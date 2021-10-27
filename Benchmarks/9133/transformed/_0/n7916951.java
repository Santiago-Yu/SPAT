class n7916951 {
	@Override
	public List<WebSearchResult> search(String pEBAXLIV) {
		List<GoogleResult> MLsm0MbG = null;
		try {
			URL f5hJF47R = new URL(GoogleWebSearch.GOOGLE_URL + URLEncoder.encode(pEBAXLIV, GoogleWebSearch.CHARSET));
			Reader QRBq63Gn = new InputStreamReader(f5hJF47R.openStream(), GoogleWebSearch.CHARSET);
			GoogleResponse HV6WZT7x = new Gson().fromJson(QRBq63Gn, GoogleResponse.class);
			MLsm0MbG = HV6WZT7x.getResponseData().getResults();
		} catch (Exception o5o0u1oQ) {
			o5o0u1oQ.printStackTrace();
		}
		List<WebSearchResult> cFrFGilW = new ArrayList<WebSearchResult>();
		if (MLsm0MbG != null) {
			cFrFGilW.addAll(MLsm0MbG);
		}
		return cFrFGilW;
	}

}