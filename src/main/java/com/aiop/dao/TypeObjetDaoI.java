package com.aiop.dao;  
  
import java.io.Serializable;  
import java.util.List;

import com.aiop.model.TypeObjet;
  
public interface TypeObjetDaoI<T>  
{  
    public Serializable save(T o);  
    public List<T> getTypeObjets();
    public TypeObjet load(long id);
}  
