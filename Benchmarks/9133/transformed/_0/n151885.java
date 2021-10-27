class n151885 {
	private static void main(String[] VBb4rCIa) {
		try {
			File cNBftFSl = new File("test.txt");
			if (cNBftFSl.exists()) {
				throw new IOException(cNBftFSl + " already exists.  I don't want to overwrite it.");
			}
			StraightStreamReader VXFPoskK;
			char[] ifGgc27I = new char[0x1000];
			int UWVUFAUe;
			int oTEDYAjb;
			FileOutputStream fEsG2Ale = new FileOutputStream(cNBftFSl);
			for (int xAw1voSD = 0x00; xAw1voSD < 0x100; xAw1voSD++) {
				fEsG2Ale.write(xAw1voSD);
			}
			fEsG2Ale.close();
			VXFPoskK = new StraightStreamReader(new FileInputStream(cNBftFSl));
			for (int UefcYHs1 = 0x00; UefcYHs1 < 0x100; UefcYHs1++) {
				UWVUFAUe = VXFPoskK.read();
				if (UWVUFAUe != UefcYHs1) {
					System.err.println("Error: " + UefcYHs1 + " read as " + UWVUFAUe);
				}
			}
			VXFPoskK.close();
			VXFPoskK = new StraightStreamReader(new FileInputStream(cNBftFSl));
			oTEDYAjb = VXFPoskK.read(ifGgc27I);
			if (oTEDYAjb != 0x100) {
				System.err.println(
						"Simple buffered read did not read the full amount: 0x" + Integer.toHexString(oTEDYAjb));
			}
			for (int vnp75G6m = 0x00; vnp75G6m < oTEDYAjb; vnp75G6m++) {
				if (ifGgc27I[vnp75G6m] != vnp75G6m) {
					System.err.println("Error: 0x" + vnp75G6m + " read as 0x" + ifGgc27I[vnp75G6m]);
				}
			}
			VXFPoskK.close();
			VXFPoskK = new StraightStreamReader(new FileInputStream(cNBftFSl));
			oTEDYAjb = 0;
			while (oTEDYAjb <= 0x100 && (UWVUFAUe = VXFPoskK.read(ifGgc27I, oTEDYAjb, 0x100 - oTEDYAjb)) > 0) {
				oTEDYAjb += UWVUFAUe;
			}
			if (oTEDYAjb != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(oTEDYAjb));
			}
			for (int z33l6YaX = 0x00; z33l6YaX < oTEDYAjb; z33l6YaX++) {
				if (ifGgc27I[z33l6YaX] != z33l6YaX) {
					System.err.println("Error: 0x" + z33l6YaX + " read as 0x" + ifGgc27I[z33l6YaX]);
				}
			}
			VXFPoskK.close();
			VXFPoskK = new StraightStreamReader(new FileInputStream(cNBftFSl));
			oTEDYAjb = 0;
			while (oTEDYAjb <= 0x100 && (UWVUFAUe = VXFPoskK.read(ifGgc27I, oTEDYAjb + 0x123, 0x100 - oTEDYAjb)) > 0) {
				oTEDYAjb += UWVUFAUe;
			}
			if (oTEDYAjb != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(oTEDYAjb));
			}
			for (int vWcjNywM = 0x00; vWcjNywM < oTEDYAjb; vWcjNywM++) {
				if (ifGgc27I[vWcjNywM + 0x123] != vWcjNywM) {
					System.err.println("Error: 0x" + vWcjNywM + " read as 0x" + ifGgc27I[vWcjNywM + 0x123]);
				}
			}
			VXFPoskK.close();
			VXFPoskK = new StraightStreamReader(new FileInputStream(cNBftFSl));
			oTEDYAjb = 0;
			while (oTEDYAjb <= 0x100 && (UWVUFAUe = VXFPoskK.read(ifGgc27I, oTEDYAjb + 0x123, 7)) > 0) {
				oTEDYAjb += UWVUFAUe;
			}
			if (oTEDYAjb != 0x100) {
				System.err.println("Not enough read. Bytes read: " + Integer.toHexString(oTEDYAjb));
			}
			for (int h37xN3bf = 0x00; h37xN3bf < oTEDYAjb; h37xN3bf++) {
				if (ifGgc27I[h37xN3bf + 0x123] != h37xN3bf) {
					System.err.println("Error: 0x" + h37xN3bf + " read as 0x" + ifGgc27I[h37xN3bf + 0x123]);
				}
			}
			VXFPoskK.close();
			cNBftFSl.delete();
		} catch (IOException M1qQQkIa) {
			System.err.println(M1qQQkIa.getMessage());
		}
	}

}