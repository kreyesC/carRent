package com.mycompany.carrent;

import java.util.GregorianCalendar;

/**
 *
 * @author vilantra
 */
public class Devolucion {

    private GregorianCalendar fechaDevolucion;
    private Vehiculo vehiculo;
    private Arriendo arriendo;

    public Devolucion(GregorianCalendar fechaDevolucion, Vehiculo vehiculo, Arriendo arriendo) {
        setFechaDevolucion(fechaDevolucion);
        setVehiculo(vehiculo);
        setArriendo(arriendo);

        if (validarFechaDevolucion() && validarArriendo()) {
            System.out.println("La devolucion fue exitosa");
        } else {
            System.out.println("La devolucion no se realizo");
        }
    }

    private boolean validarFechaDevolucion() {
        return getArriendo().getFechaArriendo().compareTo(fechaDevolucion) < 0;
    }

    private boolean validarArriendo() {
        if (vehiculo.getPatente().equals(arriendo.getVehiculo().getPatente())) {
            vehiculo.setCondition('D');
            return true;
        }
        return false;

    }

    /**
     * @return the fechaDevolucion
     */
    public GregorianCalendar getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     * @param fechaDevolucion the fechaDevolucion to set
     */
    public void setFechaDevolucion(GregorianCalendar fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
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
        this.vehiculo = vehiculo;
    }

    /**
     * @return the arriendo
     */
    public Arriendo getArriendo() {
        return arriendo;
    }

    /**
     * @param arriendo the arriendo to set
     */
    public void setArriendo(Arriendo arriendo) {
        this.arriendo = arriendo;
    }
}
