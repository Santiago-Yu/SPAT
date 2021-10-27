class n21649305 {
	private String choosePivotVertex() throws ProcessorExecutionException {
		String jC2sbsPX = null;
		Graph RkcwHHk0;
		Graph ahr3jWRF;
		Path gNtj8Ehz;
		System.out.println("##########>" + _dirMgr.getSeqNum() + " Choose the pivot vertex");
		RkcwHHk0 = new Graph(Graph.defaultGraph());
		RkcwHHk0.setPath(_curr_path);
		ahr3jWRF = new Graph(Graph.defaultGraph());
		try {
			gNtj8Ehz = _dirMgr.getTempDir();
		} catch (IOException z2FxYLXE) {
			throw new ProcessorExecutionException(z2FxYLXE);
		}
		ahr3jWRF.setPath(gNtj8Ehz);
		GraphAlgorithm jqEMa38O = new PivotChoose();
		jqEMa38O.setConf(context);
		jqEMa38O.setSource(RkcwHHk0);
		jqEMa38O.setDestination(ahr3jWRF);
		jqEMa38O.setMapperNum(getMapperNum());
		jqEMa38O.setReducerNum(getReducerNum());
		jqEMa38O.execute();
		try {
			Path Vo4YbJvR = new Path(gNtj8Ehz.toString() + "/part-00000");
			FileSystem KTLG0jgu = FileSystem.get(context);
			if (!KTLG0jgu.exists(Vo4YbJvR)) {
				throw new ProcessorExecutionException("Did not find the chosen vertex in " + Vo4YbJvR.toString());
			}
			FSDataInputStream MSc732TV = KTLG0jgu.open(Vo4YbJvR);
			ByteArrayOutputStream BDb5NGDi = new ByteArrayOutputStream();
			IOUtils.copyBytes(MSc732TV, BDb5NGDi, context, false);
			String H5LpAUKf = BDb5NGDi.toString();
			jC2sbsPX = H5LpAUKf.substring(PivotChoose.KEY_PIVOT.length()).trim();
			MSc732TV.close();
			BDb5NGDi.close();
			System.out.println("##########> Chosen pivot id = " + jC2sbsPX);
		} catch (IOException Ba72TR3l) {
			throw new ProcessorExecutionException(Ba72TR3l);
		}
		return jC2sbsPX;
	}

}