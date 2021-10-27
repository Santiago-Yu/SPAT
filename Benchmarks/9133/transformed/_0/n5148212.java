class n5148212 {
	public static void copyFile(File rFW81Pdy, File bXLSocAq, int JPsZwWPc, boolean DTcQGNb9) throws IOException {
		logger.info("copyFile(File src=" + rFW81Pdy + ", File dest=" + bXLSocAq + ", int bufSize=" + JPsZwWPc
				+ ", boolean force=" + DTcQGNb9 + ") - start");
		File oSHtA5HX = new File(Configuration.getArchiveDir());
		if (!oSHtA5HX.exists()) {
			oSHtA5HX.mkdir();
		}
		if (bXLSocAq.exists()) {
			if (DTcQGNb9) {
				bXLSocAq.delete();
			} else {
				throw new IOException("Cannot overwrite existing file: " + bXLSocAq);
			}
		}
		byte[] hCJFRJoi = new byte[JPsZwWPc];
		int agT20e1D = 0;
		InputStream my82uVO2 = null;
		OutputStream GQ5SN7Xc = null;
		try {
			my82uVO2 = new FileInputStream(rFW81Pdy);
			GQ5SN7Xc = new FileOutputStream(bXLSocAq);
			while (true) {
				agT20e1D = my82uVO2.read(hCJFRJoi);
				if (agT20e1D == -1) {
					break;
				}
				GQ5SN7Xc.write(hCJFRJoi, 0, agT20e1D);
			}
		} finally {
			if (my82uVO2 != null) {
				try {
					my82uVO2.close();
				} finally {
					if (GQ5SN7Xc != null) {
						GQ5SN7Xc.close();
					}
				}
			}
		}
		logger.debug("copyFile(File, File, int, boolean) - end");
	}

}