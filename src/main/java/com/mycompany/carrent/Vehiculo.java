/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.carrent;

/**
 *
 * @author vilantra
 */
public class Vehiculo {

    private String patente;
    private String marca;
    private String modelo;
    private int anho;
    private char condition;
    private Boolean vehiculoCreado;

    public Vehiculo(String patente, String marca, String modelo, int anho) {
        setPatente(patente);
        setMarca(marca);
        setModelo(modelo);
        setAnho(anho);
        setCondition('D');
        setVehiculoCreado(vehiculoCreado);

        if (!getVehiculoCreado()) {
            System.out.println("Vehiculo no creado");
        } else {
            System.out.println("Vehiculo creado con exito");
        }
    }

    /**
     * @return the patente
     */
    public String getPatente() {
        return patente;
    }

    /**
     * @param patente the patente to set
     */
    public void setPatente(String patente) {
        if (patente.length() < 8 || patente.length() > 8) {
            System.out.println("Largo patente invalido");
            setVehiculoCreado(false);
            return;
        }
        setVehiculoCreado(true);
        this.patente = patente.toUpperCase();
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca.toUpperCase();
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo.toUpperCase();
    }

    /**
     * @return the anho
     */
    public int getAnho() {
        return anho;
    }

    /**
     * @param anho the anho to set
     */
    public void setAnho(int anho) {
        if (anho < 2000) {
            System.out.println("Año debe ser mayor a 2000");
            return;
        }
        this.anho = anho;
    }

    /**
     * @return the condition
     */
    public char getCondition() {
        return condition;
    }

    public String getConditionComplet() {
        if (getCondition() == 'A') {
            return "ARRENDADO";
        } else if (getCondition() == 'D') {
            return "DISPONIBLE";
        }
        return "MANTENCION";
    }

    /**
     * @param condition the condition to set
     */
    public void setCondition(char condition) {
        if (condition != 'A' && condition != 'D' && condition != 'M') {
            System.out.println("CONDITION NO VALID");
            return;
        }
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "PATENTE: " + getPatente() + "\t"
                + "MODELO: " + getModelo() + "\t"
                + "MARCA: " + getMarca() + "\t"
                + "CONDICION: " + getCondition();
    }

    /**
     * @return the vehiculoCreado
     */
    public Boolean getVehiculoCreado() {
        return vehiculoCreado;
    }

    /**
     * @param vehiculoCreado the vehiculoCreado to set
     */
    public void setVehiculoCreado(Boolean vehiculoCreado) {
        this.vehiculoCreado = vehiculoCreado;
    }

    public void asignarMantencion() {
        if (getCondition() != 'A' && getCondition() == 'D') {
            setCondition('M');
            System.out.println("Vehiculo en mantencion");
            return;
        }
        System.out.println("Vehiculo no es posible asignar Mantencion");
    }
}
