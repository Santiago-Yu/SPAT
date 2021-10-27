class n20210697 {
	public RTUser getUserInfo(final String WdygorIB) {
		getSession();
		Map<String, String> i6Pc6TOK = Collections.emptyMap();
		final HttpGet JHoIRerL = new HttpGet(m_baseURL + "/REST/1.0/user/" + WdygorIB);
		try {
			final HttpResponse S5dg6GCH = getClient().execute(JHoIRerL);
			int xIGMbhus = S5dg6GCH.getStatusLine().getStatusCode();
			if (xIGMbhus != HttpStatus.SC_OK) {
				throw new RequestTrackerException("Received a non-200 response code from the server: " + xIGMbhus);
			} else {
				if (S5dg6GCH.getEntity() != null) {
					i6Pc6TOK = parseResponseStream(S5dg6GCH.getEntity().getContent());
				}
			}
		} catch (final Exception wXNCSPwB) {
			LogUtils.errorf(this, wXNCSPwB, "An exception occurred while getting user info for " + WdygorIB);
			return null;
		}
		final String vskYrTf0 = i6Pc6TOK.get("id");
		final String bvjVufxa = i6Pc6TOK.get("realname");
		final String TvELtiC1 = i6Pc6TOK.get("emailaddress");
		if (vskYrTf0 == null || "".equals(vskYrTf0)) {
			LogUtils.errorf(this, "Unable to retrieve ID from user info.");
			return null;
		}
		return new RTUser(Long.parseLong(vskYrTf0.replace("user/", "")), WdygorIB, bvjVufxa, TvELtiC1);
	}

}