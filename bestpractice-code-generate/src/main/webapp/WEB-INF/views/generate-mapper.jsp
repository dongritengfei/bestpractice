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
	<label for="mappClassNameWithPackage">Mapper��ȫ����</label><input type="text" id="mappClassNameWithPackage" name="mappClassNameWithPackage"><br>
	<label for="modelClassName">Model������</label><input type="text" id="modelClassName" name="modelClassName"><br>
	<label>�����sql��䣺</label><br><textarea name="createStatement" rows="30" cols="200"></textarea>
	<br>
	<input type="submit" value="���ɴ���">
</form>
<br>
<h2>���ɵĴ������£�</h2>
<label>mapper.xml��</label>
<br>
<textarea  rows="30" cols="200">${mapperXml}</textarea>
<br><br>
<label>model.java��</label>
<br>
<textarea  rows="30" cols="200">${modelJava}</textarea>
</body>
</html>