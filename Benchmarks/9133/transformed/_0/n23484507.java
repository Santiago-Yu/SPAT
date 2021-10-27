class n23484507 {
	public static void copy(File vBhz22Bu, File sawpVPFN) throws IOException {
		if (!vBhz22Bu.exists())
			throw new IOException("FileCopy: " + "no such source file: " + vBhz22Bu.getName());
		if (!vBhz22Bu.isFile())
			throw new IOException("FileCopy: " + "can't copy directory: " + vBhz22Bu.getName());
		if (!vBhz22Bu.canRead())
			throw new IOException("FileCopy: " + "source file is unreadable: " + vBhz22Bu.getName());
		if (sawpVPFN.isDirectory())
			sawpVPFN = new File(sawpVPFN, vBhz22Bu.getName());
		String nt8bmI5I = sawpVPFN.getParent();
		if (nt8bmI5I == null)
			nt8bmI5I = System.getProperty("user.dir");
		File zlELM0Ad = new File(nt8bmI5I);
		if (!zlELM0Ad.exists())
			throw new IOException("FileCopy: " + "destination directory doesn't exist: " + nt8bmI5I);
		if (zlELM0Ad.isFile())
			throw new IOException("FileCopy: " + "destination is not a directory: " + nt8bmI5I);
		if (!zlELM0Ad.canWrite())
			throw new IOException("FileCopy: " + "destination directory is unwriteable: " + nt8bmI5I);
		FileInputStream Z6lbHpgx = null;
		FileOutputStream dgVKPamr = null;
		try {
			Z6lbHpgx = new FileInputStream(vBhz22Bu);
			dgVKPamr = new FileOutputStream(sawpVPFN);
			byte[] TUEDM2dv = new byte[4096];
			int vB6Mmc2g;
			while ((vB6Mmc2g = Z6lbHpgx.read(TUEDM2dv)) != -1)
				dgVKPamr.write(TUEDM2dv, 0, vB6Mmc2g);
		} finally {
			if (Z6lbHpgx != null)
				try {
					Z6lbHpgx.close();
				} catch (IOException RWBSmcnW) {
					;
				}
			if (dgVKPamr != null)
				try {
					dgVKPamr.close();
				} catch (IOException GEwuC8r5) {
					;
				}
		}
	}

}