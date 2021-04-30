package org.cfuentes.scrumapp.util;

import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

import org.cfuentes.scrumapp.entity.Miembro;
import org.cfuentes.scrumapp.service.api.MiembroService;
import org.springframework.beans.factory.annotation.Autowired;

@Named("miembroConverter")
public class MiembroConverter implements Converter{

	@Autowired
	MiembroService miembroService;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
            return null;
        }
		Miembro PO = miembroService.findMiembroByEmail(value);
		if (PO==null) {
            return new Miembro();
		}
		return PO;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (!(value instanceof Miembro) || (value == null)) {
            return null;
        }
		return ((Miembro)value).getEmail();
	}
}
