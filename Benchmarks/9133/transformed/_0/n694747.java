class n694747 {
	private static void main(String[] gAmXJkR8) {
		try {
			File GV1AAN5b = new File("test.txt");
			if (GV1AAN5b.exists()) {
				throw new IOException(GV1AAN5b + " already exists.  I don't want to overwrite it.");
			}
			StraightStreamReader McssM8i0;
			char[] CNLbAkBx = new char[0x1000];
			int B3b70VBS;
			int XTjgzJUe;
			FileOutputStream gAx57ghK = new FileOutputStream(GV1AAN5b);
			for (int OYNRMeXx = 0x00; OYNRMeXx < 0x100; OYNRMeXx++) {
				gAx57ghK.write(OYNRMeXx);
			}
			gAx57ghK.close();
			McssM8i0 = new StraightStreamReader(new FileInputStream(GV1AAN5b));
			for (int lx8NY3iB = 0x00; lx8NY3iB < 0x100; lx8NY3iB++) {
				B3b70VBS = McssM8i0.read();
				if (B3b70VBS != lx8NY3iB) {
					System.err.println("Error: " + lx8NY3iB + " read as " + B3b70VBS);
				}
			}
			McssM8i0.close();
			McssM8i0 = new StraightStreamReader(new FileInputStream(GV1AAN5b));
			XTjgzJUe = McssM8i0.read(CNLbAkBx);
			if (XTjgzJUe != 0x100) {
				System.err.println(
						"Simple buffered read did not read the full amount: 0x" + Integer.toHexString(XTjgzJUe));
			}
			for (int FNOZnQyV = 0x00; FNOZnQyV < XTjgzJUe; FNOZnQyV++) {
				if (CNLbAkBx[FNOZnQyV] != FNOZnQyV) {
					System.err.println("Error: 0x" + FNOZnQyV + " read as 0x" + CNLbAkBx[FNOZnQyV]);
				}
			}
			McssM8i0.close();
			McssM8i0 = new StraightStreamReader(new FileInputStream(GV1AAN5b));
			XTjgzJUe = 0;
			while (XTjgzJUe <= 0x100 && (B3b70VBS = McssM8i0.read(CNLbAkBx, XTjgzJUe, 0x100 - XTjgzJUe)) > 0) {
				XTjgzJUe += B3b70VBS;
			}
			if (XTjgzJUe != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(XTjgzJUe));
			}
			for (int a6LMj0A3 = 0x00; a6LMj0A3 < XTjgzJUe; a6LMj0A3++) {
				if (CNLbAkBx[a6LMj0A3] != a6LMj0A3) {
					System.err.println("Error: 0x" + a6LMj0A3 + " read as 0x" + CNLbAkBx[a6LMj0A3]);
				}
			}
			McssM8i0.close();
			McssM8i0 = new StraightStreamReader(new FileInputStream(GV1AAN5b));
			XTjgzJUe = 0;
			while (XTjgzJUe <= 0x100 && (B3b70VBS = McssM8i0.read(CNLbAkBx, XTjgzJUe + 0x123, 0x100 - XTjgzJUe)) > 0) {
				XTjgzJUe += B3b70VBS;
			}
			if (XTjgzJUe != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(XTjgzJUe));
			}
			for (int km59H6XW = 0x00; km59H6XW < XTjgzJUe; km59H6XW++) {
				if (CNLbAkBx[km59H6XW + 0x123] != km59H6XW) {
					System.err.println("Error: 0x" + km59H6XW + " read as 0x" + CNLbAkBx[km59H6XW + 0x123]);
				}
			}
			McssM8i0.close();
			McssM8i0 = new StraightStreamReader(new FileInputStream(GV1AAN5b));
			XTjgzJUe = 0;
			while (XTjgzJUe <= 0x100 && (B3b70VBS = McssM8i0.read(CNLbAkBx, XTjgzJUe + 0x123, 7)) > 0) {
				XTjgzJUe += B3b70VBS;
			}
			if (XTjgzJUe != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(XTjgzJUe));
			}
			for (int cuDN7F6Z = 0x00; cuDN7F6Z < XTjgzJUe; cuDN7F6Z++) {
				if (CNLbAkBx[cuDN7F6Z + 0x123] != cuDN7F6Z) {
					System.err.println("Error: 0x" + cuDN7F6Z + " read as 0x" + CNLbAkBx[cuDN7F6Z + 0x123]);
				}
			}
			McssM8i0.close();
			GV1AAN5b.delete();
		} catch (IOException a8xRuz2R) {
			System.err.println(a8xRuz2R.getMessage());
		}
	}

}