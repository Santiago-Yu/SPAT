class n17551920 {
	@Override
	public void execute() throws ProcessorExecutionException {
		try {
			if (getSource().getPaths() == null || getSource().getPaths().size() == 0
					|| getDestination().getPaths() == null || getDestination().getPaths().size() == 0) {
				throw new ProcessorExecutionException("No input and/or output paths specified.");
			}
			String gy120EMF = getDestination().getPath().getParent().toString() + "/bcc_"
					+ getDestination().getPath().getName() + "_";
			SequenceTempDirMgr qUjhNMFs = new SequenceTempDirMgr(gy120EMF, context);
			qUjhNMFs.setSeqNum(0);
			Path tj16vPsp;
			System.out.println("++++++>" + qUjhNMFs.getSeqNum() + ": Transform input to AdjSetVertex");
			Transformer rj66gyUZ = new OutAdjVertex2AdjSetVertexTransformer();
			rj66gyUZ.setConf(context);
			rj66gyUZ.setSrcPath(getSource().getPath());
			tj16vPsp = qUjhNMFs.getTempDir();
			rj66gyUZ.setDestPath(tj16vPsp);
			rj66gyUZ.setMapperNum(getMapperNum());
			rj66gyUZ.setReducerNum(getReducerNum());
			rj66gyUZ.execute();
			System.out.println("++++++>" + qUjhNMFs.getSeqNum() + ": Transform input to LabeledAdjSetVertex");
			Vertex2LabeledTransformer gONthnUW = new Vertex2LabeledTransformer();
			gONthnUW.setConf(context);
			gONthnUW.setSrcPath(tj16vPsp);
			tj16vPsp = qUjhNMFs.getTempDir();
			gONthnUW.setDestPath(tj16vPsp);
			gONthnUW.setMapperNum(getMapperNum());
			gONthnUW.setReducerNum(getReducerNum());
			gONthnUW.setOutputValueClass(LabeledAdjSetVertex.class);
			gONthnUW.execute();
			Graph AWZVpUyp;
			Graph hJ9ceSpt;
			Path LlDr6H1m = tj16vPsp;
			System.out.println("++++++>" + qUjhNMFs.getSeqNum() + ": SpanningTreeRootChoose");
			AWZVpUyp = new Graph(Graph.defaultGraph());
			AWZVpUyp.setPath(tj16vPsp);
			hJ9ceSpt = new Graph(Graph.defaultGraph());
			tj16vPsp = qUjhNMFs.getTempDir();
			hJ9ceSpt.setPath(tj16vPsp);
			GraphAlgorithm hMrvBGZg = new SpanningTreeRootChoose();
			hMrvBGZg.setConf(context);
			hMrvBGZg.setSource(AWZVpUyp);
			hMrvBGZg.setDestination(hJ9ceSpt);
			hMrvBGZg.setMapperNum(getMapperNum());
			hMrvBGZg.setReducerNum(getReducerNum());
			hMrvBGZg.execute();
			Path rYKdCqpn = new Path(tj16vPsp.toString() + "/part-00000");
			FileSystem yc2b0rJf = FileSystem.get(context);
			if (!yc2b0rJf.exists(rYKdCqpn)) {
				throw new ProcessorExecutionException("Did not find the chosen vertex in " + rYKdCqpn.toString());
			}
			FSDataInputStream I8UTNtQw = yc2b0rJf.open(rYKdCqpn);
			ByteArrayOutputStream dznlnclZ = new ByteArrayOutputStream();
			IOUtils.copyBytes(I8UTNtQw, dznlnclZ, context, false);
			String Ay2JzGJL = dznlnclZ.toString();
			String T5IMpuM8 = Ay2JzGJL.substring(SpanningTreeRootChoose.SPANNING_TREE_ROOT.length()).trim();
			I8UTNtQw.close();
			dznlnclZ.close();
			System.out.println("++++++> Chosen the root of spanning tree = " + T5IMpuM8);
			while (true) {
				System.out.println("++++++>" + qUjhNMFs.getSeqNum() + " Generate the spanning tree rooted at : ("
						+ T5IMpuM8 + ") from " + tj16vPsp);
				AWZVpUyp = new Graph(Graph.defaultGraph());
				AWZVpUyp.setPath(LlDr6H1m);
				tj16vPsp = qUjhNMFs.getTempDir();
				hJ9ceSpt = new Graph(Graph.defaultGraph());
				hJ9ceSpt.setPath(tj16vPsp);
				LlDr6H1m = tj16vPsp;
				GraphAlgorithm FKXFTHLo = new SpanningTreeGenerate();
				FKXFTHLo.setConf(context);
				FKXFTHLo.setSource(AWZVpUyp);
				FKXFTHLo.setDestination(hJ9ceSpt);
				FKXFTHLo.setMapperNum(getMapperNum());
				FKXFTHLo.setReducerNum(getReducerNum());
				FKXFTHLo.setParameter(ConstantLabels.ROOT_ID, T5IMpuM8);
				FKXFTHLo.execute();
				System.out.println("++++++>" + qUjhNMFs.getSeqNum() + " Test spanning convergence");
				AWZVpUyp = new Graph(Graph.defaultGraph());
				AWZVpUyp.setPath(tj16vPsp);
				tj16vPsp = qUjhNMFs.getTempDir();
				hJ9ceSpt = new Graph(Graph.defaultGraph());
				hJ9ceSpt.setPath(tj16vPsp);
				GraphAlgorithm SNhdYHUM = new SpanningConvergenceTest();
				SNhdYHUM.setConf(context);
				SNhdYHUM.setSource(AWZVpUyp);
				SNhdYHUM.setDestination(hJ9ceSpt);
				SNhdYHUM.setMapperNum(getMapperNum());
				SNhdYHUM.setReducerNum(getReducerNum());
				SNhdYHUM.execute();
				long tRRaO1Dd = MRConsoleReader.getMapOutputRecordNum(SNhdYHUM.getFinalStatus());
				System.out.println("++++++> number of vertexes out of the spanning tree = " + tRRaO1Dd);
				if (tRRaO1Dd == 0) {
					break;
				}
			}
			System.out.println("++++++> From spanning tree to sets of edges");
			AWZVpUyp = new Graph(Graph.defaultGraph());
			AWZVpUyp.setPath(LlDr6H1m);
			tj16vPsp = qUjhNMFs.getTempDir();
			hJ9ceSpt = new Graph(Graph.defaultGraph());
			hJ9ceSpt.setPath(tj16vPsp);
			GraphAlgorithm zESxjSGs = new Tree2EdgeSet();
			zESxjSGs.setConf(context);
			zESxjSGs.setSource(AWZVpUyp);
			zESxjSGs.setDestination(hJ9ceSpt);
			zESxjSGs.setMapperNum(getMapperNum());
			zESxjSGs.setReducerNum(getReducerNum());
			zESxjSGs.execute();
			long mLzvHQ5I = -1;
			long iwmrNYlc = -2;
			Stack<Path> YwwNOJ3Z = new Stack<Path>();
			do {
				System.out.println("++++++>" + qUjhNMFs.getSeqNum() + ": EdgeSetMinorJoin");
				GraphAlgorithm nv37BrqQ = new EdgeSetMinorJoin();
				nv37BrqQ.setConf(context);
				AWZVpUyp = new Graph(Graph.defaultGraph());
				AWZVpUyp.setPath(tj16vPsp);
				hJ9ceSpt = new Graph(Graph.defaultGraph());
				tj16vPsp = qUjhNMFs.getTempDir();
				hJ9ceSpt.setPath(tj16vPsp);
				nv37BrqQ.setSource(AWZVpUyp);
				nv37BrqQ.setDestination(hJ9ceSpt);
				nv37BrqQ.setMapperNum(getMapperNum());
				nv37BrqQ.setReducerNum(getReducerNum());
				nv37BrqQ.execute();
				YwwNOJ3Z.push(tj16vPsp);
				System.out.println("++++++>" + qUjhNMFs.getSeqNum() + ": EdgeSetJoin");
				GraphAlgorithm fUWzszrV = new EdgeSetJoin();
				fUWzszrV.setConf(context);
				AWZVpUyp = new Graph(Graph.defaultGraph());
				AWZVpUyp.setPath(tj16vPsp);
				hJ9ceSpt = new Graph(Graph.defaultGraph());
				tj16vPsp = qUjhNMFs.getTempDir();
				hJ9ceSpt.setPath(tj16vPsp);
				fUWzszrV.setSource(AWZVpUyp);
				fUWzszrV.setDestination(hJ9ceSpt);
				fUWzszrV.setMapperNum(getMapperNum());
				fUWzszrV.setReducerNum(getReducerNum());
				fUWzszrV.execute();
				mLzvHQ5I = MRConsoleReader.getMapInputRecordNum(fUWzszrV.getFinalStatus());
				iwmrNYlc = MRConsoleReader.getMapOutputRecordNum(fUWzszrV.getFinalStatus());
				System.out.println("++++++> map in/out : " + mLzvHQ5I + "/" + iwmrNYlc);
			} while (mLzvHQ5I != iwmrNYlc);
			while (YwwNOJ3Z.size() > 0) {
				System.out.println("++++++>" + qUjhNMFs.getSeqNum() + ": EdgeSetExpand");
				GraphAlgorithm rreTtlut = new EdgeSetExpand();
				rreTtlut.setConf(context);
				AWZVpUyp = new Graph(Graph.defaultGraph());
				AWZVpUyp.addPath(YwwNOJ3Z.pop());
				AWZVpUyp.addPath(tj16vPsp);
				hJ9ceSpt = new Graph(Graph.defaultGraph());
				tj16vPsp = qUjhNMFs.getTempDir();
				hJ9ceSpt.setPath(tj16vPsp);
				rreTtlut.setSource(AWZVpUyp);
				rreTtlut.setDestination(hJ9ceSpt);
				rreTtlut.setMapperNum(getMapperNum());
				rreTtlut.setReducerNum(getReducerNum());
				rreTtlut.execute();
				System.out.println("++++++>" + qUjhNMFs.getSeqNum() + ": EdgeSetMinorExpand");
				GraphAlgorithm P4g5JTfx = new EdgeSetMinorExpand();
				P4g5JTfx.setConf(context);
				AWZVpUyp = new Graph(Graph.defaultGraph());
				AWZVpUyp.setPath(tj16vPsp);
				hJ9ceSpt = new Graph(Graph.defaultGraph());
				tj16vPsp = qUjhNMFs.getTempDir();
				hJ9ceSpt.setPath(tj16vPsp);
				P4g5JTfx.setSource(AWZVpUyp);
				P4g5JTfx.setDestination(hJ9ceSpt);
				P4g5JTfx.setMapperNum(getMapperNum());
				P4g5JTfx.setReducerNum(getReducerNum());
				P4g5JTfx.execute();
			}
			System.out.println("++++++>" + qUjhNMFs.getSeqNum() + ": EdgeSetSummarize");
			GraphAlgorithm ZbWJQkDo = new EdgeSetSummarize();
			ZbWJQkDo.setConf(context);
			AWZVpUyp = new Graph(Graph.defaultGraph());
			AWZVpUyp.setPath(tj16vPsp);
			hJ9ceSpt = new Graph(Graph.defaultGraph());
			hJ9ceSpt.setPath(getDestination().getPath());
			ZbWJQkDo.setSource(AWZVpUyp);
			ZbWJQkDo.setDestination(hJ9ceSpt);
			ZbWJQkDo.setMapperNum(getMapperNum());
			ZbWJQkDo.setReducerNum(getReducerNum());
			ZbWJQkDo.execute();
			qUjhNMFs.deleteAll();
		} catch (IOException Fm9iOsID) {
			throw new ProcessorExecutionException(Fm9iOsID);
		} catch (IllegalAccessException HmubIerw) {
			throw new ProcessorExecutionException(HmubIerw);
		}
	}

}