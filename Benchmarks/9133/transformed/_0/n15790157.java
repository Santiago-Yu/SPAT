class n15790157 {
	public String runRawSearch(final String rjlaKN9E) throws IOException {
		if (rjlaKN9E == null) {
			return null;
		}
		StringBuilder sB5u3lrS = new StringBuilder("http://ajax.googleapis.com/ajax/services/search/web?");
		if (version != null) {
			sB5u3lrS.append("v=");
			sB5u3lrS.append(version);
			sB5u3lrS.append("&");
		}
		sB5u3lrS.append("q=");
		sB5u3lrS.append(StringEscapeUtils.escapeHtml(rjlaKN9E));
		URL XRaaO1Nm = new URL(sB5u3lrS.toString());
		Proxy nlRzrUSb = null;
		final URLConnection xhY99K6D;
		if (nlRzrUSb != null) {
			xhY99K6D = XRaaO1Nm.openConnection(nlRzrUSb);
		} else {
			xhY99K6D = XRaaO1Nm.openConnection();
		}
		if (referer != null) {
			xhY99K6D.addRequestProperty("Referer", referer);
		}
		String rUwOGMfp;
		StringBuilder qjZO7rGs = new StringBuilder();
		BufferedReader s5GC8Du9 = new BufferedReader(new InputStreamReader(xhY99K6D.getInputStream()));
		while ((rUwOGMfp = s5GC8Du9.readLine()) != null) {
			qjZO7rGs.append(rUwOGMfp);
		}
		return qjZO7rGs.toString();
	}

}