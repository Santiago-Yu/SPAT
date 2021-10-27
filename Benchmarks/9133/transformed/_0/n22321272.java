class n22321272 {
	public static void copyFile(File ZsWyxhWh, File PWvPBnA3) throws Exception {
		if (!ZsWyxhWh.exists())
			return;
		FileInputStream aqT8XJd0 = new FileInputStream(ZsWyxhWh);
		FileOutputStream w8sWehrQ = new FileOutputStream(PWvPBnA3);
		byte[] RU5JJKiN = new byte[BUFFER_SIZE];
		int BXWJeY3x;
		while (true) {
			BXWJeY3x = aqT8XJd0.read(RU5JJKiN);
			if (BXWJeY3x == -1)
				break;
			w8sWehrQ.write(RU5JJKiN, 0, BXWJeY3x);
		}
		w8sWehrQ.flush();
		w8sWehrQ.close();
		aqT8XJd0.close();
	}

}