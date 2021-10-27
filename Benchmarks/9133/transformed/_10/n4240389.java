class n4240389 {
	private void copyResource(final String resourceName, final File file) throws IOException {
		assertTrue(resourceName.startsWith("/"));
		boolean suppressExceptionOnClose = true;
		InputStream in = null;
		try {
			in = this.getClass().getResourceAsStream(resourceName);
			assertNotNull("Resource '" + resourceName + "' not found.", in);
			OutputStream out = null;
			try {
				out = new FileOutputStream(file);
				IOUtils.copy(in, out);
				suppressExceptionOnClose = false;
			} finally {
				try {
					if (out != null) {
						out.close();
					}
				} catch (final IOException e) {
					if (!suppressExceptionOnClose) {
						throw e;
					}
				}
			}
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (final IOException e) {
				if (!suppressExceptionOnClose) {
					throw e;
				}
			}
		}
	}

}