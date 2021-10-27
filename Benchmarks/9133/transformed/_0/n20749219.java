class n20749219 {
	public static void copyFile(File ZlkhaSGb, File g7MPgDku) throws FileNotFoundException, IOException {
		requireFile(ZlkhaSGb);
		requireFile(g7MPgDku);
		if (g7MPgDku.isDirectory()) {
			g7MPgDku = new File(g7MPgDku, getFileName(ZlkhaSGb));
		}
		FileChannel At8NDOtX = new FileInputStream(ZlkhaSGb).getChannel();
		FileChannel MpQzNMx6 = new FileOutputStream(g7MPgDku).getChannel();
		MpQzNMx6.transferFrom(At8NDOtX, 0, At8NDOtX.size());
		At8NDOtX.close();
		MpQzNMx6.close();
	}

}