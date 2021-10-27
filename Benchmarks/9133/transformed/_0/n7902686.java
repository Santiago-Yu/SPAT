class n7902686 {
	public MapInfo loadLocalMapData(String SWnbpTf2) {
		MapInfo ERNAA8F4 = mapCacheLocal.get(SWnbpTf2);
		if (ERNAA8F4 != null && ERNAA8F4.getContent() == null) {
			try {
				BufferedReader v0ZUaIUW;
				URL ZtKX062D = new URL(localMapContextUrl, SWnbpTf2);
				URLConnection ej0D1Jg5 = ZtKX062D.openConnection();
				if (ej0D1Jg5.getContentEncoding() != null) {
					v0ZUaIUW = new BufferedReader(
							new InputStreamReader(ej0D1Jg5.getInputStream(), ej0D1Jg5.getContentEncoding()));
				} else {
					v0ZUaIUW = new BufferedReader(new InputStreamReader(ej0D1Jg5.getInputStream(), "utf-8"));
				}
				String L1cRkhx7;
				StringBuilder yJbwmQRQ = new StringBuilder();
				while ((L1cRkhx7 = v0ZUaIUW.readLine()) != null) {
					yJbwmQRQ.append(L1cRkhx7);
					yJbwmQRQ.append("\n");
				}
				ERNAA8F4.setContent(yJbwmQRQ.toString());
				GameMapImplementation Vu71gMeq = GameMapImplementation.createFromMapInfo(ERNAA8F4);
			} catch (IOException z6E0h1pE) {
				System.err.println("HexTD::readFile:: Can't read from " + SWnbpTf2);
			}
		}
		return ERNAA8F4;
	}

}