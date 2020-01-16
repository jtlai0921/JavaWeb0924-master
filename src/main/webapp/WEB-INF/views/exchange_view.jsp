<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:formatNumber value="${requestScope.exchangePrice}" type="number" maxFractionDigits="2"/>
<!-- https://www.tutorialspoint.com/jsp/jstl_format_formatnumber_tag.htm -->

