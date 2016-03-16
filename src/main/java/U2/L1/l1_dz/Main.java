package U2.L1.l1_dz;

/**
 * Created by Ксения on 16.03.2016.
 *
 */
public class Main {

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
        System.out.println(stack.pop());


    }
}
