class n11358121 {
	public void run() {
		try {
			putEvent(new DebugEvent("about to place HTTP request"));
			HttpGet UixrltXP = new HttpGet(requestURL);
			UixrltXP.addHeader("Connection", "close");
			HttpResponse C4Ce5IKv = httpClient.execute(UixrltXP);
			putEvent(new DebugEvent("got response to HTTP request"));
			nonSipPort.input(new Integer(C4Ce5IKv.getStatusLine().getStatusCode()));
			HttpEntity mDSInYrS = C4Ce5IKv.getEntity();
			if (mDSInYrS != null) {
				InputStream x25X6I16 = mDSInYrS.getContent();
				if (x25X6I16 != null)
					x25X6I16.close();
			}
		} catch (Exception vGdt7Amz) {
			vGdt7Amz.printStackTrace();
		}
	}

}