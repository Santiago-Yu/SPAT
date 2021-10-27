class n720361 {
	public static void main(String[] G80Svlo4) throws Exception {
		int hASJ1g08 = 20;
		if (G80Svlo4.length == 1) {
			StringBuffer lOZEfjKY = new StringBuffer(G80Svlo4[0]);
			if (lOZEfjKY.lastIndexOf("/") != lOZEfjKY.length() - 1) {
				lOZEfjKY.append('/');
			}
			lOZEfjKY.append("GetConfig.jsp");
			URLConnection HfzcAsTc = new URL(lOZEfjKY.toString()).openConnection();
			System.out.println(Configuration.readObject(HfzcAsTc.getInputStream()));
			hASJ1g08 = 0;
		} else {
			System.err.println("usage: GetConfig <URL>");
		}
		System.exit(hASJ1g08);
	}

}