<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<%--<script language="javascript" src="${pageContext.request.contextPath}/js/user_add.js"></script>--%>
<html>
<head>
    <title>卖方设置</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/>
            卖方信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <s:form action="sellerAction_add.action">
        <div class="ItemBlock_Title1">
            <div class="ItemBlock_Title1">
                <img border="0" width="4" height="7"
                     src="${pageContext.request.contextPath}/css/blue/images/item_point.gif"/>卖家信息
            </div>
        </div>

        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
                        <td>卖家名</td>
                        <td><s:textfield name="name" cssClass="InputStyle"></s:textfield></td>
                    </tr>
                    <tr>
                        <td>密码</td>
                        <td><s:password name="password" cssClass="InputStyle"></s:password></td>
                    </tr>
                    <tr>
                        <td>确认密码</td>
                        <td><s:password name="password2" cssClass="InputStyle"></s:password></td>
                    </tr>
                    <tr>
                        <td>电话</td>
                        <td><s:textfield name="phone" cssClass="InputStyle"></s:textfield></td>
                    </tr>
                    <tr>
                        <td>卖家信誉</td>
                        <td><s:textfield name="sreputation" cssClass="InputStyle"></s:textfield></td>
                    </tr>
                    <tr>
                        <td>地址</td>
                        <td><s:textarea name="address" cssClass="TextareaStyle"></s:textarea></td>
                    </tr>
                    <tr>
                        <td>自我描述</td>
                        <td><s:textarea name="description" cssClass="TextareaStyle"></s:textarea></td>
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
