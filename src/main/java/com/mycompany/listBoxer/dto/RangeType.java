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
public enum RangeType {

    ALL("All"), AM("A-M, a-m"), NZ("N-Z, n-z"),
    NUM1("0-100"), NUM2("101-200"), NUM3("201-300"), NUM4("301-9999");

    private final String key;

    private RangeType(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }

    public RangeType getByRange(String key) {

        return RangeType.valueOf(key);

    }

}
