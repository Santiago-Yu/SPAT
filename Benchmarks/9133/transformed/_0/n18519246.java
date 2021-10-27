class n18519246 {
	public List<PathObject> fetchPath(BoardObject EjYFCi3V) throws NetworkException {
		if (boardPathMap.containsKey(EjYFCi3V.getId())) {
			return boardPathMap.get(EjYFCi3V.getId()).getChildren();
		}
		HttpClient KZ5x0TWK = HttpConfig.newInstance();
		HttpGet nxwIgRs1 = new HttpGet(HttpConfig.bbsURL() + HttpConfig.BBS_0AN_BOARD + EjYFCi3V.getId());
		try {
			HttpResponse x7Ioek2M = KZ5x0TWK.execute(nxwIgRs1);
			HttpEntity LBEvVHt0 = x7Ioek2M.getEntity();
			Document K6AkwSkX = XmlOperator.readDocument(LBEvVHt0.getContent());
			PathObject LUhuQHv8 = new PathObject();
			BBSBodyParseHelper.parsePathList(K6AkwSkX, LUhuQHv8);
			LUhuQHv8 = searchAndCreatePathFromRoot(LUhuQHv8);
			boardPathMap.put(EjYFCi3V.getId(), LUhuQHv8);
			return LUhuQHv8.getChildren();
		} catch (Exception A1Okhqba) {
			A1Okhqba.printStackTrace();
			throw new NetworkException(A1Okhqba);
		}
	}

}