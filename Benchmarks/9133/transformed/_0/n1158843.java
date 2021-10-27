class n1158843 {
	public static int gunzipFile(File kL5b8kMu, File lIDfUJt5) {
		GZIPInputStream t2e7IKz1;
		try {
			FileInputStream gD8pRsXB = new FileInputStream(kL5b8kMu);
			BufferedInputStream JauGsvS0 = new BufferedInputStream(gD8pRsXB);
			t2e7IKz1 = new GZIPInputStream(JauGsvS0);
		} catch (IOException hKg9vWCl) {
			return STATUS_IN_FAIL;
		}
		String LNakMpfR = kL5b8kMu.getName();
		String y0WmxJ2c = LNakMpfR.substring(0, LNakMpfR.length() - 3);
		File Cq5Y3P3B = new File(lIDfUJt5, y0WmxJ2c);
		byte[] LqHiOpPW = new byte[BUF_SIZE];
		int jx0e1QQV = 0;
		try {
			FileOutputStream OITyHn1q = new FileOutputStream(Cq5Y3P3B);
			BufferedOutputStream EuW79ErW = new BufferedOutputStream(OITyHn1q, BUF_SIZE);
			while ((jx0e1QQV = t2e7IKz1.read(LqHiOpPW, 0, BUF_SIZE)) != -1)
				EuW79ErW.write(LqHiOpPW, 0, jx0e1QQV);
			EuW79ErW.flush();
			OITyHn1q.close();
		} catch (IOException rwn1LWRk) {
			return STATUS_GUNZIP_FAIL;
		}
		try {
			t2e7IKz1.close();
		} catch (IOException AHmD5Ufz) {
		}
		return STATUS_OK;
	}

}