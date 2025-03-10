package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private Product[] productBasket = new Product[5];


    public void addProduct(Product product) {
        for (int i = 0; i < productBasket.length; i++) {
            if (productBasket[i] == null) {
                productBasket[i] = product;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }

    public int fullPriceBasket() {
        int fullPrice = 0;
        for (Product product : productBasket) {
            if (product != null) {
                fullPrice += product.getProductPrice();
            }
        }
        return fullPrice;
    }

    public void printContentBasket() {
        for (Product product : productBasket) {
            if (product != null) {
                System.out.println(product);
            }
        }
        if (fullPriceBasket() == 0) {
            System.out.println("В корзине пусто");
        } else {
            System.out.printf("Итого: %s рублей\n", fullPriceBasket());
        }
    }

    public boolean nameProductBasket(String productName) {
        for (Product product : productBasket) {
            if (product != null && product.getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void cleanBasket() {
        Arrays.fill(productBasket, null);
    }
}
