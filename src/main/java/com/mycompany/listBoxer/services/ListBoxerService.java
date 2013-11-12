/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.listBoxer.services;

import com.mycompany.listBoxer.dto.SelectionCriteria;
import java.util.List;

/**
 *
 * @author vbobina
 */
public interface ListBoxerService {

    Boolean saveContent(String userInput);

    List<String> getAll();
    
    List<String> getByRange(String range);
    
    List<String> getByCriteria(SelectionCriteria selCriteria);
    
    
}
