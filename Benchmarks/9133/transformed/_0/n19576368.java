class n19576368 {
	public String setContent(URL hg8CQAiB, String bbydw3Dk) {
		String rkWnIY8r = "";
		try {
			HttpURLConnection UCllZukd = (HttpURLConnection) hg8CQAiB.openConnection();
			UCllZukd.setDoOutput(true);
			UCllZukd.setRequestMethod("POST");
			UCllZukd.connect();
			OutputStreamWriter BEhXm7yH = new OutputStreamWriter(UCllZukd.getOutputStream());
			BEhXm7yH.write(bbydw3Dk);
			BEhXm7yH.flush();
			BufferedReader hvd1JSbH = new BufferedReader(new InputStreamReader(UCllZukd.getInputStream()));
			String GbusBn7R = "";
			while ((GbusBn7R = hvd1JSbH.readLine()) != null) {
				rkWnIY8r = rkWnIY8r + GbusBn7R;
			}
			hvd1JSbH.close();
			BEhXm7yH.close();
		} catch (IOException QsSJRhnn) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,
					"Problem writing to " + hg8CQAiB + " content " + bbydw3Dk, QsSJRhnn);
		}
		return rkWnIY8r;
	}

}