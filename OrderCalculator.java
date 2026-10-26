import java.util.Scanner;

public class OrderCalculator {
    private static final int MAX_QUANTITY = 10000;
    private static final double MAX_PRICE = 5_000_000;
    private static final double MAX_DISCOUNT = 30;
    private static final double VAT_RATE = 20;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Количество: ");
        int quantity = sc.nextInt();
        System.out.print("Цена за единицу: ");
        double price = sc.nextDouble();
        System.out.print("Скидка, %: ");
        double discount = sc.nextDouble();

        if (!isValid(quantity, price, discount)) {
            System.out.println("Ошибка: количество 1..10000, цена > 0 и не более 5000000, скидка 0..30.");
            return;
        }
        double base = calculateBase(quantity, price);
        double afterDiscount = applyDiscount(base, discount);
        double vat = calculateVat(afterDiscount, VAT_RATE);
        System.out.printf("Базовая сумма: %.2f руб.%n", base);
        System.out.printf("После скидки: %.2f руб.%n", afterDiscount);
        System.out.printf("НДС: %.2f руб.%n", vat);
        System.out.printf("Итого: %.2f руб.%n", afterDiscount + vat);
    }

    public static double calculateBase(int quantity, double price) {
        return quantity * price;
    }

    public static double applyDiscount(double base, double percent) {
        return base - base * percent / 100;
    }

    public static double calculateVat(double amount, double rate) {
        return amount * rate / 100;
    }

    public static boolean isValid(int quantity, double price, double discount) {
        return quantity > 0 && quantity <= MAX_QUANTITY
                && price > 0 && price <= MAX_PRICE
                && discount >= 0 && discount <= MAX_DISCOUNT;
    }
}
