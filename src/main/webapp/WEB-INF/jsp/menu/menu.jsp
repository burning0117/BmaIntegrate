<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="span10 last">
    <div class="topNav clearfix">
        <ul>
            <s:if test="#session.existUser == null">
                <li id="headerLogin" class="headerLogin" style="display: list-item;">
                    <a href="${ pageContext.request.contextPath }/preuserAction_loginPage.action">登录</a>|
                </li>
                <li id="headerRegister" class="headerRegister"
                    style="display: list-item;"><a
                        href="${ pageContext.request.contextPath }/preuserAction_registPage.action">注册</a>|
                </li>
            </s:if>
            <s:else>
                <li id="headerLogin" class="headerLogin" style="display: list-item;">
                    欢迎你：<s:property value="#session.existUser.username"/>
                    |
                </li>
                <li id="headerLogin" class="headerLogin" style="display: list-item;">
                    <a href="${ pageContext.request.contextPath }/orderAction_findByUid.action?page=1">我的订单</a>
                    |
                </li>
                <li id="headerRegister" class="headerRegister"
                    style="display: list-item;"><a href="${pageContext.request.contextPath }/preuserAction_quit.action">退出</a>|
                </li>
            </s:else>

            <li><a>会员中心</a> |</li>
            <li><a>购物指南</a> |</li>
            <li><a>关于我们</a></li>
        </ul>
    </div>
    <div class="cart">
        <a href="${ pageContext.request.contextPath }/cartAction_myCart.action">购物车</a>
    </div>
    <div class="phone">
        客服热线: <strong>0532/88888888</strong>
    </div>
</div>
<div class="span24">
    <ul class="mainNav">
        <li><a href="${ pageContext.request.contextPath }/indexAction.action">首页</a> |</li>
        <s:iterator var="c" value="#session.categoryList">
            <li>
                <a href="${ pageContext.request.contextPath }/productionAction_findByCid.action?cid=<s:property value="#c.cid"/>&page=1"><s:property
                        value="#c.cname"/></a> |
            </li>
        </s:iterator>

    </ul>
</div>