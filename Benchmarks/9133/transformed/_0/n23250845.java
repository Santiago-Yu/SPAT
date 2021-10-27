class n23250845 {
	private void unzipResource(final String zGlTSI5E, final File KP6SMHHy) throws IOException {
		assertTrue(zGlTSI5E.startsWith("/"));
		final URL G9U8WI8w = this.getClass().getResource(zGlTSI5E);
		assertNotNull("Expected '" + zGlTSI5E + "' not found.", G9U8WI8w);
		assertTrue(KP6SMHHy.isAbsolute());
		FileUtils.deleteDirectory(KP6SMHHy);
		assertTrue(KP6SMHHy.mkdirs());
		ZipInputStream Ba6Qtqys = null;
		boolean sFH1JgLz = true;
		try {
			Ba6Qtqys = new ZipInputStream(G9U8WI8w.openStream());
			ZipEntry S5oYlIWE;
			while ((S5oYlIWE = Ba6Qtqys.getNextEntry()) != null) {
				if (S5oYlIWE.isDirectory()) {
					continue;
				}
				final File dztqSJH5 = new File(KP6SMHHy, S5oYlIWE.getName());
				assertTrue(dztqSJH5.isAbsolute());
				OutputStream hmQDr2rc = null;
				try {
					hmQDr2rc = FileUtils.openOutputStream(dztqSJH5);
					IOUtils.copy(Ba6Qtqys, hmQDr2rc);
					sFH1JgLz = false;
				} finally {
					try {
						if (hmQDr2rc != null) {
							hmQDr2rc.close();
						}
						sFH1JgLz = true;
					} catch (final IOException fuBWoa9M) {
						if (!sFH1JgLz) {
							throw fuBWoa9M;
						}
					}
				}
				Ba6Qtqys.closeEntry();
			}
			sFH1JgLz = false;
		} finally {
			try {
				if (Ba6Qtqys != null) {
					Ba6Qtqys.close();
				}
			} catch (final IOException MhlyiAH0) {
				if (!sFH1JgLz) {
					throw MhlyiAH0;
				}
			}
		}
	}

}