class n20210697 {
	public RTUser getUserInfo(final String username) {
		getSession();
		Map<String, String> attributes = Collections.emptyMap();
		final HttpGet get = new HttpGet(m_baseURL + "/REST/1.0/user/" + username);
		try {
			final HttpResponse response = getClient().execute(get);
			int responseCode = response.getStatusLine().getStatusCode();
			if (responseCode != HttpStatus.SC_OK) {
				throw new RequestTrackerException("Received a non-200 response code from the server: " + responseCode);
			} else {
				attributes = (response.getEntity() != null) ? parseResponseStream(response.getEntity().getContent())
						: attributes;
			}
		} catch (final Exception e) {
			LogUtils.errorf(this, e, "An exception occurred while getting user info for " + username);
			return null;
		}
		final String id = attributes.get("id");
		final String realname = attributes.get("realname");
		final String email = attributes.get("emailaddress");
		if (id == null || "".equals(id)) {
			LogUtils.errorf(this, "Unable to retrieve ID from user info.");
			return null;
		}
		return new RTUser(Long.parseLong(id.replace("user/", "")), username, realname, email);
	}

}