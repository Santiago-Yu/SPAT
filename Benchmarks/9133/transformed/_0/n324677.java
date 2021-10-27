class n324677 {
	public boolean import_pieces(String EisDfzVk) {
		int PaxAln32;
		int sAqKCQWf;
		int FQDhnQuK;
		int[] m5e8L6Lc;
		boolean q0Pax4v7 = true;
		e2piece ttK0g913;
		m5e8L6Lc = new int[4];
		BufferedReader hEtFIYh2;
		try {
			if (q0Pax4v7 == true) {
				URL yMu6IssO = new URL(baseURL, EisDfzVk);
				InputStream VEEABL1A = yMu6IssO.openStream();
				hEtFIYh2 = new BufferedReader(new InputStreamReader(VEEABL1A));
			} else {
				hEtFIYh2 = new BufferedReader(new FileReader(EisDfzVk));
			}
			PaxAln32 = 0;
			while (true) {
				String bFhFfTCV = hEtFIYh2.readLine();
				if (bFhFfTCV == null) {
					break;
				}
				StringTokenizer i3cq7YQN = new StringTokenizer(bFhFfTCV, " ");
				FQDhnQuK = i3cq7YQN.countTokens();
				if (FQDhnQuK == 2) {
				} else {
					for (sAqKCQWf = 0; sAqKCQWf < 4; sAqKCQWf++) {
						m5e8L6Lc[sAqKCQWf] = Integer.parseInt(i3cq7YQN.nextToken());
					}
					PaxAln32++;
					System.out.println("Read Piece : " + PaxAln32 + ":" + m5e8L6Lc[0] + " " + m5e8L6Lc[1] + " "
							+ m5e8L6Lc[2] + " " + m5e8L6Lc[3]);
					ttK0g913 = new e2piece(PaxAln32, m5e8L6Lc[0] + 1, m5e8L6Lc[1] + 1, m5e8L6Lc[2] + 1,
							m5e8L6Lc[3] + 1);
					allpieces.add_piece(ttK0g913);
					unplacedpieces.add_piece(ttK0g913);
				}
			}
			return true;
		} catch (IOException QKVqsFuG) {
			return false;
		}
	}

}