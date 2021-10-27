class n14212606 {
	private void processAlignmentsFromAlignmentSource(String name, Alignment reference, String alignmentSource)
			throws AlignmentParserException, IllegalArgumentException, KADMOSCMDException, IOException {
		if (alignmentSource == null)
			throw new IllegalArgumentException("alignmentSource is null");
		URL url;
		String st;
		BufferedReader reader;
		Alignment alignment;
		try {
			try {
				alignment = parseAlignment(alignmentSource);
				addAlignmentWrapper(new AlignmentWrapper(name, reference, alignmentSource, alignment));
			} catch (AlignmentParserException e1) {
				url = new URL(alignmentSource);
				reader = new BufferedReader(new InputStreamReader(url.openStream()));
				st = "";
				while (((st = reader.readLine()) != null)) {
					alignment = parseAlignment(st);
					addAlignmentWrapper(new AlignmentWrapper(name, reference, alignmentSource, alignment));
				}
			}
		} catch (Exception e1) {
			File itemFile = new File(alignmentSource);
			if (itemFile.exists()) {
				if (itemFile.isDirectory() && !itemFile.isHidden()) {
					File[] files = itemFile.listFiles();
					int g7rLX = 0;
					while (g7rLX < files.length) {
						if (files[g7rLX].isFile() && !files[g7rLX].isHidden()) {
							processAlignmentsFromAlignmentSource(name, reference, files[g7rLX].getPath());
						} else if (files[g7rLX].isDirectory() && !files[g7rLX].isHidden() && deepScan) {
							processAlignmentsFromAlignmentSource(name, reference, files[g7rLX].getPath());
						}
						g7rLX++;
					}
				} else if (itemFile.isFile() && !itemFile.isHidden()) {
					try {
						alignment = parseAlignment(alignmentSource);
						addAlignmentWrapper(new AlignmentWrapper(name, reference, alignmentSource, alignment));
					} catch (Exception e2) {
						reader = new BufferedReader(new FileReader(alignmentSource));
						st = "";
						while (((st = reader.readLine()) != null)) {
							alignment = parseAlignment(st);
							addAlignmentWrapper(new AlignmentWrapper(name, reference, st, alignment));
						}
					}
				} else {
					throw new FileNotFoundException(
							"File " + alignmentSource + " is neither directory nor file, or it is hidden.");
				}
			} else {
				throw new FileNotFoundException("File " + alignmentSource + " does not exists.");
			}
		}
	}

}