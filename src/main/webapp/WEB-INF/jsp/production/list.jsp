<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<script language="javascript" src="${pageContext.request.contextPath}/js/jquery-checkbox.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/js/user_list.js"></script>
<html>
<head>
    <title>产品列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/css/images/title_arrow.gif"/>
            产品管理
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
            <td>产品名</td>
            <td>所属商家</td>
            <td>价格</td>
            <td>卖家对买家价格偏好系数</td>
            <td>卖方要求买方的信誉度</td>
            <td>卖方对卖方信誉度偏好系数</td>
            <td>卖方的服务质量</td>
            <td>相关操作</td>
        </tr>
        </thead>

        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="productionList">
        <s:iterator value="#productionList">
            <tr class="TableDetail1 template">
                <td><input type="checkbox"/></td>
                <td><s:property value="name"/></td>
                <s:hidden name="pid"></s:hidden>
                <td><s:property value="seller.name"/></td>
                <td><s:property value="price"/></td>
                <td><s:property value="pricerate"></s:property></td>
                <td><s:property value="preputation"/></td>
                <td><s:property value="preputationrate"/></td>
                <%--需要设置为不可修改，值传过来--%>
                <td><s:property value="pqos"/></td>
                <td>
                    <s:a action="productionAction_deleteProduction?pid=%{pid}">删除</s:a>
                    <s:a action="productionAction_updateUI?pid=%{pid}">修改</s:a>
                </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>
    <div id="TableTail">
        <div id="TableTail_inside">
            <a href="productionAction_addUI.action"><img
                    src="${pageContext.request.contextPath}/css/images/createNew.png"/></a>
        </div>
    </div>
</div>

</body>
</html>
