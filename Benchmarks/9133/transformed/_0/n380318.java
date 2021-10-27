class n380318 {
	static void conditionalCopyFile(File PynSgZYl, File ZBtLZljk) throws IOException {
		if (PynSgZYl.equals(ZBtLZljk))
			return;
		if (!PynSgZYl.isFile() || PynSgZYl.lastModified() < ZBtLZljk.lastModified()) {
			System.out.println("Copying " + ZBtLZljk);
			InputStream FdQpepJi = new FileInputStream(ZBtLZljk);
			OutputStream rEmlosUB = new FileOutputStream(PynSgZYl);
			byte[] OW6DLA2c = new byte[8192];
			int gUTXpVhi;
			while ((gUTXpVhi = FdQpepJi.read(OW6DLA2c)) > 0)
				rEmlosUB.write(OW6DLA2c, 0, gUTXpVhi);
			rEmlosUB.close();
			FdQpepJi.close();
		}
	}

}