// ============================================================================
//
// Copyright (C) 2006-2013 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.editors.xsdeditor;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.xsd.XSDAnnotation;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDIdentityConstraintDefinition;
import org.eclipse.xsd.XSDModelGroup;
import org.eclipse.xsd.XSDModelGroupDefinition;
import org.eclipse.xsd.XSDParticle;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.XSDTypeDefinition;

import com.amalto.workbench.editors.DataModelMainPage;
import com.amalto.workbench.providers.datamodel.SchemaTreeContentProvider;

/**
 * created by liusonbo on 2013-6-8
 */
public class TreeExpandHelper {

    private List<XSDNode> expandedElements;

    private List<XSDNode> expandedTypes;

    public TreeExpandHelper() {
        expandedElements = new ArrayList<TreeExpandHelper.XSDNode>();
        expandedTypes = new ArrayList<TreeExpandHelper.XSDNode>();
    }

    public void recordExpandState(DataModelMainPage mainPage) {
        if (mainPage == null)
            return;

        cleanCache();

        TreeViewer elementsViewer = mainPage.getElementsViewer();
        TreeViewer typesViewer = mainPage.getTypesViewer();

        expandedElements = getExpandedNodes(elementsViewer.getExpandedTreePaths());
        expandedTypes = getExpandedNodes(typesViewer.getExpandedTreePaths());
    }

    public void recoverExpandState(DataModelMainPage mainPage) {
        if (mainPage == null)
            return;

        Object[] expandedEntityElements = getExpandedEntityElements(mainPage);
        mainPage.getElementsViewer().setExpandedElements(expandedEntityElements);

        Object[] expandedTypeElements = getExpandedTypeElements(mainPage);
        mainPage.getTypesViewer().setExpandedElements(expandedTypeElements);

        cleanCache();
    }

    private List<XSDNode> getExpandedNodes(TreePath[] expandedElementPaths) {
        TreePath[] expandedPaths = removeInvalidTreePaths(expandedElementPaths);

        List<XSDNode> expanded = new ArrayList<XSDNode>();
        XSDNode rootNode = null;
        for (TreePath path : expandedPaths) {
            int segmentCount = path.getSegmentCount();

            rootNode = XSDNode.newNode(path.getFirstSegment());
            if (expanded.contains(rootNode)) {
                rootNode = expanded.get(expanded.indexOf(rootNode));
            } else {
                expanded.add(rootNode);
            }

            for (int i = 1; i < segmentCount; i++) {
                Object segment = path.getSegment(i);
                XSDNode newNode = XSDNode.newNode(segment);
                if (rootNode.childs == null)
                    rootNode.addChild(newNode);
                else {
                    if (rootNode.childs.contains(newNode)) {
                        newNode = rootNode.childs.get(rootNode.childs.indexOf(newNode));
                    } else {
                        rootNode.addChild(newNode);
                    }
                }

                rootNode = newNode;
            }
        }

        return expanded;
    }

    /**
     * <b>Re-order the inputed TreePath array and filter out the invlaid TreePaths.</b><br>
     * <br>
     * the ordered TreePath sequence is under such validation state:<br>
     * * the first TreePath's segement count of the TreePath sequence must be one, otherwise the whole sequence is
     * invlaid.<br>
     * * the neighbouring TreePah's segment count must be same(it means same layer of the tree), or the prior one's
     * segment count add 1 will equal to the next TreePath's segment count, otherwise the sequence from the next
     * TreePath is invalid.
     */
    private TreePath[] removeInvalidTreePaths(TreePath[] expandedElementPaths) {
        List<TreePath> paths = new ArrayList<TreePath>();
        Map<Object, List<TreePath>> map = new HashMap<Object, List<TreePath>>();
        for (TreePath path : expandedElementPaths) {
            List<TreePath> pathList = null;
            if (!map.keySet().contains(path.getSegment(0))) {
                pathList = new ArrayList<TreePath>();
                pathList.add(path);
                map.put(path.getSegment(0), pathList);
            } else {
                pathList = map.get(path.getSegment(0));
                int index = -1;
                for (int i = 0; i < pathList.size(); i++) {
                    if (pathList.get(i).getSegmentCount() < path.getSegmentCount())
                        continue;

                    index = i;
                    break;
                }

                if (index == -1)
                    pathList.add(path);
                else
                    pathList.add(index, path);
            }
        }

        for (List<TreePath> pathList : map.values()) {
            // ensure the first is the root node's tree path
            if (pathList.get(0).getSegmentCount() == 1) {
                for (int i = 0; i < pathList.size() - 1; i++) {

                    TreePath pathI = pathList.get(i);
                    TreePath pathJ = pathList.get(i + 1);
                    if (pathI.getSegmentCount() == pathJ.getSegmentCount())
                        continue;
                    else if (pathI.getSegmentCount() + 1 == pathJ.getSegmentCount()
                            && pathI.getLastSegment().equals(pathJ.getSegment(pathI.getSegmentCount() - 1))) {
                        continue;
                    }
                    else {
                        pathList = pathList.subList(0, i + 1);
                        break;
                    }
                }

                paths.addAll(pathList);
            }
        }

        return paths.toArray(new TreePath[0]);
    }

