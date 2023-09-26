package org.school.management.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Reports {
    CONTENT_DISPOSITION_FORM_DATA("attachment"),REPORTS_FOLDER("./reports/"),
    IN_EXTENSION(".jrxml"),OUT_EXTENSION(".pdf"),
    STUDENTS_REPORT("ReporteEstudiantes"),
    TEACHERS_REPORT("ReporteProfesores");

    public final String name;
}
