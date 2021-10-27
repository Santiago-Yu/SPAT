class n17805384 {
	public static final String getUniqueId() {
		String CYd1uTB2 = "";
		try {
			MessageDigest W3qdERsq = MessageDigest.getInstance("MD5");
			String a9727cyU = "" + (System.currentTimeMillis() + 1);
			String eU2uoc6A = "";
			;
			try {
				eU2uoc6A = InetAddress.getLocalHost().toString();
			} catch (UnknownHostException WzWWDuVr) {
				log.error("Error trying to get localhost" + WzWWDuVr.getMessage());
			}
			String vyA3RYyR = "" + new Random().nextInt();
			String kgtyA1Gg = a9727cyU + eU2uoc6A + vyA3RYyR;
			W3qdERsq.reset();
			W3qdERsq.update(kgtyA1Gg.getBytes());
			CYd1uTB2 = toHexString(W3qdERsq.digest());
		} catch (NoSuchAlgorithmException ue5DEOu1) {
			log.error("Error trying to generate unique Id" + ue5DEOu1.getMessage());
		}
		return CYd1uTB2;
	}

}