class n19063414 {
	public void readData() throws IOException {
		i = 0;
		j = 0;
		URL ZQe6AJru = getClass().getResource("resources/Chrom_623_620.dat");
		InputStream DWL8JKzb = ZQe6AJru.openStream();
		InputStreamReader XlM3z0LJ = new InputStreamReader(DWL8JKzb);
		BufferedReader p76NRvzC = new BufferedReader(XlM3z0LJ);
		s = p76NRvzC.readLine();
		StringTokenizer YSAUi25k = new StringTokenizer(s);
		s = p76NRvzC.readLine();
		YSAUi25k = new StringTokenizer(s);
		chrom_x[i][j] = Double.parseDouble(YSAUi25k.nextToken());
		temp_prev = chrom_x[i][j];
		chrom_y[i][j] = Double.parseDouble(YSAUi25k.nextToken());
		gridmin = chrom_x[i][j];
		gridmax = chrom_x[i][j];
		sext1[i][j] = Double.parseDouble(YSAUi25k.nextToken());
		sext2[i][j] = Double.parseDouble(YSAUi25k.nextToken());
		sext3[i][j] = Double.parseDouble(YSAUi25k.nextToken());
		sext4[i][j] = Double.parseDouble(YSAUi25k.nextToken());
		j++;
		while ((s = p76NRvzC.readLine()) != null) {
			YSAUi25k = new StringTokenizer(s);
			temp_new = Double.parseDouble(YSAUi25k.nextToken());
			if (temp_new != temp_prev) {
				temp_prev = temp_new;
				i++;
				j = 0;
			}
			chrom_x[i][j] = temp_new;
			chrom_y[i][j] = Double.parseDouble(YSAUi25k.nextToken());
			sext1[i][j] = Double.parseDouble(YSAUi25k.nextToken());
			sext2[i][j] = Double.parseDouble(YSAUi25k.nextToken());
			sext3[i][j] = Double.parseDouble(YSAUi25k.nextToken());
			sext4[i][j] = Double.parseDouble(YSAUi25k.nextToken());
			imax = i;
			jmax = j;
			j++;
			if (chrom_x[i][j] <= gridmin)
				gridmin = chrom_x[i][j];
			if (chrom_x[i][j] >= gridmax)
				gridmax = chrom_x[i][j];
		}
	}

}