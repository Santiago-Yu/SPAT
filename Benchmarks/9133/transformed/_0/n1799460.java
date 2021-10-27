class n1799460 {
	public static void copy(File Mfpj0ewe, File Tz3XBe7A) {
		if (Mfpj0ewe.getAbsolutePath().equals(Tz3XBe7A.getAbsolutePath())) {
			return;
		}
		FileInputStream jYz2WBW0 = null;
		FileOutputStream D9V6et4s = null;
		try {
			jYz2WBW0 = new FileInputStream(Mfpj0ewe);
			D9V6et4s = new FileOutputStream(Tz3XBe7A);
			int P9eGFvHG = -1;
			byte[] gVJfkb8x = new byte[10000];
			while ((P9eGFvHG = jYz2WBW0.read(gVJfkb8x)) > 0) {
				D9V6et4s.write(gVJfkb8x, 0, P9eGFvHG);
			}
		} catch (Exception lYFPCNzY) {
			throw new RuntimeException();
		} finally {
			try {
				jYz2WBW0.close();
			} catch (Exception iChW0anB) {
			}
			try {
				D9V6et4s.close();
			} catch (Exception eLDzPEPL) {
			}
		}
	}

}