class n9530015 {
	public static void main(String[] t7a0g6k6) throws Throwable {
		Options XhcTmqrI = new Options();
		XhcTmqrI.addOption(new CommandLineOptionBuilder("cas", "cas file").isRequired(true).build());
		XhcTmqrI.addOption(
				new CommandLineOptionBuilder("o", "output directory").longName("outputDir").isRequired(true).build());
		XhcTmqrI.addOption(new CommandLineOptionBuilder("tempDir", "temp directory").build());
		XhcTmqrI.addOption(new CommandLineOptionBuilder("prefix",
				"file prefix for all generated files ( default " + DEFAULT_PREFIX + " )").build());
		XhcTmqrI.addOption(
				new CommandLineOptionBuilder("trim", "trim file in sfffile's tab delimmed trim format").build());
		XhcTmqrI.addOption(new CommandLineOptionBuilder("trimMap",
				"trim map file containing tab delimited trimmed fastX file to untrimmed counterpart").build());
		XhcTmqrI.addOption(new CommandLineOptionBuilder("chromat_dir",
				"directory of chromatograms to be converted into phd "
						+ "(it is assumed the read data for these chromatograms are in a fasta file which the .cas file knows about")
								.build());
		XhcTmqrI.addOption(new CommandLineOptionBuilder("s", "cache size ( default " + DEFAULT_CACHE_SIZE + " )")
				.longName("cache_size").build());
		XhcTmqrI.addOption(new CommandLineOptionBuilder("useIllumina",
				"any FASTQ files in this assembly are encoded in Illumina 1.3+ format (default is Sanger)").isFlag(true)
						.build());
		XhcTmqrI.addOption(new CommandLineOptionBuilder("useClosureTrimming",
				"apply additional contig trimming based on JCVI Closure rules").isFlag(true).build());
		CommandLine qo7vZFFj;
		try {
			qo7vZFFj = CommandLineUtils.parseCommandLine(XhcTmqrI, t7a0g6k6);
			int qQbQOFAD = qo7vZFFj.hasOption("s") ? Integer.parseInt(qo7vZFFj.getOptionValue("s"))
					: DEFAULT_CACHE_SIZE;
			File F9Gvxh7e = new File(qo7vZFFj.getOptionValue("cas"));
			File uxAO6Ohm = F9Gvxh7e.getParentFile();
			ReadWriteDirectoryFileServer RrWQjlrP = DirectoryFileServer
					.createReadWriteDirectoryFileServer(qo7vZFFj.getOptionValue("o"));
			String RVjMv7wH = qo7vZFFj.hasOption("prefix") ? qo7vZFFj.getOptionValue("prefix") : DEFAULT_PREFIX;
			TrimDataStore I36i2QDj;
			if (qo7vZFFj.hasOption("trim")) {
				List<TrimDataStore> MZQf2hhZ = new ArrayList<TrimDataStore>();
				final String VnJZw7Vy = qo7vZFFj.getOptionValue("trim");
				for (String AwsvEmqt : VnJZw7Vy.split(",")) {
					System.out.println("adding trim file " + AwsvEmqt);
					MZQf2hhZ.add(new DefaultTrimFileDataStore(new File(AwsvEmqt)));
				}
				I36i2QDj = MultipleDataStoreWrapper.createMultipleDataStoreWrapper(TrimDataStore.class, MZQf2hhZ);
			} else {
				I36i2QDj = TrimDataStoreUtil.EMPTY_DATASTORE;
			}
			CasTrimMap Nkoupm8z;
			if (qo7vZFFj.hasOption("trimMap")) {
				Nkoupm8z = new DefaultTrimFileCasTrimMap(new File(qo7vZFFj.getOptionValue("trimMap")));
			} else {
				Nkoupm8z = new UnTrimmedExtensionTrimMap();
			}
			boolean K1JJw9ek = qo7vZFFj.hasOption("useClosureTrimming");
			TraceDataStore<FileSangerTrace> KZijuXrQ = null;
			Map<String, File> GM3IXM8e = null;
			ReadOnlyDirectoryFileServer oiA8rqSZ = null;
			if (qo7vZFFj.hasOption("chromat_dir")) {
				oiA8rqSZ = DirectoryFileServer
						.createReadOnlyDirectoryFileServer(new File(qo7vZFFj.getOptionValue("chromat_dir")));
				KZijuXrQ = new SingleSangerTraceDirectoryFileDataStore(oiA8rqSZ, ".scf");
				GM3IXM8e = new HashMap<String, File>();
				Iterator<String> ARIAGcY8 = KZijuXrQ.getIds();
				while (ARIAGcY8.hasNext()) {
					String RbQh5TpH = ARIAGcY8.next();
					GM3IXM8e.put(RbQh5TpH, KZijuXrQ.get(RbQh5TpH).getFile());
				}
			}
			PrintWriter WgHDVss3 = new PrintWriter(new FileOutputStream(RrWQjlrP.createNewFile(RVjMv7wH + ".log")),
					true);
			PrintWriter JyFfB9GV = new PrintWriter(
					new FileOutputStream(RrWQjlrP.createNewFile(RVjMv7wH + ".consensus.fasta")), true);
			PrintWriter ztMYDDAB = new PrintWriter(
					new FileOutputStream(RrWQjlrP.createNewFile(RVjMv7wH + ".traceFiles.txt")), true);
			PrintWriter bCfMvNOU = new PrintWriter(
					new FileOutputStream(RrWQjlrP.createNewFile(RVjMv7wH + ".referenceFiles.txt")), true);
			long fvYDhtZo = System.currentTimeMillis();
			WgHDVss3.println(System.getProperty("user.dir"));
			final ReadWriteDirectoryFileServer SIkIRwiQ;
			if (!qo7vZFFj.hasOption("tempDir")) {
				SIkIRwiQ = DirectoryFileServer.createTemporaryDirectoryFileServer(DEFAULT_TEMP_DIR);
			} else {
				File Nk4G5qdV = new File(qo7vZFFj.getOptionValue("tempDir"));
				IOUtil.mkdirs(Nk4G5qdV);
				SIkIRwiQ = DirectoryFileServer.createTemporaryDirectoryFileServer(Nk4G5qdV);
			}
			try {
				if (!RrWQjlrP.contains("chromat_dir")) {
					RrWQjlrP.createNewDir("chromat_dir");
				}
				if (oiA8rqSZ != null) {
					for (File XZBtb7I4 : oiA8rqSZ) {
						String llkV3EwQ = XZBtb7I4.getName();
						OutputStream EnPqgPxV = new FileOutputStream(RrWQjlrP.createNewFile("chromat_dir/" + llkV3EwQ));
						final FileInputStream uCg1kmwb = new FileInputStream(XZBtb7I4);
						try {
							IOUtils.copy(uCg1kmwb, EnPqgPxV);
						} finally {
							IOUtils.closeQuietly(EnPqgPxV);
							IOUtils.closeQuietly(uCg1kmwb);
						}
					}
				}
				FastQQualityCodec s16T6uH3 = qo7vZFFj.hasOption("useIllumina") ? FastQQualityCodec.ILLUMINA
						: FastQQualityCodec.SANGER;
				CasDataStoreFactory bxeD8Fgw = new MultiCasDataStoreFactory(
						new H2SffCasDataStoreFactory(uxAO6Ohm, SIkIRwiQ, EmptyDataStoreFilter.INSTANCE),
						new H2FastQCasDataStoreFactory(uxAO6Ohm, Nkoupm8z, s16T6uH3, SIkIRwiQ.getRootDir()),
						new FastaCasDataStoreFactory(uxAO6Ohm, Nkoupm8z, qQbQOFAD));
				final SliceMapFactory qtM6HHPn = new LargeNoQualitySliceMapFactory();
				CasAssembly fsqjFWAU = new DefaultCasAssembly.Builder(F9Gvxh7e, bxeD8Fgw, I36i2QDj, Nkoupm8z, uxAO6Ohm)
						.build();
				System.out.println("finished making casAssemblies");
				for (File weBOWvDI : fsqjFWAU.getNuceotideFiles()) {
					ztMYDDAB.println(weBOWvDI.getAbsolutePath());
					final String CvoNTKsa = weBOWvDI.getName();
					String N8OVKJVr = FilenameUtils.getExtension(CvoNTKsa);
					if (CvoNTKsa.contains("fastq")) {
						if (!RrWQjlrP.contains("solexa_dir")) {
							RrWQjlrP.createNewDir("solexa_dir");
						}
						if (RrWQjlrP.contains("solexa_dir/" + CvoNTKsa)) {
							IOUtil.delete(RrWQjlrP.getFile("solexa_dir/" + CvoNTKsa));
						}
						RrWQjlrP.createNewSymLink(weBOWvDI.getAbsolutePath(), "solexa_dir/" + CvoNTKsa);
					} else if ("sff".equals(N8OVKJVr)) {
						if (!RrWQjlrP.contains("sff_dir")) {
							RrWQjlrP.createNewDir("sff_dir");
						}
						if (RrWQjlrP.contains("sff_dir/" + CvoNTKsa)) {
							IOUtil.delete(RrWQjlrP.getFile("sff_dir/" + CvoNTKsa));
						}
						RrWQjlrP.createNewSymLink(weBOWvDI.getAbsolutePath(), "sff_dir/" + CvoNTKsa);
					}
				}
				for (File uGYCsQod : fsqjFWAU.getReferenceFiles()) {
					bCfMvNOU.println(uGYCsQod.getAbsolutePath());
				}
				DataStore<CasContig> nl4BtuIM = fsqjFWAU.getContigDataStore();
				Map<String, AceContig> qMutUKGr = new HashMap<String, AceContig>();
				CasIdLookup eMDawYic = GM3IXM8e == null ? fsqjFWAU.getReadIdLookup()
						: new DifferentFileCasIdLookupAdapter(fsqjFWAU.getReadIdLookup(), GM3IXM8e);
				Date Jkiqwt8L = new Date(fvYDhtZo);
				NextGenClosureAceContigTrimmer stCtLais = null;
				if (K1JJw9ek) {
					stCtLais = new NextGenClosureAceContigTrimmer(2, 5, 10);
				}
				for (CasContig PYbxLJ0L : nl4BtuIM) {
					final AceContigAdapter vNH0PM2B = new AceContigAdapter(PYbxLJ0L, Jkiqwt8L, eMDawYic);
					CoverageMap<CoverageRegion<AcePlacedRead>> WjFVSVSo = DefaultCoverageMap.buildCoverageMap(vNH0PM2B);
					for (AceContig eUkAYeWa : ConsedUtil.split0xContig(vNH0PM2B, WjFVSVSo)) {
						if (K1JJw9ek) {
							AceContig EFjy3UCl = stCtLais.trimContig(eUkAYeWa);
							if (EFjy3UCl == null) {
								System.out.printf("%s was completely trimmed... skipping%n", eUkAYeWa.getId());
								continue;
							}
							eUkAYeWa = EFjy3UCl;
						}
						qMutUKGr.put(eUkAYeWa.getId(), eUkAYeWa);
						JyFfB9GV.print(new DefaultNucleotideEncodedSequenceFastaRecord(eUkAYeWa.getId(), NucleotideGlyph
								.convertToString(NucleotideGlyph.convertToUngapped(eUkAYeWa.getConsensus().decode()))));
					}
				}
				System.out.printf("finished adapting %d casAssemblies into %d ace contigs%n", nl4BtuIM.size(),
						qMutUKGr.size());
				QualityDataStore sIO2Mtsm = KZijuXrQ == null ? fsqjFWAU.getQualityDataStore()
						: MultipleDataStoreWrapper.createMultipleDataStoreWrapper(QualityDataStore.class,
								TraceQualityDataStoreAdapter.adapt(KZijuXrQ), fsqjFWAU.getQualityDataStore());
				final DateTime xueiNekQ = new DateTime(Jkiqwt8L);
				final PhdDataStore pktcd6qi = CachedDataStore.createCachedDataStore(PhdDataStore.class,
						new ArtificalPhdDataStore(fsqjFWAU.getNucleotideDataStore(), sIO2Mtsm, xueiNekQ), qQbQOFAD);
				final PhdDataStore krvs3zR9 = KZijuXrQ == null ? pktcd6qi
						: MultipleDataStoreWrapper.createMultipleDataStoreWrapper(PhdDataStore.class,
								new PhdSangerTraceDataStoreAdapter<FileSangerTrace>(KZijuXrQ, xueiNekQ), pktcd6qi);
				WholeAssemblyAceTag kwbYM2Tr = new DefaultWholeAssemblyAceTag("phdball", "cas2consed",
						new Date(DateTimeUtils.currentTimeMillis()), "../phd_dir/" + RVjMv7wH + ".phd.ball");
				AceAssembly DyCX7YjO = new DefaultAceAssembly<AceContig>(new SimpleDataStore<AceContig>(qMutUKGr),
						krvs3zR9, Collections.<File>emptyList(),
						new DefaultAceTagMap(Collections.<ConsensusAceTag>emptyList(),
								Collections.<ReadAceTag>emptyList(), Arrays.asList(kwbYM2Tr)));
				System.out.println("writing consed package...");
				ConsedWriter.writeConsedPackage(DyCX7YjO, qtM6HHPn, RrWQjlrP.getRootDir(), RVjMv7wH, false);
			} catch (Throwable fKS4GmLZ) {
				fKS4GmLZ.printStackTrace(WgHDVss3);
				throw fKS4GmLZ;
			} finally {
				long YVxWd1iL = System.currentTimeMillis();
				WgHDVss3.printf("took %s%n", new Period(YVxWd1iL - fvYDhtZo));
				WgHDVss3.flush();
				WgHDVss3.close();
				RrWQjlrP.close();
				JyFfB9GV.close();
				ztMYDDAB.close();
				bCfMvNOU.close();
				I36i2QDj.close();
			}
		} catch (ParseException ZucCyhyS) {
			printHelp(XhcTmqrI);
			System.exit(1);
		}
	}

}