package com.idega.documentmanager.manager.impl;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.idega.documentmanager.business.component.properties.PropertiesThankYouPage;
import com.idega.documentmanager.component.FormComponent;
import com.idega.documentmanager.component.beans.LocalizedStringBean;
import com.idega.documentmanager.component.beans.XFormsComponentDataBean;
import com.idega.documentmanager.component.properties.impl.ConstUpdateType;
import com.idega.documentmanager.context.DMContext;
import com.idega.documentmanager.manager.XFormsManagerThankYouPage;
import com.idega.documentmanager.util.FormManagerUtil;

/**
 * @author <a href="mailto:civilis@idega.com">Vytautas Čivilis</a>
 * @version $Revision: 1.1 $
 *
 * Last modified: $Date: 2007/10/05 11:42:29 $ by $Author: civilis $
 */
public class XFormsManagerThankYouPageImpl extends XFormsManagerPageImpl implements XFormsManagerThankYouPage {

	@Override
	public void update(DMContext context, ConstUpdateType what) {
		
		FormComponent component = context.getComponent();
		
		super.update(component.getContext(), what);
		
		int update = what.getUpdateType();
		
		switch (update) {
		case ConstUpdateType.thankyou_text:
			updateThankYouText(component.getContext());
			break;

		default:
			break;
		}
	}

	protected void updateThankYouText(DMContext context) {
		
		FormComponent component = context.getComponent();
		XFormsComponentDataBean xformsComponentDataBean = component.getXformsComponentDataBean();
		
		PropertiesThankYouPage props = (PropertiesThankYouPage)component.getProperties();
		LocalizedStringBean loc_str = props.getText();
		
		NodeList outputs = xformsComponentDataBean.getElement().getElementsByTagName(FormManagerUtil.output_tag);
		
		if(outputs == null || outputs.getLength() == 0)
			return;
		
		Element output = (Element)outputs.item(0);
		
		FormManagerUtil.putLocalizedText(null, null, 
				output,
				component.getFormDocument().getXformsDocument(),
				loc_str
		);
	}
	
	public LocalizedStringBean getThankYouText(DMContext context) {
		
		FormComponent component = context.getComponent();
		XFormsComponentDataBean xformsComponentDataBean = component.getXformsComponentDataBean();
		
		NodeList outputs = xformsComponentDataBean.getElement().getElementsByTagName(FormManagerUtil.output_tag);
		
		if(outputs == null || outputs.getLength() == 0)
			return new LocalizedStringBean();
		
		Element output = (Element)outputs.item(0);
		
		return FormManagerUtil.getElementLocalizedStrings(output, component.getFormDocument().getXformsDocument());
	}
}