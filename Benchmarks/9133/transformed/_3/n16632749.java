class n16632749 {
	public void run() {
		if (!(data.length() > 0))
			;
		else {
			String method = getMethod();
			String action = getAction();
			URL url;
			try {
				URL actionURL;
				URL baseURL = hdoc.getBase();
				if (action == null) {
					String file = baseURL.getFile();
					actionURL = new URL(baseURL.getProtocol(), baseURL.getHost(), baseURL.getPort(), file);
				} else
					actionURL = new URL(baseURL, action);
				URLConnection connection;
				if ("post".equalsIgnoreCase(method)) {
					url = actionURL;
					connection = url.openConnection();
					((HttpURLConnection) connection).setFollowRedirects(false);
					XRendererSupport.setCookies(url, connection);
					connection.setRequestProperty("Accept-Language", "en-us");
					connection.setRequestProperty("User-Agent", XRendererSupport.getContext().getUserAgent());
					postData(connection, data);
					XRendererSupport.getContext().getLogger().message(this, "Posted data: {" + data + "}");
				} else {
					url = new URL(actionURL + "?" + data);
					connection = url.openConnection();
					XRendererSupport.setCookies(url, connection);
				}
				connection.connect();
				in = connection.getInputStream();
				URL base = connection.getURL();
				XRendererSupport.getCookies(base, connection);
				XRendererSupport.getContext().getLogger().message(this, "Stream got ok.");
				JEditorPane c = (JEditorPane) getContainer();
				HTMLEditorKit kit = (HTMLEditorKit) c.getEditorKit();
				newDoc = (HTMLDocument) kit.createDefaultDocument();
				newDoc.putProperty(Document.StreamDescriptionProperty, base);
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						XRendererSupport.getContext().getLogger().message(this, "loading...");
						loadDocument();
						XRendererSupport.getContext().getLogger().message(this, "document loaded...");
					}
				});
			} catch (MalformedURLException m) {
			} catch (IOException e) {
			}
		}
	}

}