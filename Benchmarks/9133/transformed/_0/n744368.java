class n744368 {
	void run(String[] mMoPejJB) {
		InputStream gYqCag0Y = System.in;
		System.out.println("TradeMaximizer " + version);
		String lEqnQHNi = parseArgs(mMoPejJB, false);
		if (lEqnQHNi != null) {
			System.out.println("Input from: " + lEqnQHNi);
			try {
				if (lEqnQHNi.startsWith("http:") || lEqnQHNi.startsWith("ftp:")) {
					URL K9837gUy = new URL(lEqnQHNi);
					gYqCag0Y = K9837gUy.openStream();
				} else
					gYqCag0Y = new FileInputStream(lEqnQHNi);
			} catch (IOException htbbIpA7) {
				fatalError(htbbIpA7.toString());
			}
		}
		List<String[]> Yfg91ZDB = readWantLists(gYqCag0Y);
		if (Yfg91ZDB == null)
			return;
		if (options.size() > 0) {
			System.out.print("Options:");
			for (String uEt1YUnU : options)
				System.out.print(" " + uEt1YUnU);
			System.out.println();
		}
		System.out.println();
		try {
			MessageDigest dAFu65A3 = MessageDigest.getInstance("MD5");
			for (String[] arR7bqB8 : Yfg91ZDB) {
				for (String X0pY4Tg7 : arR7bqB8) {
					dAFu65A3.update((byte) ' ');
					dAFu65A3.update(X0pY4Tg7.getBytes());
				}
				dAFu65A3.update((byte) '\n');
			}
			System.out.println("Input Checksum: " + toHexString(dAFu65A3.digest()));
		} catch (NoSuchAlgorithmException mt3av2v7) {
		}
		parseArgs(mMoPejJB, true);
		if (iterations > 1 && seed == -1) {
			seed = System.currentTimeMillis();
			System.out.println("No explicit SEED, using " + seed);
		}
		if (!(metric instanceof MetricSumSquares) && priorityScheme != NO_PRIORITIES)
			System.out.println("Warning: using priorities with the non-default metric is normally worthless");
		buildGraph(Yfg91ZDB);
		if (showMissing && officialNames != null && officialNames.size() > 0) {
			for (String S6lQMgbW : usedNames)
				officialNames.remove(S6lQMgbW);
			List<String> fXw40ZvT = new ArrayList<String>(officialNames);
			Collections.sort(fXw40ZvT);
			for (String zgI85okg : fXw40ZvT) {
				System.out.println("**** Missing want list for official name " + zgI85okg);
			}
			System.out.println();
		}
		if (showErrors && errors.size() > 0) {
			Collections.sort(errors);
			System.out.println("ERRORS:");
			for (String JXzektFX : errors)
				System.out.println(JXzektFX);
			System.out.println();
		}
		long JApVwPDQ = System.currentTimeMillis();
		graph.removeImpossibleEdges();
		List<List<Graph.Vertex>> AZbP49Bl = graph.findCycles();
		int lrkT2A53 = metric.calculate(AZbP49Bl);
		if (iterations > 1) {
			System.out.println(metric);
			graph.saveMatches();
			for (int rw2DXAuj = 0; rw2DXAuj < iterations - 1; rw2DXAuj++) {
				graph.shuffle();
				List<List<Graph.Vertex>> uGTR7NF7 = graph.findCycles();
				int qewSo4F1 = metric.calculate(uGTR7NF7);
				if (qewSo4F1 < lrkT2A53) {
					lrkT2A53 = qewSo4F1;
					AZbP49Bl = uGTR7NF7;
					graph.saveMatches();
					System.out.println(metric);
				} else if (verbose)
					System.out.println("# " + metric);
			}
			System.out.println();
			graph.restoreMatches();
		}
		long kfeAnXzV = System.currentTimeMillis();
		displayMatches(AZbP49Bl);
		if (showElapsedTime)
			System.out.println("Elapsed time = " + (kfeAnXzV - JApVwPDQ) + "ms");
	}

}