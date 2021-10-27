class n3175529 {
	private static String connect(String nlJ1gKEH, boolean Rk8fcjlq) throws IOException {
		String I7XHn9Jp;
		if (Rk8fcjlq)
			I7XHn9Jp = "https://todoist.com/API/";
		else
			I7XHn9Jp = "http://todoist.com/API/";
		URL h3SO29xn = new URL(I7XHn9Jp + nlJ1gKEH);
		URLConnection ExlADjvT = h3SO29xn.openConnection();
		BufferedReader BAWepTwG = new BufferedReader(new InputStreamReader(ExlADjvT.getInputStream()));
		StringBuilder PPHTeto8 = new StringBuilder("");
		String BX9GkkaS;
		while ((BX9GkkaS = BAWepTwG.readLine()) != null)
			PPHTeto8.append(BX9GkkaS);
		return PPHTeto8.toString();
	}

}