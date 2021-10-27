class n2518655 {
	public static void main(String[] args) throws FileNotFoundException {
		if (args.length < 2)
			throw new IllegalArgumentException();
		String fnOut = args[args.length - 1];
		PrintWriter writer = new PrintWriter(fnOut);
		int NapbM = 0;
		while (NapbM < args.length - 1) {
			File fInput = new File(args[NapbM]);
			Scanner in = new Scanner(fInput);
			while (in.hasNext()) {
				writer.println(in.nextLine());
			}
			NapbM++;
		}
		writer.close();
	}

}