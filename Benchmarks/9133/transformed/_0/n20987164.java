class n20987164 {
	public static void copyFile(File JW9fn5mW, String vS7OI72w, boolean eRihpgvo, boolean W21sNJRM)
			throws FileNotFoundException, IOException {
		FileInputStream RYilzpNY = null;
		FileOutputStream DDklxGJ0 = null;
		byte[] hHpdixd8;
		int CztTDBCC;
		File ISwCbl5u = new File(vS7OI72w);
		if (eRihpgvo && !ISwCbl5u.exists())
			ISwCbl5u.mkdirs();
		if (ISwCbl5u.exists()) {
			File FxxMj9wZ = new File(vS7OI72w + "/" + JW9fn5mW.getName());
			try {
				if (!FxxMj9wZ.exists() || W21sNJRM) {
					RYilzpNY = new FileInputStream(JW9fn5mW);
					DDklxGJ0 = new FileOutputStream(FxxMj9wZ);
					hHpdixd8 = new byte[1024];
					while (true) {
						CztTDBCC = RYilzpNY.read(hHpdixd8);
						if (CztTDBCC == -1)
							break;
						DDklxGJ0.write(hHpdixd8, 0, CztTDBCC);
					}
				}
			} catch (Exception dcDxNUWL) {
				dcDxNUWL.printStackTrace();
			} finally {
				if (RYilzpNY != null)
					try {
						RYilzpNY.close();
					} catch (IOException E3Q15zh4) {
					}
				if (DDklxGJ0 != null)
					try {
						DDklxGJ0.close();
					} catch (IOException XEVP5u3K) {
					}
			}
		}
	}

}