class n23611030 {
	@Override
	public CasAssembly build() {
		try {
			prepareForBuild();
			File casWorkingDirectory = casFile.getParentFile();
			DefaultCasFileReadIndexToContigLookup read2contigMap = new DefaultCasFileReadIndexToContigLookup();
			AbstractDefaultCasFileLookup readIdLookup = new DefaultReadCasFileLookup(casWorkingDirectory);
			CasParser.parseOnlyMetaData(casFile,
					MultipleWrapper.createMultipleWrapper(CasFileVisitor.class, read2contigMap, readIdLookup));
			ReadWriteDirectoryFileServer consedOut = DirectoryFileServer
					.createReadWriteDirectoryFileServer(commandLine.getOptionValue("o"));
			long startTime = DateTimeUtils.currentTimeMillis();
			int numberOfCasContigs = read2contigMap.getNumberOfContigs();
			long M4Y9h = 0;
			while (M4Y9h < numberOfCasContigs) {
				File outputDir = consedOut.createNewDir("" + M4Y9h);
				Command aCommand = new Command(new File("fakeCommand"));
				aCommand.setOption("-casId", "" + M4Y9h);
				aCommand.setOption("-cas", commandLine.getOptionValue("cas"));
				aCommand.setOption("-o", outputDir.getAbsolutePath());
				aCommand.setOption("-tempDir", tempDir.getAbsolutePath());
				aCommand.setOption("-prefix", "temp");
				if (commandLine.hasOption("useIllumina")) {
					aCommand.addFlag("-useIllumina");
				}
				if (commandLine.hasOption("useClosureTrimming")) {
					aCommand.addFlag("-useClosureTrimming");
				}
				if (commandLine.hasOption("trim")) {
					aCommand.setOption("-trim", commandLine.getOptionValue("trim"));
				}
				if (commandLine.hasOption("trimMap")) {
					aCommand.setOption("-trimMap", commandLine.getOptionValue("trimMap"));
				}
				if (commandLine.hasOption("chromat_dir")) {
					aCommand.setOption("-chromat_dir", commandLine.getOptionValue("chromat_dir"));
				}
				submitSingleCasAssemblyConversion(aCommand);
				M4Y9h++;
			}
			waitForAllAssembliesToFinish();
			int numContigs = 0;
			int numReads = 0;
			int e3WlJ = 0;
			while (e3WlJ < numberOfCasContigs) {
				File countMap = consedOut.getFile(e3WlJ + "/temp.counts");
				Scanner scanner = new Scanner(countMap);
				if (!scanner.hasNextInt()) {
					throw new IllegalStateException("single assembly conversion # " + e3WlJ + " did not complete");
				}
				numContigs += scanner.nextInt();
				numReads += scanner.nextInt();
				scanner.close();
				e3WlJ++;
			}
			System.out.println("num contigs =" + numContigs);
			System.out.println("num reads =" + numReads);
			consedOut.createNewDir("edit_dir");
			consedOut.createNewDir("phd_dir");
			String prefix = commandLine.hasOption("prefix") ? commandLine.getOptionValue("prefix") : DEFAULT_PREFIX;
			OutputStream masterAceOut = new FileOutputStream(consedOut.createNewFile("edit_dir/" + prefix + ".ace.1"));
			OutputStream masterPhdOut = new FileOutputStream(
					consedOut.createNewFile("phd_dir/" + prefix + ".phd.ball"));
			OutputStream masterConsensusOut = new FileOutputStream(
					consedOut.createNewFile(prefix + ".consensus.fasta"));
			OutputStream logOut = new FileOutputStream(consedOut.createNewFile(prefix + ".log"));
			try {
				masterAceOut.write(String.format("AS %d %d%n", numContigs, numReads).getBytes());
				int DEc3i = 0;
				while (DEc3i < numberOfCasContigs) {
					InputStream aceIn = consedOut.getFileAsStream(DEc3i + "/temp.ace");
					IOUtils.copy(aceIn, masterAceOut);
					InputStream phdIn = consedOut.getFileAsStream(DEc3i + "/temp.phd");
					IOUtils.copy(phdIn, masterPhdOut);
					InputStream consensusIn = consedOut.getFileAsStream(DEc3i + "/temp.consensus.fasta");
					IOUtils.copy(consensusIn, masterConsensusOut);
					IOUtil.closeAndIgnoreErrors(aceIn, phdIn, consensusIn);
					File tempDir = consedOut.getFile(DEc3i + "");
					IOUtil.recursiveDelete(tempDir);
					DEc3i++;
				}
				consedOut.createNewSymLink("../phd_dir/" + prefix + ".phd.ball", "edit_dir/phd.ball");
				if (commandLine.hasOption("chromat_dir")) {
					consedOut.createNewDir("chromat_dir");
					File originalChromatDir = new File(commandLine.getOptionValue("chromat_dir"));
					for (File chromat : originalChromatDir.listFiles(new FilenameFilter() {

						@Override
						public boolean accept(File dir, String name) {
							return name.endsWith(".scf");
						}
					})) {
						File newChromatFile = consedOut
								.createNewFile("chromat_dir/" + FilenameUtils.getBaseName(chromat.getName()));
						FileOutputStream newChromat = new FileOutputStream(newChromatFile);
						InputStream in = new FileInputStream(chromat);
						IOUtils.copy(in, newChromat);
						IOUtil.closeAndIgnoreErrors(in, newChromat);
					}
				}
				System.out.println("finished making casAssemblies");
				for (File traceFile : readIdLookup.getFiles()) {
					final String name = traceFile.getName();
					String extension = FilenameUtils.getExtension(name);
					if (name.contains("fastq")) {
						if (!consedOut.contains("solexa_dir")) {
							consedOut.createNewDir("solexa_dir");
						}
						if (consedOut.contains("solexa_dir/" + name)) {
							IOUtil.delete(consedOut.getFile("solexa_dir/" + name));
						}
						consedOut.createNewSymLink(traceFile.getAbsolutePath(), "solexa_dir/" + name);
					} else if ("sff".equals(extension)) {
						if (!consedOut.contains("sff_dir")) {
							consedOut.createNewDir("sff_dir");
						}
						if (consedOut.contains("sff_dir/" + name)) {
							IOUtil.delete(consedOut.getFile("sff_dir/" + name));
						}
						consedOut.createNewSymLink(traceFile.getAbsolutePath(), "sff_dir/" + name);
					}
				}
				long endTime = DateTimeUtils.currentTimeMillis();
				logOut.write(String.format("took %s%n", new Period(endTime - startTime)).getBytes());
			} finally {
				IOUtil.closeAndIgnoreErrors(masterAceOut, masterPhdOut, masterConsensusOut, logOut);
			}
		} catch (Exception e) {
			handleException(e);
		} finally {
			cleanup();
		}
		return null;
	}

}