class n20947969 {
	static InputStream getFileAsStream(Class clazz, HandlerChain chain) {
		URL url = clazz.getResource(chain.file());
		if (null == url) {
			url = Thread.currentThread().getContextClassLoader().getResource(chain.file());
		}
		if (null == url) {
			String tmp = clazz.getPackage().getName();
			tmp = tmp.replace('.', '/');
			tmp += "/" + chain.file();
			url = Thread.currentThread().getContextClassLoader().getResource(tmp);
		}
		if (null == url) {
			throw new UtilException("util.failed.to.find.handlerchain.file", clazz.getName(), chain.file());
		}
		try {
			return url.openStream();
		} catch (IOException e) {
			throw new UtilException("util.failed.to.parse.handlerchain.file", clazz.getName(), chain.file());
		}
	}

}