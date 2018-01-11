package com.github.jmodel.japp.example.mappings.news;

import com.github.jmodel.ModelException;
import com.github.jmodel.api.entity.Model;
import com.github.jmodel.mapper.api.domain.Mapping;
import java.util.Map;

@SuppressWarnings("all")
public class AddNews extends Mapping {
  private static Mapping instance;
  
  public static synchronized Mapping getInstance() {
    if (instance == null) {
    	instance = new com.github.jmodel.japp.example.mappings.news.AddNews();
    	
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
    
    
    	
    			
    	
    				
    	myInstance.getRawSourceFieldPaths().add("Request._");
    	myInstance.getRawTargetFieldPaths().add("News._");
    	
    
        myInstance.getRawSourceFieldPaths().add("Request.title");
        myInstance.getRawSourceFieldPaths().add("Request.subTitle");
    	
    	myInstance.getRawTargetFieldPaths().add("News.title");												
    	myInstance.getRawTargetFieldPaths().add("News.subTitle");												
  }
  
  @Override
  public void execute(final Model mySourceModel, final Model myTargetModel, final Map myVariablesMap) throws ModelException {
    super.execute(mySourceModel, myTargetModel, myVariablesMap);
    myTargetModel.setTargetBean(new com.github.jmodel.japp.example.domain.entity.News());
    {
    {
    String fieldValue = null;
    fieldValue = String.valueOf(com.github.jmodel.utils.ModelHelper.getFieldValue(mySourceModel.getFieldPathMap().get("Request.title")));
    myTargetModel.getFieldPathMap().get("News.title").setValue(fieldValue); 
    
    myTargetModel.getFieldPathMap().get("News.title").setDataType(com.github.jmodel.api.entity.DataTypeEnum.STRING);   
    
    }
    {
    String fieldValue = null;
    fieldValue = String.valueOf(com.github.jmodel.utils.ModelHelper.getFieldValue(mySourceModel.getFieldPathMap().get("Request.subTitle")));
    myTargetModel.getFieldPathMap().get("News.subTitle").setValue(fieldValue); 
    
    myTargetModel.getFieldPathMap().get("News.subTitle").setDataType(com.github.jmodel.api.entity.DataTypeEnum.STRING);   
    
    }
    }
  }
}
