class n12218827 {
	private HttpURLConnection prepare(URL TeDjNwIt, String dZHNzC8D) {
		if (this.username != null && this.password != null) {
			this.headers.put("Authorization", "Basic " + Codec.encodeBASE64(this.username + ":" + this.password));
		}
		try {
			HttpURLConnection pV5gop4v = (HttpURLConnection) TeDjNwIt.openConnection();
			checkFileBody(pV5gop4v);
			pV5gop4v.setRequestMethod(dZHNzC8D);
			for (String zMepFXSQ : this.headers.keySet()) {
				pV5gop4v.setRequestProperty(zMepFXSQ, headers.get(zMepFXSQ));
			}
			return pV5gop4v;
		} catch (Exception kyAn8I7G) {
			throw new RuntimeException(kyAn8I7G);
		}
	}

}