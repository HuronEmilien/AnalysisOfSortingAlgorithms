package main.swing.utils;

public class Sextet<A, B, C, D, E, F> {
    
    private final A first;
    private final B second;
    private final C third;
    private final D fourth;
    private final E fifth;
    private final F sixth;

    public Sextet(A first, B second, C third, D fourth, E fifth, F sixth) {
        this.fifth = fifth;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.first = first;
        this.sixth = sixth;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    public C getThird() {
        return third;
    }

    public D getFourth() {
        return fourth;
    }

    public E getFifth() {
        return fifth;
    }

    public F getSixth() {
        return sixth;
    }

    @Override
    public String toString() {
        return "(" +
                first + "," +
                second + "," +
                third + "," +
                fourth + "," +
                fifth + "," +
                sixth + "," +
                ')';
    }
    
}
