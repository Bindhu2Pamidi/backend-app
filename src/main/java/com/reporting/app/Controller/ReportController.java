package com.reporting.app.Controller;

import com.reporting.app.Entity.ReportEntity;
import com.reporting.app.Service.ReportService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Data
@RestController
public class ReportController {
    @Autowired
     private ReportService service;
     public ReportController(ReportService service){

     }
     @GetMapping("/reports")
     public List<ReportEntity> getDetails(){
         return service.getDetails();
     }
     @PostMapping("/reports")
     public ReportEntity setDetails(@RequestBody ReportEntity entity){
         return service.setDetails(entity);
     }
}
