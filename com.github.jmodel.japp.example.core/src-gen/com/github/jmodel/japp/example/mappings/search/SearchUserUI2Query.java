package com.github.jmodel.japp.example.mappings.search;

import com.github.jmodel.ModelException;
import com.github.jmodel.api.domain.Model;
import com.github.jmodel.mapper.api.domain.Mapping;
import java.util.Map;

@SuppressWarnings("all")
public class SearchUserUI2Query extends Mapping {
  private static Mapping instance;
  
  public static synchronized Mapping getInstance() {
    if (instance == null) {
    	instance = new com.github.jmodel.japp.example.mappings.search.SearchUserUI2Query();
    	
    	instance.init(instance);
    }	
    
    return instance;
  }
  
  @Override
  public void init(final Mapping myInstance) {
    super.init(myInstance);
    com.github.jmodel.api.domain.Entity sourceRootModel = new com.github.jmodel.api.domain.Entity();
    myInstance.setSourceTemplateModel(sourceRootModel);
    com.github.jmodel.api.domain.Entity targetRootModel = new com.github.jmodel.api.domain.Entity();
    myInstance.setTargetTemplateModel(targetRootModel); 
    		
    myInstance.setFromFormat(com.github.jmodel.FormatEnum.JSON);														
    
    myInstance.setToFormat(com.github.jmodel.FormatEnum.JSON);														
    
    	
    			
    	
    				
    	myInstance.getRawSourceFieldPaths().add("Request._");
    	myInstance.getRawTargetFieldPaths().add("Q._");
    	
    	myInstance.getRawSourceFieldPaths().add("Request._");
    	myInstance.getRawTargetFieldPaths().add("Q.query._");
    	
    	myInstance.getRawSourceFieldPaths().add("Request._");
    	myInstance.getRawTargetFieldPaths().add("Q.query.constant_score._");
    	
    	myInstance.getRawSourceFieldPaths().add("Request._");
    	myInstance.getRawTargetFieldPaths().add("Q.query.constant_score.filter._");
    	
    	myInstance.getRawSourceFieldPaths().add("Request._");
    	myInstance.getRawTargetFieldPaths().add("Q.query.constant_score.filter.term._");
    	
    
        myInstance.getRawSourceFieldPaths().add("Request.A");
    	
    	myInstance.getRawTargetFieldPaths().add("Q.query.constant_score.filter.term.A");												
  }
  
  @Override
  public void execute(final Model mySourceModel, final Model myTargetModel, final Map myVariablesMap) throws ModelException {
    super.execute(mySourceModel, myTargetModel, myVariablesMap);
    {
    {
    {
    {
    {
    {
    String fieldValue = null;
    fieldValue = String.valueOf(com.github.jmodel.api.utils.ModelHelper.getFieldValue(mySourceModel.getFieldPathMap().get("Request.A")));
    myTargetModel.getFieldPathMap().get("Q.query.constant_score.filter.term.A").setValue(fieldValue); 
    
    myTargetModel.getFieldPathMap().get("Q.query.constant_score.filter.term.A").setDataType(com.github.jmodel.api.domain.DataTypeEnum.STRING);   
    
    }
    }
    }
    }
    }
    }
  }
}
