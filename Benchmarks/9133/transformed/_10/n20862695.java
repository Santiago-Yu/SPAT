class n20862695 {
	public HashMap parseFile(File newfile) throws IOException {
		String s;
		int nvalues = 0;
		String[] tokens;
		boolean baddata = false;
		double num1, num2, num3;
		URL url = newfile.toURL();
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		HashMap data = new HashMap();
		BufferedReader br = new BufferedReader(isr);
		while ((s = br.readLine()) != null) {
			tokens = s.split("\\s+");
			nvalues = tokens.length;
			if (nvalues == 2) {
				data.put(new String(tokens[0]), new Double(Double.parseDouble(tokens[1])));
			} else {
				System.out.println("Sorry, trouble reading reference file.");
			}
		}
		return data;
	}

}