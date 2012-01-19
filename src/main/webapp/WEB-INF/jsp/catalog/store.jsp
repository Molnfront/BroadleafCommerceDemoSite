<%@ include file="/WEB-INF/jsp/include.jsp" %>
<tiles:insertDefinition name="baseNoSide">
	<tiles:putAttribute name="mainContent" type="string">

    <cms:content contentType="Message" contentName="Home Page Message" contentItemVar="item">
        <c:if test="${numResults > 0}">
            <h3>${item.messageText}</h3>
        </c:if>
    </cms:content>

	<div class="splashContainer">
	<div class="dontMiss">
        <cms:content contentType="Homepage Banner Ad" contentItemVar="item">
            <a href='<cms:url value="${item.targetUrl}"/>'><img src='<cms:url value="${item.imageUrl}"/>' /></a>
        </cms:content>
	</div>
	<div class="sidePromoContainer">
        <cms:content contentType="Homepage Small Ad" count="2" contentListVar="itemList">
            <c:forEach var="item" items="${itemList}">
                <div class="sidePromo">
                    <a href='<cms:url value="${item.targetUrl}"/>'><img src='<cms:url value="${item.imageUrl}"/>' /></a>
		        </div>
            </c:forEach>
        </cms:content>
	</div>

	</tiles:putAttribute>
</tiles:insertDefinition>