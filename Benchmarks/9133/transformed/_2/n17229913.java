class n17229913 {
	private void process(int optind, String args[]) throws IOException, XMLStreamException {
		final int srlimit = 500;
		final QName att_title = new QName("title");
		final QName att_sroffset = new QName("sroffset");
		String sroffset = null;
		String srnamespace = null;
		if (!this.srnamespaces.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			for (Integer i : this.srnamespaces) {
				if (sb.length() > 0)
					sb.append("|");
				sb.append(String.valueOf(i));
			}
			srnamespace = sb.toString();
		}
		StringBuilder terms = new StringBuilder();
		for (; optind < args.length;) {
			if (terms.length() > 0)
				terms.append(" ");
			terms.append(args[optind++]);
		}
		for (; true;) {
			String url = this.base_api + "?action=query" + "&list=search" + "&format=xml" + "&srsearch="
					+ URLEncoder.encode(terms.toString(), "UTF-8")
					+ (srnamespace != null ? "&srnamespace=" + srnamespace : "")
					+ (sroffset == null ? "" : "&sroffset=" + sroffset) + "&srlimit=" + srlimit
					+ "&srwhat=text&srprop=timestamp";
			sroffset = null;
			LOG.info(url);
			XMLEventReader reader = this.xmlInputFactory.createXMLEventReader(openStream(url));
			while (reader.hasNext()) {
				XMLEvent event = reader.nextEvent();
				if (event.isStartElement()) {
					StartElement e = event.asStartElement();
					String name = e.getName().getLocalPart();
					Attribute att = null;
					if (name.equals("p") && (att = e.getAttributeByName(att_title)) != null) {
						System.out.println(att.getValue());
					} else if (name.equals("search") && (att = e.getAttributeByName(att_sroffset)) != null) {
						sroffset = att.getValue();
					}
				}
			}
			reader.close();
			if (sroffset == null)
				break;
		}
	}

}