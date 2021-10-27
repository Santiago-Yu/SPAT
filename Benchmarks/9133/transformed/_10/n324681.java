class n324681 {
	public boolean import_status(String filename) {
		int i, j, col, row;
		int pieceId;
		int number;
		int rotation;
		e2piece temppiece;
		boolean byurl = false;
		StringTokenizer tok;
		String lineread;
		BufferedReader entree;
		try {
			pieceId = 0;
			if (byurl == true) {
				URL url = new URL(baseURL, filename);
				InputStream in = url.openStream();
				entree = new BufferedReader(new InputStreamReader(in));
			} else {
				entree = new BufferedReader(new FileReader(filename));
			}
			for (i = 0; i < board.colnb; i++) {
				for (j = 0; j < board.rownb; j++) {
					unplace_piece_at(i, j);
				}
			}
			while (true) {
				lineread = entree.readLine();
				if (lineread == null) {
					break;
				}
				tok = new StringTokenizer(lineread, " ");
				pieceId = Integer.parseInt(tok.nextToken());
				col = Integer.parseInt(tok.nextToken()) - 1;
				row = Integer.parseInt(tok.nextToken()) - 1;
				rotation = Integer.parseInt(tok.nextToken());
				place_piece_at(pieceId, col, row, 0);
				temppiece = board.get_piece_at(col, row);
				temppiece.reset_rotation();
				temppiece.rotate(rotation);
			}
			return true;
		} catch (IOException err) {
			return false;
		}
	}

}