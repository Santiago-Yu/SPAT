class n7288760 {
	public void testDecode1000BinaryStore() throws Exception {
		EXISchema corpus = EXISchemaFactoryTestUtil.getEXISchema("/DataStore/DataStore.xsd", getClass(),
				m_compilerErrors);
		Assert.assertEquals(0, m_compilerErrors.getTotalCount());
		GrammarCache grammarCache = new GrammarCache(corpus, GrammarOptions.STRICT_OPTIONS);
		String[] base64Values100 = { "R0lGODdhWALCov////T09M7Ozqampn19fVZWVi0tLQUFBSxYAsJAA/8Iutz+MMpJq7046827/2Ao\n",
				"/9j/4BBKRklGAQEBASwBLP/hGlZFeGlmTU0qF5ZOSUtPTiBDT1JQT1JBVElPTk5J",
				"R0lGODlhHh73KSkpOTk5QkJCSkpKUlJSWlpaY2Nja2trc3Nze3t7hISEjIyMlJSUnJycpaWlra2t\n"
						+ "tbW1vb29xsbGzs7O1tbW3t7e5+fn7+/v//////////8=",
				"/9j/4BBKRklGAQEBAf/bQwYEBQYFBAYGBQYHBwYIChAKCgkJChQODwwQFxQYGBc=",
				"R0lGODlhHh73M2aZzP8zMzNmM5kzzDP/M2YzZmZmmWbM",
				"/9j/4BBKRklGAQEBAf/bQwYEBQYFBAYGBQYHBwYIChAKCgkJChQODwwQFxQYGBcUFhYaHSUfGhsj\n"
						+ "HBYWICwgIyYnKSopGR8tMC0oMCUoKSj/20M=",
				"R0lGODdhWAK+ov////j4+NTU1JOTk0tLSx8fHwkJCSxYAr5AA/8IMkzjrEEmahy23SpC",
				"R0lGODdh4QIpAncJIf4aU29mdHdhcmU6IE1pY3Jvc29mdCBPZmZpY2Us4QIpAof//////8z//5n/\n",
				"R0lGODdhWAK+ov////v7++fn58DAwI6Ojl5eXjExMQMDAyxYAr5AA/8Iutz+MMpJq7046827/2Ao\n" + "jmRpnmiqPsKxvg==",
				"R0lGODdh4QIpAncJIf4aU29mdHdhcmU6IE1pY3Jvc29mdCBPZmZpY2Us4QIpAob//////8z//5n/\nzP//zMw=" };
		AlignmentType alignment = AlignmentType.bitPacked;
		Transmogrifier encoder = new Transmogrifier();
		encoder.setEXISchema(grammarCache);
		encoder.setAlignmentType(alignment);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		encoder.setOutputStream(baos);
		URL url = resolveSystemIdAsURL("/DataStore/instance/1000BinaryStore.xml");
		encoder.encode(new InputSource(url.openStream()));
		byte[] bts = baos.toByteArray();
		Scanner scanner;
		int n_texts;
		EXIDecoder decoder = new EXIDecoder(999);
		decoder.setEXISchema(grammarCache);
		decoder.setAlignmentType(alignment);
		decoder.setInputStream(new ByteArrayInputStream(bts));
		scanner = decoder.processHeader();
		EXIEvent exiEvent;
		n_texts = 0;
		while ((exiEvent = scanner.nextEvent()) != null) {
			if (exiEvent.getEventVariety() == EXIEvent.EVENT_CH) {
				int k9pjV8EG = ++n_texts % 100;
				if (k9pjV8EG == 0) {
					int TjUrEfJN = n_texts / 100;
					String expected = base64Values100[(TjUrEfJN) - 1];
					String val = exiEvent.getCharacters().makeString();
					Assert.assertEquals(expected, val);
				}
			}
		}
		Assert.assertEquals(1000, n_texts);
	}

}