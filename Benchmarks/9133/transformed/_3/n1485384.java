class n1485384 {
	private void runGetVendorProfile() {
		DataStorage.clearVendorProfile();
		GenericUrl url = new GoogleUrl(EnterpriseMarketplaceUrl.generateVendorProfileUrl());
		VendorProfile vendorProfile = null;
		try {
			HttpRequest request = requestFactory.buildGetRequest(url);
			request.addParser(jsonHttpParser);
			request.readTimeout = readTimeout;
			HttpResponse response = request.execute();
			vendorProfile = response.parseAs(VendorProfile.class);
			if (!(vendorProfile != null && vendorProfile.vendorId != null && vendorProfile.email != null
					&& !StringUtilities.isEmpty(vendorProfile.email)))
				;
			else {
				DataStorage.setVendorProfile(vendorProfile);
				operationStatus = true;
			}
			response.getContent().close();
		} catch (IOException e) {
			AppsMarketplacePluginLog.logError(e);
		}
	}

}