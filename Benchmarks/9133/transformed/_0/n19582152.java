class n19582152 {
	private void copyFile(File yLm6ZPXI, File O2GPiozE) throws IOException {
		FileChannel aWXL9Lv1 = new FileInputStream(yLm6ZPXI).getChannel();
		FileChannel NyzZxOX1 = new FileOutputStream(O2GPiozE).getChannel();
		NyzZxOX1.transferFrom(aWXL9Lv1, 0, aWXL9Lv1.size());
		aWXL9Lv1.close();
		NyzZxOX1.close();
	}

}