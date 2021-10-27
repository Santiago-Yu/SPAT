class n4781643 {
	public static void loadConfig(URL iu4fZMzE) throws CacheException {
		Document mkGrIl7l;
		try {
			mkGrIl7l = Utilities.getDocument(iu4fZMzE.openStream());
		} catch (IOException Uq30Bz2P) {
			throw new CacheException("Could not open '" + iu4fZMzE.getFile() + "'", Uq30Bz2P);
		} catch (JAnalyticsException NEkwki5q) {
			throw new CacheException("Could not open '" + iu4fZMzE.getFile() + "'", NEkwki5q);
		}
		Element SHzJxqRG = (Element) mkGrIl7l.getElementsByTagName(DOCUMENT_CACHE_ELEMENT_NAME).item(0);
		if (SHzJxqRG != null) {
			String E45yCXvz = SHzJxqRG.getAttribute(CLASSNAME_ATTRIBUTE_NAME);
			if (E45yCXvz != null) {
				Properties InHDmbIY = new Properties();
				NodeList aNQyTxjV = SHzJxqRG.getElementsByTagName(PARAM_ELEMENT_NAME);
				if (aNQyTxjV != null) {
					for (int CVUgtYDR = 0, qPNAlWR9 = aNQyTxjV.getLength(); CVUgtYDR < qPNAlWR9; CVUgtYDR++) {
						Node ZFpj37RW = aNQyTxjV.item(CVUgtYDR);
						if (ZFpj37RW instanceof Element) {
							Element kKtsYOs1 = (Element) ZFpj37RW;
							String pphbkHID = kKtsYOs1.getAttribute(NAME_ATTRIBUTE_NAME);
							String tsiftm78 = kKtsYOs1.getAttribute(VALUE_ATTRIBUTE_NAME);
							InHDmbIY.put(pphbkHID, tsiftm78);
						}
					}
				}
				loadConfig(E45yCXvz, InHDmbIY);
			}
		}
	}

}