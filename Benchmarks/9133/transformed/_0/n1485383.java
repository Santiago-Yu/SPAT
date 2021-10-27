class n1485383 {
	private void runGetAppListing() {
		DataStorage.clearAppListings();
		GenericUrl oxapq8Zh = new GoogleUrl(
				EnterpriseMarketplaceUrl.generateAppListingUrl() + DataStorage.getVendorProfile().vendorId);
		AppListingList IE6XtQ5z;
		try {
			HttpRequest q5hensH1 = requestFactory.buildGetRequest(oxapq8Zh);
			q5hensH1.addParser(jsonHttpParser);
			q5hensH1.readTimeout = readTimeout;
			HttpResponse OE7ck0dB = q5hensH1.execute();
			IE6XtQ5z = OE7ck0dB.parseAs(AppListingList.class);
			if (IE6XtQ5z != null && IE6XtQ5z.appListings != null) {
				operationStatus = true;
				DataStorage.setAppListings(IE6XtQ5z.appListings);
			}
			OE7ck0dB.getContent().close();
		} catch (IOException KvsPQPYW) {
			AppsMarketplacePluginLog.logError(KvsPQPYW);
		}
	}

}