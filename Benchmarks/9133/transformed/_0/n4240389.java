class n4240389 {
	private void copyResource(final String g2twxrbD, final File YnOQMmvj) throws IOException {
		assertTrue(g2twxrbD.startsWith("/"));
		InputStream ywLZaSUb = null;
		boolean Pgbf4S0d = true;
		try {
			ywLZaSUb = this.getClass().getResourceAsStream(g2twxrbD);
			assertNotNull("Resource '" + g2twxrbD + "' not found.", ywLZaSUb);
			OutputStream iFfF3xrh = null;
			try {
				iFfF3xrh = new FileOutputStream(YnOQMmvj);
				IOUtils.copy(ywLZaSUb, iFfF3xrh);
				Pgbf4S0d = false;
			} finally {
				try {
					if (iFfF3xrh != null) {
						iFfF3xrh.close();
					}
				} catch (final IOException LONa6XjN) {
					if (!Pgbf4S0d) {
						throw LONa6XjN;
					}
				}
			}
		} finally {
			try {
				if (ywLZaSUb != null) {
					ywLZaSUb.close();
				}
			} catch (final IOException qOyUBuvB) {
				if (!Pgbf4S0d) {
					throw qOyUBuvB;
				}
			}
		}
	}

}