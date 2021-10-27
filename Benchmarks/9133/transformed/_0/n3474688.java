class n3474688 {
	public void connect(final URLConnectAdapter dL3gswIx) {
		if (this.connectSettings == null) {
			throw new IllegalStateException("Invalid Connect Settings (is null)");
		}
		final HttpURLConnection wc7U7B82 = (HttpURLConnection) dL3gswIx.openConnection();
		BufferedReader o49NAI70;
		try {
			o49NAI70 = new BufferedReader(new InputStreamReader(wc7U7B82.getInputStream()));
			final StringBuilder r1jbGWb7 = new StringBuilder(200);
			String Rgl5nxxy;
			while ((Rgl5nxxy = o49NAI70.readLine()) != null) {
				r1jbGWb7.append(Rgl5nxxy);
				r1jbGWb7.append('\n');
			}
			final ConnectResult sDGHjVJj = new ConnectResult(wc7U7B82.getResponseCode(), r1jbGWb7.toString());
			final Map<String, List<String>> uM3WpHmL = wc7U7B82.getHeaderFields();
			for (Map.Entry<String, List<String>> entry : uM3WpHmL.entrySet()) {
				final String x7kgd037 = entry.getKey();
				final List<String> TOK0iQx1 = entry.getValue();
				if ((TOK0iQx1 != null) && (TOK0iQx1.size() > 1)) {
					System.out.println(
							"WARN: Invalid header value : " + x7kgd037 + " url=" + this.connectSettings.getUrl());
				}
				if (x7kgd037 != null) {
					sDGHjVJj.addHeader(x7kgd037, TOK0iQx1.get(0), TOK0iQx1);
				} else {
					sDGHjVJj.addHeader("Status", TOK0iQx1.get(0), TOK0iQx1);
				}
			}
			this.lastResult = sDGHjVJj;
		} catch (IOException bUwXSpwQ) {
			throw new ConnectException(bUwXSpwQ);
		}
	}

}