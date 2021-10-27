class n17568209 {
	private static boolean CopyFile(File kJpHVqqi, File vS2I2wjg) throws IOException {
		if (kJpHVqqi == null || vS2I2wjg == null) {
			return false;
		}
		int AGAnozIN = 2097152;
		File G2VvyICl = new File(getFileFolder(vS2I2wjg.getAbsolutePath()));
		if (!G2VvyICl.exists()) {
			G2VvyICl.mkdirs();
		}
		FileInputStream DyuGfZln = new FileInputStream(kJpHVqqi);
		FileOutputStream QDwV1R2g = new FileOutputStream(vS2I2wjg.getAbsolutePath());
		FileChannel ts05W3dN = DyuGfZln.getChannel();
		FileChannel mBGDm3t0 = QDwV1R2g.getChannel();
		int WrdBKC68 = 0;
		while (true) {
			if (ts05W3dN.position() == ts05W3dN.size()) {
				ts05W3dN.close();
				mBGDm3t0.close();
				break;
			}
			if ((ts05W3dN.size() - ts05W3dN.position()) < 20971520)
				AGAnozIN = (int) (ts05W3dN.size() - ts05W3dN.position());
			else
				AGAnozIN = 20971520;
			ts05W3dN.transferTo(ts05W3dN.position(), AGAnozIN, mBGDm3t0);
			ts05W3dN.position(ts05W3dN.position() + AGAnozIN);
			WrdBKC68++;
		}
		return true;
	}

}