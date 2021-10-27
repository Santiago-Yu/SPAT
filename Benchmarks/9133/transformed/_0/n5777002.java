class n5777002 {
	public void testJTLM_publish100() throws Exception {
		EXISchema nB3ms2XC = EXISchemaFactoryTestUtil.getEXISchema("/JTLM/schemas/TLMComposite.xsd", getClass(),
				m_compilerErrors);
		Assert.assertEquals(0, m_compilerErrors.getTotalCount());
		GrammarCache LBkAQ6pV = new GrammarCache(nB3ms2XC, GrammarOptions.DEFAULT_OPTIONS);
		AlignmentType[] LBfSFBFy = new AlignmentType[] { AlignmentType.bitPacked, AlignmentType.byteAligned,
				AlignmentType.preCompress, AlignmentType.compress };
		for (AlignmentType IWybNadt : LBfSFBFy) {
			Transmogrifier pACHzHC0 = new Transmogrifier();
			EXIDecoder PfcYX7Nh = new EXIDecoder(999);
			Scanner T3e6e73A;
			InputSource CsbfuW41;
			pACHzHC0.setAlignmentType(IWybNadt);
			PfcYX7Nh.setAlignmentType(IWybNadt);
			pACHzHC0.setEXISchema(LBkAQ6pV);
			ByteArrayOutputStream L64UEsr1 = new ByteArrayOutputStream();
			pACHzHC0.setOutputStream(L64UEsr1);
			URL jNGXwN26 = resolveSystemIdAsURL("/JTLM/publish100.xml");
			CsbfuW41 = new InputSource(jNGXwN26.toString());
			CsbfuW41.setByteStream(jNGXwN26.openStream());
			byte[] wWdkNOcG;
			int WNWgkOGn, rbnVtm53;
			pACHzHC0.encode(CsbfuW41);
			wWdkNOcG = L64UEsr1.toByteArray();
			PfcYX7Nh.setEXISchema(LBkAQ6pV);
			PfcYX7Nh.setInputStream(new ByteArrayInputStream(wWdkNOcG));
			T3e6e73A = PfcYX7Nh.processHeader();
			ArrayList<EXIEvent> BeKTxoOs = new ArrayList<EXIEvent>();
			EXIEvent oc98p1eo;
			WNWgkOGn = 0;
			rbnVtm53 = 0;
			while ((oc98p1eo = T3e6e73A.nextEvent()) != null) {
				++WNWgkOGn;
				if (oc98p1eo.getEventVariety() == EXIEvent.EVENT_CH) {
					if (rbnVtm53 % 100 == 0) {
						final int wkUT0WZQ = rbnVtm53 / 100;
						Assert.assertEquals(publish100_centennials[wkUT0WZQ], oc98p1eo.getCharacters().makeString());
					}
					++rbnVtm53;
				}
				BeKTxoOs.add(oc98p1eo);
			}
			Assert.assertEquals(10610, WNWgkOGn);
		}
	}

}