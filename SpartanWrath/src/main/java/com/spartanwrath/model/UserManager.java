package com.spartanwrath.model;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    // Map para almacenar los usuarios
    private static final Map<String, User> usersMap = new HashMap<>();
    // Map para almacenar nombres de usuario y contraseñas para autenticación
    private static final Map<String, String> credentialsMap = new HashMap<>();

    // Inicialización de usuarios y contraseñas iniciales
    static {
        User user1 = new User(1, "Nombre1", "usuario1", "email1@example.com", "Dirección1", "123456789", "type1", "contraseña1", "01/01/2000", "123456789X", "pago1");
        User user2 = new User(2, "Nombre2", "usuario2", "email2@example.com", "Dirección2", "987654321", "type2", "contraseña2", "02/02/2000", "987654321Y", "pago2");
        User admin = new User(3, "Admin", "admin", "admin@example.com", "Dirección Admin", "999999999", "admin", "admin123", "03/03/2000", "000000000Z", "pagoAdmin");

        usersMap.put(user1.getUsername(), user1);
        usersMap.put(user2.getUsername(), user2);
        usersMap.put(admin.getUsername(), admin);

        credentialsMap.put(user1.getUsername(), user1.getPassword());
        credentialsMap.put(user2.getUsername(), user2.getPassword());
        credentialsMap.put(admin.getUsername(), admin.getPassword());
    }

    // Método para agregar un usuario
    public static void addUser(User user) {
        usersMap.put(user.getUsername(), user);
        credentialsMap.put(user.getUsername(), user.getPassword());
    }

    // Método para eliminar un usuario
    public static void removeUser(String username) {
        usersMap.remove(username);
        credentialsMap.remove(username);
    }

    // Método para verificar si un usuario está autenticado
    public static boolean authenticate(String username, String password) {
        String storedPassword = credentialsMap.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }

    // Método para verificar si un usuario es administrador
    public static boolean isAdmin(String username) {
        User user = usersMap.get(username);
        return user != null && "admin".equals(user.getType());
    }
}
