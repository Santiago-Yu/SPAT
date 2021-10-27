class n12721184 {
	public static int fileCopy(String FK0sVevm, String LSY6Ortl, String LwWBGKID) throws IOException {
		String qlDvXYlu = System.getProperty("file.separator");
		File Q1NEExlr = new File(FK0sVevm);
		if (!Q1NEExlr.exists())
			Q1NEExlr.mkdirs();
		File N4eH9AF9 = new File(LSY6Ortl);
		if (!N4eH9AF9.exists())
			N4eH9AF9.mkdirs();
		FileInputStream shdkrn9Y = null;
		FileOutputStream pTTuwkz7 = null;
		try {
			shdkrn9Y = new FileInputStream(new File(FK0sVevm + qlDvXYlu + LwWBGKID));
			pTTuwkz7 = new FileOutputStream(new File(LSY6Ortl + qlDvXYlu + LwWBGKID));
			IOUtils.copy(shdkrn9Y, pTTuwkz7);
		} catch (Exception MU1v4lI6) {
			return -1;
		} finally {
			try {
				pTTuwkz7.close();
				shdkrn9Y.close();
			} catch (Exception Je8wPbrx) {
			}
		}
		return 0;
	}

}