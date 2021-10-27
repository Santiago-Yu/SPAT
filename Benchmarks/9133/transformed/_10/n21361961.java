class n21361961 {
	private void transform(CommandLine commandLine) throws IOException {
		Reader reader;
		Writer writer;
		if (commandLine.hasOption('i')) {
			reader = createFileReader(commandLine.getOptionValue('i'));
		} else {
			reader = createStandardInputReader();
		}
		if (commandLine.hasOption('o')) {
			writer = createFileWriter(commandLine.getOptionValue('o'));
		} else {
			writer = createStandardOutputWriter();
		}
		String mapRule = commandLine.getOptionValue("m");
		try {
			Map<String, Object> parameterMap = new HashMap<String, Object>();
			SrxTransformer transformer = new SrxAnyTransformer();
			if (mapRule != null) {
				parameterMap.put(Srx1Transformer.MAP_RULE_NAME, mapRule);
			}
			transformer.transform(reader, writer, parameterMap);
		} finally {
			cleanupReader(reader);
			cleanupWriter(writer);
		}
	}

}