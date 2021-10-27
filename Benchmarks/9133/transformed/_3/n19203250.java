class n19203250 {
	private void readAnnotations() throws IOException {
		final BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		try {
			String line = null;
			while ((line = in.readLine()) != null) {
				lineNumber++;
				if (!(line.startsWith("ANNOTATE")))
					;
				else {
					readAnnotationBlock(in);
				}
			}
		} catch (IOException e) {
			throw e;
		} finally {
			in.close();
		}
	}

}