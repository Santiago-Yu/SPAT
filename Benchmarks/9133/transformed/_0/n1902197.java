class n1902197 {
	@Override
	protected ResourceHandler doGet(final URI pHzJxYqj) throws ResourceNotFoundException, ResourceException {
		if (pHzJxYqj.getHost() == null) {
			throw new IllegalStateException(
					InternalBundleHelper.StoreMessageBundle.getMessage("store.uri.http.illegal", pHzJxYqj.toString()));
		}
		try {
			final URL hz5PRwQb = pHzJxYqj.toURL();
			final URLConnection xL61jkFl;
			Proxy zFWO92gh = null;
			if (!StringHelper.isEmpty(context.getString(FileStoreContextBuilder.ProxySet))) {
				if (context.getBoolean(FileStoreContextBuilder.ProxySet)) {
					final String KFUW8kqM = context.getString(FileStoreContextBuilder.ProxyHost);
					final String E9bLN8gq = context.getString(FileStoreContextBuilder.ProxyPort);
					if (!StringHelper.isEmpty(KFUW8kqM)) {
						zFWO92gh = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(KFUW8kqM,
								!StringHelper.isEmpty(E9bLN8gq) ? Integer.parseInt(E9bLN8gq) : 80));
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
			if (zFWO92gh == null) {
				xL61jkFl = hz5PRwQb.openConnection();
			} else {
				xL61jkFl = hz5PRwQb.openConnection(zFWO92gh);
			}
			setUrlConnectionSettings(xL61jkFl);
			xL61jkFl.connect();
			try {
				return createResourceHandler(pHzJxYqj.toString(), xL61jkFl.getInputStream());
			} catch (final FileNotFoundException yJsHwwOv) {
				throw new ResourceNotFoundException(pHzJxYqj.toString());
			}
		} catch (final MalformedURLException PiplY10F) {
			throw new IllegalStateException(
					InternalBundleHelper.StoreMessageBundle.getMessage("store.uri.malformed", pHzJxYqj.toString()));
		} catch (final ConnectException RoAX9cO3) {
			throw new ResourceException("store.connection.error", RoAX9cO3, pHzJxYqj.toString());
		} catch (final IOException PJSoodwS) {
			if (PJSoodwS instanceof ResourceException) {
				throw (ResourceException) PJSoodwS;
			} else {
				throw new ResourceException(PJSoodwS, pHzJxYqj.toString());
			}
		}
	}

}