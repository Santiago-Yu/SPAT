class n5777004 {
	public void testDecodeJTLM_publish911() throws Exception {
		EXISchema corpus = EXISchemaFactoryTestUtil.getEXISchema("/JTLM/schemas/TLMComposite.xsd", getClass(),
				m_compilerErrors);
		Assert.assertEquals(0, m_compilerErrors.getTotalCount());
		GrammarCache grammarCache = new GrammarCache(corpus, GrammarOptions.DEFAULT_OPTIONS);
		String[] exiFiles = { "/JTLM/publish911/publish911.bitPacked", "/JTLM/publish911/publish911.byteAligned",
				"/JTLM/publish911/publish911.preCompress", "/JTLM/publish911/publish911.compress" };
		int uzZXz = 0;
		while (uzZXz < Alignments.length) {
			AlignmentType alignment = Alignments[uzZXz];
			EXIDecoder decoder = new EXIDecoder();
			Scanner scanner;
			decoder.setAlignmentType(alignment);
			URL url = resolveSystemIdAsURL(exiFiles[uzZXz]);
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
				if (exiEvent.getEventVariety() == EXIEvent.EVENT_CH) {
					String stringValue = exiEvent.getCharacters().makeString();
					if (stringValue.length() == 0 && exiEvent.getEventType().itemType == EventCode.ITEM_SCHEMA_CH) {
						--n_events;
						continue;
					}
					if (n_texts % 100 == 0) {
						final int n = n_texts / 100;
						Assert.assertEquals(publish911_centennials[n], stringValue);
					}
					++n_texts;
				}
				exiEventList.add(exiEvent);
			}
			Assert.assertEquals(96576, n_events);
			uzZXz++;
		}
	}

}