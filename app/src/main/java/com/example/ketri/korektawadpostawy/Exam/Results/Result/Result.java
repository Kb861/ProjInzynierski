package com.example.ketri.korektawadpostawy.Exam.Results.Result;

/**
 * Created by ketri on 09.11.2018.
 */

public class Result {
    private String defectName;
    private String defectDescrip;


    public Result(String defectName, String defectDescrip) {
        this.defectName = defectName;
        this.defectDescrip = defectDescrip;
    }

    public String getDefectName() {
        return defectName;
    }

    public String getDefectDescrip() {
        return defectDescrip;
    }
}
