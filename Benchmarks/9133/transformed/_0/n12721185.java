class n12721185 {
	public static int fileUpload(long q0EbW5f4, InputStream Jd0pLEcB, String Ho5fmFCb, String ijtMO0P1)
			throws IOException {
		String UXOSD9UD = System.getProperty("file.separator");
		if (q0EbW5f4 > (10 * 1024 * 1024)) {
			return -1;
		}
		InputStream QuZWL69j = null;
		FileOutputStream wGUKu18t = null;
		try {
			File LEJSUpin = new File(Ho5fmFCb);
			if (!LEJSUpin.exists())
				LEJSUpin.mkdirs();
			QuZWL69j = Jd0pLEcB;
			wGUKu18t = new FileOutputStream(new File(Ho5fmFCb + UXOSD9UD + ijtMO0P1));
			IOUtils.copy(QuZWL69j, wGUKu18t);
		} catch (Exception RKfZik58) {
			return -2;
		} finally {
			try {
				wGUKu18t.close();
				QuZWL69j.close();
			} catch (Exception R43BEpkH) {
			}
		}
		return 0;
	}

}