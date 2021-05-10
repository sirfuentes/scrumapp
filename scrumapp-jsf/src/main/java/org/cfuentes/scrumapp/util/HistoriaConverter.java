package org.cfuentes.scrumapp.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

import org.cfuentes.scrumapp.entity.HistoriaUsuario;
import org.cfuentes.scrumapp.entity.Miembro;
import org.cfuentes.scrumapp.service.api.HistoriaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

@Named("historiaConverter")
public class HistoriaConverter implements Converter{

	@Autowired
	HistoriaUsuarioService historiaUsuarioService;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
            return null;
        }
		HistoriaUsuario historia = historiaUsuarioService.findHistoriaUsuarioByCodigo(value);
		if (historia==null) {
            return new HistoriaUsuario();
		}
		return historia;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (!(value instanceof HistoriaUsuario) || (value == null)) {
            return null;
        }
		return ((HistoriaUsuario)value).getCodigo();
	}

}
