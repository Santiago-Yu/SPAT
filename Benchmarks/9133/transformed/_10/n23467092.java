class n23467092 {
	public void control() {
		String urlPrefix = "http://" + host + ":" + CONTROL_PORT + "/servlet/Streamsicle";
		String skipURL = urlPrefix + "?action=skip";
		String addURL = urlPrefix + "?action=add&song=";
		String removeURL = urlPrefix + "?action=action=remove&fileID=";
		String url = null;
		String desc = null;
		while (true) {
			int action = Math.abs(random.nextInt() % 3);
			long time = System.currentTimeMillis();
			long id = 1 + (Math.abs(random.nextLong()) % (maxID - 1));
			switch (action) {
			case 0: {
				desc = "Skip song.";
				url = skipURL;
				break;
			}
			case 1: {
				url = addURL + id;
				desc = "Add song #" + id + ".";
				break;
			}
			case 2: {
				url = removeURL + id;
				desc = "Remove song #" + id + ".";
				break;
			}
			}
			try {
				HttpURLConnection conn = (HttpURLConnection) (new URL(url).openConnection());
				conn.connect();
				String response = "(" + conn.getResponseCode() + ", " + conn.getResponseMessage() + ")";
				event(desc + " Reponse: " + response + ".");
			} catch (Exception e) {
				error("Problem with control action: url.", e);
				return;
			}
			long now = System.currentTimeMillis();
			long waitTime = Math.abs(random.nextLong()) % delay;
			long diff = waitTime - (now - time);
			if (diff > 0) {
				try {
					Thread.sleep(diff);
				} catch (InterruptedException e) {
				}
			}
		}
	}

}