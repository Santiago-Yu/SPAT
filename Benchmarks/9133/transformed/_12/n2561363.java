class n2561363 {
	public Document getKmlStream(String streetname, String number, String neighbourhood, String city, String state)
			throws RotaException {
		StringBuffer urlsb = new StringBuffer(resourceBundle.getString(Constants.URL_SEARCH));
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		InputStream in = null;
		HttpURLConnection httpConnection = null;
		Document doc = null;
		dbf.setValidating(false);
		String proxy = resourceBundle.getString(Constants.PROXY_HOST),
				port = resourceBundle.getString(Constants.PROXY_PORT);
		try {
			String address = String.format("%s+%s+%s+%s+%s",
					URLEncoder.encode(streetname.trim(), Constants.URL_ENCODING),
					URLEncoder.encode(number.trim(), Constants.URL_ENCODING),
					URLEncoder.encode(neighbourhood.trim(), Constants.URL_ENCODING),
					URLEncoder.encode(city.trim(), Constants.URL_ENCODING),
					URLEncoder.encode(state.trim(), Constants.URL_ENCODING));
			DocumentBuilder df = dbf.newDocumentBuilder();
			urlsb.append(address);
			urlsb.append(resourceBundle.getString(Constants.GOOGLE_TYPE_OUTPUT));
			urlsb.append(resourceBundle.getString(Constants.SENSOR));
			urlsb.append(resourceBundle.getString(Constants.GOOGLE_KEY));
			urlsb.append(resourceBundle.getString(Constants.GOOGLE_KEY_VALUE));
			String addressUTF8 = urlsb.toString();
			URL url = new URL(addressUTF8);
			Properties systemproperties = System.getProperties();
			if (proxy != null && !proxy.equals("")) {
				systemproperties.setProperty("http.proxyHost", proxy);
				systemproperties.setProperty("http.proxyPort", port);
			}
			httpConnection = (HttpURLConnection) url.openConnection();
			httpConnection.connect();
			in = httpConnection.getInputStream();
			doc = df.parse(in);
			in.close();
			httpConnection.disconnect();
			if (doc == null || !verificaStatusRequisicao(doc)) {
				throw new RotaException("N?o foi poss?vel realizar a geodecodifica??o com o endere?o informado!");
			}
			return doc;
		} catch (UnsupportedEncodingException ue) {
			logger.error(ue);
			throw new RotaException("Encoding n?o suportado : " + ue.getMessage());
		} catch (MalformedURLException ma) {
			logger.error(ma);
			throw new RotaException("Erro na URL : " + ma.getMessage());
		} catch (ParserConfigurationException pe) {
			logger.error(pe);
			throw new RotaException("Erro ao realizar o parser da configura??o : " + pe.getMessage());
		} catch (SAXException sa) {
			logger.error(sa);
			throw new RotaException("Erro de SAX : " + sa.getMessage());
		} catch (ConnectException co) {
			logger.error(co);
			throw new RotaException("N?o foi poss?vel estabelecer a conex?o http : " + co.getMessage());
		} catch (IOException io) {
			logger.error(io);
			throw new RotaException("Erro de io : ", io);
		} catch (Exception ex) {
			throw new RotaException("N?o foi poss?vel gerar a rota  : " + ex.getMessage());
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception ex) {
					throw new RotaException("N?o foi poss?vel fechar o stream de dados ! : " + ex.getMessage());
				}
			}
			if (httpConnection != null) {
				httpConnection.disconnect();
			}
		}
	}

}