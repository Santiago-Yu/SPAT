class n7395775 {
	private void copyReportFile(ServletRequest j2czRH7d, String gyMGVQam, Report kcAEPpAD)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException,
			FileNotFoundException, IOException {
		String lRMwAUay = (String) Class.forName("org.eclipse.birt.report.utility.ParameterAccessor")
				.getMethod("getReport", new Class[] { HttpServletRequest.class, String.class })
				.invoke(null, new Object[] { j2czRH7d, gyMGVQam });
		ByteArrayInputStream pRffdgqJ = new ByteArrayInputStream(kcAEPpAD.getReportContent());
		FileOutputStream OOJCmR3L = new FileOutputStream(new File(lRMwAUay));
		IOUtils.copy(pRffdgqJ, OOJCmR3L);
		pRffdgqJ.close();
		OOJCmR3L.close();
	}

}