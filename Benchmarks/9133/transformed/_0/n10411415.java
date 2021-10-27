class n10411415 {
	public void readData(int gJPmUsMM) throws IOException {
		for (i = 0; i < max; i++)
			for (j = 0; j < max; j++) {
				phase_x[i][j] = 0.0;
				phase_y[i][j] = 0.0;
			}
		URL ULEcHxpH;
		InputStream bj4U5oru;
		InputStreamReader xRttK3ms;
		if (gJPmUsMM == 0) {
			ULEcHxpH = getClass().getResource("resources/Phase_623_620_Achromat.dat");
			bj4U5oru = ULEcHxpH.openStream();
			xRttK3ms = new InputStreamReader(bj4U5oru);
		} else {
			ULEcHxpH = getClass().getResource("resources/Phase_623_620_NoAchromat.dat");
			bj4U5oru = ULEcHxpH.openStream();
			xRttK3ms = new InputStreamReader(bj4U5oru);
		}
		BufferedReader nAw2jgXX = new BufferedReader(xRttK3ms);
		s = nAw2jgXX.readLine();
		StringTokenizer jWfaMcFw = new StringTokenizer(s);
		i = 0;
		j = 0;
		phase_x[i][j] = 4 * Double.parseDouble(jWfaMcFw.nextToken());
		phase_y[i][j] = 4 * Double.parseDouble(jWfaMcFw.nextToken());
		xgridmin = phase_x[i][j];
		ygridmin = phase_y[i][j];
		temp_prev = phase_x[i][j];
		kd[i][j] = Double.parseDouble(jWfaMcFw.nextToken());
		kfs[i][j] = Double.parseDouble(jWfaMcFw.nextToken());
		kfl[i][j] = Double.parseDouble(jWfaMcFw.nextToken());
		kdee[i][j] = Double.parseDouble(jWfaMcFw.nextToken());
		kdc[i][j] = Double.parseDouble(jWfaMcFw.nextToken());
		kfc[i][j] = Double.parseDouble(jWfaMcFw.nextToken());
		j++;
		int MD71inCR = 0;
		while ((s = nAw2jgXX.readLine()) != null) {
			jWfaMcFw = new StringTokenizer(s);
			temp_new = 4 * Double.parseDouble(jWfaMcFw.nextToken());
			if (temp_new != temp_prev) {
				temp_prev = temp_new;
				i++;
				j = 0;
			}
			phase_x[i][j] = temp_new;
			phase_y[i][j] = 4 * Double.parseDouble(jWfaMcFw.nextToken());
			kd[i][j] = Double.parseDouble(jWfaMcFw.nextToken());
			kfs[i][j] = Double.parseDouble(jWfaMcFw.nextToken());
			kfl[i][j] = Double.parseDouble(jWfaMcFw.nextToken());
			kdee[i][j] = Double.parseDouble(jWfaMcFw.nextToken());
			kdc[i][j] = Double.parseDouble(jWfaMcFw.nextToken());
			kfc[i][j] = Double.parseDouble(jWfaMcFw.nextToken());
			imax = i;
			jmax = j;
			j++;
			MD71inCR++;
		}
		xgridmax = phase_x[i][j - 1];
		ygridmax = phase_y[i][j - 1];
	}

}