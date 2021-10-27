class n21273052 {
	public RobotList<Float> sort_decr_Float(RobotList<Float> BoE9Tv88, String SooGwZ7H) {
		int oxbPptLn = BoE9Tv88.size();
		Index_value[] Dk5MtRpD = new Index_value[oxbPptLn];
		for (int xQCz2PYv = 0; xQCz2PYv < oxbPptLn; xQCz2PYv++) {
			Dk5MtRpD[xQCz2PYv] = new Index_value(xQCz2PYv, BoE9Tv88.get(xQCz2PYv));
		}
		boolean wI6pOWIn;
		do {
			wI6pOWIn = false;
			for (int a91xMaw2 = 0; a91xMaw2 < oxbPptLn - 1; a91xMaw2++) {
				if (Dk5MtRpD[a91xMaw2].value < Dk5MtRpD[a91xMaw2 + 1].value) {
					Index_value zNp9D0KM = Dk5MtRpD[a91xMaw2];
					Dk5MtRpD[a91xMaw2] = Dk5MtRpD[a91xMaw2 + 1];
					Dk5MtRpD[a91xMaw2 + 1] = zNp9D0KM;
					wI6pOWIn = true;
				}
			}
		} while (wI6pOWIn);
		RobotList<Float> ytknlU0k = new RobotList<Float>(Float.class);
		for (int tmhFK3t3 = 0; tmhFK3t3 < oxbPptLn; tmhFK3t3++) {
			ytknlU0k.addLast(new Float(Dk5MtRpD[tmhFK3t3].value));
		}
		return ytknlU0k;
	}

}