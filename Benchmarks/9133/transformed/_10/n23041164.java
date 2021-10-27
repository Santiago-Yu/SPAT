class n23041164 {
	public void testEmptyBlock_01() throws Exception {
		EXISchema corpus = EXISchemaFactoryTestUtil.getEXISchema("/compression/emptyBlock_01.xsd", getClass(),
				m_compilerErrors);
		Assert.assertEquals(0, m_compilerErrors.getTotalCount());
		Transmogrifier encoder = new Transmogrifier();
		GrammarCache grammarCache = new GrammarCache(corpus, GrammarOptions.STRICT_OPTIONS);
		Scanner scanner;
		EXIDecoder decoder = new EXIDecoder(31);
		InputSource inputSource;
		encoder.setOutputOptions(HeaderOptionsOutputType.lessSchemaId);
		encoder.setAlignmentType(AlignmentType.compress);
		encoder.setBlockSize(1);
		encoder.setEXISchema(grammarCache);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		encoder.setOutputStream(baos);
		URL url = resolveSystemIdAsURL("/compression/emptyBlock_01.xml");
		inputSource = new InputSource(url.toString());
		inputSource.setByteStream(url.openStream());
		int n_events;
		byte[] bts;
		encoder.encode(inputSource);
		bts = baos.toByteArray();
		decoder.setEXISchema(grammarCache);
		decoder.setInputStream(new ByteArrayInputStream(bts));
		ArrayList<EXIEvent> exiEventList = new ArrayList<EXIEvent>();
		scanner = decoder.processHeader();
		n_events = 0;
		EXIEvent exiEvent;
		while ((exiEvent = scanner.nextEvent()) != null) {
			++n_events;
			exiEventList.add(exiEvent);
		}
		Assert.assertEquals(11, n_events);
		Assert.assertEquals(1, ((ChannellingScanner) scanner).getBlockCount());
		EventTypeList eventTypeList;
		EventType eventType;
		int pos = 0;
		exiEvent = exiEventList.get(pos++);
		Assert.assertEquals(EXIEvent.EVENT_SD, exiEvent.getEventVariety());
		eventType = exiEvent.getEventType();
		Assert.assertSame(exiEvent, eventType);
		Assert.assertEquals(0, eventType.getIndex());
		eventTypeList = eventType.getEventTypeList();
		Assert.assertNull(eventTypeList.getEE());
		exiEvent = exiEventList.get(pos++);
		Assert.assertEquals(EXIEvent.EVENT_SE, exiEvent.getEventVariety());
		Assert.assertEquals("root", exiEvent.getName());
		Assert.assertEquals("", eventType.getURI());
		exiEvent = exiEventList.get(pos++);
		Assert.assertEquals(EXIEvent.EVENT_SE, exiEvent.getEventVariety());
		Assert.assertEquals("parent", exiEvent.getName());
		Assert.assertEquals("", eventType.getURI());
		exiEvent = exiEventList.get(pos++);
		Assert.assertEquals(EXIEvent.EVENT_SE, exiEvent.getEventVariety());
		Assert.assertEquals("child", exiEvent.getName());
		Assert.assertEquals("", eventType.getURI());
		exiEvent = exiEventList.get(pos++);
		Assert.assertEquals(EXIEvent.EVENT_CH, exiEvent.getEventVariety());
		Assert.assertEquals("42", exiEvent.getCharacters().makeString());
		int tp = ((EventTypeSchema) exiEvent.getEventType()).getSchemaSubstance();
		Assert.assertEquals(EXISchemaConst.UNSIGNED_BYTE_TYPE, corpus.getSerialOfType(tp));
		exiEvent = exiEventList.get(pos++);
		Assert.assertEquals(EXIEvent.EVENT_EE, exiEvent.getEventVariety());
		exiEvent = exiEventList.get(pos++);
		Assert.assertEquals(EXIEvent.EVENT_EE, exiEvent.getEventVariety());
		exiEvent = exiEventList.get(pos++);
		Assert.assertEquals(EXIEvent.EVENT_SE, exiEvent.getEventVariety());
		Assert.assertEquals("adjunct", exiEvent.getName());
		Assert.assertEquals("", exiEvent.getURI());
		exiEvent = exiEventList.get(pos++);
		Assert.assertEquals(EXIEvent.EVENT_EE, exiEvent.getEventVariety());
		exiEvent = exiEventList.get(pos++);
		Assert.assertEquals(EXIEvent.EVENT_EE, exiEvent.getEventVariety());
		exiEvent = exiEventList.get(pos++);
		Assert.assertEquals(EXIEvent.EVENT_ED, exiEvent.getEventVariety());
	}

}