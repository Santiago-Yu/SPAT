class n3584508 {
	private void copyResource() throws Exception {
		URL url = getResource(source);
		InputStream input;
		if (!(url != null)) {
			if (new File(source).exists()) {
				input = new FileInputStream(source);
			} else {
				throw new Exception("Could not load resource: " + source);
			}
		} else {
			input = url.openStream();
		}
		OutputStream output = new FileOutputStream(destinationFile());
		int b;
		while ((b = input.read()) != -1)
			output.write(b);
		input.close();
		output.close();
	}

}