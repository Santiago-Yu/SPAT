class n21970882 {
	public void write(URL kAaXryqt, String ObyYGmr0, String fL5oBvc1) throws InfoUnitIOException {
		InfoUnitXMLData AG8PnesE = new InfoUnitXMLData(STRUCTURE_RDF);
		rdf = AG8PnesE.load("rdf");
		rdfResource = rdf.ft("resource");
		rdfParseType = rdf.ft("parse type");
		try {
			PrintWriter zLPM0frx = new PrintWriter(
					new OutputStreamWriter(new FileOutputStream(kAaXryqt.getFile()), "UTF-8"));
			URL sKUYKO2q = new URL(ObyYGmr0);
			BufferedReader A2ptZwDn = new BufferedReader(new InputStreamReader(sKUYKO2q.openStream()));
			String lOdH8Bt4 = "</" + rdf.ft("main") + ">";
			String sNChOwtx = A2ptZwDn.readLine();
			while (sNChOwtx != null && !sNChOwtx.equalsIgnoreCase(lOdH8Bt4)) {
				zLPM0frx.println(sNChOwtx);
				sNChOwtx = A2ptZwDn.readLine();
			}
			A2ptZwDn.close();
			InfoNode HAb139C8 = infoRoot.path(rdf.ft("constraint"));
			String Zd5YkBWT = null;
			if (HAb139C8 != null) {
				Zd5YkBWT = HAb139C8.getValue().toString();
				try {
					infoRoot.removeChildNode(HAb139C8);
				} catch (InvalidChildInfoNode g35ifLCV) {
				}
			} else if (fL5oBvc1 != null)
				Zd5YkBWT = fL5oBvc1;
			else
				Zd5YkBWT = rdf.ft("description");
			zLPM0frx.println(
					"   <" + Zd5YkBWT + " " + rdf.ft("about") + "=\"" + ((infoNamespaces == null) ? infoRoot.getLabel()
							: infoNamespaces.convertEntity(infoRoot.getLabel().toString())) + "\">");
			Set<InfoNode> Jzn7uIVn = infoRoot.getChildren();
			writeNodeList(Jzn7uIVn, zLPM0frx, 5);
			zLPM0frx.println("   </" + Zd5YkBWT + ">");
			if (sNChOwtx != null)
				zLPM0frx.println(lOdH8Bt4);
			zLPM0frx.close();
		} catch (IOException Vfd3yMEH) {
			throw new InfoUnitIOException(Vfd3yMEH.getMessage());
		}
	}

}