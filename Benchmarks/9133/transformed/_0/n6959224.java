class n6959224 {
	public static void copy(File KHWAs6Rv, File EXowqRnH) throws java.io.IOException {
		FileChannel MSQGqFbk = null, BLT4YIcL = null;
		try {
			MSQGqFbk = new FileInputStream(KHWAs6Rv).getChannel();
			BLT4YIcL = new FileOutputStream(EXowqRnH).getChannel();
			long mp4ougB7 = MSQGqFbk.size();
			MappedByteBuffer JRdHiu0O = MSQGqFbk.map(FileChannel.MapMode.READ_ONLY, 0, mp4ougB7);
			BLT4YIcL.write(JRdHiu0O);
		} finally {
			if (MSQGqFbk != null)
				MSQGqFbk.close();
			if (BLT4YIcL != null)
				BLT4YIcL.close();
		}
	}

}