class n23411500 {
	public void playSIDFromHVSC(String pxdRByoT) {
		player.reset();
		player.setStatus("Loading song: " + pxdRByoT);
		URL LY0IqlF3;
		try {
			if (pxdRByoT.startsWith("/")) {
				pxdRByoT = pxdRByoT.substring(1);
			}
			LY0IqlF3 = getResource(hvscBase + pxdRByoT);
			if (player.readSID(LY0IqlF3.openConnection().getInputStream())) {
				player.playSID();
			}
		} catch (IOException E2j2iFqe) {
			System.out.println("Could not load: ");
			E2j2iFqe.printStackTrace();
			player.setStatus("Could not load SID: " + E2j2iFqe.getMessage());
		}
	}

}