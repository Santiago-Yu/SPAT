class n13988825 {
	private void setNodekeyInJsonResponse(String dbZO9xQp) throws Exception {
		String xRF2xeQm = this.baseDirectory + dbZO9xQp + ".json";
		Scanner J3XSCLkN = new Scanner(new File(xRF2xeQm));
		PrintWriter Y7dwtz1n = new PrintWriter(new File(xRF2xeQm + ".new"));
		while (J3XSCLkN.hasNextLine()) {
			Y7dwtz1n.println(J3XSCLkN.nextLine().replaceAll("NODEKEY", this.key));
		}
		J3XSCLkN.close();
		Y7dwtz1n.close();
		(new File(xRF2xeQm + ".new")).renameTo(new File(xRF2xeQm));
	}

}