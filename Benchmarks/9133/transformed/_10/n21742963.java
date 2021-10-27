class n21742963 {
	public static void main(String[] args) throws Exception {
		if (args.length != 2) {
			System.out.println("usage: PutFromFile [properties file] [file with pmpxml]");
			throw new IllegalArgumentException("Wrong number of arguments");
		}
		char[] b = new char[1024];
		Reader is = new FileReader(args[1]);
		int n;
		StringBuffer sb = new StringBuffer();
		while ((n = is.read(b)) > 0) {
			sb.append(b, 0, n);
		}
		String test = sb.toString();
		System.out.println(test);
		String strurl = args[0];
		URL url = new URL(strurl);
		String data = "verb=PutRecord&xml=" + URLEncoder.encode(test, "UTF-8");
		URLConnection conn = url.openConnection();
		conn.setDoOutput(true);
		OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
		wr.write(data);
		wr.flush();
		String line;
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		while ((line = rd.readLine()) != null) {
			System.out.println(line);
		}
		wr.close();
		rd.close();
	}

}