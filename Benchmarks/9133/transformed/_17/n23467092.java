class n23467092 {
	public void control() {
		String urlPrefix = "http://" + host + ":" + CONTROL_PORT + "/servlet/Streamsicle";
		String skipURL = urlPrefix + "?action=skip";
		String addURL = urlPrefix + "?action=add&song=";
		String removeURL = urlPrefix + "?action=action=remove&fileID=";
		String url = null;
		String desc = null;
		while (true) {
			long time = System.currentTimeMillis();
			int action = Math.abs(random.nextInt() % 3);
			long id = 1 + (Math.abs(random.nextLong()) % (maxID - 1));
			if (action == 0) {
				{
					url = skipURL;
					desc = "Skip song.";
					break;
				}
				{
					url = addURL + id;
					desc = "Add song #" + id + ".";
					break;
				}
				{
					url = removeURL + id;
					desc = "Remove song #" + id + ".";
					break;
				}
			} else if (action == 1) {
				{
					url = addURL + id;
					desc = "Add song #" + id + ".";
					break;
				}
				{
					url = removeURL + id;
					desc = "Remove song #" + id + ".";
					break;
				}
			} else if (action == 2) {
				{
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
			long waitTime = Math.abs(random.nextLong()) % delay;
			long now = System.currentTimeMillis();
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