class n3768629 {
	public static boolean decodeFileToFile(String IRszbkiu, String Dq0k9Hay) {
		boolean TMVTd6Qw = false;
		java.io.InputStream Xel1HvgE = null;
		java.io.OutputStream gZj0KR7T = null;
		try {
			Xel1HvgE = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(IRszbkiu)),
					Base64.DECODE);
			gZj0KR7T = new java.io.BufferedOutputStream(new java.io.FileOutputStream(Dq0k9Hay));
			byte[] PSC1KMuK = new byte[65536];
			int eEbxNoHU = -1;
			while ((eEbxNoHU = Xel1HvgE.read(PSC1KMuK)) >= 0) {
				gZj0KR7T.write(PSC1KMuK, 0, eEbxNoHU);
			}
			TMVTd6Qw = true;
		} catch (java.io.IOException Q8HjOK6Y) {
			Q8HjOK6Y.printStackTrace();
		} finally {
			try {
				Xel1HvgE.close();
			} catch (Exception Jz9e6T4k) {
			}
			try {
				gZj0KR7T.close();
			} catch (Exception McLP9lSO) {
			}
		}
		return TMVTd6Qw;
	}

}