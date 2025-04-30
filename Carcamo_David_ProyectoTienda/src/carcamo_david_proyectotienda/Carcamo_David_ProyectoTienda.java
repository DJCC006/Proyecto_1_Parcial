/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package carcamo_david_proyectotienda;

import java.util.Scanner;
        
/**
 *
 * @author David
 */
public class Carcamo_David_ProyectoTienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Creación de variable que lleva seguimiento del estatus de la caja
        boolean statusCaja= false; 
        
        // Creación de Menu Inicial y lectura
        System.out.print("****Menu de Facturación****");
        System.out.println("\n 1. Abrir Caja"
        +"\n 2. Venta"+"\n 3. Compra"+"\n 4. Reporte"+"\n 5. Cierre Caja"+"\n 6.Salir");
        
        
        System.out.println("**Porfavor abrir caja antes de seleccionar alguna opcion del menu (seleccione opcion 1)***");
        Scanner lea= new Scanner(System.in);
        lea.useDelimiter("\n");
        System.out.println("Porfavor ingrese una opción: ");
        
        
       //Estructura para evaluacion de estatus de caja y respuestas
       while (statusCaja!=true){        
        if(lea.hasNextInt()){
           int opcionInicial = lea.nextInt();
            if(opcionInicial<1){
           System.out.println("No se aceptan numeros negativos. Porfavor ignrese una opcion valida: ");
         }else if(opcionInicial>6){
             System.out.println("Numero fuera del limite establecido(1-6). Porfavor ingrese una opcion valida: ");
             
         }else if (opcionInicial != 1){
           System.out.println("Porfavor abra caja primero. Ingrese nuevamente una opcion: ");
           
           }else if(opcionInicial ==1) {
            System.out.println("Caja abierta");
            statusCaja = true;
          }
         }else{
            System.out.println("Valor invalido. Porfavor ingrese un numero como opcion: ");
            lea.next();
        }
        }
        
       
       //Ingreso de efectivo inicial
       boolean primeraApertura= true;
       double efectivoCaja=0;
       
       if(primeraApertura=true){
           System.out.println("Ingrese cantidad de efectivo inicial a guardar en caja: ");
           efectivoCaja= lea.nextDouble();
           System.out.println("Efectivo guardado exitosamente");
       }
       
    
       
       //Estructura para realizar procedimientos
       System.out.println("Porfavor seleccione una opcion del menu: ");
       int opcion = lea.nextInt();
       
       if (opcion == 1){
           System.out.println("Aqui se muestra la opcion de ingresar efectivo");
       }else if (opcion==2){
           System.out.println("Aqui se inicia el procedimiento de venta");
       }else if (opcion ==3){
           System.out.println("Aqui se inicia el procedimiento de compra");
       }else if (opcion == 4){
           System.out.println("Aqui se inicia el procedimiento de reporte");
       }else if (opcion ==5){
           System.out.println("Aqui se inicia el procedimiento de cierre de caja");
       }else if (opcion ==6){
           System.out.println("Aqui se inicia el procedimiento de salir ");
       }
       
        
        
        
    }
    
}
