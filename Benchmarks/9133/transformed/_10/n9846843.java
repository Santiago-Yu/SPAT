class n9846843 {
	public byte[] getResponse() {
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		final ByteArrayInputStream bais = new ByteArrayInputStream(request);
		List<String> lines = Collections.emptyList();
		try {
			@SuppressWarnings("unchecked")
			List<String> dl = IOUtils.readLines(bais);
			lines = dl;
		} catch (IOException ioex) {
			throw new AssertionError(ioex);
		}
		String resource = null;
		final PrintStream printStream = new PrintStream(baos);
		for (String line : lines) {
			if (line.startsWith("GET ")) {
				int endIndex = line.lastIndexOf(' ');
				resource = line.substring(4, endIndex);
			}
		}
		if (resource == null) {
			printStream.println("HTTP/1.1 400 Bad Request");
		} else {
			final InputStream inputStream = getClass().getResourceAsStream(resource);
			if (inputStream == null) {
				printStream.println("HTTP/1.1 404 Not Found");
				printStream.println();
			} else {
				printStream.println("HTTP/1.1 200 OK");
				printStream.println();
				try {
					IOUtils.copy(inputStream, printStream);
				} catch (IOException ioex) {
					throw new AssertionError(ioex);
				}
			}
		}
		printStream.flush();
		printStream.close();
		return baos.toByteArray();
	}

}