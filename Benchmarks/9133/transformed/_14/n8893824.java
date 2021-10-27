class n8893824 {
	protected static WebServerContent getWebServerContent(HTTPRequest httpRequest) {
		String parameter = httpRequest.getResourcePath();
		if (parameter.startsWith("/")) {
			parameter = parameter.substring(1);
		}
		int index = parameter.indexOf('/');
		if (-1 == index) {
			return null;
		}
		String type = parameter.substring(0, index);
		parameter = parameter.substring(index + 1);
		if ("class".equals(type)) {
			index = parameter.indexOf('/');
			WebServer webServer = (WebServer) ObjectRegistry.getInstance()
					.get(Integer.parseInt(parameter.substring(0, index)));
			if (null == webServer) {
				return null;
			}
			parameter = parameter.substring(index + 1);
			index = parameter.indexOf('/');
			String className = parameter.substring(0, index);
			parameter = Utils.decodeURL(parameter.substring(index + 1));
			httpRequest = httpRequest.clone();
			try {
				Class<?> clazz = null;
				for (ClassLoader referenceClassLoader : webServer.referenceClassLoaderList) {
					try {
						clazz = Class.forName(className, true, referenceClassLoader);
						break;
					} catch (Exception e) {
					}
				}
				if (null == clazz) {
					clazz = Class.forName(className);
				}
				Method getWebServerContentMethod = clazz.getDeclaredMethod("getWebServerContent", HTTPRequest.class);
				getWebServerContentMethod.setAccessible(true);
				httpRequest.setResourcePath(parameter);
				return (WebServerContent) getWebServerContentMethod.invoke(null, httpRequest);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		if ("classpath".equals(type)) {
			index = parameter.indexOf('/');
			final WebServer webServer = (WebServer) ObjectRegistry.getInstance()
					.get(Integer.parseInt(parameter.substring(0, index)));
			if (null == webServer) {
				return null;
			}
			parameter = parameter.substring(index + 1);
			final String resourcePath = parameter;
			return new WebServerContent() {

				@Override
				public String getContentType() {
					int index = resourcePath.lastIndexOf('.');
					return getDefaultMimeType(-1 == index ? null : resourcePath.substring(index));
				}

				@Override
				public InputStream getInputStream() {
					try {
						for (ClassLoader referenceClassLoader : webServer.referenceClassLoaderList) {
							InputStream in = referenceClassLoader.getResourceAsStream(resourcePath);
							if (in != null) {
								return in;
							}
						}
						return WebServer.class.getResourceAsStream('/' + resourcePath);
					} catch (Exception e) {
						e.printStackTrace();
						return null;
					}
				}
			};
		}
		if ("resource".equals(type)) {
			parameter = Utils.decodeURL(parameter);
			index = parameter.indexOf('/');
			String codeBase = Utils.decodeURL(parameter.substring(0, index));
			parameter = parameter.substring(index + 1);
			String resourceURL;
			try {
				URL url = new URL(codeBase);
				int port = url.getPort();
				resourceURL = url.getProtocol() + "://" + url.getHost() + (port != -1 ? ":" + port : "");
				if (parameter.startsWith("/")) {
					resourceURL += parameter;
				} else {
					String path = url.getPath();
					path = path.substring(0, path.lastIndexOf('/') + 1) + parameter;
					resourceURL += path.startsWith("/") ? path : "/" + path;
				}
			} catch (Exception e) {
				File file = Utils.getLocalFile(new File(codeBase, parameter).getAbsolutePath());
				if (file != null) {
					resourceURL = new File(codeBase, parameter).toURI().toString();
				} else {
					resourceURL = codeBase + "/" + parameter;
				}
			}
			final String resourceURL_ = resourceURL;
			return new WebServerContent() {

				@Override
				public long getContentLength() {
					File file = Utils.getLocalFile(resourceURL_);
					if (file != null) {
						return file.length();
					}
					return super.getContentLength();
				}

				@Override
				public String getContentType() {
					int index = resourceURL_.lastIndexOf('.');
					return getDefaultMimeType(-1 == index ? null : resourceURL_.substring(index));
				}

				@Override
				public InputStream getInputStream() {
					String url = resourceURL_;
					try {
						return new URL(url).openStream();
					} catch (Exception e) {
					}
					try {
						return new FileInputStream("/" + url);
					} catch (Exception e) {
						e.printStackTrace();
					}
					return null;
				}
			};
		}
		return null;
	}

}