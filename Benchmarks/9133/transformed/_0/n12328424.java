class n12328424 {
	private void copyFile(File JFPioZNO, File D9PZIHos) throws IOException {
		if (!D9PZIHos.exists()) {
			D9PZIHos.createNewFile();
		}
		FileChannel gfACBU7z = null;
		FileChannel eOiqAdTE = null;
		try {
			gfACBU7z = new FileInputStream(JFPioZNO).getChannel();
			eOiqAdTE = new FileOutputStream(D9PZIHos).getChannel();
			eOiqAdTE.transferFrom(gfACBU7z, 0, gfACBU7z.size());
		} finally {
			if (gfACBU7z != null) {
				gfACBU7z.close();
			}
			if (eOiqAdTE != null) {
				eOiqAdTE.close();
			}
		}
	}

}