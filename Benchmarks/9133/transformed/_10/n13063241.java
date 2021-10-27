class n13063241 {
	public static void copyFile(File src, File dest) throws IOException {
		FileOutputStream fos = new FileOutputStream(dest);
		FileInputStream fis = new FileInputStream(src);
		java.nio.channels.FileChannel channelSrc = fis.getChannel();
		java.nio.channels.FileChannel channelDest = fos.getChannel();
		channelSrc.transferTo(0, channelSrc.size(), channelDest);
		fis.close();
		fos.close();
	}

}