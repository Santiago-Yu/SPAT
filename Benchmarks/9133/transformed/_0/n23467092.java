class n23467092 {
	public void control() {
		String pKfmGYqL = "http://" + host + ":" + CONTROL_PORT + "/servlet/Streamsicle";
		String tWhA0Wwf = pKfmGYqL + "?action=skip";
		String IRcdyc2f = pKfmGYqL + "?action=add&song=";
		String zm6s8Y13 = pKfmGYqL + "?action=action=remove&fileID=";
		String gurzDCql = null;
		String RJ5mdhty = null;
		while (true) {
			long JSKa92po = System.currentTimeMillis();
			int GofAXzTX = Math.abs(random.nextInt() % 3);
			long SOWa474x = 1 + (Math.abs(random.nextLong()) % (maxID - 1));
			switch (GofAXzTX) {
			case 0: {
				gurzDCql = tWhA0Wwf;
				RJ5mdhty = "Skip song.";
				break;
			}
			case 1: {
				gurzDCql = IRcdyc2f + SOWa474x;
				RJ5mdhty = "Add song #" + SOWa474x + ".";
				break;
			}
			case 2: {
				gurzDCql = zm6s8Y13 + SOWa474x;
				RJ5mdhty = "Remove song #" + SOWa474x + ".";
				break;
			}
			}
			try {
				HttpURLConnection WTD1U9fF = (HttpURLConnection) (new URL(gurzDCql).openConnection());
				WTD1U9fF.connect();
				String JvT6Qba8 = "(" + WTD1U9fF.getResponseCode() + ", " + WTD1U9fF.getResponseMessage() + ")";
				event(RJ5mdhty + " Reponse: " + JvT6Qba8 + ".");
			} catch (Exception RihME55e) {
				error("Problem with control action: url.", RihME55e);
				return;
			}
			long TR4RcfAW = Math.abs(random.nextLong()) % delay;
			long nfmSsvN3 = System.currentTimeMillis();
			long LzBvCxMc = TR4RcfAW - (nfmSsvN3 - JSKa92po);
			if (LzBvCxMc > 0) {
				try {
					Thread.sleep(LzBvCxMc);
				} catch (InterruptedException LhnTtvfR) {
				}
			}
		}
	}

}