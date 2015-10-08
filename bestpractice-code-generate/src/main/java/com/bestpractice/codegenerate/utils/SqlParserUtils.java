package com.bestpractice.codegenerate.utils;

import java.util.ArrayList;
import java.util.List;

import com.bestpractice.codegenerate.model.ColumnDef;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.create.table.ColumnDefinition;
import net.sf.jsqlparser.statement.create.table.CreateTable;

public class SqlParserUtils {
	
	public static List<ColumnDef> parseSql(String sql) {
		Statement parseResult = null;
		try {
			parseResult = CCJSqlParserUtil.parse(sql);
		} catch (JSQLParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CreateTable createTableStatement = (CreateTable) parseResult;
		List<ColumnDefinition> columnDefinitions = createTableStatement
				.getColumnDefinitions();
		List<ColumnDef> defs = new ArrayList<ColumnDef>();
		for (ColumnDefinition def : columnDefinitions) {
			System.out.println(removeQuote(def.getColumnName()) + " "
					+ def.getColDataType().getDataType() + " "
					+ parseDescription(def.getColumnSpecStrings()));
			defs.add(new ColumnDef(CamelUtils.toCamelCase(removeQuote(def.getColumnName())), def
					.getColDataType().getDataType(), parseDescription(def
					.getColumnSpecStrings())));
		}
		return defs;
	}

	private static String removeQuote(String name) {
		if (name == null || name.length() == 0) {
			return name;
		}
		name = name.replace("`", "");
		return name.replace("'", "");
	}

	private static String parseDescription(List<String> list) {
		String result = null;
		if (list == null || list.size() < 2) {
			return result;
		}
		int indexOfComment = -1;
		for (int i = 0; i < list.size(); i++) {
			if ("comment".equalsIgnoreCase(list.get(i))) {
				indexOfComment = i;
			}
		}
		if (indexOfComment > -1 && list.size() - 1 >= indexOfComment + 1) {
			return removeQuote(list.get(indexOfComment + 1));
		}
		return result;
	}
}
