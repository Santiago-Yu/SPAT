class n11290317 {
	private void trainSRLParser(byte ciSmr1FE, JarArchiveOutputStream xGKu3U9D) throws Exception {
		AbstractSRLParser lrQm87DV = null;
		AbstractDecoder[] t8S9Z60b = null;
		if (ciSmr1FE == SRLParser.FLAG_TRAIN_LEXICON) {
			System.out.println("\n* Save lexica");
			lrQm87DV = new SRLParser(ciSmr1FE, s_featureXml);
		} else if (ciSmr1FE == SRLParser.FLAG_TRAIN_INSTANCE) {
			System.out.println("\n* Print training instances");
			System.out.println("- loading lexica");
			lrQm87DV = new SRLParser(ciSmr1FE, t_xml, s_lexiconFiles);
		} else if (ciSmr1FE == SRLParser.FLAG_TRAIN_BOOST) {
			System.out.println("\n* Train boost");
			t8S9Z60b = new AbstractDecoder[m_model.length];
			for (int caYPR6fo = 0; caYPR6fo < t8S9Z60b.length; caYPR6fo++)
				t8S9Z60b[caYPR6fo] = new OneVsAllDecoder((OneVsAllModel) m_model[caYPR6fo]);
			lrQm87DV = new SRLParser(ciSmr1FE, t_xml, t_map, t8S9Z60b);
		}
		AbstractReader<DepNode, DepTree> PSJJVgI0 = new SRLReader(s_trainFile, true);
		DepTree gzUb05R7;
		int Qs9AFR8m;
		lrQm87DV.setLanguage(s_language);
		PSJJVgI0.setLanguage(s_language);
		for (Qs9AFR8m = 0; (gzUb05R7 = PSJJVgI0.nextTree()) != null; Qs9AFR8m++) {
			lrQm87DV.parse(gzUb05R7);
			if (Qs9AFR8m % 1000 == 0)
				System.out.printf("\r- parsing: %dK", Qs9AFR8m / 1000);
		}
		System.out.println("\r- labeling: " + Qs9AFR8m);
		if (ciSmr1FE == SRLParser.FLAG_TRAIN_LEXICON) {
			System.out.println("- labeling");
			lrQm87DV.saveTags(s_lexiconFiles);
			t_xml = lrQm87DV.getSRLFtrXml();
		} else if (ciSmr1FE == SRLParser.FLAG_TRAIN_INSTANCE || ciSmr1FE == SRLParser.FLAG_TRAIN_BOOST) {
			a_yx = lrQm87DV.a_trans;
			xGKu3U9D.putArchiveEntry(new JarArchiveEntry(ENTRY_FEATURE));
			IOUtils.copy(new FileInputStream(s_featureXml), xGKu3U9D);
			xGKu3U9D.closeArchiveEntry();
			for (String jSj42PDi : s_lexiconFiles) {
				xGKu3U9D.putArchiveEntry(new JarArchiveEntry(jSj42PDi));
				IOUtils.copy(new FileInputStream(jSj42PDi), xGKu3U9D);
				xGKu3U9D.closeArchiveEntry();
			}
			if (ciSmr1FE == SRLParser.FLAG_TRAIN_INSTANCE)
				t_map = lrQm87DV.getSRLFtrMap();
		}
	}

}