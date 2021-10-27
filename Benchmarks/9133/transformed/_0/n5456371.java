class n5456371 {
	public MapInfo loadLocalMapData(String ndjghrGT) {
		MapInfo N7VJVdWx = mapCacheLocal.get(ndjghrGT);
		if (N7VJVdWx != null && N7VJVdWx.getContent() == null) {
			try {
				BufferedReader QFYjJoFY;
				URL aR5itXMT = new URL(localMapContextUrl, ndjghrGT);
				URLConnection LgsAonDv = aR5itXMT.openConnection();
				if (LgsAonDv.getContentEncoding() != null) {
					QFYjJoFY = new BufferedReader(
							new InputStreamReader(LgsAonDv.getInputStream(), LgsAonDv.getContentEncoding()));
				} else {
					QFYjJoFY = new BufferedReader(new InputStreamReader(LgsAonDv.getInputStream(), "utf-8"));
				}
				String OTwUXEIC;
				StringBuilder utdbX1oN = new StringBuilder();
				while ((OTwUXEIC = QFYjJoFY.readLine()) != null) {
					utdbX1oN.append(OTwUXEIC);
					utdbX1oN.append("\n");
				}
				N7VJVdWx.setContent(utdbX1oN.toString());
				GameMapImplementation bF0VtTTq = GameMapImplementation.createFromMapInfo(N7VJVdWx);
			} catch (IOException vYBbDrBJ) {
				System.err.println("HexTD::readFile:: Can't read from " + ndjghrGT);
			}
		} else {
			System.err.println("HexTD::readFile:: file not in cache: " + ndjghrGT);
		}
		return N7VJVdWx;
	}

}