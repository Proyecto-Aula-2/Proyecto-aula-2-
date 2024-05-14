import java.util.Scanner;

public class accion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        funciones fs = new funciones();
        contraseñas cs = new contraseñas();
        boolean ejecutando = true;
        
        do {
            menu.menuPrincipal();
            System.out.print("Ingrese la opción que desea realizar: ");
            int option = scan.nextInt();
            System.out.println(" ");
            switch (option) {
                case 1:
                    menu.menuCliente();
                    System.out.print("Elija (1) para Realizar una Evaluación de Satisfacción o (2) para ingresar un P.Q.R: ");
                    int subOption = scan.nextInt();
                    scan.nextLine(); 
                    if (subOption == 1) {
                        menu.evaluacionSatisfaccion();
                        fs.evaluaSastifi_process(scan);
                    } else if (subOption == 2) {
                        menu.pqr();
                        fs.pqr_process(scan);
                    } else {
                        System.out.println("Ingresó una opción incorrecta.");
                    }
                    break;
                case 2:
                    cs.contraseña(scan);
                    break;
                case 3:
                    cs.contraseña2(scan);
                    break;
                case 4:
                    System.out.println("¡Gracias por usar el programa!");
                    ejecutando = false;
                    break;
                default:
                    System.out.println("Ingresó una opción incorrecta.");
            }
        } while (ejecutando);
        
        scan.close();
    }
}
