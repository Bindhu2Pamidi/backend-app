package com.reporting.app.Service;

import com.reporting.app.Entity.ReportEntity;
import com.reporting.app.Repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

   @Autowired
   ReportRepository repository;
   public ReportService(ReportRepository repository){
       this.repository = repository;
   }

    public List<ReportEntity> getDetails(){
        return repository.findAll();
    }

    public ReportEntity setDetails(ReportEntity entity){
        return repository.save(entity);
    }
    public ReportEntity getDetailsById(int id){
        return repository.findById(id).orElse(null);
    }

}
