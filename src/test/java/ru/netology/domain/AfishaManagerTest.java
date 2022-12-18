package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AfishaManagerTest {

    String item1 = "Бладшот";
    String item2 = "Вперед";
    String item3 = "Отель Белград";
    String item4 = "Джентельмены";
    String item5 = "Человек-невидимка";
    String item6 = "Тролли.Мировой тур";
    String item7 = "Номер один";
    String item8 = "Любовное письмо";
    String item9 = "Чук и Гек";
    String item10 = "Песнь моря";
    String item11 = "Чебурашка";
    int maxLimit;

    @Test
    public void shouldNew() {
        AfishaManager afisha = new AfishaManager();

        String[] expected = new String[0];
        String[] actual = afisha.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNewWithParameter() {
        AfishaManager afisha = new AfishaManager(6);

        String[] expected = new String[0];
        String[] actual = afisha.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddItem() {
        AfishaManager afisha = new AfishaManager();
        afisha.addItem(item1);
        afisha.addItem(item2);

        String[] expected = {item1, item2};
        String[] actual = afisha.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldAddItemsToNull() {
        AfishaManager afisha = new AfishaManager();
        String[] items = {item3, item4, item5, item6, item7, item8};
        afisha.addItems(items);

        String[] expected = items;
        String[] actual = afisha.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddItemsToItems() {
        AfishaManager afisha = new AfishaManager();
        afisha.addItem(item1);
        afisha.addItem(item2);
        String[] items = {item3, item4, item5, item6, item7, item8};
        afisha.addItems(items);

        String[] expected = {item1, item2, item3, item4, item5, item6, item7, item8};
        String[] actual = afisha.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


    // тесты для метода findLast()
    // - вывод максимального лимита последних добавленных фильмов в обратном от добавления порядке -
    // если значение максимального лимита задано пользователем
    @Test
    public void shouldFindLastWithParameterLessDefault() {
        maxLimit = 6;
        String[] items = {item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11};
        AfishaManager afisha = new AfishaManager(maxLimit);
        afisha.addItems(items);

        String[] expected = {item11, item10, item9, item8, item7, item6};
        String[] actual = afisha.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWithParameterMoreDefault() {
        maxLimit = 16;
        String[] items = {item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11};
        AfishaManager afisha = new AfishaManager(maxLimit);
        afisha.addItems(items);
        afisha.addItems(items);

        String[] expected = {item11, item10, item9, item8, item7, item6, item5, item4, item3, item2, item1, item11, item10, item9, item8, item7};
        String[] actual = afisha.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWithParameterEqualsDefault() {
        maxLimit = 10;
        String[] items = {item1, item2, item3, item4, item5, item6, item7, item8, item9, item10};
        AfishaManager afisha = new AfishaManager(maxLimit);
        afisha.addItems(items);

        String[] expected = {item10, item9, item8, item7, item6, item5, item4, item3, item2, item1};
        String[] actual = afisha.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    // тесты для метода findLast()
    // - вывод максимального лимита последних добавленных фильмов в обратном от добавления порядке -
    // если значение максимального лимита задано по умолчанию
    @Test
    public void shouldFindLastLessDefault() {
        String[] items = {item1, item2, item3, item4, item5, item6};
        AfishaManager afisha = new AfishaManager();
        afisha.addItems(items);

        String[] expected = {item6, item5, item4, item3, item2, item1};
        String[] actual = afisha.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastMoreDefault() {
        String[] items = {item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11};
        AfishaManager afisha = new AfishaManager();
        afisha.addItems(items);
        afisha.addItems(items);

        String[] expected = {item11, item10, item9, item8, item7, item6, item5, item4, item3, item2};
        String[] actual = afisha.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastEqualsDefault() {
        String[] items = {item1, item2, item3, item4, item5, item6, item7, item8, item9, item10};
        AfishaManager afisha = new AfishaManager();
        afisha.addItems(items);

        String[] expected = {item10, item9, item8, item7, item6, item5, item4, item3, item2, item1};
        String[] actual = afisha.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
