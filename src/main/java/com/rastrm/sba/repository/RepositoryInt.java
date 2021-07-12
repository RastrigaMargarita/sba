package com.rastrm.sba.repository;

import com.rastrm.sba.entity.EntityItem;


public interface RepositoryInt {

    public void newItem(EntityItem item);

    public String getAllList();

    public void delByID(int id);

    public EntityItem findByID(int id);
}

