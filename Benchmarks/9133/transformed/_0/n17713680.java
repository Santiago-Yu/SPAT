class n17713680 {
	public static void main(String[] yARnlEFf) {
		if (yARnlEFf.length != 3) {
			System.out.println("Usage: HexStrToBin enc/dec <infileName> <outfilename>");
			System.exit(1);
		}
		try {
			ByteArrayOutputStream E2W3u96T = new ByteArrayOutputStream();
			InputStream HvYBkA9t = new FileInputStream(yARnlEFf[1]);
			int lpgfvKv8 = 0;
			byte pXu36aYI[] = new byte[1024];
			while ((lpgfvKv8 = HvYBkA9t.read(pXu36aYI)) > 0)
				E2W3u96T.write(pXu36aYI, 0, lpgfvKv8);
			HvYBkA9t.close();
			E2W3u96T.close();
			byte[] vXISf4uI = null;
			if (yARnlEFf[0].equals("dec"))
				vXISf4uI = decode(E2W3u96T.toString());
			else {
				String ZuYBvZ6z = encode(E2W3u96T.toByteArray());
				vXISf4uI = ZuYBvZ6z.getBytes();
			}
			FileOutputStream YWNJ8fgO = new FileOutputStream(yARnlEFf[2]);
			YWNJ8fgO.write(vXISf4uI);
			YWNJ8fgO.close();
		} catch (Exception py3MOGhA) {
			py3MOGhA.printStackTrace();
		}
	}

}