package com.riwi.vacants.utils.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VacantToResponse {
    private Long id;
    private String title;
    private String description;
    private String status;
    private CompanyResponse company;
}
