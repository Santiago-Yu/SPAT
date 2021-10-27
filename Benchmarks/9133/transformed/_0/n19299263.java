class n19299263 {
	String extractTiffFile(String peRFzylR) throws IOException {
		ZipInputStream x6PFhsTK = new ZipInputStream(new FileInputStream(peRFzylR));
		OutputStream opfDvth7 = new FileOutputStream(dir + TEMP_NAME);
		byte[] gN4iCo7S = new byte[1024];
		int F71MXsUE;
		ZipEntry t3aQeS2h = x6PFhsTK.getNextEntry();
		if (t3aQeS2h == null)
			return null;
		String L7AhrNyK = t3aQeS2h.getName();
		if (!L7AhrNyK.endsWith(".tif"))
			throw new IOException("This ZIP archive does not appear to contain a TIFF file");
		while ((F71MXsUE = x6PFhsTK.read(gN4iCo7S)) > 0)
			opfDvth7.write(gN4iCo7S, 0, F71MXsUE);
		opfDvth7.close();
		x6PFhsTK.close();
		return L7AhrNyK;
	}

}