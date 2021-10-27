class n5677926 {
	public static void copyFile(File source, File destination) throws IOException {
		FileOutputStream fos = null;
		FileInputStream fis = new FileInputStream(source);
		try {
			FileChannel sourceChannel = fis.getChannel();
			fos = new FileOutputStream(destination);
			FileChannel destinationChannel = fos.getChannel();
			sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);
			destinationChannel.close();
			sourceChannel.close();
		} finally {
			if (fos != null)
				fos.close();
			fis.close();
		}
	}

}