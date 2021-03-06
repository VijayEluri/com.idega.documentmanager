package com.idega.documentmanager.business.component.properties;

import com.idega.documentmanager.component.beans.LocalizedItemsetBean;

/**
 * @author <a href="mailto:civilis@idega.com">Vytautas Čivilis</a>
 * @version $Revision: 1.2 $
 *
 * Last modified: $Date: 2007/10/30 21:57:44 $ by $Author: civilis $
 */
public interface PropertiesSelect extends PropertiesComponent {
	
	public static final int LOCAL_DATA_SRC = 1;
	public static final int EXTERNAL_DATA_SRC = 2;
	
	public abstract LocalizedItemsetBean getItemset();

	public abstract String getExternalDataSrc();

	public abstract void setExternalDataSrc(String external_data_src);

	public abstract Integer getDataSrcUsed();

	public abstract void setDataSrcUsed(Integer data_src_used);
}