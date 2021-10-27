class n7776792 {
	public static void main(String[] kwga1ESO) throws Exception {
		URL IEzZ4RtI = new URL("http://www.yahoo.com");
		HttpURLConnection f8jv5aOn = (HttpURLConnection) IEzZ4RtI.openConnection();
		f8jv5aOn.connect();
		BufferedReader hapAvT3O = new BufferedReader(new InputStreamReader(f8jv5aOn.getInputStream()));
		String oVknUOLF = "";
		String prykUgVH = "";
		while ((oVknUOLF = hapAvT3O.readLine()) != null) {
			prykUgVH += oVknUOLF;
		}
		System.out.println(prykUgVH);
	}

}