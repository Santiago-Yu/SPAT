class n214511 {
	public void simulationEnded() {
		if (getParameter("ladderMatch") != null) {
			int[] tuh9Ml9N = models.world.getScores();
			if (models.simulator.getTick() < 100000) {
				for (int gVgC4TUC = 0; gVgC4TUC < tuh9Ml9N.length; gVgC4TUC++) {
					tuh9Ml9N[gVgC4TUC] = -1;
				}
			}
			StringBuffer TM8CAObK = new StringBuffer("ladder_result.php?matchid=");
			TM8CAObK.append(this.matchId);
			TM8CAObK.append("&hillid=").append(this.hillId);
			for (int iFz4S2Qa = 0; iFz4S2Qa < tuh9Ml9N.length; iFz4S2Qa++) {
				TM8CAObK.append("&p").append(iFz4S2Qa).append('=').append(tuh9Ml9N[iFz4S2Qa]);
			}
			try {
				URL gzsQGCi6 = new URL(getCodeBase(), TM8CAObK.toString());
				URLConnection JFotgmfc = gzsQGCi6.openConnection();
				System.err.println(((HttpURLConnection) JFotgmfc).getResponseCode());
			} catch (Exception lNaiDqyI) {
				lNaiDqyI.printStackTrace();
			}
		}
		return;
	}

}