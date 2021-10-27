class n19002330 {
	public static void copyFile(File src, File dst) throws ResourceNotFoundException, ParseErrorException, Exception {
		if (src.getAbsolutePath().endsWith(".vm")) {
			copyVMFile(src, dst.getAbsolutePath().substring(0, dst.getAbsolutePath().lastIndexOf(".vm")));
		} else {
			FileOutputStream fOut;
			FileInputStream fIn;
			long fSize;
			FileChannel fIChan, fOChan;
			fIn = new FileInputStream(src);
			MappedByteBuffer mBuf;
			fIChan = fIn.getChannel();
			fOut = new FileOutputStream(dst);
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

}