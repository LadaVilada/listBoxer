/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.listBoxer.dto;

/**
 *
 * @author vbobina
 */
public class SelectionCriteria {

    private Boolean asc;
    private Boolean desc;
    private Boolean alphabetic;
    private Boolean numeric;

    public Boolean getAsc() {
        return asc;
    }

    public void setAsc(Boolean asc) {
        this.asc = asc;
    }

    public Boolean getDesc() {
        return desc;
    }

    public void setDesc(Boolean desc) {
        this.desc = desc;
    }

    public Boolean getAlphabetic() {
        return alphabetic;
    }

    public void setAlphabetic(Boolean alphabetic) {
        this.alphabetic = alphabetic;
    }

    public Boolean getNumeric() {
        return numeric;
    }

    public void setNumeric(Boolean numeric) {
        this.numeric = numeric;
    }
    
    

}
