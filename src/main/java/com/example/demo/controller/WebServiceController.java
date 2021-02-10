package com.example.demo.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Reader.Row;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.util.*;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class WebServiceController {
	

    @GetMapping("/median")
    @RequestMapping(value = "/median", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public String median(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //System.out.println("test post\n");
        //PrintWriter out = resp.getWriter();
    	String data = "";   
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = req.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        data = builder.toString();
        //JSONObject object = new JSONObject(data);
	    
        List<Row> rows = new ArrayList<>();
        //calculate median here...
        int[] levels = new int[rows.size()];
        int sum = 0;
        for (int i = 0; i < rows.size(); i++) {
            levels[i] = rows.get(i).getLabel();
            sum += levels[i];
        }
        Arrays.sort(levels);
        int CalculateMedian = levels[rows.size() / 2];
        
        
        //send json response.. 
        //String json_str = req.getParameter("name");
        //out.print(json_str);
        return data;
    }
}


