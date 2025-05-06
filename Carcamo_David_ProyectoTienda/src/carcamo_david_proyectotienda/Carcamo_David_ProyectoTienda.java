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
        boolean statusPrograma=true;
        
        //Contadores de Stock
        double stockAzucar=0;
        double stockAvena=0;
        double stockTrigo=0;
        double stockMaiz=0;
        
        //Seguidor de Apertura
        boolean primeraApertura= true;
        boolean controladorApertura=true;
        
        //Almacenador de dinero
        double efectivoCaja=0;
        
        int opcion=0;
        
       while (statusPrograma==true){
        // Creación de Menu Inicial y lectura
        System.out.print("****Menu Principal****");
        System.out.println("\n 1. Abrir Caja"
        +"\n 2. Venta"+"\n 3. Compra"+"\n 4. Reporte"+"\n 5. Cierre Caja"+"\n 6.Salir");
        
        //Mensaje de apertura caja al inicio de cada nuevo dia
        if(statusCaja==false){
            System.out.println("**Porfavor abrir caja antes de seleccionar alguna opcion del menu (seleccione opcion 1)***");
        }
        
        Scanner lea= new Scanner(System.in);
        lea.useDelimiter("\n");
        System.out.println("Porfavor ingrese una opción del menu: ");
        
        
       //Estructura para evaluacion de estatus de caja y respuestas (Primera Apertura)
       while (statusCaja!=true){        
        if(lea.hasNextInt()){
           int opcionInicial = lea.nextInt();
            if(opcionInicial<1){
           System.out.println("No se aceptan numeros negativos. Porfavor ingrese una opcion valida: ");
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
       
       
       while(controladorApertura==false){
           if(lea.hasNextInt()){
               int opcionInicial = lea.nextInt();
               if(opcionInicial<1){
                   System.out.println("No se aceptan numeros negativos. Porfavor ingrese una opcion valida: ");
               }else if(opcionInicial>6){
                   System.out.println("Numero fuera del limite establecido(1-6). Porfavor ingrese una opcion valida: ");
               }else if(opcionInicial>=1 && opcionInicial<=6){
                   controladorApertura=true;
                   opcion=opcionInicial;
               }
           }else{
               System.out.println("Valor invalid. Porfavor ingrese un numero como opcion: ");
               lea.next();
           }
       }
       
       
          
       //Ingreso de efectivo inicial
       if(primeraApertura==true){
           System.out.println("Ingrese cantidad de efectivo inicial a guardar en caja: ");
           efectivoCaja= lea.nextDouble();
           System.out.println("Efectivo guardado exitosamente");
           primeraApertura = false;
           System.out.println("Porfavor seleccione una opcion del menu: ");
           opcion = lea.nextInt();
       }
       
       
     
        //Aviso inicial de stock en 0 se puede mover a ventas, para que no espamee
       
       
       //Estructura para realizar procedimientos
      
       //int opcion=opcionP;
       double totalproducto=0;
       
       if (opcion == 1){
           System.out.println("Aqui se muestra la opcion de ingresar efectivo");
           
           
       }else if (opcion==2){
           double subtotalVenta=0;
           if(stockAzucar==0 && stockAvena==0 && stockTrigo==0 && stockMaiz==0){
           System.out.println("*AVISO* NO HAY PRODUCTOS EN STOCK ");
           System.out.println("");
           }else{
            System.out.println("Porfavor seleccione tipo de cliente al que desea vender(A,B,C): ");
            System.out.println("1.cliente A"+"\n2.cliente B"+"\n3.cliente C");
            String seleccionCliente= lea.next();
            String cliente= seleccionCliente.toLowerCase();
            
            if(cliente.equals("a")){
               System.out.println("***Productos Disponibles Para Venta***");
               System.out.println("| Codigo |"+" | Producto | "+" | Precio | ");
               System.out.println("|   1    |"+" |  Azucar  | "+" | Lps.30 | ");
               System.out.println("|   2    |"+" |   Avena  | "+" | Lps.25 | ");
               System.out.println("|   3    |"+" |   Trigo  | "+" | Lps.32 | ");
               System.out.println("|   4    |"+" |   Maiz   | "+" | Lps.20 | ");
               System.out.println("");
               boolean facturar =false;
               //Ciclo que permite el reingreso de productos antes de facturar
               while(facturar==false){
                System.out.println("Porfavor ingrese el codigo del producto que desea vender: ");
                int producto=lea.nextInt();
                if(producto==1){
                   System.out.println("");
                   System.out.println("**Informacion de producto**");
                   System.out.println("Codigo: 2"+"\nNombre de Producto: Azucar"+"\nPrecio unitario: Lps.30");
                   System.out.println("Ingrese la cantidad (en kilogramos) que desea comprar de este producto: ");
                   double cantidad= lea.nextDouble();
                   subtotalVenta= cantidad*30;
                   //Pregunta para proseguir a facturar
                    System.out.println("¿Desea agregar otro producto? Y/N");
                    String selec= lea.next();
                    String seleccion= selec.toLowerCase();
                    //Evaluacion para proceder a facturar
                    if(seleccion.equals("y")){
                        System.out.println("");
                    }else{
                        System.out.println("Procede a facturar");
                        facturar=true;
                    }
           
                }else if(producto==2){
                   System.out.println("");
                   System.out.println("**Informacion de producto**");
                   System.out.println("Codigo: 2"+"\nNombre de Producto: Avena"+"\nPrecio unitario: Lps.25");
                   System.out.println("Ingrese la cantidad (en kilogramos) que desea comprar de este producto: ");
                   double cantidad= lea.nextDouble();
                   subtotalVenta= cantidad*25;
                }else if(producto==3){
                   System.out.println("");
                   System.out.println("**Informacion de producto**");
                   System.out.println("Codigo: 3"+"\nNombre de Producto: Trigo"+"\nPrecio unitario: Lps.32");
                   System.out.println("Ingrese la cantidad (en kilogramos) que desea comprar de este producto: ");
                   double cantidad= lea.nextDouble();
                   subtotalVenta= cantidad*32;
                }else if(producto==4){
                   System.out.println("");
                   System.out.println("**Informacion de producto**");
                   System.out.println("Codigo: 4"+"\nNombre de Producto: Maiz"+"\nPrecio unitario: Lps.20");
                   System.out.println("Ingrese la cantidad (en kilogramos) que desea comprar de este producto: ");
                   double cantidad= lea.nextDouble();
                   subtotalVenta= cantidad*20;
                }
               
                
               }//Fin ciclo While
               
               //Procedimiento de facturacion
                System.out.println("***Detalle de Factura***");
                System.out.println("Numero de Factura: ");
                System.out.println("---Productos--- ");
                System.out.println("Detalles de productos");
                System.out.println("Subtotal: Lps."+subtotalVenta);
                //Evaluaciones de descuento1
                
               
               
           }else if(cliente.equals("b")){
               System.out.println("***Productos Disponibles Para Venta***");
               System.out.println("| Codigo |"+" | Producto | "+" | Precio | ");
               System.out.println("|   1    |"+" |  Azucar  | "+" | Lps.30 | ");
               System.out.println("|   2    |"+" |   Avena  | "+" | Lps.25 | ");
               System.out.println("|   3    |"+" |   Trigo  | "+" | Lps.32 | ");
               System.out.println("");
           }else if(cliente.equals("c")){
               System.out.println("***Productos Disponibles Para Venta***");
               System.out.println("| Codigo |"+" | Producto | "+" | Precio | ");
               System.out.println("|   4    |"+" |   Maiz   | "+" | Lps.20 | ");
               System.out.println("");
           }
          }
           
           
       }else if (opcion ==3){
           //Seleccion de Proveedor
           System.out.println("Porfavor seleccione el proveedor al que desea comprar(A,B,C): ");
           System.out.println("1.Proveedor A"+"\n2.Proveedor B"+"\n3.Proveedor C");
           String seleccionProveedor= lea.next();
           String proveedor= seleccionProveedor.toLowerCase();
           if(proveedor.equals("a")){
               System.out.println("***Productos Disponibles Para Compra***");
               System.out.println("| Codigo |"+" | Producto | "+" | Precio | ");
               System.out.println("|   1    |"+" |  Azucar  | "+" | Lps.25 | ");
               System.out.println("|   4    |"+" |   Maiz   | "+" | Lps.18 | ");
               System.out.println("");
               System.out.println("Porfavor ingrese el codigo del producto que desea comprar: ");
               int producto= lea.nextInt();
               
               if (producto==1){
                   System.out.println("Ingrese la cantidad (kilogramos) que desea comprar de este producto: ");
                   double cantidad= lea.nextDouble();
                   totalproducto= cantidad*25;
                   if(efectivoCaja>=totalproducto){
                       System.out.println("***Detalles de Compra***");
                       System.out.println("Codigo Producto: 1"+"\nProducto: Azucar"+"\nCantidad: "+cantidad+" kilogramos"+"\nTotal: "+totalproducto);
                       stockAzucar=cantidad;
                       efectivoCaja=efectivoCaja-totalproducto;
                       System.out.println("Cantidad de Efectivo en Caja: "+efectivoCaja);
                       System.out.println("");
                   }else{
                       System.out.println("No se puede pagar Compra");
                   }
               }else if(producto==4){
                   System.out.println("Ingrese la cantidad (kilogramos) que desea comprar de este producto: ");
                   double cantidad= lea.nextDouble(); 
                    totalproducto= cantidad*18;
                    if(efectivoCaja>=totalproducto){
                      System.out.println("***Detalles de Compra***");
                      System.out.println("Codigo Producto: 4"+"\nProducto: Maiz"+"\nCantidad"+cantidad+" kilogramos"+"\nTotal: "+totalproducto);
                      stockMaiz=cantidad;
                      efectivoCaja=efectivoCaja-totalproducto;
                      System.out.println("Cantidad de Efectivo en Caja: "+efectivoCaja);
                      System.out.println("");
                   }else{
                       System.out.println("No se puede pagar Compra");
                }
               }else{
                   System.out.println("Proveedor no vende dicho Producto");
                   System.out.println("");
               }
               
           }else if(proveedor.equals("b")){
               System.out.println("***Productos Disponibles***");
               System.out.println("| Codigo |"+" | Producto | "+" | Precio | ");
               System.out.println("|   2    |"+" |  Avena   | "+" | Lps.20 | ");
               System.out.println("|   3    |"+" |  Trigo   | "+" | Lps.30 | ");
               
               System.out.println("Porfavor ingrese el codigo del producto que desea comprar: ");
               int producto= lea.nextInt();
               
               if (producto==2){
                   System.out.println("Ingrese la cantidad (kilogramos) que desea comprar de este producto: ");
                   double cantidad= lea.nextDouble();
                   totalproducto= cantidad*20;
                   if(efectivoCaja>=totalproducto){
                       System.out.println("***Detalles de Compra***");
                       System.out.println("Codigo Producto: 2"+"\nProducto: Avena"+"\nCantidad: "+cantidad+" kilogramos"+"\nTotal: "+totalproducto);
                       stockAvena=cantidad;
                       efectivoCaja=efectivoCaja-totalproducto;
                       System.out.println("Cantidad de Efectivo en Caja: "+efectivoCaja);
                       System.out.println("");
                   }else{
                       System.out.println("No se puede pagar Compra");
                   }
               }else if(producto==3){
                   System.out.println("Ingrese la cantidad (kilogramos) que desea comprar de este producto: ");
                   double cantidad= lea.nextDouble();
                    totalproducto= cantidad*30;
                    if(efectivoCaja>=totalproducto){
                      System.out.println("***Detalles de Compra***");
                      System.out.println("Codigo Producto: 3"+"\nProducto: Trigo"+"\nCantidad"+cantidad+" kilogramos"+"\nTotal: "+totalproducto);
                      stockTrigo=cantidad;
                      efectivoCaja=efectivoCaja-totalproducto;
                      System.out.println("Cantidad de Efectivo en Caja: "+efectivoCaja);
                      System.out.println("");
                   }else{
                       System.out.println("No se puede pagar Compra");
                }
               }else{
                   System.out.println("Proveedor no vende dicho producto");
                   System.out.println("");
               }
               
               
               
               
           }else if(proveedor.equals("c")){
               System.out.println("***Productos Disponibles***");
               System.out.println("| Codigo |"+" | Producto | "+" | Precio | ");
               System.out.println("|   2    |"+" |  Avena   | "+" | Lps.22 | ");
               
               System.out.println("Porfavor ingrese el codigo del producto que desea comprar: ");
               int producto= lea.nextInt();
               
               if (producto==2){
                   System.out.println("Ingrese la cantidad (kilogramos) que desea comprar de este producto: ");
                   double cantidad= lea.nextDouble();
                   totalproducto= cantidad*22;
                   if(efectivoCaja>=totalproducto){
                       System.out.println("***Detalles de Compra***");
                       System.out.println("Codigo Producto: 2"+"\nProducto: Avena"+"\nCantidad: "+cantidad+" kilogramos"+"\nTotal: "+totalproducto);
                       stockAvena=cantidad;
                       efectivoCaja=efectivoCaja-totalproducto;
                       System.out.println("");
                       System.out.println("Cantidad de Efectivo en Caja: "+efectivoCaja);
                       System.out.println("");
                   }else{
                       System.out.println("No se puede pagar Compra");
                   }
               }else{
                   System.out.println("Proveedor no vende dicho producto");
                   System.out.println("");
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
           break;
       }   
       
       controladorApertura=false;
     }
    }  
   }
    
