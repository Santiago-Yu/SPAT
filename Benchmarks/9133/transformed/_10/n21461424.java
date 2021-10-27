class n21461424 {
	public static final void copy(String source, String destination) {
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try {
			fos = new FileOutputStream(destination);
			fis = new FileInputStream(source);
			java.nio.channels.FileChannel channelSrc = fis.getChannel();
			java.nio.channels.FileChannel channelDest = fos.getChannel();
			channelSrc.transferTo(0, channelSrc.size(), channelDest);
			fis.close();
			fos.close();
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}

}