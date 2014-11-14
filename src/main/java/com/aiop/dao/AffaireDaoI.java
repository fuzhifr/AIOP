package com.aiop.dao;  
  
import java.io.Serializable;  

import com.aiop.model.Affaire;
  
public interface AffaireDaoI  
{  
    public Serializable save(Affaire a); 
    public void update(Affaire a);
    public Affaire load(long id);
}  
