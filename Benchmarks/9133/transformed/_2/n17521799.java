class n17521799 {
	public void testRead() throws ParserConfigurationException, SAXException, ParseException, IOException {
		InputStream in = getConfStream();
		LogDistiller ld = dOMConfigurator.read(in);
		in.close();
		checkLogDistiller(ld);
		File tmp = File.createTempFile("logdistiller", "test");
		tmp.delete();
		tmp.mkdir();
		URL url = WeblogicLogEvent.class.getResource("wldomain7.log");
		in = url.openStream();
		assertNotNull("load resource wldomain7.log", in);
		Reader reader = new InputStreamReader(in);
		ld.getOutput().setDirectory(tmp.getAbsolutePath());
		LogDistillation exec = new LogDistillation(ld);
		LogEvent.Factory factory = exec.getLogTypeDescription().newFactory(reader, url.toString());
		exec.begin();
		LogEvent le;
		for (; (le = factory.nextEvent()) != null;) {
			exec.processLogEvent(le);
		}
		exec.end();
		in.close();
		assertEquals("number of logevents processed", 21, exec.getEventCount());
		final int[] groupEventCount = { 6, 6, 1, 4, 9, 7 };
		for (int i = 0; i < 6; i++) {
			LogDistillation.Group g = exec.getGroups()[i];
			LogDistiller.Group def = g.getDefinition();
			assertEquals("number of logevents in group[id='" + def.getId() + "']", groupEventCount[i],
					g.getEventCount());
		}
	}

}