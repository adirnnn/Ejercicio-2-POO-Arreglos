// Adrián López 231361
// Programación Orientada a Objetos

public class Customer {
    private String name;     // Nombre del cliente
    private int visits;      // Número de veces que el cliente ha visitado el hotel

    public Customer(String name, int visits) {
        // Constructor de la clase Customer que recibe el nombre y número de visitas del cliente
        this.name = name;         // Asigna el nombre del cliente
        this.visits = visits;     // Asigna el número de visitas del cliente
    }

    public boolean isRegular() {
        // Método que verifica si el cliente es regular (menos de 5 visitas)
        return visits < 5;        // Retorna true si el cliente tiene menos de 5 visitas, false de lo contrario
    }

    public boolean isFrequent() {
        // Método que verifica si el cliente es frecuente (entre 5 y 9 visitas)
        return visits >= 5 && visits < 10; // Retorna true si el cliente tiene entre 5 y 9 visitas, false de lo contrario
    }

    public boolean isVIP() {
        // Método que verifica si el cliente es VIP (10 o más visitas)
        return visits >= 10;      // Retorna true si el cliente tiene 10 o más visitas, false de lo contrario
    }

    public String getInfo() {
        // Método que devuelve información del cliente
        return "Nombre: " + name + ", Visitas: " + visits; // Retorna una cadena con el nombre y número de visitas del cliente
    }

    public String getName() {
        // Método para obtener el nombre del cliente
        return name;              // Retorna el nombre del cliente
    }
}