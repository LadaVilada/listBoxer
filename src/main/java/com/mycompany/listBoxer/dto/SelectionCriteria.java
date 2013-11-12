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

    /**
     * @return the asc
     */
    public Boolean getAsc() {
        return asc;
    }

    /**
     * @param asc the asc to set
     */
    public void setAsc(Boolean asc) {
        this.asc = asc;
    }

    /**
     * @return the desc
     */
    public Boolean getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(Boolean desc) {
        this.desc = desc;
    }

    /**
     * @return the alphabetic
     */
    public Boolean getAlphabetic() {
        return alphabetic;
    }

    /**
     * @param alphabetic the alphabetic to set
     */
    public void setAlphabetic(Boolean alphabetic) {
        this.alphabetic = alphabetic;
    }

    /**
     * @return the numeric
     */
    public Boolean getNumeric() {
        return numeric;
    }

    /**
     * @param numeric the numeric to set
     */
    public void setNumeric(Boolean numeric) {
        this.numeric = numeric;
    }
    
    

}
