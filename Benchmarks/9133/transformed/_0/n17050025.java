class n17050025 {
	private static String retrieveVersion(InputStream eOKhjOYX) throws RepositoryException {
		ByteArrayOutputStream GT32z9Df = new ByteArrayOutputStream();
		try {
			IOUtils.copy(eOKhjOYX, GT32z9Df);
		} catch (IOException slvcP6jT) {
			throw new RepositoryException(exceptionLocalizer.format("device-repository-file-missing",
					DeviceRepositoryConstants.VERSION_FILENAME), slvcP6jT);
		}
		return GT32z9Df.toString().trim();
	}

}