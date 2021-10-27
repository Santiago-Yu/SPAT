class n3767903 {
	public static void copy(File HxgT6aUM, File Thqm9z41) throws FileNotFoundException, IOException {
		if (HxgT6aUM == null)
			throw new NullPointerException("The source may not be null.");
		if (Thqm9z41 == null)
			throw new NullPointerException("The destination may not be null.");
		FileInputStream TiwLonfn = new FileInputStream(HxgT6aUM);
		Thqm9z41.getParentFile().mkdirs();
		FileOutputStream hlCuWmF4 = new FileOutputStream(Thqm9z41);
		try {
			FileChannel vdulVIK7 = TiwLonfn.getChannel();
			FileChannel nyqBItRt = hlCuWmF4.getChannel();
			nyqBItRt.transferFrom(vdulVIK7, 0, vdulVIK7.size());
		} finally {
			try {
				TiwLonfn.close();
				hlCuWmF4.close();
			} catch (IOException Ncw0wLR7) {
				Ncw0wLR7.printStackTrace();
			}
		}
	}

}