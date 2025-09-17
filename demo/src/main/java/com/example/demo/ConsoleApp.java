package com.example.demo;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleApp implements CommandLineRunner {

    private final AuthService authService;

    public ConsoleApp(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nВыберите действие: 1 - Регистрация, 2 - Вход, 0 - Выход");
            String choice = scanner.nextLine();

            if ("0".equals(choice)) {
                System.out.println("Выход...");
                break;
            }

            System.out.print("Введите имя пользователя: ");
            String username = scanner.nextLine();
            System.out.print("Введите пароль: ");
            String password = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    if (authService.register(username, password)) {
                        System.out.println("Пользователь зарегистрирован");
                    } else {
                        System.out.println("Такой пользователь уже существует");
                    }
                }
                case "2" -> {
                    if (authService.login(username, password)) {
                        System.out.println("Вход выполнен");
                    } else {
                        System.out.println("Неверный логин или пароль");
                    }
                }
                default -> System.out.println("Некорректный выбор");
            }
        }
    }
}