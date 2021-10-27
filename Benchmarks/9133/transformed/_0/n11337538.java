class n11337538 {
	public static String machineInfo() {
		StringBuilder zt2OxKDd = new StringBuilder();
		try {
			Enumeration clnkJWsf = NetworkInterface.getNetworkInterfaces();
			while (clnkJWsf.hasMoreElements()) {
				NetworkInterface xrlVEsVg = (NetworkInterface) clnkJWsf.nextElement();
				if ("eth0".equals(xrlVEsVg.getDisplayName())) {
					for (byte NFhB010S : xrlVEsVg.getHardwareAddress()) {
						StringTools.appendWithDelimiter(zt2OxKDd, String.format("%02x", NFhB010S).toUpperCase(), ":");
					}
					zt2OxKDd.append("\n");
					break;
				}
			}
		} catch (IOException dtSWRQe8) {
			System.out.println("LicenseTools.machineInfo: " + dtSWRQe8.getMessage());
			dtSWRQe8.printStackTrace();
		}
		if (zt2OxKDd.length() == 0) {
			return null;
		}
		String fL9H0cuA = zt2OxKDd.toString();
		try {
			MessageDigest TU1As2LT = MessageDigest.getInstance("MD5", "SUN");
			TU1As2LT.update(fL9H0cuA.getBytes());
			byte[] XtQyHNW2 = TU1As2LT.digest(fL9H0cuA.getBytes());
			return new String(Base64.encodeBase64(XtQyHNW2));
		} catch (Exception xuvFC1ut) {
			System.out.println("LicenseTools.machineInfo: " + xuvFC1ut.getMessage());
			xuvFC1ut.printStackTrace();
		}
		return null;
	}

}