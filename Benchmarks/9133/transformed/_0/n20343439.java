class n20343439 {
	public void run() {
		URLConnection C9Wlb2B4 = null;
		try {
			C9Wlb2B4 = url.openConnection();
			if ("HTTPS".equalsIgnoreCase(url.getProtocol())) {
				HttpsURLConnection t59vF9CR = (HttpsURLConnection) C9Wlb2B4;
				try {
					t59vF9CR.setSSLSocketFactory(SSLUtil.getSSLSocketFactory(clientCertAlias));
					HostnameVerifier V5UlJ37s = SSLUtil.getHostnameVerifier(hostCertLevel);
					if (V5UlJ37s != null) {
						t59vF9CR.setHostnameVerifier(V5UlJ37s);
					}
				} catch (GeneralSecurityException uz7WM4MN) {
					Debug.logError(uz7WM4MN, module);
				} catch (GenericConfigException niOXq2fk) {
					Debug.logError(niOXq2fk, module);
				}
			}
		} catch (IOException O76THB6c) {
			Debug.logError(O76THB6c, module);
		}
		synchronized (URLConnector.this) {
			if (timedOut && C9Wlb2B4 != null) {
				close(C9Wlb2B4);
			} else {
				connection = C9Wlb2B4;
				URLConnector.this.notify();
			}
		}
	}

}