<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<script language="javascript" src="${pageContext.request.contextPath}/fckeditor/fckeditor.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/js/jquery-fckeditor.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/js/user_add.js"></script>
<html>
<head>
    <title>买家设置</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/>
            买家信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <s:form action="userAction_add.action">
        <div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="${pageContext.request.contextPath}/css/blue/images/item_point.gif" /> 部门信息 </DIV>  -->
        </div>

        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
                        <td>买家姓名</td>
                        <td>
                            <s:textfield name="name" cssClass="InputStyle"></s:textfield>
                            <s:label id="name"></s:label></td>
                    </tr>
                    <tr>
                        <td>密码</td>
                        <td>
                            <s:password name="password" value="以字母开头，长度在6~18之间，只能包含字符、数字和下划线" cssClass="InputStyle"></s:password>
                            <s:label id="password"></s:label>
                        </td>
                    </tr>
                    <tr>
                        <td>确认密码</td>
                        <td>
                            <s:password name="password2" cssClass="inputstyle"></s:password>
                            <s:label id="password2"></s:label>
                        </td>
                    </tr>
                    <tr>
                        <td>email</td>
                        <td>
                            <s:textfield name="email" cssClass="InputStyle"></s:textfield>
                            <s:label id="email"></s:label>
                        </td>
                    </tr>
                    <tr>
                        <td>联系方式</td>
                        <td>
                            <s:textfield name="phone" cssClass="InputStyle"></s:textfield>
                            <s:label id="phone"></s:label>
                        </td>
                    </tr>
                    <tr>
                        <td>用户信誉</td>
                        <td>
                            <s:textfield name="ureputation" cssClass="InputStyle"></s:textfield>
                            <s:label id="ureputation"></s:label>
                        </td>
                    </tr>
                    <tr>
                        <td>地址</td>
                        <td><s:textarea name="address" cssClass="TextareaStyle"></s:textarea></td>
                    </tr>
                </table>
            </div>
        </div>

        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="image" src="${pageContext.request.contextPath}/css/images/save.png"/>
            <a href="javascript:history.go(-1);"><img
                    src="${pageContext.request.contextPath}/css/images/goBack.png"/></a>
        </div>
    </s:form>
</div>
</body>
</html>
