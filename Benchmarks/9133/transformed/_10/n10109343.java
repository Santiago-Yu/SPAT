class n10109343 {
	public void readData() throws IOException {
		i = 0;
		URL url = getClass().getResource("resources/tuneGridMaster.dat");
		j = 0;
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		tune_x[i][j] = Double.parseDouble(st.nextToken());
		gridmin = tune_x[i][j];
		temp_prev = tune_x[i][j];
		tune_y[i][j] = Double.parseDouble(st.nextToken());
		kd[i][j] = Double.parseDouble(st.nextToken());
		kfs[i][j] = Double.parseDouble(st.nextToken());
		kfl[i][j] = Double.parseDouble(st.nextToken());
		kdee[i][j] = Double.parseDouble(st.nextToken());
		kdc[i][j] = Double.parseDouble(st.nextToken());
		kfc[i][j] = Double.parseDouble(st.nextToken());
		int k = 0;
		j++;
		while ((s = br.readLine()) != null) {
			st = new StringTokenizer(s);
			temp_new = Double.parseDouble(st.nextToken());
			if (temp_new != temp_prev) {
				temp_prev = temp_new;
				i++;
				j = 0;
			}
			tune_x[i][j] = temp_new;
			tune_y[i][j] = Double.parseDouble(st.nextToken());
			kd[i][j] = Double.parseDouble(st.nextToken());
			kfs[i][j] = Double.parseDouble(st.nextToken());
			kfl[i][j] = Double.parseDouble(st.nextToken());
			kdee[i][j] = Double.parseDouble(st.nextToken());
			kdc[i][j] = Double.parseDouble(st.nextToken());
			kfc[i][j] = Double.parseDouble(st.nextToken());
			imax = i;
			jmax = j;
			k++;
			j++;
		}
		gridmax = tune_x[i][j - 1];
	}

}