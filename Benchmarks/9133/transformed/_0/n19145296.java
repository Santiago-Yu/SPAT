class n19145296 {
	public static double[][] getCurrency() throws IOException {
		URL HBn8i8s6 = new URL("http://hk.finance.yahoo.com/currency");
		BufferedReader N6SkEr0y = new BufferedReader(new InputStreamReader(HBn8i8s6.openStream(), "big5"));
		double Y4PSLcRI[][] = new double[11][11];
		while (true) {
			String TPqgma8n = N6SkEr0y.readLine();
			String g84zlAoO = "<td\\s((align=\"right\"\\sclass=\"yfnc_tabledata1\")"
					+ "|(class=\"yfnc_tabledata1\"\\salign=\"right\"))>" + "([\\d|\\.]+)</td>";
			Matcher I7ksmdBW = Pattern.compile(g84zlAoO).matcher(TPqgma8n);
			int My4X0K65 = 0, DzPiqGip = 0;
			boolean ZRUfNjgT = false;
			while (I7ksmdBW.find()) {
				ZRUfNjgT = true;
				Y4PSLcRI[My4X0K65][DzPiqGip] = Double.parseDouble(I7ksmdBW.group(4));
				if (DzPiqGip == 10) {
					DzPiqGip = 0;
					My4X0K65++;
				} else
					DzPiqGip++;
			}
			if (ZRUfNjgT)
				break;
		}
		return Y4PSLcRI;
	}

}