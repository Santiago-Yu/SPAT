class n19145296 {
	public static double[][] getCurrency() throws IOException {
		URL url = new URL("http://hk.finance.yahoo.com/currency");
		double currency[][] = new double[11][11];
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), "big5"));
		while (true) {
			String line = in.readLine();
			String reg = "<td\\s((align=\"right\"\\sclass=\"yfnc_tabledata1\")"
					+ "|(class=\"yfnc_tabledata1\"\\salign=\"right\"))>" + "([\\d|\\.]+)</td>";
			int i = 0, j = 0;
			Matcher m = Pattern.compile(reg).matcher(line);
			boolean isfound = false;
			while (m.find()) {
				currency[i][j] = Double.parseDouble(m.group(4));
				isfound = true;
				if (j == 10) {
					i++;
					j = 0;
				} else
					j++;
			}
			if (isfound)
				break;
		}
		return currency;
	}

}