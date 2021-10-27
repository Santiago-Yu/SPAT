class n16301512 {
	public static void copy(File src, File dst) throws IOException {
		FileChannel outChannel;
		FileChannel inChannel;
		inChannel = new FileInputStream(src).getChannel();
		outChannel = new FileOutputStream(dst).getChannel();
		outChannel.transferFrom(inChannel, 0, inChannel.size());
		inChannel.close();
		outChannel.close();
	}

}