class n9399634 {
	protected static String fileName2md5(String zoWuEP02) {
		try {
			MessageDigest UTyOZZ36 = MessageDigest.getInstance("MD5");
			UTyOZZ36.reset();
			UTyOZZ36.update(zoWuEP02.getBytes("iso-8859-1"));
			byte[] dYWjiSYz = UTyOZZ36.digest();
			UTyOZZ36.reset();
			StringBuffer pOvtHa8g = new StringBuffer();
			for (int D4zNKD3o = 0; D4zNKD3o < dYWjiSYz.length; D4zNKD3o++) {
				pOvtHa8g.append(Integer.toHexString(0xFF & dYWjiSYz[D4zNKD3o]));
			}
			return (pOvtHa8g.toString());
		} catch (Exception N9nliAL0) {
			Logger.error(N9nliAL0.getClass() + " " + N9nliAL0.getMessage());
			for (int jjZZd9Uj = 0; jjZZd9Uj < N9nliAL0.getStackTrace().length; jjZZd9Uj++)
				Logger.error("     " + N9nliAL0.getStackTrace()[jjZZd9Uj].toString());
			N9nliAL0.printStackTrace();
		}
		return String.valueOf(Math.random() * Long.MAX_VALUE);
	}

}