class n17874479 {
	public static final void main(String[] Z3D2GLWv) throws Exception {
		HttpClient Wmh1TwHu = new DefaultHttpClient();
		HttpGet N2UCFkLs = new HttpGet("http://www.apache.org/");
		System.out.println("executing request " + N2UCFkLs.getURI());
		HttpResponse jB1Moi6b = Wmh1TwHu.execute(N2UCFkLs);
		HttpEntity szihwGO5 = jB1Moi6b.getEntity();
		System.out.println("----------------------------------------");
		System.out.println(jB1Moi6b.getStatusLine());
		if (szihwGO5 != null) {
			System.out.println("Response content length: " + szihwGO5.getContentLength());
		}
		System.out.println("----------------------------------------");
		N2UCFkLs.abort();
	}

}