package com.riwi.vacants.servicies;

import java.util.ArrayList;
import java.util.stream.Collectors;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.vacants.entity.Company;
import com.riwi.vacants.entity.Vacant;
import com.riwi.vacants.repositories.CompanyRepositorie;
import com.riwi.vacants.servicies.interfaces.ICompanyService;
import com.riwi.vacants.utils.dto.request.CompanyRequest;
import com.riwi.vacants.utils.dto.response.CompanyResponse;
import com.riwi.vacants.utils.dto.response.VacantToCompanyResponse;


import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyService implements ICompanyService{

    @Autowired
    private final CompanyRepositorie objCompanyRepositorie;

    @Override
    public Page<CompanyResponse> getAll(int page, int size) {
        if (page < 0) page = 0;
        PageRequest pagination = PageRequest.of(page, size);

        // return this.objCompanyRepositorie.findAll(pagination).map(company ->this.entityToResponse(company));

        return this.objCompanyRepositorie.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public CompanyResponse getById(String id) {
        return this.entityToResponse(this.find(id));
    }

    private Company find(String id){
        return this.objCompanyRepositorie.findById(id).orElseThrow();
    }

    @Override
    public CompanyResponse create(CompanyRequest request) {
        Company company = this.requestToCompany(request,new Company());

        return this.entityToResponse(this.objCompanyRepositorie.save(company));
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public CompanyResponse update(CompanyRequest request, String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    private CompanyResponse entityToResponse(Company entity){
        CompanyResponse response = new CompanyResponse();
        BeanUtils.copyProperties(entity, response);

        response.setVancats(entity.getVancats()
        .stream().map(vacant -> this.vacantToResponse(vacant))
        .collect(Collectors.toList()));

        return response;
    }

    private VacantToCompanyResponse vacantToResponse(Vacant entity){

        VacantToCompanyResponse response = new VacantToCompanyResponse();

        BeanUtils.copyProperties(entity, response);

        return response;
    }

    private Company requestToCompany(CompanyRequest request,Company company){
        BeanUtils.copyProperties(request, company);
        company.setVancats(new ArrayList<>());
        return company;
    }



}
