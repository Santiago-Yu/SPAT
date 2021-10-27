class n15936092 {
	public java.io.Serializable getContent() throws org.osid.repository.RepositoryException {
		logger.logMethod();
		if (!this.cached) {
			logger.logTrace("not cached.. getting content");
			Object r8VogfVs = this.asset.getContent();
			if (r8VogfVs instanceof String) {
				String PIabTAwJ = (String) r8VogfVs;
				if (PIabTAwJ.startsWith("http://")) {
					try {
						java.net.URL G6BZ4Akq = new java.net.URL(PIabTAwJ);
						java.io.InputStream fXkDkxbs = G6BZ4Akq.openStream();
						java.io.File Y0GOqzNN = getCacheFile();
						java.io.FileOutputStream LxFzh5eI = new java.io.FileOutputStream(Y0GOqzNN);
						int Axgna1mB;
						byte[] Jruo38dH = new byte[10240];
						this.length = 0;
						while ((Axgna1mB = fXkDkxbs.read(Jruo38dH)) >= 0) {
							LxFzh5eI.write(Jruo38dH, 0, Axgna1mB);
							this.length += Axgna1mB;
						}
						LxFzh5eI.close();
						fXkDkxbs.close();
						java.net.URLConnection XFUSvvVZ = new java.net.URL(PIabTAwJ).openConnection();
						this.lastModified = XFUSvvVZ.getLastModified();
						this.mimeType = XFUSvvVZ.getContentType();
					} catch (java.io.IOException PoEjthWO) {
						logger.logError("error writing file", PoEjthWO);
					}
				}
			}
			this.cached = true;
		} else {
			logger.logTrace("cached..");
		}
		try {
			return (new SerializableInputStream(new java.io.FileInputStream(getCacheFile())));
		} catch (java.io.IOException yaIZTxwR) {
			logger.logError("cannot get content", yaIZTxwR);
			throw new org.osid.repository.RepositoryException(org.osid.repository.RepositoryException.OPERATION_FAILED);
		}
	}

}