class n7252230 {
	private String callBambooApi(URL theURL) throws MonitoringException, BambooTicketNeedToBeRenewedError {
		HttpURLConnection urlConnection = null;
		String returnedValue = null;
		BufferedReader urlConnectionReader = null;
		try {
			urlConnection = (HttpURLConnection) theURL.openConnection();
			urlConnection.connect();
			String line = null;
			urlConnectionReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			StringBuffer serverResponse = new StringBuffer();
			while ((line = urlConnectionReader.readLine()) != null) {
				serverResponse.append(line);
			}
			returnedValue = serverResponse.toString();
			InputSource is = new InputSource(new StringReader(serverResponse.toString()));
			if (returnedValue.contains("<title>Bamboo Setup Wizard - Atlassian Bamboo</title>")) {
				throw new MonitoringException(
						"Your Bamboo server installation is not finished ! Double click here to complete the Bamboo Setup Wizard !",
						getMainPageURI());
			}
			XPath xpath = XPathFactory.newInstance().newXPath();
			String error = xpath.evaluate("/errors/error", is);
			if (!"".equals(error)) {
				if ("User not authenticated yet, or session timed out.".equals(error)) {
					throw new BambooTicketNeedToBeRenewedError();
				} else {
					URI uriForNonOptionsRelatedErrors = getMainPageURI();
					boolean isErrorOptionsRelated = false;
					if ("Invalid username or password.".equals(error)) {
						isErrorOptionsRelated = true;
					}
					if ("The remote API has been disabled.".equals(error)) {
						try {
							synchronized (this.bambooProperties) {
								uriForNonOptionsRelatedErrors = new URI(
										this.bambooProperties.getServerBaseUrl() + "/admin/configure!default.action");
							}
						} catch (URISyntaxException e) {
							throw new RuntimeException(e);
						}
						error += " Double click here to enable it.";
					}
					throw new MonitoringException("Error reported by the Bamboo server: " + error,
							isErrorOptionsRelated, uriForNonOptionsRelatedErrors);
				}
			}
		} catch (ClassCastException e) {
			throw new MonitoringException(
					"Problem: the base URL defined for the Bamboo server in Options is not an http URL.", true, null);
		} catch (UnknownHostException e) {
			throw new MonitoringException("Problem: cannot find host " + theURL.getHost() + " on the network.", true,
					null);
		} catch (ConnectException e) {
			throw new MonitoringException(
					"Problem: cannot connect to port " + theURL.getPort() + " on host " + theURL.getHost() + ".", true,
					null);
		} catch (FileNotFoundException e) {
			throw new MonitoringException(
					"Problem: cannot find the Bamboo server REST api using the base URL defined for the Bamboo server in Options. Seems that this URL is not the one to your Bamboo server home page...",
					true, null);
		} catch (SocketException e) {
			throw new MonitoringException("Problem: network error, connection lost.", null);
		} catch (XPathExpressionException e) {
			throw new MonitoringException(
					"Problem: the Bamboo Server returned an unexpected content for attribute <error>: " + returnedValue,
					null);
		} catch (MonitoringException e) {
			throw e;
		} catch (Throwable t) {
			throw new MonitoringException(t, null);
		} finally {
			if (urlConnectionReader != null) {
				try {
					urlConnectionReader.close();
				} catch (IOException e) {
				}
			}
			if (urlConnection != null) {
				urlConnection.disconnect();
			}
		}
		return returnedValue;
	}

}