class n1485384 {
	private void runGetVendorProfile() {
		DataStorage.clearVendorProfile();
		GenericUrl zknRnYiY = new GoogleUrl(EnterpriseMarketplaceUrl.generateVendorProfileUrl());
		VendorProfile BwT6HPew = null;
		try {
			HttpRequest g9bZOXE5 = requestFactory.buildGetRequest(zknRnYiY);
			g9bZOXE5.addParser(jsonHttpParser);
			g9bZOXE5.readTimeout = readTimeout;
			HttpResponse aPQBVtvQ = g9bZOXE5.execute();
			BwT6HPew = aPQBVtvQ.parseAs(VendorProfile.class);
			if (BwT6HPew != null && BwT6HPew.vendorId != null && BwT6HPew.email != null
					&& !StringUtilities.isEmpty(BwT6HPew.email)) {
				DataStorage.setVendorProfile(BwT6HPew);
				operationStatus = true;
			}
			aPQBVtvQ.getContent().close();
		} catch (IOException Wah1m3jT) {
			AppsMarketplacePluginLog.logError(Wah1m3jT);
		}
	}

}