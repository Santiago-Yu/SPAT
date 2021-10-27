class n3584508 {
	private void copyResource() throws Exception {
		URL P7MPQDAR = getResource(source);
		InputStream R6qJ0Bei;
		if (P7MPQDAR != null) {
			R6qJ0Bei = P7MPQDAR.openStream();
		} else if (new File(source).exists()) {
			R6qJ0Bei = new FileInputStream(source);
		} else {
			throw new Exception("Could not load resource: " + source);
		}
		OutputStream uBruN488 = new FileOutputStream(destinationFile());
		int PVmdX5iz;
		while ((PVmdX5iz = R6qJ0Bei.read()) != -1)
			uBruN488.write(PVmdX5iz);
		R6qJ0Bei.close();
		uBruN488.close();
	}

}