import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

//Clase que contiene todos las variables usados en todo el programa//
class variables {
    static List<String> liPeticion = new ArrayList<>();
    static List<String> liReclamos = new ArrayList<>();
    static List<String> liQuejas = new ArrayList<>();
    static List<String> liEvaluaciones = new ArrayList<>();
    static Map<String, String> personal = new HashMap<>();
    static int cargo, pqr, me, inf, info;
    static String cargo_eva, evaluaciones,Comentario, peticion, quejas, reclamos, passw, respuesta_vigilante, respuesta_mesero, nombre_mesero, respuesta_cocinero, respuesta_cajero; 
}


public class funciones {     
    public void evaluaSastifi_process(Scanner scan) {
        System.out.println(" ");
        System.out.print("Ingrese el numero correspondiente al cargo (1-5):");
        variables.cargo = scan.nextInt();
    
        if (1 <= variables.cargo && variables.cargo <= 5) {
            System.out.print("Ingrese la puntuación del servicio (1-5): ");
            int puntuacion = scan.nextInt();
    
            if (puntuacion >= 1 && puntuacion <= 5) {
                System.out.print("Ingrese su Comentario: ");
                scan.nextLine(); 
                variables.Comentario = scan.nextLine();
    
                switch (variables.cargo) {
                    case 1:
                        variables.cargo_eva = "vigilante";
                        break;
                    case 2:
                        variables.cargo_eva = "Mesero Juan";
                        break;
                    case 3:
                        variables.cargo_eva = "Mesero Andres";
                        break;
                    case 4:
                        variables.cargo_eva = "Cocinero";
                        break;
                    case 5:
                        variables.cargo_eva = "Cajero";
                        break;
                    default:
                        System.out.println("Te has equivocado");
                        return;
                }
                variables.evaluaciones = String.format("Se realizó una evaluación al cargo de %s, tuvo una puntuación de %d, y colocó este comentario: %s",
                variables.cargo_eva, puntuacion, variables.Comentario);
                variables.liEvaluaciones.add(variables.evaluaciones);
            } else {
                System.out.println("La puntuación no está dentro del rango de 1 a 5");
            }
        } else {
            System.out.println("una opción incorrecta, vuelva a intentarlo...");
        }
    }
    

    

    public void pqr_process(Scanner scan){
        System.out.print("Ingrese el numero correspondiente a la accion que desea realizar (1-3):  ");
        variables.pqr = scan.nextInt();
        if (variables.pqr == 1) {
            System.out.print("Ingrese su Peticion: ");
            scan.nextLine();
            variables.peticion = scan.nextLine();
            variables.liPeticion.add(variables.peticion);
        } else if (variables.pqr == 2) {
            System.out.print("Ingrese su quejas: ");
            scan.nextLine(); 
            variables.quejas = scan.nextLine();
            variables.liQuejas.add(variables.quejas);
        } else if (variables.pqr == 3) {
            System.out.print("Ingrese su reclamo: ");
            scan.nextLine();
            variables.reclamos = scan.nextLine();
            variables.liReclamos.add(variables.reclamos);
        } else {
            System.out.println("Ingreso un numero incorrecto.");
        }
    }
    

    public void servicio_personal(){
        System.out.println(" ");
        System.out.println("""
                Bienvenido al Menu del Servicio del personal"
                1. Capacitacion de aprendizaje
                2. Diagnostico
                """);
    }
    
    public static void capacitacion_aprendizaje(Scanner scan){
        menu.CapacitacionMenu();
        System.out.println(" ");
        System.out.print("Ingrese el numero correspondiente al cargo: ");
        variables.cargo = scan.nextInt();
    
        if (variables.cargo == 1) {
            capacitacion.vigilante_capacitacion();
        } else if (variables.cargo == 2) {
            capacitacion.mesero_capacitacion();
        } else if (variables.cargo == 3) {
            capacitacion.cocinero_capacitacion();
        } else if (variables.cargo == 4) {
            capacitacion.cajero_capacitacion();
        } else {
            System.out.println("Error Ingreso el codigo incorrecto");
        }
    }
    
    
    public static void servicio_personal_process(Scanner scan){
                menu.diagnosticoMenu();
                System.out.print("Cual el numero correspondiente al cargo (1-4): ");
                variables.cargo = scan.nextInt();

                if (variables.cargo == 1) {
                    System.out.print("Cual es la regla cuartenta de seguridad implementada en la induccion?: ");
                    scan.nextLine();
                    variables.respuesta_vigilante = scan.nextLine();
                    variables.personal.put("vigilante",variables.respuesta_vigilante);
                }else if (variables.cargo == 2) {
                    System.out.print("Comor realizar el proceso para llevar un plato a una mesa?: ");
                    scan.nextLine();
                    variables.respuesta_mesero = scan.nextLine();
                    variables.personal.put("mesero", variables.respuesta_mesero);

                    System.out.print("Cual fue el mesero que realizo la encuesta: ");
                    variables.nombre_mesero = scan.nextLine();
                    variables.personal.put("nombre_mesero", variables.nombre_mesero);
                    /*meter respuesta al diccionario*/ 

                }else if (variables.cargo == 3) {
                    System.out.print("Como son las medidas de biodeseguridad: ");
                    scan.nextLine();
                    variables.respuesta_cocinero = scan.nextLine();
                    variables.personal.put("cocinero", variables.respuesta_cocinero);
                }else if (variables.cargo == 4) {
                    System.out.print("Como se hace para abrir la caja registradora?: ");
                    scan.nextLine();
                    variables.respuesta_cajero = scan.nextLine();
                    variables.personal.put("cajero", variables.respuesta_cajero);
                }else {
                    System.out.println("Error Ingreso el codigo Incorrecto");
                }
    }

