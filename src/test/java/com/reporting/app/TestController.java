package com.reporting.app;

import com.reporting.app.Controller.ReportController;
import com.reporting.app.Entity.ReportEntity;
import com.reporting.app.Service.ReportService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class TestController { // Renamed

    @Mock
    private ReportService service;

    private ReportController reportController;

    @BeforeEach
    void setUp() {
        reportController = new ReportController(service);
    }

    @Test
    void getReports() {
        ReportEntity en = new ReportEntity(1, "jane.doe@example.com", "Jane", "Doe", "SecurePassword123!", "+1-555-0198", "Software engineer with five years of experience.", "submitted");
        ReportEntity en1 = new ReportEntity(2, "marcus.vance@example.com", "Marcus", "Vance", "CryptoKey987##", "+1-555-0741", "Senior Database Administrator specializing in PostgreSQL performance tuning and cloud migrations.", "not_submitted");
        List<ReportEntity> mockList = Arrays.asList(en, en1);

        when(service.getDetails()).thenReturn(mockList);

        List<ReportEntity> response = reportController.getDetails();

        assertNotNull(response);
        assertEquals(1, response.get(0).getId());
        assertEquals("Jane", response.get(0).getFirstName());
        assertEquals("Doe", response.get(0).getLastName());
        assertEquals("jane.doe@example.com", response.get(0).getEmail());
        assertEquals("SecurePassword123!", response.get(0).getPassword());
        assertEquals("+1-555-0198", response.get(0).getPhone());
        assertEquals("Software engineer with five years of experience.", response.get(0).getDescription());
        assertEquals("submitted", response.get(0).getStatus());
        verify(service).getDetails();
    }

    @Test
    void CreateNewReport() {
        ReportEntity rawInput = new ReportEntity(null, "jane.doe@example.com", "Jane", "Doe", "SecurePassword123!", "+1-555-0198", "Software engineer with five years of experience.", "submitted");
        ReportEntity databaseOutput = new ReportEntity(1, "jane.doe@example.com", "Jane", "Doe", "SecurePassword123!", "+1-555-0198", "Software engineer with five years of experience.", "submitted");

        when(service.setDetails(any(ReportEntity.class))).thenReturn(databaseOutput);

        ReportEntity response = reportController.setDetails(rawInput);

        assertNotNull(response);
        assertAll(
                () -> assertEquals(1, response.getId()),
                () -> assertEquals("Jane", response.getFirstName()),
                () -> assertEquals("Doe", response.getLastName()),
                () -> assertEquals("+1-555-0198", response.getPhone()),
                () -> assertEquals("jane.doe@example.com", response.getEmail()),
                () -> assertEquals("SecurePassword123!", response.getPassword()),
                () -> assertEquals("Software engineer with five years of experience.", response.getDescription()),
                () -> assertEquals("submitted", response.getStatus())
        );
        verify(service).setDetails(rawInput);
    }
}
