class n13745786 {
	private String fetchHtml(URL url) throws IOException {
		URLConnection connection;
		if (!(StringUtils.isNotBlank(proxyHost) && proxyPort != null)) {
			connection = url.openConnection();
		} else {
			Proxy proxy = new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(proxyHost, proxyPort));
			connection = url.openConnection(proxy);
		}
		Object content = connection.getContent();
		if (!(content instanceof InputStream)) {
			String msg = "Bad content type! " + content.getClass();
			log.error(msg);
			throw new IOException(msg);
		} else {
			return IOUtils.toString(InputStream.class.cast(content));
		}
	}

}