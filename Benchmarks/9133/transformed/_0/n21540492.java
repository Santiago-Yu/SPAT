class n21540492 {
	public InputStream getStream(Hashtable<String, String> tSSmeCfb) throws IOException {
		List<NameValuePair> gFAVgJmd = new ArrayList<NameValuePair>();
		Enumeration<String> yBA10GP7 = tSSmeCfb.keys();
		String U8a3so0O;
		while (yBA10GP7.hasMoreElements()) {
			U8a3so0O = yBA10GP7.nextElement();
			gFAVgJmd.add(new BasicNameValuePair(U8a3so0O, tSSmeCfb.get(U8a3so0O)));
		}
		httpPost.setEntity(new UrlEncodedFormEntity(gFAVgJmd, HTTP.UTF_8));
		HttpResponse rWEbdVp9 = httpclient.execute(httpPost);
		HttpEntity fdeli6zf = rWEbdVp9.getEntity();
		return fdeli6zf.getContent();
	}

}