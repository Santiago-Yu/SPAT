class n324681 {
	public boolean import_status(String kLg7GJFt) {
		int Inj6Byeu;
		int Xt6pUUTl, QkdTXoV1, xJvr4ud7, Q8x0jnSu;
		int Qm16FzeN;
		int yuNKPJdw;
		boolean IrMPCz7H = false;
		e2piece hFZqn97L;
		String exQYLrxk;
		StringTokenizer JhcgViqy;
		BufferedReader Mae5lquh;
		try {
			if (IrMPCz7H == true) {
				URL n3cEZQoh = new URL(baseURL, kLg7GJFt);
				InputStream sHeA7oaO = n3cEZQoh.openStream();
				Mae5lquh = new BufferedReader(new InputStreamReader(sHeA7oaO));
			} else {
				Mae5lquh = new BufferedReader(new FileReader(kLg7GJFt));
			}
			Inj6Byeu = 0;
			for (Xt6pUUTl = 0; Xt6pUUTl < board.colnb; Xt6pUUTl++) {
				for (QkdTXoV1 = 0; QkdTXoV1 < board.rownb; QkdTXoV1++) {
					unplace_piece_at(Xt6pUUTl, QkdTXoV1);
				}
			}
			while (true) {
				exQYLrxk = Mae5lquh.readLine();
				if (exQYLrxk == null) {
					break;
				}
				JhcgViqy = new StringTokenizer(exQYLrxk, " ");
				Inj6Byeu = Integer.parseInt(JhcgViqy.nextToken());
				xJvr4ud7 = Integer.parseInt(JhcgViqy.nextToken()) - 1;
				Q8x0jnSu = Integer.parseInt(JhcgViqy.nextToken()) - 1;
				Qm16FzeN = Integer.parseInt(JhcgViqy.nextToken());
				place_piece_at(Inj6Byeu, xJvr4ud7, Q8x0jnSu, 0);
				hFZqn97L = board.get_piece_at(xJvr4ud7, Q8x0jnSu);
				hFZqn97L.reset_rotation();
				hFZqn97L.rotate(Qm16FzeN);
			}
			return true;
		} catch (IOException VCgFDGcj) {
			return false;
		}
	}

}