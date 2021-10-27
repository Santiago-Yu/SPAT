class n7823489 {
	protected String getPostRequestContent(String ELCMe0g0, String FqeGjBF8) throws Exception {
		URL ULcGHayj = new URL(ELCMe0g0);
		HttpURLConnection jC45tbd2 = (HttpURLConnection) ULcGHayj.openConnection();
		String mWAbfNXE = null;
		try {
			jC45tbd2.setRequestMethod("POST");
			jC45tbd2.setUseCaches(false);
			jC45tbd2.setDoOutput(true);
			PrintStream Yf3gAiWb = new PrintStream(jC45tbd2.getOutputStream());
			Yf3gAiWb.print(FqeGjBF8);
			Yf3gAiWb.close();
			jC45tbd2.connect();
			BufferedReader rXsibTn4 = new BufferedReader(new InputStreamReader(jC45tbd2.getInputStream()));
			mWAbfNXE = rXsibTn4.readLine();
			rXsibTn4.close();
		} finally {
			jC45tbd2.disconnect();
		}
		return mWAbfNXE;
	}

}