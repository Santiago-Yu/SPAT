class n5777003 {
	public void testDecodeJTLM_publish100() throws Exception {
		EXISchema IXuupKbS = EXISchemaFactoryTestUtil.getEXISchema("/JTLM/schemas/TLMComposite.xsd", getClass(),
				m_compilerErrors);
		Assert.assertEquals(0, m_compilerErrors.getTotalCount());
		GrammarCache PTLGyCQR = new GrammarCache(IXuupKbS, GrammarOptions.DEFAULT_OPTIONS);
		String[] yncLlrQ0 = { "/JTLM/publish100/publish100.bitPacked", "/JTLM/publish100/publish100.byteAligned",
				"/JTLM/publish100/publish100.preCompress", "/JTLM/publish100/publish100.compress" };
		for (int wsHZjHD6 = 0; wsHZjHD6 < Alignments.length; wsHZjHD6++) {
			AlignmentType Rp9e1wa9 = Alignments[wsHZjHD6];
			EXIDecoder HcwoIYyy = new EXIDecoder();
			Scanner xLxSC9I9;
			HcwoIYyy.setAlignmentType(Rp9e1wa9);
			URL aPOAKfrh = resolveSystemIdAsURL(yncLlrQ0[wsHZjHD6]);
			int ELmETN9E, GZhOZPxa;
			HcwoIYyy.setEXISchema(PTLGyCQR);
			HcwoIYyy.setInputStream(aPOAKfrh.openStream());
			xLxSC9I9 = HcwoIYyy.processHeader();
			ArrayList<EXIEvent> kTGFSkYv = new ArrayList<EXIEvent>();
			EXIEvent n8333201;
			ELmETN9E = 0;
			GZhOZPxa = 0;
			while ((n8333201 = xLxSC9I9.nextEvent()) != null) {
				++ELmETN9E;
				if (n8333201.getEventVariety() == EXIEvent.EVENT_CH) {
					String n5z0a0FR = n8333201.getCharacters().makeString();
					if (n5z0a0FR.length() == 0 && n8333201.getEventType().itemType == EventCode.ITEM_SCHEMA_CH) {
						--ELmETN9E;
						continue;
					}
					if (GZhOZPxa % 100 == 0) {
						final int mIZCzP2x = GZhOZPxa / 100;
						Assert.assertEquals(publish100_centennials[mIZCzP2x], n5z0a0FR);
					}
					++GZhOZPxa;
				}
				kTGFSkYv.add(n8333201);
			}
			Assert.assertEquals(10610, ELmETN9E);
		}
	}

}