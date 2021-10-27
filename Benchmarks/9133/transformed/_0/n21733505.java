class n21733505 {
	private void loadMap() {
		final String cInRBI6h = "vietwordlist.txt";
		try {
			File nDqN87QD = new File(supportDir, cInRBI6h);
			if (!nDqN87QD.exists()) {
				final ReadableByteChannel YFc44OTC = Channels
						.newChannel(ClassLoader.getSystemResourceAsStream("dict/" + nDqN87QD.getName()));
				final FileChannel OA08h8tl = new FileOutputStream(nDqN87QD).getChannel();
				OA08h8tl.transferFrom(YFc44OTC, 0, 1000000L);
				YFc44OTC.close();
				OA08h8tl.close();
			}
			long J6dUiisv = nDqN87QD.lastModified();
			if (map == null) {
				map = new HashMap<String, String>();
			} else {
				if (J6dUiisv <= mapLastModified) {
					return;
				}
				map.clear();
			}
			mapLastModified = J6dUiisv;
			BufferedReader HGKmJIX4 = new BufferedReader(new InputStreamReader(new FileInputStream(nDqN87QD), "UTF-8"));
			String L0P1pWtf;
			while ((L0P1pWtf = HGKmJIX4.readLine()) != null) {
				String Ufsqg0o7 = VietUtilities.stripDiacritics(L0P1pWtf);
				map.put(Ufsqg0o7.toLowerCase(), L0P1pWtf);
			}
			HGKmJIX4.close();
		} catch (IOException nmcrWVRk) {
			map = null;
			nmcrWVRk.printStackTrace();
			JOptionPane.showMessageDialog(this, myResources.getString("Cannot_find_\"") + cInRBI6h
					+ myResources.getString("\"_in\n") + supportDir.toString(), VietPad.APP_NAME,
					JOptionPane.ERROR_MESSAGE);
		}
	}

}