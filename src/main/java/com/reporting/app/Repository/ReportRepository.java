package com.reporting.app.Repository;

import com.reporting.app.Entity.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ReportRepository extends JpaRepository<ReportEntity, Integer> {

}
