package com.example.ketri.korektawadpostawy.Exam;

/**
 * Created by ketri on 27.10.2018.
 */

public class Item {
    int background;
    String cardName;
    String descrip;

    public Item() {
    }

    public Item(int background, String cardName) {
        this.background = background;
        this.cardName = cardName;
    }

    public Item(int background, String cardName, String descrip) {
        this.background = background;
        this.cardName = cardName;
        this.descrip = descrip;
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

    public String getDescrip() {
        return descrip;
    }


}
