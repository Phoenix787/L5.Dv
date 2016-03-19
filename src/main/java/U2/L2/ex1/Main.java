package U2.L1.L2.ex1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * Created by Ксения on 16.03.2016.
 *
 */
public class Main {
    final static Logger logger = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) throws StackException {
        GenericStack<Integer> stack = new GenericStack<>(5);


        stack.push(5);
        stack.push(3);
        stack.push(1);
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("size stack is " + stack.getSize());
        ArrayList<Integer> src = new ArrayList<>();
        src.add(12);
        src.add(14);
        src.add(16);

        logger.info("It is write");

        stack.pushAll(src);
        System.out.println(stack);




    }


}
