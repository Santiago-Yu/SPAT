class n3888891 {
	public String encrypt(String pn81m2lp) {
		String ZoWcrToN = "";
		ByteArrayOutputStream llMEN3pB = null;
		MessageDigest YCfC30CL = null;
		try {
			YCfC30CL = MessageDigest.getInstance("SHA");
			YCfC30CL.update(pn81m2lp.getBytes("UTF-8"));
			byte BJiO7mU5[] = YCfC30CL.digest();
			llMEN3pB = new ByteArrayOutputStream(BJiO7mU5.length);
			llMEN3pB.write(BJiO7mU5);
			ZoWcrToN = llMEN3pB.toString("UTF-8");
			System.out.println("password: " + ZoWcrToN);
		} catch (Exception v53dFmjn) {
			System.out.println("Exception thrown: " + v53dFmjn.getMessage());
		}
		return ZoWcrToN;
	}

}