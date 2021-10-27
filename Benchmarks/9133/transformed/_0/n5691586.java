class n5691586 {
	public static void main(String[] ACWIIFk8) throws IOException {
		String LTqYNnHw = ACWIIFk8[0];
		BufferedReader VnwBcPBd = new BufferedReader(new FileReader(LTqYNnHw));
		String XraI7QXw = (VnwBcPBd.readLine().split("\\s+"))[0];
		String PZJObl4A = (VnwBcPBd.readLine().split("\\s+"))[0];
		String jB1W8Z7D = (VnwBcPBd.readLine().split("\\s+"))[0];
		String ceAxFk9N = (VnwBcPBd.readLine().split("\\s+"))[0];
		String yNwuZyV5 = (VnwBcPBd.readLine().split("\\s+"))[0];
		String ppPynNU7 = (VnwBcPBd.readLine().split("\\s+"))[0];
		String xLpSxjkB = (VnwBcPBd.readLine().split("\\s+"))[0];
		String NOiXn8gj = (VnwBcPBd.readLine().split("\\s+"))[0];
		String FuibY9ZH = "AlignmentGrids";
		int lFlb98QF = 1000;
		VnwBcPBd.close();
		int O6ztncEh = countLines(ceAxFk9N);
		InputStream NFSuOxnL = new FileInputStream(new File(ceAxFk9N));
		BufferedReader CFcuZMjg = new BufferedReader(new InputStreamReader(NFSuOxnL, "utf8"));
		String[] zSma4QEE = new String[O6ztncEh];
		for (int Vo3Ic999 = 0; Vo3Ic999 < O6ztncEh; ++Vo3Ic999) {
			zSma4QEE[Vo3Ic999] = CFcuZMjg.readLine();
		}
		CFcuZMjg.close();
		println("Creating src vocabulary @ " + (new Date()));
		srcVocab = new Vocabulary();
		int[] NkWT5jCV = Vocabulary.initializeVocabulary(yNwuZyV5, srcVocab, true);
		int ztXZiSsJ = NkWT5jCV[0];
		int EfboTwXD = NkWT5jCV[1];
		println("Reading src corpus @ " + (new Date()));
		srcCorpusArray = SuffixArrayFactory.createCorpusArray(yNwuZyV5, srcVocab, ztXZiSsJ, EfboTwXD);
		println("Creating src SA @ " + (new Date()));
		srcSA = SuffixArrayFactory.createSuffixArray(srcCorpusArray, lFlb98QF);
		println("Creating tgt vocabulary @ " + (new Date()));
		tgtVocab = new Vocabulary();
		int[] vqMCJfQb = Vocabulary.initializeVocabulary(ppPynNU7, tgtVocab, true);
		int gOmBYRK1 = vqMCJfQb[0];
		int hbeVFuac = vqMCJfQb[1];
		println("Reading tgt corpus @ " + (new Date()));
		tgtCorpusArray = SuffixArrayFactory.createCorpusArray(ppPynNU7, tgtVocab, gOmBYRK1, hbeVFuac);
		println("Creating tgt SA @ " + (new Date()));
		tgtSA = SuffixArrayFactory.createSuffixArray(tgtCorpusArray, lFlb98QF);
		int Gq09yoEf = srcCorpusArray.getNumSentences();
		if (Gq09yoEf != tgtCorpusArray.getNumSentences()) {
			throw new RuntimeException("Source and target corpora have different number of sentences. This is bad.");
		}
		println("Reading alignment data @ " + (new Date()));
		alignments = null;
		if ("AlignmentArray".equals(FuibY9ZH)) {
			alignments = SuffixArrayFactory.createAlignments(xLpSxjkB, srcSA, tgtSA);
		} else if ("AlignmentGrids".equals(FuibY9ZH) || "AlignmentsGrid".equals(FuibY9ZH)) {
			alignments = new AlignmentGrids(new Scanner(new File(xLpSxjkB)), srcCorpusArray, tgtCorpusArray, Gq09yoEf,
					true);
		} else if ("MemoryMappedAlignmentGrids".equals(FuibY9ZH)) {
			alignments = new MemoryMappedAlignmentGrids(xLpSxjkB, srcCorpusArray, tgtCorpusArray);
		}
		if (!fileExists(NOiXn8gj)) {
			alreadyResolved_srcSet = new HashMap<String, TreeSet<Integer>>();
			alreadyResolved_tgtSet = new HashMap<String, TreeSet<Integer>>();
		} else {
			try {
				ObjectInputStream DVRGqmNc = new ObjectInputStream(new FileInputStream(NOiXn8gj));
				alreadyResolved_srcSet = (HashMap<String, TreeSet<Integer>>) DVRGqmNc.readObject();
				alreadyResolved_tgtSet = (HashMap<String, TreeSet<Integer>>) DVRGqmNc.readObject();
				DVRGqmNc.close();
			} catch (FileNotFoundException UPAqnVyN) {
				System.err.println("FileNotFoundException in AlignCandidates.main(String[]): " + UPAqnVyN.getMessage());
				System.exit(99901);
			} catch (IOException GDxXnSgW) {
				System.err.println("IOException in AlignCandidates.main(String[]): " + GDxXnSgW.getMessage());
				System.exit(99902);
			} catch (ClassNotFoundException NHzG3dzi) {
				System.err
						.println("ClassNotFoundException in AlignCandidates.main(String[]): " + NHzG3dzi.getMessage());
				System.exit(99904);
			}
		}
		println("Processing candidates @ " + (new Date()));
		PrintWriter Lyj952Pb = new PrintWriter(PZJObl4A);
		PrintWriter MvSb8X4l = new PrintWriter(jB1W8Z7D);
		InputStream JpfOPTga = new FileInputStream(new File(XraI7QXw));
		BufferedReader IwZhlExW = new BufferedReader(new InputStreamReader(JpfOPTga, "utf8"));
		String jPTFe3MD = "";
		String ivi94UWe = "";
		jPTFe3MD = IwZhlExW.readLine();
		int pnBFKsOO = 0;
		int F9ozcBXJ = 0;
		int Bn96sfcY = 0;
		int q7neepKp = 0;
		int cSssJj8J = -1;
		String Ypknlg5z = "";
		String[] QqqqLTH1 = null;
		int F2jKOfg5 = 0;
		int oaPicEHx = 0;
		while (jPTFe3MD != null) {
			++F2jKOfg5;
			println("Read candidate on line #" + F2jKOfg5);
			int P4AenljU = toInt((jPTFe3MD.substring(0, jPTFe3MD.indexOf("|||"))).trim());
			if (P4AenljU != cSssJj8J) {
				Ypknlg5z = zSma4QEE[P4AenljU];
				QqqqLTH1 = Ypknlg5z.split("\\s+");
				cSssJj8J = P4AenljU;
				println("New value for i: " + P4AenljU + " seen @ " + (new Date()));
				oaPicEHx = 0;
			} else {
				++oaPicEHx;
			}
			jPTFe3MD = (jPTFe3MD.substring(jPTFe3MD.indexOf("|||") + 3)).trim();
			ivi94UWe = (jPTFe3MD.substring(0, jPTFe3MD.indexOf("|||"))).trim();
			ivi94UWe = ivi94UWe.substring(ivi94UWe.indexOf(" ") + 1, ivi94UWe.length() - 1);
			JoshuaDerivationTree I5UrgSlx = new JoshuaDerivationTree(ivi94UWe, 0);
			String g0hEiS7L = I5UrgSlx.toSentence();
			String[] UGpb7aYH = g0hEiS7L.split("\\s+");
			String eZrPfCb5 = I5UrgSlx.alignments();
			Lyj952Pb.println(eZrPfCb5);
			println("  i = " + P4AenljU + ", alignSrcCand: " + eZrPfCb5);
			String Mr4QS5hz = "";
			String[] CwRwA6Wf = eZrPfCb5.split("\\s+");
			for (int jI4oPJ93 = 0; jI4oPJ93 < CwRwA6Wf.length; ++jI4oPJ93) {
				String ZpKBYgyD = CwRwA6Wf[jI4oPJ93];
				if (ZpKBYgyD.indexOf(',') == -1) {
					Mr4QS5hz += " " + ZpKBYgyD.replaceFirst("--", "-");
				} else {
					Mr4QS5hz += " " + resolve(ZpKBYgyD, QqqqLTH1, UGpb7aYH);
				}
			}
			Mr4QS5hz = Mr4QS5hz.trim();
			println("  i = " + P4AenljU + ", alignSrcCand_res: " + Mr4QS5hz);
			MvSb8X4l.println(Mr4QS5hz);
			if (oaPicEHx == 50) {
				println("50C @ " + (new Date()));
				oaPicEHx = 0;
			}
			jPTFe3MD = IwZhlExW.readLine();
		}
		Lyj952Pb.close();
		MvSb8X4l.close();
		IwZhlExW.close();
		println("Finished processing candidates @ " + (new Date()));
		try {
			ObjectOutputStream fiqLSKV8 = new ObjectOutputStream(new FileOutputStream(NOiXn8gj));
			fiqLSKV8.writeObject(alreadyResolved_srcSet);
			fiqLSKV8.writeObject(alreadyResolved_tgtSet);
			fiqLSKV8.flush();
			fiqLSKV8.close();
		} catch (IOException U842Tduo) {
			System.err.println("IOException in AlignCandidates.main(String[]): " + U842Tduo.getMessage());
			System.exit(99902);
		}
	}

}