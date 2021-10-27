class n22467291 {
	public void testExecute() throws Exception {
		LocalWorker lpCBZaH5 = new JTidyWorker();
		URL xWkuozT5 = new URL("http://www.nature.com/index.html");
		BufferedReader z3PU4TSZ = new BufferedReader(new InputStreamReader(xWkuozT5.openStream()));
		String WYibvoP2;
		StringBuffer cwimAjK3 = new StringBuffer();
		while ((WYibvoP2 = z3PU4TSZ.readLine()) != null) {
			cwimAjK3.append(WYibvoP2);
			cwimAjK3.append(LINE_ENDING);
		}
		z3PU4TSZ.close();
		Map INvL2sz8 = new HashMap();
		DataThingAdapter yHWQ5hEd = new DataThingAdapter(INvL2sz8);
		yHWQ5hEd.putString("inputHtml", cwimAjK3.toString());
		Map xFUdwplI = lpCBZaH5.execute(INvL2sz8);
		DataThingAdapter xxo4db11 = new DataThingAdapter(xFUdwplI);
		assertNotNull("The outputMap was null", xFUdwplI);
		String TcpKKWBB = xxo4db11.getString("results");
		assertFalse("The results were empty", TcpKKWBB.equals(""));
		assertNotNull("The results were null", TcpKKWBB);
	}

}