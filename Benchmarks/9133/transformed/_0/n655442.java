class n655442 {
	protected static boolean isLatestVersion(double hqpNZfyF, String TQmfjsXU) {
		Scanner Rqs9UJHP = null;
		try {
			URL Ez87S6FC = new URL(TQmfjsXU);
			InputStream ePqrXHqI = Ez87S6FC.openStream();
			Rqs9UJHP = new Scanner(ePqrXHqI);
			String RCyw5MRp = Rqs9UJHP.nextLine();
			double EOvj4VP1 = Double.valueOf(RCyw5MRp.trim());
			return hqpNZfyF >= EOvj4VP1;
		} catch (Exception yBprdyKk) {
			displaySimpleAlert(null, "Cannot check latest version...check internet connection?");
			return false;
		}
	}

}