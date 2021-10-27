class n20303339 {
	private void trainDepParser(byte URVr4B1C, JarArchiveOutputStream EOUi88kQ) throws Exception {
		AbstractDepParser PiEcgzp0 = null;
		OneVsAllDecoder NFOwPE5f = null;
		if (URVr4B1C == ShiftPopParser.FLAG_TRAIN_LEXICON) {
			System.out.println("\n* Save lexica");
			if (s_depParser.equals(AbstractDepParser.ALG_SHIFT_EAGER))
				PiEcgzp0 = new ShiftEagerParser(URVr4B1C, s_featureXml);
			else if (s_depParser.equals(AbstractDepParser.ALG_SHIFT_POP))
				PiEcgzp0 = new ShiftPopParser(URVr4B1C, s_featureXml);
		} else if (URVr4B1C == ShiftPopParser.FLAG_TRAIN_INSTANCE) {
			System.out.println("\n* Print training instances");
			System.out.println("- loading lexica");
			if (s_depParser.equals(AbstractDepParser.ALG_SHIFT_EAGER))
				PiEcgzp0 = new ShiftEagerParser(URVr4B1C, t_xml, ENTRY_LEXICA);
			else if (s_depParser.equals(AbstractDepParser.ALG_SHIFT_POP))
				PiEcgzp0 = new ShiftPopParser(URVr4B1C, t_xml, ENTRY_LEXICA);
		} else if (URVr4B1C == ShiftPopParser.FLAG_TRAIN_BOOST) {
			System.out.println("\n* Train conditional");
			NFOwPE5f = new OneVsAllDecoder(m_model);
			if (s_depParser.equals(AbstractDepParser.ALG_SHIFT_EAGER))
				PiEcgzp0 = new ShiftEagerParser(URVr4B1C, t_xml, t_map, NFOwPE5f);
			else if (s_depParser.equals(AbstractDepParser.ALG_SHIFT_POP))
				PiEcgzp0 = new ShiftPopParser(URVr4B1C, t_xml, t_map, NFOwPE5f);
		}
		AbstractReader<DepNode, DepTree> mpwFRB1b = null;
		DepTree wQDN0nPS;
		int jHenHn9a;
		if (s_format.equals(AbstractReader.FORMAT_DEP))
			mpwFRB1b = new DepReader(s_trainFile, true);
		else if (s_format.equals(AbstractReader.FORMAT_CONLLX))
			mpwFRB1b = new CoNLLXReader(s_trainFile, true);
		PiEcgzp0.setLanguage(s_language);
		mpwFRB1b.setLanguage(s_language);
		for (jHenHn9a = 0; (wQDN0nPS = mpwFRB1b.nextTree()) != null; jHenHn9a++) {
			PiEcgzp0.parse(wQDN0nPS);
			if (jHenHn9a % 1000 == 0)
				System.out.printf("\r- parsing: %dK", jHenHn9a / 1000);
		}
		System.out.println("\r- parsing: " + jHenHn9a);
		if (URVr4B1C == ShiftPopParser.FLAG_TRAIN_LEXICON) {
			System.out.println("- saving");
			PiEcgzp0.saveTags(ENTRY_LEXICA);
			t_xml = PiEcgzp0.getDepFtrXml();
		} else if (URVr4B1C == ShiftPopParser.FLAG_TRAIN_INSTANCE || URVr4B1C == ShiftPopParser.FLAG_TRAIN_BOOST) {
			a_yx = PiEcgzp0.a_trans;
			EOUi88kQ.putArchiveEntry(new JarArchiveEntry(ENTRY_PARSER));
			PrintStream GZnB4l64 = new PrintStream(EOUi88kQ);
			GZnB4l64.print(s_depParser);
			GZnB4l64.flush();
			EOUi88kQ.closeArchiveEntry();
			EOUi88kQ.putArchiveEntry(new JarArchiveEntry(ENTRY_FEATURE));
			IOUtils.copy(new FileInputStream(s_featureXml), EOUi88kQ);
			EOUi88kQ.closeArchiveEntry();
			EOUi88kQ.putArchiveEntry(new JarArchiveEntry(ENTRY_LEXICA));
			IOUtils.copy(new FileInputStream(ENTRY_LEXICA), EOUi88kQ);
			EOUi88kQ.closeArchiveEntry();
			if (URVr4B1C == ShiftPopParser.FLAG_TRAIN_INSTANCE)
				t_map = PiEcgzp0.getDepFtrMap();
		}
	}

}