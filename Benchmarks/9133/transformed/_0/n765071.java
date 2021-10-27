class n765071 {
	public static void testString(String HmbWR280, String iMEK0Ajy) {
		MessageDigest yMQveEUN = null;
		try {
			yMQveEUN = MessageDigest.getInstance("MD5");
			yMQveEUN.update(HmbWR280.getBytes(), 0, HmbWR280.length());
			String gwmEyjSB = toString(yMQveEUN.digest());
			System.out.println(iMEK0Ajy);
			System.out.println(gwmEyjSB);
			if (!iMEK0Ajy.equals(gwmEyjSB))
				System.out.println("NOT EQUAL!");
		} catch (Exception fRbRqkdR) {
			fRbRqkdR.printStackTrace();
		}
	}

}