import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    Account account = new Account();

    @Test
    public void testDeposit() {
        account.deposit(100);
        assertEquals(100, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdraw() {
        account.deposit(100);
        assertEquals(50, account.withdraw(50), 0.01);
        assertEquals(50, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdrawOverdraft() {
        account.deposit(100);
        assertEquals(0, account.withdraw(200), 0.01);
        assertEquals(100, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdrawNegativeAmount() {
        account.deposit(100);
        try {
            account.withdraw(-50);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals(100, account.getBalance(), 0.01);
        }
    }

    @Test
    public void testDepositNegativeAmount() {
        try {
            account.deposit(-50);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals(0, account.getBalance(), 0.01);
        }
    }

    @Test
    public void testGetBalance() {
        assertEquals(0, account.getBalance(), 0.01);
    }
}