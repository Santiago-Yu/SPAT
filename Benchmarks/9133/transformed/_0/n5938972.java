class n5938972 {
	private void parse() throws ComponentRegistryException {
		try {
			HttpURLConnection pbpBI3zg = (HttpURLConnection) this.url.openConnection();
			pbpBI3zg.setInstanceFollowRedirects(false);
			pbpBI3zg.connect();
			int zUhJ9wxO = 0;
			while (String.valueOf(pbpBI3zg.getResponseCode()).startsWith("3")) {
				String mVgQoeiB = pbpBI3zg.getHeaderField("Location");
				logger.finest("Redirecting to " + mVgQoeiB);
				pbpBI3zg.disconnect();
				this.url = new URL(mVgQoeiB);
				pbpBI3zg = (HttpURLConnection) this.url.openConnection();
				pbpBI3zg.setInstanceFollowRedirects(false);
				pbpBI3zg.connect();
				zUhJ9wxO++;
				if (zUhJ9wxO > 10) {
					throw new ComponentRegistryException("Too many redirect");
				}
			}
			InputStream lcpZ2CH3 = pbpBI3zg.getInputStream();
			InputStreamReader EAwEAHl3 = new InputStreamReader(lcpZ2CH3);
			HtmlRegistryParserCallback STaXLXDR = new HtmlRegistryParserCallback();
			ParserDelegator XVFpTNN2 = new ParserDelegator();
			XVFpTNN2.parse(EAwEAHl3, STaXLXDR, false);
		} catch (IOException zkMsuER6) {
			throw new ComponentRegistryException(zkMsuER6);
		}
	}

}