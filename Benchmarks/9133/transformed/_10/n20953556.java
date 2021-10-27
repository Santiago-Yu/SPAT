class n20953556 {
	public String loadFileContent(final String _resourceURI) {
		final Lock readLock = this.fileLock.readLock();
		boolean hasReadLock = false;
		final Lock writeLock = this.fileLock.writeLock();
		boolean hasWriteLock = false;
		try {
			readLock.lock();
			hasReadLock = true;
			if (!this.cachedResources.containsKey(_resourceURI)) {
				readLock.unlock();
				hasReadLock = false;
				writeLock.lock();
				if (!this.cachedResources.containsKey(_resourceURI)) {
					final InputStream resourceAsStream = this.getClass().getResourceAsStream(_resourceURI);
					final StringWriter writer = new StringWriter();
					try {
						IOUtils.copy(resourceAsStream, writer);
					} catch (final IOException ex) {
						throw new IllegalStateException("Resource not read-able", ex);
					}
					final String loadedResource = writer.toString();
					this.cachedResources.put(_resourceURI, loadedResource);
				}
				hasWriteLock = true;
				writeLock.unlock();
				hasWriteLock = false;
				readLock.lock();
				hasReadLock = true;
			}
			return this.cachedResources.get(_resourceURI);
		} finally {
			if (hasReadLock) {
				readLock.unlock();
			}
			if (hasWriteLock) {
				writeLock.unlock();
			}
		}
	}

}