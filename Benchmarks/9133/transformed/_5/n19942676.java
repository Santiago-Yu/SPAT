class n19942676 {
	private void harvest() throws IOException, XMLStreamException {
		String api_url = "http://search.twitter.com/search.atom?q=+%23" + hashtag + "+to%3A" + account;
		System.err.println(api_url);
		URL url = new URL(api_url);
		URLConnection con = url.openConnection();
		String basic = this.login + ":" + new String(this.password);
		con.setRequestProperty("Authorization", "Basic " + Base64.encode(basic));
		XMLInputFactory factory = XMLInputFactory.newInstance();
		factory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, true);
		factory.setProperty(XMLInputFactory.IS_VALIDATING, false);
		factory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
		XMLEventReader reader = factory.createXMLEventReader(con.getInputStream());
		boolean inEntry = false;
		boolean inAuthor = false;
		String published = null;
		String title = null;
		String foafName = null;
		String foafURI = null;
		String link = null;
		while (reader.hasNext()) {
			XMLEvent evt = reader.nextEvent();
			if (evt.isStartElement()) {
				StartElement e = evt.asStartElement();
				QName qName = e.getName();
				if (!inEntry && Atom.NS.equals(qName.getNamespaceURI()) && qName.getLocalPart().equals("entry")) {
					inEntry = true;
				} else if (inEntry) {
					String local = qName.getLocalPart();
					if (local.equals("published")) {
						published = reader.getElementText();
					} else if (local.equals("title")) {
						title = reader.getElementText();
					} else if (link == null && local.equals("link")) {
						Attribute att = e.getAttributeByName(new QName("type"));
						if (att != null && att.getValue().equals("text/html")) {
							att = e.getAttributeByName(new QName("href"));
							if (att != null) {
								link = att.getValue();
							}
						}
					} else if (local.equals("author")) {
						inAuthor = true;
					} else if (inAuthor && local.equals("name")) {
						foafName = reader.getElementText();
					} else if (inAuthor && local.equals("uri")) {
						foafURI = reader.getElementText();
					}
				}
			} else if (evt.isEndElement()) {
				EndElement e = evt.asEndElement();
				QName qName = e.getName();
				if (inEntry && Atom.NS.equals(qName.getNamespaceURI())) {
					String local = qName.getLocalPart();
					if (local.equals("entry")) {
						Protein p1 = null;
						Protein p2 = null;
						PubmedEntry pubmed = null;
						boolean valid = title != null && published != null;
						String tokens[];
						if (title == null)
							tokens = new String[0];
						else
							tokens = title.trim().split("[ \t\n\r]+");
						if (valid && tokens.length != 5) {
							System.err.println("Ignoring " + title);
							valid = false;
						}
						if (valid && !tokens[0].equals("@" + account)) {
							System.err.println("Ignoring " + title + " doesn't start with @" + account);
							valid = false;
						}
						if (valid && !(tokens[1].startsWith("gi:") && Cast.Integer.isA(tokens[1].substring(3)))) {
							System.err.println("Ignoring " + title + " not a gi:###");
							valid = false;
						}
						if (valid && (p1 = fetchProtein(Integer.parseInt(tokens[1].substring(3)))) == null) {
							valid = false;
						}
						if (valid && !(tokens[2].startsWith("gi:") && Cast.Integer.isA(tokens[2].substring(3)))) {
							System.err.println("Ignoring " + title + " not a gi:###");
							valid = false;
						}
						if (valid && (p2 = fetchProtein(Integer.parseInt(tokens[2].substring(3)))) == null) {
							valid = false;
						}
						if (valid && !(tokens[3].startsWith("pmid:") && Cast.Integer.isA(tokens[3].substring(5)))) {
							System.err.println("Ignoring " + title + " not a pmid:###");
							valid = false;
						}
						if (valid && (pubmed = fetchPubmedEntry(Integer.parseInt(tokens[3].substring(5)))) == null) {
							valid = false;
						}
						if (valid && !tokens[4].equals("#" + hashtag)) {
							System.err.println("Ignoring " + title + " doesn't end with #" + hashtag);
							valid = false;
						}
						if (valid && p1 != null && p2 != null && pubmed != null && foafName != null
								&& foafURI != null) {
							exportFoaf(foafName, foafURI);
							exportGi(p1);
							exportGi(p2);
							exportPubmed(pubmed);
							System.out.println("<Interaction rdf:about=\"" + link + "\">");
							System.out.println(
									" <interactor rdf:resource=\"lsid:ncbi.nlm.nih.gov:protein:" + p1.gi + "\"/>");
							System.out.println(
									" <interactor rdf:resource=\"lsid:ncbi.nlm.nih.gov:protein:" + p2.gi + "\"/>");
							System.out.println(" <reference rdf:resource=\"http://www.ncbi.nlm.nih.gov/pubmed/"
									+ pubmed.pmid + "\"/>");
							System.out.println(" <dc:creator rdf:resource=\"" + foafURI + "\"/>");
							System.out.println(" <dc:date>" + escape(published) + "</dc:date>");
							System.out.println("</Interaction>");
						}
						inEntry = false;
						title = null;
						foafName = null;
						foafURI = null;
						inAuthor = false;
						published = null;
						link = null;
					} else if (inAuthor && local.equals("author")) {
						inAuthor = false;
					}
				}
			}
		}
		reader.close();
	}

}