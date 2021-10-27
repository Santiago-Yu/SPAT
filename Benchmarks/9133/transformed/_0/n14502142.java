class n14502142 {
	public static void copyFile(File crJTew0S, File Yc9YFjc7) throws IOException {
		if (!Yc9YFjc7.exists()) {
			Yc9YFjc7.createNewFile();
		}
		FileChannel PBj0EZkC = null;
		FileChannel Bq7qtFVX = null;
		try {
			PBj0EZkC = new FileInputStream(crJTew0S).getChannel();
			Bq7qtFVX = new FileOutputStream(Yc9YFjc7).getChannel();
			Bq7qtFVX.transferFrom(PBj0EZkC, 0, PBj0EZkC.size());
		} finally {
			if (PBj0EZkC != null) {
				PBj0EZkC.close();
			}
			if (Bq7qtFVX != null) {
				Bq7qtFVX.close();
			}
		}
	}

}