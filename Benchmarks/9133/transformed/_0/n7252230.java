class n7252230 {
	private String callBambooApi(URL eCrEunJt) throws MonitoringException, BambooTicketNeedToBeRenewedError {
		String we1HCGbw = null;
		HttpURLConnection QrebNCMK = null;
		BufferedReader bSRjXrhc = null;
		try {
			QrebNCMK = (HttpURLConnection) eCrEunJt.openConnection();
			QrebNCMK.connect();
			bSRjXrhc = new BufferedReader(new InputStreamReader(QrebNCMK.getInputStream()));
			String tQhulBya = null;
			StringBuffer ZVNtOU6P = new StringBuffer();
			while ((tQhulBya = bSRjXrhc.readLine()) != null) {
				ZVNtOU6P.append(tQhulBya);
			}
			we1HCGbw = ZVNtOU6P.toString();
			if (we1HCGbw.contains("<title>Bamboo Setup Wizard - Atlassian Bamboo</title>")) {
				throw new MonitoringException(
						"Your Bamboo server installation is not finished ! Double click here to complete the Bamboo Setup Wizard !",
						getMainPageURI());
			}
			InputSource f5w2IhaB = new InputSource(new StringReader(ZVNtOU6P.toString()));
			XPath Lry3cDCH = XPathFactory.newInstance().newXPath();
			String gS9e0qnY = Lry3cDCH.evaluate("/errors/error", f5w2IhaB);
			if (!"".equals(gS9e0qnY)) {
				if ("User not authenticated yet, or session timed out.".equals(gS9e0qnY)) {
					throw new BambooTicketNeedToBeRenewedError();
				} else {
					boolean VzZELmDQ = false;
					URI fkiCVGEL = getMainPageURI();
					if ("Invalid username or password.".equals(gS9e0qnY)) {
						VzZELmDQ = true;
					}
					if ("The remote API has been disabled.".equals(gS9e0qnY)) {
						gS9e0qnY += " Double click here to enable it.";
						try {
							synchronized (this.bambooProperties) {
								fkiCVGEL = new URI(
										this.bambooProperties.getServerBaseUrl() + "/admin/configure!default.action");
							}
						} catch (URISyntaxException HtBebRbj) {
							throw new RuntimeException(HtBebRbj);
						}
					}
					throw new MonitoringException("Error reported by the Bamboo server: " + gS9e0qnY, VzZELmDQ,
							fkiCVGEL);
				}
			}
		} catch (ClassCastException eUsBegvB) {
			throw new MonitoringException(
					"Problem: the base URL defined for the Bamboo server in Options is not an http URL.", true, null);
		} catch (UnknownHostException hbI1Of2r) {
			throw new MonitoringException("Problem: cannot find host " + eCrEunJt.getHost() + " on the network.", true,
					null);
		} catch (ConnectException qMfSdyux) {
			throw new MonitoringException(
					"Problem: cannot connect to port " + eCrEunJt.getPort() + " on host " + eCrEunJt.getHost() + ".",
					true, null);
		} catch (FileNotFoundException tCV8CQtB) {
			throw new MonitoringException(
					"Problem: cannot find the Bamboo server REST api using the base URL defined for the Bamboo server in Options. Seems that this URL is not the one to your Bamboo server home page...",
					true, null);
		} catch (SocketException Nvt1zG4i) {
			throw new MonitoringException("Problem: network error, connection lost.", null);
		} catch (XPathExpressionException QwP4dIoY) {
			throw new MonitoringException(
					"Problem: the Bamboo Server returned an unexpected content for attribute <error>: " + we1HCGbw,
					null);
		} catch (MonitoringException shotjVGR) {
			throw shotjVGR;
		} catch (Throwable DGGnzCAQ) {
			throw new MonitoringException(DGGnzCAQ, null);
		} finally {
			if (bSRjXrhc != null) {
				try {
					bSRjXrhc.close();
				} catch (IOException zIfr0HIl) {
				}
			}
			if (QrebNCMK != null) {
				QrebNCMK.disconnect();
			}
		}
		return we1HCGbw;
	}

}