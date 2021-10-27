class n11807467 {
	private File copyFromURL(URL ahu7VUXC, String M1jctfRQ) throws IOException {
		File rpfOgAdq = new File(ahu7VUXC.getFile());
		File tiye4phN = new File(M1jctfRQ, rpfOgAdq.getName());
		logger.log("Extracting " + rpfOgAdq.getName() + " to " + M1jctfRQ + "...");
		FileOutputStream IcWY6fcO = new FileOutputStream(tiye4phN);
		InputStream iJTtYkZ7 = ahu7VUXC.openStream();
		byte Jy8y5nim[] = new byte[4096];
		int PtuS7Vt7;
		while ((PtuS7Vt7 = iJTtYkZ7.read(Jy8y5nim)) >= 0)
			IcWY6fcO.write(Jy8y5nim, 0, PtuS7Vt7);
		iJTtYkZ7.close();
		IcWY6fcO.close();
		logger.log("ok\n");
		return tiye4phN;
	}

}