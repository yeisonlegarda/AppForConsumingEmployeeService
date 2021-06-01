/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thales.thalestestrest.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thales.thalestestrest.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Yeison David Sanchez Legarda
 */
@Component
public class JsonDecoderSingle<T> {

            
    @Autowired
    private ObjectMapper objectMapper;
    
     public Object nodeToObject(JsonNode jsonNode,Class<T> returnType) throws JsonProcessingException{
        return objectMapper.treeToValue(jsonNode, returnType);
    }
     
     public JsonNode getNodeByName(String nodeName,JsonNode jsonNode ){
         return jsonNode.get(nodeName);
     }
}
