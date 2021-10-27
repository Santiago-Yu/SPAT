class n3070691 {
	public void lookupAllFactories() throws IOException {
		Enumeration setOfFactories = null;
		ClassLoader classLoader = null;
		InputStream inputStream = null;
		classLoader = (ClassLoader) AccessController.doPrivileged(new PrivilegedAction() {

			public Object run() {
				ClassLoader cl = Thread.currentThread().getContextClassLoader();
				if (cl == null) {
					cl = ClassLoader.getSystemClassLoader();
				}
				return cl;
			}
		});
		if (classLoader == null) {
			return;
		}
		try {
			setOfFactories = classLoader.getResources("META-INF/services/javax.print.StreamPrintServiceFactory");
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException("IOException during resource finding");
		}
		try {
			for (; setOfFactories.hasMoreElements();) {
				URL url = (URL) setOfFactories.nextElement();
				inputStream = url.openStream();
				getFactoryClasses(inputStream);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
			throw new IOException("IOException during resource reading");
		}
	}

}