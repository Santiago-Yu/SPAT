class n23107114 {
	private static InputStream download(String wFqzFsFI) {
		try {
			HttpClient RsJYHxKa = new DefaultHttpClient();
			HttpGet hkgd92Cw = new HttpGet(wFqzFsFI);
			HttpResponse pb4OK1k9 = RsJYHxKa.execute(hkgd92Cw);
			HttpEntity OBIZQ9Mf = pb4OK1k9.getEntity();
			if (OBIZQ9Mf != null) {
				return OBIZQ9Mf.getContent();
			}
		} catch (Exception nRAZTUw2) {
			Log.e("Android", nRAZTUw2.getMessage());
		}
		return null;
	}

}