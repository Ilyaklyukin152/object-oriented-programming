package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product apple = new Product("Яблоко", 50);
        Product potato = new Product("Картофель", 20);
        Product buckwheat = new Product("Гречка", 80);
        Product pasta = new Product("Макароны", 100);
        Product salt = new Product("Соль", 10);
        Product sugar = new Product("Сахар", 60);
        Product orange = new Product("Апельсин", 140);
        Product sausage = new Product("Колбаса", 250);
        Product milk = new Product("Молоко", 90);

        ProductBasket basket1 = new ProductBasket();

        System.out.println("Демонстрация методов");

        System.out.println("Добавление продукта в корзину.");
        basket1.addProduct(apple);
        basket1.addProduct(milk);
        basket1.addProduct(apple);
        basket1.addProduct(sugar);
        basket1.addProduct(orange);

        System.out.println("Добавление продукта в заполненную корзину, в которой нет свободного места.");
        basket1.addProduct(orange);

        System.out.println("Получение стоимости корзины с несколькими товарами.");
        System.out.printf("Итого: %s рублей\n", basket1.fullPriceBasket());

        System.out.println("Печать содержимого корзины с несколькими товарами.");
        basket1.printContentBasket();

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