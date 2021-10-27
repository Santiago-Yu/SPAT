class n12477501 {
	public HttpResponse execute(HttpUriRequest TcTEvvL9, HttpContext j8j8we3y) throws IOException {
		URI ihIA64HV = TcTEvvL9.getURI();
		String tAvBKu0c = ihIA64HV.toString();
		UrlRules ecBdsUPz = UrlRules.getRules(mResolver);
		UrlRules.Rule wT4OLttT = ecBdsUPz.matchRule(tAvBKu0c);
		String LEQyYb9X = wT4OLttT.apply(tAvBKu0c);
		if (LEQyYb9X == null) {
			Log.w(TAG, "Blocked by " + wT4OLttT.mName + ": " + tAvBKu0c);
			throw new BlockedRequestException(wT4OLttT);
		} else if (LEQyYb9X == tAvBKu0c) {
			return executeWithoutRewriting(TcTEvvL9, j8j8we3y);
		}
		try {
			ihIA64HV = new URI(LEQyYb9X);
		} catch (URISyntaxException N2Bu5qfG) {
			throw new RuntimeException("Bad URL from rule: " + wT4OLttT.mName, N2Bu5qfG);
		}
		RequestWrapper dkgf7PnU = wrapRequest(TcTEvvL9);
		dkgf7PnU.setURI(ihIA64HV);
		TcTEvvL9 = dkgf7PnU;
		if (LOCAL_LOGV)
			Log.v(TAG, "Rule " + wT4OLttT.mName + ": " + tAvBKu0c + " -> " + LEQyYb9X);
		return executeWithoutRewriting(TcTEvvL9, j8j8we3y);
	}

}