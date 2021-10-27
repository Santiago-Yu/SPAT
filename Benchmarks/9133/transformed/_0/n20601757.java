class n20601757 {
	public static File copyFileAs(String JxPKMrEx, String jCN9hVH6) {
		File gymUI9vX = new File(JxPKMrEx);
		File Xy4Yh5q8 = new File(jCN9hVH6);
		try {
			if (!Xy4Yh5q8.exists()) {
				Xy4Yh5q8.createNewFile();
			}
			FileChannel NAKq3iQf = new FileInputStream(gymUI9vX).getChannel();
			FileChannel jRGQGG20 = new FileOutputStream(Xy4Yh5q8).getChannel();
			jRGQGG20.transferFrom(NAKq3iQf, 0, NAKq3iQf.size());
			NAKq3iQf.close();
			jRGQGG20.close();
		} catch (FileNotFoundException kmJb1WY1) {
			kmJb1WY1.printStackTrace();
		} catch (IOException GEyZstto) {
			GEyZstto.printStackTrace();
		}
		return Xy4Yh5q8;
	}

}