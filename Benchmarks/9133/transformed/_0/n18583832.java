class n18583832 {
	private static void copy(File nqmgXbpY, File jgvc7iRO) throws IOException {
		FileInputStream kHJoaS5s = null;
		FileOutputStream yZNFWFn9 = null;
		try {
			kHJoaS5s = new FileInputStream(nqmgXbpY);
			yZNFWFn9 = new FileOutputStream(jgvc7iRO);
			byte[] pdSQIBRr = new byte[4096];
			int FVehkJ6N;
			while ((FVehkJ6N = kHJoaS5s.read(pdSQIBRr)) != -1)
				yZNFWFn9.write(pdSQIBRr, 0, FVehkJ6N);
		} finally {
			if (kHJoaS5s != null)
				try {
					kHJoaS5s.close();
				} catch (IOException WZHVa4B9) {
				}
			if (yZNFWFn9 != null)
				try {
					yZNFWFn9.close();
				} catch (IOException uPDS5sp3) {
				}
		}
	}

}