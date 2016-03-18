package U2.L1.L2.ex2.view;

import U2.L1.L2.ex2.controller.ConsoleController;

import java.util.Scanner;

/**
 * Created by Ксения on 18.03.2016.
 */
public class ConsoleView {
    private final Scanner sc;

    public ConsoleView() {
        this.sc = new Scanner(System.in);

    }

    public void show(){
        System.out.println("Вас приветствует Финансовый менеджер. ");
        System.out.println("Выберите действие (введите номер пункта): ");
        System.out.println("1. Войти в личный кабинет.");
        System.out.println("2. Зарегистрироваться.");

    }

    public String getMessage(){
        return sc.nextLine();
    }

    public void sendMessage(String message) {
        System.out.println(message);
    }



}
