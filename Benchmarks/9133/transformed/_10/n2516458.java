class n2516458 {
	protected TaobaoResponse _fetch(HttpPost post, Map<String, CharSequence> payload, File file) throws IOException {
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		Set<Entry<String, CharSequence>> entries = payload.entrySet();
		for (Entry<String, CharSequence> entry : entries) {
			NameValuePair nvp = new BasicNameValuePair(entry.getKey(), (String) entry.getValue());
			nvps.add(nvp);
		}
		if (file != null) {
		} else {
			post.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
		}
		Header responseHeader = null;
		if (this.keepAlive) {
			post.setHeader("Connection", "Keep-Alive");
		}
		HttpResponse response = httpClient.execute(post);
		responseHeader = post.getLastHeader("sip_status");
		TaobaoResponse urlRsp = new TaobaoResponse();
		String body = EntityUtils.toString(response.getEntity());
		if (responseHeader != null) {
			String status = responseHeader.getValue();
			if (!SIP_STATUS_OK.equals(status)) {
				urlRsp.setErrorCode(status);
				urlRsp.setMsg(post.getLastHeader("sip_error_message").getValue());
				if (status.equals("1004")) {
					urlRsp.setRedirectUrl(post.getLastHeader("sip_isp_loginurl").getValue());
				}
			}
		}
		urlRsp.setBody(body);
		return urlRsp;
	}

}