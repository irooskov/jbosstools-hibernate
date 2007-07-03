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
package org.jboss.tools.hibernate.internal.core.hibernate.descriptors;

import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.jboss.tools.hibernate.internal.core.OrmConfiguration;
import org.jboss.tools.hibernate.internal.core.properties.EditableListPropertyDescriptor;
import org.jboss.tools.hibernate.internal.core.properties.ListPropertyDescriptor;
import org.jboss.tools.hibernate.internal.core.properties.PropertyDescriptorsHolder;


/**
 * 
 * @author akuzmin - akuzmin@exadel.com
 * Jun 2, 2005
 * 
 */
public class PropertyMappingForAnyMapingDescriptorsHolder extends PropertyDescriptorsHolder {
	private static PropertyDescriptorsHolder instance=new PropertyMappingForAnyMapingDescriptorsHolder();
	private static final String GENERAL_CATEGORY=Messages.PropertyMappingForAnyMapingDescriptorsHolder_GeneralCategory;
	private static final String ADVANCED_CATEGORY=Messages.PropertyMappingForAnyMapingDescriptorsHolder_AdvancedCategory;

	public static PropertyDescriptorsHolder getInstance(){
		return instance;
	}
	
	protected PropertyMappingForAnyMapingDescriptorsHolder(){

		PropertyDescriptor pd=new PropertyDescriptor("name",Messages.PropertyMappingForAnyMapingDescriptorsHolder_NameN); //$NON-NLS-1$
		pd.setDescription(Messages.PropertyMappingForAnyMapingDescriptorsHolder_NameD);
		pd.setCategory(GENERAL_CATEGORY);
		addPropertyDescriptor(pd);
		setDefaultPropertyValue(pd.getId(),""); //$NON-NLS-1$
		
		pd=new EditableListPropertyDescriptor("propertyAccessorName",Messages.PropertyMappingForAnyMapingDescriptorsHolder_PropertyAccessorNameN,OrmConfiguration.ACCESS_VALUES); //$NON-NLS-1$
		pd.setDescription(Messages.PropertyMappingForAnyMapingDescriptorsHolder_PropertyAccessorNameD);
		addPropertyDescriptor(pd);
		pd.setCategory(ADVANCED_CATEGORY);
		setDefaultPropertyValue(pd.getId(),OrmConfiguration.DEFAULT_ACCESS);

		pd=new ListPropertyDescriptor("updateable",Messages.PropertyMappingForAnyMapingDescriptorsHolder_UpdateableN,OrmConfiguration.BOOLEAN_VALUES); //$NON-NLS-1$
		pd.setDescription(Messages.PropertyMappingForAnyMapingDescriptorsHolder_UpdateableD);
		addPropertyDescriptor(pd);
		pd.setCategory(ADVANCED_CATEGORY);
		setDefaultPropertyValue(pd.getId(),"true"); //$NON-NLS-1$
		
		pd=new ListPropertyDescriptor("insertable",Messages.PropertyMappingForAnyMapingDescriptorsHolder_InsertableN,OrmConfiguration.BOOLEAN_VALUES); //$NON-NLS-1$
		pd.setDescription(Messages.PropertyMappingForAnyMapingDescriptorsHolder_InsertableD);
		addPropertyDescriptor(pd);
		pd.setCategory(ADVANCED_CATEGORY);
		setDefaultPropertyValue(pd.getId(),"true"); //$NON-NLS-1$

		pd=new EditableListPropertyDescriptor("cascade",Messages.PropertyMappingForAnyMapingDescriptorsHolder_CascadeN,OrmConfiguration.CASCADE_VALUES); //$NON-NLS-1$
		pd.setDescription(Messages.PropertyMappingForAnyMapingDescriptorsHolder_CascadeD);
		pd.setCategory(ADVANCED_CATEGORY);
		addPropertyDescriptor(pd);
		setDefaultPropertyValue(pd.getId(),OrmConfiguration.DEFAULT_CASCADE);				
		
	}

}