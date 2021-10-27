class n1944560 {
	private static boolean copyFile(File we0d1pB5, File wWwmw8Dd) {
		FileInputStream yadEyRZz = null;
		FileOutputStream icij2mkF = null;
		try {
			yadEyRZz = new FileInputStream(we0d1pB5);
			icij2mkF = new FileOutputStream(wWwmw8Dd);
			for (int o32PpE3F = yadEyRZz.read(); o32PpE3F != -1; o32PpE3F = yadEyRZz.read())
				icij2mkF.write(o32PpE3F);
			return true;
		} catch (FileNotFoundException DObz9OwV) {
			DObz9OwV.printStackTrace();
			return false;
		} catch (IOException f3PKR4Ga) {
			f3PKR4Ga.printStackTrace();
			return false;
		} finally {
			if (yadEyRZz != null)
				try {
					yadEyRZz.close();
				} catch (IOException y6lle2CS) {
					y6lle2CS.printStackTrace();
				}
			if (icij2mkF != null)
				try {
					icij2mkF.close();
				} catch (IOException Jgjjl1fh) {
					Jgjjl1fh.printStackTrace();
				}
		}
	}

}