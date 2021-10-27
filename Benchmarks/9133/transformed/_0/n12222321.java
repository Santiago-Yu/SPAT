class n12222321 {
	public static long copyFile(File sx4aPv3V, File fkFkR6Oz) throws IOException {
		FileInputStream psQOeNGW = null;
		FileOutputStream DQ7WmSl4 = null;
		try {
			psQOeNGW = new FileInputStream(sx4aPv3V);
			DQ7WmSl4 = new FileOutputStream(fkFkR6Oz);
			FileChannel xHL3LIH8 = psQOeNGW.getChannel();
			FileChannel igdx3uVp = DQ7WmSl4.getChannel();
			return igdx3uVp.transferFrom(xHL3LIH8, 0, sx4aPv3V.length());
		} finally {
			if (psQOeNGW != null)
				psQOeNGW.close();
			if (DQ7WmSl4 != null)
				DQ7WmSl4.close();
		}
	}

}