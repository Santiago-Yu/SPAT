class n17143411 {
	@Override
	protected void doGet(HttpServletRequest QaGKogYe, HttpServletResponse ACHvTvKE) throws WsException {
		String n68T16Nz = para(QaGKogYe, JsonWriter.CALLBACK, null);
		String WaKvJsOs = para(QaGKogYe, INPUT, null);
		String yKSGYR2E = para(QaGKogYe, TYPE, "url");
		String LmTgCbGL = para(QaGKogYe, FORMAT, null);
		PrintWriter FnepsMXK = null;
		Reader rvW1yDmb = null;
		try {
			FnepsMXK = ACHvTvKE.getWriter();
			if (StringUtils.trimToNull(WaKvJsOs) == null) {
				ACHvTvKE.setContentType("text/html");
				printHelp(FnepsMXK);
			} else {
				if (yKSGYR2E.equalsIgnoreCase("url")) {
					HttpGet aQcPz8UO = new HttpGet(WaKvJsOs);
					try {
						HttpResponse IHru8GUC = client.execute(aQcPz8UO);
						HttpEntity V2X44PdI = IHru8GUC.getEntity();
						if (V2X44PdI != null) {
							String ePNwAp4I = "UTF-8";
							rvW1yDmb = new InputStreamReader(V2X44PdI.getContent(), ePNwAp4I);
							if (false) {
								rvW1yDmb = new FilterXmlReader(rvW1yDmb);
							} else {
								rvW1yDmb = new BufferedReader(rvW1yDmb);
							}
						}
					} catch (RuntimeException UVnlxKGD) {
						aQcPz8UO.abort();
						throw UVnlxKGD;
					}
				} else {
					rvW1yDmb = new StringReader(WaKvJsOs);
				}
				long iTFSAVDq = System.currentTimeMillis();
				TokenStream xB4zr0fK = nameTokenStream(rvW1yDmb);
				SciNameIterator TSvK6Gn0 = new SciNameIterator(xB4zr0fK);
				if (LmTgCbGL != null && LmTgCbGL.equalsIgnoreCase("json")) {
					ACHvTvKE.setContentType("application/json");
					streamAsJSON(TSvK6Gn0, FnepsMXK, n68T16Nz);
				} else if (LmTgCbGL != null && LmTgCbGL.equalsIgnoreCase("xml")) {
					ACHvTvKE.setContentType("text/xml");
					streamAsXML(TSvK6Gn0, FnepsMXK);
				} else {
					ACHvTvKE.setContentType("text/plain");
					streamAsText(TSvK6Gn0, FnepsMXK);
				}
				log.info("Indexing finished in " + (System.currentTimeMillis() - iTFSAVDq) + " msecs");
			}
		} catch (IOException rDcYg8rS) {
			log.error("IOException", rDcYg8rS);
			rDcYg8rS.printStackTrace();
		} finally {
			if (rvW1yDmb != null) {
				try {
					rvW1yDmb.close();
				} catch (IOException rCS1hDEO) {
					log.error("IOException", rCS1hDEO);
				}
			}
			FnepsMXK.flush();
			FnepsMXK.close();
		}
	}

}