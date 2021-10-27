class n3578392 {
	public static void copyFile(File Yb3ixxbF, File vgM9FEuS) throws FileNotFoundException, IOException {
		FileChannel bPr4Sl1g = null;
		FileChannel w8BHv2kd = null;
		try {
			bPr4Sl1g = new FileInputStream(Yb3ixxbF).getChannel();
			w8BHv2kd = new FileOutputStream(vgM9FEuS).getChannel();
			bPr4Sl1g.transferTo(0, bPr4Sl1g.size(), w8BHv2kd);
		} finally {
			try {
				bPr4Sl1g.close();
			} catch (Exception aEIu2X4g) {
			}
			try {
				w8BHv2kd.close();
			} catch (Exception YJxgdcVo) {
			}
		}
	}

}