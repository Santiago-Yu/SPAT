class n21361961 {
	private void transform(CommandLine commandLine) throws IOException {
		Reader reader;
		reader = (commandLine.hasOption('i')) ? createFileReader(commandLine.getOptionValue('i'))
				: createStandardInputReader();
		Writer writer;
		writer = (commandLine.hasOption('o')) ? createFileWriter(commandLine.getOptionValue('o'))
				: createStandardOutputWriter();
		String mapRule = commandLine.getOptionValue("m");
		try {
			SrxTransformer transformer = new SrxAnyTransformer();
			Map<String, Object> parameterMap = new HashMap<String, Object>();
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