class n10690321 {
	private static void readData() {
		StringTokenizer HCLR057q;
		topSet = new HashSet();
		HCLR057q = new StringTokenizer(tops, ",");
		while (HCLR057q.hasMoreTokens())
			topSet.add(HCLR057q.nextToken());
		leftSet = new HashSet();
		HCLR057q = new StringTokenizer(lefts, ",");
		while (HCLR057q.hasMoreTokens())
			leftSet.add(HCLR057q.nextToken());
		rightSet = new HashSet();
		HCLR057q = new StringTokenizer(rights, ",");
		while (HCLR057q.hasMoreTokens())
			rightSet.add(HCLR057q.nextToken());
		farRightSet = new HashSet();
		HCLR057q = new StringTokenizer(farrights, ",");
		while (HCLR057q.hasMoreTokens())
			farRightSet.add(HCLR057q.nextToken());
		vowelSet = new HashSet();
		HCLR057q = new StringTokenizer(vowels, ",");
		while (HCLR057q.hasMoreTokens()) {
			String CWQeS7NB;
			vowelSet.add(CWQeS7NB = HCLR057q.nextToken());
			if (maxEwtsVowelLength < CWQeS7NB.length())
				maxEwtsVowelLength = CWQeS7NB.length();
			validInputSequences.put(CWQeS7NB, anyOldObjectWillDo);
		}
		puncSet = new HashSet();
		HCLR057q = new StringTokenizer(others, ",");
		while (HCLR057q.hasMoreTokens()) {
			String RRb1vUfp;
			puncSet.add(RRb1vUfp = HCLR057q.nextToken());
			validInputSequences.put(RRb1vUfp, anyOldObjectWillDo);
		}
		charSet = new HashSet();
		tibSet = new HashSet();
		HCLR057q = new StringTokenizer(tibetanConsonants, ",");
		while (HCLR057q.hasMoreTokens()) {
			String RLFm3TWs;
			charSet.add(RLFm3TWs = HCLR057q.nextToken());
			tibSet.add(RLFm3TWs);
			validInputSequences.put(RLFm3TWs, anyOldObjectWillDo);
		}
		sanskritStackSet = new HashSet();
		HCLR057q = new StringTokenizer(otherConsonants, ",");
		while (HCLR057q.hasMoreTokens()) {
			String dXbRiJ1R;
			charSet.add(dXbRiJ1R = HCLR057q.nextToken());
			sanskritStackSet.add(dXbRiJ1R);
			validInputSequences.put(dXbRiJ1R, anyOldObjectWillDo);
		}
		numberSet = new HashSet();
		HCLR057q = new StringTokenizer(numbers, ",");
		while (HCLR057q.hasMoreTokens()) {
			String NQRvp0fP;
			charSet.add(NQRvp0fP = HCLR057q.nextToken());
			numberSet.add(NQRvp0fP);
			validInputSequences.put(NQRvp0fP, anyOldObjectWillDo);
		}
		charSet.add("Y");
		charSet.add("R");
		charSet.add("W");
		validInputSequences.put("Y", anyOldObjectWillDo);
		validInputSequences.put("R", anyOldObjectWillDo);
		validInputSequences.put("W", anyOldObjectWillDo);
		HCLR057q = null;
		top_vowels = new HashSet();
		top_vowels.add(i_VOWEL);
		top_vowels.add(e_VOWEL);
		top_vowels.add(o_VOWEL);
		top_vowels.add(ai_VOWEL);
		top_vowels.add(au_VOWEL);
		top_vowels.add(reverse_i_VOWEL);
		try {
			URL eznMng5U = TibetanMachineWeb.class.getResource(fileName);
			if (eznMng5U == null) {
				System.err.println("Cannot find " + fileName + "; aborting.");
				System.exit(1);
			}
			InputStreamReader lJvzVVAm = new InputStreamReader(eznMng5U.openStream());
			BufferedReader WDdSQYO7 = new BufferedReader(lJvzVVAm);
			System.out.println("Reading Tibetan Machine Web code table " + fileName);
			String gs4BKdme;
			boolean HuqUtjje = false;
			boolean RRegkjAr = false;
			boolean vZmz0oNc = false;
			boolean jf0RmeXt = false;
			while ((gs4BKdme = WDdSQYO7.readLine()) != null) {
				if (gs4BKdme.startsWith("<?")) {
					if (gs4BKdme.equalsIgnoreCase("<?Consonants?>")) {
						vZmz0oNc = false;
						RRegkjAr = true;
						HuqUtjje = false;
						jf0RmeXt = false;
						do {
							gs4BKdme = WDdSQYO7.readLine();
						} while (gs4BKdme.startsWith("//") || gs4BKdme.equals(""));
					} else if (gs4BKdme.equalsIgnoreCase("<?Numbers?>")) {
						vZmz0oNc = false;
						RRegkjAr = false;
						HuqUtjje = false;
						jf0RmeXt = false;
						do {
							gs4BKdme = WDdSQYO7.readLine();
						} while (gs4BKdme.startsWith("//") || gs4BKdme.equals(""));
					} else if (gs4BKdme.equalsIgnoreCase("<?Vowels?>")) {
						vZmz0oNc = false;
						RRegkjAr = false;
						HuqUtjje = false;
						jf0RmeXt = false;
						do {
							gs4BKdme = WDdSQYO7.readLine();
						} while (gs4BKdme.startsWith("//") || gs4BKdme.equals(""));
					} else if (gs4BKdme.equalsIgnoreCase("<?Other?>")) {
						vZmz0oNc = false;
						RRegkjAr = false;
						HuqUtjje = false;
						jf0RmeXt = false;
						do {
							gs4BKdme = WDdSQYO7.readLine();
						} while (gs4BKdme.startsWith("//") || gs4BKdme.equals(""));
					} else if (gs4BKdme.equalsIgnoreCase("<?Input:Punctuation?>")
							|| gs4BKdme.equalsIgnoreCase("<?Input:Vowels?>")) {
						vZmz0oNc = false;
						RRegkjAr = false;
						HuqUtjje = true;
						jf0RmeXt = false;
					} else if (gs4BKdme.equalsIgnoreCase("<?Input:Tibetan?>")) {
						vZmz0oNc = false;
						RRegkjAr = true;
						HuqUtjje = true;
						jf0RmeXt = false;
					} else if (gs4BKdme.equalsIgnoreCase("<?Input:Numbers?>")) {
						vZmz0oNc = false;
						RRegkjAr = false;
						HuqUtjje = true;
						jf0RmeXt = false;
					} else if (gs4BKdme.equalsIgnoreCase("<?Input:Sanskrit?>")) {
						vZmz0oNc = true;
						RRegkjAr = false;
						HuqUtjje = true;
						jf0RmeXt = false;
					} else if (gs4BKdme.equalsIgnoreCase("<?ToWylie?>")) {
						vZmz0oNc = false;
						RRegkjAr = false;
						HuqUtjje = false;
						jf0RmeXt = false;
					} else if (gs4BKdme.equalsIgnoreCase("<?Ignore?>")) {
						vZmz0oNc = false;
						jf0RmeXt = true;
					}
				} else if (gs4BKdme.startsWith("//")) {
					;
				} else if (gs4BKdme.equals("")) {
					;
				} else {
					StringTokenizer Gf1hZoqh = new StringTokenizer(gs4BKdme, DELIMITER, true);
					String qa4pfFre = null;
					DuffCode[] wBOpZyig;
					wBOpZyig = new DuffCode[11];
					int sjd1FWvc = 0;
					StringBuffer bjhSUggV = new StringBuffer("");
					ThdlDebug.verify(bjhSUggV.length() == 0);
					while (Gf1hZoqh.hasMoreTokens()) {
						String NKVWVWfq = getEscapedToken(Gf1hZoqh, bjhSUggV);
						if (NKVWVWfq.equals(DELIMITER) && bjhSUggV.length() == 0) {
							sjd1FWvc++;
						} else if (!NKVWVWfq.equals("")) {
							if (bjhSUggV.length() != 0) {
								bjhSUggV = new StringBuffer("");
								ThdlDebug.verify(bjhSUggV.length() == 0);
							}
							switch (sjd1FWvc) {
							case 0:
								qa4pfFre = NKVWVWfq;
								break;
							case 1:
								wBOpZyig[TM] = new DuffCode(NKVWVWfq, false);
								break;
							case 2:
								if (!jf0RmeXt) {
									wBOpZyig[REDUCED_C] = new DuffCode(NKVWVWfq, true);
								}
								break;
							case 3:
								wBOpZyig[TMW] = new DuffCode(NKVWVWfq, true);
								if (null != wBOpZyig[TM]) {
									TMtoTMW[wBOpZyig[TM].getFontNum() - 1][wBOpZyig[TM].getCharNum()
											- 32] = wBOpZyig[TMW];
								}
								if (null != TMWtoTM[wBOpZyig[TMW].getFontNum() - 1][wBOpZyig[TMW].getCharNum() - 32])
									throw new Error(
											"tibwn.ini is supposed to use the TibetanMachineWeb glyph as the unique key, but "
													+ NKVWVWfq + " appears two or more times.");
								TMWtoTM[wBOpZyig[TMW].getFontNum() - 1][wBOpZyig[TMW].getCharNum() - 32] = wBOpZyig[TM];
								if (qa4pfFre.toLowerCase().startsWith("\\uf0")) {
									int kiRq03bg = Integer.parseInt(qa4pfFre.substring("\\u".length()), 16);
									ThdlDebug.verify((kiRq03bg >= 0xF000 && kiRq03bg <= 0xF0FF));
									NonUnicodeToTMW[kiRq03bg - '?'] = new DuffCode[] { wBOpZyig[TMW] };
								}
								break;
							case 4:
							case 5:
							case 6:
							case 7:
							case 8:
							case 9:
								if (!jf0RmeXt) {
									try {
										wBOpZyig[sjd1FWvc - 1] = new DuffCode(NKVWVWfq, true);
									} catch (Exception uBAdwPDm) {
										System.err.println("Couldn't make a DuffCode out of " + NKVWVWfq + "; line is "
												+ gs4BKdme + "; k is " + sjd1FWvc);
									}
								}
								break;
							case 10:
								if (!NKVWVWfq.equals("none")) {
									StringBuffer xLPHEKBT = new StringBuffer();
									StringTokenizer hUbJSkUo = new StringTokenizer(NKVWVWfq, ",");
									while (hUbJSkUo.hasMoreTokens()) {
										String lodFpKIw = hUbJSkUo.nextToken();
										ThdlDebug.verify(lodFpKIw.length() == 4 || lodFpKIw.length() == 3);
										try {
											int NGcJxP4W = Integer.parseInt(lodFpKIw, 16);
											ThdlDebug.verify((NGcJxP4W >= 0x0F00 && NGcJxP4W <= 0x0FFF)
													|| NGcJxP4W == 0x5350 || NGcJxP4W == 0x534D || NGcJxP4W == 0x0020
													|| NGcJxP4W == 0x00A0 || NGcJxP4W == 0x2003);
											xLPHEKBT.append((char) NGcJxP4W);
										} catch (NumberFormatException fdLCOERM) {
											ThdlDebug.verify(false);
										}
									}
									TMWtoUnicode[wBOpZyig[TMW].getFontNum() - 1][wBOpZyig[TMW].getCharNum()
											- 32] = xLPHEKBT.toString();
									char h79CEEK6;
									if (xLPHEKBT.length() == 1
											&& UnicodeUtils.isInTibetanRange(h79CEEK6 = xLPHEKBT.charAt(0))) {
										if (null != UnicodeToTMW[h79CEEK6 - '?'][0] && '?' != h79CEEK6
												&& '?' != h79CEEK6 && '?' != h79CEEK6 && '?' != h79CEEK6
												&& '?' != h79CEEK6 && '?' != h79CEEK6 && '?' != h79CEEK6
												&& '?' != h79CEEK6 && '?' != h79CEEK6 && '?' != h79CEEK6
												&& '?' != h79CEEK6 && '?' != h79CEEK6 && '?' != h79CEEK6
												&& '?' != h79CEEK6 && '?' != h79CEEK6 && '?' != h79CEEK6
												&& '?' != h79CEEK6 && '?' != h79CEEK6 && '?' != h79CEEK6
												&& '?' != h79CEEK6 && '?' != h79CEEK6 && '?' != h79CEEK6
												&& '?' != h79CEEK6 && '?' != h79CEEK6 && '?' != h79CEEK6
												&& '?' != h79CEEK6 && '?' != h79CEEK6 && '?' != h79CEEK6
												&& '?' != h79CEEK6) {
											throw new Error(
													"tibwn.ini has more than one TMW fellow listed that has the Unicode "
															+ NKVWVWfq
															+ ", but it's not on the list of specially handled glyphs");
										}
										UnicodeToTMW[h79CEEK6 - '?'][0] = wBOpZyig[TMW];
									}
								}
								break;
							case 11:
								if (!jf0RmeXt) {
									wBOpZyig[HALF_C] = new DuffCode(NKVWVWfq, true);
								}
								break;
							case 12:
								if (!jf0RmeXt) {
									DuffCode dvtn2dPX = new DuffCode(NKVWVWfq, true);
									binduMap.put(wBOpZyig[TMW], dvtn2dPX);
								}
								break;
							case 13:
								throw new Error("tibwn.ini has only 13 columns, you tried to use a 14th column.");
							}
						} else {
							if (sjd1FWvc == 10) {
								throw new Error("needed none or some unicode; line is " + gs4BKdme);
							}
						}
					}
					if (sjd1FWvc < 10) {
						throw new Error("needed none or some unicode; line is " + gs4BKdme);
					}
					if (!jf0RmeXt) {
						if (null == qa4pfFre)
							throw new Error(fileName + " has a line ^" + DELIMITER
									+ " which means that no Wylie is assigned.  That isn't supported.");
						if (HuqUtjje) {
							tibHash.put(Manipulate.unescape(qa4pfFre), wBOpZyig);
						}
						if (RRegkjAr) {
							StringBuffer W2DqdGbT = new StringBuffer(qa4pfFre);
							for (int dNnW12ij = 0; dNnW12ij < W2DqdGbT.length(); dNnW12ij++) {
								if (W2DqdGbT.charAt(dNnW12ij) == '-') {
									W2DqdGbT.deleteCharAt(dNnW12ij);
									--dNnW12ij;
								}
							}
							tibSet.add(W2DqdGbT.toString());
						}
						if (vZmz0oNc) {
							sanskritStackSet.add(qa4pfFre);
						}
						if (null == wBOpZyig[TMW])
							throw new Error(fileName + " has a line with wylie " + qa4pfFre
									+ " but no TMW; that's not allowed");
						int yC5cOnjT = wBOpZyig[TMW].getFontNum();
						int YFwkbBWm = wBOpZyig[TMW].getCharNum() - 32;
						toHashKey[yC5cOnjT][YFwkbBWm] = Manipulate.unescape(qa4pfFre);
					}
				}
			}
		} catch (IOException ZeAa3o1k) {
			System.out.println("file Disappeared");
			ThdlDebug.noteIffyCode();
		}
	}

}