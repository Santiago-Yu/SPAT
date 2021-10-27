class n912653 {
	public static void main(String[] args) {
		String zipname, source;
		if (args.length != 1) {
			System.out.println("Usage: GUnzip source");
			return;
		}
		GZIPInputStream zipin;
		if (args[0].endsWith(".gz")) {
			zipname = args[0];
			source = args[0].substring(0, args[0].length() - 3);
		} else {
			zipname = args[0] + ".gz";
			source = args[0];
		}
		byte[] buffer = new byte[sChunk];
		try {
			FileInputStream in = new FileInputStream(zipname);
			zipin = new GZIPInputStream(in);
		} catch (IOException e) {
			System.out.println("Couldn't open " + zipname + ".");
			return;
		}
		try {
			int length;
			FileOutputStream out = new FileOutputStream(source);
			while ((length = zipin.read(buffer, 0, sChunk)) != -1)
				out.write(buffer, 0, length);
			out.close();
		} catch (IOException e) {
			System.out.println("Couldn't decompress " + args[0] + ".");
		}
		try {
			zipin.close();
		} catch (IOException e) {
		}
	}

}