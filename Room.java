// Adrián López 231361
// Programación Orientada a Objetos

public class Room {
    private int roomNumber;         // Número único de la habitación
    private int capacity;           // Capacidad máxima de ocupantes en la habitación
    private double pricePerNight;   // Precio por noche de la habitación
    private Customer occupant;      // Referencia al cliente que ocupa la habitación (null si está desocupada)

    public Room(int roomNumber, int capacity, double pricePerNight) {
        this.roomNumber = roomNumber;               // Asigna el número de habitación
        this.capacity = capacity;                   // Asigna la capacidad de la habitación
        this.pricePerNight = pricePerNight;         // Asigna el precio por noche
        this.occupant = null;                       // Inicializa el ocupante como null (habitación desocupada)
    }

    public boolean isOccupied() {
        // Método que verifica si la habitación está ocupada
        return occupant != null;                   // Retorna true si hay un ocupante asignado, false si está desocupada
    }

    public boolean assignOccupant(Customer customer) {
        // Método para asignar un cliente a la habitación
        if (!isOccupied()) {
            // Verifica si la habitación está desocupada
            occupant = customer;                   // Asigna al cliente como ocupante
            return true;                           // Retorna true para indicar que la asignación fue exitosa
        }
        return false;                              // Retorna false si la habitación ya está ocupada
    }

    public String getRoomInfo() {
        // Método que devuelve información de la habitación
        return "Número de Habitación: " + roomNumber + ", Capacidad: " + capacity + ", Precio por Noche: " + pricePerNight;
    }

    public int getRoomNumber() {
        // Método para obtener el número de la habitación
        return roomNumber;                         // Retorna el número único de la habitación
    }
}
