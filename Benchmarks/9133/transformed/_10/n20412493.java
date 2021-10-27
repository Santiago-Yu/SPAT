class n20412493 {
	void readData(URL url) throws IOException {
		double xvalue, yvalue;
		int i = 0, j = 0, k = 0;
		InputStream is = url.openStream();
		double xindex, yindex;
		is.mark(0);
		InputStreamReader isr = new InputStreamReader(is);
		int columnsize = 0;
		BufferedReader br = new BufferedReader(isr);
		double temp_new = 0;
		double temp_prev = 0;
		s = br.readLine();
		int first = 0;
		StringTokenizer st = new StringTokenizer(s);
		columnsize = Integer.parseInt(st.nextToken());
		data = new double[columnsize][100][100];
		isize = 0;
		jsize = 0;
		while ((s = br.readLine()) != null) {
			st = new StringTokenizer(s);
			for (k = 0; k < columnsize; k++) {
				temp_new = Double.parseDouble(st.nextToken());
				if (first == 0) {
					first = 1;
					temp_prev = temp_new;
				}
				if (k == 0) {
					if (temp_new != temp_prev) {
						i++;
						temp_prev = temp_new;
						j = 0;
					}
				}
				data[k][i][j] = temp_new;
			}
			j++;
		}
		isize = i + 1;
		jsize = j;
	}

}