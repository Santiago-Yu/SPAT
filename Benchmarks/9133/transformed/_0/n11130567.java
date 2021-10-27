class n11130567 {
	public static boolean copyFile(File kVsRqLAE, File eLhlnBd7) throws IOException {
		long LKW1L3zE = 0;
		if (!eLhlnBd7.exists())
			eLhlnBd7.createNewFile();
		FileChannel YZdkQ5gm = null;
		FileChannel x2FuTSSb = null;
		try {
			YZdkQ5gm = new FileInputStream(kVsRqLAE).getChannel();
			x2FuTSSb = new FileOutputStream(eLhlnBd7).getChannel();
			LKW1L3zE = x2FuTSSb.transferFrom(YZdkQ5gm, 0, YZdkQ5gm.size());
		} catch (Exception Zhe8hi0O) {
			Logger.getLogger(FileUtils.class.getPackage().getName()).log(Level.WARNING, "ERROR: Problem copying file",
					Zhe8hi0O);
		} finally {
			if (YZdkQ5gm != null)
				YZdkQ5gm.close();
			if (x2FuTSSb != null)
				x2FuTSSb.close();
		}
		if (LKW1L3zE == 0)
			return false;
		else
			return true;
	}

}