package U2.L2.fm.view;

import U2.L2.fm.model.interfaces.GUI;

import java.util.Scanner;

/**
 * Created by Ксения on 18.03.2016.
 */
public class ConsoleView {
    private final Scanner sc;
    private final GUI controller;

    public ConsoleView(GUI controller) {
        this.sc = new Scanner(System.in);
        this.controller = controller;

    }

    public void start(){
        System.out.println("Вас приветствует Финансовый менеджер. ");
        System.out.println("Выберите действие (введите номер пункта): ");
        System.out.println("1. Войти в личный кабинет.");
        System.out.println("2. Зарегистрироваться.");
        int i = Integer.valueOf(getMessage());
        switch (i){
            case 1: { //авторизоваться
                sendMessage("Введите логин: ");
                String login = getMessage();
                sendMessage("Введите пароль: ");
                String password = getMessage();
                if (controller.authenticate(login, password)) {
                    sendMessage("Авторизация прошла успешно!");
                } else {
                    sendMessage("Неверный логин/пароль");
                }
            }
            break;
            case 2: {
                sendMessage("Введите логин: ");
                String login = getMessage();
                sendMessage("Введите пароль: ");
                String password = getMessage();
                if (!controller.register(login, password)) {
                    sendMessage("Пользователь с таким логином уже существует.");
                } else
                    sendMessage("Вы успешно зарегистрировались!");
            }
            break;

        }

    }

    private String getMessage(){
        return sc.nextLine();
    }

    private void sendMessage(String message) {
        System.out.println(message);
    }



}
