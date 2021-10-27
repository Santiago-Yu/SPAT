class n8625346 {
	public static boolean encodeFileToFile(String V9TVr6fH, String OHw2WYtr) {
		boolean FupAOcuZ = false;
		java.io.InputStream ipNcGnAO = null;
		java.io.OutputStream AoEQpl1c = null;
		try {
			ipNcGnAO = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(V9TVr6fH)),
					Base64.ENCODE);
			AoEQpl1c = new java.io.BufferedOutputStream(new java.io.FileOutputStream(OHw2WYtr));
			byte[] E8XuR1om = new byte[65536];
			int F5Sacdrw = -1;
			while ((F5Sacdrw = ipNcGnAO.read(E8XuR1om)) >= 0) {
				AoEQpl1c.write(E8XuR1om, 0, F5Sacdrw);
			}
			FupAOcuZ = true;
		} catch (java.io.IOException hv658Fsy) {
			hv658Fsy.printStackTrace();
		} finally {
			try {
				ipNcGnAO.close();
			} catch (Exception fO8SbfJT) {
			}
			try {
				AoEQpl1c.close();
			} catch (Exception Aaho6kku) {
			}
		}
		return FupAOcuZ;
	}

}