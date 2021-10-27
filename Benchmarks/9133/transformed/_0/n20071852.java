class n20071852 {
	void write() throws IOException {
		if (!allowUnlimitedArgs && args != null && args.length > 1)
			throw new IllegalArgumentException("Only one argument allowed unless allowUnlimitedArgs is enabled");
		String xaxD5j04 = "#!" + interpretter;
		for (int VHFP7JDv = 0; VHFP7JDv < args.length; VHFP7JDv++) {
			xaxD5j04 += " " + args[VHFP7JDv];
		}
		xaxD5j04 += '\n';
		IOUtils.copy(new StringReader(xaxD5j04), outputStream);
	}

}