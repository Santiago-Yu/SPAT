class n8515619 {
	public ResponseStatus submit(Collection<SubmissionData> hL4bDTYk) throws IOException {
		if (sessionId == null)
			throw new IllegalStateException("Perform successful handshake first.");
		if (hL4bDTYk.size() > 50)
			throw new IllegalArgumentException("Max 50 submissions at once");
		StringBuilder YfvGYJz3 = new StringBuilder(hL4bDTYk.size() * 100);
		int E5lgICJn = 0;
		for (SubmissionData LVSD6dEI : hL4bDTYk) {
			YfvGYJz3.append(LVSD6dEI.toString(sessionId, E5lgICJn));
			YfvGYJz3.append('\n');
			E5lgICJn++;
		}
		String a6ofiN35 = YfvGYJz3.toString();
		if (Caller.getInstance().isDebugMode())
			System.out.println("submit: " + a6ofiN35);
		HttpURLConnection VkFlvafV = Caller.getInstance().openConnection(submissionUrl);
		VkFlvafV.setRequestMethod("POST");
		VkFlvafV.setDoOutput(true);
		OutputStream sVzdfHPU = VkFlvafV.getOutputStream();
		BufferedWriter S2lJNKJ7 = new BufferedWriter(new OutputStreamWriter(sVzdfHPU));
		S2lJNKJ7.write(a6ofiN35);
		S2lJNKJ7.close();
		InputStream Cj8duokK = VkFlvafV.getInputStream();
		BufferedReader iRg53Z3i = new BufferedReader(new InputStreamReader(Cj8duokK));
		String rnDcPCxQ = iRg53Z3i.readLine();
		iRg53Z3i.close();
		int mvW1m5TU = ResponseStatus.codeForStatus(rnDcPCxQ);
		if (mvW1m5TU == ResponseStatus.FAILED) {
			return new ResponseStatus(mvW1m5TU, rnDcPCxQ.substring(rnDcPCxQ.indexOf(' ') + 1));
		}
		return new ResponseStatus(mvW1m5TU);
	}

}