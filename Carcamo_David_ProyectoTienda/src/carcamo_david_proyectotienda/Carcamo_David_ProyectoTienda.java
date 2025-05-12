/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package carcamo_david_proyectotienda;

import java.util.InputMismatchException;
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
        
        //Contador de Facturas
        int numfacturas=0;
        
        
        
        int opcion=0;
        
        
        //-------------------------------------------------------
        
       while (statusPrograma==true){
        // Creación de Menu Inicial y lectura
        System.out.print("****Menu Principal****");
        System.out.println("\n 1. Abrir Caja/Introducir Efectivo"
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
       
       
       
       //Ciclo que permitira la misma revision despues del primer ingreso
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
               System.out.println("Valor invalido. Porfavor ingrese un numero como opcion: ");
               lea.next();
           }
       }
       
       
       
       
       
       //Ingreso de efectivo inicial
       while(primeraApertura==true){
           System.out.println("Ingrese cantidad de fectivo inicial a guardar en caja:");
           if(lea.hasNextInt()){
               efectivoCaja=lea.nextDouble();
               if(efectivoCaja<1){
                   System.out.println("No se aceptan numeros negativos. Porfavor ingrese una opcion valida: ");
                   System.out.println("");
               }else if(efectivoCaja==0){
                   System.out.println("Porfavor ingrese una cantidad valida.");
                   System.out.println("");
               }else if(efectivoCaja>=1){
                   System.out.println("Efectivo guardado exitosamente");
                   System.out.println("Porfavor seleccione una opcion del menu: ");
                   primeraApertura = false;
               }
           }else{
               System.out.println("Valor invalido. Porfavor ingrese un numero como opcion:");
               lea.next();
           }
       }
       
       
       
     
        //Aviso inicial de stock en 0 se puede mover a ventas, para que no espamee
       
       
       //Estructura para realizar procedimientos
      
       //int opcion=opcionP;
       double totalproducto=0;
       
       if (opcion == 1){
           //Funcion para agregar efectivo extra
           System.out.println("Ingrese la cantidad de efectivo extra que desea ingresar: ");
           double dineroExtra=lea.nextDouble();
           efectivoCaja= efectivoCaja+dineroExtra;
           System.out.println("Efectivo Guardado Exitosamente");
           System.out.println("Efectivo en Caja: "+efectivoCaja);
           
          
       }else if (opcion==2){//Desarrollo de seccion ventas
           double subtotalVenta=0;
           numfacturas++;
           if(stockAzucar==0 && stockAvena==0 && stockTrigo==0 && stockMaiz==0){
           System.out.println("*AVISO* NO HAY PRODUCTOS EN STOCK ");
           System.out.println("");//Mensaje en caso que stock este vacio
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
               String productList= "--Detalle de Productos--"; //Variable String que llevara registro de los productos seleccionados mediante la anexion de texto
               while(facturar==false){
                
                System.out.println("Porfavor ingrese el codigo del producto que desea vender: ");
                
                
                
              if(lea.hasNextInt()){
                    
                int producto=lea.nextInt();
                
                if(producto==1){
                   System.out.println("");
                   System.out.println("**Informacion de producto**");
                   System.out.println("Codigo: 1"+"\nNombre de Producto: Azucar"+"\nPrecio unitario: Lps.30");
                   
                   boolean checkkilograms=false;
                   double cantidad=0;
                   
                   //Ciclo controlador de ingreso en kilogramos
                   while(checkkilograms!=true){
                       
                    System.out.println("Ingrese la cantidad (en kilogramos) que desea comprar de este producto: ");
                   
                    if(lea.hasNextDouble()){
                       
                    cantidad= lea.nextDouble();
                   
                    if(cantidad<0){
                       System.out.println("Cantidad Invalida.");
                       System.out.println("");
                    }else if(cantidad>0){
                       subtotalVenta= subtotalVenta+(cantidad*30);
                       checkkilograms=true;
                    }
                   
                   
                    }else{
                       System.out.println("Opcion Invalida");
                       System.out.println("");
                       lea.next();
                   }//Fin ciclo verificador
                   
                   }//Fin ciclo while
                   
                   
                   //Pregunta para proseguir a facturar
                    System.out.println("¿Desea agregar otro producto? Y/N");
                    String selec= lea.next();
                    String seleccion= selec.toLowerCase();
                    //Evaluacion para proceder a facturar
                    if(seleccion.equals("y")){
                        System.out.println("");
                        productList= productList + ("\n|Codigo: 1| "+" |Nombre de Producto: Azucar| "+" |Cantidad: "+cantidad+" kg| "+" | Precio unitario: Lps.30|");//Anexion a lista de productos
                        productList= productList + ("\n---------------------------------------------------------------------------");
                    }else{//caso respuesta de n
                        
                        System.out.println("");
                        productList= productList + ("\n|Codigo: 1| "+" |Nombre de Producto: Azucar| "+" |Cantidad: "+cantidad+" kg|"+" |Precio unitario: Lps.30|");
                        productList= productList + ("\n---------------------------------------------------------------------------");
                        facturar=true;
                    }
           
                }else if(producto==2){
                   System.out.println("");
                   System.out.println("**Informacion de producto**");
                   System.out.println("Codigo: 2"+"\nNombre de Producto: Avena"+"\nPrecio unitario: Lps.25");
                   System.out.println("Ingrese la cantidad (en kilogramos) que desea comprar de este producto: ");
                   double cantidad= lea.nextDouble();
                   subtotalVenta= subtotalVenta+(cantidad*25);
                   
                   System.out.println("¿Desea agregar otro producto? Y/N");
                   String selec= lea.next();
                   String seleccion= selec.toLowerCase();
                    //Evaluacion para proceder a facturar
                   if(seleccion.equals("y")){
                        System.out.println("");
                        productList= productList + ("\n|Codigo: 2| "+" |Nombre de Producto: Avena| "+" |Cantidad: "+cantidad+" kg|"+" |Precio unitario: Lps.25|");//Anexion a lista de productos
                        productList= productList + ("\n---------------------------------------------------------------------------");
                   }else{
                        
                        System.out.println("");
                        productList= productList + ("\n|Codigo: 2| "+" |Nombre de Producto: Avena| "+" |Cantidad: "+cantidad+" kg|"+" |Precio unitario: Lps.25|");
                        productList= productList + ("\n---------------------------------------------------------------------------");
                        facturar=true;
                    }
                   
                }else if(producto==3){
                   System.out.println("");
                   System.out.println("**Informacion de producto**");
                   System.out.println("Codigo: 3"+"\nNombre de Producto: Trigo"+"\nPrecio unitario: Lps.32");
                   System.out.println("Ingrese la cantidad (en kilogramos) que desea comprar de este producto: ");
                   double cantidad= lea.nextDouble();
                   subtotalVenta= subtotalVenta+ (cantidad*32);
                   
                   System.out.println("¿Desea agregar otro producto? Y/N");
                   String selec= lea.next();
                   String seleccion= selec.toLowerCase();
                    //Evaluacion para proceder a facturar
                   if(seleccion.equals("y")){
                        System.out.println("");
                        productList= productList + ("\n|Codigo: 3| "+" |Nombre de Producto: Trigo| "+" |Cantidad: "+cantidad+" kg|"+" |Precio unitario: Lps.32|");//Anexion a lista de productos
                        productList= productList + ("\n---------------------------------------------------------------------------");
                   }else{
                        
                        System.out.println("");
                        productList= productList + ("\n|Codigo: 3| "+" |Nombre de Producto: Trigo| "+" |Cantidad: "+cantidad+" kg|"+" |Precio unitario: Lps.32|");
                        productList= productList + ("\n---------------------------------------------------------------------------");
                        facturar=true;
                   }
                   
                }else if(producto==4){
                   System.out.println("");
                   System.out.println("**Informacion de producto**");
                   System.out.println("Codigo: 4"+"\nNombre de Producto: Maiz"+"\nPrecio unitario: Lps.20");
                   System.out.println("Ingrese la cantidad (en kilogramos) que desea comprar de este producto: ");
                   double cantidad= lea.nextDouble();
                   subtotalVenta= subtotalVenta +(cantidad*20);
                   
                   System.out.println("¿Desea agregar otro producto? Y/N");
                    String selec= lea.next();
                    String seleccion= selec.toLowerCase();
                    //Evaluacion para proceder a facturar
                   if(seleccion.equals("y")){
                        System.out.println("");
                        productList= productList + ("\n|Codigo: 4| "+" |Nombre de Producto: Maíz| "+" |Cantidad: "+cantidad+" kg|"+" |Precio unitario: Lps.20|");//Anexion a lista de productos
                        productList= productList + ("\n---------------------------------------------------------------------------");
                   }else{
                        
                        System.out.println("");
                        productList= productList + ("\n|Codigo: 4| "+" |Nombre de Producto: Maíz| "+" |Cantidad: "+cantidad+" kg|"+" |Precio unitario: Lps.20|");
                        productList= productList + ("\n---------------------------------------------------------------------------");
                        facturar=true;
                   }
                   
                }else if(producto<=0){
                    System.out.println("Opcion Invalida");
                    System.out.println("");
                }
               }else{
                  System.out.println("Opcion Invalida");
                  System.out.println("");
                  lea.next();
               } //Fin ciclo comprobador if
               
                
               }//Fin ciclo While
               
               //Evaluaciones de descuentos
               double descuento=0;
               int porcentaje=0;
               if (subtotalVenta>=1000 && subtotalVenta<=5000){
                   descuento=subtotalVenta*0.05;
                   porcentaje=5;
               }else if(subtotalVenta>5000){
                   descuento=subtotalVenta*0.10;
                   porcentaje=10;
               }else if(subtotalVenta<1000){
                   descuento=0;
                   porcentaje=0;
               }
               
               
               
               //Subtotal con descuento aplicado
               double subtotalaplicado=(subtotalVenta-descuento);
               
               //Evaluacion de impuesto
               double impuesto=subtotalaplicado*0.07;
               String impuestoRedondeado= String.format("%.2f",impuesto);
               
               //Evaluacion del total
               double totalVenta=subtotalaplicado+impuesto;
               String totalVredondeado= String.format("%.2f",totalVenta);
               
               //Procedimiento de facturacion
                System.out.println("");
                System.out.println("***Detalle de Factura***");
                System.out.println("Numero de Factura: "+numfacturas);
                System.out.println(productList);
                System.out.println("Subtotal: Lps."+subtotalVenta);
                System.out.println("Descuento del "+porcentaje+"%: Lps."+descuento);
                System.out.println("Subtotal con descuento aplicado: "+subtotalaplicado);
                System.out.println("I.S.V 7%: Lps."+impuestoRedondeado);
                System.out.println("Total a pagar: Lps."+totalVredondeado);
                System.out.println("");
                
                //Sumatoria a caja
                efectivoCaja= efectivoCaja+totalVenta;
                System.out.println("Dinero en caja: "+efectivoCaja);
               
               
           }else if(cliente.equals("b")){
               System.out.println("***Productos Disponibles Para Venta***");
               System.out.println("| Codigo |"+" | Producto | "+" | Precio | ");
               System.out.println("|   1    |"+" |  Azucar  | "+" | Lps.30 | ");
               System.out.println("|   2    |"+" |   Avena  | "+" | Lps.25 | ");
               System.out.println("|   3    |"+" |   Trigo  | "+" | Lps.32 | ");
               System.out.println("");
               boolean facturar =false;
               
               String productList= "--Detalle de Productos--"; //Variable String que llevara registro de los productos seleccionados mediante la anexion de texto
               while(facturar==false){
                
                System.out.println("Porfavor ingrese el codigo del producto que desea vender: ");
                
               if(lea.hasNextInt()){
                   
               
                int producto=lea.nextInt();
                
                if(producto==1){
                   System.out.println("");
                   System.out.println("**Informacion de producto**");
                   System.out.println("Codigo: 1"+"\nNombre de Producto: Azucar"+"\nPrecio unitario: Lps.30");
                   System.out.println("Ingrese la cantidad (en kilogramos) que desea comprar de este producto: ");
                   double cantidad= lea.nextDouble();
                   subtotalVenta= subtotalVenta+(cantidad*30);
                   //Pregunta para proseguir a facturar
                    System.out.println("¿Desea agregar otro producto? Y/N");
                    String selec= lea.next();
                    String seleccion= selec.toLowerCase();
                    //Evaluacion para proceder a facturar
                    if(seleccion.equals("y")){
                        System.out.println("");
                        productList= productList + ("\n|Codigo: 1| "+" |Nombre de Producto: Azucar| "+" |Cantidad: "+cantidad+" kg| "+" | Precio unitario: Lps.30|");//Anexion a lista de productos
                        productList= productList + ("\n---------------------------------------------------------------------------");
                    }else{
                        
                        System.out.println("");
                        productList= productList + ("\n|Codigo: 1| "+" |Nombre de Producto: Azucar| "+" |Cantidad: "+cantidad+" kg|"+" |Precio unitario: Lps.30|");
                        productList= productList + ("\n---------------------------------------------------------------------------");
                        facturar=true;
                    }
           
                }else if(producto==2){
                   System.out.println("");
                   System.out.println("**Informacion de producto**");
                   System.out.println("Codigo: 2"+"\nNombre de Producto: Avena"+"\nPrecio unitario: Lps.25");
                   System.out.println("Ingrese la cantidad (en kilogramos) que desea comprar de este producto: ");
                   double cantidad= lea.nextDouble();
                   subtotalVenta= subtotalVenta+(cantidad*25);
                   
                   System.out.println("¿Desea agregar otro producto? Y/N");
                   String selec= lea.next();
                   String seleccion= selec.toLowerCase();
                    //Evaluacion para proceder a facturar
                   if(seleccion.equals("y")){
                        System.out.println("");
                        productList= productList + ("\n|Codigo: 2| "+" |Nombre de Producto: Avena| "+" |Cantidad: "+cantidad+" kg|"+" |Precio unitario: Lps.25|");//Anexion a lista de productos
                        productList= productList + ("\n---------------------------------------------------------------------------");
                   }else{
                        
                        System.out.println("");
                        productList= productList + ("\n|Codigo: 2| "+" |Nombre de Producto: Avena| "+" |Cantidad: "+cantidad+" kg|"+" |Precio unitario: Lps.25|");
                        productList= productList + ("\n---------------------------------------------------------------------------");
                        facturar=true;
                    }
                   
                }else if(producto==3){
                   System.out.println("");
                   System.out.println("**Informacion de producto**");
                   System.out.println("Codigo: 3"+"\nNombre de Producto: Trigo"+"\nPrecio unitario: Lps.32");
                   System.out.println("Ingrese la cantidad (en kilogramos) que desea comprar de este producto: ");
                   double cantidad= lea.nextDouble();
                   subtotalVenta= subtotalVenta+ (cantidad*32);
                   
                   System.out.println("¿Desea agregar otro producto? Y/N");
                   String selec= lea.next();
                   String seleccion= selec.toLowerCase();
                    //Evaluacion para proceder a facturar
                   if(seleccion.equals("y")){
                        System.out.println("");
                        productList= productList + ("\n|Codigo: 3| "+" |Nombre de Producto: Trigo| "+" |Cantidad: "+cantidad+" kg|"+" |Precio unitario: Lps.32|");//Anexion a lista de productos
                        productList= productList + ("\n---------------------------------------------------------------------------");
                   }else{
                        
                        System.out.println("");
                        productList= productList + ("\n|Codigo: 3| "+" |Nombre de Producto: Trigo| "+" |Cantidad: "+cantidad+" kg|"+" |Precio unitario: Lps.32|");
                        productList= productList + ("\n---------------------------------------------------------------------------");
                        facturar=true;
                   }
                }else if(producto<=0){
                    System.out.println("Opcion invalida");
                    System.out.println("");

                }
                
               }else{
                  System.out.println("Opcion Invalida");
                  System.out.println("");
                  lea.next();
               }
               
                
               }//Fin Cilco While
                
                
                //Evaluaciones de descuentos
               double descuento=0;
               int porcentaje=0;
               if (subtotalVenta>=1000 && subtotalVenta<=5000){
                   descuento=subtotalVenta*0.05;
                   porcentaje=5;
               }else if(subtotalVenta>5000){
                   descuento=subtotalVenta*0.10;
                   porcentaje=10;
               }else if(subtotalVenta<1000){
                   descuento=0;
                   porcentaje=0;
               }
               
               
               //Subtotal con descuento aplicado
               double subtotalaplicado=(subtotalVenta-descuento);
               
               //Evaluacion de impuesto
               double impuesto=subtotalaplicado*0.07;
               String impuestoRedondeado= String.format("%.2f",impuesto);
               
               //Evaluacion del total
               double totalVenta=subtotalaplicado+impuesto;
               String totalVredondeado= String.format("%.2f",totalVenta);
               
               //Procedimiento de facturacion
                System.out.println("");
                System.out.println("***Detalle de Factura***");
                System.out.println("Numero de Factura: "+numfacturas);
                System.out.println(productList);
                System.out.println("Subtotal: Lps."+subtotalVenta);
                System.out.println("Descuento del "+porcentaje+"%: Lps."+descuento);
                System.out.println("Subtotal con descuento aplicado: "+subtotalaplicado);
                System.out.println("I.S.V 7%: Lps."+impuestoRedondeado);
                System.out.println("Total a pagar: Lps."+totalVredondeado);
                System.out.println("");
               
               
               
               
                //Sumatoria a caja
                efectivoCaja= efectivoCaja+totalVenta;
                System.out.println("Dinero en caja: "+efectivoCaja);
               
               
               
               
               
               
               
               
               
                       
           }else if(cliente.equals("c")){
               System.out.println("***Productos Disponibles Para Venta***");
               System.out.println("| Codigo |"+" | Producto | "+" | Precio | ");
               System.out.println("|   4    |"+" |   Maiz   | "+" | Lps.20 | ");
               System.out.println("");
               
            boolean facturar =false;
               
            String productList= "--Detalle de Productos--"; //Variable String que llevara registro de los productos seleccionados mediante la anexion de texto
            while(facturar==false){
                
                
            
            System.out.println("Porfavor ingrese el codigo del producto que desea vender: ");
            
          if(lea.hasNextInt()){
            int producto=lea.nextInt();
            if(producto==4){
                System.out.println("");
                System.out.println("**Informacion de producto**");
                System.out.println("Codigo: 4"+"\nNombre de Producto: Maiz"+"\nPrecio unitario: Lps.20");
                System.out.println("Ingrese la cantidad (en kilogramos) que desea comprar de este producto: ");
                double cantidad= lea.nextDouble();
                subtotalVenta= subtotalVenta+(cantidad*20);
                //Pregunta para proseguir a facturar
                System.out.println("¿Desea agregar otro producto? Y/N");
                String selec= lea.next();
                String seleccion= selec.toLowerCase();
                //Evaluacion para proceder a facturar
                if(seleccion.equals("y")){
                    System.out.println("");
                    productList= productList + ("\n|Codigo: 4| "+" |Nombre de Producto: Maiz| "+" |Cantidad: "+cantidad+" kg| "+" | Precio unitario: Lps.20|");//Anexion a lista de productos
                    productList= productList + ("\n---------------------------------------------------------------------------");
                   }else{
                        
                    System.out.println("");
                    productList= productList + ("\n|Codigo: 4| "+" |Nombre de Producto: Maiz| "+" |Cantidad: "+cantidad+" kg|"+" |Precio unitario: Lps.20|");
                    productList= productList + ("\n---------------------------------------------------------------------------");
                    facturar=true;
                    }
            }else if(producto<=0){
                System.out.println("Opcion Invalida");
            }
            
          }else{
              System.out.println("Opcion Invalida");
              System.out.println("");
              lea.next();
          }
            
            }//Fin de ciclo While
            
             //Evaluaciones de descuentos
            double descuento=0;
            int porcentaje=0;
            if (subtotalVenta>=1000 && subtotalVenta<=5000){
                descuento=subtotalVenta*0.05;
                porcentaje=5;
            }else if(subtotalVenta>5000){
                descuento=subtotalVenta*0.10;
                porcentaje=10;
            }else if(subtotalVenta<1000){
                descuento=0;
                porcentaje=0;
            }
               
               
            //Subtotal con descuento aplicado
               double subtotalaplicado=(subtotalVenta-descuento);
               
            //Evaluacion de impuesto
            double impuesto=subtotalaplicado*0.07;
            String impuestoRedondeado= String.format("%.2f",impuesto);
               
            //Evaluacion del total
            double totalVenta=subtotalaplicado+impuesto;
            String totalVredondeado= String.format("%.2f",totalVenta);
               
            //Procedimiento de facturacion
            System.out.println("");
            System.out.println("***Detalle de Factura***");
            System.out.println("Numero de Factura: "+numfacturas);
            System.out.println(productList);
            System.out.println("Subtotal: Lps."+subtotalVenta);
            System.out.println("Descuento del "+porcentaje+"%: Lps."+descuento);
            System.out.println("Subtotal con descuento aplicado: "+subtotalaplicado);
            System.out.println("I.S.V 7%: Lps."+impuestoRedondeado);
            System.out.println("Total a pagar: Lps."+totalVredondeado);
            System.out.println("");
               
            //Sumatoria a caja
            efectivoCaja= efectivoCaja+totalVenta;
            System.out.println("Dinero en caja: "+efectivoCaja);
               
               
           }else{
                System.out.println("Valor no valido");
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
               
               boolean checkcompra=false;
               
               
               while(checkcompra!=true){
                   
               System.out.println("Porfavor ingrese el codigo del producto que desea comprar: ");
               
               if(lea.hasNextInt()){
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
                       checkcompra=true;
                   }else{
                       System.out.println("No se puede pagar Compra");
                       checkcompra=true;
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
                      checkcompra=true;
                   }else{
                       System.out.println("No se puede pagar Compra");
                       checkcompra=true;
                }
               }else if(producto<=0){
                   System.out.println("Opcion no Valida");
                   System.out.println("");
               }else{
                   System.out.println("Proveedor no vende dicho Producto");
                   System.out.println("");
                   checkcompra=true;
               }
               
               }else{
                   System.out.println("Opcion no Valida");
                   lea.next();
               }//Fin evaluador
               
               }//Fin ciclo while
               
           }else if(proveedor.equals("b")){
               System.out.println("***Productos Disponibles***");
               System.out.println("| Codigo |"+" | Producto | "+" | Precio | ");
               System.out.println("|   2    |"+" |  Avena   | "+" | Lps.20 | ");
               System.out.println("|   3    |"+" |  Trigo   | "+" | Lps.30 | ");
               
               boolean checkcompra=false;
               
               while(checkcompra!=true){
                   
               System.out.println("Porfavor ingrese el codigo del producto que desea comprar: ");
               
               if(lea.hasNextInt()){
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
                       checkcompra=true;
                   }else{
                       System.out.println("No se puede pagar Compra");
                       checkcompra=true;
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
                      checkcompra=true;
                   }else{
                       System.out.println("No se puede pagar Compra");
                       checkcompra=true;
                }
               }else if(producto<=0){
                   System.out.println("Opcion Invalida");
                   System.out.println("");
               }else{
                   System.out.println("Proveedor no vende dicho producto");
                   System.out.println("");
               }
               
               }else{
                   System.out.println("Opcion Invalida");
                   System.out.println("");
                   lea.next();
               }//Fin comprobador
               
               }//Fin ciclo while
               
               
               
               
           }else if(proveedor.equals("c")){
               System.out.println("***Productos Disponibles***");
               System.out.println("| Codigo |"+" | Producto | "+" | Precio | ");
               System.out.println("|   2    |"+" |  Avena   | "+" | Lps.22 | ");
               
               boolean checkcompra=false;
               
               
               while(checkcompra!=true){
               System.out.println("Porfavor ingrese el codigo del producto que desea comprar: ");
               
               if(lea.hasNextInt()){
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
                       checkcompra=true;
                   }else{
                       System.out.println("No se puede pagar Compra");
                       checkcompra=true;
                   }
               }else if(producto<=0){
                   System.out.println("Opcion Invalida");
                   System.out.println("");
               }else{
                   System.out.println("Proveedor no vende dicho producto");
                   System.out.println("");
               }
               }else{
                   System.out.println("Opcion Invalida");
                   System.out.println("");
                   lea.next();
               }//Fin ceccion validacion 
               
               }//Fin ciclo WHile
               
          
           }else {
               System.out.println("Opcion no valida. Porfavor vuelva a intentar");
           }//Fin parte 3
         
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
    
