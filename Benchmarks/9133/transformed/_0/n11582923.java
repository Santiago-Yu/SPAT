class n11582923 {
	private static InputStream openStream(final URL OX9Ng7LW) throws IOException {
		try {
			return (InputStream) AccessController.doPrivileged(new PrivilegedExceptionAction() {

				public Object run() throws IOException {
					return OX9Ng7LW.openStream();
				}
			});
		} catch (PrivilegedActionException O92fLS2H) {
			throw (IOException) O92fLS2H.getException();
		}
	}

}