    public static void inf_diag_process(Scanner scan){
        /*Colocar las keys del diccionario */
        variables.personal.put("vigilante", "");
        variables.personal.put("mesero", "");
        variables.personal.put("nombre_mesero", "");
        variables.personal.put("cocinero", "");
        variables.personal.put("cajero", "");


        System.out.println("¿Cual respuesta desea saber su informacion? ");
        variables.inf = scan.nextInt();

        if (variables.inf == 1) { 
            System.out.println("la respuesta es: " + variables.respuesta_vigilante );
        }else if (variables.inf == 2) {
            String valornombre = variables.personal.get("nombre_mesero");
            System.out.println("la respuesta es: " + variables.respuesta_mesero + " esta fue ingresada por el mesero" + valornombre);
        }else if (variables.inf == 3) {
            System.out.println("la respuesta es: " + variables.respuesta_cocinero );
        }else if (variables.inf == 4) {
            System.out.println("la respuesta es: " + variables.respuesta_cocinero );
        }else if (variables.inf == 5) {
            String valorCajero = variables.personal.get("cajero");
            System.out.println("la respuesta es: " + valorCajero );
        }
    }


    public static void muestra_informacion_process(Scanner scan) {
        System.out.print("Que informacion deseas saber (1-5)?: ");
        variables.info = scan.nextInt();

        if (variables.info == 1) {
            for (int i = 0; i < variables.liEvaluaciones.size(); i++){
                System.out.println("-" + variables.liEvaluaciones.get(i));
            }
        }else if (variables.info == 2) {
            for (int i = 0; i < variables.liPeticion.size(); i++){
                System.out.println("-" + variables.liPeticion.get(i));
            }
        }else if (variables.info == 3) {
            for (int i = 0; i < variables.liReclamos.size(); i++){
                System.out.println("-" + variables.liReclamos.get(i));
            }
        }else if (variables.info == 4) {
            for (int i = 0; i < variables.liQuejas.size(); i++){
                System.out.println("-" + variables.liQuejas.get(i));
            }
        }else if (variables.info == 5) {
            menu.muestra_inf_diag();
            funciones.inf_diag_process(scan);
        }else {
            System.out.println("opcion no valida");
        }
    }

}

//Clase que contiene todos los menus (metodos o funciones) //
class menu {
    public static void menuPrincipal() {
        System.out.println(" ");
        System.out.println("==== Menú ====");
        System.out.println("1. Servicio al Cliente    "); 
        System.out.println("2. Apartado del Personal");
        System.out.println("3. Apartado del Gerente");
        System.out.println("4. Salir\n");

    }

    public static void evaluacionSatisfaccion(){
        System.out.println(" ");
        System.out.println("""
            1. Vigilante
            2. Mesero Juan
            3. Mesero Andres
            4. Cocinero
            5. Cajero
                """);
    }

    public static void pqr(){
        System.out.println(" ");
        System.out.println("""
                1. Peticiones
                2. Quejas
                3. Reclamos
                """);
    }

    public static void menuCliente() {
        System.out.println("""
                Bienvenido al Menú del Servicio al Cliente!!
                1. Realizar una Evaluación de Satisfacción
                2. P.Q.R""");        
    }
    public static void muestra_informacion(){
        System.out.println("""
            1. Evaluaciones realizadas
            2. Peticiones
            3. Reclamos
            4. Quejas
            5. Respuestas de los diagnósticos
                """);
    }
    public static void muestra_inf_diag(){
        System.out.println("""
            1. Respuesta que ingresó el Vigilante. 
            2. Respuesta que ingresó el Mesero
            3. Respuesta que ingresó el Cocinero
            4. Respuesta que ingresó el Cajero
                """);
    }

