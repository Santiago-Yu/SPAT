class n3597316 {
	public static void copyFile(File PhiOIyLY, File TZAb3fov) throws IOException {
		if (!TZAb3fov.exists()) {
			TZAb3fov.createNewFile();
		}
		FileChannel F0CI3NLx = null;
		FileChannel JZBVONpJ = null;
		try {
			F0CI3NLx = new FileInputStream(PhiOIyLY).getChannel();
			JZBVONpJ = new FileOutputStream(TZAb3fov).getChannel();
			JZBVONpJ.transferFrom(F0CI3NLx, 0, F0CI3NLx.size());
		} finally {
			if (F0CI3NLx != null) {
				F0CI3NLx.close();
			}
			if (JZBVONpJ != null) {
				JZBVONpJ.close();
			}
		}
	}

}