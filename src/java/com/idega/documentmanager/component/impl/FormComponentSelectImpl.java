package com.idega.documentmanager.component.impl;

import com.idega.documentmanager.business.component.ComponentSelect;
import com.idega.documentmanager.business.component.properties.PropertiesSelect;
import com.idega.documentmanager.component.properties.impl.ComponentPropertiesSelect;
import com.idega.documentmanager.component.properties.impl.ConstUpdateType;
import com.idega.documentmanager.manager.XFormsManagerSelect;

/**
 * @author <a href="mailto:civilis@idega.com">Vytautas Čivilis</a>
 * @version $Revision: 1.1 $
 *
 * Last modified: $Date: 2007/10/05 11:42:31 $ by $Author: civilis $
 */
public class FormComponentSelectImpl extends FormComponentImpl implements ComponentSelect {
	
	@Override
	public XFormsManagerSelect getXFormsManager() {
		
		return getContext().getXformsManagerFactory().getXformsManagerSelect();
	}
	
	@Override
	public PropertiesSelect getProperties() {
		
		if(properties == null) {
			ComponentPropertiesSelect properties = new ComponentPropertiesSelect();
			properties.setComponent(this);
			this.properties = properties;
		}
		
		return (PropertiesSelect)properties;
	}
	
	@Override
	protected void setProperties() {
		
		super.setProperties();
		
		ComponentPropertiesSelect properties = (ComponentPropertiesSelect)getProperties();
		XFormsManagerSelect xforms_manager = getXFormsManager();
		
		properties.setDataSrcUsedPlain(xforms_manager.getDataSrcUsed(getContext()));
		properties.setExternalDataSrcPlain(xforms_manager.getExternalDataSrc(getContext()));
		properties.setItemsetPlain(xforms_manager.getItemset(getContext()));
	}
	
	@Override
	public void update(ConstUpdateType what) {
		super.update(what);
		
		int update = what.getUpdateType();
		
		switch (update) {
		case ConstUpdateType.data_src_used:
			getHtmlManager().clearHtmlComponents();
			getFormDocument().setFormDocumentModified(true);
			break;
			
		case ConstUpdateType.itemset:
			getHtmlManager().clearHtmlComponents();
			getFormDocument().setFormDocumentModified(true);
			break;
			
		case ConstUpdateType.external_data_src:
			getHtmlManager().clearHtmlComponents();
			getFormDocument().setFormDocumentModified(true);
			break;

		default:
			break;
		}
	}
	
	public void remove() {
		
		getXFormsManager().removeSelectComponentSourcesFromXFormsDocument(getContext());
		super.remove();
	}
}