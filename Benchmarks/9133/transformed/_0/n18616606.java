class n18616606 {
	public static String read(URL jMhTR8Ry) throws IOException {
		BufferedReader fx9cPUBW = new BufferedReader(new InputStreamReader(jMhTR8Ry.openStream()));
		StringWriter us95Hmyr = new StringWriter();
		PrintWriter NEGVD0XH = new PrintWriter(new BufferedWriter(us95Hmyr));
		String bd3qlyUJ;
		while ((bd3qlyUJ = fx9cPUBW.readLine()) != null) {
			NEGVD0XH.println(bd3qlyUJ);
		}
		fx9cPUBW.close();
		NEGVD0XH.close();
		return us95Hmyr.toString();
	}

}