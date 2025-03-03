package com.alldata.JavaCourse2025.serviceImpl;/*
 * @created 02/03/2025
 * @project JavaCourse2025
 * @author Noktuos
 */

import com.alldata.JavaCourse2025.service.JsonService;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class JsonServiceImpl implements JsonService {


    @Override
    public ResponseEntity<?> transformar(String jsonObject) {
        if(jsonObject == null){
            return ResponseEntity.unprocessableEntity().body("The provided JSON is null");
        }
        if(jsonObject.startsWith("{") && jsonObject.endsWith("}")){
            JSONObject jsonObject1 = new JSONObject(jsonObject);
            if(jsonObject1.has("saludo")){
                String content = jsonObject1.getString("saludo").trim().replace(" ","*");
                jsonObject1.remove("saludo");
                jsonObject1.put("saludo", content);

                return ResponseEntity.ok().body(jsonObject1.toString());
            }else{
                return ResponseEntity.unprocessableEntity().body("The provided JSON do not have a content attribute, cannot transform");
            }
        }else{
            return ResponseEntity.unprocessableEntity().body("The provided JSON was not correct");
        }

    }
}
