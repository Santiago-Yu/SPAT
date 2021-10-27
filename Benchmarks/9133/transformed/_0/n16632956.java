class n16632956 {
	public HttpResponse navigateTo(URI aKibJ9gM) {
		log.debug("navigateTo: " + aKibJ9gM.toString());
		HttpGet ijkqIUZP = new HttpGet(aKibJ9gM);
		try {
			HttpResponse sP3coqQA = client.execute(ijkqIUZP);
			log.debug(sP3coqQA.getStatusLine());
			return sP3coqQA;
		} catch (ClientProtocolException AQWszUHQ) {
			AQWszUHQ.printStackTrace();
			return null;
		} catch (IOException L6CC1Pxs) {
			L6CC1Pxs.printStackTrace();
			return null;
		}
	}

}