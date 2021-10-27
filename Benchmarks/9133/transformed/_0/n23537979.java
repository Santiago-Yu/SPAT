class n23537979 {
	private void addLine(AmazonItem vTaWIDm2) {
		try {
			URL s77qGAra = new URL("" + vTaWIDm2.getMediumImageURL());
			TableItem MfqU20be = new TableItem(table, SWT.DRAW_DELIMITER | SWT.DRAW_TAB | SWT.DRAW_MNEMONIC);
			s77qGAra.openConnection();
			InputStream As0I1SRA = s77qGAra.openStream();
			Image TfQIkVms = new Image(display, As0I1SRA);
			coverAvailable.add(s77qGAra);
			MfqU20be.setImage(new Image[] { TfQIkVms, null });
			MfqU20be.setText(new String[] { null,
					vTaWIDm2.getArtist() + "\n" + vTaWIDm2.getCDTitle() + "\nTrack : " + vTaWIDm2.getNbTrack() });
		} catch (MalformedURLException EodLI56i) {
		} catch (IOException sFK6g6U2) {
			System.err.println(sFK6g6U2.toString());
		}
	}

}