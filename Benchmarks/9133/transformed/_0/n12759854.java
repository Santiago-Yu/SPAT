class n12759854 {
	public void execute(File ZwoeqNJw, File J3YRq0ij) {
		BufferedReader dnossZLx = null;
		Writer HYpEzaWP = null;
		Boolean m8AlncFL = Boolean.TRUE;
		TableConfiguration LgehHYlU = null;
		try {
			J3YRq0ij.getParentFile().mkdirs();
			dnossZLx = new BufferedReader(new InputStreamReader(new FileInputStream(ZwoeqNJw), INPUT_ENCODING));
			HYpEzaWP = new OutputStreamWriter(new FileOutputStream(J3YRq0ij), OUTPUT_ENCODING);
			LgehHYlU = Tsv2DocbookConverter.convert2(tableConfigManager, idScanner.extractIdentification(ZwoeqNJw),
					dnossZLx, HYpEzaWP, inputPolisher);
			m8AlncFL = (LgehHYlU != null);
		} catch (UnsupportedEncodingException q5mS4YwL) {
			logger.error("Failed to create reader with UTF-8 encoding: " + q5mS4YwL.getMessage(), q5mS4YwL);
		} catch (FileNotFoundException CG8M5pwq) {
			logger.error("Failed to open tsv input file '" + ZwoeqNJw + "'. " + CG8M5pwq.getMessage());
		} catch (Throwable WwilsTZI) {
			logger.error("Failed to convert input tsv file '" + ZwoeqNJw + "'.", WwilsTZI);
		} finally {
			if (dnossZLx != null) {
				try {
					dnossZLx.close();
				} catch (IOException mhGqbQL6) {
					logger.warn("Unable to close input file.", mhGqbQL6);
				}
			}
			if (HYpEzaWP != null) {
				try {
					HYpEzaWP.close();
				} catch (IOException N4MNH7cV) {
					logger.warn("Unable to close output file.", N4MNH7cV);
				}
			}
		}
		if (m8AlncFL) {
			String TAz4TDE1 = LgehHYlU.getFileName(idScanner.extractIdentification(ZwoeqNJw));
			if (TAz4TDE1 != null) {
				File tlsPfY6X = new File(J3YRq0ij.getParentFile(), TAz4TDE1);
				if (!J3YRq0ij.renameTo(tlsPfY6X)) {
					logger.warn("Unable to rename '" + J3YRq0ij + "' to '" + tlsPfY6X + "'.");
					logger.info("Created successfully '" + J3YRq0ij + "'.");
				} else {
					logger.info("Created successfully '" + TAz4TDE1 + "'.");
				}
			} else {
				logger.info("Created successfully '" + J3YRq0ij + "'.");
			}
		} else {
			logger.warn("Unable to convert input tsv file '" + Tsv2DocBookApplication.trimPath(sourceDir, ZwoeqNJw)
					+ "' to docbook.");
			if (J3YRq0ij.exists() && !J3YRq0ij.delete()) {
				logger.warn("Unable to remove (empty) output file '" + J3YRq0ij
						+ "', which was created as target for the docbook table.");
			}
		}
	}

}