    // ///
    private Object[] getExpandedEntityElements(DataModelMainPage mainPage) {
        TreeViewer elementsViewer = mainPage.getElementsViewer();
        SchemaTreeContentProvider contentProvider = (SchemaTreeContentProvider) elementsViewer.getContentProvider();
        Object[] xsdDeclarations = getChildren(contentProvider.getXsdSchema(), contentProvider);


        List<Object> result = new ArrayList<Object>();//
        Deque<XSDNode> nodeStack = new LinkedList<XSDNode>();//
        Deque<Object> elementStack = new LinkedList<Object>();//

        // record entities
        Map<XSDNode, XSDElementDeclaration> expandedRoots = new HashMap<XSDNode, XSDElementDeclaration>();
        for (Object obj : xsdDeclarations) {
            XSDElementDeclaration decl = (XSDElementDeclaration) obj;
            String name = decl.getName();
            for (XSDNode node : expandedElements) {
                if (name.equals(((XSDElementDeclaration) node.data).getName())) {
                    expandedRoots.put(node, decl);

                    result.add(decl);
                    nodeStack.add(node);// /
                    elementStack.add(decl);// /
                    break;
                }
            }
        }

        while (!nodeStack.isEmpty() && !elementStack.isEmpty()) {
            XSDNode node = nodeStack.pollFirst();
            Object element = elementStack.pollFirst();

            List<XSDNode> nodes = node.childs;
            Object[] elementChildren = getChildren(element, contentProvider);

            if (nodes != null && nodes.size() > 0 && elementChildren != null) {
                Map<XSDNode, Object> nodeElementPairs = getNodeElementPairs(elementChildren, nodes);
                for (XSDNode node2 : nodeElementPairs.keySet()) {
                    nodeStack.add(node2);
                    elementStack.add(nodeElementPairs.get(node2));
                    result.add(nodeElementPairs.get(node2));
                }
            }
        }

        return result.toArray();
    }

    private Object[] getExpandedTypeElements(DataModelMainPage mainPage) {
        TreeViewer typesViewer = mainPage.getTypesViewer();
        SchemaTreeContentProvider contentProvider = (SchemaTreeContentProvider) typesViewer.getContentProvider();
        Object[] xsdDeclarations = getChildren(contentProvider.getXsdSchema(), contentProvider);

        List<Object> result = new ArrayList<Object>();//
        Deque<XSDNode> nodeStack = new LinkedList<XSDNode>();//
        Deque<Object> elementStack = new LinkedList<Object>();//

        // record entities
        Map<XSDNode, XSDTypeDefinition> expandedRoots = new HashMap<XSDNode, XSDTypeDefinition>();
        for (Object obj : xsdDeclarations) {
            XSDTypeDefinition type = (XSDTypeDefinition) obj;
            String name = type.getName();
            for (XSDNode node : expandedTypes) {
                if (name.equals(((XSDTypeDefinition) node.data).getName())) {
                    expandedRoots.put(node, type);

                    result.add(type);
                    nodeStack.add(node);// /
                    elementStack.add(type);// /
                    break;
                }
            }
        }

        while (!nodeStack.isEmpty() && !elementStack.isEmpty()) {
            XSDNode node = nodeStack.pollFirst();
            Object element = elementStack.pollFirst();

            List<XSDNode> nodes = node.childs;
            Object[] elementChildren = getChildren(element, contentProvider);

            if (nodes != null && nodes.size() > 0 && elementChildren != null) {
                Map<XSDNode, Object> nodeElementPairs = getNodeElementPairs(elementChildren, nodes);
                for (XSDNode node2 : nodeElementPairs.keySet()) {
                    nodeStack.add(node2);
                    elementStack.add(nodeElementPairs.get(node2));
                    result.add(nodeElementPairs.get(node2));
                }
            }
        }

        return result.toArray();
    }

