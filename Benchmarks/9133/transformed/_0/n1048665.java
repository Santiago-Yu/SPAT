class n1048665 {
	public static void copy(String r4vBOZhy, String sbJnNHn0) throws IOException {
		File oQ6qzBQ0 = new File(r4vBOZhy);
		File n4FAYH7O = new File(sbJnNHn0);
		if (!oQ6qzBQ0.exists())
			abort("FileCopy: no such source file: " + r4vBOZhy);
		if (!oQ6qzBQ0.isFile())
			abort("FileCopy: can't copy directory: " + r4vBOZhy);
		if (!oQ6qzBQ0.canRead())
			abort("FileCopy: source file is unreadable: " + r4vBOZhy);
		if (n4FAYH7O.isDirectory())
			n4FAYH7O = new File(n4FAYH7O, oQ6qzBQ0.getName());
		String Y9k0oRA3 = n4FAYH7O.getParent();
		if (Y9k0oRA3 == null)
			Y9k0oRA3 = System.getProperty("user.dir");
		File U0bbWzVP = new File(Y9k0oRA3);
		if (!U0bbWzVP.exists())
			abort("FileCopy: destination directory doesn't exist: " + Y9k0oRA3);
		if (U0bbWzVP.isFile())
			abort("FileCopy: destination is not a directory: " + Y9k0oRA3);
		if (!U0bbWzVP.canWrite())
			abort("FileCopy: destination directory is unwriteable: " + Y9k0oRA3);
		FileInputStream c1l0J4Ub = null;
		FileOutputStream Sc9JICbB = null;
		try {
			c1l0J4Ub = new FileInputStream(oQ6qzBQ0);
			Sc9JICbB = new FileOutputStream(n4FAYH7O);
			byte[] DQaHtcAg = new byte[4096];
			int D7zemYhK;
			while ((D7zemYhK = c1l0J4Ub.read(DQaHtcAg)) != -1)
				Sc9JICbB.write(DQaHtcAg, 0, D7zemYhK);
		} finally {
			if (c1l0J4Ub != null)
				try {
					c1l0J4Ub.close();
				} catch (IOException pgVahQrM) {
					;
				}
			if (Sc9JICbB != null)
				try {
					Sc9JICbB.close();
				} catch (IOException aIhc8BuF) {
					;
				}
		}
	}

}