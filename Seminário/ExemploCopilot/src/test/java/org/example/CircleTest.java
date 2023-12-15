package org.example;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @org.junit.jupiter.api.Test
    void getArea() {
        // test the getArea() method
        Circle circle = new Circle(567);
        assertEquals(Math.PI * 567 * 567, circle.getArea());
    }

    @org.junit.jupiter.api.Test
    void getCircumference() {
        // test the getCircumference() method
        Circle circle = new Circle(5);
        assertEquals(31.41592653589793, circle.getCircumference());
    }

    @org.junit.jupiter.api.Test
    void getDiameter() {
        // test the getDiameter() method
        Circle circle = new Circle(5);
        assertEquals(10, circle.getDiameter());
    }
}