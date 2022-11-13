/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carrent;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author vilantra
 */
public class Arriendo {

    private int numero;
    private GregorianCalendar fechaArriendo;
    private int dias;
    private Vehiculo vehiculo;
    private Cliente cliente;
    private int valorArriendo;
    private int totalArriendo;

    public Arriendo(int numero, GregorianCalendar fechaArriendo, int dias, int valorArriendo, Vehiculo vehiculo, Cliente cliente) {
        setNumero(numero);
        setDias(dias);
        setValorArriendo(valorArriendo);
        setVehiculo(vehiculo);
        setCliente(cliente);
        setFechaArriendo(fechaArriendo);
        setTotalArriendo(totalArriendo);

        ingresarArriendo();
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the fechaArriendo
     */
    public GregorianCalendar getFechaArriendo() {
        return fechaArriendo;
    }

    /**
     * @param fechaArriendo the fechaArriendo to set
     */
    public void setFechaArriendo(GregorianCalendar fechaArriendo) {
        this.fechaArriendo = fechaArriendo;
    }

    /**
     * @return the dias
     */
    public int getDias() {
        return dias;
    }

    /**
     * @param dias the dias to set
     */
    public void setDias(int dias) {
        if (dias < 1 || dias > 10) {
            System.out.println("CANTIDAD DE DIAS NO VALIDOS");
            return;
        }
        this.dias = dias;
    }

    /**
     * @return the vehiculo
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * @param vehiculo the vehiculo to set
     */
    public void setVehiculo(Vehiculo vehiculo) {
        vehiculo.setCondition('A');
        this.vehiculo = vehiculo;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the valorArriendo
     */
    public int getValorArriendo() {
        return valorArriendo;
    }

    /**
     * @param valorArriendo the valorArriendo to set
     */
    public void setValorArriendo(int valorArriendo) {
        this.valorArriendo = valorArriendo;
    }

    private boolean validarArriendo() {
        return getVehiculo().getCondition() == 'D';
    }

    private boolean validarCliente() {
        return getCliente().getVigente() == true;
    }

    /**
     * @return the totalArriendo
     */
    private int getTotalArriendo() {
        return totalArriendo;
    }

    /**
     * @param totalArriendo the totalArriendo to set
     */
    private int setTotalArriendo(int totalArriendo) {
        this.totalArriendo = getDias() * getValorArriendo();
        return totalArriendo;
    }

    public boolean ingresarArriendo() {
        if (!validarCliente() && !validarArriendo()) {
            System.out.println("VEHICULO Ó CLIENTE INVÁLIDOS ARRIENDO NO CREADO");
            return false;
        }
        getVehiculo().setCondition('A');
        System.out.println("ARRIENDO CREADO");
        return true;
    }

    private String getDateString() {
        Calendar c = getFechaArriendo();
        String date = c.get(Calendar.DAY_OF_MONTH) + "-" + c.get(Calendar.MONTH) + "-" + c.get(Calendar.YEAR);        //c.get() retorna una parte del calendar de c indicada en el parametro        System.out.println(date);
        return date;
    }

    @Override
    public String toString() {
        return """
               -----------------------------------------------------------------------------
                            TICKET        ARRIENDO    DE      VEHICULO
               -----------------------------------------------------------------------------
                               NUMERO DE ARRIENDO:  """ + getNumero() + "\n"
                + "\t" + "\t" + "VEHICULO          : " + vehiculo.getPatente() + "\t" + vehiculo.getMarca() + "\t" + vehiculo.getModelo() + "\n"
                + "\t" + "\t" + "PRECIO DIARIO     : " + getValorArriendo() + "\n" + "\n"
                + "FECHA" + "\t" + "\t" + "CLIENTE" + "\t" + "\t" + "\t" + "DIAS" + "\t" + "\t" + "A PAGAR" + "\n"
                + "-----------------------------------------------------------------------------" + "\n"
                + getDateString() + "\t" + cliente.getCedula() + "/" + cliente.getNombre() + "\t" + getDias() + "\t" + "\t" + "$" + getTotalArriendo() + "\n"
                + "-----------------------------------------------------------------------------" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
                + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "------------------" + "\n"
                + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "   FIRMA CLIENTE" + "\n"
                + "-----------------------------------------------------------------------------";
    }
}
