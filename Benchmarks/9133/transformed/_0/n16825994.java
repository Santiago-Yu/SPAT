class n16825994 {
	public int run(String[] IeuWkI5V) throws Exception {
		if (IeuWkI5V.length < 2) {
			System.err.println("Download dir local");
			return 1;
		}
		OutputStream c9qM9BLt = new FileOutputStream(IeuWkI5V[1]);
		Path bKTZczKt = new Path(IeuWkI5V[0]);
		Configuration VZFztyCY = new Configuration();
		FileSystem PuetguNB = FileSystem.get(VZFztyCY);
		if (!PuetguNB.getFileStatus(bKTZczKt).isDirectory()) {
			System.err.println(IeuWkI5V[0] + " is not a directory.");
			return 1;
		}
		try {
			FileStatus pRCTx57t[] = PuetguNB.listStatus(bKTZczKt);
			for (int qFIDgxM5 = 0; qFIDgxM5 < pRCTx57t.length; qFIDgxM5++) {
				if (pRCTx57t[qFIDgxM5].isFile()) {
					System.err.println(pRCTx57t[qFIDgxM5].getPath());
					InputStream dN9irwrf = PuetguNB.open(pRCTx57t[qFIDgxM5].getPath());
					try {
						IOUtils.copyBytes(dN9irwrf, c9qM9BLt, VZFztyCY, false);
					} finally {
						dN9irwrf.close();
					}
				}
			}
		} finally {
			c9qM9BLt.close();
		}
		return 0;
	}

}