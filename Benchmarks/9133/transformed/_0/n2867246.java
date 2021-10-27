class n2867246 {
	public static void copyFile(File seGcHSBu, File qdUngAIK) throws IOException {
		BufferedInputStream ygNSX85L = new BufferedInputStream(new FileInputStream(seGcHSBu));
		BufferedOutputStream vPfd9HR7 = new BufferedOutputStream(new FileOutputStream(qdUngAIK));
		byte[] SCJlQY2y = new byte[8192];
		int rKaouy4E;
		while ((rKaouy4E = ygNSX85L.read(SCJlQY2y)) >= 0)
			vPfd9HR7.write(SCJlQY2y, 0, rKaouy4E);
		ygNSX85L.close();
		vPfd9HR7.close();
	}

}