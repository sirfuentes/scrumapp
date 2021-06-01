package org.cfuentes.scrumapp.controller;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.cfuentes.scrumapp.entity.Proyecto;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component("globalController")
@SessionScope
public class GlobalController {

	private Object entidad;
	private Proyecto proyecto;
	private LinkedHashMap<String, Object> langs;
	private Locale lang;
	
	public void setSpanish() {
		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale ( "es" , "ES" ));
	}
	
	public void setEnglish() {
		FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.ENGLISH);
	}
	
	public void localeChanged(ValueChangeEvent e) {
	      String newLocaleValue = e.getNewValue().toString();
	      
	      for (Map.Entry<String, Object> entry : langs.entrySet()) {
	         
	         if(entry.getValue().toString().equals(newLocaleValue)) {
	            FacesContext.getCurrentInstance()
	               .getViewRoot().setLocale((Locale)entry.getValue());         
	         }
	      }
	   }
	
	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Object getEntidad() {
		return entidad;
	}

	public void setEntidad(Object entidad) {
		this.entidad = entidad;
	}

	public LinkedHashMap<String, Object> getLangs() {
		return langs;
	}

	public void setLangs(LinkedHashMap<String, Object> langs) {
		this.langs = langs;
	}

	public Locale getLang() {
		return lang;
	}

	public void setLang(Locale lang) {
		this.lang = lang;
	}
	
	
}
