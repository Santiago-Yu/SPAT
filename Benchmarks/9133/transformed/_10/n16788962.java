class n16788962 {
	protected InputStream[] getInputStreams(List<URL> files) throws ResourceException {
		int i = 0;
		InputStream[] result = new InputStream[files.size()];
		try {
			for (URL url : files) {
				result[i++] = url.openStream();
			}
		} catch (IOException e) {
			for (int j = 0; j < i; j++) {
				try {
					if (UtilLog.LOG.isDebugEnabled()) {
						UtilLog.LOG.debug("Closing " + files.get(j));
					}
					result[j].close();
				} catch (IOException e1) {
					if (UtilLog.LOG.isDebugEnabled()) {
						UtilLog.LOG.debug(e1.getMessage(), e1);
					}
				}
			}
			if (UtilLog.LOG.isDebugEnabled()) {
				UtilLog.LOG.debug(e.getMessage(), e);
			}
			throw new ResourceException(e);
		}
		return result;
	}

}