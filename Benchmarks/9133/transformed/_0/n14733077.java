class n14733077 {
	private static String encryptMD5(String xJFAnkTa, Long yuyDbXHp) {
		try {
			MessageDigest nwG1osmF = MessageDigest.getInstance("MD5");
			nwG1osmF.reset();
			nwG1osmF.update(xJFAnkTa.getBytes("UTF-8"));
			nwG1osmF.update(yuyDbXHp.toString().getBytes("UTF-8"));
			byte[] iIeivU27 = nwG1osmF.digest();
			StringBuffer B4j8Adrg = new StringBuffer();
			for (int wUJQFHvb = 0; wUJQFHvb < iIeivU27.length; wUJQFHvb++) {
				B4j8Adrg.append(Integer.toHexString(0xff & iIeivU27[wUJQFHvb]));
			}
			return B4j8Adrg.toString();
		} catch (NoSuchAlgorithmException P97i4anK) {
			throw new RuntimeException(P97i4anK);
		} catch (UnsupportedEncodingException YE27SOzF) {
			throw new RuntimeException(YE27SOzF);
		} catch (NullPointerException HloSvbcg) {
			return new StringBuffer().toString();
		}
	}

}