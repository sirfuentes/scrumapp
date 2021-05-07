package org.cfuentes.scrumapp.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

import org.cfuentes.scrumapp.entity.EstadoTarea;
import org.cfuentes.scrumapp.entity.HistoriaUsuario;
import org.cfuentes.scrumapp.service.api.EstadoTareaService;
import org.springframework.beans.factory.annotation.Autowired;

@Named("estadoTareaConverter")
public class EstadoTareaConverter implements Converter {

	@Autowired
	EstadoTareaService estadoTareaService;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
            return null;
        }
		EstadoTarea estadoTarea = estadoTareaService.findEstadoTareaByNombre(value);
		if (estadoTarea==null) {
            return new EstadoTarea();
		}
		return estadoTarea;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (!(value instanceof EstadoTarea) || (value == null)) {
            return null;
        }
		return ((EstadoTarea)value).getNombre();
	}

}
