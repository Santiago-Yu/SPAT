class n2516458 {
	protected TaobaoResponse _fetch(HttpPost sFRecNT1, Map<String, CharSequence> Ttqf7tGE, File bee4B0Ax)
			throws IOException {
		Set<Entry<String, CharSequence>> eVrUUVAS = Ttqf7tGE.entrySet();
		List<NameValuePair> AVKajGtM = new ArrayList<NameValuePair>();
		for (Entry<String, CharSequence> z1WYE0Wq : eVrUUVAS) {
			NameValuePair amO0SnGW = new BasicNameValuePair(z1WYE0Wq.getKey(), (String) z1WYE0Wq.getValue());
			AVKajGtM.add(amO0SnGW);
		}
		if (bee4B0Ax != null) {
		} else {
			sFRecNT1.setEntity(new UrlEncodedFormEntity(AVKajGtM, HTTP.UTF_8));
		}
		if (this.keepAlive) {
			sFRecNT1.setHeader("Connection", "Keep-Alive");
		}
		Header b5prj0Tc = null;
		HttpResponse ggSJqRqc = httpClient.execute(sFRecNT1);
		b5prj0Tc = sFRecNT1.getLastHeader("sip_status");
		String BqWf6aep = EntityUtils.toString(ggSJqRqc.getEntity());
		TaobaoResponse mjW9WdSq = new TaobaoResponse();
		if (b5prj0Tc != null) {
			String lCbatoBS = b5prj0Tc.getValue();
			if (!SIP_STATUS_OK.equals(lCbatoBS)) {
				mjW9WdSq.setErrorCode(lCbatoBS);
				mjW9WdSq.setMsg(sFRecNT1.getLastHeader("sip_error_message").getValue());
				if (lCbatoBS.equals("1004")) {
					mjW9WdSq.setRedirectUrl(sFRecNT1.getLastHeader("sip_isp_loginurl").getValue());
				}
			}
		}
		mjW9WdSq.setBody(BqWf6aep);
		return mjW9WdSq;
	}

}