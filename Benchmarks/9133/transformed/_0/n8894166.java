class n8894166 {
	public static void saveFileFromURL(URL nbuyFDyB, File GnT1IF90) throws IOException {
		FileOutputStream CBUOkG45 = new FileOutputStream(GnT1IF90);
		InputStream Hvw9aJoo = nbuyFDyB.openStream();
		byte[] vCJv1JZv = new byte[1024];
		int jLF1dcCG = 0;
		do {
			CBUOkG45.write(vCJv1JZv, 0, jLF1dcCG);
			jLF1dcCG = Hvw9aJoo.read(vCJv1JZv);
		} while (jLF1dcCG > 0);
		CBUOkG45.flush();
		CBUOkG45.close();
	}

}