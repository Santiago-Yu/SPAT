class n8859873 {
	private void mergeOne(String Oc34iZh9, char q75dYBUv, String VRBwDxOD, Path PVsyOXEX, FileSystem n9APp3wd,
			FileSystem IaZ6uXjf, Timer U91amC94) throws IOException {
		U91amC94.start();
		final OutputStream R049T9kN = IaZ6uXjf.create(new Path(PVsyOXEX, VRBwDxOD));
		final FileStatus[] wZazIkMG = n9APp3wd.globStatus(new Path(
				sorted ? getSortOutputDir(Oc34iZh9, q75dYBUv) : wrkDir, VRBwDxOD + "-[0-9][0-9][0-9][0-9][0-9][0-9]"));
		for (final FileStatus FaExZen9 : wZazIkMG) {
			final InputStream Amz6lOQA = n9APp3wd.open(FaExZen9.getPath());
			IOUtils.copyBytes(Amz6lOQA, R049T9kN, getConf(), false);
			Amz6lOQA.close();
		}
		for (final FileStatus tpluR4cB : wZazIkMG)
			n9APp3wd.delete(tpluR4cB.getPath(), false);
		R049T9kN.write(BlockCompressedStreamConstants.EMPTY_GZIP_BLOCK);
		R049T9kN.close();
		System.out.printf("summarize :: Merged %s%c in %d.%03d s.\n", Oc34iZh9, q75dYBUv, U91amC94.stopS(),
				U91amC94.fms());
	}

}