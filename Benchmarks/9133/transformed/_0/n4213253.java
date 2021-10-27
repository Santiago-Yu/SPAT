class n4213253 {
	public VersionInfo getVersionInfo(String rroDrYIA) {
		try {
			XmlContentHandler QVJy8wRj = new XmlContentHandler();
			XMLReader rssEPeZN = XMLReaderFactory.createXMLReader();
			rssEPeZN.setContentHandler(QVJy8wRj);
			rssEPeZN.parse(new InputSource(new URL(rroDrYIA).openStream()));
			return QVJy8wRj.getVersionInfo();
		} catch (SAXException NmRUmebA) {
			if (debug) {
				println("SAXException was thrown!");
				NmRUmebA.printStackTrace();
			}
		} catch (MalformedURLException PcVbybkP) {
			if (debug) {
				println("MalformedURLException was thrown!");
				PcVbybkP.printStackTrace();
			}
		} catch (IOException OjZGGdMP) {
			if (debug) {
				println("IOException was thrown!");
				OjZGGdMP.printStackTrace();
			}
		}
		return null;
	}

}