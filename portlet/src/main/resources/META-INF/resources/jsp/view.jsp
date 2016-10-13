<%@ include file="init.jsp" %>

<h1><liferay-ui:message key="whois.title" /></h1>

<c:if test="${not empty siteInfo}">
<% SiteInfoDTO info = (SiteInfoDTO) request.getAttribute("siteInfo"); %>
<h3><liferay-ui:message key="whois.owner"/></h3>
<dl class="dl-horizontal">
  <dt><liferay-ui:message key="whois.person"/></dt>
  <dd><%= info.owner.person %></dd>
  
  <dt><liferay-ui:message key="whois.organization"/></dt>
  <dd><%= info.owner.organization %></dd>
  
  <dt><liferay-ui:message key="whois.phone"/></dt>
  <dd><%= info.owner.phoneNumber %></dd>
</dl>
<h3><liferay-ui:message key="whois.admin"/></h3>
<dl class="dl-horizontal">
  <dt><liferay-ui:message key="whois.person"/></dt>
  <dd><%= info.admin.person %></dd>
  
  <dt><liferay-ui:message key="whois.organization"/></dt>
  <dd><%= info.admin.organization %></dd>
  
  <dt><liferay-ui:message key="whois.phone"/></dt>
  <dd><%= info.admin.phoneNumber %></dd>
</dl>
</c:if>

<portlet:actionURL name="whoisLookup" var="whoisUrl"/>


<div class="panel panel-default">
  <div class="panel-body">    
	<aui:form action="${whoisUrl}" method="post" name="whois">
		<aui:input name="url" type="text" value="" />
		<aui:button name="submit" value="Lookup" type="submit"/>
	</aui:form>
  </div>
</div>
