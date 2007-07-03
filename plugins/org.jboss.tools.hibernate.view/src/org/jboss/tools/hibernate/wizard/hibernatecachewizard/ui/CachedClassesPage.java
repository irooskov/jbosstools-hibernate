/*******************************************************************************
 * Copyright (c) 2007 Exadel, Inc. and Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Exadel, Inc. and Red Hat, Inc. - initial API and implementation
 ******************************************************************************/ 
package org.jboss.tools.hibernate.wizard.hibernatecachewizard.ui;
import java.util.*;

public class CachedClassesPage extends CommonCachedPage {
	public void setCallback(Wizard callback) {
	/**
	private void createPageContent(Composite parent)
	protected void createPageElements(Composite parent)
	private void createInitialViewer(Composite parent)
	private void createCachedViewer(Composite parent)
	private void stuffInitialViewer()
	protected void createInitialDescriptor(Composite parent) 
	protected void createComposedDescriptor(Composite parent) 
	private void createEmptyDescriptor(Composite parent)
	protected void createPopupMenu()
	private String prepareCacheableClassName(String name)
	private void classNamesTransfer(Iterator it, int transtype)
	/**
	private void cacheableToCachedUITransfer(String name)
	private void removeFromCache(String name)
	private void removeClassFromCache(String name)
	private void cacheToCacheableTransfer(String name)
	protected void updateUI()
	protected void updateComposedViewer()
	private void cleanSet(Iterator it,boolean incom)
	protected void processAddToCacheButtonPressed()
		classNamesTransfer(sel.iterator(),ICacheable.ADD_TO_CACHE);
	protected void processAddAllToCacheButtonPressed()
	protected void processRemoveFromCachePressed()