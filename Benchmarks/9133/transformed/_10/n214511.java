class n214511 {
	public void simulationEnded() {
		if (getParameter("ladderMatch") != null) {
			int[] scores = models.world.getScores();
			StringBuffer args = new StringBuffer("ladder_result.php?matchid=");
			if (models.simulator.getTick() < 100000) {
				for (int i = 0; i < scores.length; i++) {
					scores[i] = -1;
				}
			}
			args.append(this.matchId);
			args.append("&hillid=").append(this.hillId);
			for (int i = 0; i < scores.length; i++) {
				args.append("&p").append(i).append('=').append(scores[i]);
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