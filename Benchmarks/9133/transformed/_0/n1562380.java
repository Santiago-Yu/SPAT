class n1562380 {
	protected URLConnection openConnection(URL kltUnwzT) throws IOException {
		URLStreamHandler jtH7dY3Q = factory.findAuthorizedURLStreamHandler(protocol);
		if (jtH7dY3Q != null) {
			try {
				return (URLConnection) openConnectionMethod.invoke(jtH7dY3Q, new Object[] { kltUnwzT });
			} catch (Exception Zdu8BuSa) {
				factory.adaptor.getFrameworkLog()
						.log(new FrameworkLogEntry(MultiplexingURLStreamHandler.class.getName(), "openConnection",
								FrameworkLogEntry.ERROR, Zdu8BuSa, null));
				throw new RuntimeException(Zdu8BuSa.getMessage());
			}
		}
		throw new MalformedURLException();
	}

}