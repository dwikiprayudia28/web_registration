<%@ page contentType="application.pdf" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import="net.sf.jasperreports.engine.*" %>
<%@ page import="net.sf.jasperreports.engine.data.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>


<%
Map<String, Object> parameters = new java.util.HashMap();
try{
	List<Map<String, ?>> dataSource = (List<Map<String, ?>>) request.getAttribute("listObj");
	JRDataSource jrDataSource = new JRBeanCollectionDataSource(dataSource);
	String jrxmlFile = session.getServletContext().getRealPath("/WEB-INF/views/printAction/report/purchOrd.jrxml");
	
	InputStream input = new FileInputStream(new File(jrxmlFile));
	
	
    parameters.put("logo", session.getServletContext().getRealPath("/WEB-INF/views/printAction/images/logo_dashboard.png"));
	
	JasperReport jasperReport = JasperCompileManager.compileReport(input);
	JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrDataSource);
	JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	response.getOutputStream().flush();
	response.getOutputStream().close();
}catch (Exception e){
	e.printStackTrace();
}

%>