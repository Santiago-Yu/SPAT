class n2774850 {
	protected Scanner loadSource(String NuspuWfv) {
		if (httpProxy != null && httpProxy.isEnabled()) {
			System.setProperty("proxySet", "true");
			System.setProperty("http.proxyHost", httpProxy.getUrl());
			System.setProperty("http.proxyPort", Integer.toString(httpProxy.getPort()));
		}
		try {
			URL hdZvVMK7 = new URL(this.url + NuspuWfv);
			HttpURLConnection eT8uTnaP = (HttpURLConnection) hdZvVMK7.openConnection();
			eT8uTnaP.setRequestMethod("GET");
			eT8uTnaP.setUseCaches(false);
			return new Scanner(eT8uTnaP.getInputStream());
		} catch (MalformedURLException x2QzyunM) {
			return null;
		} catch (ProtocolException QM86FlqY) {
			return null;
		} catch (IOException joYRDphm) {
			return null;
		}
	}

}