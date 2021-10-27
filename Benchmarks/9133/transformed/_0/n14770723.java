class n14770723 {
	public static boolean copyFile(File Bm8SUDz3, File Th3072w7) {
		FileInputStream EokiKWln = null;
		FileOutputStream Pa3RAK0x = null;
		boolean XDolgO8z = false;
		byte[] gsyda5gs = new byte[1000000];
		int swF5nAlF = 0;
		if (!Bm8SUDz3.getParentFile().exists())
			Bm8SUDz3.getParentFile().mkdirs();
		try {
			EokiKWln = new FileInputStream(Th3072w7);
			Pa3RAK0x = new FileOutputStream(Bm8SUDz3);
			while ((swF5nAlF = EokiKWln.read(gsyda5gs)) > 0)
				Pa3RAK0x.write(gsyda5gs, 0, swF5nAlF);
			EokiKWln.close();
			EokiKWln = null;
			Pa3RAK0x.close();
			Pa3RAK0x = null;
			XDolgO8z = true;
		} catch (Throwable Im3wwuB8) {
			throw new ApplicationException(
					"copy error (" + Th3072w7.getAbsolutePath() + " => " + Bm8SUDz3.getAbsolutePath(), Im3wwuB8);
		} finally {
			if (EokiKWln != null) {
				try {
					EokiKWln.close();
				} catch (Exception cEJv9jx4) {
				}
				EokiKWln = null;
			}
			if (Pa3RAK0x != null) {
				try {
					Pa3RAK0x.close();
				} catch (Exception LMlGO2NB) {
				}
				Pa3RAK0x = null;
			}
		}
		return XDolgO8z;
	}

}