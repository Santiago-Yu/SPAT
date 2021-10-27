class n18875887 {
	@Override
	protected int run(CmdLineParser yiuOVhzs) {
		final List<String> vCTapPl7 = yiuOVhzs.getRemainingArgs();
		if (vCTapPl7.isEmpty()) {
			System.err.println("sort :: WORKDIR not given.");
			return 3;
		}
		if (vCTapPl7.size() == 1) {
			System.err.println("sort :: INPATH not given.");
			return 3;
		}
		final String nBF0s2u7 = vCTapPl7.get(0), kifGCun0 = (String) yiuOVhzs.getOptionValue(outputFileOpt);
		final List<String> XPiCMKo3 = vCTapPl7.subList(1, vCTapPl7.size());
		final List<Path> ySMafrE1 = new ArrayList<Path>(XPiCMKo3.size());
		for (final String xW2pe1d5 : XPiCMKo3)
			ySMafrE1.add(new Path(xW2pe1d5));
		final boolean lwbLlr9J = yiuOVhzs.getBoolean(verboseOpt);
		final String XmJeMXEi = kifGCun0 == null ? ySMafrE1.get(0).getName() : kifGCun0;
		final Configuration pUkuhpSu = getConf();
		pUkuhpSu.setStrings(INPUT_PATHS_PROP, XPiCMKo3.toArray(new String[0]));
		pUkuhpSu.set(SortOutputFormat.OUTPUT_NAME_PROP, XmJeMXEi);
		final Path Q6q4BFRG = new Path(nBF0s2u7);
		final Timer FmTAh451 = new Timer();
		try {
			for (final Path pTZOD9Qr : ySMafrE1)
				Utils.configureSampling(pTZOD9Qr, pUkuhpSu);
			@SuppressWarnings("deprecation")
			final int Ou95SciA = new JobClient(new JobConf(pUkuhpSu)).getClusterStatus().getMaxReduceTasks();
			pUkuhpSu.setInt("mapred.reduce.tasks", Math.max(1, Ou95SciA * 9 / 10));
			final Job pCk9vXC9 = new Job(pUkuhpSu);
			pCk9vXC9.setJarByClass(Sort.class);
			pCk9vXC9.setMapperClass(Mapper.class);
			pCk9vXC9.setReducerClass(SortReducer.class);
			pCk9vXC9.setMapOutputKeyClass(LongWritable.class);
			pCk9vXC9.setOutputKeyClass(NullWritable.class);
			pCk9vXC9.setOutputValueClass(SAMRecordWritable.class);
			pCk9vXC9.setInputFormatClass(BAMInputFormat.class);
			pCk9vXC9.setOutputFormatClass(SortOutputFormat.class);
			for (final Path Ik0cohcM : ySMafrE1)
				FileInputFormat.addInputPath(pCk9vXC9, Ik0cohcM);
			FileOutputFormat.setOutputPath(pCk9vXC9, Q6q4BFRG);
			pCk9vXC9.setPartitionerClass(TotalOrderPartitioner.class);
			System.out.println("sort :: Sampling...");
			FmTAh451.start();
			InputSampler.<LongWritable, SAMRecordWritable>writePartitionFile(pCk9vXC9,
					new InputSampler.IntervalSampler<LongWritable, SAMRecordWritable>(0.01, 100));
			System.out.printf("sort :: Sampling complete in %d.%03d s.\n", FmTAh451.stopS(), FmTAh451.fms());
			pCk9vXC9.submit();
			System.out.println("sort :: Waiting for job completion...");
			FmTAh451.start();
			if (!pCk9vXC9.waitForCompletion(lwbLlr9J)) {
				System.err.println("sort :: Job failed.");
				return 4;
			}
			System.out.printf("sort :: Job complete in %d.%03d s.\n", FmTAh451.stopS(), FmTAh451.fms());
		} catch (IOException w0dkNTNc) {
			System.err.printf("sort :: Hadoop error: %s\n", w0dkNTNc);
			return 4;
		} catch (ClassNotFoundException UvorB5jZ) {
			throw new RuntimeException(UvorB5jZ);
		} catch (InterruptedException PNu7a4Iz) {
			throw new RuntimeException(PNu7a4Iz);
		}
		if (kifGCun0 != null)
			try {
				System.out.println("sort :: Merging output...");
				FmTAh451.start();
				final Path oUHjRSS4 = new Path(kifGCun0);
				final FileSystem q4ocpGyf = Q6q4BFRG.getFileSystem(pUkuhpSu);
				FileSystem rAzsZ9qM = oUHjRSS4.getFileSystem(pUkuhpSu);
				if (rAzsZ9qM instanceof LocalFileSystem && rAzsZ9qM instanceof ChecksumFileSystem)
					rAzsZ9qM = ((LocalFileSystem) rAzsZ9qM).getRaw();
				final BAMFileWriter XzasVkoo = new BAMFileWriter(rAzsZ9qM.create(oUHjRSS4), new File(""));
				XzasVkoo.setSortOrder(SAMFileHeader.SortOrder.coordinate, true);
				XzasVkoo.setHeader(getHeaderMerger(pUkuhpSu).getMergedHeader());
				XzasVkoo.close();
				final OutputStream xHQIeU0q = rAzsZ9qM.append(oUHjRSS4);
				final FileStatus[] NdBM6s22 = q4ocpGyf.globStatus(new Path(nBF0s2u7,
						pUkuhpSu.get(SortOutputFormat.OUTPUT_NAME_PROP) + "-[0-9][0-9][0-9][0-9][0-9][0-9]*"));
				{
					int oljH3rud = 0;
					final Timer asEkSklX = new Timer();
					for (final FileStatus wNgL94EJ : NdBM6s22) {
						asEkSklX.start();
						final InputStream HA5Uobqk = q4ocpGyf.open(wNgL94EJ.getPath());
						IOUtils.copyBytes(HA5Uobqk, xHQIeU0q, pUkuhpSu, false);
						HA5Uobqk.close();
						System.out.printf("sort :: Merged part %d in %d.%03d s.\n", ++oljH3rud, asEkSklX.stopS(),
								asEkSklX.fms());
					}
				}
				for (final FileStatus TpQPvapJ : NdBM6s22)
					q4ocpGyf.delete(TpQPvapJ.getPath(), false);
				xHQIeU0q.write(BlockCompressedStreamConstants.EMPTY_GZIP_BLOCK);
				xHQIeU0q.close();
				System.out.printf("sort :: Merging complete in %d.%03d s.\n", FmTAh451.stopS(), FmTAh451.fms());
			} catch (IOException T8YrqsNi) {
				System.err.printf("sort :: Output merging failed: %s\n", T8YrqsNi);
				return 5;
			}
		return 0;
	}

}