class n7288760 {
	public void testDecode1000BinaryStore() throws Exception {
		EXISchema LH8YkUb9 = EXISchemaFactoryTestUtil.getEXISchema("/DataStore/DataStore.xsd", getClass(),
				m_compilerErrors);
		Assert.assertEquals(0, m_compilerErrors.getTotalCount());
		GrammarCache gbjOCIH0 = new GrammarCache(LH8YkUb9, GrammarOptions.STRICT_OPTIONS);
		String[] QGyORUe4 = { "R0lGODdhWALCov////T09M7Ozqampn19fVZWVi0tLQUFBSxYAsJAA/8Iutz+MMpJq7046827/2Ao\n",
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
		AlignmentType DQ7RsaNR = AlignmentType.bitPacked;
		Transmogrifier cTUZcRHY = new Transmogrifier();
		cTUZcRHY.setEXISchema(gbjOCIH0);
		cTUZcRHY.setAlignmentType(DQ7RsaNR);
		ByteArrayOutputStream PSCNIkoY = new ByteArrayOutputStream();
		cTUZcRHY.setOutputStream(PSCNIkoY);
		URL xtUfiNwQ = resolveSystemIdAsURL("/DataStore/instance/1000BinaryStore.xml");
		cTUZcRHY.encode(new InputSource(xtUfiNwQ.openStream()));
		byte[] aYfSSeDD = PSCNIkoY.toByteArray();
		Scanner u0xODnNu;
		int Cgmb2POL;
		EXIDecoder sJ0jBZqe = new EXIDecoder(999);
		sJ0jBZqe.setEXISchema(gbjOCIH0);
		sJ0jBZqe.setAlignmentType(DQ7RsaNR);
		sJ0jBZqe.setInputStream(new ByteArrayInputStream(aYfSSeDD));
		u0xODnNu = sJ0jBZqe.processHeader();
		EXIEvent gmOTwlm1;
		Cgmb2POL = 0;
		while ((gmOTwlm1 = u0xODnNu.nextEvent()) != null) {
			if (gmOTwlm1.getEventVariety() == EXIEvent.EVENT_CH) {
				if (++Cgmb2POL % 100 == 0) {
					String bupM5sOC = QGyORUe4[(Cgmb2POL / 100) - 1];
					String OsfySfHQ = gmOTwlm1.getCharacters().makeString();
					Assert.assertEquals(bupM5sOC, OsfySfHQ);
				}
			}
		}
		Assert.assertEquals(1000, Cgmb2POL);
	}

}