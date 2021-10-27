class n2490462 {
	private void getRandomGUID(boolean llrk73AB) {
		MessageDigest gbjYf8Tk = null;
		StringBuffer syGNBhds = new StringBuffer();
		try {
			gbjYf8Tk = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException NXbJuMx6) {
			System.out.println("Error: " + NXbJuMx6);
		}
		try {
			long JMZwFtLw = System.currentTimeMillis();
			long VY1mPf6U = 0;
			if (llrk73AB) {
				VY1mPf6U = mySecureRand.nextLong();
			} else {
				VY1mPf6U = myRand.nextLong();
			}
			syGNBhds.append(s_id);
			syGNBhds.append(":");
			syGNBhds.append(Long.toString(JMZwFtLw));
			syGNBhds.append(":");
			syGNBhds.append(Long.toString(VY1mPf6U));
			valueBeforeMD5 = syGNBhds.toString();
			gbjYf8Tk.update(valueBeforeMD5.getBytes());
			byte[] XwBWTdE8 = gbjYf8Tk.digest();
			StringBuffer WXP6n7wu = new StringBuffer();
			for (int Q3IAhJqA = 0; Q3IAhJqA < XwBWTdE8.length; ++Q3IAhJqA) {
				int CDg8NW6K = XwBWTdE8[Q3IAhJqA] & 0xFF;
				if (CDg8NW6K < 0x10)
					WXP6n7wu.append('0');
				WXP6n7wu.append(Integer.toHexString(CDg8NW6K));
			}
			valueAfterMD5 = WXP6n7wu.toString();
		} catch (Exception aFPhXTOQ) {
			System.out.println("Error:" + aFPhXTOQ);
		}
	}

}