package ru.netology.domain;

public class AfishaManager {
    private String[] items = new String[0];
    private int maxLimitLast = 10;

    public AfishaManager() {
    }

    public AfishaManager(int maxLimitLast) {
        this.maxLimitLast = maxLimitLast;
    }

    public void addItem(String item) {
        String[] tmp = new String[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public void addItems(String[] items) {
        String[] tmp = new String[this.items.length + items.length];
        for (int i = 0; i < this.items.length; i++) {
            tmp[i] = this.items[i];
        }
        int j = this.items.length;
        for (int i = 0; i < items.length; i++) {
            tmp[j] = items[i];
            j++;
        }
        this.items = tmp;
    }

    public String[] findAll() {
        return this.items;
    }

    public String[] findLast() {
        int resultLength;
        if (items.length < maxLimitLast) {
            resultLength = items.length;
        } else {
            resultLength = maxLimitLast;
        }
        String[] lasted = new String[resultLength];
        for (int i = 0; i < lasted.length; i++) {
            lasted[i] = items[items.length - 1 - i];
        }
        return lasted;
    }

}
