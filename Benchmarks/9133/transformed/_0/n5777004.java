class n5777004 {
	public void testDecodeJTLM_publish911() throws Exception {
		EXISchema PCSDVlVW = EXISchemaFactoryTestUtil.getEXISchema("/JTLM/schemas/TLMComposite.xsd", getClass(),
				m_compilerErrors);
		Assert.assertEquals(0, m_compilerErrors.getTotalCount());
		GrammarCache K58OKNRX = new GrammarCache(PCSDVlVW, GrammarOptions.DEFAULT_OPTIONS);
		String[] WYHt3hsj = { "/JTLM/publish911/publish911.bitPacked", "/JTLM/publish911/publish911.byteAligned",
				"/JTLM/publish911/publish911.preCompress", "/JTLM/publish911/publish911.compress" };
		for (int FoojnVkx = 0; FoojnVkx < Alignments.length; FoojnVkx++) {
			AlignmentType wbssR0jS = Alignments[FoojnVkx];
			EXIDecoder TIFd0e7d = new EXIDecoder();
			Scanner BUZ3ccyV;
			TIFd0e7d.setAlignmentType(wbssR0jS);
			URL mKw04amk = resolveSystemIdAsURL(WYHt3hsj[FoojnVkx]);
			int lo6hjdfu, hPIYlPC3;
			TIFd0e7d.setEXISchema(K58OKNRX);
			TIFd0e7d.setInputStream(mKw04amk.openStream());
			BUZ3ccyV = TIFd0e7d.processHeader();
			ArrayList<EXIEvent> pjJFaWz0 = new ArrayList<EXIEvent>();
			EXIEvent w2wtOZUM;
			lo6hjdfu = 0;
			hPIYlPC3 = 0;
			while ((w2wtOZUM = BUZ3ccyV.nextEvent()) != null) {
				++lo6hjdfu;
				if (w2wtOZUM.getEventVariety() == EXIEvent.EVENT_CH) {
					String E7FASb0e = w2wtOZUM.getCharacters().makeString();
					if (E7FASb0e.length() == 0 && w2wtOZUM.getEventType().itemType == EventCode.ITEM_SCHEMA_CH) {
						--lo6hjdfu;
						continue;
					}
					if (hPIYlPC3 % 100 == 0) {
						final int WhWgGDX6 = hPIYlPC3 / 100;
						Assert.assertEquals(publish911_centennials[WhWgGDX6], E7FASb0e);
					}
					++hPIYlPC3;
				}
				pjJFaWz0.add(w2wtOZUM);
			}
			Assert.assertEquals(96576, lo6hjdfu);
		}
	}

}