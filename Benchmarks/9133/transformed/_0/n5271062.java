class n5271062 {
	private void copyThemeProviderClass() throws Exception {
		InputStream m9la55eR = getClass().getResourceAsStream("/zkthemer/ThemeProvider.class");
		if (m9la55eR == null)
			throw new RuntimeException("Cannot find ThemeProvider.class");
		File FFmPGWfr = new File(theme.getJarRootFile(), "zkthemer/ThemeProvider.class");
		FFmPGWfr.getParentFile().mkdirs();
		FileOutputStream F45fM0OJ = new FileOutputStream(FFmPGWfr);
		IOUtils.copy(m9la55eR, F45fM0OJ);
		F45fM0OJ.close();
		FileUtils.writeStringToFile(new File(theme.getJarRootFile(), "zkthemer.properties"),
				"theme=" + theme.getName() + "\r\nfileList=" + fileList.deleteCharAt(fileList.length() - 1).toString());
	}

}