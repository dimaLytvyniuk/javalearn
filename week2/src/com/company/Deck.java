package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by dima on 16.03.17.
 */
public class Deck {
    Card cards[];
    int size;

    public Deck()
    {
        cards = new Card[36];

        for (int i = 0, counter = 0; i < 4;i++)
            for (int j = 0; j < 9;j++) {
                cards[counter++] = new Card(Rank.values[j], Suit.values[i]);
            }
        size = 36;
    }
    //Перемішує колоду у випадковому порядку
    public void shuffle() {
        Random random = new Random();

        for (int i = size - 1, j; i > 0;i--) {
            j = random.nextInt(i + 1);
            Card prom = cards[i];
            cards[i] = cards[j];
            cards[j] = prom;
        }
    }
    /* * Впорядкування колоди за мастями та значеннями
    * Порядок сотрування:
    * Спочатку всі карти з мастю HEARTS, потім DIAMONDS, CLUBS, SPADES
    * для кожної масті порядок наступний: Ace,King,Queen,Jack,10,9,8,7,6
    * Наприклад
    * HEARTS Ace
    * HEARTS King
    * HEARTS Queen
    * HEARTS Jack
    * HEARTS 10
    * HEARTS 9
    * HEARTS 8
    * HEARTS 7
    * HEARTS 6
    * І так далі для DIAMONDS, CLUBS, SPADES */
    public void order() {
        ArrayList<Card> hearts = new ArrayList<Card>();
        ArrayList<Card> diamonds = new ArrayList<Card>();
        ArrayList<Card> clubs = new ArrayList<Card>();
        ArrayList<Card> spades = new ArrayList<Card>();

        for (int i = 0; i < size;i++) {
            int index = 0;
            String suit = cards[i].getSuit().getName();

            for (int l = 0; l < 4;l++)
            {
                if (suit == Suit.values[l].getName())
                    index = l;
            }
            switch (index) {
                case 0:
                    hearts.add(cards[i]);
                    break;
                case 1:
                    diamonds.add(cards[i]);
                    break;
                case 2:
                    clubs.add(cards[i]);
                    break;
                case 3:
                    spades.add(cards[i]);
                    break;
                default:
                    break;
            }
        }

        //sort hearts
        for (int i = 0, suitSize = hearts.size(); i < suitSize;i++)
        {
            for (int j = 0; j < suitSize - i - 1;j++)
            {
                String low = hearts.get(j).getRank().getName(),
                        high = hearts.get(j + 1).getRank().getName();
                int lowIndex = 0,
                    highIndex = 0;

                for (int l = 0; l < 9;l++)
                {
                    if (low == Rank.values[l].getName())
                        lowIndex = l;
                    if (high == Rank.values[l].getName())
                        highIndex = l;
                }

                if (lowIndex > highIndex)
                {
                    Card prom = hearts.get(j);
                    hearts.set(j, hearts.get(j + 1));
                    hearts.set(j + 1, prom);
                }
            }
        }

        //sort diomonds
        for (int i = 0, suitSize = diamonds.size(); i < suitSize;i++)
        {
            for (int j = 0; j < suitSize - i - 1;j++)
            {
                String low = diamonds.get(j).getRank().getName(),
                        high = diamonds.get(j + 1).getRank().getName();
                int lowIndex = 0,
                        highIndex = 0;

                for (int l = 0; l < 9;l++)
                {
                    if (low == Rank.values[l].getName())
                        lowIndex = l;
                    if (high == Rank.values[l].getName())
                        highIndex = l;
                }

                if (lowIndex > highIndex)
                {
                    Card prom = diamonds.get(j);
                    diamonds.set(j, diamonds.get(j + 1));
                    diamonds.set(j + 1, prom);
                }
            }
        }

        //sort clubs
        for (int i = 0, suitSize = clubs.size(); i < suitSize;i++)
        {
            for (int j = 0; j < suitSize - i - 1;j++)
            {
                String low = clubs.get(j).getRank().getName(),
                        high = clubs.get(j + 1).getRank().getName();
                int lowIndex = 0,
                        highIndex = 0;

                for (int l = 0; l < 9;l++)
                {
                    if (low == Rank.values[l].getName())
                        lowIndex = l;
                    if (high == Rank.values[l].getName())
                        highIndex = l;
                }

                if (lowIndex > highIndex)
                {
                    Card prom = clubs.get(j);
                    clubs.set(j, clubs.get(j + 1));
                    clubs.set(j + 1, prom);
                }
            }
        }

        //sort spades
        for (int i = 0, suitSize = spades.size(); i < suitSize;i++)
        {
            for (int j = 0; j < suitSize - i - 1;j++)
            {
                String low = spades.get(j).getRank().getName(),
                        high = spades.get(j + 1).getRank().getName();
                int lowIndex = 0,
                        highIndex = 0;

                for (int l = 0; l < 9;l++)
                {
                    if (low == Rank.values[l].getName())
                        lowIndex = l;
                    if (high == Rank.values[l].getName())
                        highIndex = l;
                }

                if (lowIndex > highIndex)
                {
                    Card prom = spades.get(j);
                    spades.set(j, spades.get(j + 1));
                    spades.set(j + 1, prom);
                }
            }
        }

        int index = 0;

        for (int j = 0; j < hearts.size(); j++)
            cards[index++] = hearts.get(j);

        for (int j = 0; j < diamonds.size(); j++)
            cards[index++] = diamonds.get(j);

        for (int j = 0; j < clubs.size(); j++)
            cards[index++] = clubs.get(j);

        for (int j = 0; j < spades.size(); j++)
            cards[index++] = spades.get(j);

    }

    //Повертає true у випадку коли в колоді ще доступні карти
    public boolean hasNext() {
        if (size > 0)
            return true;
        else
            return false;
    }

    //"Виймає" одну карту з колоди, коли буде видано всі 36 карт повертає null
    //Карти виймаються з "вершини" колоди. Наприклад перший виклик видасть SPADES 6 потім
    //SPADES 7, ..., CLUBS 6, ..., CLUBS Ace і так далі до HEARTS Ace
    public Card drawOne() {
        if (size > 0)
            return cards[--size];
        else
            return null;
    }
}
