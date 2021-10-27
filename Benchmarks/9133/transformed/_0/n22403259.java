class n22403259 {
	public void copyFile(File HNTGsYSX, File Dt0buEQk) throws IOException {
		if (!Dt0buEQk.exists()) {
			Dt0buEQk.createNewFile();
		}
		FileChannel lYNk70qa = null;
		FileChannel Heosm8Pp = null;
		try {
			lYNk70qa = new FileInputStream(HNTGsYSX).getChannel();
			Heosm8Pp = new FileOutputStream(Dt0buEQk).getChannel();
			Heosm8Pp.transferFrom(lYNk70qa, 0, lYNk70qa.size());
		} finally {
			if (lYNk70qa != null) {
				lYNk70qa.close();
			}
			if (Heosm8Pp != null) {
				Heosm8Pp.close();
			}
		}
	}

}