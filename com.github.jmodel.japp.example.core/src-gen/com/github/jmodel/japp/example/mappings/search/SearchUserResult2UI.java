package com.github.jmodel.japp.example.mappings.search;

import com.github.jmodel.ModelException;
import com.github.jmodel.api.entity.Model;
import com.github.jmodel.mapper.api.domain.Mapping;
import java.util.Map;

@SuppressWarnings("all")
public class SearchUserResult2UI extends Mapping {
  private static Mapping instance;
  
  public static synchronized Mapping getInstance() {
    if (instance == null) {
    	instance = new com.github.jmodel.japp.example.mappings.search.SearchUserResult2UI();
    	
    	instance.init(instance);
    }	
    
    return instance;
  }
  
  @Override
  public void init(final Mapping myInstance) {
    super.init(myInstance);
    com.github.jmodel.api.entity.Entity sourceRootModel = new com.github.jmodel.api.entity.Entity();
    myInstance.setSourceTemplateModel(sourceRootModel);
    com.github.jmodel.api.entity.Entity targetRootModel = new com.github.jmodel.api.entity.Entity();
    myInstance.setTargetTemplateModel(targetRootModel); 
    		
    myInstance.setFromFormat(com.github.jmodel.FormatEnum.JSON);														
    
    myInstance.setToFormat(com.github.jmodel.FormatEnum.JSON);														
    
    	
    			
    	
    				
    	myInstance.getRawSourceFieldPaths().add("Result._");
    	myInstance.getRawTargetFieldPaths().add("UI._");
    	
    	myInstance.getRawSourceFieldPaths().add("Result.hits._");
    	myInstance.getRawTargetFieldPaths().add("UI._");
    	
    	myInstance.getRawSourceFieldPaths().add("Result.hits.hits[]._");
    	myInstance.getRawTargetFieldPaths().add("UI.list[]._");
    	
    	myInstance.getRawSourceFieldPaths().add("Result.hits.hits[]._source._");
    	myInstance.getRawTargetFieldPaths().add("UI.list[]._");
    	
    
        myInstance.getRawSourceFieldPaths().add("Result.hits.total");
        myInstance.getRawSourceFieldPaths().add("Result.hits.hits[]._source.A");
        myInstance.getRawSourceFieldPaths().add("Result.hits.hits[]._source.A");
    	
    	myInstance.getRawTargetFieldPaths().add("UI.total");												
    	myInstance.getRawTargetFieldPaths().add("UI.list[].id");												
    	myInstance.getRawTargetFieldPaths().add("UI.list[].name");												
  }
  
  @Override
  public void execute(final Model mySourceModel, final Model myTargetModel, final Map myVariablesMap) throws ModelException {
    super.execute(mySourceModel, myTargetModel, myVariablesMap);
    {
    {
    {
    String fieldValue = null;
    fieldValue = String.valueOf(com.github.jmodel.utils.ModelHelper.getFieldValue(mySourceModel.getFieldPathMap().get("Result.hits.total")));
    myTargetModel.getFieldPathMap().get("UI.total").setValue(fieldValue); 
    
    myTargetModel.getFieldPathMap().get("UI.total").setDataType(com.github.jmodel.api.entity.DataTypeEnum.STRING);   
    
    }
    {
    java.util.function.Predicate<String> p = null;
    com.github.jmodel.mapper.api.utils.MappingHelper.arrayMapping(mySourceModel, myTargetModel, mySourceModel.getModelPathMap().get("Result.hits.hits[]"), myTargetModel.getModelPathMap().get("UI.list[]"), "Result.hits.hits[]", "UI.list[]", 0, false, p,
    (String[] m_2) ->
    {
    {
    java.util.function.Predicate<String> p_1 = null;
    com.github.jmodel.mapper.api.utils.MappingHelper.arrayMapping(mySourceModel, myTargetModel, mySourceModel.getModelPathMap().get(m_2[0] + "._source"), myTargetModel.getModelPathMap().get(m_2[1] + ""), m_2[0] + "._source", m_2[1] + "", Integer.valueOf(m_2[2]), false, p_1,
    (String[] m_3) ->
    {
    {
    String fieldValue = null;
    fieldValue = String.valueOf(com.github.jmodel.utils.ModelHelper.getFieldValue(mySourceModel.getFieldPathMap().get(m_3[0] + ".A")));
    myTargetModel.getFieldPathMap().get(m_3[1] + ".id").setValue(fieldValue); 
    
    myTargetModel.getFieldPathMap().get(m_3[1] + ".id").setDataType(com.github.jmodel.api.entity.DataTypeEnum.STRING);  
    
    }
    {
    String fieldValue = null;
    fieldValue = String.valueOf(com.github.jmodel.utils.ModelHelper.getFieldValue(mySourceModel.getFieldPathMap().get(m_3[0] + ".A")));
    myTargetModel.getFieldPathMap().get(m_3[1] + ".name").setValue(fieldValue); 
    
    myTargetModel.getFieldPathMap().get(m_3[1] + ".name").setDataType(com.github.jmodel.api.entity.DataTypeEnum.STRING);  
    
    }
    });
    }
    });
    }
    }
    }
  }
}
