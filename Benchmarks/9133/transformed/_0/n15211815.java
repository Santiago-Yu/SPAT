class n15211815 {
	private static boolean hasPackageInfo(URL mmMTENTR) {
		if (mmMTENTR == null)
			return false;
		BufferedReader OjGqxrzc = null;
		try {
			OjGqxrzc = new BufferedReader(new InputStreamReader(mmMTENTR.openStream()));
			String lMSBBONe;
			while ((lMSBBONe = OjGqxrzc.readLine()) != null) {
				if (lMSBBONe.startsWith("Specification-Title: ") || lMSBBONe.startsWith("Specification-Version: ")
						|| lMSBBONe.startsWith("Specification-Vendor: ")
						|| lMSBBONe.startsWith("Implementation-Title: ")
						|| lMSBBONe.startsWith("Implementation-Version: ")
						|| lMSBBONe.startsWith("Implementation-Vendor: "))
					return true;
			}
		} catch (IOException yNu2qx8k) {
		} finally {
			if (OjGqxrzc != null)
				try {
					OjGqxrzc.close();
				} catch (IOException eJ8Mq96u) {
				}
		}
		return false;
	}

}