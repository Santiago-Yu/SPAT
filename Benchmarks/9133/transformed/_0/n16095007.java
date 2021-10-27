class n16095007 {
	private static void getFileFtp(String rC5Ytsoq, String qKOiiWcT, String fwIDRacl, int q6bnRJX5, String rCcWWajb,
			String DBxPtFkC) throws Exception {
		Log.info("\nretrieve " + rCcWWajb + NEW_LINE);
		FTPClient WCLHhuhL = new FTPClient();
		WCLHhuhL.connect(fwIDRacl, q6bnRJX5);
		int PHjEq7NM = WCLHhuhL.getReplyCode();
		if (!FTPReply.isPositiveCompletion(PHjEq7NM)) {
			throw new Exception("FTP fail to connect");
		}
		if (!WCLHhuhL.login(rC5Ytsoq, qKOiiWcT)) {
			throw new Exception("FTP fail to login");
		}
		try {
			File NV1btket = new File(DBxPtFkC);
			File yVi5Tmcf = new File(NV1btket, rCcWWajb);
			if (yVi5Tmcf.exists()) {
				yVi5Tmcf.delete();
			} else {
				NV1btket.mkdirs();
			}
			boolean PKvTpkf3 = WCLHhuhL.changeWorkingDirectory("/");
			Log.info("chdir-status:" + PKvTpkf3 + NEW_LINE);
			WCLHhuhL.setFileTransferMode(FTPClient.BINARY_FILE_TYPE);
			WCLHhuhL.setFileType(FTPClient.BINARY_FILE_TYPE);
			WCLHhuhL.enterLocalActiveMode();
			InputStream TDb0wJUz = WCLHhuhL.retrieveFileStream(rCcWWajb);
			if (TDb0wJUz == null) {
				Log.error("Input stream is null\n");
				throw new Exception("Fail to retrieve file " + rCcWWajb);
			}
			Thread.sleep(3000);
			saveInputStreamToFile(TDb0wJUz, new File(DBxPtFkC, rCcWWajb));
		} finally {
			WCLHhuhL.disconnect();
		}
	}

}