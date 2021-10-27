class n5777002 {
	public void testJTLM_publish100() throws Exception {
		EXISchema corpus = EXISchemaFactoryTestUtil.getEXISchema("/JTLM/schemas/TLMComposite.xsd", getClass(),
				m_compilerErrors);
		Assert.assertEquals(0, m_compilerErrors.getTotalCount());
		GrammarCache grammarCache = new GrammarCache(corpus, GrammarOptions.DEFAULT_OPTIONS);
		AlignmentType[] alignments = new AlignmentType[] { AlignmentType.bitPacked, AlignmentType.byteAligned,
				AlignmentType.preCompress, AlignmentType.compress };
		for (AlignmentType alignment : alignments) {
			EXIDecoder decoder = new EXIDecoder(999);
			Transmogrifier encoder = new Transmogrifier();
			InputSource inputSource;
			Scanner scanner;
			encoder.setAlignmentType(alignment);
			decoder.setAlignmentType(alignment);
			encoder.setEXISchema(grammarCache);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			encoder.setOutputStream(baos);
			URL url = resolveSystemIdAsURL("/JTLM/publish100.xml");
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
				if (exiEvent.getEventVariety() == EXIEvent.EVENT_CH) {
					if (n_texts % 100 == 0) {
						final int n = n_texts / 100;
						Assert.assertEquals(publish100_centennials[n], exiEvent.getCharacters().makeString());
					}
					++n_texts;
				}
				++n_events;
				exiEventList.add(exiEvent);
			}
			Assert.assertEquals(10610, n_events);
		}
	}

}