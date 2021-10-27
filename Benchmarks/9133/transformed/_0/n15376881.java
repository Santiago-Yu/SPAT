class n15376881 {
	public static void copyFile(final File COps6ZIx, final File fWgxL7J5) throws IOException {
		if (!fWgxL7J5.exists()) {
			fWgxL7J5.createNewFile();
		}
		FileInputStream FEXH9TbI = null;
		FileOutputStream hLp8g717 = null;
		FileChannel eGnYMrDl = null;
		FileChannel UR84wYxh = null;
		try {
			eGnYMrDl = (FEXH9TbI = new FileInputStream(COps6ZIx)).getChannel();
			UR84wYxh = (hLp8g717 = new FileOutputStream(fWgxL7J5)).getChannel();
			UR84wYxh.transferFrom(eGnYMrDl, 0, eGnYMrDl.size());
		} finally {
			closeIO(eGnYMrDl);
			closeIO(FEXH9TbI);
			closeIO(UR84wYxh);
			closeIO(hLp8g717);
		}
	}

}