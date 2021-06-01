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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Yeison David Sanchez Legarda
 */
@Component
public class JsonDecoderMultiple<T> extends JsonDecoderSingle {
  @Autowired
    private ObjectMapper objectMapper;
    
    public List<JsonNode> decodeMultipleValues(String nodeName,JsonNode jsonNode){
        JsonNode jsonNodes  = super.getNodeByName(nodeName,jsonNode);
        List<JsonNode> dataNodes = new ArrayList();
        if(jsonNodes!=null){
                Iterator<JsonNode> empNodes = jsonNodes.iterator();
                while (empNodes.hasNext()) {
                    dataNodes.add(empNodes.next());
                }
            }
        return dataNodes;
    }
    
    public List<Object> deserializeList(List<JsonNode> jsonNodes,Class<T> returnType) throws JsonProcessingException{
        List<Object> list = new ArrayList();
        for(JsonNode jn:jsonNodes){
            list.add(super.nodeToObject(jn, returnType));
        }
        return list;
    }
}
