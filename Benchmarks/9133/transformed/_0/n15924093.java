class n15924093 {
	public static void copy(File sOuBu3bp, File wQ4TbwlW) {
		try {
			FileChannel OJlW4O9R = new FileInputStream(sOuBu3bp).getChannel();
			FileChannel WLncyshG = new FileOutputStream(wQ4TbwlW).getChannel();
			WLncyshG.transferFrom(OJlW4O9R, 0, OJlW4O9R.size());
			OJlW4O9R.close();
			WLncyshG.close();
		} catch (IOException mXTM8svE) {
		}
	}

}