package com.idega.documentmanager.component.properties.impl;

import com.idega.documentmanager.business.component.properties.PropertiesSelect;
import com.idega.documentmanager.component.beans.LocalizedItemsetBean;

/**
 * @author <a href="mailto:civilis@idega.com">Vytautas Čivilis</a>
 * @version 1.0
 * 
 */
public class ComponentPropertiesSelect extends ComponentProperties implements PropertiesSelect {
	
	private String external_data_src;
	private LocalizedItemsetBean itemset;
	private Integer data_src_used;
	
	public LocalizedItemsetBean getItemset() {
		return itemset;
	}
	public void setItemsetPlain(LocalizedItemsetBean itemset) {
		this.itemset = itemset;
	}
	public String getExternalDataSrc() {
		return external_data_src;
	}
	/**
	 * @param external_data_src - source to xml, containing data source<br />
	 * <b>IMPORTANT:</b> xml data structure should validate against 
	 * select-data-src.xsd (look somewhere around for it, probably in resources/templates).
	 * See also select-data-src.xml for example.
	 * 
	 */
	public void setExternalDataSrc(String external_data_src) {
		this.external_data_src = external_data_src;
		component.update(new ConstUpdateType(ConstUpdateType.external_data_src));
	}
	public void setExternalDataSrcPlain(String external_data_src) {
		this.external_data_src = external_data_src;
	}
	public Integer getDataSrcUsed() {
		return data_src_used;
	}
	public void setDataSrcUsed(Integer data_src_used) {
		
		if(data_src_used != LOCAL_DATA_SRC && data_src_used != EXTERNAL_DATA_SRC)
			throw new IllegalArgumentException("Neither LOCAL_DATA_SRC, nor EXTERNAL_DATA_SRC provided.");
		
		this.data_src_used = data_src_used;
		component.update(new ConstUpdateType(ConstUpdateType.data_src_used));
	}
	public void setDataSrcUsedPlain(Integer data_src_used) {
		
		if(data_src_used != null && data_src_used != LOCAL_DATA_SRC && data_src_used != EXTERNAL_DATA_SRC)
			throw new IllegalArgumentException("Neither LOCAL_DATA_SRC, nor EXTERNAL_DATA_SRC provided.");
		
		this.data_src_used = data_src_used;
	}
}