class n20303339 {
	private void trainDepParser(byte flag, JarArchiveOutputStream zout) throws Exception {
		AbstractDepParser parser = null;
		OneVsAllDecoder decoder = null;
		if (flag == ShiftPopParser.FLAG_TRAIN_LEXICON) {
			System.out.println("\n* Save lexica");
			if (s_depParser.equals(AbstractDepParser.ALG_SHIFT_EAGER))
				parser = new ShiftEagerParser(flag, s_featureXml);
			else
				parser = (s_depParser.equals(AbstractDepParser.ALG_SHIFT_POP)) ? new ShiftPopParser(flag, s_featureXml)
						: parser;
		} else if (flag == ShiftPopParser.FLAG_TRAIN_INSTANCE) {
			System.out.println("\n* Print training instances");
			System.out.println("- loading lexica");
			if (s_depParser.equals(AbstractDepParser.ALG_SHIFT_EAGER))
				parser = new ShiftEagerParser(flag, t_xml, ENTRY_LEXICA);
			else
				parser = (s_depParser.equals(AbstractDepParser.ALG_SHIFT_POP))
						? new ShiftPopParser(flag, t_xml, ENTRY_LEXICA)
						: parser;
		} else if (flag == ShiftPopParser.FLAG_TRAIN_BOOST) {
			System.out.println("\n* Train conditional");
			decoder = new OneVsAllDecoder(m_model);
			if (s_depParser.equals(AbstractDepParser.ALG_SHIFT_EAGER))
				parser = new ShiftEagerParser(flag, t_xml, t_map, decoder);
			else
				parser = (s_depParser.equals(AbstractDepParser.ALG_SHIFT_POP))
						? new ShiftPopParser(flag, t_xml, t_map, decoder)
						: parser;
		}
		AbstractReader<DepNode, DepTree> reader = null;
		DepTree tree;
		int n;
		if (s_format.equals(AbstractReader.FORMAT_DEP))
			reader = new DepReader(s_trainFile, true);
		else
			reader = (s_format.equals(AbstractReader.FORMAT_CONLLX)) ? new CoNLLXReader(s_trainFile, true) : reader;
		parser.setLanguage(s_language);
		reader.setLanguage(s_language);
		for (n = 0; (tree = reader.nextTree()) != null; n++) {
			parser.parse(tree);
			if (n % 1000 == 0)
				System.out.printf("\r- parsing: %dK", n / 1000);
		}
		System.out.println("\r- parsing: " + n);
		if (flag == ShiftPopParser.FLAG_TRAIN_LEXICON) {
			System.out.println("- saving");
			parser.saveTags(ENTRY_LEXICA);
			t_xml = parser.getDepFtrXml();
		} else if (flag == ShiftPopParser.FLAG_TRAIN_INSTANCE || flag == ShiftPopParser.FLAG_TRAIN_BOOST) {
			a_yx = parser.a_trans;
			zout.putArchiveEntry(new JarArchiveEntry(ENTRY_PARSER));
			PrintStream fout = new PrintStream(zout);
			fout.print(s_depParser);
			fout.flush();
			zout.closeArchiveEntry();
			zout.putArchiveEntry(new JarArchiveEntry(ENTRY_FEATURE));
			IOUtils.copy(new FileInputStream(s_featureXml), zout);
			zout.closeArchiveEntry();
			zout.putArchiveEntry(new JarArchiveEntry(ENTRY_LEXICA));
			IOUtils.copy(new FileInputStream(ENTRY_LEXICA), zout);
			zout.closeArchiveEntry();
			t_map = (flag == ShiftPopParser.FLAG_TRAIN_INSTANCE) ? parser.getDepFtrMap() : t_map;
		}
	}

}