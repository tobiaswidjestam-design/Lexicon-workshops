package se.lexicon.workshops.week45;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*
 * JUnit 5 migration — what changed compared to the JUnit 4 version, and why:
 *
 *  1. pom.xml: junit:junit 4.13.2  ->  org.junit.jupiter:junit-jupiter 5.14.4
 *     4.13.2 was the last JUnit 4 release (February 2021) and JUnit 4 is in
 *     maintenance mode. Maven Surefire is pinned to 3.x so the new tests are
 *     actually discovered — older defaults only understand JUnit 4 and would
 *     report "0 tests" without failing the build.
 *
 *  2. Imports:
 *       org.junit.Before            -> org.junit.jupiter.api.BeforeEach
 *       org.junit.Test              -> org.junit.jupiter.api.Test
 *       org.junit.Assert.assertEquals -> org.junit.jupiter.api.Assertions.assertEquals
 *     The argument order is unchanged: assertEquals(expected, actual).
 *
 *  3. jdk.jfr.Description -> org.junit.jupiter.api.DisplayName
 *     @Description comes from Java Flight Recorder (the profiling API) and never
 *     affected these tests; @DisplayName is what actually shows in the report.
 *
 *  4. shouldRejectInvalidCoin: the empty try/catch is replaced by assertThrows(...).
 *     With JUnit 4 that test passed even if insertCoin() had silently accepted the
 *     coin, because the exception was swallowed before the assertion ran.
 *
 * Nothing else changed: same seven tests, same inputs, same expected values.
 */

public class VendingMachineTests {
    private VendingMachine vendingMachine;

    @BeforeEach
    public void setup() {
        vendingMachine = new VendingMachine();
    }

    @Test
    @DisplayName("Given: balance = 0 When: insertCoin(10) Then: balance = 10")
    public void shouldInsertValidCoin() {
        assertEquals(0, vendingMachine.getBalance());
        vendingMachine.insertCoin(10);
        assertEquals(10, vendingMachine.getBalance());
    }

    @Test
    @DisplayName("Given: balance = 0 When: insertCoin(7) Then: balance stays 0")
    public void shouldRejectInvalidCoin() {
        assertEquals(0, vendingMachine.getBalance());

        // assertThrows fails the test if no exception is thrown.
        assertThrows(IllegalArgumentException.class, () -> vendingMachine.insertCoin(7));

        assertEquals(0, vendingMachine.getBalance());
    }

    @Test
    @DisplayName("Given: product price = 20, quantity = 3, balance = 0 When: insertCoin(20), purchaseProduct(id) Then: purchase returns the product, balance = 0, quantity = 2")
    public void shouldBePurchaseSuccess() {
        Product product = new Snack(4, "Cookies", 20, 3, 220);
        vendingMachine.addProduct(product);
        vendingMachine.insertCoin(20);
        vendingMachine.purchaseProduct(4);

        assertEquals(2, product.getQuantity());
        assertEquals(0, vendingMachine.getBalance());
    }

    @Test
    @DisplayName("Given: product price = 20, balance = 10 When: purchaseProduct(id) Then: purchase fails, balance stays 10, quantity unchanged")
    public void shouldFailOnInsufficientBalance() {
        Product product = new Snack(4, "Cookies", 20, 10, 220);
        vendingMachine.addProduct(product);
        vendingMachine.insertCoin(10);
        vendingMachine.purchaseProduct(4);
        assertEquals(10, vendingMachine.getBalance());
        assertEquals(10, product.getQuantity());
    }

    @Test
    @DisplayName("Given: quantity = 0, balance >= price When: purchaseProduct(id) Then: purchase fails, balance unchanged, quantity stays 0")
    public void shouldFailSinceOutOfStock() {
        Product product = new Snack(4, "Cookies", 20, 0, 220);
        vendingMachine.addProduct(product);
        vendingMachine.insertCoin(50);
        vendingMachine.purchaseProduct(4);

        assertEquals(50, vendingMachine.getBalance());
        assertEquals(0, product.getQuantity());
    }

    @Test
    @DisplayName("Given: balance = 50 When: returnChange() Then: returns 50, balance = 0")
    public void shouldReturnChange() {
        vendingMachine.insertCoin(50);
        assertEquals(50, vendingMachine.cancel());
        assertEquals(0, vendingMachine.getBalance());
    }

    @Test
    @DisplayName("Given: machine has 3 products added When: getProducts() Then: list size = 3")
    public void shouldHaveThreeProducts() {
        assertEquals(3, vendingMachine.getProducts().size());
    }
}
