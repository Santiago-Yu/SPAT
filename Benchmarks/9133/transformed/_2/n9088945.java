class n9088945 {
	public static void v2ljastaVeebileht(String s) throws IOException {
		URL url = new URL(s);
		InputStream is = url.openConnection().getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line;
		for (; (line = br.readLine()) != null;) {
			System.out.println(line);
		}
	}

}