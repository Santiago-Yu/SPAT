class n324679 {
	public boolean import_hints(String fNjThBiz) {
		int NnmvTqPK;
		int zdQHrym1, j71GAtko, kfmmAz2i;
		int Ir9YAg8C;
		int iM17qTvU;
		boolean l7N7oQSV = true;
		e2piece WctFc4bE;
		String SkPKVhsn;
		StringTokenizer yyFKwH4X;
		BufferedReader ZcJK51ef;
		try {
			if (l7N7oQSV == true) {
				URL tfGnvPNG = new URL(baseURL, fNjThBiz);
				InputStream OnFmcBOH = tfGnvPNG.openStream();
				ZcJK51ef = new BufferedReader(new InputStreamReader(OnFmcBOH));
			} else {
				ZcJK51ef = new BufferedReader(new FileReader(fNjThBiz));
			}
			NnmvTqPK = 0;
			SkPKVhsn = ZcJK51ef.readLine();
			yyFKwH4X = new StringTokenizer(SkPKVhsn, " ");
			iM17qTvU = Integer.parseInt(yyFKwH4X.nextToken());
			for (zdQHrym1 = 0; zdQHrym1 < iM17qTvU; zdQHrym1++) {
				SkPKVhsn = ZcJK51ef.readLine();
				if (SkPKVhsn == null) {
					break;
				}
				yyFKwH4X = new StringTokenizer(SkPKVhsn, " ");
				NnmvTqPK = Integer.parseInt(yyFKwH4X.nextToken());
				j71GAtko = Integer.parseInt(yyFKwH4X.nextToken()) - 1;
				kfmmAz2i = Integer.parseInt(yyFKwH4X.nextToken()) - 1;
				Ir9YAg8C = Integer.parseInt(yyFKwH4X.nextToken());
				System.out.println("placing hint piece : " + NnmvTqPK);
				place_piece_at(NnmvTqPK, j71GAtko, kfmmAz2i, 0);
				WctFc4bE = board.get_piece_at(j71GAtko, kfmmAz2i);
				WctFc4bE.reset_rotation();
				WctFc4bE.rotate(Ir9YAg8C);
				WctFc4bE.set_as_hint();
			}
			return true;
		} catch (IOException J3I62V6e) {
			return false;
		}
	}

}