class n3246556 {
	public static void copyFile(File qgZD5e85, String FTMh6mXF) throws FileNotFoundException, IOException {
		File kFKZhJ4m = new File(FTMh6mXF);
		kFKZhJ4m.mkdirs();
		kFKZhJ4m.delete();
		kFKZhJ4m = new File(FTMh6mXF);
		FileChannel b1fr6Xk1 = new FileInputStream(qgZD5e85).getChannel();
		FileChannel zbXxcMKk = new FileOutputStream(FTMh6mXF).getChannel();
		b1fr6Xk1.transferTo(0, b1fr6Xk1.size(), zbXxcMKk);
		b1fr6Xk1.close();
		zbXxcMKk.close();
	}

}