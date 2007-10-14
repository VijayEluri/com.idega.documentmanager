package com.idega.documentmanager.business;

import java.util.List;

import org.chiba.xml.xslt.TransformerService;
import org.w3c.dom.Document;

import com.idega.documentmanager.business.component.ConstComponentCategory;
import com.idega.documentmanager.component.beans.LocalizedStringBean;
import com.idega.documentmanager.manager.impl.CacheManager;
import com.idega.documentmanager.util.InitializationException;

/**
 * 
 * @author <a href="mailto:civilis@idega.com">Vytautas Čivilis</a>
 * @version 1.0
 *
 */
public interface DocumentManager {

	/**
	 * creates primary user form document and stores it depending
	 * 
	 * @param form_id - cannot be null
	 * @param name - form name. Can be null, then default is used.
	 *  
	 * @throws NullPointerException - form_id was not provided
	 * @throws Exception - some kind of other error occured
	 * 
	 * @return Created form document
	 */
	public abstract com.idega.documentmanager.business.Document createForm(String form_id, LocalizedStringBean name)
			throws NullPointerException, Exception;

	/**
	 * 
	 * @return List of available form components types by category
	 */
	public List<String> getAvailableFormComponentsTypesList(ConstComponentCategory category);

	/**
	 * Open and load document by form id
	 * 
	 * @param form_id
	 * @throws NullPointerException - form_id is not provided
	 * @throws Exception
	 * 
	 * @return loaded document
	 */
	public abstract com.idega.documentmanager.business.Document openForm(String form_id) throws NullPointerException, FormLockException, Exception;
	
	public abstract com.idega.documentmanager.business.Document openForm(Document xforms_doc) throws NullPointerException, Exception;
	
	public abstract com.idega.documentmanager.business.Document openForm(Document xforms_doc, String formId) throws NullPointerException, Exception;
	
	public abstract void setPersistenceManager(PersistenceManager persistence_manager);
	
	public abstract void init() throws InitializationException;
	
	public abstract boolean isInited();
	
	public abstract void setCacheManager(CacheManager cacheManager);
	
	public abstract void setTransformerService(TransformerService transformerService);
	
	public abstract void setComponentsXforms(Document componentsXforms);
	
	public abstract void setComponentsXsd(Document componentsXsd);
	
	public abstract void setFormXformsTemplate(Document formXformsTemplate);
}