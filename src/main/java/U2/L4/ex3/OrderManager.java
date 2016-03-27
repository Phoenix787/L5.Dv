package U2.L4.ex3;

public class OrderManager {
    MailSender mailSender;

//    public OrderManager() {
//        this.mailSender = new MailSender(); //ТАК НЕ ДЕЛАЕМ!!!!
//    }

    public OrderManager(MailSender mailSender) {
        this.mailSender = mailSender;
    }
}
