/*******************************************************************************
 * Copyright (c) 2007-2008 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributor:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.hibernate.jpt.ui.internal.platform;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jpt.core.JpaProject;
import org.eclipse.jpt.db.Table;
import org.eclipse.jpt.gen.internal.EntityGenerator;
import org.eclipse.jpt.gen.internal.PackageGenerator;
import org.eclipse.jpt.ui.internal.platform.generic.GenericPlatformUi;
import org.hibernate.eclipse.launch.HibernateLaunchConstants;
import org.jboss.tools.hibernate.jpt.ui.wizard.GenerateDdlWizard;
import org.jboss.tools.hibernate.jpt.ui.wizard.GenerateEntitiesWizard;

/**
 * @author Dmitry Geraskov
 * 
 */
public class HibernatePlatformUI extends GenericPlatformUi {

	public static final String LaunchConfigurationType_ID = "org.hibernate.eclipse.launch.CodeGenerationLaunchConfigurationType";

	public static String exporter_id = "hbmexporter";
	public static String full_exporter_id = HibernateLaunchConstants.ATTR_EXPORTERS + '.' + "hbmexporter";

	@Override
	public void generateEntities(JpaProject project, IStructuredSelection selection) {
		GenerateEntitiesWizard wizard = new GenerateEntitiesWizard(project, selection);
		
		WizardDialog dialog = new WizardDialog(null, wizard);
		dialog.open();
	}

	@Override
	public void generateDDL(JpaProject project, IStructuredSelection selection) {
		GenerateDdlWizard wizard = new GenerateDdlWizard(project, selection);
		
		WizardDialog dialog = new WizardDialog(null, wizard);
		dialog.open();
	}

	public static ILaunchConfigurationWorkingCopy createDefaultLaunchConfig(String projectName) {
		ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
		ILaunchConfigurationType launchConfigurationType = launchManager
				.getLaunchConfigurationType(LaunchConfigurationType_ID); //$NON-NLS-1$

		ILaunchConfigurationWorkingCopy wc = null;
		try {
			wc = launchConfigurationType.newInstance(null, projectName + "-hibernate-generate");
			wc.setAttribute(HibernateLaunchConstants.ATTR_REVERSE_ENGINEER, true);
			// Create exporters
			List<String> exporters = new ArrayList<String>();
			exporters.add(exporter_id); //$NON-NLS-1$
			wc.setAttribute(HibernateLaunchConstants.ATTR_EXPORTERS, exporters);
			wc.setAttribute(full_exporter_id, true);
		} catch (CoreException e) {
			e.printStackTrace();
		}

		return wc;
	}
}