class n2516458 {
	protected TaobaoResponse _fetch(HttpPost post, Map<String, CharSequence> payload, File file) throws IOException {
		Set<Entry<String, CharSequence>> entries = payload.entrySet();
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		for (Entry<String, CharSequence> entry : entries) {
			NameValuePair nvp = new BasicNameValuePair(entry.getKey(), (String) entry.getValue());
			nvps.add(nvp);
		}
		if (file != null) {
		} else {
			post.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
		}
		if (this.keepAlive) {
			post.setHeader("Connection", "Keep-Alive");
		}
		Header responseHeader = null;
		HttpResponse response = httpClient.execute(post);
		responseHeader = post.getLastHeader("sip_status");
		String body = EntityUtils.toString(response.getEntity());
		TaobaoResponse urlRsp = new TaobaoResponse();
		if (responseHeader != null) {
			String status = responseHeader.getValue();
			if (!SIP_STATUS_OK.equals(status)) {
				urlRsp.setErrorCode(status);
				urlRsp.setMsg(post.getLastHeader("sip_error_message").getValue());
				if ("1004".equals(status)) {
					urlRsp.setRedirectUrl(post.getLastHeader("sip_isp_loginurl").getValue());
				}
			}
		}
		urlRsp.setBody(body);
		return urlRsp;
	}

}