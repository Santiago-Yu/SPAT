class n3809797 {
	protected void addAssetResources(MimeMultipart pkg, MarinerPageContext context) throws PackagingException {
		boolean includeFullyQualifiedURLs = context.getBooleanDevicePolicyValue("protocol.mime.fully.qualified.urls");
		MarinerRequestContext requestContext = context.getRequestContext();
		ApplicationContext ac = ContextInternals.getApplicationContext(requestContext);
		PackageResources pr = ac.getPackageResources();
		List encodedURLs = pr.getEncodedURLs();
		Map assetURLMap = pr.getAssetURLMap();
		Iterator iterator;
		String encodedURL;
		PackageResources.Asset asset;
		String assetURL = null;
		BodyPart assetPart;
		iterator = (encodedURLs != null) ? encodedURLs.iterator() : assetURLMap.keySet().iterator();
		while (iterator.hasNext()) {
			encodedURL = (String) iterator.next();
			asset = (PackageResources.Asset) assetURLMap.get(encodedURL);
			assetURL = asset.getValue();
			if (includeFullyQualifiedURLs || !isFullyQualifiedURL(assetURL)) {
				if (isToBeAdded(assetURL, context)) {
					assetPart = new MimeBodyPart();
					try {
						if (!asset.getOnClientSide()) {
							URL url = null;
							URLConnection connection;
							try {
								url = context.getAbsoluteURL(new MarinerURL(assetURL));
								connection = url.openConnection();
								if (connection != null) {
									connection.setDoInput(true);
									connection.setDoOutput(false);
									connection.setAllowUserInteraction(false);
									connection.connect();
									connection.getInputStream();
									assetPart.setDataHandler(new DataHandler(url));
									assetPart.setHeader("Content-Location", assetURL);
									pkg.addBodyPart(assetPart);
								}
							} catch (MalformedURLException e) {
								if (logger.isDebugEnabled()) {
									logger.debug("Ignoring asset with malformed URL: " + url.toString());
								}
							} catch (IOException e) {
								if (logger.isDebugEnabled()) {
									logger.debug("Ignoring asset with URL that doesn't " + "exist: " + assetURL + " ("
											+ url.toString() + ")");
								}
							}
						} else {
							assetPart.setHeader("Content-Location", "file://" + assetURL);
						}
					} catch (MessagingException e) {
						throw new PackagingException(exceptionLocalizer.format("could-not-add-asset", encodedURL), e);
					}
				}
			}
		}
	}

}