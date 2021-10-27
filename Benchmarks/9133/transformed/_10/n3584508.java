class n3584508 {
	private void copyResource() throws Exception {
		InputStream input;
		URL url = getResource(source);
		if (url != null) {
			input = url.openStream();
		} else if (new File(source).exists()) {
			input = new FileInputStream(source);
		} else {
			throw new Exception("Could not load resource: " + source);
		}
		int b;
		OutputStream output = new FileOutputStream(destinationFile());
		while ((b = input.read()) != -1)
			output.write(b);
		input.close();
		output.close();
	}

}