<%-- WARNING: IF YOU CHANGE THIS CODE PASS THE MANUAL TEST ON DateCalendarTest.txt --%>

<%@ page import="org.openxava.model.meta.MetaProperty" %>

<jsp:useBean id="style" class="org.openxava.web.style.Style" scope="request"/>
  
<%
// TMP FALTA PASAR A OpenXava
String propertyKey = request.getParameter("propertyKey");
MetaProperty p = (MetaProperty) request.getAttribute(propertyKey);
String fvalue = (String) request.getAttribute(propertyKey + ".fvalue");
String align = p.isNumber()?"right":"left";
boolean editable="true".equals(request.getParameter("editable"));
String disabled=editable?"":"disabled";
String script = request.getParameter("script");
boolean label = org.openxava.util.XavaPreferences.getInstance().isReadOnlyAsLabel();
if (editable || !label) {
	String dateClass = editable?"xava_date":""; // tmp
%>
<%-- tmp
<span class="<%=style.getDateCalendar()%>">
<input type="text" name="<%=propertyKey%>" id="<%=propertyKey%>" class=<%=style.getEditor()%> title="<%=p.getDescription(request)%>"
	tabindex="1" 
	align='<%=align%>'
	maxlength="19" 
	size="19"  	
	value="<%=fvalue%>"
	<%=disabled%>
	<%=script%>><%if (editable) {%><a style="position: relative; right: 25px;" href="javascript:showCalendar('<%=propertyKey%>', '<%=org.openxava.util.Dates.dateTimeFormatForJSCalendar(org.openxava.util.Locales.getCurrent())%>', '12')"><i class="mdi mdi-calendar-clock"></i></a><%} %>
--%>	
<%-- tmp ini --%>
<span class="<%=dateClass%> <%=style.getDateCalendar()%>" 
	data-date-format="<%=org.openxava.util.Dates.dateTimeFormatForJSCalendar()%>"
	data-enable-time="true">
	<input type="text" name="<%=propertyKey%>" id="<%=propertyKey%>" class="<%=style.getEditor()%>" title="<%=p.getDescription(request)%>"
		tabindex="1" 
		align='<%=align%>'
		maxlength="19"
		data-input
		size="19" 
		value="<%=fvalue%>" <%=disabled%> <%=script%>><%if (editable) {%><a href="javascript:void(0)" data-toggle style="position: relative; right: 25px;"><i class="mdi mdi-calendar-clock"></i></a><%} %>	
<%-- tmp fin --%>
</span>

<%
} else {
%>
<%=fvalue%>&nbsp;	
<%
}
%>
<% if (!editable) { %>
	<input type="hidden" name="<%=propertyKey%>" value="<%=fvalue%>">
<% } %>			
