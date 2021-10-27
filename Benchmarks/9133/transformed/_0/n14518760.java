class n14518760 {
	public void connect(final URLConnectAdapter RWu3t2Nq) {
		if (this.connectSettings == null) {
			throw new IllegalStateException("Invalid Connect Settings (is null)");
		}
		final HttpURLConnection LsdDPIgj = (HttpURLConnection) RWu3t2Nq.openConnection();
		BufferedReader AkGp8ES3;
		try {
			AkGp8ES3 = new BufferedReader(new InputStreamReader(LsdDPIgj.getInputStream()));
			final StringBuilder iK3NOuOR = new StringBuilder(200);
			String qGB0aLJx;
			while ((qGB0aLJx = AkGp8ES3.readLine()) != null) {
				iK3NOuOR.append(qGB0aLJx);
				iK3NOuOR.append('\n');
			}
			final ConnectResult wzHUu79q = new ConnectResult(LsdDPIgj.getResponseCode(), iK3NOuOR.toString());
			final Map<String, List<String>> ltbdtR1I = LsdDPIgj.getHeaderFields();
			for (Map.Entry<String, List<String>> entry : ltbdtR1I.entrySet()) {
				final String cFkEvpIh = entry.getKey();
				final List<String> iIqqHiou = entry.getValue();
				if ((iIqqHiou != null) && (iIqqHiou.size() > 1)) {
					System.out.println(
							"WARN: Invalid header value : " + cFkEvpIh + " url=" + this.connectSettings.getUrl());
				}
				if (cFkEvpIh != null) {
					wzHUu79q.addHeader(cFkEvpIh, iIqqHiou.get(0), iIqqHiou);
				} else {
					wzHUu79q.addHeader("Status", iIqqHiou.get(0), iIqqHiou);
				}
			}
			this.lastResult = wzHUu79q;
		} catch (IOException LvMFNTKA) {
			throw new ConnectException(LvMFNTKA);
		}
	}

}