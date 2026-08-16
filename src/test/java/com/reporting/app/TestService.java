package com.reporting.app;

import com.reporting.app.Entity.ReportEntity;
import com.reporting.app.Repository.ReportRepository;
import com.reporting.app.Service.ReportService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestService {

    @Mock
    private ReportRepository repository;

    private ReportService service;

    @BeforeEach
    void setUp(){
        service = new ReportService(repository);
    }

    @Test
    void getReports(){
        ReportEntity en = new ReportEntity(1, "jane.doe@example.com", "Jane", "Doe", "SecurePassword123!", "+1-555-0198", "Software engineer with five years of experience.", "submitted");
        ReportEntity en1 = new ReportEntity(2, "marcus.vance@example.com", "Marcus", "Vance", "CryptoKey987##", "+1-555-0741", "Senior Database Administrator specializing in PostgreSQL performance tuning and cloud migrations.", "not_submitted");
        List<ReportEntity> mockList = Arrays.asList(en, en1);
        when(repository.findAll()).thenReturn(mockList);
        List<ReportEntity> response = service.getDetails();

        assertNotNull(response);
        assertEquals(1,response.get().getId());
        assertEquals("Jane", response.get(0).getFirstName());
        assertEquals("Doe", response.get(0).getLastName());
        assertEquals("jane.doe@example.com", response.get(0).getEmail());
        assertEquals("SecurePassword123!",response.get(0).getPassword());
        assertEquals("+1-555-0741",response.get(0).getPhone());
        assertEquals("Software engineer with five years of experience.",response.get(0).getDescription());
        assertEquals("submitted", response.get(0).getStatus());
    }

    @Test
    void setReports(){
        ReportEntity en = new ReportEntity(1, "jane.doe@example.com", "Jane", "Doe", "SecurePassword123!", "+1-555-0198", "Software engineer with five years of experience.", "submitted");


        when(repository.save(en)).thenReturn(en);
        ReportEntity savedReport = service.setDetails(en);

        assertNotNull(savedReport);
        assertEquals("1",savedReport.getId());
        assertEquals("Jane", savedReport.getFirstName());
        assertEquals("Doe", savedReport.getLastName());
        assertEquals("jane.doe@example.com", savedReport.getEmail());
        assertEquals("SecurePassword123!", savedReport.getPassword());
        assertEquals("+1-555-0198", savedReport.getPhone());
        assertEquals("Software engineer with five years of experience.",savedReport.getDescription());
        assertEquals("submitted",savedReport.getStatus());

    }

}
