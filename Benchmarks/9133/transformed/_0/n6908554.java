class n6908554 {
	static void reopen(MJIEnv Jn0FoQl7, int TvzzVWFa) throws IOException {
		int xrQESedA = Jn0FoQl7.getIntField(TvzzVWFa, "fd");
		long Y1MA9ncH = Jn0FoQl7.getLongField(TvzzVWFa, "off");
		if (content.get(xrQESedA) == null) {
			int DMoXPvQ7 = Jn0FoQl7.getIntField(TvzzVWFa, "mode");
			int oSMK3Ff2 = Jn0FoQl7.getReferenceField(TvzzVWFa, "fileName");
			String Z1VkvgQ5 = Jn0FoQl7.getStringObject(oSMK3Ff2);
			if (DMoXPvQ7 == FD_READ) {
				FileInputStream LSwgMLUp = new FileInputStream(Z1VkvgQ5);
				FileChannel StAnKESc = LSwgMLUp.getChannel();
				StAnKESc.position(Y1MA9ncH);
				content.set(xrQESedA, LSwgMLUp);
			} else if (DMoXPvQ7 == FD_WRITE) {
				FileOutputStream OK0pkbob = new FileOutputStream(Z1VkvgQ5);
				FileChannel WjTDN4b8 = OK0pkbob.getChannel();
				WjTDN4b8.position(Y1MA9ncH);
				content.set(xrQESedA, OK0pkbob);
			} else {
				Jn0FoQl7.throwException("java.io.IOException", "illegal mode: " + DMoXPvQ7);
			}
		}
	}

}