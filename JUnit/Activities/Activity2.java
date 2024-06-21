import activities.Activity2.BankAccount;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class Activity2 {
    @Test
    void notEnoughFunds(){
        BankAccount account = new BankAccount(9);
        assertThrows(activities.Activity2.NotEnoughFundsException.class, ()-> account.withdraw(10), "Balance Must be greater than the amount of withdrawal");


    }

    @Test
    void enoughFunds(){
        BankAccount account = new BankAccount(100);
        assertDoesNotThrow(()->account.withdraw(100))
    }
}
