class n23411499 {
	public void playSIDFromURL(String FksBwL4n) {
		player.reset();
		player.setStatus("Loading song: " + FksBwL4n);
		URL D5D7XzbB;
		try {
			if (FksBwL4n.startsWith("http")) {
				D5D7XzbB = new URL(FksBwL4n);
			} else {
				D5D7XzbB = getResource(FksBwL4n);
			}
			if (player.readSID(D5D7XzbB.openConnection().getInputStream())) {
				player.playSID();
			}
		} catch (IOException H5syEd76) {
			System.out.println("Could not load: ");
			H5syEd76.printStackTrace();
			player.setStatus("Could not load SID: " + H5syEd76.getMessage());
		}
	}

}