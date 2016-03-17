package U2.L1.L2.ex1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Сергеева on 17.03.2016.
 *
 */
public class GenericStackTest {
    GenericStack<Integer> stack;

    @Before
    public void setUp() throws Exception{
        stack = new GenericStack<>(5);
    }

    @After
    public void tearDown() throws Exception{

    }

    @Test
    public void testPush() throws Exception {
        stack.push(22);
        assertEquals(22, stack.peek().intValue());
    }

    @Test
    public void testPop() throws Exception{
        stack.push(4);
        assertEquals(4, stack.pop().intValue());
    }

    @Test
    public void testGetSize() throws Exception{
        stack.pushAll(Arrays.asList(4, 5, 8, 7));
        assertEquals(4, stack.getSize());
    }

    @Test
    public void testIsEmpty() throws Exception{
        assertTrue(stack.getSize() == 0);
    }

    @Test
    public void testPeek() throws Exception{
        stack.pushAll(Arrays.asList(4,5,7));
        assertEquals(7, stack.peek().intValue());
    }

    @Test(expected = StackException.class)
    public void testIsFullStack() throws StackException {
            stack.pushAll(Arrays.asList(4,5,7,8,9,10));
    }

    @Test(expected = StackException.class)
    public void testIsEmptyStack() throws StackException {
         stack.pop();
    }


}