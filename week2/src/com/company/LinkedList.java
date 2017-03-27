package com.company;

/**
 * Created by dima on 16.03.17.
 */
public class LinkedList {
    Node head;
    Node tail;
    int count;

    /* Конструктор без аргументів */
    public LinkedList() {
        head = null;
        tail = null;
        count = 0;
    }

    /* Додати елемент в кінець списку */
    public void add(Integer data) {
        Node newNode = new Node();
        newNode.setNext(null);
        newNode.setData(data);

        if (head != null)
        {    if (tail != null)
                tail.setNext(newNode);
            else
                head.setNext(newNode);

            tail = newNode;
        }
        else
            head = newNode;

        count++;
    }

    /* Отримати елемент по індексу, повертає null якщо такий елемент недоступний */
    public Integer get(int index) {
        Node node = head;

        for (int i = 0; i < index && node != null;i++)
            node = node.getNext();

        return node.getData();
    }

    /* Вилучення елементу за індексом, повертає true у разі успіху або false в іншому випадку */
    public boolean delete(int index) {
        Node node = head;

        if (index != 0)
        {
            for (int i = 0; i < index - 1 && node != null; i++)
                node = node.getNext();

            if (node != null) {
                if (node.getNext() != null)
                    node.setNext(node.getNext().getNext());
                else
                    node.setNext(null);

                count--;
                return true;
            }
            else
                return false;
        }
        else
        {
            if (head != null) {
                head = node.getNext();
                node = null;
                count --;
                return true;
            }
            else
                return false;
        }
    }

    /*Поверта розмір списку: якщо елементів в списку нема то повертає 0 (нуль)*/
    public int size() {
        return count;
    }
}
