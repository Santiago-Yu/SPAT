class n22246375 {
	public static boolean decodeFileToFile(String zc08ooOD, String IAB6u59l) {
		boolean RUerAEFk = false;
		java.io.InputStream FH0dKt0M = null;
		java.io.OutputStream GcPERvqf = null;
		try {
			FH0dKt0M = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(zc08ooOD)),
					Base64.DECODE);
			GcPERvqf = new java.io.BufferedOutputStream(new java.io.FileOutputStream(IAB6u59l));
			byte[] Qb3V4Fta = new byte[65536];
			int OHWlcIlS = -1;
			while ((OHWlcIlS = FH0dKt0M.read(Qb3V4Fta)) >= 0) {
				GcPERvqf.write(Qb3V4Fta, 0, OHWlcIlS);
			}
			RUerAEFk = true;
		} catch (java.io.IOException ag48MBuW) {
			ag48MBuW.printStackTrace();
		} finally {
			try {
				FH0dKt0M.close();
			} catch (Exception WSVA97cZ) {
			}
			try {
				GcPERvqf.close();
			} catch (Exception VCuxuUSI) {
			}
		}
		return RUerAEFk;
	}

}