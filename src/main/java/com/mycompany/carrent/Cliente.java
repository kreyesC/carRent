/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carrent;

import cl.daplay.jrut.JRut;

/**
 *
 * @author vilantra
 */
public class Cliente {

    private String cedula;
    private String nombre;
    private Boolean vigente;
    private Boolean clienteCreado;

    public Cliente(String cedula, String nombre) {
        setCedula(cedula);
        setNombre(nombre);
        setVigente(vigente);
        setClienteCreado(clienteCreado);

        final JRut rutIngresado = new JRut(getCedula());
        if (!getClienteCreado()) {
            System.out.println("Cliente no creado");
        } else {
            System.out.println("Cliente creado con exito");
        }
    }

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        if (cedula.length() != 10) {
            System.out.println("LARGO DE CEDULA NO VALIDO");
            setClienteCreado(false);
            setVigente(false);
            return;
        }
        setClienteCreado(true);
        setVigente(true);
        this.cedula = cedula;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the vigente
     */
    public Boolean getVigente() {
        return vigente;
    }

    public String getClienteVigente() {
        if (getVigente()) {
            return "CLIENTE VIGENTE";
        }
        return "CLIENTE NO VIGENTE";
    }

    /**
     * @param vigente the vigente to set
     */
    public void setVigente(Boolean vigente) {
        this.vigente = vigente;
    }

    /**
     * @return the clienteCreado
     */
    public Boolean getClienteCreado() {
        return clienteCreado;
    }

    /**
     * @param clienteCreado the clienteCreado to set
     */
    public void setClienteCreado(Boolean clienteCreado) {
        this.clienteCreado = clienteCreado;
    }
}
