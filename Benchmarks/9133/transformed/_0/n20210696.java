class n20210696 {
	public Long postEdit(final HttpPost BaU3ta7g, final String nJlCp3uU, final Pattern Q9LBeDBs)
			throws RequestTrackerException {
		String rqXI5wtP = null;
		final List<NameValuePair> Fn79lW7B = new ArrayList<NameValuePair>();
		Fn79lW7B.add(new BasicNameValuePair("user", m_user));
		Fn79lW7B.add(new BasicNameValuePair("pass", m_password));
		Fn79lW7B.add(new BasicNameValuePair("content", nJlCp3uU));
		try {
			UrlEncodedFormEntity NvCF2ACn = new UrlEncodedFormEntity(Fn79lW7B, "UTF-8");
			BaU3ta7g.setEntity(NvCF2ACn);
		} catch (final UnsupportedEncodingException GZRJUhMG) {
			LogUtils.warnf(this, GZRJUhMG, "unsupported encoding exception for UTF-8 -- WTF?!");
		}
		try {
			final HttpResponse KYTnTU8S = getClient().execute(BaU3ta7g);
			int UngjMAXh = KYTnTU8S.getStatusLine().getStatusCode();
			if (UngjMAXh != HttpStatus.SC_OK) {
				throw new RequestTrackerException("Received a non-200 response code from the server: " + UngjMAXh);
			} else {
				final String iazdmCqG = EntityUtils.toString(KYTnTU8S.getEntity());
				final Matcher z4VSPzZn = Q9LBeDBs.matcher(iazdmCqG);
				if (z4VSPzZn.find()) {
					rqXI5wtP = z4VSPzZn.group(1);
				} else {
					LogUtils.debugf(this, "did not get ticket ID from response when posting to %s",
							BaU3ta7g.toString());
				}
			}
		} catch (final Exception z1jcXRzY) {
			LogUtils.errorf(this, z1jcXRzY, "Failure attempting to update ticket.");
			throw new RequestTrackerException(z1jcXRzY);
		}
		if (rqXI5wtP == null) {
			return null;
		}
		return Long.valueOf(rqXI5wtP);
	}

}