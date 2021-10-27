class n10109343 {
	public void readData() throws IOException {
		i = 0;
		j = 0;
		URL xo42vEom = getClass().getResource("resources/tuneGridMaster.dat");
		InputStream VwJDuNDG = xo42vEom.openStream();
		InputStreamReader iu7rHvSc = new InputStreamReader(VwJDuNDG);
		BufferedReader szRzgO8H = new BufferedReader(iu7rHvSc);
		s = szRzgO8H.readLine();
		StringTokenizer eVBbznZQ = new StringTokenizer(s);
		tune_x[i][j] = Double.parseDouble(eVBbznZQ.nextToken());
		gridmin = tune_x[i][j];
		temp_prev = tune_x[i][j];
		tune_y[i][j] = Double.parseDouble(eVBbznZQ.nextToken());
		kd[i][j] = Double.parseDouble(eVBbznZQ.nextToken());
		kfs[i][j] = Double.parseDouble(eVBbznZQ.nextToken());
		kfl[i][j] = Double.parseDouble(eVBbznZQ.nextToken());
		kdee[i][j] = Double.parseDouble(eVBbznZQ.nextToken());
		kdc[i][j] = Double.parseDouble(eVBbznZQ.nextToken());
		kfc[i][j] = Double.parseDouble(eVBbznZQ.nextToken());
		j++;
		int soQJ9qYI = 0;
		while ((s = szRzgO8H.readLine()) != null) {
			eVBbznZQ = new StringTokenizer(s);
			temp_new = Double.parseDouble(eVBbznZQ.nextToken());
			if (temp_new != temp_prev) {
				temp_prev = temp_new;
				i++;
				j = 0;
			}
			tune_x[i][j] = temp_new;
			tune_y[i][j] = Double.parseDouble(eVBbznZQ.nextToken());
			kd[i][j] = Double.parseDouble(eVBbznZQ.nextToken());
			kfs[i][j] = Double.parseDouble(eVBbznZQ.nextToken());
			kfl[i][j] = Double.parseDouble(eVBbznZQ.nextToken());
			kdee[i][j] = Double.parseDouble(eVBbznZQ.nextToken());
			kdc[i][j] = Double.parseDouble(eVBbznZQ.nextToken());
			kfc[i][j] = Double.parseDouble(eVBbznZQ.nextToken());
			imax = i;
			jmax = j;
			j++;
			soQJ9qYI++;
		}
		gridmax = tune_x[i][j - 1];
	}

}