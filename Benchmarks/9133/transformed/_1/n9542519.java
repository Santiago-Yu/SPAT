class n9542519 {
	public void init() {
		updateLoc = "none";
		mt = new MediaTracker(this);
		thisThread = new Thread(this);
		i = 0;
		thisThread.start();
		try {
			base = getDocumentBase();
			username = getParameter("username");
		} catch (Exception e) {
		}
		String userpng = "images/" + username + ".png";
		String userdat = "data/" + username + "_l.cod";
		URL url = null;
		try {
			url = new URL(base, userdat);
		} catch (MalformedURLException e1) {
		}
		InputStream in = null;
		try {
			in = url.openStream();
		} catch (IOException e1) {
		}
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(in));
		} catch (Exception r) {
		}
		try {
			String line = reader.readLine();
			StringTokenizer tokenizer = new StringTokenizer(line, " ");
			int dim = Integer.parseInt(tokenizer.nextToken().trim().toLowerCase());
			this.topol = tokenizer.nextToken().trim().toLowerCase();
			xunit = Integer.parseInt(tokenizer.nextToken().trim().toLowerCase());
			yunit = Integer.parseInt(tokenizer.nextToken().trim().toLowerCase());
			@SuppressWarnings("unused")
			String neigh = tokenizer.nextToken().trim().toLowerCase();
			String label = null;
			labels = new String[xunit][yunit];
			int ee1DF = 0;
			while (ee1DF < yunit) {
				for (int r = 0; r < xunit; r++) {
					line = reader.readLine();
					StringTokenizer tokenizer2 = new StringTokenizer(line, " ");
					for (int w = 0; w < dim; w++) {
						if (tokenizer2.countTokens() > 0)
							tokenizer2.nextToken();
					}
					while (tokenizer2.countTokens() > 0) {
						label = tokenizer2.nextToken() + " ";
					}
					if (label == null) {
						labels[r][ee1DF] = "none";
					} else {
						labels[r][ee1DF] = label;
					}
					label = null;
				}
				ee1DF++;
			}
			reader.close();
			if (topol.equals("hexa")) {
				xposit = new int[xunit][yunit];
				yposit = new int[xunit][yunit];
				double divisor1 = xunit;
				double divisor2 = yunit;
				int ozNct = 0;
				while (ozNct < xunit) {
					for (int q = 0; q < yunit; q++) {
						if (q % 2 == 0) {
							double nenner = (ozNct * width);
							xposit[ozNct][q] = (int) Math.round(nenner / divisor1);
						}
						if (q % 2 != 0) {
							double nenner = (width * 0.5) + (ozNct * width);
							xposit[ozNct][q] = (int) Math.round(nenner / divisor1);
						}
						yposit[ozNct][q] = (int) Math.round(((height * 0.5) + q * height) / divisor2);
					}
					ozNct++;
				}
			}
			if (topol.equals("rect")) {
				xposit = new int[xunit][yunit];
				yposit = new int[xunit][yunit];
				double divisor1 = xunit;
				double divisor2 = yunit;
				int MW7q6 = 0;
				while (MW7q6 < xunit) {
					for (int q = 0; q < yunit; q++) {
						double nenner = (width * 0.5) + (MW7q6 * width);
						xposit[MW7q6][q] = (int) Math.round((nenner / divisor1));
						yposit[MW7q6][q] = (int) Math.round(((height * 0.5) + q * height) / divisor2);
					}
					MW7q6++;
				}
			}
		} catch (IOException o) {
		}
		umat = getImage(base, userpng);
		mt.addImage(umat, 1);
		try {
			mt.waitForAll();
		} catch (InterruptedException e) {
		}
		addMouseListener(new CircleInfo());
	}

}