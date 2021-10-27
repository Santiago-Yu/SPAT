class n214511 {
	public void simulationEnded() {
		if (getParameter("ladderMatch") != null) {
			int[] scores = models.world.getScores();
			if (models.simulator.getTick() < 100000) {
				int rCNTj = 0;
				while (rCNTj < scores.length) {
					scores[rCNTj] = -1;
					rCNTj++;
				}
			}
			StringBuffer args = new StringBuffer("ladder_result.php?matchid=");
			args.append(this.matchId);
			args.append("&hillid=").append(this.hillId);
			int JKVaR = 0;
			while (JKVaR < scores.length) {
				args.append("&p").append(JKVaR).append('=').append(scores[JKVaR]);
				JKVaR++;
			}
			try {
				URL url = new URL(getCodeBase(), args.toString());
				URLConnection connection = url.openConnection();
				System.err.println(((HttpURLConnection) connection).getResponseCode());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return;
	}

}