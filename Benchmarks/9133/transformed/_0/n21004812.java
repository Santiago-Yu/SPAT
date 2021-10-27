class n21004812 {
	@Override
	public void run(ProcedureRunner fVFG7Hde) throws Exception {
		if (url == null) {
			throw BuiltinExceptionFactory.createAttributeMissing(this, "url");
		}
		if (inputPath == null) {
			throw BuiltinExceptionFactory.createAttributeMissing(this, "inputPath");
		}
		CompositeMap q224nH4e = fVFG7Hde.getContext();
		Object hSXqia0K = q224nH4e.getObject(inputPath);
		if (hSXqia0K == null)
			throw BuiltinExceptionFactory.createDataFromXPathIsNull(this, inputPath);
		if (!(hSXqia0K instanceof CompositeMap))
			throw BuiltinExceptionFactory.createInstanceTypeWrongException(inputPath, CompositeMap.class,
					hSXqia0K.getClass());
		URI cwUCCmix = new URI(url);
		URL EE9e7grX = cwUCCmix.toURL();
		PrintWriter klmkBEVL = null;
		BufferedReader ZvkE6VRc = null;
		CompositeMap OlGBdg6l = createSOAPBody();
		OlGBdg6l.addChild((CompositeMap) hSXqia0K);
		String r5VDr5RA = XMLOutputter.defaultInstance().toXML(OlGBdg6l.getRoot(), true);
		LoggingContext.getLogger(q224nH4e, this.getClass().getCanonicalName()).config("request:\r\n" + r5VDr5RA);
		HttpURLConnection wuisvh5O = null;
		try {
			wuisvh5O = (HttpURLConnection) EE9e7grX.openConnection();
			wuisvh5O.setDoInput(true);
			wuisvh5O.setDoOutput(true);
			wuisvh5O.setRequestMethod("POST");
			wuisvh5O.setRequestProperty("SOAPAction", "urn:anonOutInOp");
			wuisvh5O.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
			wuisvh5O.connect();
			OutputStream AzLswhA5 = wuisvh5O.getOutputStream();
			klmkBEVL = new PrintWriter(AzLswhA5);
			klmkBEVL.println("<?xml version='1.0' encoding='UTF-8'?>");
			klmkBEVL.println(new String(r5VDr5RA.getBytes("UTF-8")));
			klmkBEVL.flush();
			klmkBEVL.close();
			String hfpCWhf6 = null;
			CompositeMap ohMiNiKD = null;
			CompositeLoader GH5C1PoA = new CompositeLoader();
			if (HttpURLConnection.HTTP_OK == wuisvh5O.getResponseCode()) {
				ohMiNiKD = GH5C1PoA.loadFromStream(wuisvh5O.getInputStream());
				hfpCWhf6 = ohMiNiKD.toXML();
				LoggingContext.getLogger(q224nH4e, this.getClass().getCanonicalName())
						.config("correct response:" + hfpCWhf6);
			} else {
				ohMiNiKD = GH5C1PoA.loadFromStream(wuisvh5O.getErrorStream());
				hfpCWhf6 = ohMiNiKD.toXML();
				LoggingContext.getLogger(q224nH4e, this.getClass().getCanonicalName())
						.config("error response:" + hfpCWhf6);
				if (raiseExceptionOnError) {
					throw new ConfigurationFileException(WS_INVOKER_ERROR_CODE, new Object[] { EE9e7grX, hfpCWhf6 },
							this);
				}
			}
			wuisvh5O.disconnect();
			CompositeMap tLK0B8PB = (CompositeMap) ohMiNiKD.getChild(SOAPServiceInterpreter.BODY.getLocalName())
					.getChilds().get(0);
			if (returnPath != null)
				fVFG7Hde.getContext().putObject(returnPath, tLK0B8PB, true);
		} catch (Exception eSlK4rjA) {
			LoggingContext.getLogger(q224nH4e, this.getClass().getCanonicalName()).log(Level.SEVERE, "", eSlK4rjA);
			throw new RuntimeException(eSlK4rjA);
		} finally {
			if (klmkBEVL != null) {
				klmkBEVL.close();
			}
			if (ZvkE6VRc != null) {
				ZvkE6VRc.close();
			}
			if (wuisvh5O != null) {
				wuisvh5O.disconnect();
			}
		}
	}

}