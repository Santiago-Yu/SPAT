class n23041162 {
	public void testJTLM_publish911() throws Exception {
		EXISchema corpus = EXISchemaFactoryTestUtil.getEXISchema("/JTLM/schemas/TLMComposite.xsd", getClass(),
				m_compilerErrors);
		Assert.assertEquals(0, m_compilerErrors.getTotalCount());
		GrammarCache grammarCache = new GrammarCache(corpus, GrammarOptions.STRICT_OPTIONS);
		Transmogrifier encoder = new Transmogrifier();
		AlignmentType alignment = AlignmentType.compress;
		Scanner scanner;
		EXIDecoder decoder = new EXIDecoder();
		InputSource inputSource;
		encoder.setAlignmentType(alignment);
		decoder.setAlignmentType(alignment);
		encoder.setEXISchema(grammarCache);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		encoder.setOutputStream(baos);
		URL url = resolveSystemIdAsURL("/JTLM/publish911.xml");
		inputSource = new InputSource(url.toString());
		inputSource.setByteStream(url.openStream());
		int n_events, n_texts;
		byte[] bts;
		encoder.encode(inputSource);
		bts = baos.toByteArray();
		decoder.setEXISchema(grammarCache);
		decoder.setInputStream(new ByteArrayInputStream(bts));
		ArrayList<EXIEvent> exiEventList = new ArrayList<EXIEvent>();
		scanner = decoder.processHeader();
		n_events = 0;
		EXIEvent exiEvent;
		n_texts = 0;
		while ((exiEvent = scanner.nextEvent()) != null) {
			++n_events;
			if (exiEvent.getEventVariety() == EXIEvent.EVENT_CH) {
				if (exiEvent.getCharacters().length() == 0) {
					--n_events;
					continue;
				}
				if (n_texts % 100 == 0) {
					final int n = n_texts / 100;
					Assert.assertEquals(JTLMTest.publish911_centennials[n], exiEvent.getCharacters().makeString());
				}
				++n_texts;
			}
			exiEventList.add(exiEvent);
		}
		Assert.assertEquals(96576, n_events);
	}

}