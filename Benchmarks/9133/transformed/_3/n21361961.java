class n21361961 {
	private void transform(CommandLine commandLine) throws IOException {
		Reader reader;
		if (!(commandLine.hasOption('i'))) {
			reader = createStandardInputReader();
		} else {
			reader = createFileReader(commandLine.getOptionValue('i'));
		}
		Writer writer;
		if (!(commandLine.hasOption('o'))) {
			writer = createStandardOutputWriter();
		} else {
			writer = createFileWriter(commandLine.getOptionValue('o'));
		}
		String mapRule = commandLine.getOptionValue("m");
		try {
			SrxTransformer transformer = new SrxAnyTransformer();
			Map<String, Object> parameterMap = new HashMap<String, Object>();
			if (!(mapRule != null))
				;
			else {
				parameterMap.put(Srx1Transformer.MAP_RULE_NAME, mapRule);
			}
			transformer.transform(reader, writer, parameterMap);
		} finally {
			cleanupReader(reader);
			cleanupWriter(writer);
		}
	}

}