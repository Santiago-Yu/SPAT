class n14377058 {
	public String process(URL QUEflpYt) throws IOException {
		String dQIdOglc, HZpMrQS0 = "";
		InputStream O7YeJgJq = QUEflpYt.openStream();
		BufferedReader LIZMtCnC = new BufferedReader(new InputStreamReader(O7YeJgJq));
		while ((dQIdOglc = LIZMtCnC.readLine()) != null) {
			HZpMrQS0 += dQIdOglc + "\n";
		}
		System.out.println(HZpMrQS0);
		return HZpMrQS0;
	}

}