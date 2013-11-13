/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.listBoxer.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static List<String> getStringValue() {
    	List<String> result = new ArrayList<String>();
        List<RangeType> rangeTypeList = Arrays.asList(RangeType.values());
        for (RangeType type : rangeTypeList)
        {
        	result.add(type.key);
        }
        return result;
    }

    public RangeType getByRange(String key) {

        return RangeType.valueOf(key);

    }
    
    public static RangeType fromKey(String rangeTypeKey)
    {
        RangeType[] enums = RangeType.values();

        for (RangeType item : enums)
        {
            if (rangeTypeKey != null && item.getKey().equals(rangeTypeKey))
            {
                return item;
            }
        }

        throw new IllegalArgumentException(String.format("Unknown cssClassName %s", RangeType.class));
    }
    
    public String getKey()
    {
    	return key;
    }
    
}
