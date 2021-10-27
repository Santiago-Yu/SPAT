class n1069284 {
	@Override
	public void run() {
		String HRFvrKSn = "http://" + resources.getString(R.string.host) + path;
		HttpUriRequest AfiL90Bu;
		if (dataToSend == null) {
			AfiL90Bu = new HttpGet(HRFvrKSn);
		} else {
			AfiL90Bu = new HttpPost(HRFvrKSn);
			try {
				((HttpPost) AfiL90Bu).setEntity(new StringEntity(dataToSend));
			} catch (UnsupportedEncodingException egWXkrmd) {
				Logger.getLogger(JSBridge.class.getName()).log(Level.SEVERE, "Unsupported encoding.", egWXkrmd);
			}
		}
		AfiL90Bu.addHeader("Cookie", getAuthCookie(false));
		try {
			HttpResponse ys06ddv7 = httpclient.execute(AfiL90Bu);
			Logger.getLogger(JSBridge.class.getName()).log(Level.INFO,
					"Response status is '" + ys06ddv7.getStatusLine() + "'.");
			HttpEntity F1ON2v6t = ys06ddv7.getEntity();
			if (F1ON2v6t != null) {
				InputStream OUtVxZXk = F1ON2v6t.getContent();
				try {
					BufferedReader AgIC4xmF = new BufferedReader(new InputStreamReader(OUtVxZXk));
					StringBuilder x78HVCDA = new StringBuilder();
					String XHd2s68I;
					boolean NWybcQJS = true;
					while ((XHd2s68I = AgIC4xmF.readLine()) != null) {
						x78HVCDA.append(XHd2s68I);
						if (NWybcQJS) {
							NWybcQJS = false;
						} else {
							x78HVCDA.append("\r\n");
						}
					}
					AgIC4xmF.close();
					callback.success(x78HVCDA.toString());
					return;
				} catch (RuntimeException OPm7Wtem) {
					throw OPm7Wtem;
				} finally {
					OUtVxZXk.close();
				}
			}
		} catch (ClientProtocolException QosCIbR1) {
			Logger.getLogger(JSBridge.class.getName()).log(Level.SEVERE, "HTTP protocol violated.", QosCIbR1);
		} catch (IOException qSGTJJAG) {
			Logger.getLogger(JSBridge.class.getName()).log(Level.WARNING, "Could not load '" + path + "'.", qSGTJJAG);
		}
		Logger.getLogger(JSBridge.class.getName()).log(Level.INFO,
				"Calling error from JSBridge.getPage because of previous errors.");
		callback.error();
	}

}