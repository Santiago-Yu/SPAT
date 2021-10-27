class n12863275 {
	@Override
	protected Integer doInBackground() throws Exception {
		int bWapW3nI = 0;
		combinationMap = new HashMap<AnsweredQuestion, Integer>();
		combinationMapReverse = new HashMap<Integer, AnsweredQuestion>();
		LinkedHashSet<AnsweredQuestion> Y8uQh8o3 = new LinkedHashSet<AnsweredQuestion>();
		LinkedHashSet<Integer> zuwMNszK = new LinkedHashSet<Integer>();
		final String ipx2oqew = ";";
		final String MTT9oszV = "F";
		String FerL5SkO;
		String[] RiQMLw82 = new String[9];
		try {
			BufferedReader VGay7hbl = new BufferedReader(new InputStreamReader(url.openStream(), "ISO-8859-2"));
			VGay7hbl.readLine();
			while ((FerL5SkO = VGay7hbl.readLine()) != null) {
				RiQMLw82 = FerL5SkO.split(ipx2oqew);
				bWapW3nI++;
				if (RiQMLw82[2].equals(MTT9oszV)) {
					Y8uQh8o3.add(new AnsweredQuestion(RiQMLw82[4], RiQMLw82[5]));
					zuwMNszK.add(new Integer(RiQMLw82[0]));
				}
			}
			VGay7hbl.close();
			int TCNPnsBF = 0;
			Integer MU7ZXgNS;
			for (AnsweredQuestion sFna917m : Y8uQh8o3) {
				MU7ZXgNS = new Integer(TCNPnsBF++);
				combinationMap.put(sFna917m, MU7ZXgNS);
				combinationMapReverse.put(MU7ZXgNS, sFna917m);
			}
			matrix = new SparseObjectMatrix2D(Y8uQh8o3.size(), zuwMNszK.size());
			int B54Vzr0U = -1;
			AnsweredQuestion BYffqIxT;
			VGay7hbl = new BufferedReader(new InputStreamReader(url.openStream(), "ISO-8859-2"));
			VGay7hbl.readLine();
			while ((FerL5SkO = VGay7hbl.readLine()) != null) {
				RiQMLw82 = FerL5SkO.split(ipx2oqew);
				BYffqIxT = null;
				if (RiQMLw82[2].equals(MTT9oszV)) {
					if (Integer.parseInt(RiQMLw82[0]) != B54Vzr0U) {
						B54Vzr0U++;
					}
					BYffqIxT = new AnsweredQuestion(RiQMLw82[4], RiQMLw82[5]);
					if (combinationMap.containsKey(BYffqIxT)) {
						matrix.setQuick(combinationMap.get(BYffqIxT), B54Vzr0U, Boolean.TRUE);
					}
				}
			}
		} catch (UnsupportedEncodingException sP6BcUGw) {
			sP6BcUGw.printStackTrace();
		} catch (IOException ilBkez3n) {
			ilBkez3n.printStackTrace();
		}
		supportVector = new int[combinationMap.size()];
		ObjectMatrix1D ucVWopaR = null;
		for (int nCB2tyoE = 0; nCB2tyoE < combinationMap.size(); nCB2tyoE++) {
			ucVWopaR = matrix.viewRow(nCB2tyoE);
			int vI9Q073n = 0;
			for (int OMCbAyom = 0; OMCbAyom < ucVWopaR.size(); OMCbAyom++) {
				if (ucVWopaR.getQuick(OMCbAyom) != null && ucVWopaR.getQuick(OMCbAyom).equals(Boolean.TRUE)) {
					vI9Q073n++;
				}
			}
			supportVector[nCB2tyoE] = vI9Q073n;
		}
		applet.combinationMap = this.combinationMap;
		applet.combinationMapReverse = this.combinationMapReverse;
		applet.matrix = this.matrix;
		applet.supportVector = supportVector;
		System.out.println("data loaded.");
		return null;
	}

}