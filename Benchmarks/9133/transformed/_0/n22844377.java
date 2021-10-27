class n22844377 {
	public int scrapeForIsbns(URL gJ0H17Ei) {
		int PrPazu6h = 0;
		Pattern sj63MjFL = Pattern.compile("ISBN-10:</strong>\\s*(\\w{10})");
		Matcher GEFhXIrG;
		for (int gPEQcxdD = 0; gPEQcxdD < RETRIES; gPEQcxdD++) {
			try {
				InputStream BBTVH7iq = gJ0H17Ei.openStream();
				BufferedReader KqzTZmNS = new BufferedReader(new InputStreamReader(BBTVH7iq));
				String FRMs8CQl;
				while ((FRMs8CQl = KqzTZmNS.readLine()) != null) {
					GEFhXIrG = sj63MjFL.matcher(FRMs8CQl);
					while (GEFhXIrG.find()) {
						PrPazu6h++;
						outputIsbns.put(GEFhXIrG.group(1));
						logger.debug("Got ISBN: " + GEFhXIrG.group(1));
					}
				}
				break;
			} catch (ConnectException cEmMAfoj) {
				logger.warn("Connection attempt " + gPEQcxdD + " failed, trying again. Max retries: " + RETRIES);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException AXunNa2a) {
				}
			} catch (IOException YlRpDbZ3) {
				logger.error("Error reading URL stream", YlRpDbZ3);
			} catch (InterruptedException K6kb1DI0) {
				logger.error("Interrupted while calling put(Object E)", K6kb1DI0);
			}
		}
		return PrPazu6h;
	}

}