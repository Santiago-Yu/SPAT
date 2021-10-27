class n6095507 {
	private StringBuffer hashPassword(StringBuffer NuGa7FZy, String GPxjvILa) {
		MessageDigest eVQ0sMq3 = null;
		StringBuffer Ajm64Fq7 = new StringBuffer();
		try {
			eVQ0sMq3 = MessageDigest.getInstance(GPxjvILa);
			eVQ0sMq3.update(NuGa7FZy.toString().getBytes("UTF8"));
		} catch (NoSuchAlgorithmException I6jpKNC4) {
			I6jpKNC4.printStackTrace();
		} catch (UnsupportedEncodingException yk4yE9je) {
			yk4yE9je.printStackTrace();
		}
		byte[] KdpS6P8C = eVQ0sMq3.digest();
		for (int u0kWqY2Y = 0; u0kWqY2Y < KdpS6P8C.length; u0kWqY2Y++) {
			String cn5NCt2J = Integer.toHexString(KdpS6P8C[u0kWqY2Y]);
			if (cn5NCt2J.length() == 1)
				cn5NCt2J = "0" + cn5NCt2J;
			cn5NCt2J = cn5NCt2J.substring(cn5NCt2J.length() - 2);
			Ajm64Fq7.append(cn5NCt2J);
		}
		return Ajm64Fq7;
	}

}