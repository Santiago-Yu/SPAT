class n17143411 {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws WsException {
		String callback = para(req, JsonWriter.CALLBACK, null);
		String input = para(req, INPUT, null);
		String type = para(req, TYPE, "url");
		String format = para(req, FORMAT, null);
		PrintWriter out = null;
		Reader contentReader = null;
		try {
			out = resp.getWriter();
			if (StringUtils.trimToNull(input) == null) {
				resp.setContentType("text/html");
				printHelp(out);
			} else {
				if (type.equalsIgnoreCase("url")) {
					HttpGet httpget = new HttpGet(input);
					try {
						HttpResponse response = client.execute(httpget);
						HttpEntity entity = response.getEntity();
						if (entity != null) {
							String charset = "UTF-8";
							contentReader = new InputStreamReader(entity.getContent(), charset);
							contentReader = (false) ? new FilterXmlReader(contentReader)
									: new BufferedReader(contentReader);
						}
					} catch (RuntimeException ex) {
						httpget.abort();
						throw ex;
					}
				} else {
					contentReader = new StringReader(input);
				}
				long time = System.currentTimeMillis();
				TokenStream stream = nameTokenStream(contentReader);
				SciNameIterator iter = new SciNameIterator(stream);
				if (format != null && format.equalsIgnoreCase("json")) {
					resp.setContentType("application/json");
					streamAsJSON(iter, out, callback);
				} else if (format != null && format.equalsIgnoreCase("xml")) {
					resp.setContentType("text/xml");
					streamAsXML(iter, out);
				} else {
					resp.setContentType("text/plain");
					streamAsText(iter, out);
				}
				log.info("Indexing finished in " + (System.currentTimeMillis() - time) + " msecs");
			}
		} catch (IOException e1) {
			log.error("IOException", e1);
			e1.printStackTrace();
		} finally {
			if (contentReader != null) {
				try {
					contentReader.close();
				} catch (IOException e) {
					log.error("IOException", e);
				}
			}
			out.flush();
			out.close();
		}
	}

}