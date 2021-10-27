class n12803512 {
	@Override
	public CheckAvailabilityResult execute(final CheckAvailabilityAction jn7KVPhZ, final ExecutionContext R231U7DC)
			throws ActionException {
		if (LOGGER.isDebugEnabled()) {
			String VAIOJknS = null;
			if (jn7KVPhZ.getServerId() == CheckAvailability.FEDORA_ID) {
				VAIOJknS = "fedora";
			} else if (jn7KVPhZ.getServerId() == CheckAvailability.KRAMERIUS_ID) {
				VAIOJknS = "kramerius";
			}
			LOGGER.debug("Processing action: CheckAvailability: " + VAIOJknS);
		}
		ServerUtils.checkExpiredSession(httpSessionProvider);
		boolean Evz1UKK9 = true;
		String YCwq3zAa = null;
		String TfPvvFnm = "";
		String vUkO9T6f = "";
		if (jn7KVPhZ.getServerId() == CheckAvailability.FEDORA_ID) {
			YCwq3zAa = configuration.getFedoraHost();
			TfPvvFnm = configuration.getFedoraLogin();
			vUkO9T6f = configuration.getFedoraPassword();
		} else if (jn7KVPhZ.getServerId() == CheckAvailability.KRAMERIUS_ID) {
			YCwq3zAa = configuration.getKrameriusHost() + SOME_STATIC_KRAMERIUS_PAGE;
		} else {
			throw new ActionException("Unknown server id");
		}
		try {
			URLConnection X9fUJC7i = RESTHelper.openConnection(YCwq3zAa, TfPvvFnm, vUkO9T6f, false);
			if (X9fUJC7i instanceof HttpURLConnection) {
				HttpURLConnection izmoFIur = (HttpURLConnection) X9fUJC7i;
				int lnnPqXYM = izmoFIur.getResponseCode();
				if (lnnPqXYM < 200 || lnnPqXYM >= 308) {
					Evz1UKK9 = false;
					LOGGER.info("Server " + YCwq3zAa + " answered with HTTP code " + izmoFIur.getResponseCode());
				}
			} else {
				Evz1UKK9 = false;
			}
		} catch (MalformedURLException BBts8PVk) {
			Evz1UKK9 = false;
			BBts8PVk.printStackTrace();
		} catch (IOException BStKGokn) {
			Evz1UKK9 = false;
			BStKGokn.printStackTrace();
		}
		return new CheckAvailabilityResult(Evz1UKK9, YCwq3zAa);
	}

}