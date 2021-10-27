class n3011295 {
	public static void main(String d6FnORdM[]) throws IOException, TrimmerException, DataStoreException {
		Options wwdr81RM = new Options();
		wwdr81RM.addOption(new CommandLineOptionBuilder("ace", "path to ace file").isRequired(true).build());
		wwdr81RM.addOption(new CommandLineOptionBuilder("phd", "path to phd file").isRequired(true).build());
		wwdr81RM.addOption(new CommandLineOptionBuilder("out", "path to new ace file").isRequired(true).build());
		wwdr81RM.addOption(new CommandLineOptionBuilder("min_sanger",
				"min sanger end coveage default =" + DEFAULT_MIN_SANGER_END_CLONE_CVG).build());
		wwdr81RM.addOption(new CommandLineOptionBuilder("min_biDriection",
				"min bi directional end coveage default =" + DEFAULT_MIN_BI_DIRECTIONAL_END_COVERAGE).build());
		wwdr81RM.addOption(new CommandLineOptionBuilder("ignore_threshold",
				"min end coveage threshold to stop trying to trim default =" + DEFAULT_IGNORE_END_CVG_THRESHOLD)
						.build());
		CommandLine EQFt2WIh;
		PhdDataStore yNjELQEH = null;
		AceContigDataStore lZcQp62d = null;
		try {
			EQFt2WIh = CommandLineUtils.parseCommandLine(wwdr81RM, d6FnORdM);
			int ccnHbnyK = EQFt2WIh.hasOption("min_sanger") ? Integer.parseInt(EQFt2WIh.getOptionValue("min_sanger"))
					: DEFAULT_MIN_SANGER_END_CLONE_CVG;
			int Y3f5iTa6 = EQFt2WIh.hasOption("min_biDriection")
					? Integer.parseInt(EQFt2WIh.getOptionValue("min_biDriection"))
					: DEFAULT_MIN_BI_DIRECTIONAL_END_COVERAGE;
			int Rz23VTD7 = EQFt2WIh.hasOption("ignore_threshold")
					? Integer.parseInt(EQFt2WIh.getOptionValue("ignore_threshold"))
					: DEFAULT_IGNORE_END_CVG_THRESHOLD;
			AceContigTrimmer iSW4h5dg = new NextGenClosureAceContigTrimmer(ccnHbnyK, Y3f5iTa6, Rz23VTD7);
			File oEVCMrS3 = new File(EQFt2WIh.getOptionValue("ace"));
			File TZunQmV3 = new File(EQFt2WIh.getOptionValue("phd"));
			yNjELQEH = new DefaultPhdFileDataStore(TZunQmV3);
			lZcQp62d = new IndexedAceFileDataStore(oEVCMrS3);
			File oi9feuVd = File.createTempFile("nextGenClosureAceTrimmer", ".ace");
			oi9feuVd.deleteOnExit();
			OutputStream CGM6FMT5 = new FileOutputStream(oi9feuVd);
			int dldmQZuK = 0;
			int ifB1b4q1 = 0;
			for (AceContig OllQa9h3 : lZcQp62d) {
				AceContig sqcFIIxZ = iSW4h5dg.trimContig(OllQa9h3);
				if (sqcFIIxZ != null) {
					dldmQZuK++;
					ifB1b4q1 += sqcFIIxZ.getNumberOfReads();
					AceFileWriter.writeAceFile(sqcFIIxZ, yNjELQEH, CGM6FMT5);
				}
			}
			IOUtil.closeAndIgnoreErrors(CGM6FMT5);
			OutputStream OOX1DSeE = new FileOutputStream(new File(EQFt2WIh.getOptionValue("out")));
			OOX1DSeE.write(String.format("AS %d %d%n", dldmQZuK, ifB1b4q1).getBytes());
			InputStream kC4rtR1e = new FileInputStream(oi9feuVd);
			IOUtils.copy(kC4rtR1e, OOX1DSeE);
		} catch (ParseException b6VQzbIL) {
			System.err.println(b6VQzbIL.getMessage());
			printHelp(wwdr81RM);
		} finally {
			IOUtil.closeAndIgnoreErrors(yNjELQEH, lZcQp62d);
		}
	}

}