    private Object[] getChildren(Object parent, SchemaTreeContentProvider contentProvider) {
        Object[] children = contentProvider.getChildren(parent);
        return children;
    }

    private Map<XSDNode, Object> getNodeElementPairs(Object[] elementChildrens, List<XSDNode> nodes) {
        Map<XSDNode, Object> pairs = new HashMap<XSDNode, Object>();

        for (Object child : elementChildrens) {
            for (XSDNode node : nodes)
                if (isSameXSDElement(child, node.data)) {
                    pairs.put(node, child);
                }
        }

        return pairs;
    }

    private boolean isSameXSDElement(Object objA, Object objB) {
        if (objA != null && objB != null) {
            if (objA.getClass().getName().equals(objB.getClass().getName())) {// same type
                if (objA instanceof XSDElementDeclaration) {
                    XSDElementDeclaration declA = (XSDElementDeclaration) objA;
                    XSDElementDeclaration declB = (XSDElementDeclaration) objB;
                    if (declA.getName().equals(declB.getName()))
                        return true;
                } else if (objA instanceof XSDModelGroup) {
                    XSDModelGroup goupA = (XSDModelGroup) objA;
                    XSDModelGroup goupB = (XSDModelGroup) objB;

                    String nameA = getModelGroupName(goupA);
                    String nameB = getModelGroupName(goupB);
                    if (nameA == null && nameB == null)
                        return true;

                    if (nameA != null && nameB != null && nameA.equals(nameB))
                        return true;
                } else if (objA instanceof XSDModelGroupDefinition) {
                    XSDModelGroupDefinition goupA = (XSDModelGroupDefinition) objA;
                    XSDModelGroupDefinition goupB = (XSDModelGroupDefinition) objB;
                    if (goupA.getName() == null && goupB.getName() == null)
                        return true;
                    if (goupA.getName().equals(goupB.getName()))
                        return true;
                } else if (objA instanceof XSDParticle) {
                    XSDParticle particleA = (XSDParticle) objA;
                    XSDParticle particleB = (XSDParticle) objB;
                    if (particleA.getTerm() instanceof XSDElementDeclaration
                            && particleB.getTerm() instanceof XSDElementDeclaration) {
                        XSDElementDeclaration declA = (XSDElementDeclaration) particleA.getTerm();
                        XSDElementDeclaration declB = (XSDElementDeclaration) particleB.getTerm();
                        if (declA.getName().equals(declB.getName()))
                            return true;
                    }
                } else if (objA instanceof XSDAnnotation) {
                    return true;
                } else if (objA instanceof XSDIdentityConstraintDefinition) {
                    XSDIdentityConstraintDefinition constraintA = (XSDIdentityConstraintDefinition) objA;
                    XSDIdentityConstraintDefinition constraintB = (XSDIdentityConstraintDefinition) objA;
                    if (constraintA.getName().equals(constraintB.getName()))
                        return true;
                } else if (objA instanceof XSDSimpleTypeDefinition) {
                    XSDSimpleTypeDefinition simpleDefineA = (XSDSimpleTypeDefinition) objA;
                    XSDSimpleTypeDefinition simpleDefineB = (XSDSimpleTypeDefinition) objB;

                    if (simpleDefineA.getName().equals(simpleDefineB.getName()))
                        return true;
                }
            }
        }

        return false;
    }

    private String getModelGroupName(XSDModelGroup goupA) {
        XSDParticle particle = (XSDParticle) goupA.getContainer();
        XSDComplexTypeDefinition complexTypeDefinition = (XSDComplexTypeDefinition) particle.getContainer();
        String name = complexTypeDefinition.getName();

        return name;
    }

    public void cleanCache() {
        expandedElements.clear();
        expandedTypes.clear();
    }

    // /////////////////

    static class XSDNode {

        public Object data;

        public List<XSDNode> childs;

        public static XSDNode newNode(Object data) {
            return new XSDNode(data);
        }

        public XSDNode(Object data) {
            this.data = data;
        }

        public void addChild(XSDNode obj) {
            if (childs == null) {
                childs = new ArrayList<XSDNode>();
            }

            childs.add(obj);
        }

        public boolean hasChildren() {
            if (childs == null || childs.size() == 0)
                return false;

            return true;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null)
                return false;

            if (obj instanceof XSDNode) {
                XSDNode node = (XSDNode) obj;
                return node.data == data;
            }

            return false;
        }

        @Override
        public int hashCode() {
            if (data != null)
                return data.hashCode();

            return super.hashCode();
        }
    }
}
