package com.lcorp.supportservice.controller;

import com.lcorp.supportservice.model.dao.SalesReport;
import com.lcorp.supportservice.service.ReportService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path ="api/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public ResponseEntity<SalesReport> getSalesReport() {
        return new ResponseEntity<SalesReport>(reportService.generateSalesReport(), new HttpHeaders(), HttpStatus.OK);
    }

}
