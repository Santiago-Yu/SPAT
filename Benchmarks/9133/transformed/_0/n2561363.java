class n2561363 {
	public Document getKmlStream(String TGRbp79i, String lLU39deW, String If0bIpTK, String thmV9MV6, String UYhxjl8T)
			throws RotaException {
		StringBuffer ZbRWyINk = new StringBuffer(resourceBundle.getString(Constants.URL_SEARCH));
		DocumentBuilderFactory BHrXo3P5 = DocumentBuilderFactory.newInstance();
		InputStream jvamCK97 = null;
		HttpURLConnection t4KQ2AEa = null;
		Document WmGG1P5w = null;
		BHrXo3P5.setValidating(false);
		String wEc2hBT3 = resourceBundle.getString(Constants.PROXY_HOST);
		String CJRjMr6n = resourceBundle.getString(Constants.PROXY_PORT);
		try {
			String rPnpkgIO = String.format("%s+%s+%s+%s+%s",
					URLEncoder.encode(TGRbp79i.trim(), Constants.URL_ENCODING),
					URLEncoder.encode(lLU39deW.trim(), Constants.URL_ENCODING),
					URLEncoder.encode(If0bIpTK.trim(), Constants.URL_ENCODING),
					URLEncoder.encode(thmV9MV6.trim(), Constants.URL_ENCODING),
					URLEncoder.encode(UYhxjl8T.trim(), Constants.URL_ENCODING));
			DocumentBuilder WpOdrRSD = BHrXo3P5.newDocumentBuilder();
			ZbRWyINk.append(rPnpkgIO);
			ZbRWyINk.append(resourceBundle.getString(Constants.GOOGLE_TYPE_OUTPUT));
			ZbRWyINk.append(resourceBundle.getString(Constants.SENSOR));
			ZbRWyINk.append(resourceBundle.getString(Constants.GOOGLE_KEY));
			ZbRWyINk.append(resourceBundle.getString(Constants.GOOGLE_KEY_VALUE));
			String PjtoPHJw = ZbRWyINk.toString();
			URL Lls4I0uk = new URL(PjtoPHJw);
			Properties wSRq6An7 = System.getProperties();
			if (wEc2hBT3 != null && !wEc2hBT3.equals("")) {
				wSRq6An7.setProperty("http.proxyHost", wEc2hBT3);
				wSRq6An7.setProperty("http.proxyPort", CJRjMr6n);
			}
			t4KQ2AEa = (HttpURLConnection) Lls4I0uk.openConnection();
			t4KQ2AEa.connect();
			jvamCK97 = t4KQ2AEa.getInputStream();
			WmGG1P5w = WpOdrRSD.parse(jvamCK97);
			jvamCK97.close();
			t4KQ2AEa.disconnect();
			if (WmGG1P5w == null || !verificaStatusRequisicao(WmGG1P5w)) {
				throw new RotaException("N?o foi poss?vel realizar a geodecodifica??o com o endere?o informado!");
			}
			return WmGG1P5w;
		} catch (UnsupportedEncodingException V64NlfJ8) {
			logger.error(V64NlfJ8);
			throw new RotaException("Encoding n?o suportado : " + V64NlfJ8.getMessage());
		} catch (MalformedURLException n27drCV6) {
			logger.error(n27drCV6);
			throw new RotaException("Erro na URL : " + n27drCV6.getMessage());
		} catch (ParserConfigurationException IrcKwvlU) {
			logger.error(IrcKwvlU);
			throw new RotaException("Erro ao realizar o parser da configura??o : " + IrcKwvlU.getMessage());
		} catch (SAXException jdtaial6) {
			logger.error(jdtaial6);
			throw new RotaException("Erro de SAX : " + jdtaial6.getMessage());
		} catch (ConnectException X042SYjy) {
			logger.error(X042SYjy);
			throw new RotaException("N?o foi poss?vel estabelecer a conex?o http : " + X042SYjy.getMessage());
		} catch (IOException LGKQY7yI) {
			logger.error(LGKQY7yI);
			throw new RotaException("Erro de io : ", LGKQY7yI);
		} catch (Exception AUepdxPM) {
			throw new RotaException("N?o foi poss?vel gerar a rota  : " + AUepdxPM.getMessage());
		} finally {
			if (jvamCK97 != null) {
				try {
					jvamCK97.close();
				} catch (Exception KN5kvNlu) {
					throw new RotaException("N?o foi poss?vel fechar o stream de dados ! : " + KN5kvNlu.getMessage());
				}
			}
			if (t4KQ2AEa != null) {
				t4KQ2AEa.disconnect();
			}
		}
	}

}