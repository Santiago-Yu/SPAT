class n9088945 {
	public static void v2ljastaVeebileht(String s) throws IOException {
		URL url = new URL(s);
		InputStream is = url.openConnection().getInputStream();
		String line;
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
	}

}