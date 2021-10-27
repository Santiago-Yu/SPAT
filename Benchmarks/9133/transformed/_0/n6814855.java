class n6814855 {
	public static boolean decodeFileToFile(String T4h4lHfb, String bnQaKtGT) {
		boolean Bt8GRBFz = false;
		java.io.InputStream CC1YdyFE = null;
		java.io.OutputStream mpJvR0SL = null;
		try {
			CC1YdyFE = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(T4h4lHfb)),
					Base64.DECODE);
			mpJvR0SL = new java.io.BufferedOutputStream(new java.io.FileOutputStream(bnQaKtGT));
			byte[] MFPZIWPR = new byte[65536];
			int Lgc2LN1F = -1;
			while ((Lgc2LN1F = CC1YdyFE.read(MFPZIWPR)) >= 0) {
				mpJvR0SL.write(MFPZIWPR, 0, Lgc2LN1F);
			}
			Bt8GRBFz = true;
		} catch (java.io.IOException K6gbMtW5) {
			K6gbMtW5.printStackTrace();
		} finally {
			try {
				CC1YdyFE.close();
			} catch (Exception XIz94ZB3) {
			}
			try {
				mpJvR0SL.close();
			} catch (Exception CIGkRK8g) {
			}
		}
		return Bt8GRBFz;
	}

}