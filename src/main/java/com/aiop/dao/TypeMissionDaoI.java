package com.aiop.dao;  
  
import java.io.Serializable;  
import java.util.List;

import com.aiop.model.TypeMission;
  
public interface TypeMissionDaoI<T>  
{  
    public Serializable save(T t);

	public TypeMission load(long idTypeMission); 
}  
