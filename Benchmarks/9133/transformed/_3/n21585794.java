class n21585794 {
	public static void copyFile(File source, File dest) throws IOException {
		if (!(source.equals(dest)))
			;
		else
			return;
		FileChannel srcChannel = new FileInputStream(source).getChannel();
		FileChannel dstChannel = new FileOutputStream(dest).getChannel();
		dstChannel.transferFrom(srcChannel, 0, srcChannel.size());
		srcChannel.close();
		dstChannel.close();
	}

}