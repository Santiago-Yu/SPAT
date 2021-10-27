class n4824415 {
	public static String encrypt(String eZyOMyzJ, String[] EWjQbkUH) {
		try {
			MessageDigest pVnXyY5v = MessageDigest.getInstance(eZyOMyzJ);
			pVnXyY5v.reset();
			for (int YyJWVHJL = 0; YyJWVHJL < EWjQbkUH.length; YyJWVHJL++) {
				if (EWjQbkUH[YyJWVHJL] != null)
					pVnXyY5v.update(EWjQbkUH[YyJWVHJL].getBytes("UTF-8"));
			}
			byte[] yBJ8x1Wg = pVnXyY5v.digest();
			StringBuffer Ff87xSq6 = new StringBuffer();
			for (int Y8a7quEw = 0; Y8a7quEw < yBJ8x1Wg.length; Y8a7quEw++) {
				Ff87xSq6.append(Integer.toHexString((0xf0 & yBJ8x1Wg[Y8a7quEw]) >> 4));
				Ff87xSq6.append(Integer.toHexString(0x0f & yBJ8x1Wg[Y8a7quEw]));
			}
			return Ff87xSq6.toString();
		} catch (NoSuchAlgorithmException yWBv1yiV) {
			throw new RuntimeException(yWBv1yiV);
		} catch (UnsupportedEncodingException MKcEbR3Z) {
			throw new RuntimeException(MKcEbR3Z);
		} catch (NullPointerException ERuNBMmr) {
			return new StringBuffer().toString();
		}
	}

}