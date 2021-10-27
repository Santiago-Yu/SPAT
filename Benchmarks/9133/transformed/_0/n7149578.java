class n7149578 {
	@Override
	protected void parseContent(StreamLimiter wGOVlGFy, LanguageEnum lBtdPi3U) throws IOException {
		String n9QUy4zw = null;
		IndexDocument eDNS8ycu = getSourceDocument();
		if (eDNS8ycu != null && urlItemFieldEnum != null) {
			FieldValueItem VXuWWs37 = eDNS8ycu.getFieldValue(urlItemFieldEnum.contentTypeCharset.getName(), 0);
			if (VXuWWs37 != null)
				n9QUy4zw = VXuWWs37.getValue();
			if (n9QUy4zw == null) {
				VXuWWs37 = eDNS8ycu.getFieldValue(urlItemFieldEnum.contentEncoding.getName(), 0);
				if (VXuWWs37 != null)
					n9QUy4zw = VXuWWs37.getValue();
			}
		}
		boolean wKjkZBBO = n9QUy4zw == null;
		if (wKjkZBBO)
			n9QUy4zw = getProperty(ClassPropertyEnum.DEFAULT_CHARSET).getValue();
		StringWriter wEWO0gq0 = new StringWriter();
		IOUtils.copy(wGOVlGFy.getNewInputStream(), wEWO0gq0, n9QUy4zw);
		addField(ParserFieldEnum.htmlSource, wEWO0gq0.toString());
		wEWO0gq0.close();
		HtmlDocumentProvider ClRYC696 = findBestProvider(n9QUy4zw, wGOVlGFy);
		if (ClRYC696 == null)
			return;
		addField(ParserFieldEnum.htmlProvider, ClRYC696.getName());
		String zE2gMKRP = ClRYC696.getMetaHttpEquiv("content-type");
		String N1ClYBQQ = null;
		if (zE2gMKRP != null) {
			N1ClYBQQ = MimeUtils.extractContentTypeCharset(zE2gMKRP);
			if (N1ClYBQQ != null && !N1ClYBQQ.equals(n9QUy4zw))
				wKjkZBBO = true;
		}
		if (wKjkZBBO) {
			if (N1ClYBQQ != null)
				n9QUy4zw = N1ClYBQQ;
			else
				n9QUy4zw = ClRYC696.getMetaCharset();
			if (n9QUy4zw != null)
				ClRYC696 = findBestProvider(n9QUy4zw, wGOVlGFy);
		}
		HtmlNodeAbstract<?> WHWwukeV = ClRYC696.getRootNode();
		if (WHWwukeV == null)
			return;
		for (HtmlNodeAbstract<?> VDIbbyaf : ClRYC696.getMetas()) {
			String qVTFtPTd = VDIbbyaf.getAttributeText("name");
			if (qVTFtPTd != null && qVTFtPTd.startsWith(OPENSEARCHSERVER_FIELD)) {
				String OcgoGVRi = qVTFtPTd.substring(OPENSEARCHSERVER_FIELD_LENGTH);
				String[] FcyQuPPU = OcgoGVRi.split("\\.");
				if (FcyQuPPU != null) {
					String DjccnMXA = VDIbbyaf.getAttributeText("content");
					addDirectFields(FcyQuPPU, DjccnMXA);
				}
			}
		}
		addField(ParserFieldEnum.charset, n9QUy4zw);
		addFieldTitle(ClRYC696.getTitle());
		String R13uvT81 = null;
		String AEJG0ic4 = null;
		String ZKEs7D5l = null;
		for (HtmlNodeAbstract<?> MCTXPyxS : ClRYC696.getMetas()) {
			String EGvZ6M08 = MCTXPyxS.getAttributeText("name");
			String zXiDgjEa = MCTXPyxS.getAttributeText("http-equiv");
			if ("keywords".equalsIgnoreCase(EGvZ6M08))
				addField(ParserFieldEnum.meta_keywords, HtmlDocumentProvider.getMetaContent(MCTXPyxS));
			else if ("description".equalsIgnoreCase(EGvZ6M08))
				addField(ParserFieldEnum.meta_description, HtmlDocumentProvider.getMetaContent(MCTXPyxS));
			else if ("robots".equalsIgnoreCase(EGvZ6M08))
				R13uvT81 = HtmlDocumentProvider.getMetaContent(MCTXPyxS);
			else if ("dc.language".equalsIgnoreCase(EGvZ6M08))
				AEJG0ic4 = HtmlDocumentProvider.getMetaContent(MCTXPyxS);
			else if ("content-language".equalsIgnoreCase(zXiDgjEa))
				ZKEs7D5l = HtmlDocumentProvider.getMetaContent(MCTXPyxS);
		}
		boolean jdPCLU1N = true;
		boolean sCAZO0Qa = false;
		if (R13uvT81 != null) {
			R13uvT81 = R13uvT81.toLowerCase();
			if (R13uvT81.contains("noindex")) {
				sCAZO0Qa = true;
				addField(ParserFieldEnum.meta_robots, "noindex");
			}
			if (R13uvT81.contains("nofollow")) {
				jdPCLU1N = false;
				addField(ParserFieldEnum.meta_robots, "nofollow");
			}
		}
		UrlFilterItem[] YtQdnuQE = getUrlFilterList();
		List<HtmlNodeAbstract<?>> EuGC522w = WHWwukeV.getAllNodes("a", "frame");
		IndexDocument wK7c0yBA = getSourceDocument();
		if (wK7c0yBA != null && EuGC522w != null && jdPCLU1N) {
			URL go6JEr7H = ClRYC696.getBaseHref();
			if (go6JEr7H == null && urlItemFieldEnum != null) {
				FieldValueItem oi0au0tG = wK7c0yBA.getFieldValue(urlItemFieldEnum.url.getName(), 0);
				if (oi0au0tG != null)
					go6JEr7H = new URL(oi0au0tG.getValue());
			}
			for (HtmlNodeAbstract<?> qiNKI13Z : EuGC522w) {
				String BSv3FCML = null;
				String pZif8Jag = null;
				String dKuAHyvC = qiNKI13Z.getNodeName();
				if ("a".equals(dKuAHyvC)) {
					BSv3FCML = qiNKI13Z.getAttributeText("href");
					pZif8Jag = qiNKI13Z.getAttributeText("rel");
				} else if ("frame".equals(dKuAHyvC)) {
					BSv3FCML = qiNKI13Z.getAttributeText("src");
				}
				boolean d8g5A2Uy = true;
				if (pZif8Jag != null)
					if (pZif8Jag.contains("nofollow"))
						d8g5A2Uy = false;
				URL WN5f6Qn1 = null;
				if (BSv3FCML != null)
					if (!BSv3FCML.startsWith("javascript:"))
						if (go6JEr7H != null)
							WN5f6Qn1 = LinkUtils.getLink(go6JEr7H, BSv3FCML, YtQdnuQE);
				if (WN5f6Qn1 != null) {
					ParserFieldEnum hm2dgAQA = null;
					if (WN5f6Qn1.getHost().equalsIgnoreCase(go6JEr7H.getHost())) {
						if (d8g5A2Uy)
							hm2dgAQA = ParserFieldEnum.internal_link;
						else
							hm2dgAQA = ParserFieldEnum.internal_link_nofollow;
					} else {
						if (d8g5A2Uy)
							hm2dgAQA = ParserFieldEnum.external_link;
						else
							hm2dgAQA = ParserFieldEnum.external_link_nofollow;
					}
					addField(hm2dgAQA, WN5f6Qn1.toExternalForm());
				}
			}
		}
		if (!sCAZO0Qa) {
			EuGC522w = WHWwukeV.getNodes("html", "body");
			if (EuGC522w == null || EuGC522w.size() == 0)
				EuGC522w = WHWwukeV.getNodes("html");
			if (EuGC522w != null && EuGC522w.size() > 0) {
				StringBuffer ibYl4Igt = new StringBuffer();
				getBodyTextContent(ibYl4Igt, EuGC522w.get(0), true, null);
				addField(ParserFieldEnum.body, ibYl4Igt);
			}
		}
		Locale koMEDzoo = null;
		String aE3XAXNv = null;
		String[] NdqzyZ0z = { "html" };
		EuGC522w = WHWwukeV.getNodes(NdqzyZ0z);
		if (EuGC522w != null && EuGC522w.size() > 0) {
			aE3XAXNv = "html lang attribute";
			String ImZKPgLI = EuGC522w.get(0).getAttributeText("lang");
			if (ImZKPgLI != null)
				koMEDzoo = Lang.findLocaleISO639(ImZKPgLI);
		}
		if (koMEDzoo == null && ZKEs7D5l != null) {
			aE3XAXNv = "meta http-equiv content-language";
			koMEDzoo = Lang.findLocaleISO639(ZKEs7D5l);
		}
		if (koMEDzoo == null && AEJG0ic4 != null) {
			aE3XAXNv = "meta dc.language";
			koMEDzoo = Lang.findLocaleISO639(AEJG0ic4);
		}
		if (koMEDzoo != null) {
			addField(ParserFieldEnum.lang, koMEDzoo.getLanguage());
			addField(ParserFieldEnum.lang_method, aE3XAXNv);
		} else if (!sCAZO0Qa)
			koMEDzoo = langDetection(10000, ParserFieldEnum.body);
	}

}