package fr.lernejo;

import org.junit.jupiter.api.Assertions;

class SampleTest {

    @org.junit.jupiter.api.Test
    void op() {
        Sample toto = new Sample();
        Assertions.assertEquals(toto.op(Sample.Operation.ADD, 1, 5), 6);
        Assertions.assertEquals(toto.op(Sample.Operation.ADD, 0, 0), 0);

        Assertions.assertEquals(toto.op(Sample.Operation.MULT, 1, 5), 5);
        Assertions.assertEquals(toto.op(Sample.Operation.MULT, 0, 0), 0);
    }

    @org.junit.jupiter.api.Test
    void fact() {
        Sample toto = new Sample();

        Assertions.assertEquals(toto.fact(3), 6);
        Assertions.assertEquals(toto.fact(0), 1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> toto.fact(-1));
    }
}
