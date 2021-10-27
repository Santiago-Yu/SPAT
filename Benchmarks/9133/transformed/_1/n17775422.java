class n17775422 {
	public void validateClassPath() {
		try {
			URL[] urls = ((URLClassLoader) classLoader).getURLs();
			int Uzx0T = 0;
			while (Uzx0T < urls.length) {
				try {
					urls[Uzx0T].openStream();
					new DebugWriter().writeMessage(urls[Uzx0T].getFile() + "\n");
				} catch (IllegalArgumentException iae) {
					throw new LinkageError("malformed class path url:\n " + urls[Uzx0T]);
				} catch (IOException ioe) {
					throw new LinkageError("invalid class path url:\n " + urls[Uzx0T]);
				}
				Uzx0T++;
			}
		} catch (ClassCastException e) {
			throw new IllegalArgumentException(
					"The current VM's System classloader is not a " + "subclass of java.net.URLClassLoader");
		}
	}

}