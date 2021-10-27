class n21285620 {
	public static void copyFile(File SNKSsuKu, File zZyj4nPl) throws IOException {
		FileChannel nGr3RaUY = new FileInputStream(SNKSsuKu).getChannel();
		FileChannel udzrqFEU = new FileOutputStream(zZyj4nPl).getChannel();
		try {
			nGr3RaUY.transferTo(0, nGr3RaUY.size(), udzrqFEU);
		} catch (IOException kbVQBCWk) {
			throw kbVQBCWk;
		} finally {
			if (nGr3RaUY != null)
				nGr3RaUY.close();
			if (udzrqFEU != null)
				udzrqFEU.close();
		}
	}

}