package com.bestpractice.codegenerate.model;

import org.apache.commons.lang.ArrayUtils;

import com.bestpractice.codegenerate.utils.CamelUtils;

public class ColumnDef {
	private String columnName;
	private String dataType;
	private String description;

	public ColumnDef(String columnName, String dataType, String description) {
		super();
		this.columnName = columnName;
		this.dataType = dataType;
		this.description = description;
	}

	public String getColumnName() {
		return columnName;
	}
	
	public String getUnderLineColumnName(){
		return CamelUtils.toUnderlineName(columnName);
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getDataType() {
		return dataType;
	}

	public boolean isNumberType(){
		if(dataType.contains("int")
				||dataType.contains("INT")
				||dataType.equalsIgnoreCase("double")
				||dataType.equalsIgnoreCase("decimal")
				||dataType.equalsIgnoreCase("float")){
			return true;
		}else{
			return false;
		}
	}
	
	public String getGetterMethodName(){
		return "get" + Character.toUpperCase(columnName.charAt(0)) + columnName.substring(1);
	}
	
	public String getSetterMethodName(){
		return "set" + Character.toUpperCase(columnName.charAt(0)) + columnName.substring(1);
	}
	
	public String getJavaType(){
		if(ArrayUtils.contains(new String[]{"CHAR","VARCHAR","BLOB","LONGBLOB","MEDIUMBLOB","TINYBLOB","BINARY","VARBINARY","LONGTEXT","TEXT","TINYTEXT","MEDIUMTEXT"}, dataType.toUpperCase())){
			return "String";
		}else if(ArrayUtils.contains(new String[]{"INT","TINYINT","SMALLINT","MEDIUMINT"}, dataType.toUpperCase())){
			return "int";
		}else if(ArrayUtils.contains(new String[]{"DOUBLE"}, dataType.toUpperCase())){
			return "double";
		}else if(ArrayUtils.contains(new String[]{"BIGINT","DECIMAL"}, dataType.toUpperCase())){
			return "long";
		}else if(ArrayUtils.contains(new String[]{"FLOAT"}, dataType.toUpperCase())){
			return "float";
		}else if(ArrayUtils.contains(new String[]{"DATE","DATETIME","TIME","TIMESTAMP","YEAR"}, dataType.toUpperCase())){
			return "Date";
		}else{
			return "String";
		}
	}
	
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
