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
       
       //Aviso inicial de stock en 0
        System.out.println("*AVISO* NO HAY PRODUCTOS EN STOCK ");
    
        
        //Contadores de Stock
        double stockAzucar=0;
        double stockAvena=0;
        double stockTrigo=0;
        double stockMaiz=0;
       
       //Estructura para realizar procedimientos
       System.out.println("Porfavor seleccione una opcion del menu: ");
       int opcion = lea.nextInt();
       double totalproducto=0;
       
       if (opcion == 1){
           System.out.println("Aqui se muestra la opcion de ingresar efectivo");
       }else if (opcion==2){
           System.out.println("Aqui se inicia el procedimiento de venta");
       }else if (opcion ==3){
           //Seleccion de Proveedor
           System.out.println("Porfavor seleccione el proveedor al que desea comprar(A,B,C): ");
           System.out.println("1.Proveedor A"+"\n2.Proveedor B"+"\n3.Proveedor C");
           String seleccionProveedor= lea.next();
           String proveedor= seleccionProveedor.toLowerCase();
           if(proveedor.equals("a")){
               System.out.println("***Productos Disponibles***");
               System.out.println("| Codigo |"+" | Producto | "+" | Precio | ");
               System.out.println("|   1    |"+" |  Azucar  | "+" | Lps.25 | ");
               System.out.println("|   4    |"+" |   Maiz   | "+" | Lps.18 | ");
               System.out.println("");
               System.out.println("Porfavor ingrese el codigo del producto que desea comprar: ");
               int producto= lea.nextInt();
               System.out.println("Ingrese la cantidad (kilogramos) que desea comprar de este producto: ");
               double cantidad= lea.nextDouble(); //Se necesitaria verificar si se pueden dar casos de cantidades no exactas, tipo, medio kilo, un cuarto de kilo and so weiter
               if (producto==1){
                   totalproducto= cantidad*25;
                   if(efectivoCaja>=totalproducto){
                       System.out.println("***Detalles de Compra***");
                       System.out.println("Codigo Producto: 1"+"\nProducto: Azucar"+"\nCantidad: "+cantidad+" kilogramos"+"\nTotal: "+totalproducto);
                       stockAzucar=cantidad;
                       efectivoCaja=efectivoCaja-totalproducto;
                       System.out.println("Cantidad de Efectivo en Caja: "+efectivoCaja);
                   }else{
                       System.out.println("No se puede pagar Compra");
                   }
               }else if(producto==4){
                    totalproducto= cantidad*18;
                    if(efectivoCaja>=totalproducto){
                      System.out.println("***Detalles de Compra***");
                      System.out.println("Codigo Producto: 4"+"\nProducto: Maiz"+"\nCantidad"+cantidad+" kilogramos"+"\nTotal: "+totalproducto);
                      stockMaiz=cantidad;
                      efectivoCaja=efectivoCaja-totalproducto;
                      System.out.println("Cantidad de Efectivo en Caja: "+efectivoCaja);
                   }else{
                       System.out.println("No se puede pagar Compra");
                }
               }
               
           }else if(proveedor.equals("b")){
               System.out.println("***Productos Disponibles***");
               System.out.println("| Codigo |"+" | Producto | "+" | Precio | ");
               System.out.println("|   2    |"+" |  Avena   | "+" | Lps.20 | ");
               System.out.println("|   3    |"+" |  Trigo   | "+" | Lps.30 | ");
               
               System.out.println("Porfavor ingrese el codigo del producto que desea comprar: ");
               int producto= lea.nextInt();
               System.out.println("Ingrese la cantidad (kilogramos) que desea comprar de este producto: ");
               double cantidad= lea.nextDouble();
               if (producto==2){
                   totalproducto= cantidad*20;
                   if(efectivoCaja>=totalproducto){
                       System.out.println("***Detalles de Compra***");
                       System.out.println("Codigo Producto: 2"+"\nProducto: Avena"+"\nCantidad: "+cantidad+" kilogramos"+"\nTotal: "+totalproducto);
                       stockAvena=cantidad;
                       efectivoCaja=efectivoCaja-totalproducto;
                       System.out.println("Cantidad de Efectivo en Caja: "+efectivoCaja);
                   }else{
                       System.out.println("No se puede pagar Compra");
                   }
               }else if(producto==3){
                    totalproducto= cantidad*30;
                    if(efectivoCaja>=totalproducto){
                      System.out.println("***Detalles de Compra***");
                      System.out.println("Codigo Producto: 3"+"\nProducto: Trigo"+"\nCantidad"+cantidad+" kilogramos"+"\nTotal: "+totalproducto);
                      stockTrigo=cantidad;
                      efectivoCaja=efectivoCaja-totalproducto;
                      System.out.println("Cantidad de Efectivo en Caja: "+efectivoCaja);
                   }else{
                       System.out.println("No se puede pagar Compra");
                }
               }
               
               
               
               
           }else if(proveedor.equals("c")){
               System.out.println("***Productos Disponibles***");
               System.out.println("| Codigo |"+" | Producto | "+" | Precio | ");
               System.out.println("|   2    |"+" |  Avena   | "+" | Lps.22 | ");
               
               System.out.println("Porfavor ingrese el codigo del producto que desea comprar: ");
               int producto= lea.nextInt();
               System.out.println("Ingrese la cantidad (kilogramos) que desea comprar de este producto: ");
               double cantidad= lea.nextDouble();
               if (producto==2){
                   totalproducto= cantidad*22;
                   if(efectivoCaja>=totalproducto){
                       System.out.println("***Detalles de Compra***");
                       System.out.println("Codigo Producto: 2"+"\nProducto: Avena"+"\nCantidad: "+cantidad+" kilogramos"+"\nTotal: "+totalproducto);
                       stockAvena=cantidad;
                       efectivoCaja=efectivoCaja-totalproducto;
                       System.out.println("");
                       System.out.println("Cantidad de Efectivo en Caja: "+efectivoCaja);
                   }else{
                       System.out.println("No se puede pagar Compra");
                   }
               }
           }else {
               System.out.println("Opcion no valida. Porfavor vuelva a intentar");
           }
         
       }else if (opcion == 4){
           System.out.println("Aqui se inicia el procedimiento de reporte");
       }else if (opcion ==5){
           System.out.println("Aqui se inicia el procedimiento de cierre de caja");
       }else if (opcion ==6){
           System.out.println("Aqui se inicia el procedimiento de salir ");
       }
       
        
        
        
    }
    
}
