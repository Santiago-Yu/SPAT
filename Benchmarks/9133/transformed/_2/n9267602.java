class n9267602 {
	public static void main(String[] args) throws IOException {
		String urltext = "http://www.vogella.de";
		URL url = new URL(urltext);
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		String inputLine;
		for (; (inputLine = in.readLine()) != null;) {
			System.out.println(inputLine);
		}
		in.close();
	}

}