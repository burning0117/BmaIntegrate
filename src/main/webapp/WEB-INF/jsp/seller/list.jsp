<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<script language="javascript" src="${pageContext.request.contextPath}/js/jquery-checkbox.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/js/user_list.js"></script>
<html>
<head>
    <title>卖家列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/>
            卖家管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
        <!-- 表头-->
        <thead>
        <tr align=center valign=middle id="TableTitle">
            <td>
                <input type="checkbox" name="allcheck"/>全选
            </td>
            <td>姓名</td>
            <td>联系方式</td>
            <td>卖方信誉</td>
            <td>地址</td>
            <td>相关操作</td>
        </tr>
        </thead>
        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="sellerList">
        <s:iterator value="#sellerList">
            <tr class="TableDetail1 template">
                <td>
                    <input type="checkbox"/>
                </td>
                <td><s:property value="name"/></td>
                <s:hidden name="sid"></s:hidden>
                <td><s:property value="phone"/></td>
                <td><s:property value="sreputation"/></td>
                <td><s:property value="address"/></td>
                <td>
                    <s:a action="sellerAction_deleteSeller?sid=%{sid}">删除</s:a>
                    <s:a action="sellerAction_updateUI?sid=%{sid}">修改</s:a>
                </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>
    <div id="TableTail">
        <div id="TableTail_inside">
            <a href="sellerAction_addUI.action"><img
                    src="${pageContext.request.contextPath}/css/images/createNew.png"/></a>
        </div>
    </div>
</div>

</body>
</html>
