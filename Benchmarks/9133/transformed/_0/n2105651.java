class n2105651 {
	public void process(String JNN0XF0P, String FashjLaa) {
		try {
			KanjiDAO f4x1KEtv = KanjiDAOFactory.getDAO();
			MorphologicalAnalyzer iuIcFr17 = MorphologicalAnalyzer.getInstance();
			if (iuIcFr17.isActive()) {
				BufferedReader kRVH8Cw4 = new BufferedReader(
						new InputStreamReader(new FileInputStream(JNN0XF0P), "UTF8"));
				BufferedWriter EAXEZ22v = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream(FashjLaa), "UTF8"));
				String k57O0LpC;
				EAXEZ22v.write("// // // \r\n$title=\r\n$singer=\r\n$id=\r\n\r\n + _______ // 0 0 0 0 0 0 0\r\n\r\n");
				while ((k57O0LpC = kRVH8Cw4.readLine()) != null) {
					System.out.println(k57O0LpC);
					String nDR4wjjT[] = k57O0LpC.split("//");
					String YdfvsZk3 = null;
					String day2Lfnr = null;
					if (nDR4wjjT.length > 1)
						day2Lfnr = nDR4wjjT[1].trim();
					if (nDR4wjjT.length > 0)
						YdfvsZk3 = nDR4wjjT[0].trim().replaceAll(" ", "_");
					boolean g8vxpP5r = true;
					if (YdfvsZk3 != null) {
						ArrayList<ExtractedWord> LGIxPST5 = iuIcFr17.extractWord(YdfvsZk3);
						Iterator<ExtractedWord> vf3oV8qN = LGIxPST5.iterator();
						while (vf3oV8qN.hasNext()) {
							ExtractedWord ayJpTswb = vf3oV8qN.next();
							if (g8vxpP5r) {
								g8vxpP5r = false;
								EAXEZ22v.write("*");
							} else
								EAXEZ22v.write(" ");
							if (ayJpTswb.isParticle)
								EAXEZ22v.write("- ");
							else
								EAXEZ22v.write("+ ");
							if (!ayJpTswb.original.equals(ayJpTswb.reading)) {
								System.out.println("--> " + JapaneseString.toRomaji(ayJpTswb.original) + " / "
										+ JapaneseString.toRomaji(ayJpTswb.reading));
								KReading[] B3mBcGdo = ReadingAnalyzer.analyzeReadingStub(ayJpTswb.original,
										ayJpTswb.reading, f4x1KEtv);
								if (B3mBcGdo != null) {
									for (int oxKnzw3j = 0; oxKnzw3j < B3mBcGdo.length; oxKnzw3j++) {
										if (oxKnzw3j > 0)
											EAXEZ22v.write(" ");
										EAXEZ22v.write(B3mBcGdo[oxKnzw3j].kanji);
										if (B3mBcGdo[oxKnzw3j].type != KReading.KANA) {
											EAXEZ22v.write("|");
											EAXEZ22v.write(B3mBcGdo[oxKnzw3j].reading);
										}
									}
								} else {
									EAXEZ22v.write(ayJpTswb.original);
									EAXEZ22v.write("|");
									EAXEZ22v.write(ayJpTswb.reading);
								}
							} else {
								EAXEZ22v.write(ayJpTswb.original);
							}
							EAXEZ22v.write(" // \r\n");
						}
						if (day2Lfnr != null) {
							EAXEZ22v.write(day2Lfnr);
							EAXEZ22v.write("\r\n");
						}
						EAXEZ22v.write("\r\n");
					}
				}
				kRVH8Cw4.close();
				EAXEZ22v.close();
			} else {
				System.out.println("Mecab couldn't be initialized");
			}
		} catch (Exception exhcSFsq) {
			exhcSFsq.printStackTrace();
		}
	}

}