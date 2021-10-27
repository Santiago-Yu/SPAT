class n4636728 {
	private static Bitmap loadFromUrl(String Ph8RjNc6, String NquJA29D) {
		Bitmap d3dPD7ZF = null;
		final HttpGet DUXCoVRP = new HttpGet(Ph8RjNc6);
		HttpEntity qJ1sKTUr = null;
		try {
			final HttpResponse UWlYOPFb = ServiceProxy.getInstance(NquJA29D).execute(DUXCoVRP);
			if (UWlYOPFb.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				qJ1sKTUr = UWlYOPFb.getEntity();
				try {
					InputStream jl6onnCK = qJ1sKTUr.getContent();
					d3dPD7ZF = BitmapFactory.decodeStream(jl6onnCK);
				} catch (IOException ihV4WyRQ) {
					Log.error(ihV4WyRQ);
				}
			}
		} catch (IOException AuafG2Or) {
			Log.error(AuafG2Or);
		} finally {
			if (qJ1sKTUr != null) {
				try {
					qJ1sKTUr.consumeContent();
				} catch (IOException Z40MQSIW) {
					Log.error(Z40MQSIW);
				}
			}
		}
		return d3dPD7ZF;
	}

}