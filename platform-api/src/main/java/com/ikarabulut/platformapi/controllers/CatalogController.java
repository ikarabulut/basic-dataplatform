package com.ikarabulut.platformapi.controllers;

import com.ikarabulut.platformapi.models.CatalogDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CatalogController {

    @PostMapping("/catalog/create")
    public ResponseEntity<CatalogDetails> greeting(@RequestBody CatalogDetails request) {
        var response = new CatalogDetails();
        return new ResponseEntity<CatalogDetails>(response, HttpStatus.CREATED);
    }
}

