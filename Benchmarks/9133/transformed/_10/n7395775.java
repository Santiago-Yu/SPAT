class n7395775 {
	private void copyReportFile(ServletRequest req, String reportName, Report report)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException,
			FileNotFoundException, IOException {
		ByteArrayInputStream bais = new ByteArrayInputStream(report.getReportContent());
		String reportFileName = (String) Class.forName("org.eclipse.birt.report.utility.ParameterAccessor")
				.getMethod("getReport", new Class[] { HttpServletRequest.class, String.class })
				.invoke(null, new Object[] { req, reportName });
		FileOutputStream fos = new FileOutputStream(new File(reportFileName));
		IOUtils.copy(bais, fos);
		bais.close();
		fos.close();
	}

}