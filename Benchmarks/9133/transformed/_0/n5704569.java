class n5704569 {
	public static void copy(File TliS2LUH, File zRkbFNBL) throws IOException {
		if (!TliS2LUH.exists()) {
			throw new IOException(StaticUtils.format(OStrings.getString("LFC_ERROR_FILE_DOESNT_EXIST"),
					new Object[] { TliS2LUH.getAbsolutePath() }));
		}
		FileInputStream Y2zgPsVz = new FileInputStream(TliS2LUH);
		zRkbFNBL.getParentFile().mkdirs();
		FileOutputStream FWzMSR1J = new FileOutputStream(zRkbFNBL);
		byte[] OuWLQLot = new byte[BUFSIZE];
		int VaGkM6DT;
		while ((VaGkM6DT = Y2zgPsVz.read(OuWLQLot)) > 0)
			FWzMSR1J.write(OuWLQLot, 0, VaGkM6DT);
		Y2zgPsVz.close();
		FWzMSR1J.close();
	}

}