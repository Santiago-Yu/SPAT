class n21382198 {
	private void initializeTree() {
		InputStreamReader OPmQfk6T = null;
		BufferedReader kB7SLq01 = null;
		try {
			for (int lONYcOuw = 0; lONYcOuw < ORDER.length; lONYcOuw++) {
				int wQwDlG0R = ORDER[lONYcOuw];
				String tQCp2tUT = wQwDlG0R < 10 ? "0" + wQwDlG0R : (wQwDlG0R > 20 ? "big" : "" + wQwDlG0R);
				URL LUhFIC61 = EmptyClass.class.getResource("engchar" + tQCp2tUT + ".dic");
				logger.info("... Loading: " + "engchar" + tQCp2tUT + ".dic = {" + LUhFIC61 + "}");
				OPmQfk6T = new InputStreamReader(LUhFIC61.openStream());
				kB7SLq01 = new BufferedReader(OPmQfk6T);
				String YB2iZRSQ = null;
				String lDJJn9v0 = null;
				do {
					YB2iZRSQ = kB7SLq01.readLine();
					if (YB2iZRSQ != null) {
						boolean s6Cp6396 = YB2iZRSQ.endsWith("/S");
						boolean GPDTtWin = YB2iZRSQ.endsWith("/X");
						if (s6Cp6396) {
							int U47UUzA7 = YB2iZRSQ.indexOf("/S");
							lDJJn9v0 = new String(YB2iZRSQ.substring(0, U47UUzA7));
						} else if (GPDTtWin) {
							int QytcyqSq = YB2iZRSQ.indexOf("/X");
							lDJJn9v0 = new String(YB2iZRSQ.substring(0, QytcyqSq));
						} else {
							lDJJn9v0 = YB2iZRSQ.toString();
						}
						if (tree == null) {
							tree = new BKTree();
						}
						tree.insertDictionaryWord(lDJJn9v0, s6Cp6396, GPDTtWin);
					}
				} while (YB2iZRSQ != null);
			}
			logger.debug("Loading supplemental dictionary...");
			List<String> HtSxmBl9 = KSupplementalDictionaryUtil.getWords();
			for (String AyuMtGXU : HtSxmBl9) {
				tree.insertDictionaryWord(AyuMtGXU, false, false);
			}
			initialized = true;
		} catch (Exception mqGTNO81) {
			logger.error("Error", mqGTNO81);
		} finally {
			if (OPmQfk6T != null) {
				try {
					OPmQfk6T.close();
				} catch (Exception UpEALhwI) {
				}
			}
			if (kB7SLq01 != null) {
				try {
					kB7SLq01.close();
				} catch (Exception B21EpXDX) {
				}
			}
		}
	}

}