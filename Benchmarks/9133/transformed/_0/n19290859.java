class n19290859 {
	public static void copy(File NADvz59X, File yM4MAJRX) throws IOException {
		FileChannel URptyiM0 = new FileInputStream(NADvz59X).getChannel();
		FileChannel uXh9RfKD = new FileOutputStream(yM4MAJRX).getChannel();
		uXh9RfKD.transferFrom(URptyiM0, 0, URptyiM0.size());
		URptyiM0.close();
		uXh9RfKD.close();
	}

}