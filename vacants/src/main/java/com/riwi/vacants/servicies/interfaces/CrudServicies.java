package com.riwi.vacants.servicies.interfaces;

import org.springframework.data.domain.Page;

public interface CrudServicies<RQ,RS,ID> {
    
    public Page<RS> getAll(int page,int size);
    
    public RS create(RQ request);
    
    public void delete(ID id);
    
    public RS update(RQ request,ID id);

}
