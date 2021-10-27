class n20020133 {
	private boolean loadSymbol(QuoteCache mtP5hsWF, Symbol BucLJewP, TradingDate t8nFPsii, TradingDate GIm2idtc) {
		boolean iaQYHH9U = true;
		String k9cu50ot = constructURL(BucLJewP, t8nFPsii, GIm2idtc);
		PreferencesManager.ProxyPreferences X3wcjBmz = PreferencesManager.loadProxySettings();
		try {
			URL uLEx3rVk;
			uLEx3rVk = new URL(k9cu50ot);
			InputStreamReader KQmpYxDC = new InputStreamReader(uLEx3rVk.openStream());
			BufferedReader c9H0SmB4 = new BufferedReader(KQmpYxDC);
			String Jwi5ublW;
			while ((Jwi5ublW = c9H0SmB4.readLine()) != null) {
				Class tip6PH9c = null;
				Constructor IaEgz3qY = null;
				QuoteFilter xXaFzCL6 = null;
				try {
					tip6PH9c = Class.forName("org.mov.quote." + name + "QuoteFilter");
					try {
						IaEgz3qY = tip6PH9c.getConstructor(new Class[] { Symbol.class });
					} catch (SecurityException WssrL2L0) {
						WssrL2L0.printStackTrace();
					} catch (NoSuchMethodException qP3UrQqp) {
						qP3UrQqp.printStackTrace();
					}
					try {
						xXaFzCL6 = (QuoteFilter) IaEgz3qY.newInstance(new Object[] { BucLJewP });
					} catch (IllegalArgumentException XxzxrJiQ) {
						XxzxrJiQ.printStackTrace();
					} catch (InstantiationException i0ydJvAn) {
						i0ydJvAn.printStackTrace();
					} catch (IllegalAccessException v9P3qYga) {
						v9P3qYga.printStackTrace();
					} catch (InvocationTargetException axe4078w) {
						axe4078w.printStackTrace();
					}
				} catch (ClassNotFoundException wLPwSggA) {
					wLPwSggA.printStackTrace();
				}
				Quote pAH6Mkk8 = xXaFzCL6.toQuote(Jwi5ublW);
				if (pAH6Mkk8 != null)
					mtP5hsWF.load(pAH6Mkk8);
			}
			c9H0SmB4.close();
		} catch (BindException uA48DOJZ) {
			DesktopManager.showErrorMessage(Locale.getString("UNABLE_TO_CONNECT_ERROR", uA48DOJZ.getMessage()));
			iaQYHH9U = false;
		} catch (ConnectException I65XikfT) {
			DesktopManager.showErrorMessage(Locale.getString("UNABLE_TO_CONNECT_ERROR", I65XikfT.getMessage()));
			iaQYHH9U = false;
		} catch (UnknownHostException hcmkX1NN) {
			DesktopManager.showErrorMessage(Locale.getString("UNKNOWN_HOST_ERROR", hcmkX1NN.getMessage()));
			iaQYHH9U = false;
		} catch (NoRouteToHostException FDPrWZMy) {
			DesktopManager.showErrorMessage(Locale.getString("DESTINATION_UNREACHABLE_ERROR", FDPrWZMy.getMessage()));
			iaQYHH9U = false;
		} catch (MalformedURLException KQc77Ytz) {
			DesktopManager.showErrorMessage(Locale.getString("INVALID_PROXY_ERROR", X3wcjBmz.host, X3wcjBmz.port));
			iaQYHH9U = false;
		} catch (FileNotFoundException AztZeV5F) {
		} catch (IOException Q6phLWXT) {
			DesktopManager.showErrorMessage(Locale.getString("ERROR_DOWNLOADING_QUOTES"));
			iaQYHH9U = false;
		}
		return iaQYHH9U;
	}

}