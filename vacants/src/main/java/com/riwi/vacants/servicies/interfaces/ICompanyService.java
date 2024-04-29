package com.riwi.vacants.servicies.interfaces;

import com.riwi.vacants.utils.dto.request.CompanyRequest;
import com.riwi.vacants.utils.dto.response.CompanyResponse;

public interface ICompanyService extends CrudServicies<CompanyRequest,CompanyResponse,String>{
    public CompanyResponse getById(String id);
}
