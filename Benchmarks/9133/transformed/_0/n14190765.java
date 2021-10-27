class n14190765 {
	private void _PostParser(Document it8iiQfk, AnnotationManager E6vKIagY, Document pfo7aXev, String GycQX5rv) {
		xformer = E6vKIagY.getTransformer();
		builder = E6vKIagY.getBuilder();
		String nVyuyPxs = "";
		if (it8iiQfk == null)
			return;
		NodeList z2XDBQGm = it8iiQfk.getElementsByTagNameNS(annoNS, "body");
		if (z2XDBQGm.getLength() != 1) {
			System.out.println("Sorry Annotation Body was found " + z2XDBQGm.getLength() + " times");
			return;
		}
		Element g9IuOLc7 = (Element) z2XDBQGm.item(0);
		Node MdV9bxv5 = g9IuOLc7.getElementsByTagName("html").item(0);
		if (MdV9bxv5 == null)
			MdV9bxv5 = g9IuOLc7.getElementsByTagName("HTML").item(0);
		Document GbAq1y2v = builder.newDocument();
		Element KR4zKTV4 = GbAq1y2v.createElementNS(rdfNS, "r:RDF");
		KR4zKTV4.setAttribute("xmlns:r", rdfNS);
		KR4zKTV4.setAttribute("xmlns:a", annoNS);
		KR4zKTV4.setAttribute("xmlns:d", dubNS);
		KR4zKTV4.setAttribute("xmlns:t", threadNS);
		GbAq1y2v.appendChild(KR4zKTV4);
		Element RLu8CMRS;
		NodeList qaPLx5sD;
		Element YTccbsFB = GbAq1y2v.createElementNS(annoNS, "a:Annotation");
		KR4zKTV4.appendChild(YTccbsFB);
		RLu8CMRS = (Element) it8iiQfk.getElementsByTagNameNS(annoNS, "context").item(0);
		String ULcIUu04 = RLu8CMRS.getChildNodes().item(0).getNodeValue();
		YTccbsFB.setAttributeNS(annoNS, "a:context", ULcIUu04);
		NodeList gaM0ad3b = RLu8CMRS.getElementsByTagNameNS(alNS, "context-element");
		Node SuYRKKtI = null;
		if (gaM0ad3b.getLength() > 0) {
			Node VKccifhr = gaM0ad3b.item(0);
			SuYRKKtI = GbAq1y2v.importNode(VKccifhr, true);
		}
		qaPLx5sD = it8iiQfk.getElementsByTagNameNS(dubNS, "title");
		YTccbsFB.setAttributeNS(dubNS, "d:title",
				qaPLx5sD.getLength() > 0 ? qaPLx5sD.item(0).getChildNodes().item(0).getNodeValue() : "Default");
		RLu8CMRS = (Element) it8iiQfk.getElementsByTagNameNS(dubNS, "creator").item(0);
		YTccbsFB.setAttributeNS(dubNS, "d:creator", RLu8CMRS.getChildNodes().item(0).getNodeValue());
		RLu8CMRS = (Element) it8iiQfk.getElementsByTagNameNS(annoNS, "created").item(0);
		YTccbsFB.setAttributeNS(annoNS, "a:created", RLu8CMRS.getChildNodes().item(0).getNodeValue());
		RLu8CMRS = (Element) it8iiQfk.getElementsByTagNameNS(dubNS, "date").item(0);
		YTccbsFB.setAttributeNS(dubNS, "d:date", RLu8CMRS.getChildNodes().item(0).getNodeValue());
		qaPLx5sD = it8iiQfk.getElementsByTagNameNS(dubNS, "language");
		String SpvNiEgI = (qaPLx5sD.getLength() > 0 ? qaPLx5sD.item(0).getChildNodes().item(0).getNodeValue() : "en");
		YTccbsFB.setAttributeNS(dubNS, "d:language", SpvNiEgI);
		Node AbQF6vJf = GbAq1y2v.importNode(it8iiQfk.getElementsByTagNameNS(rdfNS, "type").item(0), true);
		YTccbsFB.appendChild(AbQF6vJf);
		Element BbKwoJzt = GbAq1y2v.createElementNS(annoNS, "a:context");
		BbKwoJzt.setAttributeNS(rdfNS, "r:resource", ULcIUu04);
		YTccbsFB.appendChild(BbKwoJzt);
		Node fZVLcQk4 = GbAq1y2v.importNode(it8iiQfk.getElementsByTagNameNS(annoNS, "annotates").item(0), true);
		YTccbsFB.appendChild(fZVLcQk4);
		Element H1ImgLnG = GbAq1y2v.createElementNS(annoNS, "a:body");
		YTccbsFB.appendChild(H1ImgLnG);
		if (SuYRKKtI != null) {
			BbKwoJzt.appendChild(SuYRKKtI);
		} else {
			System.out.println("No context element found, we create one...");
			try {
				XPointer sq9wMoMz = new XPointer(pfo7aXev);
				NodeRange flhoV4sA = sq9wMoMz.getRange(ULcIUu04, pfo7aXev);
				Element UFcNF5yl = GbAq1y2v.createElementNS(alNS, "al:context-element");
				UFcNF5yl.setAttributeNS(alNS, "al:text", flhoV4sA.getContentString());
				UFcNF5yl.appendChild(GbAq1y2v.createTextNode(E6vKIagY.generateContextString(flhoV4sA)));
				BbKwoJzt.appendChild(UFcNF5yl);
			} catch (XPointerRangeException SnGHr1EB) {
				SnGHr1EB.printStackTrace();
			}
		}
		WordFreq rER9xQXL = new WordFreq(E6vKIagY.extractTextFromNode(pfo7aXev));
		Element NW4wugGz = GbAq1y2v.createElementNS(alNS, "al:document-identifier");
		fZVLcQk4.appendChild(NW4wugGz);
		NW4wugGz.setAttributeNS(alNS, "al:orig-url", ((Element) fZVLcQk4).getAttributeNS(rdfNS, "resource"));
		NW4wugGz.setAttributeNS(alNS, "al:version", "1");
		Iterator E5097WFB = null;
		E5097WFB = rER9xQXL.getSortedWordlist();
		Map.Entry iND73Ftt;
		String n8fA1Nhp;
		int Os5SNtCG;
		int ZZnQfzGP = 0;
		while (E5097WFB.hasNext()) {
			iND73Ftt = (Map.Entry) E5097WFB.next();
			n8fA1Nhp = ((String) iND73Ftt.getKey());
			Os5SNtCG = ((Counter) iND73Ftt.getValue()).count;
			if ((n8fA1Nhp.length() > 4) && (ZZnQfzGP < 10)) {
				Element Ugfk08eo = GbAq1y2v.createElementNS(alNS, "al:word");
				Ugfk08eo.setAttributeNS(alNS, "al:freq", Integer.toString(Os5SNtCG));
				Ugfk08eo.appendChild(GbAq1y2v.createTextNode(n8fA1Nhp));
				NW4wugGz.appendChild(Ugfk08eo);
				ZZnQfzGP++;
			}
		}
		try {
			StringWriter C1ILJWDT = new StringWriter();
			MessageDigest adB114ii = MessageDigest.getInstance("MD5");
			xformer.transform(new DOMSource(GbAq1y2v), new StreamResult(C1ILJWDT));
			adB114ii.update(C1ILJWDT.toString().getBytes());
			byte[] RwcD1iIx = adB114ii.digest();
			nVyuyPxs = "";
			for (int bEOwOjbw = 0; bEOwOjbw < RwcD1iIx.length; bEOwOjbw++) {
				String sYitAwDc = Integer.toHexString(RwcD1iIx[bEOwOjbw] & 0xFF);
				nVyuyPxs = nVyuyPxs + ((sYitAwDc.length() == 1) ? "0" + sYitAwDc : sYitAwDc);
			}
			this.annohash = nVyuyPxs;
			YTccbsFB.setAttribute("xmlns:al", alNS);
			YTccbsFB.setAttributeNS(alNS, "al:id", getAnnohash());
			Location = (GycQX5rv + "/annotation/" + getAnnohash());
			YTccbsFB.setAttributeNS(rdfNS, "r:about", Location);
			H1ImgLnG.setAttributeNS(rdfNS, "r:resource", GycQX5rv + "/annotation/body/" + getAnnohash());
		} catch (NoSuchAlgorithmException aPcINKFT) {
			aPcINKFT.printStackTrace();
		} catch (TransformerException Kr5dRh3q) {
			Kr5dRh3q.printStackTrace();
		}
		E6vKIagY.store(GbAq1y2v.getDocumentElement());
		E6vKIagY.createAnnoResource(GbAq1y2v.getDocumentElement(), getAnnohash());
		if (MdV9bxv5 != null)
			E6vKIagY.createAnnoBody(MdV9bxv5, getAnnohash());
		Location = (this.baseurl + "/annotation/" + getAnnohash());
		YTccbsFB.setAttributeNS(rdfNS, "r:about", Location);
		this.responseDoc = GbAq1y2v;
	}

}