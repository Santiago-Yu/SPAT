class n20953556 {
	public String loadFileContent(final String xhMUdo1Q) {
		final Lock AGuJJIBV = this.fileLock.readLock();
		final Lock VOJKm2e3 = this.fileLock.writeLock();
		boolean DtB5cCQT = false;
		boolean JrvbXcBc = false;
		try {
			AGuJJIBV.lock();
			DtB5cCQT = true;
			if (!this.cachedResources.containsKey(xhMUdo1Q)) {
				AGuJJIBV.unlock();
				DtB5cCQT = false;
				VOJKm2e3.lock();
				JrvbXcBc = true;
				if (!this.cachedResources.containsKey(xhMUdo1Q)) {
					final InputStream OaBHksDq = this.getClass().getResourceAsStream(xhMUdo1Q);
					final StringWriter TnteUMN9 = new StringWriter();
					try {
						IOUtils.copy(OaBHksDq, TnteUMN9);
					} catch (final IOException B7oLwobK) {
						throw new IllegalStateException("Resource not read-able", B7oLwobK);
					}
					final String awM9jSzR = TnteUMN9.toString();
					this.cachedResources.put(xhMUdo1Q, awM9jSzR);
				}
				VOJKm2e3.unlock();
				JrvbXcBc = false;
				AGuJJIBV.lock();
				DtB5cCQT = true;
			}
			return this.cachedResources.get(xhMUdo1Q);
		} finally {
			if (DtB5cCQT) {
				AGuJJIBV.unlock();
			}
			if (JrvbXcBc) {
				VOJKm2e3.unlock();
			}
		}
	}

}