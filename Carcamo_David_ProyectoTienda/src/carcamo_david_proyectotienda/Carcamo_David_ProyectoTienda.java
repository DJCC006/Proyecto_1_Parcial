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
        
        //Establecimiento de variables de primera jerarquia (Super Generales)---------
        
        //Variable que lleva control de los dias
        boolean controladorDias=true;
        int numDia=0;
        
        //Seguidor de Apertura
        boolean primeraApertura= true;
        
        
        
        
        //Almacenador de dinero
        double efectivoCaja=0;
        double efectivoBanco=0;
        
        //Contadores de Stock
        double stockAzucar=0;
        double stockAvena=0;
        double stockTrigo=0;
        double stockMaiz=0;
        
         
        
        //------------------------------------------------------
        
        
        //Ciclo que permite el inicio de un nuevo dia con todo inicializado en cero
        while(controladorDias==true){
            
            //Establecimiento de variables de segunda jerarquia (locales dentro de ciclo de dias)-----------------
        

            //Controlador de Apertura local
            boolean controladorApertura=true;

            //Creación de variable que lleva seguimiento del estatus de la caja
            boolean statusCaja= false; 
            boolean statusPrograma=true;
            
            //Controladores de cantidades de cada producto
            double cantAzucar=0;
            double cantAvena=0;
            double cantTrigo=0;
            double cantMaiz=0;


            //Controladores de producto estrella
            String producto_Estrella="";
            double cantEstrella=0;






            //Contadores
            int numfacturas=0;
            int numCompras=0;
            int numVentas=0;
            double volCompras=0;
            double volVentas=0;
            double mayorCompra=0;
            double mayorVenta=0;
            String info_mayorCompra="****Detalles de mayor Compra****";
            String info_mayorVenta="****Detalles de mayor Venta****";
            int opcion=0;

        
            //-------------------------------------------------------------------------------
            
            //Ciclo que permite la repeticion del programa y la estructura del menu inicial
            while (statusPrograma==true){
            // Creación de Menu Inicial y lectura
             System.out.print("===========  Menu Principal  =========== ");
             System.out.println("\n     1. Abrir Caja/Introducir Efectivo Extra"
             +"\n               2.Venta"+"\n               3.Compra"+"\n               4.Reporte"+"\n             5.Cierre Caja"+"\n               6.Salir");
             System.out.println("========================================");


             //Mensaje de apertura caja al inicio de cada nuevo dia
             if(statusCaja==false){
                 System.out.println("Es necesario abrir la caja antes de usar el menú. Porfavor, elija la opción 1.");
             }

             Scanner lea= new Scanner(System.in);
             lea.useDelimiter("\n");
             System.out.println("Ingrese una opción del menu: ");


            //Estructura para evaluacion de estatus de caja y respuestas (Primera Apertura)
            while (statusCaja!=true){        
             if(lea.hasNextInt()){
                int opcionInicial = lea.nextInt();
                 if(opcionInicial<1){
                    System.out.println("");
                    System.out.println("No se aceptan numeros negativos. Porfavor, ingrese una opcion válida: ");
              }else if(opcionInicial>6){
                    System.out.println("");
                    System.out.println("Número fuera del limite establecido (1-6). Porfavor, ingrese una opción válida: ");

              }else if (opcionInicial != 1){
                    System.out.println("");
                    System.out.println("Caja debe ser abierta para utilizar esta función. Porfavor, ingrese nuevamente una opción: ");

                }else if(opcionInicial ==1) {
                    System.out.println("");
                    System.out.println("Se ha abierto caja.");
                    statusCaja = true;
               }
              }else{
                    System.out.println("");
                    System.out.println("Valor inválido. Porfavor, ingrese un numero (1-6) como opción: ");
                    lea.next();
               }
             }



            //Ciclo que permitira la misma revision despues del primer ingreso
            while(controladorApertura==false){
                if(lea.hasNextInt()){
                    int opcionInicial = lea.nextInt();
                    if(opcionInicial<1){
                        System.out.println("");
                        System.out.println("No se aceptan números negativos. Porfavor, ingrese una opción válida: ");
                    }else if(opcionInicial>6){
                        System.out.println("");
                        System.out.println("Número fuera del límite establecido(1-6). Porfavor, ingrese una opción válida: ");
                    }else if(opcionInicial>=1 && opcionInicial<=6){
                        controladorApertura=true;
                        opcion=opcionInicial;
                    }
                }else{
                    System.out.println("");
                    System.out.println("Valor inválido. Porfavor, ingrese un número como opción: ");
                    lea.next();
                }
            }





            //Ingreso de efectivo inicial
            while(primeraApertura==true){
                System.out.println("Ingrese cantidad de efectivo inicial a guardar en caja:");
                if(lea.hasNextInt()){
                    efectivoCaja=lea.nextDouble();
                    if(efectivoCaja<0){
                        System.out.println("");
                        System.out.println("No se aceptan cantidades negativas. Porfavor, ingrese una cantidad válida. ");
                    }else if(efectivoCaja==0){
                        System.out.println("");
                        System.out.println("La cantidad inicial no puede ser igual a 0. Porfavor, ingrese una cantidad válida. ");
                    }else if(efectivoCaja>=1){
                        System.out.println("");
                        System.out.println("Efectivo guardado exitosamente.");
                        System.out.println("");
                        primeraApertura = false; 
                    }
                }else{
                    System.out.println("");
                    System.out.println("Valor inválido. Porfavor, ingrese un número como opción.");
                    lea.next();
                }
            }



            //Variable contadora que almacena el total de los productos seleccionados en seccion de compras
            double totalproducto=0;

            //Estructuras para realizar procedimientos del menu
            if (opcion == 1){
                //Funcion para agregar efectivo extra
                System.out.println("Ingrese la cantidad de efectivo extra que desea ingresar: ");
                double dineroExtra=lea.nextDouble();
                efectivoCaja= efectivoCaja+dineroExtra;
                System.out.println("Efectivo Guardado Exitosamente");
                System.out.println("Efectivo en Caja: Lps."+efectivoCaja);


            }else if (opcion==2){
                //Desarrollo de seccion ventas
                double subtotalVenta=0;
                

                if(stockAzucar==0 && stockAvena==0 && stockTrigo==0 && stockMaiz==0){
                    System.out.println("");//Mensaje en caso que stock este vacio
                    System.out.println("== NO HAY PRODUCTOS EN STOCK ==");
                    System.out.println("");


                }else{
                    
                    
                     //Interfaz de lista de productos disponibles para la venta
                System.out.println("");
                System.out.println("=========================================   Venta de Productos   ===================================================");
                System.out.println("|| Código || "+" || Producto || "+" ||         Precio        || "+" || Disponible Para || "+" || Stock Disponible ||");
                System.out.println("--------------------------------------------------------------------------------------------------------------------");
                System.out.println("||   1    || "+" ||  Azúcar  || "+" ||         Lps.30        || "+" ||      A  y  B    || "+" ||  "+stockAzucar+" ||");
                System.out.println("--------------------------------------------------------------------------------------------------------------------");
                System.out.println("||   2    || "+" ||   Avena  || "+" ||         Lps.25        || "+" ||      A  y  B    || "+" ||   "+stockAvena+" ||");
                System.out.println("--------------------------------------------------------------------------------------------------------------------");
                System.out.println("||   3    || "+" ||   Trigo  || "+" ||         Lps.32        || "+" ||      A  y  B    || "+" ||   "+stockTrigo+" ||");
                System.out.println("--------------------------------------------------------------------------------------------------------------------");
                System.out.println("||   4    || "+" ||   Maíz   || "+" ||         Lps.20        || "+" ||      A  y  C    || "+" ||   "+stockMaiz+"  ||");
                System.out.println("=====================================================================================================================");
                    
                    
                 System.out.println("Clientes disponibles para venta:");
                 System.out.println("Cliente A"+"\nCliente B"+"\nCliente C");
                 
                 //Ciclo verificador de tipo cliente
                 boolean verificador_cliente=false;
                 String cliente="";
                 while(verificador_cliente!=true){
                     System.out.println("");
                     System.out.println("Porfavor, introduzca la letra del cliente al que desea vender(A,B,C): ");
                     String seleccionCliente= lea.next();
                     String clienteL= seleccionCliente.toLowerCase();
                     
                     if(clienteL.equalsIgnoreCase("a") || clienteL.equalsIgnoreCase("b") || clienteL.equalsIgnoreCase("c")){
                         cliente=clienteL;
                         verificador_cliente=true;
                     }else{
                         System.out.println("");
                         System.out.println("Opción inválida.");
                     }
                 }//Fin ciclo verificador de tipo cliente
                 
                 if(cliente.equals("a")){
                     //Seleccion de Cliente A
                     System.out.println("");
                     System.out.println("========= Ha seleccionado al Cliente A ==========");
                    
                    



                    //Ciclo que permite el reingreso de productos antes de facturar
                    String productList= ""; //Variable String que llevara registro de los productos seleccionados mediante la anexion de texto
                    
                    //Variable que lleva control del proceso de factuacion 
                    boolean facturar =false;
                    
                    //Ciclo que lleva control de la facturacion
                    while(facturar==false){
                       System.out.println("Porfavor, ingrese el código del producto que desea vender: ");

                      
                      if(lea.hasNextInt()){
                        int producto=lea.nextInt();

                        if(producto==1){

                           //Comprobador de stock disponible
                           if(stockAzucar<=0){
                               //Mensaje en case de no haber stock del producto seleccionado
                               System.out.println("");
                               System.out.println("Venta no realizada. No hay unidades disponibles de este producto.");
                               
                               //Ciclo Verificador de pregunta
                                boolean verificador_facturar=false;
                                String seleccion="";
                                while(verificador_facturar!=true){
                                //Pregunta para proseguir a facturar
                                System.out.println("");
                                System.out.println("¿Desea agregar otro producto? (Y/N)");

                                String selec= lea.next();
                                String seleccionL= selec.toLowerCase();
                                if(seleccionL.equalsIgnoreCase("y") || seleccionL.equalsIgnoreCase("n")){
                                    seleccion=seleccionL;
                                    verificador_facturar=true;
                                    }else{
                                        System.out.println("");
                                        System.out.println("Opción Inválida");
                                    }
                                }
                                       
                                //Evaluacion para proceder a facturar
                                if(seleccion.equals("y")){
                                System.out.println("");

                                }else{//caso respuesta de n
                                System.out.println("");

                                //Indica que se procede a la facturación 
                                facturar=true;
                                }
                               
                               
                           }else{
                            System.out.println("");
                            System.out.println("====== Informacion de producto ======");
                            System.out.println("Codigo: 1"+"\nNombre de Producto: Azucar"+"\nPrecio unitario: Lps.30");
                            
                            //Variable que lleva control del tipo de dato ingresado en cantidad
                            boolean checkkilograms=false;
                            double cantidad=0;

                            //Ciclo controlador de ingreso en kilogramos
                            while(checkkilograms!=true){
                                System.out.println("Ingrese la cantidad (en kilogramos) que desea vender de este producto: ");
                                if(lea.hasNextDouble()){
                                    cantidad= lea.nextDouble();
                                    if(cantidad<=0){
                                       System.out.println("");
                                       System.out.println("Cantidad inválida. No se aceptan cantidades negativas o iguales a 0.");
                                       
                                       
                                        
                                       
                                    }else if(cantidad>0){
                                        
                                       //Comprobante si hay una cantidad suficiente en stock para cubrir la demanda pedida por el cliente
                                       if(stockAzucar<cantidad){
                                           System.out.println("");
                                           System.out.println("No hay una cantidad suficiente para realizar la venta.");
                                           checkkilograms=true;

                                       }else{
                                           //Calculo de subtotal
                                           subtotalVenta= subtotalVenta+(cantidad*30);

                                            //Suma a cantidad de producto
                                            cantAzucar+= cantidad;

                                            //Resta la cantidad al stock existente
                                            stockAzucar= stockAzucar-cantidad;
                                            checkkilograms=true;
                                       }

                                    }
                                }else{
                                    //Caso en el que no se introduzca un valor de tipo numérico
                                   System.out.println("");
                                   System.out.println("Dato de tipo inválido. Solamente se aceptan valores numéricos.");
                                   lea.next();
                               }
                           }//Fin ciclo verificador de kilogramos


                           //Verificador del stock existente de producto
                            if(stockAzucar<0){
                                stockAzucar=0;
                            }//Este if solamente sirve para evitar que el stock quede en una cantidad negativa, si llegase a pasar.



                           
                            
                            //Ciclo Verificador de pregunta
                            boolean verificador_facturar=false;
                            String seleccion="";
                            while(verificador_facturar!=true){
                                //Pregunta para proseguir a facturar
                                System.out.println("");
                                System.out.println("¿Desea agregar otro producto? (Y/N)");
                                
                                String selec= lea.next();
                                String seleccionL= selec.toLowerCase();
                                if(seleccionL.equalsIgnoreCase("y") || seleccionL.equalsIgnoreCase("n")){
                                    seleccion=seleccionL;
                                    verificador_facturar=true;
                                }else{
                                    System.out.println("");
                                    System.out.println("Opción Inválida");
                                }
                            }
                            
                            //Evaluacion para proceder a facturar
                            if(seleccion.equals("y")){
                                System.out.println("");
                                productList= productList +("\n     1                    Azucar                   "+cantidad+"                Lps.30            Lps."+(cantidad*30));
                                
                            }else{//caso respuesta de n
                                System.out.println("");
                                productList+= ("\n     1                    Azucar                   "+cantidad+"                Lps.30            Lps."+(cantidad*30));
                                
                                
                                //Indica que se procede a la facturación 
                                facturar=true;
                            }
                           }//Fin de If de control de stock

                        }else if(producto==2){


                           //If controlador de stock 
                           if(stockAvena<=0){
                               System.out.println("");
                               System.out.println("Venta no realizada. No hay unidades disponibles de este producto.");
                               System.out.println("");
                               
                               
                               //Ciclo Verificador de pregunta
                                boolean verificador_facturar=false;
                                String seleccion="";
                                while(verificador_facturar!=true){
                                //Pregunta para proseguir a facturar
                                System.out.println("");
                                System.out.println("¿Desea agregar otro producto? (Y/N)");

                                String selec= lea.next();
                                String seleccionL= selec.toLowerCase();
                                if(seleccionL.equalsIgnoreCase("y") || seleccionL.equalsIgnoreCase("n")){
                                    seleccion=seleccionL;
                                    verificador_facturar=true;
                                    }else{
                                        System.out.println("");
                                        System.out.println("Opción Inválida");
                                    }
                                }
                                       
                                //Evaluacion para proceder a facturar
                                if(seleccion.equals("y")){
                                System.out.println("");

                                }else{//caso respuesta de n
                                System.out.println("");

                                //Indica que se procede a la facturación 
                                facturar=true;
                                }
                               
                           }else{

                           System.out.println("");
                           System.out.println("**Informacion de producto**");
                           System.out.println("Codigo: 2"+"\nNombre de Producto: Avena"+"\nPrecio unitario: Lps.25");

                           boolean checkkilograms=false;
                           double cantidad=0;

                           //Ciclo validador para ingreso de kilogramos
                           while(checkkilograms!=true){
                               System.out.println("Ingrese la cantidad (en kilogramos) que desea comprar de este producto: ");
                               if(lea.hasNextDouble()){
                                   cantidad= lea.nextDouble();
                                   if(cantidad<=0){
                                       System.out.println("");
                                       System.out.println("Cantidad Invalida. No se aceptan cantidades negativas o iguales a 0.");
                                   }else if(cantidad>0){

                                       //Condicional verificadora del stock y cantidad
                                       if(stockAvena<cantidad){
                                           System.out.println("");
                                           System.out.println("No hay una cantidad suficiente para poder realizar la venta.");
                                       }else{

                                            subtotalVenta= subtotalVenta+(cantidad*25);
                                             //Suma a cantidad de producto
                                             cantAzucar+= cantidad;

                                             //Resta la cantidad al stock del producto
                                             stockAvena= stockAvena-cantidad;
                                            checkkilograms=true;
                                       }


                                   } 
                               }else{
                                   System.out.println("");
                                   System.out.println("Opcion Invalida");
                                   lea.next();
                               }  
                           }//Fin ciclo validador para ingreso de kilogramos

                           //Verificador de cantidad existente en stock
                           if(stockAvena<0){
                               stockAvena=0;
                           }

                           //Ciclo Verificador de pregunta
                           boolean verificador_facturar=false;
                           String seleccion="";
                           while(verificador_facturar!=true){
                                //Pregunta para proseguir a facturar
                                System.out.println("");
                                System.out.println("¿Desea agregar otro producto? (Y/N)");
                                
                                String selec= lea.next();
                                String seleccionL= selec.toLowerCase();
                                if(seleccionL.equalsIgnoreCase("y") || seleccionL.equalsIgnoreCase("n")){
                                    seleccion=seleccionL;
                                    verificador_facturar=true;
                                }else{
                                    System.out.println("");
                                    System.out.println("Opción Inválida");
                                }
                            }//Fin ciclo verificador
                           
                           
                           
                            //Evaluacion para proceder a facturar
                           if(seleccion.equals("y")){
                                System.out.println("");
                                productList= productList + ("\n     2                    Avena                    "+cantidad+"                Lps.25             Lps."+(cantidad*25));//Anexion a lista de productos

                           }else{

                                System.out.println("");
                                productList= productList + ("\n     2                    Avena                    \"+cantidad+\"                Lps.25             Lps."+(cantidad*25));

                                facturar=true;
                            }

                           }//Fin if comprobador de stock

                        }else if(producto==3){


                           //If controlador de stock
                           if(stockTrigo==0){
                               System.out.println("");
                               System.out.println("Venta no realizada. No hay unidades disponibles de este producto.");
                               System.out.println("");
                               
                               //Ciclo Verificador de pregunta
                                boolean verificador_facturar=false;
                                String seleccion="";
                                while(verificador_facturar!=true){
                                //Pregunta para proseguir a facturar
                                System.out.println("");
                                System.out.println("¿Desea agregar otro producto? (Y/N)");

                                String selec= lea.next();
                                String seleccionL= selec.toLowerCase();
                                if(seleccionL.equalsIgnoreCase("y") || seleccionL.equalsIgnoreCase("n")){
                                    seleccion=seleccionL;
                                    verificador_facturar=true;
                                    }else{
                                        System.out.println("");
                                        System.out.println("Opción Inválida");
                                    }
                                }
                                       
                                //Evaluacion para proceder a facturar
                                if(seleccion.equals("y")){
                                System.out.println("");

                                }else{//caso respuesta de n
                                System.out.println("");

                                //Indica que se procede a la facturación 
                                facturar=true;
                                }
                               
                               
                               
                               
                           }else{
                           System.out.println("");
                           System.out.println("**Informacion de producto**");
                           System.out.println("Codigo: 3"+"\nNombre de Producto: Trigo"+"\nPrecio unitario: Lps.32");
                           boolean checkkilograms=false;
                           double cantidad=0;


                           //Ciclo validador de ingreso kilogramos
                           while(checkkilograms!=true){
                               System.out.println("Ingrese la cantidad (en kilogramos) que desea comprar de este producto: ");

                               if(lea.hasNextDouble()){
                                cantidad= lea.nextDouble();

                                if(cantidad<=0){
                                    System.out.println("");
                                    System.out.println("Cantidad Invalida. No se aceptan cantidades negativas o iguales a 0.");
                                }else if(cantidad>=0){


                                    if(stockTrigo<cantidad){
                                        System.out.println("");
                                        System.out.println("No hay una cantidad suficiente para realizar la venta.");
                                    }else{
                                        subtotalVenta= subtotalVenta+ (cantidad*32);

                                        //Suma a cantidad de producto
                                        cantTrigo+= cantidad;

                                        //Resta a cantidad de stock del producto
                                        stockTrigo= stockTrigo-cantidad;
                                        checkkilograms=true;
                                    }


                                }

                             }else{
                                   System.out.println("");
                                   System.out.println("Opcion Invalida");
                                   lea.next();
                               }
                           }//Fin ciclo validador de ingreso kilogramos

                           //Ciclo verificador de cantidad negativa en stock
                           if(stockTrigo<0){
                               stockTrigo=0;
                           }

                           //Ciclo Verificador de pregunta
                           boolean verificador_facturar=false;
                           String seleccion="";
                           while(verificador_facturar!=true){
                               //Pregunta para proseguir a facturar
                               System.out.println("");
                               System.out.println("¿Desea agregar otro producto? (Y/N)");
                                
                               String selec= lea.next();
                               String seleccionL= selec.toLowerCase();
                               if(seleccionL.equalsIgnoreCase("y") || seleccionL.equalsIgnoreCase("n")){
                                   seleccion=seleccionL;
                                   verificador_facturar=true;
                               }else{
                                    System.out.println("");
                                    System.out.println("Opción Inválida");
                               }
                            }//Fin ciclo verificador
                           
                           
                           
                           
                            //Evaluacion para proceder a facturar
                           if(seleccion.equals("y")){
                                System.out.println("");
                                productList= productList + ("\n     3                    Trigo                    "+cantidad+"                Lps.32             Lps."+(cantidad*32));//Anexion a lista de productos

                           }else{

                                System.out.println("");
                                productList= productList + ("\n     3                    Trigo                     "+cantidad+"                Lps.32             Lps."+(cantidad*32));

                                facturar=true;
                           }

                           }//Fin If controlador de stock

                        }else if(producto==4){

                           //If controlador de stock
                           if(stockMaiz==0){
                               System.out.println("");
                               System.out.println("Venta no realizada. No hay unidades disponibles de este producto.");
                               System.out.println("");
                               
                               //Ciclo Verificador de pregunta
                                boolean verificador_facturar=false;
                                String seleccion="";
                                while(verificador_facturar!=true){
                                //Pregunta para proseguir a facturar
                                System.out.println("");
                                System.out.println("¿Desea agregar otro producto? (Y/N)");

                                String selec= lea.next();
                                String seleccionL= selec.toLowerCase();
                                if(seleccionL.equalsIgnoreCase("y") || seleccionL.equalsIgnoreCase("n")){
                                    seleccion=seleccionL;
                                    verificador_facturar=true;
                                    }else{
                                        System.out.println("");
                                        System.out.println("Opción Inválida");
                                    }
                                }
                                       
                                //Evaluacion para proceder a facturar
                                if(seleccion.equals("y")){
                                System.out.println("");

                                }else{//caso respuesta de n
                                System.out.println("");

                                //Indica que se procede a la facturación 
                                facturar=true;
                                }
                               
                               
                               
                           }else{
                           System.out.println("");
                           System.out.println("**Informacion de producto**");
                           System.out.println("Codigo: 4"+"\nNombre de Producto: Maiz"+"\nPrecio unitario: Lps.20");

                           boolean checkkilograms=false;
                           double cantidad=0;


                           //Ciclo validador de ingreso kilogramos
                           while(checkkilograms!=true){
                               System.out.println("Ingrese la cantidad (en kilogramos) que desea comprar de este producto: ");

                               if(lea.hasNextDouble()){
                                cantidad= lea.nextDouble();
                                if(cantidad<=0){
                                    System.out.println("");
                                    System.out.println("Cantidad Invalida. No se aceptan cantidades negativas o iguales a 0.");
                                }else if(cantidad>0){

                                    if(stockMaiz<cantidad){
                                        System.out.println("");
                                        System.out.println("No hay cantidad suficiente para poder realizar la venta");
                                    }else{
                                        subtotalVenta= subtotalVenta+ (cantidad*20);

                                         //Suma a cantidad de producto
                                        cantMaiz+= cantidad;

                                        //Resta a la cantidad en stock
                                        stockMaiz=stockMaiz-cantidad;
                                        checkkilograms=true;
                                    }

                                }

                             }else{
                                   System.out.println("");
                                   System.out.println("Opcion Invalida");
                                   lea.next();
                               }
                           }//Fin ciclo validador de ingreso kilogramos


                           //Condicional regulador de cantidad en stock
                           if(stockMaiz<0){
                               stockMaiz=0;
                           }




                           //Ciclo Verificador de pregunta
                           boolean verificador_facturar=false;
                           String seleccion="";
                           while(verificador_facturar!=true){
                            //Pregunta para proseguir a facturar
                            System.out.println("");
                            System.out.println("¿Desea agregar otro producto? (Y/N)");
                                
                            String selec= lea.next();
                            String seleccionL= selec.toLowerCase();
                            if(seleccionL.equalsIgnoreCase("y") || seleccionL.equalsIgnoreCase("n")){
                                seleccion=seleccionL;
                                verificador_facturar=true;
                            }else{
                                System.out.println("");
                                System.out.println("Opción Inválida");
                                }
                            }//Fin ciclo verificador
                            
                            
                            
                            //Evaluacion para proceder a facturar
                           if(seleccion.equals("y")){
                                System.out.println("");
                                productList= productList + ("\n     4                    Maíz                    "+cantidad+"                Lps.20             Lps."+(cantidad*20));//Anexion a lista de productos
                                

                           }else{

                                System.out.println("");
                                productList= productList + ("\n     4                    Maíz                     "+cantidad+"                Lps.20             Lps."+(cantidad*20));

                                facturar=true;
                           }
                           }//Fin If controlador de stock

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



                    //Comprobador de subtotal=0
                    if(subtotalVenta==0){
                        System.out.println("");
                        System.out.println("Factura no generada. La actual venta no sumó ninguna cantidad.");
                    }else{

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
                         
                         //Incremento de numero de facturas
                         numfacturas++;
                         //Procedimiento de facturacion
                          System.out.println("");
                          System.out.println("===================================== Detalle de Factura =============================================");
                          System.out.println("No. Factura: "+numfacturas);
                          System.out.println("|| Codigo || || Descripcion de Producto || || Cantidad (Kg) || || Precio Unitario || ||    Total    ||");
                          //System.out.println("------------------------------------------------------------------------------------------------");
                          System.out.println(productList);
                          System.out.println("");
                          System.out.println("=======================================================================================================");
                          System.out.println("Subtotal: Lps."+subtotalVenta);
                          System.out.println("Descuento del "+porcentaje+"%: Lps."+descuento);
                          System.out.println("Subtotal con descuento aplicado: Lps."+subtotalaplicado);
                          System.out.println("I.S.V 7%: Lps."+impuestoRedondeado);
                          System.out.println("Total a pagar: Lps."+totalVredondeado);
                          System.out.println("");

                          //Sumatoria a caja
                          efectivoCaja= efectivoCaja+totalVenta;
                          String efectivoCajaF= String.format("%.2f",efectivoCaja);
                          System.out.println("Dinero en caja: "+efectivoCajaF);
                          System.out.println("");
                          numVentas++;
                          volVentas+=(volVentas+totalVenta);


                          //Comprobador de mayor Venta
                          if(totalVenta>mayorVenta){
                              mayorVenta=totalVenta;
                              info_mayorVenta+= "\nLa mayor venta fue de Lps."+totalVredondeado;
                          }

                    }//Fin ciclo de evaluacion de subtotal=0


                }else if(cliente.equals("b")){
                    //Mensaje de introduccion
                    System.out.println("");
                    System.out.println("========= Ha seleccionado al Cliente B ==========");
                    
 
                    boolean facturar =false;

                    String productList= ""; //Variable String que llevara registro de los productos seleccionados mediante la anexion de texto
                    while(facturar==false){
                        System.out.println("");
                        System.out.println("Porfavor, ingrese el código del producto que desea vender: ");

                    if(lea.hasNextInt()){
                     int producto=lea.nextInt();

                     if(producto==1){

                        //If controlador de Stock
                        if(stockAzucar<=0){
                            System.out.println("");
                            System.out.println("Venta no realizada. No hay unidades disponibles de este producto.");
                            System.out.println("");
                            
                            //Ciclo Verificador de pregunta
                            boolean verificador_facturar=false;
                            String seleccion="";
                            while(verificador_facturar!=true){
                            //Pregunta para proseguir a facturar
                            System.out.println("");
                            System.out.println("¿Desea agregar otro producto? (Y/N)");

                            String selec= lea.next();
                            String seleccionL= selec.toLowerCase();
                            if(seleccionL.equalsIgnoreCase("y") || seleccionL.equalsIgnoreCase("n")){
                                seleccion=seleccionL;
                                verificador_facturar=true;
                            }else{
                                System.out.println("");
                                System.out.println("Opción Inválida");
                                }
                            }
                                       
                            //Evaluacion para proceder a facturar
                            if(seleccion.equals("y")){
                            System.out.println("");

                            }else{//caso respuesta de n
                            System.out.println("");

                            //Indica que se procede a la facturación 
                            facturar=true;
                            }
                            
                            
                        }else{
                        System.out.println("");
                        System.out.println("====== Informacion de producto ======");
                        System.out.println("Codigo: 1"+"\nNombre de Producto: Azucar"+"\nPrecio unitario: Lps.30");

                        boolean checkkilograms=false;
                        double cantidad=0;


                        //Ciclo validador de ingreso kilogramos
                        while(checkkilograms!=true){
                            System.out.println("Ingrese la cantidad (en kilogramos) que desea comprar de este producto: ");

                            if(lea.hasNextDouble()){
                             cantidad= lea.nextDouble();
                             if(cantidad<=0){
                                 System.out.println("");
                                 System.out.println("Cantidad inválida. No se aceptan cantidades negativas o iguales a 0.");
                                 
                                 //Ciclo Verificador de pregunta
                                boolean verificador_facturar=false;
                                String seleccion="";
                                while(verificador_facturar!=true){
                                //Pregunta para proseguir a facturar
                                System.out.println("");
                                System.out.println("¿Desea agregar otro producto? (Y/N)");

                                String selec= lea.next();
                                String seleccionL= selec.toLowerCase();
                                if(seleccionL.equalsIgnoreCase("y") || seleccionL.equalsIgnoreCase("n")){
                                    seleccion=seleccionL;
                                    verificador_facturar=true;
                                    }else{
                                        System.out.println("");
                                        System.out.println("Opción Inválida");
                                    }
                                }
                                       
                                //Evaluacion para proceder a facturar
                                if(seleccion.equals("y")){
                                System.out.println("");

                                }else{//caso respuesta de n
                                System.out.println("");

                                //Indica que se procede a la facturación 
                                facturar=true;
                                }
                                 
                                 
                                 
                             }else if(cantidad>0){

                                 if(stockAzucar<cantidad){
                                     System.out.println("");
                                     System.out.println("No hay una cantidad suficiente para realizar la venta");
                                 }else{
                                     subtotalVenta= subtotalVenta+ (cantidad*30);

                                     //Suma a cantidad de producto
                                     cantAzucar+= cantidad;

                                     //Restar cantidad a la cantidad en stock
                                     stockAzucar=stockAzucar-cantidad;
                                     checkkilograms=true; 
                                 }

                             }

                          }else{
                                System.out.println("");
                                System.out.println("Dato de tipo inválido. Solamente se aceptan datos numéricos.");
                                lea.next();
                            }
                        }//Fin ciclo validador de ingreso kilogramos

                        //Condicional controlador de cantdiad en stock
                        if(stockAzucar<0){
                            stockAzucar=0;
                        }


                        //Ciclo Verificador de pregunta
                        boolean verificador_facturar=false;
                        String seleccion="";
                        while(verificador_facturar!=true){
                            //Pregunta para proseguir a facturar
                            System.out.println("");
                            System.out.println("¿Desea agregar otro producto? (Y/N)");
                                
                            String selec= lea.next();
                            String seleccionL= selec.toLowerCase();
                            if(seleccionL.equalsIgnoreCase("y") || seleccionL.equalsIgnoreCase("n")){
                                seleccion=seleccionL;
                                verificador_facturar=true;
                            }else{
                                System.out.println("");
                                System.out.println("Opción Inválida");
                            }
                        }//Fin ciclo verificador
                         
                         
                         //Evaluacion para proceder a facturar
                         if(seleccion.equals("y")){
                             System.out.println("");
                             productList= productList +("\n     1                    Azucar                   "+cantidad+"                Lps.30            Lps."+(cantidad*30));//Anexion a lista de productos
                         }else{

                             System.out.println("");
                             productList= productList +("\n     1                    Azucar                   "+cantidad+"                Lps.30            Lps."+(cantidad*30));
                             facturar=true;
                         }
                        }//Fin if controlador de stock

                     }else if(producto==2){

                        //If controlador de Stock

                        if(stockAvena<=0){
                            System.out.println("");
                            System.out.println("Venta no realizada. No hay unidades disponibles de este producto.");
                            System.out.println("");
                            
                            //Ciclo Verificador de pregunta
                                boolean verificador_facturar=false;
                                String seleccion="";
                                while(verificador_facturar!=true){
                                //Pregunta para proseguir a facturar
                                System.out.println("");
                                System.out.println("¿Desea agregar otro producto? (Y/N)");

                                String selec= lea.next();
                                String seleccionL= selec.toLowerCase();
                                if(seleccionL.equalsIgnoreCase("y") || seleccionL.equalsIgnoreCase("n")){
                                    seleccion=seleccionL;
                                    verificador_facturar=true;
                                    }else{
                                        System.out.println("");
                                        System.out.println("Opción Inválida");
                                    }
                                }
                                       
                                //Evaluacion para proceder a facturar
                                if(seleccion.equals("y")){
                                System.out.println("");

                                }else{//caso respuesta de n
                                System.out.println("");

                                //Indica que se procede a la facturación 
                                facturar=true;
                                }
                            
                            
                            
                            
                        }else{
                        System.out.println("");
                        System.out.println("====== Informacion de producto ======");
                        System.out.println("Codigo: 2"+"\nNombre de Producto: Avena"+"\nPrecio unitario: Lps.25");

                        boolean checkkilograms=false;
                        double cantidad=0;


                        //Ciclo validador de ingreso kilogramos
                        while(checkkilograms!=true){
                            System.out.println("Ingrese la cantidad (en kilogramos) que desea comprar de este producto: ");

                            if(lea.hasNextDouble()){
                             cantidad= lea.nextDouble();
                             if(cantidad<=0){
                                 System.out.println("");
                                 System.out.println("Cantidad inválida. No se aceptan cantidades negativas o iguales a 0.");
                                 
                             }else if(cantidad>0){
                                 if(stockAvena<cantidad){
                                     System.out.println("");
                                     System.out.println("No hay una cantidad suficiente para realizar la venta.");
                                     
                                 }else{
                                     subtotalVenta= subtotalVenta+ (cantidad*25);

                                     //Suma a cantidad de producto
                                     cantAvena+= cantidad;

                                     //Resta a la cantidad de stock
                                     stockAvena=stockAvena-cantidad;
                                     checkkilograms=true;
                                 }

                             }

                          }else{
                                System.out.println("");
                                System.out.println("Dato de tipo inválido. Solamente se acetpan datos numéricos.");
                                lea.next();
                            }
                        }//Fin ciclo validador de ingreso kilogramos

                        if(stockAvena<0){
                            stockAvena=0;
                        }

                        //Ciclo Verificador de pregunta
                        boolean verificador_facturar=false;
                        String seleccion="";
                        while(verificador_facturar!=true){
                            //Pregunta para proseguir a facturar
                            System.out.println("");
                            System.out.println("¿Desea agregar otro producto? (Y/N)");
                                
                            String selec= lea.next();
                            String seleccionL= selec.toLowerCase();
                            if(seleccionL.equalsIgnoreCase("y") || seleccionL.equalsIgnoreCase("n")){
                                seleccion=seleccionL;
                                verificador_facturar=true;
                            }else{
                                System.out.println("");
                                System.out.println("Opción Inválida");
                            }
                        }//Fin ciclo verificador
                        
                        
                         //Evaluacion para proceder a facturar
                        if(seleccion.equals("y")){
                             System.out.println("");
                             productList= productList + ("\n     2                    Avena                    "+cantidad+"                Lps.25             Lps."+(cantidad*25));//Anexion a lista de productos
                        }else{

                             System.out.println("");
                             productList= productList + ("\n     2                    Avena                    "+cantidad+"                Lps.25             Lps."+(cantidad*25));                             
                             facturar=true;
                         }
                        }//Fin If controlador de Stock

                     }else if(producto==3){

                        //If controlador de stock
                        if(stockTrigo==0){
                            System.out.println("");
                            System.out.println("Venta no realizada. No hay unidades disponibles de este producto.");
                            System.out.println("");
                            
                             //Ciclo Verificador de pregunta
                            boolean verificador_facturar=false;
                            String seleccion="";
                            while(verificador_facturar!=true){
                            //Pregunta para proseguir a facturar
                            System.out.println("");
                            System.out.println("¿Desea agregar otro producto? (Y/N)");

                            String selec= lea.next();
                            String seleccionL= selec.toLowerCase();
                            if(seleccionL.equalsIgnoreCase("y") || seleccionL.equalsIgnoreCase("n")){
                                seleccion=seleccionL;
                                verificador_facturar=true;
                            }else{
                                System.out.println("");
                                System.out.println("Opción Inválida");
                                }
                            }
                                       
                            //Evaluacion para proceder a facturar
                            if(seleccion.equals("y")){
                            System.out.println("");

                            }else{//caso respuesta de n
                            System.out.println("");

                            //Indica que se procede a la facturación 
                            facturar=true;
                            }

                            
                            
                            
                        }else{
                        System.out.println("");
                        System.out.println("====== Informacion de producto ======");
                        System.out.println("Codigo: 3"+"\nNombre de Producto: Trigo"+"\nPrecio unitario: Lps.32");

                        boolean checkkilograms=false;
                        double cantidad=0;


                        //Ciclo validador de ingreso kilogramos
                        while(checkkilograms!=true){
                            System.out.println("Ingrese la cantidad (en kilogramos) que desea comprar de este producto: ");

                            if(lea.hasNextDouble()){
                             cantidad= lea.nextDouble();
                             if(cantidad<=0){
                                 System.out.println("");
                                 System.out.println("Cantidad inválida. No se aceptan cantidades negativas o iguales a 0.");
                                 
                             }else if(cantidad>0){
                                 if(stockTrigo<cantidad){
                                     System.out.println("");
                                     System.out.println("No hay una cantidad suficiente para realizar la venta.");
                                     
                                 }else{
                                     subtotalVenta= subtotalVenta+ (cantidad*32);

                                     //Suma a cantidad de producto
                                     cantTrigo+= cantidad;

                                     //Resta de cantidad a la cantidad en stock
                                     stockTrigo=stockTrigo-cantidad;
                                     checkkilograms=true; 
                                 }

                             }

                          }else{
                                System.out.println("");
                                System.out.println("Dato de tipo inválido. Solamente se aceptan datos numéricos.");
                                lea.next();
                            }
                        }//Fin ciclo validador de ingreso kilogramos



                        //Ciclo Verificador de pregunta
                        boolean verificador_facturar=false;
                        String seleccion="";
                        while(verificador_facturar!=true){
                            //Pregunta para proseguir a facturar
                            System.out.println("");
                            System.out.println("¿Desea agregar otro producto? (Y/N)");
                                
                            String selec= lea.next();
                            String seleccionL= selec.toLowerCase();
                            if(seleccionL.equalsIgnoreCase("y") || seleccionL.equalsIgnoreCase("n")){
                                seleccion=seleccionL;
                                verificador_facturar=true;
                            }else{
                                System.out.println("");
                                System.out.println("Opción Inválida");
                            }
                        }//Fin ciclo verificador
                        
                        
                         //Evaluacion para proceder a facturar
                        if(seleccion.equals("y")){
                             System.out.println("");
                             productList= productList + ("\n     3                    Trigo                    "+cantidad+"                Lps.32             Lps."+(cantidad*32));//Anexion a lista de productos
                        }else{

                             System.out.println("");
                             productList= productList + ("\n     3                    Trigo                    "+cantidad+"                Lps.32             Lps."+(cantidad*32));
                             facturar=true;
                        }
                        }//Fin If controlador de stock

                     }else if(producto<=0){
                         System.out.println("");
                         System.out.println("Opción inválida.");
                         

                     }

                    }else{
                       System.out.println("");
                       System.out.println("Opción Inválida");
                       lea.next();
                    }


                    }//Fin Cilco While

                     //Ciclo evaluador de subtotal¿0
                     if(subtotalVenta==0){
                         System.out.println("");
                         System.out.println("Factura no generada. La actual venta no sumó ninguna cantidad.");
                     }else{
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

                        //Incremento de numero de facturas
                         numfacturas++;
                         
                        //Procedimiento de facturacion
                         System.out.println("");
                         System.out.println("===================================== Detalle de Factura =============================================");
                         System.out.println("No. Factura: "+numfacturas);
                         System.out.println("|| Codigo || || Descripcion de Producto || || Cantidad (Kg) || || Precio Unitario || ||    Total    ||");
                         System.out.println(productList);
                         System.out.println("");
                         System.out.println("=======================================================================================================");
                         System.out.println("Subtotal: Lps."+subtotalVenta);
                         System.out.println("Descuento del "+porcentaje+"%: Lps."+descuento);
                         System.out.println("Subtotal con descuento aplicado: Lps."+subtotalaplicado);
                         System.out.println("I.S.V 7%: Lps."+impuestoRedondeado);
                         System.out.println("Total a pagar: Lps."+totalVredondeado);
                         System.out.println("");




                         //Sumatoria a caja
                         efectivoCaja= efectivoCaja+totalVenta;
                         String efectivoCajaF= String.format("%.2f",efectivoCaja);
                         System.out.println("Dinero en caja: "+efectivoCajaF);
                         System.out.println("");
                         numVentas++;
                         volVentas+=(volVentas+totalVenta);


                         //Comprobador de mayor Venta
                         if(totalVenta>mayorVenta){
                            mayorVenta=totalVenta;
                            info_mayorVenta+= "\nLa mayor venta fue de Lps."+totalVredondeado;
                         }

                     }//Fin ciclo verificador de subtotal=0










                }else if(cliente.equals("c")){
                    //Mensaje de introduccion
                    System.out.println("");
                    System.out.println("========= Ha seleccionado al Cliente C ==========");
                    
                

                 boolean facturar =false;

                 String productList= ""; //Variable String que llevara registro de los productos seleccionados mediante la anexion de texto
                 while(facturar==false){

                 System.out.println("Porfavor, ingrese el código del producto que desea vender: ");

               if(lea.hasNextInt()){
                 int producto=lea.nextInt();
                 if(producto==4){

                     //If controlador de Stock
                     if(stockMaiz==0){
                         System.out.println("");
                         System.out.println("Venta no realizada. No hay unidades disponibles de este producto.");
                         System.out.println("");
                         
                          //Ciclo Verificador de pregunta
                            boolean verificador_facturar=false;
                            String seleccion="";
                            while(verificador_facturar!=true){
                            //Pregunta para proseguir a facturar
                            System.out.println("");
                            System.out.println("¿Desea agregar otro producto? (Y/N)");

                            String selec= lea.next();
                            String seleccionL= selec.toLowerCase();
                            if(seleccionL.equalsIgnoreCase("y") || seleccionL.equalsIgnoreCase("n")){
                                seleccion=seleccionL;
                                verificador_facturar=true;
                            }else{
                                System.out.println("");
                                System.out.println("Opción Inválida");
                                }
                            }
                                       
                            //Evaluacion para proceder a facturar
                            if(seleccion.equals("y")){
                            System.out.println("");

                            }else{//caso respuesta de n
                            System.out.println("");

                            //Indica que se procede a la facturación 
                            facturar=true;
                            }

                         
                         
                         
                     }

                     System.out.println("");
                     System.out.println("====== Informacion de producto ======");
                     System.out.println("Codigo: 4"+"\nNombre de Producto: Maiz"+"\nPrecio unitario: Lps.20");

                         boolean checkkilograms=false;
                         double cantidad=0;


                        //Ciclo validador de ingreso kilogramos
                        while(checkkilograms!=true){
                            System.out.println("Ingrese la cantidad (en kilogramos) que desea comprar de este producto: ");

                            if(lea.hasNextDouble()){
                             cantidad= lea.nextDouble();
                             if(cantidad<=0){
                                 System.out.println("");
                                 System.out.println("Dato de tipo inválido. No se aceptan cantidades negativas o iguales a 0.");
                             }else if(cantidad>0){


                                 if(stockMaiz<cantidad){
                                     System.out.println("");
                                     System.out.println("No hay una cantidad suficiente para realizar la venta");
                                 }else{
                                     subtotalVenta= subtotalVenta+ (cantidad*20);
                                      //Suma a cantidad de producto
                                     cantMaiz+= cantidad;

                                     //Resta la cantidad a la cantidad de stock
                                     stockMaiz=stockMaiz-cantidad;
                                     checkkilograms=true;
                                 }

                             }

                          }else{
                                System.out.println("");
                                System.out.println("Dato de tipo inválido. Solamente se aceptan datos numéricos.");
                                lea.next();
                            }
                        }//Fin ciclo validador de ingreso kilogramos


                        //Ciclo Verificador de pregunta
                        boolean verificador_facturar=false;
                        String seleccion="";
                        while(verificador_facturar!=true){
                            //Pregunta para proseguir a facturar
                            System.out.println("");
                            System.out.println("¿Desea agregar otro producto? (Y/N)");
                                
                            String selec= lea.next();
                            String seleccionL= selec.toLowerCase();
                            if(seleccionL.equalsIgnoreCase("y") || seleccionL.equalsIgnoreCase("n")){
                                seleccion=seleccionL;
                                verificador_facturar=true;
                            }else{
                                System.out.println("");
                                System.out.println("Opción Inválida");
                            }
                        }//Fin ciclo verificador
                     
                     
                     //Evaluacion para proceder a facturar
                     if(seleccion.equals("y")){
                         System.out.println("");
                         productList= productList + ("\n     4                    Maíz                    "+cantidad+"                Lps.20             Lps."+(cantidad*20));;//Anexion a lista de productos
                        }else{

                         System.out.println("");
                         productList= productList + ("\n     4                    Maíz                    "+cantidad+"                Lps.20             Lps."+(cantidad*20));;
                         facturar=true;
                         }
                 }else if(producto<=0){
                     System.out.println("");
                     System.out.println("Opción inválida.");
                 }

               }else{
                   System.out.println("");
                   System.out.println("Opción inválida.");
                   lea.next();
               }

                 }//Fin de ciclo While


                 //If verificador de subtotal=0
                 if(subtotalVenta==0){
                     System.out.println("");
                     System.out.println("Factura no generada. La actual venta no sumó ninguna cantidad.");
                 }else{

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

                    //Incremento de numero de facturas
                    numfacturas++;
                         
                    //Procedimiento de facturacion
                    System.out.println("");
                    System.out.println("===================================== Detalle de Factura =============================================");
                    System.out.println("No. Factura: "+numfacturas);
                    System.out.println("|| Codigo || || Descripcion de Producto || || Cantidad (Kg) || || Precio Unitario || ||    Total    ||");
                    System.out.println(productList);
                    System.out.println("");
                    System.out.println("=======================================================================================================");
                    System.out.println("Subtotal: Lps."+subtotalVenta);
                    System.out.println("Descuento del "+porcentaje+"%: Lps."+descuento);
                    System.out.println("Subtotal con descuento aplicado: Lps."+subtotalaplicado);
                    System.out.println("I.S.V 7%: Lps."+impuestoRedondeado);
                    System.out.println("Total a pagar: Lps."+totalVredondeado);
                    System.out.println("");

                    //Sumatoria a caja
                    efectivoCaja= efectivoCaja+totalVenta;
                    String efectivoCajaF= String.format("%.2f",efectivoCaja);
                    System.out.println("Dinero en caja: "+efectivoCajaF);
                    System.out.println("");
                    numVentas++;
                    volVentas+=(volVentas+totalVenta);


                    //Comprobador de mayor Venta
                    if(totalVenta>mayorVenta){
                        mayorVenta=totalVenta;
                        info_mayorVenta+= "\nLa mayor venta fue de Lps."+totalVredondeado;
                    }

                 }//Fin ciclo verificador subtotal=0

                }else{
                     System.out.println("Valor no valido"); 
                }

               }//Fin seccion ventas












            }else if (opcion ==3){
                //Seccion Compras
                
                
                //Interfaz de lista de productos disponibles para la venta
                System.out.println("==========================   Compra de Productos   ============================");
                System.out.println("|| Código || "+" || Producto || "+" ||         Precio        || "+" || Proveedores || ");
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("||   1    || "+" ||  Azúcar  || "+" ||         Lps.25        || "+" ||      A      || ");
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("||   2    || "+" ||   Avena  || "+" || (B)Lps.20 / (C)Lps.22  || "+" ||   B y C    || ");
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("||   3    || "+" ||   Trigo  || "+" ||         Lps.30         || "+" ||     B      || ");
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("||   4    || "+" ||   Maíz   || "+" ||         Lps.18        ||"+" ||       A      || ");
                System.out.println("===============================================================================");
                
                
                
                //Seleccion de Proveedor
                System.out.println("Proveedores disponibles para comprar: ");
                System.out.println("Proveedor A"+"\nProveedor B"+"\nProveedor C");
                
                 //Ciclo verificador de tipo proveedor
                 boolean verificador_proveedor=false;
                 String proveedor="";
                 while(verificador_proveedor!=true){
                     System.out.println("");
                     System.out.println("Porfavor, introduzca la letra del cliente al que desea vender(A,B,C): ");
                     String seleccionProveedor= lea.next();
                     String proveedorL= seleccionProveedor.toLowerCase();
                     
                     if(proveedorL.equalsIgnoreCase("a") || proveedorL.equalsIgnoreCase("b") || proveedorL.equalsIgnoreCase("c")){
                         proveedor=proveedorL;
                         verificador_proveedor=true;
                     }else{
                         System.out.println("");
                         System.out.println("Opción inválida.");
                     }
                 }//Fin ciclo verificador de tipo proveedor
                

                if(proveedor.equals("a")){
                    //Seccion para proveedor A
                    System.out.println("");
                    System.out.println("====== Ha seleccionado al Proveedor A ======");
                    
                    //Variable que lleva control de la finalización de la compra
                    boolean checkcompra=false;

                    //Ciclo que lleva contol de compra
                    while(checkcompra!=true){
                        System.out.println("Porfavor ingrese el codigo del producto que desea comprar: ");
                        if(lea.hasNextInt()){
                        int producto= lea.nextInt();

                        //Seleccion producto 1
                        if (producto==1){
                            boolean checkkilograms=false;
                            double cantidad=0;

                            //Ciclo validador de kilogramos
                            while(checkkilograms!=true){
                                System.out.println("Ingrese la cantidad (en kilogramos) que desea comprar de este producto: ");
                                if(lea.hasNextDouble()){
                                    cantidad= lea.nextDouble();
                                    if(cantidad<=0){
                                        System.out.println("");
                                        System.out.println("Cantidad Inválida. No se aceptan cantidades negativas o iguales a 0.");
                                    }else if(cantidad>0){
                                        totalproducto= cantidad*25;
                                        checkkilograms=true;
                                    }
                                }else{
                                    System.out.println("");
                                    System.out.println("Dato de tipo inválido. Solamente se aceptan valores numéricos.");
                                    lea.next();
                                }

                            }//Fin ciclo validador de kilogramos


                            //Proceso de detalles y facturacion de compra
                            if(efectivoCaja>=totalproducto){
                                System.out.println("");
                                System.out.println("====== Detalles de Compra ======");
                                System.out.println("Codigo Producto: 1"+"\nProducto: Azucar"+"\nCantidad: "+cantidad+" kilogramos"+"\nTotal: Lps."+totalproducto);
                                stockAzucar=cantidad;
                                efectivoCaja=efectivoCaja-totalproducto;
                                String efectivoCajaF= String.format("%.2f", efectivoCaja);
                                System.out.println("");
                                System.out.println("Cantidad de Efectivo en Caja: Lps."+efectivoCajaF);
                                System.out.println("=================================");
                                System.out.println("");
                                System.out.println("");
                                
                                //Se indica que la compra ha finalizado
                                checkcompra=true;
                                
                                //Se incrementa el numero de compras
                                numCompras++;
                                //Se incrementa el volumen de compras
                                volCompras+=totalproducto;

                                //Comprobador de compra mayor
                                if(totalproducto>mayorCompra){
                                    mayorCompra=totalproducto;
                                    info_mayorCompra= info_mayorCompra +"\nLa mayor compra fue de: Lps."+mayorCompra;
                                }

                            }else{
                                //Mensaje en caso que la cantidad de efectivo en caja haya sido insuficiente para realizar la compra
                                System.out.println("");
                                System.out.println("Efectivo insuficiente en caja. No se pudo pagar la compra.");
                                checkcompra=true;
                            }
                            
                        }else if(producto==4){
                            //Seleccion producto 4
                            boolean checkkilograms=false;
                            double cantidad=0;

                            //Ciclo validador de kilogramos
                            while(checkkilograms!=true){
                                System.out.println("Ingrese la cantidad (en kilogramos) que desea comprar de este producto: ");
                                if(lea.hasNextDouble()){
                                    cantidad= lea.nextDouble();
                                    if(cantidad<=0){
                                        System.out.println("");
                                        System.out.println("Cantidad Invalida. No se aceptan cantidades negativas o iguales a 0.");
                                    }else if(cantidad>0){
                                        totalproducto= cantidad*18;
                                        checkkilograms=true;
                                    }
                                }else{
                                    System.out.println("");
                                    System.out.println("Dato de tipo inválido. Solamente se aceptan valores numéricos.");
                                    lea.next();
                                }
                            }//Fin ciclo validador de kilogramos

                            //Proceso de detalles y facturación de commpra
                             if(efectivoCaja>=totalproducto){
                               System.out.println("====== Detalles de Compra ======");
                               System.out.println("Codigo Producto: 4"+"\nProducto: Maiz"+"\nCantidad"+cantidad+" kilogramos"+"\nTotal: "+totalproducto);
                               stockMaiz=cantidad;
                               efectivoCaja=efectivoCaja-totalproducto;
                               String efectivoCajaF= String.format("%.2f", efectivoCaja);
                               System.out.println("");
                               System.out.println("Cantidad de Efectivo en Caja: Lps."+efectivoCajaF);
                               System.out.println("=================================");
                               System.out.println("");
                               System.out.println("");
                               
                               //Indica que la compra ha finalizado
                               checkcompra=true;
                               
                               //Incrementa el numero de compras
                               numCompras++;
                               //Incrementa el volumen de compras
                               volCompras+=totalproducto;

                               //Comprobador de compra mayor
                                if(totalproducto>mayorCompra){
                                    mayorCompra=totalproducto;
                                    info_mayorCompra= info_mayorCompra +"\nLa mayor compra fue de: Lps."+mayorCompra;
                                }



                            }else{
                                 System.out.println("");
                                System.out.println("Efectivo insuficiente en caja. No se pudo realizar la compra.");
                                checkcompra=true;
                         }
                        }else if(producto<=0){
                            //Caso en el que se introduzca un numero negativo o igual a cero
                            System.out.println("");
                            System.out.println("Opción Invalida.");
                            
                        }else{
                            //Caso en el que se introduzca otro codigo que es distinto a los productos ofrecidos por el proveedor
                            System.out.println("");
                            System.out.println("El proveedor no vende dicho producto.");
                        }

                        }else{
                            //Caso en el que se introduzca algun caracter no numérico
                            System.out.println("");
                            System.out.println("Opción no válida. Solamente se aceptan valores tipo numérico.");
                            lea.next();
                        }//Fin evaluador

                    }//Fin ciclo while

                }else if(proveedor.equals("b")){
                    //Seleccion proveedor B
                    
                    System.out.println("");
                    System.out.println("====== Ha seleccionado al Proveedor B ======");
                 
                    //Variable que lleva control de la finalizacion de la compra
                    boolean checkcompra=false;

                    while(checkcompra!=true){
                        System.out.println("Porfavor ingrese el codigo del producto que desea comprar: ");

                        if(lea.hasNextInt()){
                        int producto= lea.nextInt();

                        if (producto==2){
                            //Seleccion producto 2

                            //Variable que lleva control de la cantidad ingresada
                            boolean checkkilograms=false;
                            double cantidad=0;

                            //Ciclo validador de kilogramos
                            while(checkkilograms!=true){
                                System.out.println("Ingrese la cantidad (en kilogramos) que desea comprar de este producto: ");
                                //Comprueba que lea contenga un dato de tipo double
                                if(lea.hasNextDouble()){
                                    cantidad= lea.nextDouble();
                                    if(cantidad<=0){
                                        //Caso en que la cantidad introducida es negativa
                                        System.out.println("");
                                        System.out.println("Cantidad Inválida. No se aceptan cantidades negativas o iguales a 0.");
                                    }else if(cantidad>0){
                                        //Caso correcto
                                        totalproducto= cantidad*20;
                                        checkkilograms=true;
                                    }
                                }else{
                                    //Caso en el que no se introduzca un dato numérico
                                    System.out.println("");
                                    System.out.println("Dato de tipo inválido. Solamente se aceptan valores numéricos.");
                                    lea.next();
                                }

                            }//Fin ciclo validador de kilogramos


                            //Proceso de detlalle y facturacion de compra
                            if(efectivoCaja>=totalproducto){
                                System.out.println("====== Detalles de Compra ======");
                                System.out.println("Codigo Producto: 2"+"\nProducto: Avena"+"\nCantidad: "+cantidad+" kilogramos"+"\nTotal: Lps."+totalproducto);
                                stockAvena=cantidad;
                                efectivoCaja=efectivoCaja-totalproducto;
                                String efectivoCajaF= String.format("%.2f", efectivoCaja);
                                System.out.println("");
                                System.out.println("Cantidad de Efectivo en Caja: Lps."+efectivoCajaF);
                                System.out.println("=================================");
                                System.out.println("");
                                System.out.println("");

                                //Indica que la compra ha finalizado
                                checkcompra=true;

                                //Incrementa el numero de compra
                                numCompras++;
                                //Incrementa el volumen de compras
                                volCompras+=totalproducto;

                                //Comprobador de compra mayor
                                if(totalproducto>mayorCompra){
                                    mayorCompra=totalproducto;
                                    info_mayorCompra= info_mayorCompra +"\nLa mayor compra fue de: Lps."+mayorCompra;
                                }



                            }else{
                                //Caso en el que no haya suficiente efectivo para realizar la compra
                                System.out.println("");
                                System.out.println("Efectivo insuficiente en caja. No se pudo pagar la compra.");
                                checkcompra=true;
                            }

                        }else if(producto==3){
                            //Seleccion de producto 3

                            //Variable que lleva control de la validacion de datos introducidos en cantidad
                            boolean checkkilograms=false;
                            double cantidad=0;

                            //Ciclo validador de kilogramos
                            while(checkkilograms!=true){
                                System.out.println("Ingrese la cantidad (en kilogramos) que desea comprar de este producto: ");

                                if(lea.hasNextDouble()){
                                    cantidad= lea.nextDouble();
                                    if(cantidad<=0){
                                        //Caso en que se introduzca una cantidad negativa
                                        System.out.println("");
                                        System.out.println("Cantidad inválida. No se aceptan cantidades negativas o iguales a 0.");
                                    }else if(cantidad>0){
                                        totalproducto= cantidad*30;
                                        checkkilograms=true;
                                    }
                                }else{
                                    //Caso en que se introduzca un dato de tipo no numérico
                                    System.out.println("");
                                    System.out.println("Dato de tipo inválido. Solamente se aceptan valores numéricos.");
                                    lea.next();
                                }
                            }//Fin ciclo validador de kilogramos

                            //Proceso de detalles y facturacion de compra
                            if(efectivoCaja>=totalproducto){
                               System.out.println("====== Detalles de Compra ======");
                               System.out.println("Codigo Producto: 3"+"\nProducto: Trigo"+"\nCantidad"+cantidad+" kilogramos"+"\nTotal: "+totalproducto);
                               stockTrigo=cantidad;
                               efectivoCaja=efectivoCaja-totalproducto;
                               String efectivoCajaF= String.format("%.2f", efectivoCaja);
                               System.out.println("");
                               System.out.println("Cantidad de Efectivo en Caja: Lps."+efectivoCajaF);
                               System.out.println("=================================");
                               System.out.println("");
                               System.out.println("");

                               //Indica que la compra ha finalizado
                               checkcompra=true;

                               //Incrementa el numero de compra
                               numCompras++;

                               //Incrementa el volumen de compra
                               volCompras+=totalproducto;


                               //Comprobador de compra mayor
                                if(totalproducto>mayorCompra){
                                    mayorCompra=totalproducto;
                                    info_mayorCompra= info_mayorCompra +"\nLa mayor compra fue de: Lps."+mayorCompra;
                                }


                            }else{
                                System.out.println("Efectivo insuficiente en caja. No se pudo pagar la compra.");
                                checkcompra=true;
                            }

                        }else if(producto<=0){
                            //Caso en el que se introduzca un dato negativo
                            System.out.println("");
                            System.out.println("Opcion Invalida");

                        }else{
                            //Caso en el que se introduzca un codigo distinto a los ofrecido por el proveedor
                            System.out.println("");
                            System.out.println("Proveedor no vende dicho producto");

                        }

                        }else{
                            //Caso en el que se introduzca un dato de tipo no numérico
                            System.out.println("");
                            System.out.println("Dato de tipo inválido. Solamente se aceptan datos de tipo numérico.");
                            lea.next();
                        }//Fin comprobador

                    }//Fin ciclo while




                }else if(proveedor.equals("c")){
                    //Seleccion proveedor C
                    
                    System.out.println("");
                    System.out.println("====== Ha seleccionado al Proveedor C ======");
                    
                    //Variable que lleva el control de compra finalizada
                    boolean checkcompra=false;


                    while(checkcompra!=true){
                    System.out.println("Porfavor ingrese el codigo del producto que desea comprar: ");
                    if(lea.hasNextInt()){
                    int producto= lea.nextInt();

                    if (producto==2){
                        //Variable que lleva control de la cantidad introducida
                        boolean checkkilograms=false;
                        double cantidad=0;

                        //Ciclo validador de kilogramos
                        while(checkkilograms!=true){
                            System.out.println("Ingrese la cantidad (en kilogramos) que desea comprar de este producto: ");

                            if(lea.hasNextDouble()){
                                cantidad= lea.nextDouble();
                                if(cantidad<=0){
                                    //Caso en el que se introduzca una cantidad negativa
                                    System.out.println("");
                                    System.out.println("Cantidad inválida. No se aceptan cantidades negativas o iguales a 0.");
                                }else if(cantidad>0){
                                    totalproducto= cantidad*22;
                                    checkkilograms=true;
                                }
                            }else{
                                System.out.println("");
                                System.out.println("Dato de tipo inválido. Solamente se aceptan valores numéricos.");
                                lea.next();
                            }

                        }//Fin ciclo validador de kilogramos


                        if(efectivoCaja>=totalproducto){
                            System.out.println("====== Detalles de Compra ======");
                            System.out.println("Codigo Producto: 2"+"\nProducto: Avena"+"\nCantidad: "+cantidad+" kilogramos"+"\nTotal: Lps."+totalproducto);
                            stockAvena=cantidad;
                            efectivoCaja=efectivoCaja-totalproducto;
                            String efectivoCajaF= String.format("%.2f", efectivoCaja);
                            System.out.println("");
                            System.out.println("Cantidad de Efectivo en Caja: Lps."+efectivoCajaF);
                            System.out.println("=================================");
                            System.out.println("");
                            System.out.println("");
                            
                            //Indica que la compra ha finalizado
                            checkcompra=true;
                            
                            //Incrementa el numero de compras
                            numCompras++;
                            
                            //Incrementa el volumen de compras
                            volCompras+=totalproducto;

                            //Comprobador de compra mayor
                            if(totalproducto>mayorCompra){
                                mayorCompra=totalproducto;
                                info_mayorCompra= info_mayorCompra +"\nLa mayor compra fue de: Lps."+mayorCompra;
                            }



                        }else{
                            //Caso que haya insuficiente efectivo
                            System.out.println("Efectivo insuficiente en caja. No se pudo pagar la compra.");
                            checkcompra=true;
                        }
                    }else if(producto<=0){
                        //Caso en el que se haya introducido un valor negativo
                        System.out.println("");
                        System.out.println("Opción inválida");
                        
                    }else{
                        //Caso en el que se haya introducido un código distinto a los que ofrezca el proveedor
                        System.out.println("");
                        System.out.println("Proveedor no vende dicho producto");
                        
                    }
                    }else{
                        System.out.println("");
                        System.out.println("Dato de tipo inválido. Solamente se aceptan datos de tipo numérico.");
                        lea.next();
                    }//Fin seccion validacion 

                    }//Fin ciclo While

                }else {
                    //Caso que no coincida con los proveedores
                    System.out.println("Opción no válida. Porfavor, vuelva a intentar.");
                }//Fin parte 3

            }else if (opcion == 4){

                //Seccion reporte

                //Validador para no realizar reporte en caso que toda la informacion se encuentre en 0
                if(numCompras==0 && numVentas==0){
                    System.out.println("");
                    System.out.println("Reporte no disponible. Porfavor, realize por lo menos una compra o venta para generar reporte.");
                    System.out.println("");
                }else{

                     //Calculo de margen de ganancias
                     double margenganancia=(volVentas-volCompras);
                     String margengananciaF= String.format("%.2f",margenganancia);

                     //Calculo de promedios
                     double promedio_Ventas=(volVentas/numVentas);
                     double promedio_Compras=(volCompras/numCompras);

                     //Formateo de variables necesarios
                     String promedio_VentasF= String.format("%.2f",promedio_Ventas);
                     String promedio_ComprasF=String.format("%.2f",promedio_Compras);



                     //Determinar lo que es el producto estrella
                     if(cantAzucar>cantAvena && cantAzucar>cantTrigo && cantAzucar>cantMaiz){
                         cantEstrella=cantAzucar;
                         producto_Estrella=" Azucar con "+cantAzucar+" kg vendidos";
                     }else if(cantAvena>cantAzucar && cantAvena>cantTrigo && cantAvena>cantMaiz){
                         cantEstrella=cantAvena;
                          producto_Estrella=" Avena con "+cantAvena+" kg vendidos";
                     }else if(cantTrigo>cantAzucar && cantTrigo>cantAvena && cantTrigo>cantMaiz){
                         cantEstrella=cantTrigo;
                         producto_Estrella=" Trigo con "+cantTrigo+" kg vendidos";
                     }else if(cantMaiz>cantAzucar && cantMaiz>cantAvena && cantMaiz>cantTrigo){
                         cantEstrella=cantMaiz;
                         producto_Estrella=" Maiz con "+cantMaiz+" kg vendidos";
                     }else{
                         producto_Estrella=" Ninguno";
                     }

                     //Efectivo caja reducido a dos decimales
                     String efectivoCajaF= String.format("%.2f", efectivoCaja);
                     String mayorVentaF=String.format("%.2f",mayorVenta);
                     String mayorCompraF=String.format("%.2f", mayorCompra);

                     //Impresion de reporte
                     System.out.println("");
                     System.out.println("================ REPORTE =================");
                     System.out.println("Cantidad Actual en Caja: Lps."+efectivoCajaF);
                     System.out.println("");
                     System.out.println("No. Compras Realizadas: "+numCompras);
                     System.out.println("No. Ventas Realizadas: "+numVentas);
                     System.out.println("");
                     System.out.println("Volumen de Compras: Lps."+volCompras);
                     System.out.println("Volumen de Ventas: Lps."+volVentas);
                     System.out.println("Margen de ganancia: Lps."+margengananciaF);
                     System.out.println("");
                     System.out.println("Promedio Ventas: Lps."+promedio_VentasF);
                     System.out.println("Promedio Compras: Lps."+promedio_ComprasF);
                     System.out.println("");
                     System.out.println("La mayor venta fue de: Lps."+mayorVentaF);
                     System.out.println("");
                     System.out.println("La mayor compra fue de: Lps."+mayorCompraF);
                     System.out.println("");
                     System.out.println("Producto Estrella: "+producto_Estrella);
                     System.out.println("");
                     System.out.println("===========================================");
                     System.out.println("");

                }//Fin validador para habilitar reportes








            }else if (opcion ==5){

                //Incremento de dia
                numDia++;
                
                //Redondeo del efectivo en caja
                String efectivoCajaF= String.format("%.2f", efectivoCaja);


                //Calculo del tope de deposito a banco del 60%
                double topeCaja=(efectivoCaja*0.6);
                boolean statusDeposito=false;

                System.out.println("");
                System.out.println("======= Cierre de Dia "+numDia+" =======");
                System.out.println("Cantidad de Efectivo en Caja: Lps."+efectivoCajaF);
                System.out.println("");


                //Ciclo que lleva control del ingreso a banco
                while(statusDeposito==false){
                System.out.println("Especifique el porcentaje del efectivo de caja a depositar en el banco. Porcentaje Máximo 60%: ");

                //Agregar validacion asi 
                if(lea.hasNextInt()){
                 double depositoIngreso=lea.nextDouble();

                 if(depositoIngreso<=0){
                     System.out.println("");
                     System.out.println("Cantidad Invalida. No se aceptan valores menores o iguales a 0.");

                 }else if(depositoIngreso<=topeCaja){
                    double depositoReal=(efectivoCaja*(depositoIngreso/100));
                    efectivoBanco+=depositoReal;
                    efectivoCaja+=-depositoReal;
                    System.out.println("");    
                    System.out.println("Deposito realizado con éxito");
                    System.out.println("");
                    statusDeposito=true;
                 }else{
                     System.out.println("");
                     System.out.println("Cantidad Invalida. La cantidad excede el tope del 60%.");
                 }

                 }else{
                     System.out.println("");
                     System.out.println("Valor invalido. Solamente se aceptan valores numéricos.");
                     lea.next();
                 }

                }//Fin ciclo while


                String efectivoBancoF= String.format("%.2f",efectivoBanco);
                System.out.println("");
                System.out.println("Efectivo acumulado en Banco: Lps."+efectivoBancoF);
                System.out.println("Cantidad de efectivo en Caja: "+efectivoCajaF);
                System.out.println("");

                statusPrograma=false;








            }else if (opcion ==6){
                System.out.println("");
                System.out.println("======== Satus Programa: Cerrado ======== ");
                controladorDias=false;
                break; 
            }   

            controladorApertura=false;

          }
    }//Final controlador de Dias  
        
        
    }//Final Main
    
    
   }
    
