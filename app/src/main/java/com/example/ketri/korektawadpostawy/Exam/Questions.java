package com.example.ketri.korektawadpostawy.Exam;

import java.security.PrivateKey;

/**
 * Created by ketri on 23.10.2018.
 */

public class Questions {

    public String Questions[] = {
            "Ustawienie głowy:",
            "Ustawienie barków:",
            "Ustawienie i kształt klatki piersiowej:",
            "Ustawienie łopatek:",
            "Skrzywienie boczne kręgosłupa:",
            "Ustawienie brzucha:"
    };
    private String Choices[] []={
            {"nos nie wystaje przed pion przechodzący przez górną część rękojeści mostka", "twarz nie wystaje w przód przed pion przechodzący przez rękojeść mostka", "twarz wystaje w przód przed rękojeść mostka, głowa jest silnie pochylona do przodu"},
            {"szczyt barków znajduje się na tle tylnej części szyi", "szczyt barków znajduje się na tle przedniej części szyi", "szczyt barków znajduje się przed konturem szyi"},
            {"klatka piersiowa dobrze wykształcona", "klatka piersiowa nieco spłaszczona", "klatka piersiowa płaska"},
            {"łopatki tworzą jednolita płaszczyznę pleców", "łopatki odstają od konturu pleców na więcej niż jeden palec", "łopatki odstają od konturu pleców na więcej niż 2 palce"},
            {"kręgosłup nie wykazuje widocznych bocznych skrzywień", "linia wyrostków kolczystych odchyla się ponad 2 cm od pionu ", "linia wyrostków kolczystych odchyla się o ponad 4 cm od wspomnianego pionu"},
            {"brzuch płaski", "brzuch uwypuklony, nie występujący przed linią klatki piersiowej", "brzuch obwisły, wystający poza linię klatki piersiowej"}
    };

    public String getQuestion(int a){
        String question = Questions[a];
        return question;
    }

    public String getChoice1(int a){
        String choice = Choices[a][0];
        return choice;
    }

    public String getChoice2(int a){
        String choice = Choices[a][1];
        return choice;
    }

    public String getChoice3(int a){
        String choice = Choices[a][2];
        return choice;
    }
}
