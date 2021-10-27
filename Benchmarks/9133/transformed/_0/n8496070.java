class n8496070 {
	private void removeSessionId(InputStream Ag6ry8VY, Output UHZoUzyq) throws IOException {
		String mIRbV5zR = RewriteUtils.getSessionId(target);
		boolean GuyKjyyI = ResourceUtils.isTextContentType(httpClientResponse.getHeader("Content-Type"));
		if (mIRbV5zR == null || !GuyKjyyI) {
			IOUtils.copy(Ag6ry8VY, UHZoUzyq.getOutputStream());
		} else {
			String X1ia8x4N = httpClientResponse.getContentCharset();
			if (X1ia8x4N == null) {
				X1ia8x4N = "ISO-8859-1";
			}
			String U20ht8Yg = IOUtils.toString(Ag6ry8VY, X1ia8x4N);
			U20ht8Yg = removeSessionId(mIRbV5zR, U20ht8Yg);
			if (UHZoUzyq.getHeader("Content-length") != null) {
				UHZoUzyq.setHeader("Content-length", Integer.toString(U20ht8Yg.length()));
			}
			OutputStream Wv05yOoY = UHZoUzyq.getOutputStream();
			IOUtils.write(U20ht8Yg, Wv05yOoY, X1ia8x4N);
		}
		Ag6ry8VY.close();
	}

}