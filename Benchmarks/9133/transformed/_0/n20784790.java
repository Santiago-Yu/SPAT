class n20784790 {
	private static void copy(File P9ycTaAF, File Ci8ZczBF) throws IOException {
		FileInputStream yqy8C9vR = new FileInputStream(P9ycTaAF);
		FileOutputStream avzOtHWx = new FileOutputStream(Ci8ZczBF);
		byte[] a9WAWKXy = new byte[4096];
		int lgNL2AkR = 0;
		try {
			while ((lgNL2AkR = yqy8C9vR.read(a9WAWKXy)) != -1)
				avzOtHWx.write(a9WAWKXy, 0, lgNL2AkR);
		} finally {
			yqy8C9vR.close();
			avzOtHWx.close();
		}
	}

}