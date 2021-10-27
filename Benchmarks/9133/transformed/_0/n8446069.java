class n8446069 {
	public static String test(String U79Inqpv, String GF0iGM6P, String cGMIdbYO, String lmVf4Zpn) throws Exception {
		FTPClient DGcRjav4 = new FTPClient();
		try {
			String L6RdSgju = GF0iGM6P;
			DGcRjav4.connect(U79Inqpv);
			DGcRjav4.login(cGMIdbYO, lmVf4Zpn);
			int RfNtlHSs = DGcRjav4.getReplyCode();
			if (!FTPReply.isPositiveCompletion(RfNtlHSs)) {
				DGcRjav4.disconnect();
				System.err.println("FTP server refused connection.");
				return null;
			}
			DGcRjav4.setFileType(FTP.IMAGE_FILE_TYPE);
			DGcRjav4.enterLocalPassiveMode();
			boolean s4Il6RRj = isDir(DGcRjav4, L6RdSgju);
			if (s4Il6RRj) {
				FTPFile[] zBhnP8Se = DGcRjav4.listFiles(L6RdSgju);
				for (int IJJ6P9R1 = 0; IJJ6P9R1 < zBhnP8Se.length; IJJ6P9R1++) {
				}
			} else {
				ByteArrayOutputStream CgWFJ0XU = new ByteArrayOutputStream();
				if (DGcRjav4.retrieveFile(L6RdSgju, CgWFJ0XU)) {
				} else {
					throw new IOException("Unable to retrieve file:" + L6RdSgju);
				}
			}
			return "";
		} finally {
			closeConnection(DGcRjav4);
		}
	}

}