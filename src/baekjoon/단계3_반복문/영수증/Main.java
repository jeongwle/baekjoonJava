package baekjoon.단계3_반복문.영수증;

/*
백준 25304
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int TOTAL = scanner.nextInt();
        final Product[] products = new Product[scanner.nextInt()];
        for (int i = 0; i < products.length; i++) {
            final int price = scanner.nextInt();
            final int number = scanner.nextInt();
            products[i] = new Product(price, number);
        }
        final ReceiptDecipher receiptDecipher = new ReceiptDecipher(TOTAL, products);
        receiptDecipher.printResult();
    }
}

class Product {
    private final int PRICE;
    private final int NUMBER;

    Product(int price, int number) {
        if (!validatePrice(price) || !validateNumber(number)) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
        this.PRICE = price;
        this.NUMBER = number;
    }

    private boolean validatePrice(int price) {
        return (price >= 1 && price <= 1_000_000);
    }

    private boolean validateNumber(int number) {
        return (number >= 1 && number <= 10);
    }

    public int getTotal() {
        return (this.PRICE * this.NUMBER);
    }
}
class ReceiptDecipher {
    private final int TOTAL;
    private final Product[] products;

    ReceiptDecipher(int total, Product[] products) {
        if (!validateTotal(total)) {
            throw new RuntimeException("잘못된 입력입니다.");
        }
        this.TOTAL = total;
        this.products = products;
    }

    private boolean validateTotal(int total) {
        return (total >= 1 && total <= 1_000_000_000);
    }

    private boolean checkReceiptValidation() {
        return (this.TOTAL == this.getProductsTotal());
    }

    private int getProductsTotal() {
        int productsTotal = 0;
        for (Product product : this.products) {
            productsTotal += product.getTotal();
        }
        return productsTotal;
    }

    public void printResult() {
        String result = checkReceiptValidation() ? "Yes" : "No";
        System.out.println(result);
    }
}
