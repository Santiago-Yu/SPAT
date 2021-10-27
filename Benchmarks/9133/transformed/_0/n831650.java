class n831650 {
	public static boolean decodeFileToFile(String VLLKxlQI, String zsQHBPzz) {
		boolean ugGpBmB2 = false;
		java.io.InputStream BWUZFL3B = null;
		java.io.OutputStream KeydaBn2 = null;
		try {
			BWUZFL3B = new Base64.InputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(VLLKxlQI)),
					Base64.DECODE);
			KeydaBn2 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(zsQHBPzz));
			byte[] PbqlEoaN = new byte[65536];
			int qSUNUGGL = -1;
			while ((qSUNUGGL = BWUZFL3B.read(PbqlEoaN)) >= 0) {
				KeydaBn2.write(PbqlEoaN, 0, qSUNUGGL);
			}
			ugGpBmB2 = true;
		} catch (java.io.IOException J72qV671) {
			J72qV671.printStackTrace();
		} finally {
			try {
				BWUZFL3B.close();
			} catch (Exception ICZe7nmd) {
			}
			try {
				KeydaBn2.close();
			} catch (Exception OBa7ju3W) {
			}
		}
		return ugGpBmB2;
	}

}