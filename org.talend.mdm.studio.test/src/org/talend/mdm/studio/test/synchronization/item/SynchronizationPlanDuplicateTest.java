// ============================================================================
//
// Copyright (C) 2006-2010 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.studio.test.synchronization.item;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.mdm.studio.test.TalendSWTBotForMDM;

/**
 * DOC rhou class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class SynchronizationPlanDuplicateTest extends TalendSWTBotForMDM {

    private SWTBotTreeItem spParentItem;

    private SWTBotTreeItem spItem;

    @Before
    public void runBeforeEveryTest() {
        spParentItem = serverItem.getNode("Synchronization Plan [HEAD]");
        spParentItem.expand();

        spParentItem.contextMenu("New").click();
        SWTBotShell newSynchronizationPlanShell = bot.shell("New Synchronization Plan");
        newSynchronizationPlanShell.activate();
        SWTBotText text = bot.textWithLabel("Enter a Name for the New Instance");
        text.setText("TestSynchronizationPlan");
        bot.button("OK").click();
        bot.activeEditor().save();
        sleep();
        spItem = spParentItem.getNode("TestSynchronizationPlan");
        Assert.assertNotNull(spItem);
        sleep(2);
    }

    @Test
    public void synchronizationPlanDuplicateTest() {
        SWTBotMenu duplicateMenu = spItem.contextMenu("Duplicate");
        duplicateMenu.click();
        SWTBotShell shell = bot.shell("Pasting instance TestSynchronizationPlan");
        shell.activate();
        bot.text("CopyOfTestSynchronizationPlan").setText("DuplicateSynchronizationPlan");
        sleep();
        bot.button("OK").click();
        SWTBotTreeItem duplicateNode = spParentItem.getNode("DuplicateSynchronizationPlan");
        Assert.assertNotNull(duplicateNode);
        sleep(2);

    }

    @After
    public void runAfterEveryTest() {
        spParentItem.getNode("TestSynchronizationPlan").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();

        spParentItem.getNode("DuplicateSynchronizationPlan").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();
    }

}