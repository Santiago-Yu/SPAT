class n16625249 {
	@Override
	public void loadTest(StoryCardModel nxNBfo6x) {
		String RsAHIflF = nxNBfo6x.getStoryCard().getAcceptanceTestUrl();
		DocumentBuilderFactory t8nDMKqc = DocumentBuilderFactory.newInstance();
		DocumentBuilder eZwfh5uz;
		try {
			URL jsIqUjid = new URL(RsAHIflF);
			eZwfh5uz = t8nDMKqc.newDocumentBuilder();
			Document sVtF4Var;
			sVtF4Var = eZwfh5uz.parse(jsIqUjid.openStream());
			this.numPass = Integer.parseInt(
					((Element) sVtF4Var.getElementsByTagName("num-pass").item(0)).getFirstChild().getNodeValue());
			this.numFail = Integer.parseInt(
					((Element) sVtF4Var.getElementsByTagName("num-fail").item(0)).getFirstChild().getNodeValue());
			this.numRuns = Integer.parseInt(
					((Element) sVtF4Var.getElementsByTagName("num-runs").item(0)).getFirstChild().getNodeValue());
			this.numExceptions = Integer.parseInt(
					((Element) sVtF4Var.getElementsByTagName("num-exceptions").item(0)).getFirstChild().getNodeValue());
			this.wikiText = ((Element) sVtF4Var.getElementsByTagName("wiki").item(0)).getFirstChild().getNodeValue();
		} catch (Exception cTJihgvY) {
			util.Logger.singleton().error(cTJihgvY);
		}
	}

}