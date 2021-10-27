class n12721185 {
	public static int fileUpload(long lngFileSize, InputStream inputStream, String strFilePath, String strFileName)
			throws IOException {
		if (lngFileSize > (10 * 1024 * 1024)) {
			return -1;
		}
		String SEPARATOR = System.getProperty("file.separator");
		FileOutputStream fos = null;
		InputStream is = null;
		try {
			File dir = new File(strFilePath);
			is = inputStream;
			if (!dir.exists())
				dir.mkdirs();
			fos = new FileOutputStream(new File(strFilePath + SEPARATOR + strFileName));
			IOUtils.copy(is, fos);
		} catch (Exception ex) {
			return -2;
		} finally {
			try {
				fos.close();
				is.close();
			} catch (Exception ex2) {
			}
		}
		return 0;
	}

}