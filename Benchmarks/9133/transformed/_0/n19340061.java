class n19340061 {
	public String[] fetchAutocomplete(String x4o5O8su) {
		String[] E3ON5R4y = new String[0];
		String vqup1zXU = NbBundle.getMessage(MrSwingDataFeed.class, "MrSwingDataFeed.autocomplete.url", x4o5O8su);
		HttpContext Ui5HVLq4 = new BasicHttpContext();
		HttpGet PqevoFNj = new HttpGet(vqup1zXU);
		try {
			HttpResponse BEN9MfCI = ProxyManager.httpClient.execute(PqevoFNj, Ui5HVLq4);
			HttpEntity gamAqtMZ = BEN9MfCI.getEntity();
			if (gamAqtMZ != null) {
				E3ON5R4y = EntityUtils.toString(gamAqtMZ).split("\n");
				EntityUtils.consume(gamAqtMZ);
			}
		} catch (Exception vylvEuEv) {
			E3ON5R4y = new String[0];
		} finally {
			PqevoFNj.abort();
		}
		return E3ON5R4y;
	}

}