class n15295408 {
	private final long test(final boolean ZURsaiqX, final int QpVwJ2y4) throws NoSuchAlgorithmException,
			NoSuchPaddingException, FileNotFoundException, IOException, RuleLoadingException {
		final boolean rOsfzMmk = true;
		final boolean Gm8WU27t = true;
		final boolean SCSXUyuX = true;
		final boolean D6JfmdFD = true;
		final boolean grffApZo = true;
		final boolean cBebGkTF = false;
		final boolean nTn973Mq = false;
		final ContentInjectionHelper D7DEMoNe = new ContentInjectionHelper();
		final RuleFileLoader aMKHN4Lk = new ClasspathZipRuleFileLoader();
		aMKHN4Lk.setPath(RuleParameter.MODIFICATION_EXCLUDES_DEFAULT.getValue());
		final ContentModificationExcludeDefinitionContainer J6iFQJ8u = new ContentModificationExcludeDefinitionContainer(
				aMKHN4Lk);
		J6iFQJ8u.parseDefinitions();
		D7DEMoNe.setContentModificationExcludeDefinitions(J6iFQJ8u);
		final AttackHandler WJOAYP5r = new AttackHandler(null, 123, 600000, 100000, 300000, 300000, null, "MOCK", false,
				false, 0, false, false, Pattern.compile("sjghggfakgfjagfgajgfjasgfs"),
				Pattern.compile("sjghggfakgfjagfgajgfjasgfs"), true, new AttackMailHandler());
		final SessionCreationTracker n9Vnre6W = new SessionCreationTracker(WJOAYP5r, 0, 600000, 300000, 0, "", "", "",
				"");
		final RequestWrapper vyvOZFZW = new RequestWrapper(new RequestMock(), D7DEMoNe, n9Vnre6W, "123.456.789.000",
				false, true, true);
		final RuleFileLoader TchTPUDA = new ClasspathZipRuleFileLoader();
		TchTPUDA.setPath(RuleParameter.RESPONSE_MODIFICATIONS_DEFAULT.getValue());
		final ResponseModificationDefinitionContainer Y0kjXt6d = new ResponseModificationDefinitionContainer(TchTPUDA);
		Y0kjXt6d.parseDefinitions();
		final ResponseModificationDefinition[] yRR3e4Hs = downCast(Y0kjXt6d.getAllEnabledRequestDefinitions());
		final List<Pattern> GdkqoK42 = new ArrayList<Pattern>(yRR3e4Hs.length);
		final List<Pattern> DAIAmO6W = new ArrayList<Pattern>(yRR3e4Hs.length);
		final List<Pattern> C0SkVmIV = new ArrayList<Pattern>(yRR3e4Hs.length);
		final List<Pattern> VNVFYNBh = new ArrayList<Pattern>(yRR3e4Hs.length);
		final List<Pattern> ErCgOqn2 = new ArrayList<Pattern>(yRR3e4Hs.length);
		final List<Pattern> ek9aJa24 = new ArrayList<Pattern>(yRR3e4Hs.length);
		final List<WordDictionary> QsYIpRYw = new ArrayList<WordDictionary>(yRR3e4Hs.length);
		final List<WordDictionary> TWJg9CxE = new ArrayList<WordDictionary>(yRR3e4Hs.length);
		final List<WordDictionary> D2LcUVya = new ArrayList<WordDictionary>(yRR3e4Hs.length);
		final List<WordDictionary> KwMGN4KQ = new ArrayList<WordDictionary>(yRR3e4Hs.length);
		final List<WordDictionary> WWQySIbd = new ArrayList<WordDictionary>(yRR3e4Hs.length);
		final List<WordDictionary> BdJA5pwN = new ArrayList<WordDictionary>(yRR3e4Hs.length);
		final List<Integer[]> w1Dd4M7G = new ArrayList<Integer[]>(yRR3e4Hs.length);
		final List<Integer[]> EAPSkHhC = new ArrayList<Integer[]>(yRR3e4Hs.length);
		for (int gJwxNx9L = 0; gJwxNx9L < yRR3e4Hs.length; gJwxNx9L++) {
			final ResponseModificationDefinition w2yVCixk = yRR3e4Hs[gJwxNx9L];
			if (w2yVCixk.isMatchesScripts()) {
				DAIAmO6W.add(w2yVCixk.getScriptExclusionPattern());
				TWJg9CxE.add(w2yVCixk.getScriptExclusionPrefilter());
				C0SkVmIV.add(w2yVCixk.getUrlExclusionPattern());
				D2LcUVya.add(w2yVCixk.getUrlExclusionPrefilter());
				ErCgOqn2.add(w2yVCixk.getUrlCapturingPattern());
				WWQySIbd.add(w2yVCixk.getUrlCapturingPrefilter());
				w1Dd4M7G.add(ServerUtils.convertSimpleToObjectArray(w2yVCixk.getCapturingGroupNumbers()));
			}
			if (w2yVCixk.isMatchesTags()) {
				GdkqoK42.add(w2yVCixk.getTagExclusionPattern());
				QsYIpRYw.add(w2yVCixk.getTagExclusionPrefilter());
				VNVFYNBh.add(w2yVCixk.getUrlExclusionPattern());
				KwMGN4KQ.add(w2yVCixk.getUrlExclusionPrefilter());
				ek9aJa24.add(w2yVCixk.getUrlCapturingPattern());
				BdJA5pwN.add(w2yVCixk.getUrlCapturingPrefilter());
				EAPSkHhC.add(ServerUtils.convertSimpleToObjectArray(w2yVCixk.getCapturingGroupNumbers()));
			}
		}
		final Matcher[] V06PsggG = ServerUtils.convertListOfPatternToArrayOfMatcher(GdkqoK42);
		final Matcher[] HyJCqWTr = ServerUtils.convertListOfPatternToArrayOfMatcher(DAIAmO6W);
		final Matcher[] O5gUjtQS = ServerUtils.convertListOfPatternToArrayOfMatcher(C0SkVmIV);
		final Matcher[] Tg1QfWWm = ServerUtils.convertListOfPatternToArrayOfMatcher(VNVFYNBh);
		final Matcher[] pQeg72lY = ServerUtils.convertListOfPatternToArrayOfMatcher(ErCgOqn2);
		final Matcher[] gIoDw2p2 = ServerUtils.convertListOfPatternToArrayOfMatcher(ek9aJa24);
		final WordDictionary[] uW2sl908 = (WordDictionary[]) QsYIpRYw.toArray(new WordDictionary[0]);
		final WordDictionary[] rFGXVkUL = (WordDictionary[]) TWJg9CxE.toArray(new WordDictionary[0]);
		final WordDictionary[] jvEPaWOj = (WordDictionary[]) D2LcUVya.toArray(new WordDictionary[0]);
		final WordDictionary[] CC1jx9gB = (WordDictionary[]) KwMGN4KQ.toArray(new WordDictionary[0]);
		final WordDictionary[] w4CaHo2I = (WordDictionary[]) WWQySIbd.toArray(new WordDictionary[0]);
		final WordDictionary[] QRUik5Nv = (WordDictionary[]) BdJA5pwN.toArray(new WordDictionary[0]);
		final int[][] JZ13iKln = ServerUtils.convertArrayIntegerListTo2DimIntArray(w1Dd4M7G);
		final int[][] LyCKjWN0 = ServerUtils.convertArrayIntegerListTo2DimIntArray(EAPSkHhC);
		final Cipher ZI05BpBA = CryptoUtils.getCipher();
		final CryptoKeyAndSalt tSL8MpSm = CryptoUtils.generateRandomCryptoKeyAndSalt(false);
		Cipher.getInstance("AES");
		MessageDigest.getInstance("SHA-1");
		final ResponseWrapper e132WQPp = new ResponseWrapper(new ResponseMock(), vyvOZFZW, WJOAYP5r, D7DEMoNe, false,
				"___ENCRYPTED___", ZI05BpBA, tSL8MpSm, "___SEC-KEY___", "___SEC-VALUE___", "___PROT-KEY___", false,
				false, false, false, "123.456.789.000", new HashSet(), rFGXVkUL, HyJCqWTr, uW2sl908, V06PsggG, jvEPaWOj,
				O5gUjtQS, CC1jx9gB, Tg1QfWWm, w4CaHo2I, pQeg72lY, QRUik5Nv, gIoDw2p2, JZ13iKln, LyCKjWN0, true, false,
				true, true, true, true, true, true, true, true, true, false, false, true, "", "", (short) 3, true,
				false, false);
		final List n7bi11e4 = new ArrayList();
		for (int FDggDBnx = 0; FDggDBnx < QpVwJ2y4; FDggDBnx++) {
			final long OzyECMzG = System.currentTimeMillis();
			Reader X0zrs4yy = null;
			Writer clDBw7Lt = null;
			try {
				X0zrs4yy = new BufferedReader(new FileReader(this.htmlFile));
				clDBw7Lt = new FileWriter(this.outputFile);
				if (ZURsaiqX) {
					clDBw7Lt = new ResponseFilterWriter(clDBw7Lt, true, "http://127.0.0.1/test/sample", "/test",
							"/test", "___SEC-KEY___", "___SEC-VALUE___", "___PROT-KEY___", ZI05BpBA, tSL8MpSm, D7DEMoNe,
							"___ENCRYPTED___", vyvOZFZW, e132WQPp, rOsfzMmk, Gm8WU27t, D6JfmdFD, SCSXUyuX, grffApZo,
							cBebGkTF, nTn973Mq, rFGXVkUL, HyJCqWTr, uW2sl908, V06PsggG, jvEPaWOj, O5gUjtQS, CC1jx9gB,
							Tg1QfWWm, w4CaHo2I, pQeg72lY, QRUik5Nv, gIoDw2p2, JZ13iKln, LyCKjWN0, true, true, false,
							true, true, true, true, true, true, true, true, false, false, true, "", "", (short) 3, true,
							false);
					clDBw7Lt = new BufferedWriter(clDBw7Lt);
				}
				char[] EVPmMMok = new char[16 * 1024];
				int sVnHQdSQ;
				while ((sVnHQdSQ = X0zrs4yy.read(EVPmMMok)) != -1) {
					if (sVnHQdSQ > 0) {
						clDBw7Lt.write(EVPmMMok, 0, sVnHQdSQ);
					}
				}
				n7bi11e4.add(new Long(System.currentTimeMillis() - OzyECMzG));
			} finally {
				if (X0zrs4yy != null) {
					try {
						X0zrs4yy.close();
					} catch (IOException CaWE9YKv) {
					}
				}
				if (clDBw7Lt != null) {
					try {
						clDBw7Lt.close();
					} catch (IOException tKQYZMWE) {
					}
				}
			}
		}
		long CpmFFl7y = 0;
		for (final Iterator hhO1UULH = n7bi11e4.iterator(); hhO1UULH.hasNext();) {
			Long VmCILOkj = (Long) hhO1UULH.next();
			CpmFFl7y += VmCILOkj.longValue();
		}
		return CpmFFl7y / n7bi11e4.size();
	}

}