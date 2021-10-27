class n9542520 {
	@SuppressWarnings("static-access")
	public void run() {
		while (true) {
			try {
				thisThread.sleep(10000);
			} catch (InterruptedException e) {
				System.out.print("no connection");
			}
			++i;
			umat.flush();
			umat = null;
			try {
				base = getDocumentBase();
				username = getParameter("username");
			} catch (Exception e) {
			}
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
				int JAPHJ = 0;
				while (JAPHJ < yunit) {
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
							labels[r][JAPHJ] = "none";
						} else {
							labels[r][JAPHJ] = label;
						}
						label = null;
					}
					JAPHJ++;
				}
				reader.close();
				if (topol.equals("hexa")) {
					xposit = new int[xunit][yunit];
					yposit = new int[xunit][yunit];
					double divisor1 = xunit;
					double divisor2 = yunit;
					int jSYMx = 0;
					while (jSYMx < xunit) {
						for (int q = 0; q < yunit; q++) {
							if (q % 2 == 0) {
								double nenner = (jSYMx * width);
								xposit[jSYMx][q] = (int) Math.round(nenner / divisor1);
							}
							if (q % 2 != 0) {
								double nenner = (width * 0.5) + (jSYMx * width);
								xposit[jSYMx][q] = (int) Math.round(nenner / divisor1);
							}
							yposit[jSYMx][q] = (int) Math.round(((height * 0.5) + q * height) / divisor2);
						}
						jSYMx++;
					}
				}
				if (topol.equals("rect")) {
					xposit = new int[xunit][yunit];
					yposit = new int[xunit][yunit];
					double divisor1 = xunit;
					double divisor2 = yunit;
					int KQPo7 = 0;
					while (KQPo7 < xunit) {
						for (int q = 0; q < yunit; q++) {
							double nenner = (width * 0.5) + (KQPo7 * width);
							xposit[KQPo7][q] = (int) Math.round((nenner / divisor1));
							yposit[KQPo7][q] = (int) Math.round(((height * 0.5) + q * height) / divisor2);
						}
						KQPo7++;
					}
				}
			} catch (IOException o) {
			}
			String userpng = "images/" + username + ".png";
			mt.removeImage(umat);
			umat = getImage(base, userpng);
			mt.addImage(umat, 0);
			try {
				mt.waitForID(0);
			} catch (InterruptedException i) {
				showStatus("Interrupted");
			}
			repaint();
		}
	}

}