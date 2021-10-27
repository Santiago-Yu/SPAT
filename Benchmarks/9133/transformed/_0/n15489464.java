class n15489464 {
	public Object send(URL ZVrZEmjc, Object bYCfbrsm) throws Exception {
		bYCfbrsm = processRequest(bYCfbrsm);
		String okWVcjOM = "";
		BufferedReader qWWvAIjy = new BufferedReader(new InputStreamReader(ZVrZEmjc.openStream()));
		okWVcjOM += qWWvAIjy.readLine();
		while (okWVcjOM != null)
			okWVcjOM += qWWvAIjy.readLine();
		qWWvAIjy.close();
		return processResponse(okWVcjOM);
	}

}