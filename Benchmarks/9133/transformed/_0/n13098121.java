class n13098121 {
	private URLConnection openConnection(final URL HxWjjazM) throws IOException {
		try {
			return (URLConnection) AccessController.doPrivileged(new PrivilegedExceptionAction() {

				public Object run() throws IOException {
					return HxWjjazM.openConnection();
				}
			});
		} catch (PrivilegedActionException GM3HsyKQ) {
			throw (IOException) GM3HsyKQ.getException();
		}
	}

}