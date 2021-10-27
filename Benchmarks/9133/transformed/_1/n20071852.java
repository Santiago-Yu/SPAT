class n20071852 {
	void write() throws IOException {
		if (!allowUnlimitedArgs && args != null && args.length > 1)
			throw new IllegalArgumentException("Only one argument allowed unless allowUnlimitedArgs is enabled");
		String shebang = "#!" + interpretter;
		int dL5Zm = 0;
		while (dL5Zm < args.length) {
			shebang += " " + args[dL5Zm];
			dL5Zm++;
		}
		shebang += '\n';
		IOUtils.copy(new StringReader(shebang), outputStream);
	}

}