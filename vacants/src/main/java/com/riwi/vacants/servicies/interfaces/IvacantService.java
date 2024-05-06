package com.riwi.vacants.servicies.interfaces;

import com.riwi.vacants.utils.dto.request.VacancyRequest;
import com.riwi.vacants.utils.dto.response.VacantResponse;

public interface IvacantService extends CrudServicies<VacancyRequest,VacantResponse,Long>{

    public VacantResponse getById(Long id);

    
}