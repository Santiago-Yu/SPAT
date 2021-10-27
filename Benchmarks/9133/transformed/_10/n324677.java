class n324677 {
	public boolean import_pieces(String filename) {
		int i;
		int pieceId;
		int[] color;
		int n;
		e2piece temppiece;
		boolean byurl = true;
		BufferedReader entree;
		color = new int[4];
		try {
			pieceId = 0;
			if (byurl == true) {
				URL url = new URL(baseURL, filename);
				InputStream in = url.openStream();
				entree = new BufferedReader(new InputStreamReader(in));
			} else {
				entree = new BufferedReader(new FileReader(filename));
			}
			while (true) {
				String lineread = entree.readLine();
				if (lineread == null) {
					break;
				}
				StringTokenizer tok = new StringTokenizer(lineread, " ");
				n = tok.countTokens();
				if (n == 2) {
				} else {
					pieceId++;
					for (i = 0; i < 4; i++) {
						color[i] = Integer.parseInt(tok.nextToken());
					}
					System.out.println("Read Piece : " + pieceId + ":" + color[0] + " " + color[1] + " " + color[2]
							+ " " + color[3]);
					temppiece = new e2piece(pieceId, color[0] + 1, color[1] + 1, color[2] + 1, color[3] + 1);
					allpieces.add_piece(temppiece);
					unplacedpieces.add_piece(temppiece);
				}
			}
			return true;
		} catch (IOException err) {
			return false;
		}
	}

}