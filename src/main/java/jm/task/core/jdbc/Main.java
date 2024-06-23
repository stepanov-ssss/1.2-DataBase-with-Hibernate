package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        Util.getSessionFactory();
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Alex", "Stepanov", (byte) 25);
        userService.saveUser("Helen", "Chernyshova", (byte) 26);
        userService.saveUser("Kirill", "Antonov", (byte) 50);
        userService.saveUser("Ilia", "Stroev", (byte) 80);
        userService.removeUserById(2);
        userService.getAllUsers()   ;
//        userService.dropUsersTable();
//        userService.cleanUsersTable();
    }
}
