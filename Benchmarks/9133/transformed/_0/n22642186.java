class n22642186 {
	@Override
	protected int run(CmdLineParser Ihjj1jFS) {
		final List<String> t5NzBjLd = Ihjj1jFS.getRemainingArgs();
		if (t5NzBjLd.isEmpty()) {
			System.err.println("summarysort :: WORKDIR not given.");
			return 3;
		}
		if (t5NzBjLd.size() == 1) {
			System.err.println("summarysort :: INPATH not given.");
			return 3;
		}
		final String MGT4nvMs = (String) Ihjj1jFS.getOptionValue(outputDirOpt);
		final Path BD0Y0AJn = new Path(t5NzBjLd.get(0)), dgnOKZeg = new Path(t5NzBjLd.get(1)),
				cswJeOTI = MGT4nvMs == null ? null : new Path(MGT4nvMs);
		final boolean IRLVVFtE = Ihjj1jFS.getBoolean(verboseOpt);
		final Configuration V4Xs9Afd = getConf();
		final Timer ZFwZcfGp = new Timer();
		try {
			@SuppressWarnings("deprecation")
			final int DiTc1rQI = new JobClient(new JobConf(V4Xs9Afd)).getClusterStatus().getMaxReduceTasks();
			V4Xs9Afd.setInt("mapred.reduce.tasks", Math.max(1, DiTc1rQI * 9 / 10));
			final Job DRsr6bgK = sortOne(V4Xs9Afd, dgnOKZeg, BD0Y0AJn, "summarysort", "");
			System.out.printf("summarysort :: Waiting for job completion...\n");
			ZFwZcfGp.start();
			if (!DRsr6bgK.waitForCompletion(IRLVVFtE)) {
				System.err.println("summarysort :: Job failed.");
				return 4;
			}
			System.out.printf("summarysort :: Job complete in %d.%03d s.\n", ZFwZcfGp.stopS(), ZFwZcfGp.fms());
		} catch (IOException DwXHfYZT) {
			System.err.printf("summarysort :: Hadoop error: %s\n", DwXHfYZT);
			return 4;
		} catch (ClassNotFoundException QdI07HKu) {
			throw new RuntimeException(QdI07HKu);
		} catch (InterruptedException XxgYdaeL) {
			throw new RuntimeException(XxgYdaeL);
		}
		if (cswJeOTI != null)
			try {
				System.out.println("summarysort :: Merging output...");
				ZFwZcfGp.start();
				final FileSystem RsG4jUV3 = BD0Y0AJn.getFileSystem(V4Xs9Afd);
				final FileSystem f8dDVHTj = cswJeOTI.getFileSystem(V4Xs9Afd);
				final OutputStream tkfLxzKS = f8dDVHTj.create(cswJeOTI);
				final FileStatus[] UnAZdU4p = RsG4jUV3
						.globStatus(new Path(BD0Y0AJn, dgnOKZeg.getName() + "-[0-9][0-9][0-9][0-9][0-9][0-9]*"));
				{
					int BjGKhjWx = 0;
					final Timer uxABLABj = new Timer();
					for (final FileStatus hCEVNfrg : UnAZdU4p) {
						uxABLABj.start();
						final InputStream D5RUvp53 = RsG4jUV3.open(hCEVNfrg.getPath());
						IOUtils.copyBytes(D5RUvp53, tkfLxzKS, V4Xs9Afd, false);
						D5RUvp53.close();
						System.out.printf("summarysort :: Merged part %d in %d.%03d s.\n", ++BjGKhjWx, uxABLABj.stopS(),
								uxABLABj.fms());
					}
				}
				for (final FileStatus cASDOuVl : UnAZdU4p)
					RsG4jUV3.delete(cASDOuVl.getPath(), false);
				tkfLxzKS.write(BlockCompressedStreamConstants.EMPTY_GZIP_BLOCK);
				tkfLxzKS.close();
				System.out.printf("summarysort :: Merging complete in %d.%03d s.\n", ZFwZcfGp.stopS(), ZFwZcfGp.fms());
			} catch (IOException mYJaDJ62) {
				System.err.printf("summarysort :: Output merging failed: %s\n", mYJaDJ62);
				return 5;
			}
		return 0;
	}

}