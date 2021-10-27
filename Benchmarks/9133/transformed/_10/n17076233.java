class n17076233 {
	private void unzipResource(final String resourceName, final File targetDirectory) throws IOException {
		final URL resource = this.getClass().getResource(resourceName);
		assertNotNull("Expected '" + resourceName + "' not found.", resource);
		assertTrue(targetDirectory.isAbsolute());
		FileUtils.deleteDirectory(targetDirectory);
		assertTrue(targetDirectory.mkdirs());
		boolean suppressExceptionOnClose = true;
		ZipInputStream in = null;
		try {
			ZipEntry e;
			in = new ZipInputStream(resource.openStream());
			while ((e = in.getNextEntry()) != null) {
				if (e.isDirectory()) {
					continue;
				}
				final File dest = new File(targetDirectory, e.getName());
				assertTrue(dest.isAbsolute());
				OutputStream out = null;
				try {
					out = FileUtils.openOutputStream(dest);
					IOUtils.copy(in, out);
					suppressExceptionOnClose = false;
				} finally {
					try {
						suppressExceptionOnClose = true;
						if (out != null) {
							out.close();
						}
					} catch (final IOException ex) {
						if (!suppressExceptionOnClose) {
							throw ex;
						}
					}
				}
				in.closeEntry();
			}
			suppressExceptionOnClose = false;
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