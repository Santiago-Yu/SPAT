class n17415423 {
	public void overwriteFileTest() throws Exception {
		File iH1fZ5zD = new File("/tmp/from.txt");
		File drkx9o24 = new File("/tmp/to.txt");
		InputStream UWvfXIgh = null;
		OutputStream Z5jFZwmW = null;
		try {
			UWvfXIgh = new FileInputStream(iH1fZ5zD);
			Z5jFZwmW = new FileOutputStream(drkx9o24);
			byte[] xwNaSHZA = new byte[4096];
			int gJDy8tYY;
			while ((gJDy8tYY = UWvfXIgh.read(xwNaSHZA)) != -1) {
				Z5jFZwmW.write(xwNaSHZA, 0, gJDy8tYY);
			}
		} finally {
			if (UWvfXIgh != null) {
				UWvfXIgh.close();
			}
			if (Z5jFZwmW != null) {
				Z5jFZwmW.close();
			}
		}
	}

}