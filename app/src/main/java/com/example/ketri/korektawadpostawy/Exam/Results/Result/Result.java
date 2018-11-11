package com.example.ketri.korektawadpostawy.Exam.Results.Result;

/**
 * Created by ketri on 09.11.2018.
 */

public class Result {
    private String defectName;
    private String defectDescrip;
    private String attention;

    public Result(String defectName, String defectDescrip, String attention) {
        this.defectName = defectName;
        this.defectDescrip = defectDescrip;
        this.attention = attention;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public String getDefectName() {
        return defectName;
    }

    public void setDefectName(String defectName) {
        this.defectName = defectName;
    }

    public String getDefectDescrip() {
        return defectDescrip;
    }

    public void setDefectDescrip(String defectDescrip) {
        this.defectDescrip = defectDescrip;
    }
}
