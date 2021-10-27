class n18648407 {
	public static void copyFile(File l28AlzqZ, File tvNdo4l6) throws Exception {
		BufferedInputStream rooTq1j1 = null;
		BufferedOutputStream bKhUQQ31 = null;
		try {
			rooTq1j1 = new BufferedInputStream(new FileInputStream(l28AlzqZ));
			bKhUQQ31 = new BufferedOutputStream(new FileOutputStream(tvNdo4l6));
			int SIVIbzc3;
			while ((SIVIbzc3 = rooTq1j1.read()) != -1)
				bKhUQQ31.write(SIVIbzc3);
		} finally {
			try {
				if (bKhUQQ31 != null)
					bKhUQQ31.close();
			} catch (Exception fK7qxGc2) {
			}
			try {
				if (rooTq1j1 != null)
					rooTq1j1.close();
			} catch (Exception spudCt0L) {
			}
		}
	}

}