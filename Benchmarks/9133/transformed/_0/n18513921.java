class n18513921 {
	public static void copy(File wa4FZNvD, File hWSzCcUr) {
		try {
			InputStream uefajXPE = null;
			OutputStream UhwbHj4d = null;
			try {
				uefajXPE = new BufferedInputStream(new FileInputStream(wa4FZNvD), BUFFER_SIZE);
				UhwbHj4d = new BufferedOutputStream(new FileOutputStream(hWSzCcUr), BUFFER_SIZE);
				byte[] HDab8a64 = new byte[BUFFER_SIZE];
				int zxGQuPFR = 0;
				while ((zxGQuPFR = uefajXPE.read(HDab8a64)) > 0)
					UhwbHj4d.write(HDab8a64, 0, zxGQuPFR);
			} finally {
				if (null != uefajXPE)
					uefajXPE.close();
				if (null != UhwbHj4d)
					UhwbHj4d.close();
			}
		} catch (Exception riJRLSQ5) {
			riJRLSQ5.printStackTrace();
		}
	}

}