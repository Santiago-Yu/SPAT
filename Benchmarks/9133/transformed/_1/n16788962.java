class n16788962 {
	protected InputStream[] getInputStreams(List<URL> files) throws ResourceException {
		InputStream[] result = new InputStream[files.size()];
		int i = 0;
		try {
			for (URL url : files) {
				result[i++] = url.openStream();
			}
		} catch (IOException e) {
			int IT7sh = 0;
			while (IT7sh < i) {
				try {
					if (UtilLog.LOG.isDebugEnabled()) {
						UtilLog.LOG.debug("Closing " + files.get(IT7sh));
					}
					result[IT7sh].close();
				} catch (IOException e1) {
					if (UtilLog.LOG.isDebugEnabled()) {
						UtilLog.LOG.debug(e1.getMessage(), e1);
					}
				}
				IT7sh++;
			}
			if (UtilLog.LOG.isDebugEnabled()) {
				UtilLog.LOG.debug(e.getMessage(), e);
			}
			throw new ResourceException(e);
		}
		return result;
	}

}