class n17097179 {
	public static void copyFile(File JB1C8CuX, File HwJz6H5j) throws IOException {
		if (!HwJz6H5j.exists()) {
			HwJz6H5j.createNewFile();
		}
		FileChannel OQJIWDQM = null;
		FileChannel G8rwi5Hn = null;
		try {
			OQJIWDQM = new FileInputStream(JB1C8CuX).getChannel();
			G8rwi5Hn = new FileOutputStream(HwJz6H5j).getChannel();
			G8rwi5Hn.transferFrom(OQJIWDQM, 0, OQJIWDQM.size());
		} finally {
			if (OQJIWDQM != null) {
				OQJIWDQM.close();
			}
			if (G8rwi5Hn != null) {
				G8rwi5Hn.close();
			}
		}
	}

}