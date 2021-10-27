class n19033605 {
	public static void copyFile(File src, File dest) throws IOException {
		FileOutputStream fos = new FileOutputStream(dest);
		FileInputStream fis = new FileInputStream(src);
		FileChannel channelSrc = fis.getChannel();
		FileChannel channelDest = fos.getChannel();
		channelSrc.transferTo(0, channelSrc.size(), channelDest);
		fis.close();
		fos.close();
	}

}