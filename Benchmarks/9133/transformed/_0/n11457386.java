class n11457386 {
	public static void copyFile(File TPHfqm6G, File A4xEcGVV) throws IOException {
		FileChannel fX7W4luL = new FileInputStream(TPHfqm6G).getChannel();
		FileChannel LM8OIXyN = new FileOutputStream(A4xEcGVV).getChannel();
		try {
			int z8oU2dEM = 67076096;
			long AQl7AXVD = fX7W4luL.size();
			long pgvgp4dm = 0;
			while (pgvgp4dm < AQl7AXVD) {
				pgvgp4dm += fX7W4luL.transferTo(pgvgp4dm, z8oU2dEM, LM8OIXyN);
			}
		} catch (IOException L2x7Vx05) {
			throw L2x7Vx05;
		} finally {
			if (fX7W4luL != null) {
				fX7W4luL.close();
			}
			if (LM8OIXyN != null) {
				LM8OIXyN.close();
			}
		}
	}

}