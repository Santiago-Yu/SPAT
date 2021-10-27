class n23370708 {
	private final long test(final boolean xtCKbUf1, final int PrrrSClw) throws NoSuchAlgorithmException,
			NoSuchPaddingException, FileNotFoundException, IOException, RuleLoadingException {
		final boolean DurNdE0Z = true;
		final boolean HpBD24d1 = true;
		final boolean mU8YF2Sc = true;
		final boolean pBLQCNJL = true;
		final boolean tbZOM84r = true;
		final boolean iUh89QjA = false;
		final boolean GROEj0Q4 = false;
		final ContentInjectionHelper GTGjXjG5 = new ContentInjectionHelper();
		final RuleFileLoader FlQYXltY = new ClasspathZipRuleFileLoader();
		FlQYXltY.setPath(WebCastellumFilter.MODIFICATION_EXCLUDES_DEFAULT);
		final ContentModificationExcludeDefinitionContainer RdBTtMEn = new ContentModificationExcludeDefinitionContainer(
				FlQYXltY);
		RdBTtMEn.parseDefinitions();
		GTGjXjG5.setContentModificationExcludeDefinitions(RdBTtMEn);
		final AttackHandler QxaplIbJ = new AttackHandler(null, 123, 600000, 100000, 300000, 300000, null, "MOCK", false,
				false, 0, false, false, Pattern.compile("sjghggfakgfjagfgajgfjasgfs"),
				Pattern.compile("sjghggfakgfjagfgajgfjasgfs"), true);
		final SessionCreationTracker rWei75Fz = new SessionCreationTracker(QxaplIbJ, 0, 600000, 300000, 0, "", "", "",
				"");
		final RequestWrapper XzQNFJjb = new RequestWrapper(new RequestMock(), GTGjXjG5, rWei75Fz, "123.456.789.000",
				false, true, true);
		final RuleFileLoader CEdaF33q = new ClasspathZipRuleFileLoader();
		CEdaF33q.setPath(WebCastellumFilter.RESPONSE_MODIFICATIONS_DEFAULT);
		final ResponseModificationDefinitionContainer s9WT6Xs7 = new ResponseModificationDefinitionContainer(CEdaF33q);
		s9WT6Xs7.parseDefinitions();
		final ResponseModificationDefinition[] OIrvUaxw = downCast(s9WT6Xs7.getAllEnabledRequestDefinitions());
		final List xgpnSGsc = new ArrayList(OIrvUaxw.length);
		final List qbm5SEVh = new ArrayList(OIrvUaxw.length);
		final List F3y2e5r2 = new ArrayList(OIrvUaxw.length);
		final List z7trvWd4 = new ArrayList(OIrvUaxw.length);
		final List deC7w8Xr = new ArrayList(OIrvUaxw.length);
		final List NA3AukP7 = new ArrayList(OIrvUaxw.length);
		final List VYyJ7NJc = new ArrayList(OIrvUaxw.length);
		final List MFt0Tp3k = new ArrayList(OIrvUaxw.length);
		final List VEZMBeh0 = new ArrayList(OIrvUaxw.length);
		final List sEkO8r5T = new ArrayList(OIrvUaxw.length);
		final List VcIiyAok = new ArrayList(OIrvUaxw.length);
		final List QYyj9B6F = new ArrayList(OIrvUaxw.length);
		final List pQXS5adF = new ArrayList(OIrvUaxw.length);
		final List TsSo36ll = new ArrayList(OIrvUaxw.length);
		for (int C17py6Sn = 0; C17py6Sn < OIrvUaxw.length; C17py6Sn++) {
			final ResponseModificationDefinition Jqu29KZt = OIrvUaxw[C17py6Sn];
			if (Jqu29KZt.isMatchesScripts()) {
				qbm5SEVh.add(Jqu29KZt.getScriptExclusionPattern());
				MFt0Tp3k.add(Jqu29KZt.getScriptExclusionPrefilter());
				F3y2e5r2.add(Jqu29KZt.getUrlExclusionPattern());
				VEZMBeh0.add(Jqu29KZt.getUrlExclusionPrefilter());
				deC7w8Xr.add(Jqu29KZt.getUrlCapturingPattern());
				VcIiyAok.add(Jqu29KZt.getUrlCapturingPrefilter());
				pQXS5adF.add(ServerUtils.convertSimpleToObjectArray(Jqu29KZt.getCapturingGroupNumbers()));
			}
			if (Jqu29KZt.isMatchesTags()) {
				xgpnSGsc.add(Jqu29KZt.getTagExclusionPattern());
				VYyJ7NJc.add(Jqu29KZt.getTagExclusionPrefilter());
				z7trvWd4.add(Jqu29KZt.getUrlExclusionPattern());
				sEkO8r5T.add(Jqu29KZt.getUrlExclusionPrefilter());
				NA3AukP7.add(Jqu29KZt.getUrlCapturingPattern());
				QYyj9B6F.add(Jqu29KZt.getUrlCapturingPrefilter());
				TsSo36ll.add(ServerUtils.convertSimpleToObjectArray(Jqu29KZt.getCapturingGroupNumbers()));
			}
		}
		final Matcher[] tgEfB1EV = ServerUtils.convertListOfPatternToArrayOfMatcher(xgpnSGsc);
		final Matcher[] WWqEVn4Q = ServerUtils.convertListOfPatternToArrayOfMatcher(qbm5SEVh);
		final Matcher[] UbhVCVS6 = ServerUtils.convertListOfPatternToArrayOfMatcher(F3y2e5r2);
		final Matcher[] WRIWovBg = ServerUtils.convertListOfPatternToArrayOfMatcher(z7trvWd4);
		final Matcher[] uKkjUYa7 = ServerUtils.convertListOfPatternToArrayOfMatcher(deC7w8Xr);
		final Matcher[] pYya3lT8 = ServerUtils.convertListOfPatternToArrayOfMatcher(NA3AukP7);
		final WordDictionary[] yBTcUnub = (WordDictionary[]) VYyJ7NJc.toArray(new WordDictionary[0]);
		final WordDictionary[] zlrv7rWi = (WordDictionary[]) MFt0Tp3k.toArray(new WordDictionary[0]);
		final WordDictionary[] jsTdmsRt = (WordDictionary[]) VEZMBeh0.toArray(new WordDictionary[0]);
		final WordDictionary[] cznpjiWk = (WordDictionary[]) sEkO8r5T.toArray(new WordDictionary[0]);
		final WordDictionary[] ccYnAXuY = (WordDictionary[]) VcIiyAok.toArray(new WordDictionary[0]);
		final WordDictionary[] YMldFy5F = (WordDictionary[]) QYyj9B6F.toArray(new WordDictionary[0]);
		final int[][] VRC0co1s = ServerUtils.convertArrayIntegerListTo2DimIntArray(pQXS5adF);
		final int[][] TXwDkL67 = ServerUtils.convertArrayIntegerListTo2DimIntArray(TsSo36ll);
		final Cipher fWl8Cr7H = CryptoUtils.getCipher();
		final CryptoKeyAndSalt tGfrSwT5 = CryptoUtils.generateRandomCryptoKeyAndSalt(false);
		Cipher.getInstance("AES");
		MessageDigest.getInstance("SHA-1");
		final ResponseWrapper D0wKJY3m = new ResponseWrapper(new ResponseMock(), XzQNFJjb, QxaplIbJ, GTGjXjG5, false,
				"___ENCRYPTED___", fWl8Cr7H, tGfrSwT5, "___SEC-KEY___", "___SEC-VALUE___", "___PROT-KEY___", false,
				false, false, false, "123.456.789.000", new HashSet(), zlrv7rWi, WWqEVn4Q, yBTcUnub, tgEfB1EV, jsTdmsRt,
				UbhVCVS6, cznpjiWk, WRIWovBg, ccYnAXuY, uKkjUYa7, YMldFy5F, pYya3lT8, VRC0co1s, TXwDkL67, true, false,
				true, true, true, true, true, true, true, true, true, false, false, true, "", "", (short) 3, true,
				false, false);
		final List Us5PIVh6 = new ArrayList();
		for (int tEa9kJfC = 0; tEa9kJfC < PrrrSClw; tEa9kJfC++) {
			final long aehwN01B = System.currentTimeMillis();
			Reader SFFAk43W = null;
			Writer gTEdTJc7 = null;
			try {
				SFFAk43W = new BufferedReader(new FileReader(this.htmlFile));
				gTEdTJc7 = new FileWriter(this.outputFile);
				if (xtCKbUf1) {
					gTEdTJc7 = new ResponseFilterWriter(gTEdTJc7, true, "http://127.0.0.1/test/sample", "/test",
							"/test", "___SEC-KEY___", "___SEC-VALUE___", "___PROT-KEY___", fWl8Cr7H, tGfrSwT5, GTGjXjG5,
							"___ENCRYPTED___", XzQNFJjb, D0wKJY3m, DurNdE0Z, HpBD24d1, pBLQCNJL, mU8YF2Sc, tbZOM84r,
							iUh89QjA, GROEj0Q4, zlrv7rWi, WWqEVn4Q, yBTcUnub, tgEfB1EV, jsTdmsRt, UbhVCVS6, cznpjiWk,
							WRIWovBg, ccYnAXuY, uKkjUYa7, YMldFy5F, pYya3lT8, VRC0co1s, TXwDkL67, true, true, false,
							true, true, true, true, true, true, true, true, false, false, true, "", "", (short) 3, true,
							false);
					gTEdTJc7 = new BufferedWriter(gTEdTJc7);
				}
				char[] DsbXL8RK = new char[16 * 1024];
				int bER5L1Ny;
				while ((bER5L1Ny = SFFAk43W.read(DsbXL8RK)) != -1) {
					if (bER5L1Ny > 0) {
						gTEdTJc7.write(DsbXL8RK, 0, bER5L1Ny);
					}
				}
				Us5PIVh6.add(new Long(System.currentTimeMillis() - aehwN01B));
			} finally {
				if (SFFAk43W != null) {
					try {
						SFFAk43W.close();
					} catch (IOException aioxvskt) {
					}
				}
				if (gTEdTJc7 != null) {
					try {
						gTEdTJc7.close();
					} catch (IOException TUdn21pP) {
					}
				}
			}
		}
		long qBWOfmbI = 0;
		for (final Iterator qVwHuyvB = Us5PIVh6.iterator(); qVwHuyvB.hasNext();) {
			Long P5YtOdBE = (Long) qVwHuyvB.next();
			qBWOfmbI += P5YtOdBE.longValue();
		}
		return qBWOfmbI / Us5PIVh6.size();
	}

}