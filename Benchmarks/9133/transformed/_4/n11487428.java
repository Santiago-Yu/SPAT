class n11487428 {
	private void loadHtmlHeader() {
		String skinUrl = getClass().getResource("/" + Properties.defaultSkinFileName).toString();
		if (Properties.headerSkin != null && !Properties.headerSkin.equals("")) {
			try {
				URL url = new URL(Properties.headerSkin);
				if (url.getProtocol().equalsIgnoreCase("http")) {
					isHttpUrl = true;
					HttpURLConnection.setFollowRedirects(false);
					HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
					httpConn.setRequestMethod("HEAD");
					boolean urlExists = (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK);
					skinUrl = (urlExists) ? Properties.headerSkin : skinUrl;
				} else if (url.getProtocol().equalsIgnoreCase("jar")) {
					String jarFile = Properties.headerSkin.substring(9).split("!")[0];
					File skinFile = new File(jarFile);
					skinUrl = (skinFile.exists() && skinFile.canRead()) ? Properties.headerSkin : skinUrl;
				} else if (url.getProtocol().equalsIgnoreCase("file")) {
					File skinFile = new File(Properties.headerSkin.substring(5));
					skinUrl = (skinFile.exists() && skinFile.canRead()) ? Properties.headerSkin : skinUrl;
				} else {
					File skinFile = new File(Properties.headerSkin);
					skinUrl = (skinFile.exists() && skinFile.canRead()) ? Properties.headerSkin : skinUrl;
				}
			} catch (Exception ex) {
				XohmLogger.debugPrintln("Header skin url not valid. " + ex.getMessage());
				XohmLogger.debugPrintln("Loading the default skin.");
				ex.printStackTrace();
			}
		}
		XohmLogger.debugPrintln("Header skin file = " + skinUrl);
		try {
			LocalHtmlRendererContext rendererContext = new LocalHtmlRendererContext(htmlHeaderPanel,
					new SimpleUserAgentContext());
			rendererContext.navigate(skinUrl);
			headerLoaded = true;
		} catch (IOException urlEx) {
			XohmLogger.debugPrintln("Exception occured while loading the skin. " + urlEx.getMessage());
		}
	}

}