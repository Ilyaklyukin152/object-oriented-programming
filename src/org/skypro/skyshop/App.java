package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        SimpleProduct apple = new SimpleProduct("Яблоко", 50);
        SimpleProduct potato = new SimpleProduct("Картофель", 20);
        FixPriceProduct buckwheat = new FixPriceProduct("Гречка");
        DiscountedProduct pasta = new DiscountedProduct("Макароны", 100, 10);
        SimpleProduct salt = new SimpleProduct("Соль", 10);
        FixPriceProduct sugar = new FixPriceProduct("Сахар");
        SimpleProduct orange = new SimpleProduct("Апельсин", 140);
        DiscountedProduct sausage = new DiscountedProduct("Колбаса", 250, 15);
        DiscountedProduct milk = new DiscountedProduct("Молоко", 90, 20);

        ProductBasket basket1 = new ProductBasket();
        ProductBasket basket2 = new ProductBasket();

        System.out.println("Демонстрация методов");

        System.out.println("Добавление продукта в корзину.");
        basket1.addProduct(apple);
        basket1.addProduct(milk);
        basket1.addProduct(apple);
        basket1.addProduct(sugar);
        basket1.addProduct(orange);
        basket2.addProduct(potato);
        basket2.addProduct(buckwheat);
        basket2.addProduct(pasta);
        basket2.addProduct(salt);
        basket2.addProduct(sausage);

        System.out.println("Добавление продукта в заполненную корзину, в которой нет свободного места.");
        basket1.addProduct(orange);

        System.out.println("Получение стоимости корзины с несколькими товарами.");
        System.out.printf("Итого: %s рублей\n", basket1.fullPriceBasket());

        System.out.println("Печать содержимого корзины с несколькими товарами.");
        System.out.println("Корзина 1");
        basket1.printContentBasket();
        System.out.println("Корзина 2");
        basket2.printContentBasket();

        System.out.println("Поиск товара, который есть в корзине.");
        System.out.println(basket1.nameProductBasket("Молоко"));

        System.out.println("Поиск товара, которого нет в корзине.");
        System.out.println(basket1.nameProductBasket("Картофель"));

        System.out.println("Очистка корзины.");
        basket1.cleanBasket();

        System.out.println("Печать содержимого пустой корзины.");
        basket1.printContentBasket();

        System.out.println("Получение стоимости пустой корзины.");
        System.out.printf("Итого: %s рублей\n", basket1.fullPriceBasket());

        System.out.println("Поиск товара по имени в пустой корзине.");
        System.out.println(basket1.nameProductBasket("Яблоко"));
    }
}