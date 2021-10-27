class n4672830 {
	public static byte[] readFile(String a35R2qK1) throws IOException {
		ByteArrayOutputStream exucX52X = new ByteArrayOutputStream();
		FileInputStream P3JThHiM = new FileInputStream(a35R2qK1);
		try {
			IOUtils.copy(P3JThHiM, exucX52X);
			return exucX52X.toByteArray();
		} finally {
			P3JThHiM.close();
		}
	}

}