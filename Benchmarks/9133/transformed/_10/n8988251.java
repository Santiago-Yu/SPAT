class n8988251 {
	private static void exportConfigResource(ClassLoader classLoader, String resourceName, String targetFileName)
			throws Exception {
		FileOutputStream fos = new FileOutputStream(targetFileName, false);
		InputStream is = classLoader.getResourceAsStream(resourceName);
		IOUtils.copy(is, fos);
		fos.close();
		is.close();
	}

}