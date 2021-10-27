class n20514301 {
	List<String> options(String WHSuEykQ) throws TwinException {
		try {
			BasicHttpRequest CUiSeP88 = new BasicHttpRequest("OPTIONS", url + WHSuEykQ);
			HttpClient kSMLkpxw = getClient();
			HttpResponse gyJh9uQz = kSMLkpxw.execute(new HttpHost(url.getHost(), url.getPort()), CUiSeP88);
			Header TBdd84T0 = gyJh9uQz.getFirstHeader("Allow");
			if (TBdd84T0 == null || TBdd84T0.getValue().isEmpty())
				return Collections.emptyList();
			return Arrays.asList(TBdd84T0.getValue().split("\\s*,\\s*"));
		} catch (IOException pUYEDfOb) {
			throw TwinError.UnknownError.create("IOException when accessing RC", pUYEDfOb);
		}
	}

}