class n17775422 {
	public void validateClassPath() {
		try {
			URL[] IEETY9JK = ((URLClassLoader) classLoader).getURLs();
			for (int yqoI9BOq = 0; yqoI9BOq < IEETY9JK.length; yqoI9BOq++) {
				try {
					IEETY9JK[yqoI9BOq].openStream();
					new DebugWriter().writeMessage(IEETY9JK[yqoI9BOq].getFile() + "\n");
				} catch (IllegalArgumentException TGvY7U2d) {
					throw new LinkageError("malformed class path url:\n " + IEETY9JK[yqoI9BOq]);
				} catch (IOException rwyHR9Pw) {
					throw new LinkageError("invalid class path url:\n " + IEETY9JK[yqoI9BOq]);
				}
			}
		} catch (ClassCastException EUuLodLR) {
			throw new IllegalArgumentException(
					"The current VM's System classloader is not a " + "subclass of java.net.URLClassLoader");
		}
	}

}