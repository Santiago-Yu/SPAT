class n22224116 {
	public static void main(String[] args) throws IOException {
		if (args.length == 0) {
			System.out.println(
					"Usage: \nGZIPcompress file\n" + "\tUses GZIP compression to compress " + "the file to test.gz");
			System.exit(1);
		}
		BufferedReader in = new BufferedReader(new FileReader(args[0]));
		BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("test.gz")));
		System.out.println("Writing file");
		int c;
		for (; (c = in.read()) != -1;)
			out.write(c);
		in.close();
		out.close();
		System.out.println("Reading file");
		BufferedReader in2 = new BufferedReader(
				new InputStreamReader(new GZIPInputStream(new FileInputStream("test.gz"))));
		String s;
		for (; (s = in2.readLine()) != null;)
			System.out.println(s);
	}

}