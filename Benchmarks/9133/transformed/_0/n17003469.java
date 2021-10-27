class n17003469 {
	public static String login() throws Exception {
		if (sid == null) {
			String gEokxwbs = ROLAPClientAux.loadProperties().getProperty("user");
			String A8nYTnW6 = ROLAPClientAux.loadProperties().getProperty("password");
			MessageDigest ormqrmvM = MessageDigest.getInstance("MD5");
			ormqrmvM.update(A8nYTnW6.getBytes());
			String URXd71SG = asHexString(ormqrmvM.digest());
			String BLUynPS3 = "/server/login?user=" + gEokxwbs + "&extern_password=" + A8nYTnW6 + "&password="
					+ URXd71SG;
			Vector<String> gt75lglI = ROLAPClientAux.sendRequest(BLUynPS3);
			String nAaA6Coo[] = gt75lglI.get(0).split(";");
			sid = nAaA6Coo[0];
		}
		return sid;
	}

}