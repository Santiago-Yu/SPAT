class n2046165 {
	public void mouseClicked(MouseEvent IhyJN2r8) {
		if (IhyJN2r8.getClickCount() == 2) {
			int ZlTjSUT9 = lst.locationToIndex(IhyJN2r8.getPoint());
			try {
				String B055H6Lm = (String) lst.getModel().getElementAt(ZlTjSUT9), ATaOfe4f, fVpb9ugF, eWQLXWqp;
				if (B055H6Lm.indexOf("at chr") != -1) {
					B055H6Lm = B055H6Lm.substring(B055H6Lm.indexOf("at ") + 3);
					ATaOfe4f = B055H6Lm.substring(0, B055H6Lm.indexOf(":"));
					B055H6Lm = B055H6Lm.substring(B055H6Lm.indexOf(":") + 1);
					fVpb9ugF = B055H6Lm.substring(0, B055H6Lm.indexOf("-"));
					eWQLXWqp = B055H6Lm.substring(B055H6Lm.indexOf("-") + 1);
					moveViewer(ATaOfe4f, Integer.parseInt(fVpb9ugF), Integer.parseInt(eWQLXWqp));
				} else {
					String agW6CAgi = chooseHGVersion(selPanel.dsn);
					URL emESFn1x = new URL(
							"http://genome.ucsc.edu/cgi-bin/hgTracks?hgsid=" + agW6CAgi + "&position=" + B055H6Lm);
					InputStream M6WXw4Hn = emESFn1x.openStream();
					BufferedReader dMrzBhgu = new BufferedReader(new InputStreamReader(M6WXw4Hn));
					readUCSCLocation(B055H6Lm, dMrzBhgu);
				}
			} catch (Exception u9iMWTMz) {
				u9iMWTMz.printStackTrace();
			}
		}
	}

}