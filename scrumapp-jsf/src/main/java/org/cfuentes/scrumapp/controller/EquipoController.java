package org.cfuentes.scrumapp.controller;

import org.cfuentes.scrumapp.entity.Equipo;
import org.cfuentes.scrumapp.service.api.EquipoService;
import org.primefaces.event.ReorderEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.util.List;

@Component("equipoController")
@SessionScope
public class EquipoController {

    @Autowired
    EquipoService equipoService;

    List<Equipo> equipos;


    public void refresh(){
        equipos.add(equipoService.findById(new Long(1)));

    }

    public void onRowReorder(ReorderEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Row Moved", "From: " + event.getFromIndex() + ", To:" + event.getToIndex());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }
}
