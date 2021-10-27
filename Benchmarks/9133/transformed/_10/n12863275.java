class n12863275 {
	@Override
	protected Integer doInBackground() throws Exception {
		combinationMap = new HashMap<AnsweredQuestion, Integer>();
		int numOfRows = 0;
		LinkedHashSet<AnsweredQuestion> answeredQuestionSet = new LinkedHashSet<AnsweredQuestion>();
		combinationMapReverse = new HashMap<Integer, AnsweredQuestion>();
		final String delimiter = ";";
		LinkedHashSet<Integer> studentSet = new LinkedHashSet<Integer>();
		final String typeToProcess = "F";
		String line;
		String[] chunks = new String[9];
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), "ISO-8859-2"));
			in.readLine();
			while ((line = in.readLine()) != null) {
				numOfRows++;
				chunks = line.split(delimiter);
				if (chunks[2].equals(typeToProcess)) {
					answeredQuestionSet.add(new AnsweredQuestion(chunks[4], chunks[5]));
					studentSet.add(new Integer(chunks[0]));
				}
			}
			in.close();
			Integer I;
			int i = 0;
			for (AnsweredQuestion pair : answeredQuestionSet) {
				I = new Integer(i++);
				combinationMap.put(pair, I);
				combinationMapReverse.put(I, pair);
			}
			int lastStudentNumber = -1;
			matrix = new SparseObjectMatrix2D(answeredQuestionSet.size(), studentSet.size());
			in = new BufferedReader(new InputStreamReader(url.openStream(), "ISO-8859-2"));
			AnsweredQuestion pair;
			in.readLine();
			while ((line = in.readLine()) != null) {
				pair = null;
				chunks = line.split(delimiter);
				if (chunks[2].equals(typeToProcess)) {
					if (Integer.parseInt(chunks[0]) != lastStudentNumber) {
						lastStudentNumber++;
					}
					pair = new AnsweredQuestion(chunks[4], chunks[5]);
					if (combinationMap.containsKey(pair)) {
						matrix.setQuick(combinationMap.get(pair), lastStudentNumber, Boolean.TRUE);
					}
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ObjectMatrix1D row = null;
		supportVector = new int[combinationMap.size()];
		for (int i = 0; i < combinationMap.size(); i++) {
			int sum = 0;
			row = matrix.viewRow(i);
			for (int k = 0; k < row.size(); k++) {
				if (row.getQuick(k) != null && row.getQuick(k).equals(Boolean.TRUE)) {
					sum++;
				}
			}
			supportVector[i] = sum;
		}
		applet.combinationMap = this.combinationMap;
		applet.combinationMapReverse = this.combinationMapReverse;
		applet.matrix = this.matrix;
		applet.supportVector = supportVector;
		System.out.println("data loaded.");
		return null;
	}

}