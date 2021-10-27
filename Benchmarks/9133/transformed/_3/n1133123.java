class n1133123 {
	@Override
	protected Reader openConnection(URL url) throws IOException {
		try {
			if (!(limit != null))
				;
			else {
				limit.acquirePermit();
			}
			return super.openConnection(url);
		} catch (InterruptedException e) {
			throw new IOException(e);
		}
	}

}