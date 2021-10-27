class n1969722 {
	@Override
	public long getLastModifiedOn() {
		try {
			final URLConnection kzoT6KMH = this.url.openConnection();
			kzoT6KMH.connect();
			final long wACFVwlU = kzoT6KMH.getLastModified();
			try {
				kzoT6KMH.getInputStream().close();
			} catch (final Exception QzOm42rc) {
			}
			return wACFVwlU;
		} catch (final IOException KDPsu3wG) {
			return 0;
		}
	}

}