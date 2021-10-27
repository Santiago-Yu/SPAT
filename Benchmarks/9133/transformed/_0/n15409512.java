class n15409512 {
	public static void main(String I3OvYwh0[]) throws IOException {
		String KEGhvYHK = I3OvYwh0[0];
		String T74f64Wo = I3OvYwh0[1];
		long uALOtc7y = 0L;
		try {
			uALOtc7y = Long.parseLong(I3OvYwh0[2]);
		} catch (NumberFormatException lRZ3x32C) {
			try {
				uALOtc7y = Long.parseLong(I3OvYwh0[2], 16);
			} catch (NumberFormatException Yp5Od3Uh) {
				System.err.println("Wrong offset");
				System.exit(0);
			}
		}
		if (uALOtc7y < 1L) {
			System.err.println("Wrong offset. Must be more than 0");
			System.exit(0);
		}
		System.out.println("Copying  input: " + KEGhvYHK);
		System.out.println("        output: " + T74f64Wo);
		System.out.println("          from: " + uALOtc7y);
		BufferedInputStream ZoKBPoQL = new BufferedInputStream(new FileInputStream(KEGhvYHK));
		BufferedOutputStream d6lfO1Md = new BufferedOutputStream(new FileOutputStream(T74f64Wo));
		ZoKBPoQL.skip(uALOtc7y);
		for (byte[] SKn9At34 = new byte[1]; ZoKBPoQL.read(SKn9At34) > 0; d6lfO1Md.write(SKn9At34))
			;
		ZoKBPoQL.close();
		d6lfO1Md.close();
	}

}