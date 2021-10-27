class n23537979{
    private void addLine(AmazonItem coverAdress) {
        try {
            URL url = new URL("" + coverAdress.getMediumImageURL());
            TableItem ligne1 = new TableItem(table, SWT.DRAW_DELIMITER | SWT.DRAW_TAB | SWT.DRAW_MNEMONIC);
            url.openConnection();
            InputStream is = url.openStream();
            Image coverPicture = new Image(display, is);
            coverAvailable.add(url);
            ligne1.setImage(new Image[] { coverPicture, null });
            ligne1.setText(new String[] { null, coverAdress.getArtist() + "\n" + coverAdress.getCDTitle() + "\nTrack : " + coverAdress.getNbTrack() });
        } catch (MalformedURLException e) {
        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }

}