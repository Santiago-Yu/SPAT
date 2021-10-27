class n10195648 {
	public static void main(String[] sTalBJ9H) {
		if (sTalBJ9H.length != 3) {
			System.out.println("Usage: HexStrToBin enc/dec <infileName> <outfilename>");
			System.exit(1);
		}
		try {
			ByteArrayOutputStream zsetDQPs = new ByteArrayOutputStream();
			InputStream IByMJ8Qb = new FileInputStream(sTalBJ9H[1]);
			int ertKzpJl = 0;
			byte Zl4mFwSw[] = new byte[1024];
			while ((ertKzpJl = IByMJ8Qb.read(Zl4mFwSw)) > 0)
				zsetDQPs.write(Zl4mFwSw, 0, ertKzpJl);
			IByMJ8Qb.close();
			zsetDQPs.close();
			byte[] WauEk0QT = null;
			if (sTalBJ9H[0].equals("dec"))
				WauEk0QT = decode(zsetDQPs.toString());
			else {
				String LdKY1UUa = encode(zsetDQPs.toByteArray());
				WauEk0QT = LdKY1UUa.getBytes();
			}
			FileOutputStream CSeQ1ERS = new FileOutputStream(sTalBJ9H[2]);
			CSeQ1ERS.write(WauEk0QT);
			CSeQ1ERS.close();
		} catch (Exception aCUdug2u) {
			aCUdug2u.printStackTrace();
		}
	}

}