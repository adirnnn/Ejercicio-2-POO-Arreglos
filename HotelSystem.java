// Adrián López 231361
// Programación Orientada a Objetos

import java.util.ArrayList;
import java.util.Scanner;

public class HotelSystem {
    private ArrayList<Room> rooms;           // Lista de habitaciones disponibles en el hotel
    private ArrayList<Customer> waitingList; // Lista de clientes en lista de espera
    private Scanner scanner;                 // Objeto para leer entrada del usuario

    public HotelSystem() {
        rooms = new ArrayList<>();           // Inicializa la lista de habitaciones
        waitingList = new ArrayList<>();     // Inicializa la lista de clientes en espera
        scanner = new Scanner(System.in);    // Inicializa el objeto Scanner para entrada
    }

    public void start() {
        // Inicializa las habitaciones con números, capacidades y precios
        rooms.add(new Room(101, 2, 100));
        rooms.add(new Room(102, 3, 150));
        rooms.add(new Room(103, 4, 200));

        while (true) {
            showMenu(); // Muestra el menú principal
        }
    }

    public void showMenu() {
        System.out.println("1. Recibir Invitado");           // Opción para recibir un huésped
        System.out.println("2. Asignar Invitado a Habitación"); // Opción para asignar cliente a habitación
        System.out.print("Seleccione una opción: ");
        String choice = scanner.nextLine(); // Lee la opción elegida por el usuario

        switch (choice) {
            case "1":
                receiveGuest();           // Llama al método para recibir un huésped
                break;
            case "2":
                assignCustomerToRoom();   // Llama al método para asignar cliente a habitación
                break;
            default:
                System.out.println("Opción Invalida. Por Favor Seleccione Otra Vez.");
        }
    }

    public void receiveGuest() {
        System.out.print("Ingrese el Nombre del Invitado: ");
        String name = scanner.nextLine();    // Lee el nombre del huésped
        System.out.print("Inrese el Número de Visitas: ");
        int visits = Integer.parseInt(scanner.nextLine()); // Lee el número de visitas del huésped
        Customer customer = new Customer(name, visits);   // Crea un objeto Customer con los datos ingresados
        waitingList.add(customer);            // Agrega el huésped a la lista de espera
        System.out.println("Invitado ha sido Agregado a la Lista de Espera para ser Asignado.");
    }

    public void assignCustomerToRoom() {
        for (Room room : rooms) {
            if (!room.isOccupied()) {
                System.out.println(room.getRoomInfo()); // Muestra información de habitaciones disponibles
            }
        }

        System.out.print("Ingrese el Número de la Habitación a Asignar: ");
        int roomNumber = Integer.parseInt(scanner.nextLine()); // Lee el número de habitación a asignar
        Customer customer = findCustomer();   // Busca al cliente en la lista de espera

        if (customer != null) {
            for (Room room : rooms) {
                if (room.getRoomNumber() == roomNumber && room.assignOccupant(customer)) {
                    // Si la habitación se asigna con éxito, muestra el mensaje
                    System.out.println("Invitado " + customer.getName() + " asignado a habitación " + room.getRoomNumber() + ".");
                    return;
                }
            }
            System.out.println("Habitación No Disponible.");
        } else {
            System.out.println("Invitado No Encontrado.");
        }
    }

    public Customer findCustomer() {
        System.out.print("Ingrese el nombre del invitado: ");
        String name = scanner.nextLine(); // Lee el nombre del cliente a buscar
        for (Customer customer : waitingList) {
            if (customer.getName().equals(name)) {
                waitingList.remove(customer); // Elimina al cliente de la lista de espera
                return customer;              // Retorna el cliente encontrado
            }
        }
        return null; // Si no se encuentra al cliente, retorna null
    }

    public static void main(String[] args) {
        HotelSystem hotelSystem = new HotelSystem(); // Crea una instancia del sistema del hotel
        hotelSystem.start();                        // Inicia el sistema
    }
}
