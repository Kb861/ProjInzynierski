package com.example.ketri.korektawadpostawy.Exam;

/**
 * Created by ketri on 27.10.2018.
 */

public class Item {
    int background;
    String cardName;

    public Item() {
    }

    public Item(int background, String cardName) {
        this.background = background;
        this.cardName = cardName;
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
}
