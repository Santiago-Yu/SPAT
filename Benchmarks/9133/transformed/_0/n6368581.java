class n6368581 {
	private URLConnection getConnection(String SaYJe3YA, int b3G8Utv5) {
		URLConnection fGaKJLk1 = null;
		try {
			fGaKJLk1 = new URL(SaYJe3YA).openConnection();
		} catch (IOException VHHYkqq8) {
			if (b3G8Utv5 < 5) {
				System.out.println();
				System.out.print("getConnection failed - ");
				System.out.println(b3G8Utv5);
				System.out.println("Trying again ...");
				fGaKJLk1 = this.getConnection(SaYJe3YA, b3G8Utv5++);
			} else {
				System.out.println("Giving up");
				throw new OntopiaRuntimeException(VHHYkqq8);
			}
		}
		return fGaKJLk1;
	}

}