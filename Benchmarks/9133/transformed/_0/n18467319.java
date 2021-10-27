class n18467319 {
	@Nullable
	@Override
	public InputSource resolveEntity(final String x48pYwT0, final String nNUxluc6) throws IOException {
		if (nNUxluc6.endsWith(".xml")) {
			return null;
		}
		InputSource HHBxBUMp = null;
		final URL hTKPQ5ku = IOUtils.getResource(new File("system/dtd"),
				PATTERN_DIRECTORY_PART.matcher(nNUxluc6).replaceAll(""));
		final InputStream AT8MkXfn = hTKPQ5ku.openStream();
		try {
			final BufferedInputStream C1oSD3V1 = new BufferedInputStream(AT8MkXfn);
			try {
				HHBxBUMp = new InputSource(C1oSD3V1);
			} finally {
				if (HHBxBUMp == null) {
					C1oSD3V1.close();
				}
			}
		} finally {
			if (HHBxBUMp == null) {
				AT8MkXfn.close();
			}
		}
		return HHBxBUMp;
	}

}