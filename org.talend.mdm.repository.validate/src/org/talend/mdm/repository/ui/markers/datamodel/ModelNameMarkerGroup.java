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
package org.talend.mdm.repository.ui.markers.datamodel;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.ui.views.markers.MarkerField;
import org.eclipse.ui.views.markers.MarkerItem;
import org.eclipse.ui.views.markers.internal.FieldCategory;
import org.eclipse.ui.views.markers.internal.MarkerGroup;
import org.eclipse.ui.views.markers.internal.MarkerGroupingEntry;
import org.eclipse.ui.views.markers.internal.MarkerMessages;
import org.talend.mdm.repository.core.validate.datamodel.model.IDataModelMarkerConst;

/**
 * created by HHB on 2013-1-25 Detailled comment
 * 
 */
public class ModelNameMarkerGroup extends MarkerGroup {

    protected static final String BLANK = ""; //$NON-NLS-1$

    /**
     * 
     */
    public static final String ID = "org.talend.mdm.error.datamodel.groupby.model"; //$NON-NLS-1$

    private Map entries = new HashMap();

    class ModelNameMarkerField extends MarkerField {

        ModelNameMarkerField() {
            super();
        }

        @Override
        public String getValue(MarkerItem item) {

            if (item.getMarker() != null) {
                IMarker marker = item.getMarker();
                if (marker == null || !marker.exists()) {
                    return MarkerMessages.FieldCategory_Uncategorized;
                }
                String groupName = getModelName(marker);
                if (groupName == null) {

                    return BLANK;
                }
                return groupName;
            }

            return "";
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.ui.views.markers.internal.MarkerGroup.GroupMarkerField#compare(org.eclipse.ui.views.markers.
         * MarkerItem, org.eclipse.ui.views.markers.MarkerItem)
         */
        @Override
        public int compare(MarkerItem item1, MarkerItem item2) {
            return getValue(item1).compareTo(getValue(item2));
        }

        @Override
        public String getName() {
            return ModelNameMarkerGroup.this.getTitle();
        }
    }

    private String name;

    public ModelNameMarkerGroup() {
        super(null);
        this.name = "Model Name"; //$NON-NLS-1$
    }

    /**
     * Create the fields for the marker views.
     */
    @Override
    protected void createFields() {
        field = new FieldCategory();
        markerField = new ModelNameMarkerField();
    }

    @Override
    public MarkerGroupingEntry findGroupValue(String typeId, IMarker marker) {
        String groupName = getModelName(marker);
        ModelNameMarkerGroupingEntry entry = (ModelNameMarkerGroupingEntry) entries.get(groupName);
        if (entry == null) {
            entry = new ModelNameMarkerGroupingEntry(groupName);
            entry.setGroup(this);
            entries.put(groupName, entry);
        }
        return entry;
    }

    private String getModelName(IMarker marker) {

        if (marker == null) {
            return BLANK;
        }
        String msg = marker.getAttribute(IDataModelMarkerConst.DATA_MODEL, BLANK);
        return msg;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.views.markers.internal.MarkerGroup#getId()
     */
    @Override
    public String getId() {
        return ID;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.views.markers.internal.MarkerGroup#getTitle()
     */
    @Override
    public String getTitle() {
        return name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.views.markers.internal.MarkerGroup#getEntriesComparator()
     */
    @Override
    public Comparator getEntriesComparator() {
        return new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                return ((MarkerGroupingEntry) o1).getLabel().compareTo(((MarkerGroupingEntry) o2).getLabel());
            }
        };
    }

    private class ModelNameMarkerGroupingEntry extends MarkerGroupingEntry {

        public ModelNameMarkerGroupingEntry(String label) {
            super(label);
        }
    }
}