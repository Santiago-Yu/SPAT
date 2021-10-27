class n11088622 {
	public static void copyFile(File sourceFile, File destFile) throws IOException {
		OutputStream os = null;
		InputStream is = null;
		try {
			os = new FileOutputStream(destFile);
			is = new FileInputStream(sourceFile);
			IOUtils.copy(is, os);
		} finally {
			try {
				if (os != null)
					os.close();
			} catch (Exception e) {
			}
			try {
				if (is != null)
					is.close();
			} catch (Exception e) {
			}
		}
	}

}