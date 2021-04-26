package org.cfuentes.scrumapp.util;

import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

import org.cfuentes.scrumapp.entity.ProductOwner;
import org.cfuentes.scrumapp.service.api.ProductOwnerService;
import org.springframework.beans.factory.annotation.Autowired;

@Named("POConverter")
public class FacesConverter implements Converter{

	@Autowired
	ProductOwnerService productOwnerService;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
            return null;
        }
		ProductOwner PO = productOwnerService.findProductOwnerByEmail(value);
		if (PO==null) {
            return new ProductOwner();
		}
		return PO;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (!(value instanceof ProductOwner) || (value == null)) {
            return null;
        }
		return ((ProductOwner)value).getEmail();
	}
}
