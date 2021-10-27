class n14729256 {
	public static void copyFile(File file, String pathExport) throws IOException {
		FileChannel sourceChannel = new FileInputStream(file).getChannel();
		File out = new File(pathExport);
		FileChannel destinationChannel = new FileOutputStream(out).getChannel();
		sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);
		sourceChannel.close();
		destinationChannel.close();
	}

}