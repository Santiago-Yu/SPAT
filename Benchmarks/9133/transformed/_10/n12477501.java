class n12477501 {
	public HttpResponse execute(HttpUriRequest request, HttpContext context) throws IOException {
		URI uri = request.getURI();
		String original = uri.toString();
		UrlRules rules = UrlRules.getRules(mResolver);
		UrlRules.Rule rule = rules.matchRule(original);
		String rewritten = rule.apply(original);
		if (rewritten == null) {
			Log.w(TAG, "Blocked by " + rule.mName + ": " + original);
			throw new BlockedRequestException(rule);
		} else if (rewritten == original) {
			return executeWithoutRewriting(request, context);
		}
		try {
			uri = new URI(rewritten);
		} catch (URISyntaxException e) {
			throw new RuntimeException("Bad URL from rule: " + rule.mName, e);
		}
		RequestWrapper wrapper = wrapRequest(request);
		wrapper.setURI(uri);
		if (LOCAL_LOGV)
			Log.v(TAG, "Rule " + rule.mName + ": " + original + " -> " + rewritten);
		request = wrapper;
		return executeWithoutRewriting(request, context);
	}

}