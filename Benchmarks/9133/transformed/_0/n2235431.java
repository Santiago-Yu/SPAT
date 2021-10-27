class n2235431 {
	private LinkedList<Datum> processDatum(Datum HndDikp8) {
		ArrayList<Object[]> a3RsWlkY = new ArrayList<Object[]>();
		ArrayList<Object[]> Q8X1SfXn = new ArrayList<Object[]>();
		boolean C5dJB0rb = false;
		String napYtjBN = new String("");
		MarkerPhenotypeAdapter O9oqqXB4;
		if (HndDikp8.getDataType().equals(MarkerPhenotype.class)) {
			O9oqqXB4 = new MarkerPhenotypeAdapter((MarkerPhenotype) HndDikp8.getData());
		} else
			O9oqqXB4 = new MarkerPhenotypeAdapter((Phenotype) HndDikp8.getData());
		int LmK7xq6A = O9oqqXB4.getNumberOfMarkers();
		if (LmK7xq6A == 0) {
			return calculateBLUEsFromPhenotypes(O9oqqXB4, HndDikp8.getName());
		}
		int TCilts27 = O9oqqXB4.getNumberOfCovariates();
		int kOdW911W = O9oqqXB4.getNumberOfFactors();
		int wEAmLfkK = O9oqqXB4.getNumberOfPhenotypes();
		int plEls02A = wEAmLfkK * LmK7xq6A;
		int Tz6eTAWU = 0;
		int CjCS5l87 = 0;
		File GEjOqdPM = null;
		File C0WgeO2n = null;
		File T3F61WfO = null;
		BufferedWriter bJHiOUJj = null;
		BufferedWriter nPHwtUJb = null;
		String CjC7fKUr = "Trait\tMarker\tLocus\tLocus_pos\tChr\tChr_pos\tmarker_F\tmarker_p\tperm_p\tmarkerR2\tmarkerDF\tmarkerMS\terrorDF\terrorMS\tmodelDF\tmodelMS";
		String YDjokekr = "Trait\tMarker\tObs\tLocus\tLocus_pos\tChr\tChr_pos\tAllele\tEstimate";
		if (writeOutputToFile) {
			String knmoNWOm = outputName;
			if (knmoNWOm.endsWith(".txt")) {
				int tKHx7Hm3 = knmoNWOm.lastIndexOf(".");
				knmoNWOm = knmoNWOm.substring(0, tKHx7Hm3);
			}
			String RXYqBCIV = HndDikp8.getName().trim().replaceAll("\\ ", "_");
			C0WgeO2n = new File(knmoNWOm + "_" + RXYqBCIV + "_ftest.txt");
			int jLiaF4b9 = 0;
			while (C0WgeO2n.exists()) {
				jLiaF4b9++;
				C0WgeO2n = new File(knmoNWOm + "_" + RXYqBCIV + "_ftest" + jLiaF4b9 + ".txt");
			}
			T3F61WfO = new File(knmoNWOm + "_" + RXYqBCIV + "_BLUEs.txt");
			jLiaF4b9 = 0;
			while (T3F61WfO.exists()) {
				jLiaF4b9++;
				T3F61WfO = new File(knmoNWOm + "_" + RXYqBCIV + "_BLUEs" + jLiaF4b9 + ".txt");
			}
			GEjOqdPM = new File(knmoNWOm + "_" + RXYqBCIV + "_ftest.tmp");
			try {
				if (permute) {
					bJHiOUJj = new BufferedWriter(new FileWriter(GEjOqdPM));
					bJHiOUJj.write(CjC7fKUr);
					bJHiOUJj.newLine();
				} else {
					bJHiOUJj = new BufferedWriter(new FileWriter(C0WgeO2n));
					bJHiOUJj.write(CjC7fKUr);
					bJHiOUJj.newLine();
				}
				if (reportBLUEs) {
					nPHwtUJb = new BufferedWriter(new FileWriter(T3F61WfO));
					nPHwtUJb.write(YDjokekr);
					nPHwtUJb.newLine();
				}
			} catch (IOException t2dQnTt6) {
				myLogger.error("Failed to open file for output");
				myLogger.error(t2dQnTt6);
				return null;
			}
		}
		if (permute) {
			minP = new double[wEAmLfkK][numberOfPermutations];
			for (int rIDdmjTz = 0; rIDdmjTz < numberOfPermutations; rIDdmjTz++) {
				for (int SE8RwyLl = 0; SE8RwyLl < wEAmLfkK; SE8RwyLl++) {
					minP[SE8RwyLl][rIDdmjTz] = 1;
				}
			}
		}
		for (int dNEKE1Vo = 0; dNEKE1Vo < wEAmLfkK; dNEKE1Vo++) {
			double[] NMknRmoD = O9oqqXB4.getPhenotypeValues(dNEKE1Vo);
			boolean[] LRKoO3Kl = O9oqqXB4.getMissingPhenotypes(dNEKE1Vo);
			ArrayList<String[]> SVFW20TJ = MarkerPhenotypeAdapterUtils.getFactorList(O9oqqXB4, dNEKE1Vo, LRKoO3Kl);
			ArrayList<double[]> CiHx6xW0 = MarkerPhenotypeAdapterUtils.getCovariateList(O9oqqXB4, dNEKE1Vo, LRKoO3Kl);
			double[][] AwZ2GQPV = null;
			if (permute) {
				AwZ2GQPV = permuteData(NMknRmoD, LRKoO3Kl, SVFW20TJ, CiHx6xW0, O9oqqXB4);
			}
			for (int ngomhrGe = 0; ngomhrGe < LmK7xq6A; ngomhrGe++) {
				Object[] D0T7jN4S = O9oqqXB4.getMarkerValue(dNEKE1Vo, ngomhrGe);
				boolean[] A8xgI5Zv = new boolean[LRKoO3Kl.length];
				System.arraycopy(LRKoO3Kl, 0, A8xgI5Zv, 0, LRKoO3Kl.length);
				MarkerPhenotypeAdapterUtils.updateMissing(A8xgI5Zv, O9oqqXB4.getMissingMarkers(dNEKE1Vo, ngomhrGe));
				int[] Zf0KikNE = MarkerPhenotypeAdapterUtils.getNonMissingIndex(A8xgI5Zv);
				int udqyTKih = Zf0KikNE.length;
				double[] LKjvf4fb = new double[udqyTKih];
				for (int pvjSzHl2 = 0; pvjSzHl2 < udqyTKih; pvjSzHl2++)
					LKjvf4fb[pvjSzHl2] = NMknRmoD[Zf0KikNE[pvjSzHl2]];
				int UYGr9oUX = 1;
				ArrayList<ModelEffect> zCTeWDsQ = new ArrayList<ModelEffect>();
				FactorModelEffect jzhVk5Wh = new FactorModelEffect(new int[udqyTKih], false);
				jzhVk5Wh.setID("mean");
				zCTeWDsQ.add(jzhVk5Wh);
				if (kOdW911W > 0) {
					for (int j6Q4krOt = 0; j6Q4krOt < kOdW911W; j6Q4krOt++) {
						String[] J5XZDR6k = SVFW20TJ.get(j6Q4krOt);
						String[] o4NC4GTo = new String[udqyTKih];
						for (int N4vtOCeW = 0; N4vtOCeW < udqyTKih; N4vtOCeW++)
							o4NC4GTo[N4vtOCeW] = J5XZDR6k[Zf0KikNE[N4vtOCeW]];
						FactorModelEffect wNGcnLdg = new FactorModelEffect(ModelEffectUtils.getIntegerLevels(o4NC4GTo),
								true, O9oqqXB4.getFactorName(j6Q4krOt));
						zCTeWDsQ.add(wNGcnLdg);
						UYGr9oUX += wNGcnLdg.getNumberOfLevels() - 1;
					}
				}
				if (TCilts27 > 0) {
					for (int q17LNS5C = 0; q17LNS5C < TCilts27; q17LNS5C++) {
						double[] S8446mer = new double[udqyTKih];
						double[] PY40Ak2I = CiHx6xW0.get(q17LNS5C);
						for (int tffma6RH = 0; tffma6RH < udqyTKih; tffma6RH++)
							S8446mer[tffma6RH] = PY40Ak2I[Zf0KikNE[tffma6RH]];
						zCTeWDsQ.add(new CovariateModelEffect(S8446mer, O9oqqXB4.getCovariateName(q17LNS5C)));
						UYGr9oUX++;
					}
				}
				ModelEffect wweldhul;
				boolean J3xjTz6B = O9oqqXB4.isMarkerDiscrete(ngomhrGe);
				ArrayList<Object> NAcOtSwK = new ArrayList<Object>();
				if (J3xjTz6B) {
					Object[] mFLr49WO = new Object[udqyTKih];
					for (int ZLoSSyWT = 0; ZLoSSyWT < udqyTKih; ZLoSSyWT++)
						mFLr49WO[ZLoSSyWT] = D0T7jN4S[Zf0KikNE[ZLoSSyWT]];
					int[] lYU4rmzR = ModelEffectUtils.getIntegerLevels(mFLr49WO, NAcOtSwK);
					wweldhul = new FactorModelEffect(lYU4rmzR, true, O9oqqXB4.getMarkerName(ngomhrGe));
					C5dJB0rb = true;
				} else {
					double[] tAN3zSHG = new double[udqyTKih];
					for (int I0eEEk4a = 0; I0eEEk4a < udqyTKih; I0eEEk4a++)
						tAN3zSHG[I0eEEk4a] = ((Double) D0T7jN4S[Zf0KikNE[I0eEEk4a]]).doubleValue();
					wweldhul = new CovariateModelEffect(tAN3zSHG, O9oqqXB4.getMarkerName(ngomhrGe));
				}
				int[] r4PdZ7n0 = wweldhul.getLevelCounts();
				zCTeWDsQ.add(wweldhul);
				int ao7r6FIf = zCTeWDsQ.size() - 1;
				Identifier[] pVDuTPFg = new Identifier[udqyTKih];
				Identifier[] HrXRioc9 = O9oqqXB4.getTaxa(dNEKE1Vo);
				for (int pLJ7V4hv = 0; pLJ7V4hv < udqyTKih; pLJ7V4hv++)
					pVDuTPFg[pLJ7V4hv] = HrXRioc9[Zf0KikNE[pLJ7V4hv]];
				boolean Nhi1A6iT = containsDuplicates(pVDuTPFg);
				double[] BuPFnOcN = null, fLqb3ttd = null, xnS18q0J = null;
				double XHdJTf4X, AIuHkzvo;
				double[] Y2TL55uo = null;
				if (Nhi1A6iT && J3xjTz6B) {
					ModelEffect r6TnntsE = new FactorModelEffect(ModelEffectUtils.getIntegerLevels(pVDuTPFg), true);
					zCTeWDsQ.add(r6TnntsE);
					SweepFastNestedModel LUOU6Xcg = new SweepFastNestedModel(zCTeWDsQ, LKjvf4fb);
					double[] FuLyLgwR = LUOU6Xcg.getTaxaInMarkerSSdf();
					double[] NIyvBkph = LUOU6Xcg.getErrorSSdf();
					BuPFnOcN = LUOU6Xcg.getMarkerSSdf();
					fLqb3ttd = LUOU6Xcg.getErrorSSdf();
					xnS18q0J = LUOU6Xcg.getModelcfmSSdf();
					XHdJTf4X = BuPFnOcN[0] / BuPFnOcN[1] / FuLyLgwR[0] * FuLyLgwR[1];
					try {
						AIuHkzvo = LinearModelUtils.Ftest(XHdJTf4X, BuPFnOcN[1], FuLyLgwR[1]);
					} catch (Exception XKjadYtn) {
						AIuHkzvo = Double.NaN;
					}
					Y2TL55uo = LUOU6Xcg.getBeta();
					int NbtrL44w = (int) BuPFnOcN[1];
					if (permute && NbtrL44w > 0) {
						updatePermutationPValues(dNEKE1Vo, AwZ2GQPV, nonMissingIndex(LRKoO3Kl, A8xgI5Zv),
								getXfromModelEffects(zCTeWDsQ), LUOU6Xcg.getInverseOfXtX(), NbtrL44w);
					}
				} else {
					SweepFastLinearModel MWAHVMX0 = new SweepFastLinearModel(zCTeWDsQ, LKjvf4fb);
					xnS18q0J = MWAHVMX0.getModelcfmSSdf();
					BuPFnOcN = MWAHVMX0.getMarginalSSdf(ao7r6FIf);
					fLqb3ttd = MWAHVMX0.getResidualSSdf();
					XHdJTf4X = BuPFnOcN[0] / BuPFnOcN[1] / fLqb3ttd[0] * fLqb3ttd[1];
					try {
						AIuHkzvo = LinearModelUtils.Ftest(XHdJTf4X, BuPFnOcN[1], fLqb3ttd[1]);
					} catch (Exception LKDNkk0h) {
						AIuHkzvo = Double.NaN;
					}
					Y2TL55uo = MWAHVMX0.getBeta();
					int iUq25NuV = (int) BuPFnOcN[1];
					if (permute && iUq25NuV > 0) {
						updatePermutationPValues(dNEKE1Vo, AwZ2GQPV, nonMissingIndex(LRKoO3Kl, A8xgI5Zv),
								getXfromModelEffects(zCTeWDsQ), MWAHVMX0.getInverseOfXtX(), iUq25NuV);
					}
				}
				if (!filterOutput || AIuHkzvo < maxp) {
					String BlFIq0rJ = O9oqqXB4.getPhenotypeName(dNEKE1Vo);
					if (BlFIq0rJ == null)
						BlFIq0rJ = napYtjBN;
					String JsFsfcyg = O9oqqXB4.getMarkerName(ngomhrGe);
					if (JsFsfcyg == null)
						JsFsfcyg = napYtjBN;
					String DV0rqLxr = O9oqqXB4.getLocusName(ngomhrGe);
					Integer CmU73TmG = new Integer(O9oqqXB4.getLocusPosition(ngomhrGe));
					String Eve2hRB1 = "";
					Double oUKXwiOF = Double.NaN;
					if (hasMap) {
						int bMb8vaIY = -1;
						bMb8vaIY = myMap.getMarkerIndex(JsFsfcyg);
						if (bMb8vaIY > -1) {
							Eve2hRB1 = myMap.getChromosome(bMb8vaIY);
							oUKXwiOF = myMap.getGeneticPosition(bMb8vaIY);
						}
					}
					Object[] DEOvsPFl = new Object[16];
					int vbhDrOEm = 0;
					DEOvsPFl[vbhDrOEm++] = BlFIq0rJ;
					DEOvsPFl[vbhDrOEm++] = JsFsfcyg;
					DEOvsPFl[vbhDrOEm++] = DV0rqLxr;
					DEOvsPFl[vbhDrOEm++] = CmU73TmG;
					DEOvsPFl[vbhDrOEm++] = Eve2hRB1;
					DEOvsPFl[vbhDrOEm++] = oUKXwiOF;
					DEOvsPFl[vbhDrOEm++] = new Double(XHdJTf4X);
					DEOvsPFl[vbhDrOEm++] = new Double(AIuHkzvo);
					DEOvsPFl[vbhDrOEm++] = Double.NaN;
					DEOvsPFl[vbhDrOEm++] = new Double(BuPFnOcN[0] / (xnS18q0J[0] + fLqb3ttd[0]));
					DEOvsPFl[vbhDrOEm++] = new Double(BuPFnOcN[1]);
					DEOvsPFl[vbhDrOEm++] = new Double(BuPFnOcN[0] / BuPFnOcN[1]);
					DEOvsPFl[vbhDrOEm++] = new Double(fLqb3ttd[1]);
					DEOvsPFl[vbhDrOEm++] = new Double(fLqb3ttd[0] / fLqb3ttd[1]);
					DEOvsPFl[vbhDrOEm++] = new Double(xnS18q0J[1]);
					DEOvsPFl[vbhDrOEm++] = new Double(xnS18q0J[0] / xnS18q0J[1]);
					if (writeOutputToFile) {
						StringBuilder DlpW2oZq = new StringBuilder();
						DlpW2oZq.append(DEOvsPFl[0]);
						for (int bv4fUePu = 1; bv4fUePu < 16; bv4fUePu++)
							DlpW2oZq.append("\t").append(DEOvsPFl[bv4fUePu]);
						try {
							bJHiOUJj.write(DlpW2oZq.toString());
							bJHiOUJj.newLine();
						} catch (IOException DYxKCk3H) {
							myLogger.error("Failed to write output to ftest file. Ending prematurely");
							try {
								bJHiOUJj.flush();
								nPHwtUJb.flush();
							} catch (Exception TcEUsw3g) {
							}
							myLogger.error(DYxKCk3H);
							return null;
						}
					} else {
						a3RsWlkY.add(DEOvsPFl);
					}
					int XLPtoKkr = NAcOtSwK.size();
					if (XLPtoKkr == 0)
						XLPtoKkr++;
					for (int BTa3jciA = 0; BTa3jciA < XLPtoKkr; BTa3jciA++) {
						DEOvsPFl = new Object[9];
						DEOvsPFl[0] = BlFIq0rJ;
						DEOvsPFl[1] = JsFsfcyg;
						DEOvsPFl[2] = new Integer(r4PdZ7n0[BTa3jciA]);
						DEOvsPFl[3] = DV0rqLxr;
						DEOvsPFl[4] = CmU73TmG;
						DEOvsPFl[5] = Eve2hRB1;
						DEOvsPFl[6] = oUKXwiOF;
						if (XLPtoKkr == 1)
							DEOvsPFl[7] = "";
						else
							DEOvsPFl[7] = NAcOtSwK.get(BTa3jciA);
						if (BTa3jciA == XLPtoKkr - 1)
							DEOvsPFl[8] = 0.0;
						else
							DEOvsPFl[8] = Y2TL55uo[UYGr9oUX + BTa3jciA];
						if (writeOutputToFile) {
							StringBuilder vQ3iO6KQ = new StringBuilder();
							vQ3iO6KQ.append(DEOvsPFl[0]);
							for (int yE4aR4mO = 1; yE4aR4mO < 9; yE4aR4mO++)
								vQ3iO6KQ.append("\t").append(DEOvsPFl[yE4aR4mO]);
							try {
								nPHwtUJb.write(vQ3iO6KQ.toString());
								nPHwtUJb.newLine();
							} catch (IOException SyzIvX0S) {
								myLogger.error("Failed to write output to ftest file. Ending prematurely");
								try {
									bJHiOUJj.flush();
									nPHwtUJb.flush();
								} catch (Exception eKcip6jY) {
								}
								myLogger.error(SyzIvX0S);
								return null;
							}
						} else {
							Q8X1SfXn.add(DEOvsPFl);
						}
					}
				}
				int ayL49srf = ++Tz6eTAWU * 100 / plEls02A;
				if (ayL49srf > CjCS5l87) {
					CjCS5l87 = ayL49srf;
					fireProgress(CjCS5l87);
				}
			}
		}
		fireProgress(0);
		if (writeOutputToFile) {
			try {
				bJHiOUJj.close();
				nPHwtUJb.close();
			} catch (IOException H7EbDP0e) {
				H7EbDP0e.printStackTrace();
			}
		}
		HashMap<String, Integer> u4oucrY1 = new HashMap<String, Integer>();
		if (permute) {
			for (int wUHd20wN = 0; wUHd20wN < wEAmLfkK; wUHd20wN++) {
				Arrays.sort(minP[wUHd20wN]);
				u4oucrY1.put(O9oqqXB4.getPhenotypeName(wUHd20wN), wUHd20wN);
			}
			if (writeOutputToFile) {
				try {
					BufferedReader cBoOkKqO = new BufferedReader(new FileReader(GEjOqdPM));
					bJHiOUJj = new BufferedWriter(new FileWriter(C0WgeO2n));
					bJHiOUJj.write(cBoOkKqO.readLine());
					bJHiOUJj.newLine();
					String mokH5yxo;
					String[] BTq4nJWx;
					Pattern mxa5U9oe = Pattern.compile("\t");
					while ((mokH5yxo = cBoOkKqO.readLine()) != null) {
						BTq4nJWx = mxa5U9oe.split(mokH5yxo);
						String Ey61cWBu = BTq4nJWx[0];
						double JRtA7bmI = Double.parseDouble(BTq4nJWx[7]);
						int iHeyUPvu = u4oucrY1.get(Ey61cWBu);
						int rVoZZoP6 = Arrays.binarySearch(minP[iHeyUPvu], JRtA7bmI);
						if (rVoZZoP6 < 0)
							rVoZZoP6 = -rVoZZoP6 - 1;
						if (rVoZZoP6 == 0)
							rVoZZoP6 = 1;
						BTq4nJWx[8] = Double.toString((double) rVoZZoP6 / (double) numberOfPermutations);
						bJHiOUJj.write(BTq4nJWx[0]);
						for (int I2olI19l = 1; I2olI19l < BTq4nJWx.length; I2olI19l++) {
							bJHiOUJj.write("\t");
							bJHiOUJj.write(BTq4nJWx[I2olI19l]);
						}
						bJHiOUJj.newLine();
					}
					cBoOkKqO.close();
					bJHiOUJj.close();
					GEjOqdPM.delete();
				} catch (IOException uQJ29fq1) {
					myLogger.error(uQJ29fq1);
				}
			} else {
				for (Object[] zJ2MDIkL : a3RsWlkY) {
					String jGQAIDZv = zJ2MDIkL[0].toString();
					double QDNGFNQw = (Double) zJ2MDIkL[7];
					int gs4ZDSK0 = u4oucrY1.get(jGQAIDZv);
					int R4qlCAYr = Arrays.binarySearch(minP[gs4ZDSK0], QDNGFNQw);
					if (R4qlCAYr < 0)
						R4qlCAYr = -R4qlCAYr - 1;
					if (R4qlCAYr == 0)
						R4qlCAYr = 1;
					zJ2MDIkL[8] = new Double((double) R4qlCAYr / (double) numberOfPermutations);
				}
			}
		}
		String[] ili7TmdZ = new String[] { "Trait", "Marker", "Locus", "Locus_pos", "Chr", "Chr_pos", "marker_F",
				"marker_p", "perm_p", "markerR2", "markerDF", "markerMS", "errorDF", "errorMS", "modelDF", "modelMS" };
		boolean UKNIT8WU = O9oqqXB4.hasMarkerNames();
		LinkedList<Integer> skTEBufT = new LinkedList<Integer>();
		skTEBufT.add(0);
		if (UKNIT8WU)
			skTEBufT.add(1);
		skTEBufT.add(2);
		skTEBufT.add(3);
		if (hasMap) {
			skTEBufT.add(4);
			skTEBufT.add(5);
		}
		skTEBufT.add(6);
		skTEBufT.add(7);
		if (permute)
			skTEBufT.add(8);
		for (int WR1M8CIt = 9; WR1M8CIt < 16; WR1M8CIt++)
			skTEBufT.add(WR1M8CIt);
		LinkedList<Datum> LsslAgmR = new LinkedList<Datum>();
		int z3XW5Ig3 = a3RsWlkY.size();
		Object[][] gAnDuIk6 = new Object[z3XW5Ig3][];
		int nFZPEgop = skTEBufT.size();
		String[] J2zsycaT = new String[nFZPEgop];
		int SirBR4dP = 0;
		for (Integer qSI8WtKs : skTEBufT)
			J2zsycaT[SirBR4dP++] = ili7TmdZ[qSI8WtKs];
		for (int EEkUpohb = 0; EEkUpohb < z3XW5Ig3; EEkUpohb++) {
			gAnDuIk6[EEkUpohb] = new Object[nFZPEgop];
			Object[] xsEtSgXE = a3RsWlkY.get(EEkUpohb);
			SirBR4dP = 0;
			for (Integer MEGnYEq7 : skTEBufT)
				gAnDuIk6[EEkUpohb][SirBR4dP++] = xsEtSgXE[MEGnYEq7];
		}
		StringBuilder hoAmJlWy = new StringBuilder("GLM_marker_test_");
		hoAmJlWy.append(HndDikp8.getName());
		StringBuilder tAYAq8Xa = new StringBuilder("Tests of Marker-Phenotype Association");
		tAYAq8Xa.append("GLM: fixed effect linear model\n");
		tAYAq8Xa.append("Data set: ").append(HndDikp8.getName());
		tAYAq8Xa.append("\nmodel: trait = mean");
		for (int So9unQ4t = 0; So9unQ4t < O9oqqXB4.getNumberOfFactors(); So9unQ4t++) {
			tAYAq8Xa.append(" + ");
			tAYAq8Xa.append(O9oqqXB4.getFactorName(So9unQ4t));
		}
		for (int y73lt5QC = 0; y73lt5QC < O9oqqXB4.getNumberOfCovariates(); y73lt5QC++) {
			tAYAq8Xa.append(" + ");
			tAYAq8Xa.append(O9oqqXB4.getCovariateName(y73lt5QC));
		}
		tAYAq8Xa.append(" + marker");
		if (writeOutputToFile) {
			tAYAq8Xa.append("\nOutput written to " + C0WgeO2n.getPath());
		}
		TableReport eixiIqqO = new SimpleTableReport("Marker Test", J2zsycaT, gAnDuIk6);
		LsslAgmR.add(new Datum(hoAmJlWy.toString(), eixiIqqO, tAYAq8Xa.toString()));
		int[] nT4eJvFi;
		ili7TmdZ = new String[] { "Trait", "Marker", "Obs", "Locus", "Locus_pos", "Chr", "Chr_pos", "Allele",
				"Estimate" };
		if (C5dJB0rb) {
			if (UKNIT8WU && hasMap) {
				nT4eJvFi = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
			} else if (UKNIT8WU) {
				nT4eJvFi = new int[] { 0, 1, 2, 3, 4, 7, 8 };
			} else if (hasMap) {
				nT4eJvFi = new int[] { 0, 2, 3, 4, 5, 6, 7, 8 };
			} else {
				nT4eJvFi = new int[] { 0, 2, 3, 4, 7, 8 };
			}
		} else {
			if (UKNIT8WU && hasMap) {
				nT4eJvFi = new int[] { 0, 1, 2, 3, 4, 5, 6, 8 };
			} else if (UKNIT8WU) {
				nT4eJvFi = new int[] { 0, 1, 2, 3, 4, 8 };
			} else if (hasMap) {
				nT4eJvFi = new int[] { 0, 2, 3, 4, 5, 6, 8 };
			} else {
				nT4eJvFi = new int[] { 0, 2, 3, 4, 8 };
			}
		}
		z3XW5Ig3 = Q8X1SfXn.size();
		gAnDuIk6 = new Object[z3XW5Ig3][];
		nFZPEgop = nT4eJvFi.length;
		J2zsycaT = new String[nFZPEgop];
		for (int HrDq8rzA = 0; HrDq8rzA < nFZPEgop; HrDq8rzA++) {
			J2zsycaT[HrDq8rzA] = ili7TmdZ[nT4eJvFi[HrDq8rzA]];
		}
		for (int RHMPRvpl = 0; RHMPRvpl < z3XW5Ig3; RHMPRvpl++) {
			gAnDuIk6[RHMPRvpl] = new Object[nFZPEgop];
			Object[] rQpCjINK = Q8X1SfXn.get(RHMPRvpl);
			for (int tzCoBNxi = 0; tzCoBNxi < nFZPEgop; tzCoBNxi++) {
				gAnDuIk6[RHMPRvpl][tzCoBNxi] = rQpCjINK[nT4eJvFi[tzCoBNxi]];
			}
		}
		hoAmJlWy = new StringBuilder("GLM allele estimates for ");
		hoAmJlWy.append(HndDikp8.getName());
		tAYAq8Xa = new StringBuilder("Marker allele effect estimates\n");
		tAYAq8Xa.append("GLM: fixed effect linear model\n");
		tAYAq8Xa.append("Data set: ").append(HndDikp8.getName());
		tAYAq8Xa.append("\nmodel: trait = mean");
		for (int EzOHOF0z = 0; EzOHOF0z < O9oqqXB4.getNumberOfFactors(); EzOHOF0z++) {
			tAYAq8Xa.append(" + ");
			tAYAq8Xa.append(O9oqqXB4.getFactorName(EzOHOF0z));
		}
		for (int J2RMyFEv = 0; J2RMyFEv < O9oqqXB4.getNumberOfCovariates(); J2RMyFEv++) {
			tAYAq8Xa.append(" + ");
			tAYAq8Xa.append(O9oqqXB4.getCovariateName(J2RMyFEv));
		}
		tAYAq8Xa.append(" + marker");
		if (writeOutputToFile) {
			tAYAq8Xa.append("\nOutput written to " + T3F61WfO.getPath());
		}
		TableReport FIJuSALf = new SimpleTableReport("Allele Estimates", J2zsycaT, gAnDuIk6);
		LsslAgmR.add(new Datum(hoAmJlWy.toString(), FIJuSALf, tAYAq8Xa.toString()));
		fireProgress(0);
		return LsslAgmR;
	}

}