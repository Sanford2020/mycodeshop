<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>文件上传: To Struts2 Action</title>
</head>
<body>

    <s:form action="fileUpload" method="POST" enctype ="multipart/form-data" > 
        <s:file name="inFile" label="文件" /> 
        <s:textfield name="description" label="文件描述" />        
        <s:submit /> 
    </s:form>

</body>
</html>