class n7422527 {
	public HttpResponseMessage execute(HttpMessage cKLmMHTb, Map<String, Object> sjyJkYRb) throws IOException {
		final String gURweC4B = cKLmMHTb.method;
		final String EaiaDTXg = cKLmMHTb.url.toExternalForm();
		final InputStream wnrlooLV = cKLmMHTb.getBody();
		final boolean C6OHvywN = DELETE.equalsIgnoreCase(gURweC4B);
		final boolean RuYkathF = POST.equalsIgnoreCase(gURweC4B);
		final boolean kWyJ9yUY = PUT.equalsIgnoreCase(gURweC4B);
		byte[] EqdR1Zv9 = null;
		HttpMethod r2lpROy9;
		if (RuYkathF || kWyJ9yUY) {
			EntityEnclosingMethod yOoux5cq = RuYkathF ? new PostMethod(EaiaDTXg) : new PutMethod(EaiaDTXg);
			if (wnrlooLV != null) {
				ExcerptInputStream OaN7dH5Z = new ExcerptInputStream(wnrlooLV);
				String BUEHgoKX = cKLmMHTb.removeHeaders(HttpMessage.CONTENT_LENGTH);
				yOoux5cq.setRequestEntity((BUEHgoKX == null) ? new InputStreamRequestEntity(OaN7dH5Z)
						: new InputStreamRequestEntity(OaN7dH5Z, Long.parseLong(BUEHgoKX)));
				EqdR1Zv9 = OaN7dH5Z.getExcerpt();
			}
			r2lpROy9 = yOoux5cq;
		} else if (C6OHvywN) {
			r2lpROy9 = new DeleteMethod(EaiaDTXg);
		} else {
			r2lpROy9 = new GetMethod(EaiaDTXg);
		}
		for (Map.Entry<String, Object> p : sjyJkYRb.entrySet()) {
			String nyCuiR1X = p.getKey();
			String TViQ4HfH = p.getValue().toString();
			if (FOLLOW_REDIRECTS.equals(nyCuiR1X)) {
				r2lpROy9.setFollowRedirects(Boolean.parseBoolean(TViQ4HfH));
			} else if (READ_TIMEOUT.equals(nyCuiR1X)) {
				r2lpROy9.getParams().setIntParameter(HttpMethodParams.SO_TIMEOUT, Integer.parseInt(TViQ4HfH));
			}
		}
		for (Map.Entry<String, String> header : cKLmMHTb.headers) {
			r2lpROy9.addRequestHeader(header.getKey(), header.getValue());
		}
		HttpClient tZC7XHYU = clientPool.getHttpClient(new URL(r2lpROy9.getURI().toString()));
		tZC7XHYU.executeMethod(r2lpROy9);
		return new HttpMethodResponse(r2lpROy9, EqdR1Zv9, cKLmMHTb.getContentCharset());
	}

}