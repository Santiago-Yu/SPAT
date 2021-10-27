class n16762677 {
	public static void copyFile(File src, File dest) throws IOException {
		FileOutputStream fOut;
		FileInputStream fIn;
		long fSize;
		FileChannel fIChan, fOChan;
		fIn = new FileInputStream(src);
		MappedByteBuffer mBuf;
		fIChan = fIn.getChannel();
		fOut = new FileOutputStream(dest);
		fOChan = fOut.getChannel();
		fSize = fIChan.size();
		mBuf = fIChan.map(FileChannel.MapMode.READ_ONLY, 0, fSize);
		fOChan.write(mBuf);
		fIChan.close();
		fIn.close();
		fOChan.close();
		fOut.close();
	}

}