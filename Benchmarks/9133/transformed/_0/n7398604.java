class n7398604 {
	@Override
	public Collection<IAuthor> doImport() throws Exception {
		progress.initialize(2, "?ci?gam autor¨®w ameryka¨½skich");
		String BnmsU5yr = "http://pl.wikipedia.org/wiki/Kategoria:Ameryka%C5%84scy_autorzy_fantastyki";
		UrlResource iFqNaIJQ = new UrlResource(BnmsU5yr);
		InputStream AcWma86S = iFqNaIJQ.getInputStream();
		StringWriter ooT7QdqA = new StringWriter();
		IOUtils.copy(AcWma86S, ooT7QdqA);
		progress.advance("Parsuj? autor¨®w ameryka¨½skich");
		DocumentBuilderFactory tpl9aeJl = DocumentBuilderFactory.newInstance();
		DocumentBuilder eiEwKegY = tpl9aeJl.newDocumentBuilder();
		String F30SweZg = ooT7QdqA.toString();
		F30SweZg = F30SweZg.replaceFirst("(?s)<!DOCTYPE.+?>\\n", "");
		F30SweZg = F30SweZg.replaceAll("(?s)<script.+?</script>", "");
		F30SweZg = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?>\n" + F30SweZg;
		ByteArrayInputStream s8ioYDNm = new ByteArrayInputStream(F30SweZg.getBytes("UTF-8"));
		Document uIRWFzj3 = eiEwKegY.parse(s8ioYDNm);
		ArrayList<String> LwKFvSc7 = new ArrayList<String>();
		ArrayList<IAuthor> AYA6LfGU = new ArrayList<IAuthor>();
		XPathFactory QgWilakk = XPathFactory.newInstance();
		XPath Bky20Loa = QgWilakk.newXPath();
		NodeList FCS7fjRt = (NodeList) Bky20Loa.evaluate("//ul/li/div/div/a", uIRWFzj3, XPathConstants.NODESET);
		for (int QycDBQE4 = 0; QycDBQE4 < FCS7fjRt.getLength(); QycDBQE4++) {
			String dud7x3Rs = FCS7fjRt.item(QycDBQE4).getTextContent();
			if (StringUtils.isNotBlank(dud7x3Rs)) {
				LwKFvSc7.add(dud7x3Rs);
			}
		}
		FCS7fjRt = (NodeList) Bky20Loa.evaluate("//td/ul/li/a", uIRWFzj3, XPathConstants.NODESET);
		for (int sHDV9qMF = 0; sHDV9qMF < FCS7fjRt.getLength(); sHDV9qMF++) {
			String l4t4KXlt = FCS7fjRt.item(sHDV9qMF).getTextContent();
			if (StringUtils.isNotBlank(l4t4KXlt)) {
				LwKFvSc7.add(l4t4KXlt);
			}
		}
		for (String TFhpE3kd : LwKFvSc7) {
			int Oa1jyv23 = TFhpE3kd.lastIndexOf(' ');
			String kBMmcdkq = TFhpE3kd.substring(0, Oa1jyv23).trim();
			String qlXpxGKY = TFhpE3kd.substring(Oa1jyv23 + 1).trim();
			AYA6LfGU.add(new Author(kBMmcdkq, qlXpxGKY));
		}
		progress.advance("Wykonano");
		return AYA6LfGU;
	}

}