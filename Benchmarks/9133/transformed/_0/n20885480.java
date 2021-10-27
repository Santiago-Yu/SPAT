class n20885480 {
	private void anneal(final float PC3qnbGv, final float eYXBas7j, final float SSW0XCzA, final float LIlNS7Ds,
			final float Xnf5z4iU, final float k63ei8Q0, final float lkoxR87D, final float Qzzz1dJ0, final long NZppCpNy,
			final BufferedDocuments<Phrase> YtBbi6r7, final int lfezFEs9, final int m07Fe6qc, File Yg1oCKTp,
			boolean sJ3X7V2O) {
		float rPtZrSsd = 0;
		boolean cX3S9W4c = true;
		double[] ZwZhljeQ = new double[lfezFEs9];
		double[] TryL0HhE = new double[lfezFEs9];
		boolean[] lDer91yY = new boolean[lfezFEs9];
		GradientPoint[] RW3Xm728 = new GradientPoint[lfezFEs9];
		GradientPoint[] BwDTsv3t = new GradientPoint[lfezFEs9];
		GradientPoint[] mnd5zcxD = new GradientPoint[lfezFEs9];
		GradientPoint[] nIvv7wcu = new GradientPoint[lfezFEs9];
		Random jLLkG68p = new Random(NZppCpNy);
		Time fAuqbvDA = new Time();
		if (Yg1oCKTp != null && Yg1oCKTp.length() > 0) {
			fAuqbvDA.reset();
			try {
				ObjectInputStream Y8dCkPvE = new ObjectInputStream(new FileInputStream(Yg1oCKTp));
				rPtZrSsd = Y8dCkPvE.readFloat();
				cX3S9W4c = Y8dCkPvE.readBoolean();
				ZwZhljeQ = (double[]) Y8dCkPvE.readObject();
				TryL0HhE = (double[]) Y8dCkPvE.readObject();
				lDer91yY = (boolean[]) Y8dCkPvE.readObject();
				RW3Xm728 = (GradientPoint[]) Y8dCkPvE.readObject();
				BwDTsv3t = (GradientPoint[]) Y8dCkPvE.readObject();
				mnd5zcxD = (GradientPoint[]) Y8dCkPvE.readObject();
				nIvv7wcu = (GradientPoint[]) Y8dCkPvE.readObject();
				jLLkG68p = (Random) Y8dCkPvE.readObject();
				int b3ozk30C = Y8dCkPvE.readInt();
				for (int kpNhz3PO = 0; kpNhz3PO < b3ozk30C; kpNhz3PO++) {
					Feature hrT6eBrZ = FEATURES.getRaw(CONFIG, Y8dCkPvE.readUTF(), 0f);
					if (hrT6eBrZ.getId() != kpNhz3PO)
						throw new Exception("Features have changed");
				}
				evaluation.read(Y8dCkPvE);
				Y8dCkPvE.close();
				output.println("# Resuming from previous optimization state (" + fAuqbvDA + ")");
				output.println();
			} catch (Exception WZqTREhx) {
				WZqTREhx.printStackTrace();
				Log.getInstance()
						.severe("Failed loading optimization state (" + Yg1oCKTp + "): " + WZqTREhx.getMessage());
			}
		} else {
			final int pb2Vpimt = ProjectedEvaluation.CFG_OPT_HISTORY_SIZE.getValue();
			final GradientPoint[] aMKGZvWt = new GradientPoint[lfezFEs9 * pb2Vpimt];
			for (int GwuURNmg = 0; GwuURNmg < lfezFEs9; GwuURNmg++) {
				evaluation.setParallelId(GwuURNmg);
				for (int vquheCAc = 0; vquheCAc < pb2Vpimt; vquheCAc++) {
					if (GwuURNmg != 0)
						aMKGZvWt[GwuURNmg * lfezFEs9 + vquheCAc] = getRandomPoint(jLLkG68p, aMKGZvWt[0], lkoxR87D,
								null);
					evaluate(YtBbi6r7, GwuURNmg + ":" + vquheCAc);
					if (GwuURNmg == 0) {
						aMKGZvWt[0] = new GradientPoint(evaluation, null);
						rPtZrSsd = LogFeatureModel.FEAT_MODEL_GAMMA.getValue();
						break;
					}
				}
			}
			for (int kwAYC8fs = 0; kwAYC8fs < aMKGZvWt.length; kwAYC8fs++)
				if (aMKGZvWt[kwAYC8fs] != null)
					aMKGZvWt[kwAYC8fs] = new GradientPoint(evaluation, aMKGZvWt[kwAYC8fs], output);
			for (int fjhtNFdL = 0; fjhtNFdL < lfezFEs9; fjhtNFdL++) {
				BwDTsv3t[fjhtNFdL] = null;
				RW3Xm728[fjhtNFdL] = aMKGZvWt[fjhtNFdL * lfezFEs9];
				if (fjhtNFdL != 0)
					for (int nM9uOK92 = 1; nM9uOK92 < pb2Vpimt; nM9uOK92++)
						if (aMKGZvWt[fjhtNFdL * lfezFEs9 + nM9uOK92].getScore() < RW3Xm728[fjhtNFdL].getScore())
							RW3Xm728[fjhtNFdL] = aMKGZvWt[fjhtNFdL * lfezFEs9 + nM9uOK92];
				mnd5zcxD[fjhtNFdL] = RW3Xm728[fjhtNFdL];
				ZwZhljeQ[fjhtNFdL] = Float.MAX_VALUE;
			}
		}
		for (int nKSi1AtS = 1;; nKSi1AtS++) {
			boolean jYik1Snx = true;
			for (int lzEzRwjz = 0; lzEzRwjz < lfezFEs9; lzEzRwjz++)
				jYik1Snx = jYik1Snx && lDer91yY[lzEzRwjz];
			if (jYik1Snx) {
				output.println("*** N-best list converged. Modifying annealing schedule. ***");
				output.println();
				if (cX3S9W4c) {
					boolean jlGuKIJ5 = true;
					for (int FkJ3ftai = 0; jlGuKIJ5 && FkJ3ftai < lfezFEs9; FkJ3ftai++)
						jlGuKIJ5 = isConverged(mnd5zcxD[FkJ3ftai].getScore(), ZwZhljeQ[FkJ3ftai], SSW0XCzA,
								SCORE_EPSILON);
					cX3S9W4c = false;
					for (Metric<ProjectedSentenceEvaluation> weSvFmlC : AbstractEvaluation.CFG_EVAL_METRICS.getValue())
						if (weSvFmlC.doAnnealing()) {
							float KaGojb7N = weSvFmlC.getWeight();
							if (KaGojb7N != 0)
								if (jlGuKIJ5)
									weSvFmlC.setWeight(0);
								else {
									cX3S9W4c = true;
									weSvFmlC.setWeight(KaGojb7N / LIlNS7Ds);
								}
						}
				}
				if (!cX3S9W4c) {
					if (Math.abs(rPtZrSsd) >= PC3qnbGv) {
						GradientPoint VJD7pzMH = mnd5zcxD[0];
						for (int UmmFgT33 = 1; UmmFgT33 < lfezFEs9; UmmFgT33++)
							if (mnd5zcxD[UmmFgT33].getScore() < VJD7pzMH.getScore())
								VJD7pzMH = mnd5zcxD[UmmFgT33];
						output.format("Best Score: %+.7g%n", VJD7pzMH.getScore());
						output.println();
						VJD7pzMH = new GradientPoint(evaluation, VJD7pzMH, output);
						break;
					}
					rPtZrSsd *= eYXBas7j;
					if (Math.abs(rPtZrSsd) + GAMMA_EPSILON >= PC3qnbGv)
						rPtZrSsd = rPtZrSsd >= 0 ? PC3qnbGv : -PC3qnbGv;
				}
				for (int xzXKiyaH = 0; xzXKiyaH < lfezFEs9; xzXKiyaH++) {
					ZwZhljeQ[xzXKiyaH] = mnd5zcxD[xzXKiyaH].getScore();
					RW3Xm728[xzXKiyaH] = new GradientPoint(evaluation, mnd5zcxD[xzXKiyaH], rPtZrSsd, output);
					mnd5zcxD[xzXKiyaH] = RW3Xm728[xzXKiyaH];
					BwDTsv3t[xzXKiyaH] = null;
					nIvv7wcu[xzXKiyaH] = null;
					lDer91yY[xzXKiyaH] = false;
				}
				nKSi1AtS = 0;
			}
			for (int mMktf1uA = 0; mMktf1uA < lfezFEs9; mMktf1uA++) {
				if (lDer91yY[mMktf1uA])
					continue;
				if (lfezFEs9 > 1)
					output.println("Minimizing point " + mMktf1uA);
				Gradient aKGzkoHl = RW3Xm728[mMktf1uA].getGradient();
				for (int tZuqnxKI = 0; tZuqnxKI < FEATURES.size(); tZuqnxKI++)
					output.format("GRAD %-65s %-+13.7g%n", FEATURES.getName(tZuqnxKI), aKGzkoHl.get(tZuqnxKI));
				output.println();
				fAuqbvDA.reset();
				GradientPoint xyfvJREY = minimize(RW3Xm728[mMktf1uA], BwDTsv3t[mMktf1uA], mnd5zcxD[mMktf1uA], Xnf5z4iU,
						k63ei8Q0, lkoxR87D, Qzzz1dJ0, jLLkG68p);
				final float[] Br47FdjD = xyfvJREY.getWeights();
				for (int J3KagnUZ = 0; J3KagnUZ < Br47FdjD.length; J3KagnUZ++)
					output.format("PARM %-65s %-+13.7g%n", FEATURES.getName(J3KagnUZ), Br47FdjD[J3KagnUZ]);
				output.println();
				output.format("Minimum Score: %+.7g (average distance of %.2f)%n", xyfvJREY.getScore(),
						xyfvJREY.getAverageDistance());
				output.println();
				output.println("# Minimized gradient (" + fAuqbvDA + ")");
				output.println();
				output.flush();
				lDer91yY[mMktf1uA] = Br47FdjD == RW3Xm728[mMktf1uA].getWeights();
				BwDTsv3t[mMktf1uA] = RW3Xm728[mMktf1uA];
				nIvv7wcu[mMktf1uA] = xyfvJREY;
				RW3Xm728[mMktf1uA] = xyfvJREY;
			}
			for (int vZaRYu2Y = 0; vZaRYu2Y < lfezFEs9; vZaRYu2Y++) {
				if (lDer91yY[vZaRYu2Y])
					continue;
				lDer91yY[vZaRYu2Y] = isConvergedScore("minimum", nIvv7wcu[vZaRYu2Y], BwDTsv3t[vZaRYu2Y], Xnf5z4iU)
						&& isConvergedWeights(nIvv7wcu[vZaRYu2Y], BwDTsv3t[vZaRYu2Y], k63ei8Q0);
				nIvv7wcu[vZaRYu2Y].setWeightsAndRescore(evaluation);
				evaluation.setParallelId(vZaRYu2Y);
				evaluate(YtBbi6r7, Integer.toString(vZaRYu2Y));
			}
			Set<Point> uRhDmq0u = new HashSet<Point>();
			uRhDmq0u.addAll(Arrays.asList(mnd5zcxD));
			uRhDmq0u.addAll(Arrays.asList(BwDTsv3t));
			uRhDmq0u.addAll(Arrays.asList(RW3Xm728));
			evaluation.prune(uRhDmq0u, m07Fe6qc, output);
			for (int TMxUKZ5w = 0; TMxUKZ5w < lfezFEs9; TMxUKZ5w++) {
				final boolean Xmi9wYUp = mnd5zcxD[TMxUKZ5w] == BwDTsv3t[TMxUKZ5w];
				final boolean Cz5ZnM9W = mnd5zcxD[TMxUKZ5w] == RW3Xm728[TMxUKZ5w];
				mnd5zcxD[TMxUKZ5w] = new GradientPoint(evaluation, mnd5zcxD[TMxUKZ5w], Cz5ZnM9W ? output : null);
				if (Xmi9wYUp)
					BwDTsv3t[TMxUKZ5w] = mnd5zcxD[TMxUKZ5w];
				if (Cz5ZnM9W)
					RW3Xm728[TMxUKZ5w] = mnd5zcxD[TMxUKZ5w];
				if (!Xmi9wYUp && BwDTsv3t[TMxUKZ5w] != null) {
					BwDTsv3t[TMxUKZ5w] = new GradientPoint(evaluation, BwDTsv3t[TMxUKZ5w], null);
					if (BwDTsv3t[TMxUKZ5w].getScore() <= mnd5zcxD[TMxUKZ5w].getScore())
						mnd5zcxD[TMxUKZ5w] = BwDTsv3t[TMxUKZ5w];
				}
				if (!Cz5ZnM9W) {
					RW3Xm728[TMxUKZ5w] = new GradientPoint(evaluation, RW3Xm728[TMxUKZ5w], output);
					if (RW3Xm728[TMxUKZ5w].getScore() <= mnd5zcxD[TMxUKZ5w].getScore())
						mnd5zcxD[TMxUKZ5w] = RW3Xm728[TMxUKZ5w];
				}
			}
			for (int tpThMEwz = 0; tpThMEwz < lfezFEs9; tpThMEwz++)
				if (lDer91yY[tpThMEwz])
					if (nIvv7wcu[tpThMEwz] == null) {
						output.println("# Convergence failed: no previous minimum is defined");
						output.println();
						lDer91yY[tpThMEwz] = false;
					} else {
						lDer91yY[tpThMEwz] = isConvergedScore("best known", mnd5zcxD[tpThMEwz], RW3Xm728[tpThMEwz],
								Xnf5z4iU)
								&& isConvergedScore("previous minimum", nIvv7wcu[tpThMEwz], RW3Xm728[tpThMEwz],
										Xnf5z4iU);
					}
			if (Yg1oCKTp != null) {
				fAuqbvDA.reset();
				try {
					File w71hAIiL = Yg1oCKTp.getCanonicalFile().getParentFile();
					File X2gp4Qhq = File.createTempFile("cunei-opt-", ".tmp", w71hAIiL);
					ObjectOutputStream rFanBihd = new ObjectOutputStream(new FileOutputStream(X2gp4Qhq));
					rFanBihd.writeFloat(rPtZrSsd);
					rFanBihd.writeBoolean(cX3S9W4c);
					rFanBihd.writeObject(ZwZhljeQ);
					rFanBihd.writeObject(TryL0HhE);
					rFanBihd.writeObject(lDer91yY);
					rFanBihd.writeObject(RW3Xm728);
					rFanBihd.writeObject(BwDTsv3t);
					rFanBihd.writeObject(mnd5zcxD);
					rFanBihd.writeObject(nIvv7wcu);
					rFanBihd.writeObject(jLLkG68p);
					rFanBihd.writeInt(FEATURES.size());
					for (int Wnr8v3sC = 0; Wnr8v3sC < FEATURES.size(); Wnr8v3sC++)
						rFanBihd.writeUTF(FEATURES.getName(Wnr8v3sC));
					evaluation.write(rFanBihd);
					rFanBihd.close();
					if (!X2gp4Qhq.renameTo(Yg1oCKTp)) {
						FileChannel HZohxLjk = null;
						FileChannel sLC5MzBZ = null;
						try {
							HZohxLjk = new FileInputStream(X2gp4Qhq).getChannel();
							sLC5MzBZ = new FileOutputStream(Yg1oCKTp).getChannel();
							HZohxLjk.transferTo(0, HZohxLjk.size(), sLC5MzBZ);
							X2gp4Qhq.delete();
						} finally {
							if (HZohxLjk != null)
								HZohxLjk.close();
							if (sLC5MzBZ != null)
								sLC5MzBZ.close();
						}
					}
					output.println("# Saved optimization state (" + fAuqbvDA + ")");
					output.println();
				} catch (IOException DbPTR0kD) {
					Log.getInstance().severe("Failed writing optimization state: " + DbPTR0kD.getMessage());
				}
			}
		}
		if (Yg1oCKTp != null && !sJ3X7V2O)
			Yg1oCKTp.delete();
	}

}