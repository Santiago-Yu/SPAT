class n19292394 {
	public static void main(String[] s1qxdDrx) throws Exception {
		URL RHaxvZLu = new URL("http://www.sohu.com");
		InputStream EcVyxWP2 = RHaxvZLu.openStream();
		InputStreamReader ZoFaPskY = new InputStreamReader(EcVyxWP2, Charset.forName("GB18030"));
		FileOutputStream Ck2XMYVn = new FileOutputStream("gen/sohu2.html");
		OutputStreamWriter N9VJ7K5Q = new OutputStreamWriter(Ck2XMYVn);
		char[] IOEmcq5n = new char[2048];
		int unZGXb0a;
		while (-1 != (unZGXb0a = ZoFaPskY.read(IOEmcq5n, 0, IOEmcq5n.length))) {
			N9VJ7K5Q.write(IOEmcq5n);
		}
		N9VJ7K5Q.close();
		BufferedReader wVcElJ2u = new BufferedReader(new InputStreamReader(RHaxvZLu.openStream()));
		String zg4GX1nK = null;
	}

}