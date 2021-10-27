class n23041163 {
	public void testJTLM_publish100_blockSize() throws Exception {
		EXISchema yo3kzL0v = EXISchemaFactoryTestUtil.getEXISchema("/JTLM/schemas/TLMComposite.xsd", getClass(),
				m_compilerErrors);
		Assert.assertEquals(0, m_compilerErrors.getTotalCount());
		GrammarCache nb5pvhjT = new GrammarCache(yo3kzL0v, GrammarOptions.STRICT_OPTIONS);
		AlignmentType[] oCqXrL1O = new AlignmentType[] { AlignmentType.preCompress, AlignmentType.compress };
		int[] EQAWzUs6 = { 1, 100, 101 };
		Transmogrifier AfaPhJW2 = new Transmogrifier();
		EXIDecoder tiCAnFRF = new EXIDecoder(999);
		AfaPhJW2.setOutputOptions(HeaderOptionsOutputType.lessSchemaId);
		AfaPhJW2.setEXISchema(nb5pvhjT);
		tiCAnFRF.setEXISchema(nb5pvhjT);
		for (AlignmentType USzljl43 : oCqXrL1O) {
			for (int UGVzCpS3 = 0; UGVzCpS3 < EQAWzUs6.length; UGVzCpS3++) {
				Scanner VqSu5JPl;
				InputSource jvjclIeS;
				AfaPhJW2.setAlignmentType(USzljl43);
				AfaPhJW2.setBlockSize(EQAWzUs6[UGVzCpS3]);
				ByteArrayOutputStream KJv6D4w7 = new ByteArrayOutputStream();
				AfaPhJW2.setOutputStream(KJv6D4w7);
				URL b906Gv8T = resolveSystemIdAsURL("/JTLM/publish100.xml");
				jvjclIeS = new InputSource(b906Gv8T.toString());
				jvjclIeS.setByteStream(b906Gv8T.openStream());
				byte[] XrXgvDVn;
				int JkBTvB8H, sMvfUqPF;
				AfaPhJW2.encode(jvjclIeS);
				XrXgvDVn = KJv6D4w7.toByteArray();
				tiCAnFRF.setInputStream(new ByteArrayInputStream(XrXgvDVn));
				VqSu5JPl = tiCAnFRF.processHeader();
				ArrayList<EXIEvent> zNm0X60g = new ArrayList<EXIEvent>();
				EXIEvent gTHZA094;
				JkBTvB8H = 0;
				sMvfUqPF = 0;
				while ((gTHZA094 = VqSu5JPl.nextEvent()) != null) {
					++JkBTvB8H;
					if (gTHZA094.getEventVariety() == EXIEvent.EVENT_CH) {
						if (gTHZA094.getCharacters().length() == 0) {
							--JkBTvB8H;
							continue;
						}
						if (sMvfUqPF % 100 == 0) {
							final int qzY5NrBN = sMvfUqPF / 100;
							Assert.assertEquals(JTLMTest.publish100_centennials[qzY5NrBN],
									gTHZA094.getCharacters().makeString());
						}
						++sMvfUqPF;
					}
					zNm0X60g.add(gTHZA094);
				}
				Assert.assertEquals(10610, JkBTvB8H);
			}
		}
	}

}