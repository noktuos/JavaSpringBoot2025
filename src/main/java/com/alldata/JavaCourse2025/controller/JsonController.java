package com.alldata.JavaCourse2025.controller;/*
 * @created 02/03/2025
 * @project JavaCourse2025
 * @author Noktuos
 */

import com.alldata.JavaCourse2025.service.JsonService;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "json")
public class JsonController {
    private JsonService jsonService;

    public JsonController(JsonService jsonService) {
        this.jsonService = jsonService;
    }
    @ResponseBody
    @PostMapping(path = "/transformar")
    public ResponseEntity<?> transformar(@RequestBody String json){
        return jsonService.transformar(json);
    }
}
