class n23041162 {
	public void testJTLM_publish911() throws Exception {
		EXISchema h7zjwb1X = EXISchemaFactoryTestUtil.getEXISchema("/JTLM/schemas/TLMComposite.xsd", getClass(),
				m_compilerErrors);
		Assert.assertEquals(0, m_compilerErrors.getTotalCount());
		GrammarCache brYS5BTE = new GrammarCache(h7zjwb1X, GrammarOptions.STRICT_OPTIONS);
		AlignmentType nQIaSJJ8 = AlignmentType.compress;
		Transmogrifier gn89Lfvk = new Transmogrifier();
		EXIDecoder vs0NzAkp = new EXIDecoder();
		Scanner mQ6KqhSy;
		InputSource aHUN6H0y;
		gn89Lfvk.setAlignmentType(nQIaSJJ8);
		vs0NzAkp.setAlignmentType(nQIaSJJ8);
		gn89Lfvk.setEXISchema(brYS5BTE);
		ByteArrayOutputStream QFgGKSJE = new ByteArrayOutputStream();
		gn89Lfvk.setOutputStream(QFgGKSJE);
		URL RuVSobqe = resolveSystemIdAsURL("/JTLM/publish911.xml");
		aHUN6H0y = new InputSource(RuVSobqe.toString());
		aHUN6H0y.setByteStream(RuVSobqe.openStream());
		byte[] C3j8t2eq;
		int PUjHnOmZ, QAuJrphc;
		gn89Lfvk.encode(aHUN6H0y);
		C3j8t2eq = QFgGKSJE.toByteArray();
		vs0NzAkp.setEXISchema(brYS5BTE);
		vs0NzAkp.setInputStream(new ByteArrayInputStream(C3j8t2eq));
		mQ6KqhSy = vs0NzAkp.processHeader();
		ArrayList<EXIEvent> dausxmwU = new ArrayList<EXIEvent>();
		EXIEvent JTe0LM9D;
		PUjHnOmZ = 0;
		QAuJrphc = 0;
		while ((JTe0LM9D = mQ6KqhSy.nextEvent()) != null) {
			++PUjHnOmZ;
			if (JTe0LM9D.getEventVariety() == EXIEvent.EVENT_CH) {
				if (JTe0LM9D.getCharacters().length() == 0) {
					--PUjHnOmZ;
					continue;
				}
				if (QAuJrphc % 100 == 0) {
					final int QEnkCe7Z = QAuJrphc / 100;
					Assert.assertEquals(JTLMTest.publish911_centennials[QEnkCe7Z],
							JTe0LM9D.getCharacters().makeString());
				}
				++QAuJrphc;
			}
			dausxmwU.add(JTe0LM9D);
		}
		Assert.assertEquals(96576, PUjHnOmZ);
	}

}