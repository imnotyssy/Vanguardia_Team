
package Modelo;

import java.util.Scanner;


public class Tickets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ticket ticket = new Ticket();

        System.out.println("=== GENERADOR DE TICKETS ===");
        while (true) {
            System.out.print("Ingrese nombre del producto (o 'fin' para terminar): ");
            String nombre = sc.nextLine();
            if (nombre.equalsIgnoreCase("fin")) break;

            System.out.print("Cantidad: ");
            int cantidad = Integer.parseInt(sc.nextLine());

            System.out.print("Precio unitario: ");
            double precio = Double.parseDouble(sc.nextLine());

            ticket.agregarProducto(new Producto(nombre, cantidad, precio));
        }

        ticket.imprimirTicket();
        sc.close();
    }
}

