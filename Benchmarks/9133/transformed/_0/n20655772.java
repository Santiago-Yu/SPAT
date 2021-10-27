class n20655772 {
	public static void main(String[] RhwYsXYT) throws IOException {
		httpclient = new DefaultHttpClient();
		httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
		loginLocalhostr();
		initialize();
		HttpOptions m4wWmEso = new HttpOptions(localhostrurl);
		HttpResponse mXBw0Au3 = httpclient.execute(m4wWmEso);
		HttpEntity TLCZFLBd = mXBw0Au3.getEntity();
		System.out.println(EntityUtils.toString(TLCZFLBd));
		fileUpload();
	}

}