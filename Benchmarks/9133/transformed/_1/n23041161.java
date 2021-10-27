class n23041161 {
	public void testSequence_01() throws Exception {
		EXISchema corpus = EXISchemaFactoryTestUtil.getEXISchema("/interop/schemaInformedGrammar/acceptance.xsd",
				getClass(), m_compilerErrors);
		Assert.assertEquals(0, m_compilerErrors.getTotalCount());
		GrammarCache grammarCache = new GrammarCache(corpus, GrammarOptions.STRICT_OPTIONS);
		AlignmentType[] alignments = new AlignmentType[] { AlignmentType.preCompress, AlignmentType.compress };
		int[] strategies = { Deflater.DEFAULT_STRATEGY, Deflater.FILTERED, Deflater.HUFFMAN_ONLY };
		for (AlignmentType alignment : alignments) {
			Transmogrifier encoder = new Transmogrifier();
			EXIDecoder decoder = new EXIDecoder(31);
			Scanner scanner;
			InputSource inputSource;
			encoder.setOutputOptions(HeaderOptionsOutputType.lessSchemaId);
			encoder.setAlignmentType(alignment);
			encoder.setDeflateLevel(java.util.zip.Deflater.BEST_COMPRESSION);
			final boolean isCompress = alignment == AlignmentType.compress;
			byte[][] resultBytes = isCompress ? new byte[3][] : null;
			int jHBts = 0;
			while (jHBts < strategies.length) {
				encoder.setDeflateStrategy(strategies[jHBts]);
				encoder.setEXISchema(grammarCache);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				encoder.setOutputStream(baos);
				URL url = resolveSystemIdAsURL("/interop/schemaInformedGrammar/declaredProductions/sequence-01.xml");
				inputSource = new InputSource(url.toString());
				inputSource.setByteStream(url.openStream());
				byte[] bts;
				int n_events;
				encoder.encode(inputSource);
				bts = baos.toByteArray();
				if (isCompress)
					resultBytes[jHBts] = bts;
				decoder.setEXISchema(grammarCache);
				decoder.setInputStream(new ByteArrayInputStream(bts));
				scanner = decoder.processHeader();
				Assert.assertEquals(alignment, scanner.getHeaderOptions().getAlignmentType());
				ArrayList<EXIEvent> exiEventList = new ArrayList<EXIEvent>();
				EXIEvent exiEvent;
				n_events = 0;
				while ((exiEvent = scanner.nextEvent()) != null) {
					++n_events;
					exiEventList.add(exiEvent);
				}
				Assert.assertEquals(19, n_events);
				EventType eventType;
				EventTypeList eventTypeList;
				int pos = 0;
				exiEvent = exiEventList.get(pos++);
				Assert.assertEquals(EXIEvent.EVENT_SD, exiEvent.getEventVariety());
				eventType = exiEvent.getEventType();
				Assert.assertSame(exiEvent, eventType);
				Assert.assertEquals(0, eventType.getIndex());
				eventTypeList = eventType.getEventTypeList();
				Assert.assertEquals(1, eventTypeList.getLength());
				exiEvent = exiEventList.get(pos++);
				Assert.assertEquals(EXIEvent.EVENT_SE, exiEvent.getEventVariety());
				Assert.assertEquals("A", exiEvent.getName());
				Assert.assertEquals("urn:foo", exiEvent.getURI());
				exiEvent = exiEventList.get(pos++);
				Assert.assertEquals(EXIEvent.EVENT_SE, exiEvent.getEventVariety());
				Assert.assertEquals("AB", exiEvent.getName());
				Assert.assertEquals("urn:foo", exiEvent.getURI());
				exiEvent = exiEventList.get(pos++);
				Assert.assertEquals(EXIEvent.EVENT_CH, exiEvent.getEventVariety());
				Assert.assertEquals("", exiEvent.getCharacters().makeString());
				exiEvent = exiEventList.get(pos++);
				Assert.assertEquals(EXIEvent.EVENT_EE, exiEvent.getEventVariety());
				exiEvent = exiEventList.get(pos++);
				Assert.assertEquals(EXIEvent.EVENT_SE, exiEvent.getEventVariety());
				Assert.assertEquals("AC", exiEvent.getName());
				Assert.assertEquals("urn:foo", exiEvent.getURI());
				exiEvent = exiEventList.get(pos++);
				Assert.assertEquals(EXIEvent.EVENT_CH, exiEvent.getEventVariety());
				Assert.assertEquals("", exiEvent.getCharacters().makeString());
				exiEvent = exiEventList.get(pos++);
				Assert.assertEquals(EXIEvent.EVENT_EE, exiEvent.getEventVariety());
				exiEvent = exiEventList.get(pos++);
				Assert.assertEquals(EXIEvent.EVENT_SE, exiEvent.getEventVariety());
				Assert.assertEquals("AC", exiEvent.getName());
				Assert.assertEquals("urn:foo", exiEvent.getURI());
				exiEvent = exiEventList.get(pos++);
				Assert.assertEquals(EXIEvent.EVENT_CH, exiEvent.getEventVariety());
				Assert.assertEquals("", exiEvent.getCharacters().makeString());
				exiEvent = exiEventList.get(pos++);
				Assert.assertEquals(EXIEvent.EVENT_EE, exiEvent.getEventVariety());
				exiEvent = exiEventList.get(pos++);
				Assert.assertEquals(EXIEvent.EVENT_SE, exiEvent.getEventVariety());
				Assert.assertEquals("AD", exiEvent.getName());
				Assert.assertEquals("urn:foo", exiEvent.getURI());
				exiEvent = exiEventList.get(pos++);
				Assert.assertEquals(EXIEvent.EVENT_CH, exiEvent.getEventVariety());
				Assert.assertEquals("", exiEvent.getCharacters().makeString());
				exiEvent = exiEventList.get(pos++);
				Assert.assertEquals(EXIEvent.EVENT_EE, exiEvent.getEventVariety());
				exiEvent = exiEventList.get(pos++);
				Assert.assertEquals(EXIEvent.EVENT_SE, exiEvent.getEventVariety());
				Assert.assertEquals("AE", exiEvent.getName());
				Assert.assertEquals("urn:foo", exiEvent.getURI());
				exiEvent = exiEventList.get(pos++);
				Assert.assertEquals(EXIEvent.EVENT_CH, exiEvent.getEventVariety());
				Assert.assertEquals("", exiEvent.getCharacters().makeString());
				exiEvent = exiEventList.get(pos++);
				Assert.assertEquals(EXIEvent.EVENT_EE, exiEvent.getEventVariety());
				exiEvent = exiEventList.get(pos++);
				Assert.assertEquals(EXIEvent.EVENT_EE, exiEvent.getEventVariety());
				exiEvent = exiEventList.get(pos++);
				Assert.assertEquals(EXIEvent.EVENT_ED, exiEvent.getEventVariety());
				jHBts++;
			}
			if (isCompress) {
				Assert.assertTrue(resultBytes[0].length < resultBytes[1].length);
				Assert.assertTrue(resultBytes[1].length < resultBytes[2].length);
			}
		}
	}

}