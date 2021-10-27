class n13496394 {
	@Override
	protected ResourceHandler doGet(final URI CM54XFAg) throws ResourceException {
		if (CM54XFAg.getHost() == null) {
			throw new IllegalStateException(
					InternalBundleHelper.StoreMessageBundle.getMessage("store.uri.ftp.illegal", CM54XFAg.toString()));
		}
		try {
			final URL ybWFFjsL = CM54XFAg.toURL();
			final URLConnection P99NamnQ;
			Proxy PwH5uQN5 = null;
			if (!StringHelper.isEmpty(context.getString(FileStoreContextBuilder.ProxySet))) {
				if (context.getBoolean(FileStoreContextBuilder.ProxySet)) {
					final String XjStQCZJ = context.getString(FileStoreContextBuilder.ProxyHost);
					final String iPrX8OvT = context.getString(FileStoreContextBuilder.ProxyPort);
					if (!StringHelper.isEmpty(XjStQCZJ)) {
						PwH5uQN5 = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(XjStQCZJ,
								!StringHelper.isEmpty(iPrX8OvT) ? Integer.parseInt(iPrX8OvT) : 80));
						if (!StringHelper.isEmpty(context.getString(FileStoreContextBuilder.NonProxyHosts))) {
							System.getProperties().put("ftp.nonProxyHosts",
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
			if (PwH5uQN5 == null) {
				P99NamnQ = ybWFFjsL.openConnection();
			} else {
				P99NamnQ = ybWFFjsL.openConnection(PwH5uQN5);
			}
			setUrlConnectionSettings(P99NamnQ);
			P99NamnQ.connect();
			try {
				return createResourceHandler(CM54XFAg.toString(), P99NamnQ.getInputStream());
			} catch (final FileNotFoundException eTRR3APz) {
				throw new ResourceNotFoundException(CM54XFAg.toString());
			}
		} catch (final MalformedURLException S7wrTK6R) {
			throw new IllegalStateException(
					InternalBundleHelper.StoreMessageBundle.getMessage("store.uri.malformed", CM54XFAg.toString()));
		} catch (final ConnectException pwTr73Bl) {
			throw new ResourceException("store.connection.error", pwTr73Bl, CM54XFAg.toString());
		} catch (final IOException rXro4oiv) {
			if (rXro4oiv instanceof ResourceException) {
				throw (ResourceException) rXro4oiv;
			} else {
				throw new ResourceException(rXro4oiv, CM54XFAg.toString());
			}
		}
	}

}