<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<script src="${pageContext.request.contextPath}/js/user_list.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-checkbox.js"></script>
<html>
<head>
    <title>买家列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/>
            买家管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>
<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
        <!-- 表头-->
        <thead>
        <tr align=center valign=middle id=TableTitle>
            <td>
                <input type="checkbox" name="allcheck"/>全选
            </td>
            <td>买家姓名</td>
            <td>联系方式</td>
            <td>email</td>
            <td>买方信誉</td>
            <td>买方地址</td>
            <td>相关操作</td>
        </tr>
        </thead>
        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="userList">
        <s:iterator value="#userList">
            <tr class="TableDetail1 template">
                <td><input type="checkbox" name="userCheckBox"/></td>
                <s:hidden value="uid"/>
                <td><s:property value="name"/></td>
                <td><s:property value="phone"/></td>
                <td><s:property value="email"/></td>
                <td><s:property value="ureputation"/></td>
                <td><s:property value="address"/></td>
                <td>
                    <s:a action="userAction_deleteUser?uid=%{uid}">删除</s:a>
                    <s:a action="userAction_updateUI?uid=%{uid}">修改</s:a>
                </td>
            </tr>
        </s:iterator>
        <!--
            list中含有list
         -->
        <!--
			  <s:iterator>
			  	<s:iterator>
			  		<s:property value="name"/>
			  	</s:iterator>
			  </s:iterator>
			   -->
        <!--
            list中含有map
         -->
        <!--
			   <s:iterator value="#list">
			   	  <s:iterator value="top">
			   	  	<s:property value="key"/>
			   	  	<s:property value="value.name"/>
			   	  </s:iterator>
			   </s:iterator>
			    -->
        <!--
            map中含有list
         -->
        <!--
			     <s:iterator value="#maps">
			     	<s:property value="key"/>
			     	<!--
			     		该迭代就是一个list
			     	 -->
        <!--
			     	<s:iterator value="value">
			     		<s:property value="name"/>
			     	</s:iterator>
			     </s:iterator>
			      -->
        </tbody>
    </table>
    <div id="TableTail">
        <div id="TableTail_inside">
            <a href="userAction_addUI.action"><img
                    src="${pageContext.request.contextPath}/css/images/createNew.png"/></a>
        </div>
    </div>
</div>

</body>
</html>
