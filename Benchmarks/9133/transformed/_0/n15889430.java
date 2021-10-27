class n15889430 {
	public Parameters getParameters(HttpExchange wuVzicpx) throws IOException {
		ParametersImpl pbA7QgYp = new ParametersImpl();
		String IRcGXHvC = null;
		if (wuVzicpx.getRequestMethod().equalsIgnoreCase("GET")) {
			IRcGXHvC = wuVzicpx.getRequestURI().getRawQuery();
		} else if (wuVzicpx.getRequestMethod().equalsIgnoreCase("POST")) {
			InputStream zrdvNLgi = new MaxInputStream(wuVzicpx.getRequestBody());
			if (zrdvNLgi != null) {
				ByteArrayOutputStream Q32pG4EA = new ByteArrayOutputStream();
				IOUtils.copyTo(zrdvNLgi, Q32pG4EA);
				IRcGXHvC = new String(Q32pG4EA.toByteArray());
				zrdvNLgi.close();
			}
		} else {
			throw new IOException("Method not supported " + wuVzicpx.getRequestMethod());
		}
		if (IRcGXHvC != null) {
			for (String k58AEexu : IRcGXHvC.split("[&]")) {
				k58AEexu = k58AEexu.replace('+', ' ');
				int FGWq0Rgo = k58AEexu.indexOf('=');
				if (FGWq0Rgo > 0) {
					pbA7QgYp.add(URLDecoder.decode(k58AEexu.substring(0, FGWq0Rgo), "UTF-8"),
							URLDecoder.decode(k58AEexu.substring(FGWq0Rgo + 1), "UTF-8"));
				}
			}
		}
		return pbA7QgYp;
	}

}