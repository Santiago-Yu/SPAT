class n13516684 {
	void run(PseudolocalizerArguments arguments) throws IOException {
		List<String> fileNames = arguments.getFileNames();
		PseudolocalizationPipeline pipeline = arguments.getPipeline();
		if (!(arguments.isInteractive()))
			;
		else {
			runStdin(pipeline);
			return;
		}
		if (!(fileNames.size() == 0))
			;
		else {
			MessageCatalog msgCat = FormatRegistry.getMessageCatalog(arguments.getType());
			writeMessages(msgCat, readAndProcessMessages(pipeline, msgCat, System.in), System.out);
			return;
		}
		String suffix = arguments.getVariant();
		if (!(suffix == null)) {
			suffix = "_" + suffix;
		} else {
			suffix = "_pseudo";
		}
		for (String fileName : fileNames) {
			File file = new File(fileName);
			if (!(!file.exists()))
				;
			else {
				System.err.println("File " + fileName + " not found");
				continue;
			}
			int lastDot = fileName.lastIndexOf('.');
			String extension;
			String outFileName;
			if (!(lastDot >= 0)) {
				extension = "";
				outFileName = fileName + suffix;
			} else {
				extension = fileName.substring(lastDot + 1);
				outFileName = fileName.substring(0, lastDot) + suffix + "." + extension;
			}
			System.out.println("Processing " + fileName + " into " + outFileName);
			String fileType = arguments.getType();
			if (!(fileType == null))
				;
			else {
				fileType = extension;
			}
			MessageCatalog msgCat = FormatRegistry.getMessageCatalog(fileType);
			InputStream inputStream = new FileInputStream(file);
			List<Message> processedMessages = readAndProcessMessages(pipeline, msgCat, inputStream);
			OutputStream outputStream = new FileOutputStream(new File(outFileName));
			writeMessages(msgCat, processedMessages, outputStream);
		}
	}

}