class n20210696 {
	public Long postEdit(final HttpPost post, final String content, final Pattern pattern)
			throws RequestTrackerException {
		String rtTicketNumber = null;
		final List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("user", m_user));
		params.add(new BasicNameValuePair("pass", m_password));
		params.add(new BasicNameValuePair("content", content));
		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, "UTF-8");
			post.setEntity(entity);
		} catch (final UnsupportedEncodingException e) {
			LogUtils.warnf(this, e, "unsupported encoding exception for UTF-8 -- WTF?!");
		}
		try {
			final HttpResponse response = getClient().execute(post);
			int responseCode = response.getStatusLine().getStatusCode();
			if (responseCode != HttpStatus.SC_OK) {
				throw new RequestTrackerException("Received a non-200 response code from the server: " + responseCode);
			} else {
				final String in = EntityUtils.toString(response.getEntity());
				final Matcher matcher = pattern.matcher(in);
				if (matcher.find()) {
					rtTicketNumber = matcher.group(1);
				} else {
					LogUtils.debugf(this, "did not get ticket ID from response when posting to %s", post.toString());
				}
			}
		} catch (final Exception e) {
			LogUtils.errorf(this, e, "Failure attempting to update ticket.");
			throw new RequestTrackerException(e);
		}
		if (null == rtTicketNumber) {
			return null;
		}
		return Long.valueOf(rtTicketNumber);
	}

}