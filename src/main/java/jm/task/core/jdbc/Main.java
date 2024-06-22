package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        Util.getConnection();
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Alex","Stepanov", (byte) 21);
        userService.saveUser("Helen","Chernyshova", (byte) 22);
        userService.saveUser("Kirill","Antonov", (byte) 50);
        userService.saveUser("Ilya","Stroev", (byte) 80);
        userService.getAllUsers();
        userService.removeUserById(2);
        userService.getAllUsers();
        userService.cleanUsersTable();
    }
}
