class n5777002 {
	public void testJTLM_publish100() throws Exception {
		EXISchema corpus = EXISchemaFactoryTestUtil.getEXISchema("/JTLM/schemas/TLMComposite.xsd", getClass(),
				m_compilerErrors);
		Assert.assertEquals(0, m_compilerErrors.getTotalCount());
		GrammarCache grammarCache = new GrammarCache(corpus, GrammarOptions.DEFAULT_OPTIONS);
		AlignmentType[] alignments = new AlignmentType[] { AlignmentType.bitPacked, AlignmentType.byteAligned,
				AlignmentType.preCompress, AlignmentType.compress };
		for (AlignmentType alignment : alignments) {
			Transmogrifier encoder = new Transmogrifier();
			EXIDecoder decoder = new EXIDecoder(999);
			Scanner scanner;
			InputSource inputSource;
			encoder.setAlignmentType(alignment);
			decoder.setAlignmentType(alignment);
			encoder.setEXISchema(grammarCache);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			encoder.setOutputStream(baos);
			URL url = resolveSystemIdAsURL("/JTLM/publish100.xml");
			inputSource = new InputSource(url.toString());
			inputSource.setByteStream(url.openStream());
			byte[] bts;
			int n_events, n_texts;
			encoder.encode(inputSource);
			bts = baos.toByteArray();
			decoder.setEXISchema(grammarCache);
			decoder.setInputStream(new ByteArrayInputStream(bts));
			scanner = decoder.processHeader();
			ArrayList<EXIEvent> exiEventList = new ArrayList<EXIEvent>();
			EXIEvent exiEvent;
			n_events = 0;
			n_texts = 0;
			while ((exiEvent = scanner.nextEvent()) != null) {
				++n_events;
				if (EXIEvent.EVENT_CH == exiEvent.getEventVariety()) {
					if (0 == n_texts % 100) {
						final int n = n_texts / 100;
						Assert.assertEquals(publish100_centennials[n], exiEvent.getCharacters().makeString());
					}
					++n_texts;
				}
				exiEventList.add(exiEvent);
			}
			Assert.assertEquals(10610, n_events);
		}
	}

}