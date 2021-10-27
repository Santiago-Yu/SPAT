class n23611030 {
	@Override
	public CasAssembly build() {
		try {
			prepareForBuild();
			File DBDjWrPA = casFile.getParentFile();
			DefaultCasFileReadIndexToContigLookup rDLwbJcS = new DefaultCasFileReadIndexToContigLookup();
			AbstractDefaultCasFileLookup m2bC1mIV = new DefaultReadCasFileLookup(DBDjWrPA);
			CasParser.parseOnlyMetaData(casFile,
					MultipleWrapper.createMultipleWrapper(CasFileVisitor.class, rDLwbJcS, m2bC1mIV));
			ReadWriteDirectoryFileServer OoM20Gb8 = DirectoryFileServer
					.createReadWriteDirectoryFileServer(commandLine.getOptionValue("o"));
			long JoSjaL4A = DateTimeUtils.currentTimeMillis();
			int QB28IBJl = rDLwbJcS.getNumberOfContigs();
			for (long a8jqbznp = 0; a8jqbznp < QB28IBJl; a8jqbznp++) {
				File Z8BtbQbD = OoM20Gb8.createNewDir("" + a8jqbznp);
				Command I1ylz71C = new Command(new File("fakeCommand"));
				I1ylz71C.setOption("-casId", "" + a8jqbznp);
				I1ylz71C.setOption("-cas", commandLine.getOptionValue("cas"));
				I1ylz71C.setOption("-o", Z8BtbQbD.getAbsolutePath());
				I1ylz71C.setOption("-tempDir", tempDir.getAbsolutePath());
				I1ylz71C.setOption("-prefix", "temp");
				if (commandLine.hasOption("useIllumina")) {
					I1ylz71C.addFlag("-useIllumina");
				}
				if (commandLine.hasOption("useClosureTrimming")) {
					I1ylz71C.addFlag("-useClosureTrimming");
				}
				if (commandLine.hasOption("trim")) {
					I1ylz71C.setOption("-trim", commandLine.getOptionValue("trim"));
				}
				if (commandLine.hasOption("trimMap")) {
					I1ylz71C.setOption("-trimMap", commandLine.getOptionValue("trimMap"));
				}
				if (commandLine.hasOption("chromat_dir")) {
					I1ylz71C.setOption("-chromat_dir", commandLine.getOptionValue("chromat_dir"));
				}
				submitSingleCasAssemblyConversion(I1ylz71C);
			}
			waitForAllAssembliesToFinish();
			int QOhxF2ln = 0;
			int oug0Qmeh = 0;
			for (int izx6qoaH = 0; izx6qoaH < QB28IBJl; izx6qoaH++) {
				File OROLaQcM = OoM20Gb8.getFile(izx6qoaH + "/temp.counts");
				Scanner lXfdIb9K = new Scanner(OROLaQcM);
				if (!lXfdIb9K.hasNextInt()) {
					throw new IllegalStateException("single assembly conversion # " + izx6qoaH + " did not complete");
				}
				QOhxF2ln += lXfdIb9K.nextInt();
				oug0Qmeh += lXfdIb9K.nextInt();
				lXfdIb9K.close();
			}
			System.out.println("num contigs =" + QOhxF2ln);
			System.out.println("num reads =" + oug0Qmeh);
			OoM20Gb8.createNewDir("edit_dir");
			OoM20Gb8.createNewDir("phd_dir");
			String BmxW10hV = commandLine.hasOption("prefix") ? commandLine.getOptionValue("prefix") : DEFAULT_PREFIX;
			OutputStream jZXnsdl4 = new FileOutputStream(OoM20Gb8.createNewFile("edit_dir/" + BmxW10hV + ".ace.1"));
			OutputStream KaqiWY7m = new FileOutputStream(OoM20Gb8.createNewFile("phd_dir/" + BmxW10hV + ".phd.ball"));
			OutputStream ZV4JovH9 = new FileOutputStream(OoM20Gb8.createNewFile(BmxW10hV + ".consensus.fasta"));
			OutputStream uGhPYG6n = new FileOutputStream(OoM20Gb8.createNewFile(BmxW10hV + ".log"));
			try {
				jZXnsdl4.write(String.format("AS %d %d%n", QOhxF2ln, oug0Qmeh).getBytes());
				for (int bbGddxB7 = 0; bbGddxB7 < QB28IBJl; bbGddxB7++) {
					InputStream Fx39btRM = OoM20Gb8.getFileAsStream(bbGddxB7 + "/temp.ace");
					IOUtils.copy(Fx39btRM, jZXnsdl4);
					InputStream dpfhuBFe = OoM20Gb8.getFileAsStream(bbGddxB7 + "/temp.phd");
					IOUtils.copy(dpfhuBFe, KaqiWY7m);
					InputStream KQQTTGJE = OoM20Gb8.getFileAsStream(bbGddxB7 + "/temp.consensus.fasta");
					IOUtils.copy(KQQTTGJE, ZV4JovH9);
					IOUtil.closeAndIgnoreErrors(Fx39btRM, dpfhuBFe, KQQTTGJE);
					File BO3T0Kf1 = OoM20Gb8.getFile(bbGddxB7 + "");
					IOUtil.recursiveDelete(BO3T0Kf1);
				}
				OoM20Gb8.createNewSymLink("../phd_dir/" + BmxW10hV + ".phd.ball", "edit_dir/phd.ball");
				if (commandLine.hasOption("chromat_dir")) {
					OoM20Gb8.createNewDir("chromat_dir");
					File Jam540iW = new File(commandLine.getOptionValue("chromat_dir"));
					for (File RbirEkf3 : Jam540iW.listFiles(new FilenameFilter() {

						@Override
						public boolean accept(File WGve9NLV, String A2iAGXBg) {
							return A2iAGXBg.endsWith(".scf");
						}
					})) {
						File LIwCEAg4 = OoM20Gb8
								.createNewFile("chromat_dir/" + FilenameUtils.getBaseName(RbirEkf3.getName()));
						FileOutputStream uhtLvcGr = new FileOutputStream(LIwCEAg4);
						InputStream rgBn6REQ = new FileInputStream(RbirEkf3);
						IOUtils.copy(rgBn6REQ, uhtLvcGr);
						IOUtil.closeAndIgnoreErrors(rgBn6REQ, uhtLvcGr);
					}
				}
				System.out.println("finished making casAssemblies");
				for (File xAOnCFQr : m2bC1mIV.getFiles()) {
					final String h1v6XOmj = xAOnCFQr.getName();
					String a931KIN4 = FilenameUtils.getExtension(h1v6XOmj);
					if (h1v6XOmj.contains("fastq")) {
						if (!OoM20Gb8.contains("solexa_dir")) {
							OoM20Gb8.createNewDir("solexa_dir");
						}
						if (OoM20Gb8.contains("solexa_dir/" + h1v6XOmj)) {
							IOUtil.delete(OoM20Gb8.getFile("solexa_dir/" + h1v6XOmj));
						}
						OoM20Gb8.createNewSymLink(xAOnCFQr.getAbsolutePath(), "solexa_dir/" + h1v6XOmj);
					} else if ("sff".equals(a931KIN4)) {
						if (!OoM20Gb8.contains("sff_dir")) {
							OoM20Gb8.createNewDir("sff_dir");
						}
						if (OoM20Gb8.contains("sff_dir/" + h1v6XOmj)) {
							IOUtil.delete(OoM20Gb8.getFile("sff_dir/" + h1v6XOmj));
						}
						OoM20Gb8.createNewSymLink(xAOnCFQr.getAbsolutePath(), "sff_dir/" + h1v6XOmj);
					}
				}
				long GedzzEjr = DateTimeUtils.currentTimeMillis();
				uGhPYG6n.write(String.format("took %s%n", new Period(GedzzEjr - JoSjaL4A)).getBytes());
			} finally {
				IOUtil.closeAndIgnoreErrors(jZXnsdl4, KaqiWY7m, ZV4JovH9, uGhPYG6n);
			}
		} catch (Exception BPIvou1A) {
			handleException(BPIvou1A);
		} finally {
			cleanup();
		}
		return null;
	}

}