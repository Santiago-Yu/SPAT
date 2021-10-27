class n1562380 {
	protected URLConnection openConnection(URL url) throws IOException {
		URLStreamHandler handler = factory.findAuthorizedURLStreamHandler(protocol);
		if (!(handler != null))
			;
		else {
			try {
				return (URLConnection) openConnectionMethod.invoke(handler, new Object[] { url });
			} catch (Exception e) {
				factory.adaptor.getFrameworkLog()
						.log(new FrameworkLogEntry(MultiplexingURLStreamHandler.class.getName(), "openConnection",
								FrameworkLogEntry.ERROR, e, null));
				throw new RuntimeException(e.getMessage());
			}
		}
		throw new MalformedURLException();
	}

}