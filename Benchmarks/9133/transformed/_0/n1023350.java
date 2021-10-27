class n1023350 {
	public static void download(URL QpuAieeA, File IgRyyJ18, String C6DUplfX) throws IOException {
		URLConnection t0bBalbP = QpuAieeA.openConnection();
		if (C6DUplfX != null) {
			t0bBalbP.setRequestProperty("User-Agent", C6DUplfX);
		}
		InputStream qNdSsuUQ = t0bBalbP.getInputStream();
		FileOutputStream wpxiyvlZ = new FileOutputStream(IgRyyJ18);
		StreamUtil.copyThenClose(qNdSsuUQ, wpxiyvlZ);
	}

}