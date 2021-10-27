class n5777004 {
	public void testDecodeJTLM_publish911() throws Exception {
		EXISchema corpus = EXISchemaFactoryTestUtil.getEXISchema("/JTLM/schemas/TLMComposite.xsd", getClass(),
				m_compilerErrors);
		Assert.assertEquals(0, m_compilerErrors.getTotalCount());
		GrammarCache grammarCache = new GrammarCache(corpus, GrammarOptions.DEFAULT_OPTIONS);
		String[] exiFiles = { "/JTLM/publish911/publish911.bitPacked", "/JTLM/publish911/publish911.byteAligned",
				"/JTLM/publish911/publish911.preCompress", "/JTLM/publish911/publish911.compress" };
		for (int i = 0; i < Alignments.length; i++) {
			AlignmentType alignment = Alignments[i];
			EXIDecoder decoder = new EXIDecoder();
			Scanner scanner;
			decoder.setAlignmentType(alignment);
			URL url = resolveSystemIdAsURL(exiFiles[i]);
			int n_events, n_texts;
			decoder.setEXISchema(grammarCache);
			decoder.setInputStream(url.openStream());
			scanner = decoder.processHeader();
			ArrayList<EXIEvent> exiEventList = new ArrayList<EXIEvent>();
			EXIEvent exiEvent;
			n_events = 0;
			n_texts = 0;
			while ((exiEvent = scanner.nextEvent()) != null) {
				++n_events;
				if (EXIEvent.EVENT_CH == exiEvent.getEventVariety()) {
					String stringValue = exiEvent.getCharacters().makeString();
					if (0 == stringValue.length() && EventCode.ITEM_SCHEMA_CH == exiEvent.getEventType().itemType) {
						--n_events;
						continue;
					}
					if (0 == n_texts % 100) {
						final int n = n_texts / 100;
						Assert.assertEquals(publish911_centennials[n], stringValue);
					}
					++n_texts;
				}
				exiEventList.add(exiEvent);
			}
			Assert.assertEquals(96576, n_events);
		}
	}

}