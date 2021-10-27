class n1485385 {
	private void runUpdateAppListing() {
		DataStorage.clearListedAppListing();
		GenericUrl url = new GoogleUrl(
				EnterpriseMarketplaceUrl.generateAppListingUrl() + DataStorage.getVendorProfile().vendorId);
		JsonHttpContent content = new JsonHttpContent();
		AppListing appListingBody = buildAppListing(appsMarketplaceProject);
		content.jsonFactory = jsonFactory;
		AppListing appListing;
		if (appListingBody != null) {
			content.data = appListingBody;
		}
		try {
			HttpRequest request = requestFactory.buildPutRequest(url, content);
			request.addParser(jsonHttpParser);
			request.readTimeout = readTimeout;
			HttpResponse response = request.execute();
			appListing = response.parseAs(AppListing.class);
			operationStatus = validateAppListing(appListing, appListingBody);
			if (operationStatus) {
				DataStorage.setListedAppListing(appListing);
			}
			response.getContent().close();
		} catch (IOException e) {
			AppsMarketplacePluginLog.logError(e);
		}
	}

}