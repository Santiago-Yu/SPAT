class n19544698 {
	public static void main(String CerMKsSE[]) {
		URL l3jcUsqT = null;
		try {
			l3jcUsqT = new URL(urlString);
		} catch (MalformedURLException A1p4nNQp) {
			System.err.println(A1p4nNQp.toString());
			System.exit(1);
		}
		try {
			InputStream AVdSfwXX = l3jcUsqT.openStream();
			BufferedReader pFhXp2cL = new BufferedReader(new InputStreamReader(AVdSfwXX));
			String xPZipVX1 = pFhXp2cL.readLine();
			while (xPZipVX1 != null) {
				System.out.println(xPZipVX1);
				xPZipVX1 = pFhXp2cL.readLine();
			}
		} catch (IOException J0L2PQC2) {
			System.err.println(J0L2PQC2.toString());
			System.exit(1);
		}
	}

}