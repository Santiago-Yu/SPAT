class n7875897 {
	@SuppressWarnings("unchecked")
	protected void handleRequest(HttpServletRequest req, HttpServletResponse resp, boolean isPost)
			throws ServletException, IOException {
		HttpClient httpclient = WebReader.getHttpClient();
		try {
			StringBuffer sb = new StringBuffer();
			sb.append(targetServer);
			sb.append(req.getRequestURI());
			HttpRequestBase targetRequest = null;
			if (req.getQueryString() != null) {
				sb.append("?" + req.getQueryString());
			}
			if (isPost) {
				Enumeration<String> paramNames = req.getParameterNames();
				HttpPost post = new HttpPost(sb.toString());
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				String paramName = null;
				while (paramNames.hasMoreElements()) {
					paramName = paramNames.nextElement();
					params.add(new BasicNameValuePair(paramName, req.getParameterValues(paramName)[0]));
				}
				post.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
				targetRequest = post;
			} else {
				System.out.println("GET");
				HttpGet get = new HttpGet(sb.toString());
				targetRequest = get;
			}
			HttpResponse targetResponse = httpclient.execute(targetRequest);
			HttpEntity entity = targetResponse.getEntity();
			InputStream input = entity.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			OutputStream output = resp.getOutputStream();
			String line = reader.readLine();
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
			while (line != null) {
				writer.write(line + "\n");
				line = reader.readLine();
			}
			reader.close();
			writer.close();
		} finally {
			WebReader.returnHttpClient(httpclient);
		}
	}

}