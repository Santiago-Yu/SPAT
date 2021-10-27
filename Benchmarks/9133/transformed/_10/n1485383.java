class n1485383 {
	private void runGetAppListing() {
		DataStorage.clearAppListings();
		AppListingList appListingList;
		GenericUrl url = new GoogleUrl(
				EnterpriseMarketplaceUrl.generateAppListingUrl() + DataStorage.getVendorProfile().vendorId);
		try {
			HttpRequest request = requestFactory.buildGetRequest(url);
			request.addParser(jsonHttpParser);
			request.readTimeout = readTimeout;
			HttpResponse response = request.execute();
			appListingList = response.parseAs(AppListingList.class);
			if (appListingList != null && appListingList.appListings != null) {
				operationStatus = true;
				DataStorage.setAppListings(appListingList.appListings);
			}
			response.getContent().close();
		} catch (IOException e) {
			AppsMarketplacePluginLog.logError(e);
		}
	}

}