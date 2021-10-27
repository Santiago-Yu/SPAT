class n638175 {
	void run(String[] a9WELuam) {
		InputStream qFPjKNBa = System.in;
		System.out.println("TradeMaximizer " + version);
		String UFMPHwm0 = parseArgs(a9WELuam, false);
		if (UFMPHwm0 != null) {
			System.out.println("Input from: " + UFMPHwm0);
			try {
				if (UFMPHwm0.startsWith("http:") || UFMPHwm0.startsWith("ftp:")) {
					URL s4DHmTno = new URL(UFMPHwm0);
					qFPjKNBa = s4DHmTno.openStream();
				} else
					qFPjKNBa = new FileInputStream(UFMPHwm0);
			} catch (IOException EZ525JuB) {
				fatalError(EZ525JuB.toString());
			}
		}
		List<String[]> tULecyf7 = readWantLists(qFPjKNBa);
		if (tULecyf7 == null)
			return;
		if (options.size() > 0) {
			System.out.print("Options:");
			for (String aXVPLzya : options)
				System.out.print(" " + aXVPLzya);
			System.out.println();
		}
		System.out.println();
		try {
			MessageDigest ri7mRrbK = MessageDigest.getInstance("MD5");
			for (String[] GnKmUPEI : tULecyf7) {
				for (String BKyyCvnj : GnKmUPEI) {
					ri7mRrbK.update((byte) ' ');
					ri7mRrbK.update(BKyyCvnj.getBytes());
				}
				ri7mRrbK.update((byte) '\n');
			}
			System.out.println("Input Checksum: " + toHexString(ri7mRrbK.digest()));
		} catch (NoSuchAlgorithmException ekoAIwSX) {
		}
		parseArgs(a9WELuam, true);
		if (iterations > 1 && seed == -1) {
			seed = System.currentTimeMillis();
			System.out.println("No explicit SEED, using " + seed);
		}
		if (!(metric instanceof MetricSumSquares) && priorityScheme != NO_PRIORITIES)
			System.out.println("Warning: using priorities with the non-default metric is normally worthless");
		buildGraph(tULecyf7);
		if (showMissing && officialNames != null && officialNames.size() > 0) {
			for (String sK7dvrB4 : usedNames)
				officialNames.remove(sK7dvrB4);
			List<String> bZQmwP7h = new ArrayList<String>(officialNames);
			Collections.sort(bZQmwP7h);
			for (String UkryRklV : bZQmwP7h) {
				System.out.println("**** Missing want list for official name " + UkryRklV);
			}
			System.out.println();
		}
		if (showErrors && errors.size() > 0) {
			Collections.sort(errors);
			System.out.println("ERRORS:");
			for (String nkilJGI2 : errors)
				System.out.println(nkilJGI2);
			System.out.println();
		}
		long Ue1QAHw0 = System.currentTimeMillis();
		graph.removeImpossibleEdges();
		List<List<Graph.Vertex>> rz2itUTA = graph.findCycles();
		int jBiCMLGL = metric.calculate(rz2itUTA);
		if (iterations > 1) {
			System.out.println(metric);
			graph.saveMatches();
			for (int LGCAR1Zw = 0; LGCAR1Zw < iterations - 1; LGCAR1Zw++) {
				graph.shuffle();
				List<List<Graph.Vertex>> D3w59Jcg = graph.findCycles();
				int yiML23jG = metric.calculate(D3w59Jcg);
				if (yiML23jG < jBiCMLGL) {
					jBiCMLGL = yiML23jG;
					rz2itUTA = D3w59Jcg;
					graph.saveMatches();
					System.out.println(metric);
				} else if (verbose)
					System.out.println("# " + metric);
			}
			System.out.println();
			graph.restoreMatches();
		}
		long S80z0Vp6 = System.currentTimeMillis();
		displayMatches(rz2itUTA);
		if (showElapsedTime)
			System.out.println("Elapsed time = " + (S80z0Vp6 - Ue1QAHw0) + "ms");
	}

}