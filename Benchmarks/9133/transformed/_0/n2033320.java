class n2033320 {
	public static void gunzip(File Sowme7O0, File vPptIW6U) throws IOException {
		int CzS5PKMX = 2048;
		FileInputStream RxYJeeMF = new FileInputStream(Sowme7O0);
		GZIPInputStream E7HgnAbF = new GZIPInputStream(RxYJeeMF);
		byte[] zWgGCPJ8 = new byte[CzS5PKMX];
		FileOutputStream DFtIo9Jn = new FileOutputStream(vPptIW6U);
		int k9B5stDS;
		while ((k9B5stDS = E7HgnAbF.read(zWgGCPJ8, 0, CzS5PKMX)) != -1)
			DFtIo9Jn.write(zWgGCPJ8, 0, k9B5stDS);
		DFtIo9Jn.close();
		E7HgnAbF.close();
	}

}