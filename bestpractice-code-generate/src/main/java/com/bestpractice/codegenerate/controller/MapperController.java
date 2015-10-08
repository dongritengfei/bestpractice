package com.bestpractice.codegenerate.controller;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bestpractice.codegenerate.model.ColumnDef;
import com.bestpractice.codegenerate.utils.CamelUtils;
import com.bestpractice.codegenerate.utils.SqlParserUtils;
import com.bestpractice.codegenerate.utils.VelocityBuilder;

@Controller("mapperController")
@RequestMapping("/mapper")
public class MapperController {
	@RequestMapping("showForm")
	public ModelAndView showForm(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("generate-mapper");
		return mv;
	}
	
	@RequestMapping("generateCode")
	public ModelAndView generateCode(@RequestParam String createStatement, @RequestParam String mappClassNameWithPackage, @RequestParam String modelClassName) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("generate-mapper");
		List<ColumnDef> columnDefList = SqlParserUtils
				.parseSql(createStatement);
		
		String mapperXml = VelocityBuilder.create()
				.add("columnDefList", columnDefList)
				.add("mappClassNameWithPackage", mappClassNameWithPackage)
				.add("modelClassName", modelClassName)
				.add("tableName", CamelUtils.toUnderlineName(modelClassName))
				.render("mapper.xml.vm");
		mv.addObject("mapperXml", mapperXml);
		
		String modelJava = VelocityBuilder.create()
				.add("columnDefList", columnDefList)
				.add("mappClassNameWithPackage", mappClassNameWithPackage)
				.add("modelClassName", modelClassName)
				.add("tableName", CamelUtils.toUnderlineName(modelClassName))
				.add("serialVersionUID", new Random().nextLong() + "L")
				.render("model.java.vm");
		mv.addObject("modelJava", modelJava);
		
		mv.addObject("createStatement", createStatement);
		mv.addObject("mappClassNameWithPackage", mappClassNameWithPackage);
		mv.addObject("modelClassName", modelClassName);
		return mv;
	}

}
