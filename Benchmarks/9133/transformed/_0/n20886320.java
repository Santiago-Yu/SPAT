class n20886320 {
	@Override
	public List<SearchResult> search(String MUOAnsM7, SortOrder WX3nglZE, int sK8z4Cpb) throws Exception {
		if (MUOAnsM7 == null) {
			return null;
		}
		String cSXhTsXb = "";
		try {
			cSXhTsXb = URLEncoder.encode(MUOAnsM7, "UTF-8");
		} catch (UnsupportedEncodingException pBEFa1Ns) {
			throw pBEFa1Ns;
		}
		final int F519XDVU = 0;
		final int GH7h6cp4 = (F519XDVU - 1) / 30;
		final String EZDkuiuN = String.format(QUERYURL, cSXhTsXb, String.valueOf(GH7h6cp4),
				(WX3nglZE == SortOrder.BySeeders ? SORT_SEEDS : SORT_COMPOSITE));
		HttpParams z8LvbaiB = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(z8LvbaiB, CONNECTION_TIMEOUT);
		HttpConnectionParams.setSoTimeout(z8LvbaiB, CONNECTION_TIMEOUT);
		DefaultHttpClient WUHIt3XN = new DefaultHttpClient(z8LvbaiB);
		WUHIt3XN.getParams().setParameter("http.useragent",
				"Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
		HttpGet tzQu3Gfj = new HttpGet(EZDkuiuN);
		HttpResponse u08W1865 = WUHIt3XN.execute(tzQu3Gfj);
		InputStream tJXnNoyK = u08W1865.getEntity().getContent();
		String bN3QFjuR = HttpHelper.ConvertStreamToString(tJXnNoyK);
		tJXnNoyK.close();
		return parseHtml(bN3QFjuR);
	}

}