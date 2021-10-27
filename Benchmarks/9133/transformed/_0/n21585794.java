class n21585794 {
	public static void copyFile(File gW3bu3Ca, File AX9tNB15) throws IOException {
		if (gW3bu3Ca.equals(AX9tNB15))
			return;
		FileChannel iGwS4qJA = new FileInputStream(gW3bu3Ca).getChannel();
		FileChannel MSSeDzaZ = new FileOutputStream(AX9tNB15).getChannel();
		MSSeDzaZ.transferFrom(iGwS4qJA, 0, iGwS4qJA.size());
		iGwS4qJA.close();
		MSSeDzaZ.close();
	}

}