

// File generated by OpenXava: Fri Mar 27 18:49:14 CET 2020
// Archivo generado por OpenXava: Fri Mar 27 18:49:14 CET 2020

// WARNING: NO EDIT
// OJO: NO EDITAR

package org.openxava.test.model;

import org.openxava.component.MetaComponent;
import org.openxava.model.meta.MetaModel;
import org.openxava.util.XavaException;

public class SubfamilyInfo implements java.io.Serializable, org.openxava.model.IModel {

	// Attributes/Atributos 
	private org.openxava.test.model.ISubfamily2 subfamily; 
	private org.openxava.test.model.IFamily2 family;



	// Properties/Propiedades

	// References 
	public org.openxava.test.model.ISubfamily2 getSubfamily() {
		return subfamily;
	}
	public void setSubfamily(org.openxava.test.model.ISubfamily2 newSubfamily) {
		this.subfamily = newSubfamily;
	} 
	public org.openxava.test.model.IFamily2 getFamily() {
		return family;
	}
	public void setFamily(org.openxava.test.model.IFamily2 newFamily) {
		this.family = newFamily;
	}
	
	private MetaModel metaModel;
	public MetaModel getMetaModel() throws XavaException {
		if (metaModel == null) {
			metaModel = MetaComponent.get("Product3").getMetaAggregate("SubfamilyInfo");
		}
		return metaModel;
	}
	
}