class n23041164 {
	public void testEmptyBlock_01() throws Exception {
		EXISchema DRdUPNxk = EXISchemaFactoryTestUtil.getEXISchema("/compression/emptyBlock_01.xsd", getClass(),
				m_compilerErrors);
		Assert.assertEquals(0, m_compilerErrors.getTotalCount());
		GrammarCache fmXPSVYK = new GrammarCache(DRdUPNxk, GrammarOptions.STRICT_OPTIONS);
		Transmogrifier dYHLqYkq = new Transmogrifier();
		EXIDecoder qk9v8B2l = new EXIDecoder(31);
		Scanner AwoVl4Ju;
		InputSource NSc5s12j;
		dYHLqYkq.setOutputOptions(HeaderOptionsOutputType.lessSchemaId);
		dYHLqYkq.setAlignmentType(AlignmentType.compress);
		dYHLqYkq.setBlockSize(1);
		dYHLqYkq.setEXISchema(fmXPSVYK);
		ByteArrayOutputStream qdnTbmUJ = new ByteArrayOutputStream();
		dYHLqYkq.setOutputStream(qdnTbmUJ);
		URL kOmLZSzE = resolveSystemIdAsURL("/compression/emptyBlock_01.xml");
		NSc5s12j = new InputSource(kOmLZSzE.toString());
		NSc5s12j.setByteStream(kOmLZSzE.openStream());
		byte[] RhTVSLiW;
		int i60bvscH;
		dYHLqYkq.encode(NSc5s12j);
		RhTVSLiW = qdnTbmUJ.toByteArray();
		qk9v8B2l.setEXISchema(fmXPSVYK);
		qk9v8B2l.setInputStream(new ByteArrayInputStream(RhTVSLiW));
		AwoVl4Ju = qk9v8B2l.processHeader();
		ArrayList<EXIEvent> awPtNV2t = new ArrayList<EXIEvent>();
		EXIEvent OfwHBvoC;
		i60bvscH = 0;
		while ((OfwHBvoC = AwoVl4Ju.nextEvent()) != null) {
			++i60bvscH;
			awPtNV2t.add(OfwHBvoC);
		}
		Assert.assertEquals(11, i60bvscH);
		Assert.assertEquals(1, ((ChannellingScanner) AwoVl4Ju).getBlockCount());
		EventType j0SQYpel;
		EventTypeList kh70mjMW;
		int ooOJosJn = 0;
		OfwHBvoC = awPtNV2t.get(ooOJosJn++);
		Assert.assertEquals(EXIEvent.EVENT_SD, OfwHBvoC.getEventVariety());
		j0SQYpel = OfwHBvoC.getEventType();
		Assert.assertSame(OfwHBvoC, j0SQYpel);
		Assert.assertEquals(0, j0SQYpel.getIndex());
		kh70mjMW = j0SQYpel.getEventTypeList();
		Assert.assertNull(kh70mjMW.getEE());
		OfwHBvoC = awPtNV2t.get(ooOJosJn++);
		Assert.assertEquals(EXIEvent.EVENT_SE, OfwHBvoC.getEventVariety());
		Assert.assertEquals("root", OfwHBvoC.getName());
		Assert.assertEquals("", j0SQYpel.getURI());
		OfwHBvoC = awPtNV2t.get(ooOJosJn++);
		Assert.assertEquals(EXIEvent.EVENT_SE, OfwHBvoC.getEventVariety());
		Assert.assertEquals("parent", OfwHBvoC.getName());
		Assert.assertEquals("", j0SQYpel.getURI());
		OfwHBvoC = awPtNV2t.get(ooOJosJn++);
		Assert.assertEquals(EXIEvent.EVENT_SE, OfwHBvoC.getEventVariety());
		Assert.assertEquals("child", OfwHBvoC.getName());
		Assert.assertEquals("", j0SQYpel.getURI());
		OfwHBvoC = awPtNV2t.get(ooOJosJn++);
		Assert.assertEquals(EXIEvent.EVENT_CH, OfwHBvoC.getEventVariety());
		Assert.assertEquals("42", OfwHBvoC.getCharacters().makeString());
		int UHMUxnPA = ((EventTypeSchema) OfwHBvoC.getEventType()).getSchemaSubstance();
		Assert.assertEquals(EXISchemaConst.UNSIGNED_BYTE_TYPE, DRdUPNxk.getSerialOfType(UHMUxnPA));
		OfwHBvoC = awPtNV2t.get(ooOJosJn++);
		Assert.assertEquals(EXIEvent.EVENT_EE, OfwHBvoC.getEventVariety());
		OfwHBvoC = awPtNV2t.get(ooOJosJn++);
		Assert.assertEquals(EXIEvent.EVENT_EE, OfwHBvoC.getEventVariety());
		OfwHBvoC = awPtNV2t.get(ooOJosJn++);
		Assert.assertEquals(EXIEvent.EVENT_SE, OfwHBvoC.getEventVariety());
		Assert.assertEquals("adjunct", OfwHBvoC.getName());
		Assert.assertEquals("", OfwHBvoC.getURI());
		OfwHBvoC = awPtNV2t.get(ooOJosJn++);
		Assert.assertEquals(EXIEvent.EVENT_EE, OfwHBvoC.getEventVariety());
		OfwHBvoC = awPtNV2t.get(ooOJosJn++);
		Assert.assertEquals(EXIEvent.EVENT_EE, OfwHBvoC.getEventVariety());
		OfwHBvoC = awPtNV2t.get(ooOJosJn++);
		Assert.assertEquals(EXIEvent.EVENT_ED, OfwHBvoC.getEventVariety());
	}

}