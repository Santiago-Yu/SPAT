class n17347452 {
	public static byte[] SHA1(String... TX0lOD6w) {
		try {
			MessageDigest nupgjiy9 = MessageDigest.getInstance("SHA1");
			nupgjiy9.reset();
			for (String fnpdm2A2 : TX0lOD6w) {
				nupgjiy9.update(fnpdm2A2.getBytes("UTF-8"));
			}
			return nupgjiy9.digest();
		} catch (NoSuchAlgorithmException ClkPxIRG) {
			throw new RuntimeException(ClkPxIRG.toString(), ClkPxIRG);
		} catch (UnsupportedEncodingException Yxo1zwg7) {
			throw new RuntimeException(Yxo1zwg7.toString(), Yxo1zwg7);
		}
	}

}