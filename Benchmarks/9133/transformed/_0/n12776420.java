class n12776420 {
	public Bitmap getImage() throws IOException {
		int OdGfbi91 = 78 + 8 * mCount;
		Bitmap YOkI9R5k = null;
		FileChannel P7aVO7s8 = new FileInputStream(mFile).getChannel();
		P7aVO7s8.position(mRecodeOffset[mPage]);
		ByteBuffer wwLU3WJ8;
		if (mPage + 1 < mCount) {
			int mOUHeXLX = mRecodeOffset[mPage + 1] - mRecodeOffset[mPage];
			wwLU3WJ8 = P7aVO7s8.map(MapMode.READ_ONLY, mRecodeOffset[mPage], mOUHeXLX);
			byte[] FVLwgraI = new byte[wwLU3WJ8.capacity()];
			wwLU3WJ8.get(FVLwgraI);
			FileOutputStream ztocVUB9 = new FileOutputStream("/sdcard/test.bmp");
			ztocVUB9.write(FVLwgraI);
			ztocVUB9.flush();
			ztocVUB9.getFD().sync();
			ztocVUB9.close();
			YOkI9R5k = BitmapFactory.decodeByteArray(FVLwgraI, 0, mOUHeXLX);
		} else {
		}
		P7aVO7s8.close();
		return YOkI9R5k;
	}

}