    public static void servicio_personal(){
        System.out.println(" ");
        System.out.println("""
                Bienvenido al Menu del Servicio del personal"
                1. Capacitacion de aprendizaje
                2. Diagnostico
                """);
    }

    public static void diagnosticoMenu() {
        System.out.println("""
                Escoja el Cargo para realizar el diagonostico:
                1. Vigilante
                2. Mesero
                3. Cocinero
                4. Cajero
                """);
    }

    public static void CapacitacionMenu(){
        System.out.println("""
                Escoja el cargo para realizar la Capacitacion :
                1. Vigilante
                2. Mesero
                3. Cocinero
                4. Cajero
                """);
    }
}

class contraseñas {
    public void contraseña(Scanner scan){
        System.out.print("Ingrese la contraseña para ingresar el menu del personal: ");
        scan.nextLine();
        variables.passw = scan.nextLine();
        if (variables.passw.equals("personalonly")) { 
            System.out.println();
            menu.servicio_personal();
            System.out.print("Digite el numero correspondiente a la accion que desea realizar (1-2): ");
            variables.me = scan.nextInt();
            if (variables.me == 1) {
                funciones.capacitacion_aprendizaje(scan);
            } else if (variables.me == 2) {
                funciones.servicio_personal_process(scan);
            } else {
                System.out.println("La Contraseña es incorrecta...");
            }
        }else {
            System.out.println(" ");
            System.out.println("La Contraseña es incorrecta...");
        }
    }
    

    public void contraseña2(Scanner scan){
        System.out.print("Ingrese la contraseña para ingresar el menu del gerente: ");
        scan.nextLine();
        variables.passw = scan.nextLine();
        
        if (variables.passw.equals("gerenteonly")) {
            System.out.println("Bienvenido al Menu del gerente ");
            menu.muestra_informacion();
            funciones.muestra_informacion_process(scan);
        }else {
            System.out.println(" ");
            System.out.println("La Contraseña es incorrecta...");
        }
        
    }
}
class capacitacion {
    public static void vigilante_capacitacion(){
        System.out.println("""

        Vigilante:
        Presentación de la empresa: Introduce la historia, valores y misión de la empresa.
        Roles y responsabilidades: Explica las funciones específicas del vigilante, incluyendo seguridad, monitoreo de cámaras, control de accesos, y protocolos de emergencia.
        Procedimientos de seguridad: Detalla los protocolos de seguridad, manejo de situaciones de emergencia, procedimientos de evacuación y manejo de equipos de seguridad.
        Normativas internas: Informa sobre políticas de la empresa, reglamentos internos y procedimientos para reportar incidentes.
        """);
    }

    public static void mesero_capacitacion(){
        System.out.println("""

            Mesero:
            Conocimiento del restaurante: Presenta el restaurante, su historia, menú, filosofía de servicio y público objetivo.
            Roles y responsabilidades: Describe las tareas del mesero, incluyendo atención al cliente, toma de pedidos, manejo de bandejas, servicio de alimentos y bebidas, y procedimientos de limpieza.
            Entrenamiento en servicio al cliente: Enseña técnicas de atención al cliente, manejo de situaciones difíciles, y cómo garantizar una experiencia positiva para los comensales.
            Normativas de higiene y seguridad: Detalla las regulaciones de seguridad alimentaria, normas de higiene, manejo de alimentos y procedimientos de limpieza""");
    }

    public static void cocinero_capacitacion(){
        System.out.println("""

            Cajero:
            Presentación del área: Introduce el área de caja, sistemas de pago, y procedimientos de facturación.
            Roles y responsabilidades: Describe las funciones del cajero, incluyendo manejo de efectivo, cobro a clientes, cierre y apertura de caja, y registro de transacciones.
            Manejo de sistemas y tecnología: Entrena en el uso de sistemas de punto de venta (POS), manejo de tarjetas de crédito/débito, y procesos de devolución y cambios.
            Políticas financieras: Informa sobre políticas de devolución, descuentos, manejo de errores y procedimientos para evitar fraudes.  
        """);
    }

    public static void cajero_capacitacion(){
        System.out.println(""" 

            Cocinero:
            Introducción a la cocina: Presenta la cocina, sus áreas, equipos, y cómo se organiza el trabajo.
            Roles y responsabilidades: Explica las responsabilidades del cocinero, desde la preparación de ingredientes hasta la elaboración de platos, siguiendo recetas y estándares de calidad.
            Higiene y seguridad alimentaria: Enseña normativas de manipulación de alimentos, procedimientos de limpieza, seguridad en el manejo de equipos y protocolos de emergencia en la cocina.
            Conocimiento de menú y calidad: Introduce el menú, la presentación de platos y la importancia de mantener altos estándares de calidad en la cocina.   
        """);
    }
}