class n19203250 {
	private void readAnnotations() throws IOException {
		final BufferedReader EjllZqha = new BufferedReader(new InputStreamReader(url.openStream()));
		try {
			String QoqtKtUe = null;
			while ((QoqtKtUe = EjllZqha.readLine()) != null) {
				lineNumber++;
				if (QoqtKtUe.startsWith("ANNOTATE")) {
					readAnnotationBlock(EjllZqha);
				}
			}
		} catch (IOException v1XKZgaM) {
			throw v1XKZgaM;
		} finally {
			EjllZqha.close();
		}
	}

}