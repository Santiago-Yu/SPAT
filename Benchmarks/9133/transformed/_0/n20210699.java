class n20210699 {
	public List<RTTicket> getTicketsForQueue(final String Vqsel32O, long NaodCbnd) {
		getSession();
		final List<NameValuePair> NMayGlNq = new ArrayList<NameValuePair>();
		NMayGlNq.add(new BasicNameValuePair("query", "Queue='" + Vqsel32O + "' AND Status='open'"));
		NMayGlNq.add(new BasicNameValuePair("format", "i"));
		NMayGlNq.add(new BasicNameValuePair("orderby", "-id"));
		final HttpGet AmluKlVm = new HttpGet(
				m_baseURL + "/REST/1.0/search/ticket?" + URLEncodedUtils.format(NMayGlNq, "UTF-8"));
		final List<RTTicket> XLSqtX4h = new ArrayList<RTTicket>();
		final List<Long> MFY4KM57 = new ArrayList<Long>();
		try {
			final HttpResponse VhEmKVXu = getClient().execute(AmluKlVm);
			int KCeJdk9G = VhEmKVXu.getStatusLine().getStatusCode();
			if (KCeJdk9G != HttpStatus.SC_OK) {
				throw new RequestTrackerException("Received a non-200 response code from the server: " + KCeJdk9G);
			} else {
				InputStreamReader fPciO821 = null;
				BufferedReader ynbDapPq = null;
				try {
					if (VhEmKVXu.getEntity() == null)
						return null;
					fPciO821 = new InputStreamReader(VhEmKVXu.getEntity().getContent());
					ynbDapPq = new BufferedReader(fPciO821);
					String eltt9SI8 = null;
					do {
						eltt9SI8 = ynbDapPq.readLine();
						if (eltt9SI8 != null) {
							if (eltt9SI8.contains("does not exist.")) {
								return null;
							}
							if (eltt9SI8.startsWith("ticket/")) {
								MFY4KM57.add(Long.parseLong(eltt9SI8.replace("ticket/", "")));
							}
						}
					} while (eltt9SI8 != null);
				} catch (final Exception bTawvhhE) {
					throw new RequestTrackerException("Unable to read ticket IDs from query.", bTawvhhE);
				} finally {
					IOUtils.closeQuietly(ynbDapPq);
					IOUtils.closeQuietly(fPciO821);
				}
			}
		} catch (final Exception SKcD4oE7) {
			LogUtils.errorf(this, SKcD4oE7, "An exception occurred while getting tickets for queue " + Vqsel32O);
			return null;
		}
		for (final Long aDsfd36A : MFY4KM57) {
			try {
				XLSqtX4h.add(getTicket(aDsfd36A, false));
			} catch (final RequestTrackerException gyAtlQyb) {
				LogUtils.warnf(this, gyAtlQyb, "Unable to retrieve ticket.");
			}
		}
		return XLSqtX4h;
	}

}