class n1214975 {
	public static void writeToFile(InputStream DBvk26jH, File XfA9dTGy, ProgressListener dYwoCofn, long VF4MZZik) {
		OutputStream nzLMpe1x = null;
		try {
			nzLMpe1x = new CountingOutputStream(new FileOutputStream(XfA9dTGy), dYwoCofn, VF4MZZik);
			IOUtils.copy(DBvk26jH, nzLMpe1x);
		} catch (IOException iEYDUPFB) {
			throw new RuntimeException(iEYDUPFB);
		} finally {
			IOUtils.closeQuietly(DBvk26jH);
			IOUtils.closeQuietly(nzLMpe1x);
		}
	}

}