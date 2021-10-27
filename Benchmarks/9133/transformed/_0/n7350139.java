class n7350139 {
	public static void messageDigestTest() {
		try {
			MessageDigest F9AKR6I0 = MessageDigest.getInstance("MD5");
			F9AKR6I0.update("computer".getBytes());
			F9AKR6I0.update("networks".getBytes());
			System.out.println(new String(F9AKR6I0.digest()));
			System.out.println(new String(F9AKR6I0.digest("computernetworks".getBytes())));
		} catch (Exception hQuO9bd7) {
			hQuO9bd7.printStackTrace();
		}
	}

}