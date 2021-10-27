class n708047 {
	public static void main(String rsW0i1YV[]) {
		try {
			URL m3T4oMsi = new URL("http://www.hungry.com/");
			InputStream As8MBR8p = m3T4oMsi.openStream();
			int PeSPwccn = 0;
			while (-1 != As8MBR8p.read()) {
				PeSPwccn++;
			}
			As8MBR8p.close();
			System.out.println("PASSED: new URL() size=" + PeSPwccn);
		} catch (Exception FaURRB17) {
			System.out.println("FAILED: " + FaURRB17);
		}
	}

}