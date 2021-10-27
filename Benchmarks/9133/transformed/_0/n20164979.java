class n20164979 {
	private void handleUpload(CommonsMultipartFile Jpaj1u5S, String n3e2RigG, String Ft8qySwC)
			throws IOException, FileNotFoundException {
		File mxntkpxV = new File(Ft8qySwC);
		if (!mxntkpxV.exists()) {
			mxntkpxV.mkdirs();
		}
		InputStream KLHbs97p = Jpaj1u5S.getInputStream();
		OutputStream GKSE6eMh = new FileOutputStream(Ft8qySwC + n3e2RigG);
		IOUtils.copy(KLHbs97p, GKSE6eMh);
	}

}