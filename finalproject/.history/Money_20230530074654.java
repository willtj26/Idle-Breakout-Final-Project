public class Money {
    private int amount;

    public Money(int initialAmount) {
        amount = initialAmount;
    }

    public int getAmount() {
        return amount;
    }

    public void decreaseAmount(int value) {
        amount -= value;
    }
    public void increaseAmount(int value) {
        amount += value;
    }
}