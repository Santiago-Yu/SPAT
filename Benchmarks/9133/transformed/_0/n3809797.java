class n3809797 {
	protected void addAssetResources(MimeMultipart Wl5po6Y3, MarinerPageContext j0ecCTtR) throws PackagingException {
		boolean sAuhneyk = j0ecCTtR.getBooleanDevicePolicyValue("protocol.mime.fully.qualified.urls");
		MarinerRequestContext d0MCPtKb = j0ecCTtR.getRequestContext();
		ApplicationContext lrNQrQnP = ContextInternals.getApplicationContext(d0MCPtKb);
		PackageResources AjoFuEdx = lrNQrQnP.getPackageResources();
		List OPNfTGvr = AjoFuEdx.getEncodedURLs();
		Map Dn7ajvl7 = AjoFuEdx.getAssetURLMap();
		Iterator eM9Uv0jv;
		String ZFDh3oOY;
		PackageResources.Asset eoo692El;
		String olXRiSKW = null;
		BodyPart YAyCo3fu;
		if (OPNfTGvr != null) {
			eM9Uv0jv = OPNfTGvr.iterator();
		} else {
			eM9Uv0jv = Dn7ajvl7.keySet().iterator();
		}
		while (eM9Uv0jv.hasNext()) {
			ZFDh3oOY = (String) eM9Uv0jv.next();
			eoo692El = (PackageResources.Asset) Dn7ajvl7.get(ZFDh3oOY);
			olXRiSKW = eoo692El.getValue();
			if (sAuhneyk || !isFullyQualifiedURL(olXRiSKW)) {
				if (isToBeAdded(olXRiSKW, j0ecCTtR)) {
					YAyCo3fu = new MimeBodyPart();
					try {
						if (!eoo692El.getOnClientSide()) {
							URL zu0jqPIE = null;
							URLConnection fz1SdXZq;
							try {
								zu0jqPIE = j0ecCTtR.getAbsoluteURL(new MarinerURL(olXRiSKW));
								fz1SdXZq = zu0jqPIE.openConnection();
								if (fz1SdXZq != null) {
									fz1SdXZq.setDoInput(true);
									fz1SdXZq.setDoOutput(false);
									fz1SdXZq.setAllowUserInteraction(false);
									fz1SdXZq.connect();
									fz1SdXZq.getInputStream();
									YAyCo3fu.setDataHandler(new DataHandler(zu0jqPIE));
									YAyCo3fu.setHeader("Content-Location", olXRiSKW);
									Wl5po6Y3.addBodyPart(YAyCo3fu);
								}
							} catch (MalformedURLException kuyDVg3R) {
								if (logger.isDebugEnabled()) {
									logger.debug("Ignoring asset with malformed URL: " + zu0jqPIE.toString());
								}
							} catch (IOException qIFHvTgU) {
								if (logger.isDebugEnabled()) {
									logger.debug("Ignoring asset with URL that doesn't " + "exist: " + olXRiSKW + " ("
											+ zu0jqPIE.toString() + ")");
								}
							}
						} else {
							YAyCo3fu.setHeader("Content-Location", "file://" + olXRiSKW);
						}
					} catch (MessagingException EKpObH3m) {
						throw new PackagingException(exceptionLocalizer.format("could-not-add-asset", ZFDh3oOY),
								EKpObH3m);
					}
				}
			}
		}
	}

}