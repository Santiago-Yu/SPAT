class n19942676 {
	private void harvest() throws IOException, XMLStreamException {
		String MhbttQjg = "http://search.twitter.com/search.atom?q=+%23" + hashtag + "+to%3A" + account;
		System.err.println(MhbttQjg);
		URL tE7Qcitg = new URL(MhbttQjg);
		URLConnection bWJLHNEM = tE7Qcitg.openConnection();
		String gWZ7tyBw = this.login + ":" + new String(this.password);
		bWJLHNEM.setRequestProperty("Authorization", "Basic " + Base64.encode(gWZ7tyBw));
		XMLInputFactory Tudavwcs = XMLInputFactory.newInstance();
		Tudavwcs.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, true);
		Tudavwcs.setProperty(XMLInputFactory.IS_VALIDATING, false);
		Tudavwcs.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
		XMLEventReader SUZhJ3Th = Tudavwcs.createXMLEventReader(bWJLHNEM.getInputStream());
		boolean myWPoMQg = false;
		boolean GlJO5FX4 = false;
		String UuI8UjUl = null;
		String KcGcXyEQ = null;
		String mDyx0ppw = null;
		String on0WPsCG = null;
		String BtpIfjPj = null;
		while (SUZhJ3Th.hasNext()) {
			XMLEvent BbUopnlZ = SUZhJ3Th.nextEvent();
			if (BbUopnlZ.isStartElement()) {
				StartElement Xd966fxd = BbUopnlZ.asStartElement();
				QName OW85dbdi = Xd966fxd.getName();
				if (!myWPoMQg && Atom.NS.equals(OW85dbdi.getNamespaceURI())
						&& OW85dbdi.getLocalPart().equals("entry")) {
					myWPoMQg = true;
				} else if (myWPoMQg) {
					String IKnIxRyY = OW85dbdi.getLocalPart();
					if (IKnIxRyY.equals("published")) {
						UuI8UjUl = SUZhJ3Th.getElementText();
					} else if (IKnIxRyY.equals("title")) {
						KcGcXyEQ = SUZhJ3Th.getElementText();
					} else if (BtpIfjPj == null && IKnIxRyY.equals("link")) {
						Attribute XxNxZWSY = Xd966fxd.getAttributeByName(new QName("type"));
						if (XxNxZWSY != null && XxNxZWSY.getValue().equals("text/html")) {
							XxNxZWSY = Xd966fxd.getAttributeByName(new QName("href"));
							if (XxNxZWSY != null) {
								BtpIfjPj = XxNxZWSY.getValue();
							}
						}
					} else if (IKnIxRyY.equals("author")) {
						GlJO5FX4 = true;
					} else if (GlJO5FX4 && IKnIxRyY.equals("name")) {
						mDyx0ppw = SUZhJ3Th.getElementText();
					} else if (GlJO5FX4 && IKnIxRyY.equals("uri")) {
						on0WPsCG = SUZhJ3Th.getElementText();
					}
				}
			} else if (BbUopnlZ.isEndElement()) {
				EndElement hIVhZ16h = BbUopnlZ.asEndElement();
				QName W5BL8IhO = hIVhZ16h.getName();
				if (myWPoMQg && Atom.NS.equals(W5BL8IhO.getNamespaceURI())) {
					String pn5dn3sX = W5BL8IhO.getLocalPart();
					if (pn5dn3sX.equals("entry")) {
						Protein tV4xmqcz = null;
						Protein pUaXhULz = null;
						PubmedEntry zOE79D5x = null;
						boolean W4v3Rbfz = KcGcXyEQ != null && UuI8UjUl != null;
						String jASIW8Dc[] = KcGcXyEQ == null ? new String[0] : KcGcXyEQ.trim().split("[ \t\n\r]+");
						if (W4v3Rbfz && jASIW8Dc.length != 5) {
							System.err.println("Ignoring " + KcGcXyEQ);
							W4v3Rbfz = false;
						}
						if (W4v3Rbfz && !jASIW8Dc[0].equals("@" + account)) {
							System.err.println("Ignoring " + KcGcXyEQ + " doesn't start with @" + account);
							W4v3Rbfz = false;
						}
						if (W4v3Rbfz
								&& !(jASIW8Dc[1].startsWith("gi:") && Cast.Integer.isA(jASIW8Dc[1].substring(3)))) {
							System.err.println("Ignoring " + KcGcXyEQ + " not a gi:###");
							W4v3Rbfz = false;
						}
						if (W4v3Rbfz && (tV4xmqcz = fetchProtein(Integer.parseInt(jASIW8Dc[1].substring(3)))) == null) {
							W4v3Rbfz = false;
						}
						if (W4v3Rbfz
								&& !(jASIW8Dc[2].startsWith("gi:") && Cast.Integer.isA(jASIW8Dc[2].substring(3)))) {
							System.err.println("Ignoring " + KcGcXyEQ + " not a gi:###");
							W4v3Rbfz = false;
						}
						if (W4v3Rbfz && (pUaXhULz = fetchProtein(Integer.parseInt(jASIW8Dc[2].substring(3)))) == null) {
							W4v3Rbfz = false;
						}
						if (W4v3Rbfz
								&& !(jASIW8Dc[3].startsWith("pmid:") && Cast.Integer.isA(jASIW8Dc[3].substring(5)))) {
							System.err.println("Ignoring " + KcGcXyEQ + " not a pmid:###");
							W4v3Rbfz = false;
						}
						if (W4v3Rbfz
								&& (zOE79D5x = fetchPubmedEntry(Integer.parseInt(jASIW8Dc[3].substring(5)))) == null) {
							W4v3Rbfz = false;
						}
						if (W4v3Rbfz && !jASIW8Dc[4].equals("#" + hashtag)) {
							System.err.println("Ignoring " + KcGcXyEQ + " doesn't end with #" + hashtag);
							W4v3Rbfz = false;
						}
						if (W4v3Rbfz && tV4xmqcz != null && pUaXhULz != null && zOE79D5x != null && mDyx0ppw != null
								&& on0WPsCG != null) {
							exportFoaf(mDyx0ppw, on0WPsCG);
							exportGi(tV4xmqcz);
							exportGi(pUaXhULz);
							exportPubmed(zOE79D5x);
							System.out.println("<Interaction rdf:about=\"" + BtpIfjPj + "\">");
							System.out.println(" <interactor rdf:resource=\"lsid:ncbi.nlm.nih.gov:protein:"
									+ tV4xmqcz.gi + "\"/>");
							System.out.println(" <interactor rdf:resource=\"lsid:ncbi.nlm.nih.gov:protein:"
									+ pUaXhULz.gi + "\"/>");
							System.out.println(" <reference rdf:resource=\"http://www.ncbi.nlm.nih.gov/pubmed/"
									+ zOE79D5x.pmid + "\"/>");
							System.out.println(" <dc:creator rdf:resource=\"" + on0WPsCG + "\"/>");
							System.out.println(" <dc:date>" + escape(UuI8UjUl) + "</dc:date>");
							System.out.println("</Interaction>");
						}
						myWPoMQg = false;
						KcGcXyEQ = null;
						mDyx0ppw = null;
						on0WPsCG = null;
						GlJO5FX4 = false;
						UuI8UjUl = null;
						BtpIfjPj = null;
					} else if (GlJO5FX4 && pn5dn3sX.equals("author")) {
						GlJO5FX4 = false;
					}
				}
			}
		}
		SUZhJ3Th.close();
	}

}