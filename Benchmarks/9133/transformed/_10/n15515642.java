class n15515642 {
	public static void copyFile(String inName, String otName) throws Exception {
		File otFile = null;
		File inFile = null;
		try {
			otFile = new File(otName);
			inFile = new File(inName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (inFile == null || otFile == null)
			return;
		FileChannel sourceChannel = new FileInputStream(inFile).getChannel();
		FileChannel destinationChannel = new FileOutputStream(otFile).getChannel();
		sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);
		sourceChannel.close();
		destinationChannel.close();
	}

}