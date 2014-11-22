package com.aiop.dao;  
  
import java.io.Serializable;  
import java.util.List;
import java.util.Set;

import com.aiop.model.TypeMission;
  
public interface TypeMissionDaoI<T>  
{  
    public Serializable save(T t);

	public TypeMission load(long idTypeMission);

	public void update(TypeMission tm);

	public Set<TypeMission> getTypeMissionNotAssignedWTypeObjet();

	public List<T>  getTypeMissions(); 
}  
