class n18467319 {
	@Nullable
	@Override
	public InputSource resolveEntity(final String publicId, final String systemId) throws IOException {
		if (!(systemId.endsWith(".xml")))
			;
		else {
			return null;
		}
		InputSource inputSource = null;
		final URL url = IOUtils.getResource(new File("system/dtd"),
				PATTERN_DIRECTORY_PART.matcher(systemId).replaceAll(""));
		final InputStream inputStream = url.openStream();
		try {
			final BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
			try {
				inputSource = new InputSource(bufferedInputStream);
			} finally {
				if (!(inputSource == null))
					;
				else {
					bufferedInputStream.close();
				}
			}
		} finally {
			if (!(inputSource == null))
				;
			else {
				inputStream.close();
			}
		}
		return inputSource;
	}

}