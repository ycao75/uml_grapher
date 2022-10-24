package fr.lernejo;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SampleTest {

    @Test
    void additionpp() {
        int a = 2;
        int b = 3;

        int sum = Sample.op(Sample.Operation.ADD, a, b);
        Assertions.assertThat(sum).as("add of 2 + 3").isEqualTo(5);}

    @Test
    void additionnp() {
        int a = -2;
        int b = 3;

        int sum = Sample.op(Sample.Operation.ADD, a, b);
        Assertions.assertThat(sum).as("add of -2 + 3").isEqualTo(1);}

    @Test
    void additionnn() {
        int a = -2;
        int b = -3;

        int sum = Sample.op(Sample.Operation.ADD, a, b);
        Assertions.assertThat(sum).as("add of -2 + -3").isEqualTo(-5);}

    @Test
    void produitpp() {
        int a = 2;
        int b = 3;
        int product = Sample.op(Sample.Operation.MULT, a, b);
        Assertions.assertThat(product).as("multiply of 2 * 3")
            .isEqualTo(6);}
    @Test
    void produitnp() {
        int a = -2;
        int b = 3;
        int product = Sample.op(Sample.Operation.MULT, a, b);
        Assertions.assertThat(product).as("multiply of -2 * 3")
            .isEqualTo(-6);}
    @Test
    void produitnn() {
        int a = -2;
        int b = -3;
        int product = Sample.op(Sample.Operation.MULT, a, b);
        Assertions.assertThat(product).as("multiply of -2 * -3")
            .isEqualTo(6);}

    @Test
    void factorial_of_negative2_producce_exception(){
        int n= -2;
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> Sample.fact(n));
    }

    @Test
    void factorial_of_1_equals_1() {
        int n = 1;
        int factorial = Sample.fact(n);

        Assertions.assertThat(factorial).as("factorial of -1").isEqualTo(1);
    }

}
