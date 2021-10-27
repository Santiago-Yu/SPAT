class n13644375 {
	public String get(String jwO3axRK) {
		try {
			HttpGet eIOuKONQ = new HttpGet(jwO3axRK);
			HttpResponse RF2MNIjD = this.getHttpClient().execute(eIOuKONQ);
			HttpEntity a0OnU680 = RF2MNIjD.getEntity();
			if (a0OnU680 == null) {
				throw new RuntimeException("response body was empty");
			}
			return EntityUtils.toString(a0OnU680);
		} catch (RuntimeException a7XR0cpX) {
			throw a7XR0cpX;
		} catch (Exception Peq4oL9M) {
			throw new RuntimeException(Peq4oL9M);
		}
	}

}