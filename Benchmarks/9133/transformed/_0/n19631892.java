class n19631892 {
	public static void copyFiles(File YPdYhRIY, File HYHgX7tm) throws IOException {
		if (YPdYhRIY.isDirectory()) {
			HYHgX7tm.mkdirs();
			for (String ukmUdSGC : YPdYhRIY.list()) {
				String I1r6wD1f = HYHgX7tm.getPath() + File.separator + ukmUdSGC;
				String zgD8lYgP = YPdYhRIY.getPath() + File.separator + ukmUdSGC;
				copyFiles(new File(zgD8lYgP), new File(I1r6wD1f));
			}
		} else {
			FileInputStream FI3QT6Os = new FileInputStream(YPdYhRIY);
			FileOutputStream xjWXadnj = new FileOutputStream(HYHgX7tm);
			int IZz8vH4P;
			while ((IZz8vH4P = FI3QT6Os.read()) >= 0)
				xjWXadnj.write(IZz8vH4P);
			FI3QT6Os.close();
			xjWXadnj.close();
		}
	}

}