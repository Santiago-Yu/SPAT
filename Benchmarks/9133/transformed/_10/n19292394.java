class n19292394 {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://www.sohu.com");
		InputStream is = url.openStream();
		FileOutputStream fos = new FileOutputStream("gen/sohu2.html");
		InputStreamReader isr = new InputStreamReader(is, Charset.forName("GB18030"));
		char[] b = new char[2048];
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		int temp;
		while (-1 != (temp = isr.read(b, 0, b.length))) {
			osw.write(b);
		}
		osw.close();
		String line = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
	}

}