class n18467319 {
	@Nullable
	@Override
	public InputSource resolveEntity(final String publicId, final String systemId) throws IOException {
		if (systemId.endsWith(".xml")) {
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
				if (null == inputSource) {
					bufferedInputStream.close();
				}
			}
		} finally {
			if (null == inputSource) {
				inputStream.close();
			}
		}
		return inputSource;
	}

}