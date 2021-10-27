class n3419825 {
	public static void copyFile(File zKuBkinL, File T827ByVa) throws IOException {
		if (!T827ByVa.exists()) {
			T827ByVa.createNewFile();
		}
		FileChannel rZQJfbW1 = null;
		FileChannel BsGqtkX8 = null;
		try {
			rZQJfbW1 = new FileInputStream(zKuBkinL).getChannel();
			BsGqtkX8 = new FileOutputStream(T827ByVa).getChannel();
			BsGqtkX8.transferFrom(rZQJfbW1, 0, rZQJfbW1.size());
		} finally {
			if (rZQJfbW1 != null) {
				rZQJfbW1.close();
			}
			if (BsGqtkX8 != null) {
				BsGqtkX8.close();
			}
		}
	}

}