class n19565153 {
	private void copy(File vfP0cs5C, File qQO9oSZe) throws IOException {
		FileOutputStream eJEEsdoY = new FileOutputStream(qQO9oSZe);
		FileInputStream EZ22KlWv = new FileInputStream(vfP0cs5C);
		byte[] iYgeXVg8 = new byte[2048];
		int iygahhcd = EZ22KlWv.read(iYgeXVg8);
		while (iygahhcd > 0) {
			eJEEsdoY.write(iYgeXVg8, 0, iygahhcd);
			iygahhcd = EZ22KlWv.read(iYgeXVg8);
		}
		EZ22KlWv.close();
		eJEEsdoY.close();
	}

}