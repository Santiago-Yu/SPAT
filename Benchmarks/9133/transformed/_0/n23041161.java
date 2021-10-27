class n23041161 {
	public void testSequence_01() throws Exception {
		EXISchema ayx23eeL = EXISchemaFactoryTestUtil.getEXISchema("/interop/schemaInformedGrammar/acceptance.xsd",
				getClass(), m_compilerErrors);
		Assert.assertEquals(0, m_compilerErrors.getTotalCount());
		GrammarCache f0HoQYfv = new GrammarCache(ayx23eeL, GrammarOptions.STRICT_OPTIONS);
		AlignmentType[] wc5eFQpT = new AlignmentType[] { AlignmentType.preCompress, AlignmentType.compress };
		int[] SsDbTWqd = { Deflater.DEFAULT_STRATEGY, Deflater.FILTERED, Deflater.HUFFMAN_ONLY };
		for (AlignmentType exMbzpWm : wc5eFQpT) {
			Transmogrifier LxpCyqUg = new Transmogrifier();
			EXIDecoder H3nN86SQ = new EXIDecoder(31);
			Scanner NUsPClTD;
			InputSource qONca34q;
			LxpCyqUg.setOutputOptions(HeaderOptionsOutputType.lessSchemaId);
			LxpCyqUg.setAlignmentType(exMbzpWm);
			LxpCyqUg.setDeflateLevel(java.util.zip.Deflater.BEST_COMPRESSION);
			final boolean miylu19O = exMbzpWm == AlignmentType.compress;
			byte[][] lzwDvYQ9 = miylu19O ? new byte[3][] : null;
			for (int L7gKC8Vs = 0; L7gKC8Vs < SsDbTWqd.length; L7gKC8Vs++) {
				LxpCyqUg.setDeflateStrategy(SsDbTWqd[L7gKC8Vs]);
				LxpCyqUg.setEXISchema(f0HoQYfv);
				ByteArrayOutputStream JKX0ajQw = new ByteArrayOutputStream();
				LxpCyqUg.setOutputStream(JKX0ajQw);
				URL qfYQO0Us = resolveSystemIdAsURL(
						"/interop/schemaInformedGrammar/declaredProductions/sequence-01.xml");
				qONca34q = new InputSource(qfYQO0Us.toString());
				qONca34q.setByteStream(qfYQO0Us.openStream());
				byte[] uu10mLvX;
				int S4tErlFF;
				LxpCyqUg.encode(qONca34q);
				uu10mLvX = JKX0ajQw.toByteArray();
				if (miylu19O)
					lzwDvYQ9[L7gKC8Vs] = uu10mLvX;
				H3nN86SQ.setEXISchema(f0HoQYfv);
				H3nN86SQ.setInputStream(new ByteArrayInputStream(uu10mLvX));
				NUsPClTD = H3nN86SQ.processHeader();
				Assert.assertEquals(exMbzpWm, NUsPClTD.getHeaderOptions().getAlignmentType());
				ArrayList<EXIEvent> cVrEpD1I = new ArrayList<EXIEvent>();
				EXIEvent D0pHU21P;
				S4tErlFF = 0;
				while ((D0pHU21P = NUsPClTD.nextEvent()) != null) {
					++S4tErlFF;
					cVrEpD1I.add(D0pHU21P);
				}
				Assert.assertEquals(19, S4tErlFF);
				EventType vgWKtEmC;
				EventTypeList ztmqVLIm;
				int XB0GwABA = 0;
				D0pHU21P = cVrEpD1I.get(XB0GwABA++);
				Assert.assertEquals(EXIEvent.EVENT_SD, D0pHU21P.getEventVariety());
				vgWKtEmC = D0pHU21P.getEventType();
				Assert.assertSame(D0pHU21P, vgWKtEmC);
				Assert.assertEquals(0, vgWKtEmC.getIndex());
				ztmqVLIm = vgWKtEmC.getEventTypeList();
				Assert.assertEquals(1, ztmqVLIm.getLength());
				D0pHU21P = cVrEpD1I.get(XB0GwABA++);
				Assert.assertEquals(EXIEvent.EVENT_SE, D0pHU21P.getEventVariety());
				Assert.assertEquals("A", D0pHU21P.getName());
				Assert.assertEquals("urn:foo", D0pHU21P.getURI());
				D0pHU21P = cVrEpD1I.get(XB0GwABA++);
				Assert.assertEquals(EXIEvent.EVENT_SE, D0pHU21P.getEventVariety());
				Assert.assertEquals("AB", D0pHU21P.getName());
				Assert.assertEquals("urn:foo", D0pHU21P.getURI());
				D0pHU21P = cVrEpD1I.get(XB0GwABA++);
				Assert.assertEquals(EXIEvent.EVENT_CH, D0pHU21P.getEventVariety());
				Assert.assertEquals("", D0pHU21P.getCharacters().makeString());
				D0pHU21P = cVrEpD1I.get(XB0GwABA++);
				Assert.assertEquals(EXIEvent.EVENT_EE, D0pHU21P.getEventVariety());
				D0pHU21P = cVrEpD1I.get(XB0GwABA++);
				Assert.assertEquals(EXIEvent.EVENT_SE, D0pHU21P.getEventVariety());
				Assert.assertEquals("AC", D0pHU21P.getName());
				Assert.assertEquals("urn:foo", D0pHU21P.getURI());
				D0pHU21P = cVrEpD1I.get(XB0GwABA++);
				Assert.assertEquals(EXIEvent.EVENT_CH, D0pHU21P.getEventVariety());
				Assert.assertEquals("", D0pHU21P.getCharacters().makeString());
				D0pHU21P = cVrEpD1I.get(XB0GwABA++);
				Assert.assertEquals(EXIEvent.EVENT_EE, D0pHU21P.getEventVariety());
				D0pHU21P = cVrEpD1I.get(XB0GwABA++);
				Assert.assertEquals(EXIEvent.EVENT_SE, D0pHU21P.getEventVariety());
				Assert.assertEquals("AC", D0pHU21P.getName());
				Assert.assertEquals("urn:foo", D0pHU21P.getURI());
				D0pHU21P = cVrEpD1I.get(XB0GwABA++);
				Assert.assertEquals(EXIEvent.EVENT_CH, D0pHU21P.getEventVariety());
				Assert.assertEquals("", D0pHU21P.getCharacters().makeString());
				D0pHU21P = cVrEpD1I.get(XB0GwABA++);
				Assert.assertEquals(EXIEvent.EVENT_EE, D0pHU21P.getEventVariety());
				D0pHU21P = cVrEpD1I.get(XB0GwABA++);
				Assert.assertEquals(EXIEvent.EVENT_SE, D0pHU21P.getEventVariety());
				Assert.assertEquals("AD", D0pHU21P.getName());
				Assert.assertEquals("urn:foo", D0pHU21P.getURI());
				D0pHU21P = cVrEpD1I.get(XB0GwABA++);
				Assert.assertEquals(EXIEvent.EVENT_CH, D0pHU21P.getEventVariety());
				Assert.assertEquals("", D0pHU21P.getCharacters().makeString());
				D0pHU21P = cVrEpD1I.get(XB0GwABA++);
				Assert.assertEquals(EXIEvent.EVENT_EE, D0pHU21P.getEventVariety());
				D0pHU21P = cVrEpD1I.get(XB0GwABA++);
				Assert.assertEquals(EXIEvent.EVENT_SE, D0pHU21P.getEventVariety());
				Assert.assertEquals("AE", D0pHU21P.getName());
				Assert.assertEquals("urn:foo", D0pHU21P.getURI());
				D0pHU21P = cVrEpD1I.get(XB0GwABA++);
				Assert.assertEquals(EXIEvent.EVENT_CH, D0pHU21P.getEventVariety());
				Assert.assertEquals("", D0pHU21P.getCharacters().makeString());
				D0pHU21P = cVrEpD1I.get(XB0GwABA++);
				Assert.assertEquals(EXIEvent.EVENT_EE, D0pHU21P.getEventVariety());
				D0pHU21P = cVrEpD1I.get(XB0GwABA++);
				Assert.assertEquals(EXIEvent.EVENT_EE, D0pHU21P.getEventVariety());
				D0pHU21P = cVrEpD1I.get(XB0GwABA++);
				Assert.assertEquals(EXIEvent.EVENT_ED, D0pHU21P.getEventVariety());
			}
			if (miylu19O) {
				Assert.assertTrue(lzwDvYQ9[0].length < lzwDvYQ9[1].length);
				Assert.assertTrue(lzwDvYQ9[1].length < lzwDvYQ9[2].length);
			}
		}
	}

}