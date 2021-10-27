class n12980227 {
	public void copy(File src, File dest) throws FileNotFoundException, IOException {
		FileOutputStream destStream = new FileOutputStream(dest);
		FileInputStream srcStream = new FileInputStream(src);
		FileChannel srcChannel = srcStream.getChannel();
		FileChannel destChannel = destStream.getChannel();
		srcChannel.transferTo(0, srcChannel.size(), destChannel);
		destChannel.close();
		srcChannel.close();
		destStream.close();
		srcStream.close();
	}

}