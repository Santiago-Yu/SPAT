class n23041163{
    public void testJTLM_publish100_blockSize() throws Exception {
        EXISchema corpus = EXISchemaFactoryTestUtil.getEXISchema("/JTLM/schemas/TLMComposite.xsd", getClass(), m_compilerErrors);
        Assert.assertEquals(0, m_compilerErrors.getTotalCount());
        GrammarCache grammarCache = new GrammarCache(corpus, GrammarOptions.STRICT_OPTIONS);
        AlignmentType[] alignments = new AlignmentType[] { AlignmentType.preCompress, AlignmentType.compress };
        int[] blockSizes = { 1, 100, 101 };
        Transmogrifier encoder = new Transmogrifier();
        EXIDecoder decoder = new EXIDecoder(999);
        encoder.setOutputOptions(HeaderOptionsOutputType.lessSchemaId);
        encoder.setEXISchema(grammarCache);
        decoder.setEXISchema(grammarCache);
        for (AlignmentType alignment : alignments) {
            for (int i = 0; i < blockSizes.length; i++) {
                Scanner scanner;
                InputSource inputSource;
                encoder.setAlignmentType(alignment);
                encoder.setBlockSize(blockSizes[i]);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                encoder.setOutputStream(baos);
                URL url = resolveSystemIdAsURL("/JTLM/publish100.xml");
                inputSource = new InputSource(url.toString());
                inputSource.setByteStream(url.openStream());
                byte[] bts;
                int n_events, n_texts;
                encoder.encode(inputSource);
                bts = baos.toByteArray();
                decoder.setInputStream(new ByteArrayInputStream(bts));
                scanner = decoder.processHeader();
                ArrayList<EXIEvent> exiEventList = new ArrayList<EXIEvent>();
                EXIEvent exiEvent;
                n_events = 0;
                n_texts = 0;
                while ((exiEvent = scanner.nextEvent()) != null) {
                    ++n_events;
                    if (exiEvent.getEventVariety() == EXIEvent.EVENT_CH) {
                        if (exiEvent.getCharacters().length() == 0) {
                            --n_events;
                            continue;
                        }
                        if (n_texts % 100 == 0) {
                            final int n = n_texts / 100;
                            Assert.assertEquals(JTLMTest.publish100_centennials[n], exiEvent.getCharacters().makeString());
                        }
                        ++n_texts;
                    }
                    exiEventList.add(exiEvent);
                }
                Assert.assertEquals(10610, n_events);
            }
        }
    }

}