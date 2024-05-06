package com.riwi.vacants.servicies;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.vacants.entity.Company;
import com.riwi.vacants.entity.Vacant;
import com.riwi.vacants.repositories.CompanyRepositorie;
import com.riwi.vacants.repositories.VacantRepositorie;
import com.riwi.vacants.servicies.interfaces.IvacantService;
import com.riwi.vacants.utils.dto.request.VacancyRequest;
import com.riwi.vacants.utils.dto.response.CompanyToVacantResponse;
import com.riwi.vacants.utils.dto.response.VacantResponse;
import com.riwi.vacants.utils.enums.StateVacant;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VacantService implements IvacantService{

    @Autowired
    private final VacantRepositorie objVacantRepositorie;
    @Autowired
    private final CompanyRepositorie objCompanyRepositorie;

    @Override
    public Page<VacantResponse> getAll(int page, int size) {
        if (page <0) page = 0;

        //Creamos la paginacion 
        PageRequest pagination = PageRequest.of(page, size);

        return this.objVacantRepositorie.findAll(pagination).map(vacant -> this.entityToResponse(vacant));
    }

    @Override
    public VacantResponse create(VacancyRequest request) {
        Company company= this.objCompanyRepositorie.findById((request.getCompanyId())).orElseThrow(()-> new IdNotFoundException ("company"));

        Vacant vacant = this.requestToVacant(request,new Vacant());

        vacant.setCompany(company);

        return this.entityToResponse(this.objVacantRepositorie.save(vacant));
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public VacantResponse update(VacancyRequest request, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public VacantResponse getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    private VacantResponse entityToResponse(Vacant vacant){

        VacantResponse response = new VacantResponse();

        BeanUtils.copyProperties(vacant, response);

        CompanyToVacantResponse companyResp = new CompanyToVacantResponse();

        BeanUtils.copyProperties(vacant.getCompany(), companyResp);

        response.setCompany(companyResp);

        return response;
    }

    private Vacant requestToVacant(VacantRequest request,Vacant entity){
        entity.setDescription(request.getTitle);
        entity.setDescription(request.getDescription);
        entity.setStatus(StateVacant.ACTIVE);

        return entity;
    }
    
}
