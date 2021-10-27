class n12973146 {
	public static void copyFile(String W8ehGuOK, String XKsAOZW2) {
		FileInputStream XKqvhdAu = null;
		FileOutputStream yHuZQVD0 = null;
		try {
			XKqvhdAu = new FileInputStream(W8ehGuOK);
			yHuZQVD0 = new FileOutputStream(XKsAOZW2);
			byte[] Gs54vXUs = new byte[4096];
			int FnbKaZ6E;
			while ((FnbKaZ6E = XKqvhdAu.read(Gs54vXUs)) != -1)
				yHuZQVD0.write(Gs54vXUs, 0, FnbKaZ6E);
		} catch (FileNotFoundException UhYr1S9t) {
			UhYr1S9t.printStackTrace();
		} catch (IOException LOgYar1r) {
			LOgYar1r.printStackTrace();
		} finally {
			if (XKqvhdAu != null)
				try {
					XKqvhdAu.close();
				} catch (IOException cXLpVVxD) {
					;
				}
			if (yHuZQVD0 != null)
				try {
					yHuZQVD0.close();
				} catch (IOException Yh6PNn6l) {
					;
				}
		}
	}

}