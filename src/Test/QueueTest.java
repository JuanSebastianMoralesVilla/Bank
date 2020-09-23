package Test;

import data_structures.*;
import org.junit.Assert;


import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @org.junit.jupiter.api.Test
    public void enqueue() {

        Queue <String> cola = new Queue<>();
        cola.enqueue("hola");
        boolean empty = cola.isEmpty();

        Assert.assertEquals(false,empty);



       int test = 8;

       int test2 = 8;

        Assert.assertEquals(test,test2);

    }

    @org.junit.jupiter.api.Test
    void dequeue() {
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        Queue <String> cola = new Queue<>();
        boolean empty = cola.isEmpty();

        Assert.assertEquals(empty,true);
    }
}