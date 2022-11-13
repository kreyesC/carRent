/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.carrent;

import java.util.GregorianCalendar;

/**
 *
 * @author vilantra
 */
public class CarRent {

    public static void main(String[] args) {
        // Crear Cliente
        Cliente c001 = new Cliente("12111181-0", "John Doe");
        System.out.println(c001.getVigente() + " muestro estado inicial del cliente");

        // Crear Vehiculo
        Vehiculo v001 = new Vehiculo("bb-Ss-34", "kia", "morning", 2000);
        // Obtener condicion inicial
        System.out.println(v001.getCondition() + " muestro condicion inicial");

        //Desabilitar Vigencia Cliente
        c001.setVigente(false);
        System.out.println(c001.getVigente() + " muestro estado cliente desabilitado");

        //Asignar Vehiculo en Mantención
        v001.asignarMantencion();
        System.out.println(v001.getCondition() + " muestro condicion en mantencion");

        // Crear Arriendo
        GregorianCalendar dateArriendo = new GregorianCalendar(2022, 10, 21);
        Vehiculo v002 = new Vehiculo("RT-RS-46", "Ford", "Territory", 2020);
        Cliente c002 = new Cliente("12353181-7", "Jane Doe");
        Arriendo a001 = new Arriendo(1, dateArriendo, 6, 2000, v002, c002);
        Arriendo a002 = new Arriendo(2, dateArriendo, 4, 3000, v001, c001);

        //Generar Ticket Arriendo arriendo exitoso
        if(a001.ingresarArriendo()) {
            System.out.println(a001.toString());
        }
        //Muestra estado de vehiculo
        System.out.println(v002.getCondition() + " Vehiculo Arrendado");

        // Crear Devolucion
        GregorianCalendar dateDevolucion = new GregorianCalendar(2022, 10, 22);
        Devolucion d001 = new Devolucion(dateDevolucion, v001, a001);
        Devolucion d002 = new Devolucion(dateDevolucion, v002, a001);
        System.out.println(v002.getCondition() + " Vehiculo Devuelto");
    }
}
