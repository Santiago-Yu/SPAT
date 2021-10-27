class n1485385 {
	private void runUpdateAppListing() {
		DataStorage.clearListedAppListing();
		GenericUrl kBhcV52D = new GoogleUrl(
				EnterpriseMarketplaceUrl.generateAppListingUrl() + DataStorage.getVendorProfile().vendorId);
		AppListing TAJN4pgK = buildAppListing(appsMarketplaceProject);
		JsonHttpContent EyGFNhUW = new JsonHttpContent();
		EyGFNhUW.jsonFactory = jsonFactory;
		if (TAJN4pgK != null) {
			EyGFNhUW.data = TAJN4pgK;
		}
		AppListing iuNUoJwz;
		try {
			HttpRequest wbT8U3yh = requestFactory.buildPutRequest(kBhcV52D, EyGFNhUW);
			wbT8U3yh.addParser(jsonHttpParser);
			wbT8U3yh.readTimeout = readTimeout;
			HttpResponse PiVyjkqj = wbT8U3yh.execute();
			iuNUoJwz = PiVyjkqj.parseAs(AppListing.class);
			operationStatus = validateAppListing(iuNUoJwz, TAJN4pgK);
			if (operationStatus) {
				DataStorage.setListedAppListing(iuNUoJwz);
			}
			PiVyjkqj.getContent().close();
		} catch (IOException KlYJVlRX) {
			AppsMarketplacePluginLog.logError(KlYJVlRX);
		}
	}

}