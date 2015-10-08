<%@ page pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html> 
<html>
<head>
    <title>Spring MVC Hello World</title>
    <meta http-equiv="content-type" content="text/html;charset=GBK	">
</head>
 
<body>
<style>
	label,input{
		width:120px;
		display:inline-block;
		margin-bottom:10px;
		font-size:12;
	}
	input[type="submit"]{
		height: 40px;
	}
</style>
<form action="../mapper/generateCode" method="post">
	<label for="mappClassNameWithPackage">Mapper类全名：</label><input type="text" id="mappClassNameWithPackage" name="mappClassNameWithPackage"><br>
	<label for="modelClassName">Model类名：</label><input type="text" id="modelClassName" name="modelClassName"><br>
	<label>建表的sql语句：</label><br><textarea name="createStatement" rows="30" cols="200"></textarea>
	<br>
	<input type="submit" value="生成代码">
</form>
<br>
<h2>生成的代码如下：</h2>
<label>mapper.xml：</label>
<br>
<textarea  rows="30" cols="200">${mapperXml}</textarea>
<br><br>
<label>model.java：</label>
<br>
<textarea  rows="30" cols="200">${modelJava}</textarea>
</body>
</html>