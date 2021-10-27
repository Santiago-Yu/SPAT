class n17076233 {
	private void unzipResource(final String fhHAi5xR, final File hbUlwF1M) throws IOException {
		final URL JNxceCx9 = this.getClass().getResource(fhHAi5xR);
		assertNotNull("Expected '" + fhHAi5xR + "' not found.", JNxceCx9);
		assertTrue(hbUlwF1M.isAbsolute());
		FileUtils.deleteDirectory(hbUlwF1M);
		assertTrue(hbUlwF1M.mkdirs());
		ZipInputStream hB9dpsq7 = null;
		boolean Pm8Vwajl = true;
		try {
			hB9dpsq7 = new ZipInputStream(JNxceCx9.openStream());
			ZipEntry E2Jjy7ZS;
			while ((E2Jjy7ZS = hB9dpsq7.getNextEntry()) != null) {
				if (E2Jjy7ZS.isDirectory()) {
					continue;
				}
				final File VYLGaxjS = new File(hbUlwF1M, E2Jjy7ZS.getName());
				assertTrue(VYLGaxjS.isAbsolute());
				OutputStream FnHDkGhM = null;
				try {
					FnHDkGhM = FileUtils.openOutputStream(VYLGaxjS);
					IOUtils.copy(hB9dpsq7, FnHDkGhM);
					Pm8Vwajl = false;
				} finally {
					try {
						if (FnHDkGhM != null) {
							FnHDkGhM.close();
						}
						Pm8Vwajl = true;
					} catch (final IOException N845G8xE) {
						if (!Pm8Vwajl) {
							throw N845G8xE;
						}
					}
				}
				hB9dpsq7.closeEntry();
			}
			Pm8Vwajl = false;
		} finally {
			try {
				if (hB9dpsq7 != null) {
					hB9dpsq7.close();
				}
			} catch (final IOException PQCJvP7W) {
				if (!Pm8Vwajl) {
					throw PQCJvP7W;
				}
			}
		}
	}

}