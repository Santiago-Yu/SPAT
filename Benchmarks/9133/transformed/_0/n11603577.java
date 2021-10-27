class n11603577 {
	private void analyseCorpus(final IStatusDisplayer riaaVItY) {
		final String KowMTmZk = "Distros.tmp";
		final String phaUGygs = "Symbols.tmp";
		Chunker = new EntropyChunker();
		int VZ3x6WBK = 2;
		sgOverallGraph = new SymbolicGraph(1, VZ3x6WBK);
		siIndex = new SemanticIndex(sgOverallGraph);
		try {
			siIndex.MeaningExtractor = new LocalWordNetMeaningExtractor();
		} catch (IOException YbSH0xGH) {
			siIndex.MeaningExtractor = null;
		}
		try {
			DocumentSet pcc6nnu0 = new DocumentSet(FilePathEdt.getText(), 1.0);
			pcc6nnu0.createSets(true, (double) 100 / 100);
			int jJuKbku6, ed8RPmXl;
			String s2KkRhnJ = "";
			Iterator MJdgC2Wm = pcc6nnu0.getTrainingSet().iterator();
			ed8RPmXl = pcc6nnu0.getTrainingSet().size();
			if (ed8RPmXl == 0) {
				appendToLog("No input documents.\n");
				appendToLog("======DONE=====\n");
				return;
			}
			appendToLog("Training chunker...");
			Chunker.train(pcc6nnu0.toFilenameSet(DocumentSet.FROM_WHOLE_SET));
			appendToLog("Setting delimiters...");
			setDelimiters(Chunker.getDelimiters());
			jJuKbku6 = 0;
			cdDoc = new DistributionDocument[VZ3x6WBK];
			for (int tXnCR2ZM = 0; tXnCR2ZM < VZ3x6WBK; tXnCR2ZM++)
				cdDoc[tXnCR2ZM] = new DistributionDocument(1, MinLevel + tXnCR2ZM);
			riaaVItY.setVisible(true);
			ThreadList r84M3geV = new ThreadList(Runtime.getRuntime().availableProcessors() + 1);
			appendToLog("(Pass 1/3) Loading files..." + s2KkRhnJ);
			TreeSet oOFOkUNN = new TreeSet();
			while (MJdgC2Wm.hasNext()) {
				s2KkRhnJ = ((CategorizedFileEntry) MJdgC2Wm.next()).getFileName();
				riaaVItY.setStatus("(Pass 1/3) Loading file..." + s2KkRhnJ, (double) jJuKbku6 / ed8RPmXl);
				final DistributionDocument[] hZNr42tZ = cdDoc;
				final String YgNNcksQ = s2KkRhnJ;
				for (int bzFF0CEH = 0; bzFF0CEH < cdDoc.length; bzFF0CEH++) {
					final int biSD6YTS = bzFF0CEH;
					while (!r84M3geV.addThreadFor(new Runnable() {

						public void run() {
							if (!RightToLeftText)
								hZNr42tZ[biSD6YTS].loadDataStringFromFile(YgNNcksQ, false);
							else {
								hZNr42tZ[biSD6YTS].setDataString(utils.reverseString(utils.loadFileToString(YgNNcksQ)),
										biSD6YTS, false);
							}
						}
					}))
						Thread.yield();
				}
				try {
					r84M3geV.waitUntilCompletion();
				} catch (InterruptedException Zk5Xjx9T) {
					Zk5Xjx9T.printStackTrace(System.err);
					appendToLog("Interrupted...");
					sgOverallGraph.removeNotificationListener();
					return;
				}
				sgOverallGraph.setDataString(((new StringBuffer().append((char) StreamTokenizer.TT_EOF))).toString());
				sgOverallGraph.loadFromFile(s2KkRhnJ);
				riaaVItY.setStatus("Loaded file..." + s2KkRhnJ, (double) ++jJuKbku6 / ed8RPmXl);
				Thread.yield();
			}
			Set anweqeHx = null;
			File GFLRglQb = new File(phaUGygs);
			boolean QpaAE3hb = false;
			if (GFLRglQb.exists()) {
				System.err.println("ATTENTION: Using previous symbols...");
				try {
					FileInputStream w4S1QwvU = new FileInputStream(GFLRglQb);
					ObjectInputStream hJ0X1vkf = new ObjectInputStream(w4S1QwvU);
					anweqeHx = (Set) hJ0X1vkf.readObject();
					hJ0X1vkf.close();
					QpaAE3hb = true;
				} catch (FileNotFoundException j4V9GBQF) {
					j4V9GBQF.printStackTrace(System.err);
				} catch (IOException Okq3gRhW) {
					Okq3gRhW.printStackTrace(System.err);
				} catch (ClassNotFoundException aKkGs3wN) {
					aKkGs3wN.printStackTrace(System.err);
				}
			}
			if (!QpaAE3hb)
				anweqeHx = getSymbolsByProbabilities(sgOverallGraph.getDataString(), riaaVItY);
			int YOHwukhp = Integer.MAX_VALUE;
			int iR3hFtHd = Integer.MIN_VALUE;
			Iterator WzAlO929 = anweqeHx.iterator();
			while (WzAlO929.hasNext()) {
				String xFDHaoiV = (String) WzAlO929.next();
				if (iR3hFtHd < xFDHaoiV.length())
					iR3hFtHd = xFDHaoiV.length();
				if (YOHwukhp > xFDHaoiV.length())
					YOHwukhp = xFDHaoiV.length();
			}
			try {
				FileOutputStream DUrtzcAi = new FileOutputStream(phaUGygs);
				ObjectOutputStream WT45V6wT = new ObjectOutputStream(DUrtzcAi);
				WT45V6wT.writeObject(anweqeHx);
				WT45V6wT.close();
			} catch (FileNotFoundException SXZb87Wp) {
				SXZb87Wp.printStackTrace(System.err);
			} catch (IOException LwVME8mB) {
				LwVME8mB.printStackTrace(System.err);
			}
			appendToLog("(Pass 2/3) Determining symbol distros per n-gram size...");
			MJdgC2Wm = pcc6nnu0.getTrainingSet().iterator();
			ed8RPmXl = pcc6nnu0.getTrainingSet().size();
			if (ed8RPmXl == 0) {
				appendToLog("No input documents.\n");
				appendToLog("======DONE=====\n");
				return;
			}
			jJuKbku6 = 0;
			Distribution vGUzy052 = new Distribution();
			Distribution NwJOBynr = new Distribution();
			Distribution l5kYUHMf = new Distribution();
			File hEViMrxT = new File(KowMTmZk);
			boolean PFxUFsHM = false;
			if (hEViMrxT.exists()) {
				System.err.println("ATTENTION: Using previous distros...");
				try {
					FileInputStream ZoeRE5Ug = new FileInputStream(hEViMrxT);
					ObjectInputStream HpkIFGaj = new ObjectInputStream(ZoeRE5Ug);
					vGUzy052 = (Distribution) HpkIFGaj.readObject();
					NwJOBynr = (Distribution) HpkIFGaj.readObject();
					l5kYUHMf = (Distribution) HpkIFGaj.readObject();
					HpkIFGaj.close();
					PFxUFsHM = true;
				} catch (FileNotFoundException kpuKrdXp) {
					kpuKrdXp.printStackTrace(System.err);
				} catch (IOException QEkcXNvr) {
					QEkcXNvr.printStackTrace(System.err);
					vGUzy052 = new Distribution();
					NwJOBynr = new Distribution();
					l5kYUHMf = new Distribution();
				} catch (ClassNotFoundException p6tk4JRz) {
					p6tk4JRz.printStackTrace(System.err);
					vGUzy052 = new Distribution();
					NwJOBynr = new Distribution();
					l5kYUHMf = new Distribution();
				}
			}
			if (!PFxUFsHM)
				while (MJdgC2Wm.hasNext()) {
					riaaVItY.setStatus("(Pass 2/3) Parsing file..." + s2KkRhnJ, (double) jJuKbku6++ / ed8RPmXl);
					s2KkRhnJ = ((CategorizedFileEntry) MJdgC2Wm.next()).getFileName();
					String fYD3DJOh = "";
					try {
						ByteArrayOutputStream BQA5rj0P = new ByteArrayOutputStream();
						FileInputStream fJkqnlCI = new FileInputStream(s2KkRhnJ);
						int ioaBPXDb = 0;
						while ((ioaBPXDb = fJkqnlCI.read()) > -1)
							BQA5rj0P.write(ioaBPXDb);
						fYD3DJOh = BQA5rj0P.toString();
					} catch (IOException UeZ1lDSA) {
						UeZ1lDSA.printStackTrace(System.err);
					}
					final Distribution dgHaxhE1 = vGUzy052;
					final Distribution g8qSiDYU = NwJOBynr;
					final Distribution Fc3Jt8To = l5kYUHMf;
					final String qPBM4tdz = fYD3DJOh;
					final Set w2BmB5Cc = anweqeHx;
					for (int zW51kwBy = YOHwukhp; zW51kwBy <= iR3hFtHd; zW51kwBy++) {
						final int MVADtx3o = zW51kwBy;
						while (!r84M3geV.addThreadFor(new Runnable() {

							public void run() {
								NGramDocument SeAGzsqO = new NGramDocument(MVADtx3o, MVADtx3o, 1, MVADtx3o, MVADtx3o);
								SeAGzsqO.setDataString(qPBM4tdz);
								int PwicWW3w = 0;
								int urkhxhLL = 0;
								Iterator dQnX7sFw = SeAGzsqO.getDocumentGraph().getGraphLevel(0).getVertexSet()
										.iterator();
								while (dQnX7sFw.hasNext()) {
									String fAudbXjW = ((Vertex) dQnX7sFw.next()).toString();
									if (w2BmB5Cc.contains(fAudbXjW)) {
										PwicWW3w++;
										synchronized (Fc3Jt8To) {
											Fc3Jt8To.setValue(fAudbXjW.length(),
													Fc3Jt8To.getValue(fAudbXjW.length()) + 1.0);
										}
									} else
										urkhxhLL++;
								}
								synchronized (dgHaxhE1) {
									dgHaxhE1.setValue(MVADtx3o, dgHaxhE1.getValue(MVADtx3o) + PwicWW3w);
								}
								synchronized (g8qSiDYU) {
									g8qSiDYU.setValue(MVADtx3o, g8qSiDYU.getValue(MVADtx3o) + urkhxhLL);
								}
							}
						}))
							Thread.yield();
					}
				}
			if (!PFxUFsHM)
				try {
					r84M3geV.waitUntilCompletion();
					try {
						FileOutputStream vPXMoKmc = new FileOutputStream(KowMTmZk);
						ObjectOutputStream MPZgFgGS = new ObjectOutputStream(vPXMoKmc);
						MPZgFgGS.writeObject(vGUzy052);
						MPZgFgGS.writeObject(NwJOBynr);
						MPZgFgGS.writeObject(l5kYUHMf);
						MPZgFgGS.close();
					} catch (FileNotFoundException xwU0UVrm) {
						xwU0UVrm.printStackTrace(System.err);
					} catch (IOException I6pJPNCi) {
						I6pJPNCi.printStackTrace(System.err);
					}
				} catch (InterruptedException dCISHhwr) {
					appendToLog("Interrupted...");
					sgOverallGraph.removeNotificationListener();
					return;
				}
			appendToLog("\n(Pass 3/3) Determining optimal n-gram range...\n");
			NGramSizeEstimator El7SYiTQ = new NGramSizeEstimator(vGUzy052, NwJOBynr);
			IntegerPair YyT7zCS3 = El7SYiTQ.getOptimalRange();
			appendToLog("\nProposed n-gram sizes:" + YyT7zCS3.first() + "," + YyT7zCS3.second());
			riaaVItY.setStatus("Determining optimal distance...", 0.0);
			DistanceEstimator jfMGdD2y = new DistanceEstimator(vGUzy052, NwJOBynr, El7SYiTQ);
			int Z7Lh55Lq = jfMGdD2y.getOptimalDistance(1, El7SYiTQ.getMaxRank() * 2, YyT7zCS3.first(),
					YyT7zCS3.second());
			riaaVItY.setStatus("Determining optimal distance...", 1.0);
			appendToLog("\nOptimal distance:" + Z7Lh55Lq);
			appendToLog("======DONE=====\n");
		} finally {
			sgOverallGraph.removeNotificationListener();
		}
	}

}