package com.idega.documentmanager.business.component.properties;

/**
 * @author <a href="mailto:civilis@idega.com">Vytautas Čivilis</a>
 * @version $Revision: 1.2 $
 *
 * Last modified: $Date: 2007/10/30 21:57:44 $ by $Author: civilis $
 */
public interface PropertiesPlain extends PropertiesComponent {

	public abstract String getText();
		
	public abstract void setText(String text);
}