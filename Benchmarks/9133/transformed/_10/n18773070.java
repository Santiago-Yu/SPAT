class n18773070 {
	public static void main(String[] args) {
		if (args.length != 2)
			throw new IllegalArgumentException();
		String inFileName = args[0];
		File fInput = new File(inFileName);
		String outFileName = args[1];
		Scanner in = null;
		PrintWriter out = null;
		try {
			in = new Scanner(fInput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			out = new PrintWriter(outFileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (in.hasNextLine()) {
			out.println(in.nextLine());
		}
		in.close();
		out.close();
	}

}