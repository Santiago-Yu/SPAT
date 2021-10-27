class n1902197 {
	@Override
	protected ResourceHandler doGet(final URI resourceUri) throws ResourceNotFoundException, ResourceException {
		if (null == resourceUri.getHost()) {
			throw new IllegalStateException(InternalBundleHelper.StoreMessageBundle.getMessage("store.uri.http.illegal",
					resourceUri.toString()));
		}
		try {
			final URL configUrl = resourceUri.toURL();
			final URLConnection urlConnection;
			Proxy httpProxy = null;
			if (!StringHelper.isEmpty(context.getString(FileStoreContextBuilder.ProxySet))) {
				if (context.getBoolean(FileStoreContextBuilder.ProxySet)) {
					final String proxyHost = context.getString(FileStoreContextBuilder.ProxyHost);
					final String proxyPort = context.getString(FileStoreContextBuilder.ProxyPort);
					if (!StringHelper.isEmpty(proxyHost)) {
						httpProxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost,
								!StringHelper.isEmpty(proxyPort) ? Integer.parseInt(proxyPort) : 80));
						if (!StringHelper.isEmpty(context.getString(FileStoreContextBuilder.NonProxyHosts))) {
							System.getProperties().put("http.nonProxyHosts",
									context.getProperty(FileStoreContextBuilder.NonProxyHosts));
						}
						if (!StringHelper.isEmpty(context.getString(FileStoreContextBuilder.ProxyUser))
								&& !StringHelper.isEmpty(context.getString(FileStoreContextBuilder.ProxyPassword))) {
							Authenticator.setDefault(new Authenticator() {

								@Override
								protected PasswordAuthentication getPasswordAuthentication() {
									return new PasswordAuthentication(
											context.getString(FileStoreContextBuilder.ProxyUser),
											context.getString(FileStoreContextBuilder.ProxyPassword).toCharArray());
								}
							});
						}
					}
				}
			}
			if (null == httpProxy) {
				urlConnection = configUrl.openConnection();
			} else {
				urlConnection = configUrl.openConnection(httpProxy);
			}
			setUrlConnectionSettings(urlConnection);
			urlConnection.connect();
			try {
				return createResourceHandler(resourceUri.toString(), urlConnection.getInputStream());
			} catch (final FileNotFoundException fnfe) {
				throw new ResourceNotFoundException(resourceUri.toString());
			}
		} catch (final MalformedURLException mure) {
			throw new IllegalStateException(
					InternalBundleHelper.StoreMessageBundle.getMessage("store.uri.malformed", resourceUri.toString()));
		} catch (final ConnectException ce) {
			throw new ResourceException("store.connection.error", ce, resourceUri.toString());
		} catch (final IOException ioe) {
			if (ioe instanceof ResourceException) {
				throw (ResourceException) ioe;
			} else {
				throw new ResourceException(ioe, resourceUri.toString());
			}
		}
	}

}