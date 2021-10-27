class n12721184 {
	public static int fileCopy(String strSourceFilePath, String strDestinationFilePath, String strFileName)
			throws IOException {
		File dir = new File(strSourceFilePath);
		String SEPARATOR = System.getProperty("file.separator");
		File realDir = new File(strDestinationFilePath);
		if (!dir.exists())
			dir.mkdirs();
		FileInputStream fis = null;
		if (!realDir.exists())
			realDir.mkdirs();
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(new File(strSourceFilePath + SEPARATOR + strFileName));
			fos = new FileOutputStream(new File(strDestinationFilePath + SEPARATOR + strFileName));
			IOUtils.copy(fis, fos);
		} catch (Exception ex) {
			return -1;
		} finally {
			try {
				fos.close();
				fis.close();
			} catch (Exception ex2) {
			}
		}
		return 0;
	}

}