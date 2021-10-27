class n16215393 {
	public void importSequences() {
		names = new ArrayList<String>();
		sequences = new ArrayList<String>();
		try {
			InputStream bm3mlJCK = urls[urlComboBox.getSelectedIndex()].openStream();
			ImportHelper SmMEJbst = new ImportHelper(new InputStreamReader(bm3mlJCK));
			int gB6OQuau = SmMEJbst.read();
			while (gB6OQuau != '>') {
				gB6OQuau = SmMEJbst.read();
			}
			do {
				String niS1VvBN = SmMEJbst.readLine();
				StringTokenizer rVm6WV73 = new StringTokenizer(niS1VvBN, " \t");
				String K8xigDGp = rVm6WV73.nextToken();
				StringBuffer C8pMFWIc = new StringBuffer();
				SmMEJbst.readSequence(C8pMFWIc, ">", Integer.MAX_VALUE, "-", "?", "", null);
				gB6OQuau = SmMEJbst.getLastDelimiter();
				names.add(K8xigDGp);
				sequences.add(C8pMFWIc.toString());
			} while (gB6OQuau == '>');
		} catch (MalformedURLException vfUXiPcS) {
			vfUXiPcS.printStackTrace();
		} catch (EOFException FH4jYxDz) {
		} catch (IOException Pvr7XDyP) {
		}
	}

}