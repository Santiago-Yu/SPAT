class n5271797 {
	private void loadMap() {
		final String LOHjFTw4 = "vietwordlist.txt";
		try {
			File BQ1hAjPp = new File(supportDir, LOHjFTw4);
			if (!BQ1hAjPp.exists()) {
				final ReadableByteChannel uqSHTMYS = Channels
						.newChannel(ClassLoader.getSystemResourceAsStream("dict/" + BQ1hAjPp.getName()));
				final FileChannel dCmILSqN = new FileOutputStream(BQ1hAjPp).getChannel();
				dCmILSqN.transferFrom(uqSHTMYS, 0, 1000000L);
				uqSHTMYS.close();
				dCmILSqN.close();
			}
			long RcYHxPfE = BQ1hAjPp.lastModified();
			if (map == null) {
				map = new HashMap();
			} else {
				if (RcYHxPfE <= mapLastModified) {
					return;
				}
				map.clear();
			}
			mapLastModified = RcYHxPfE;
			BufferedReader dhb4Ax26 = new BufferedReader(new InputStreamReader(new FileInputStream(BQ1hAjPp), "UTF-8"));
			String pt7BViQf;
			while ((pt7BViQf = dhb4Ax26.readLine()) != null) {
				String Z1EJO15a = VietUtilities.stripDiacritics(pt7BViQf);
				map.put(Z1EJO15a.toLowerCase(), pt7BViQf);
			}
			dhb4Ax26.close();
		} catch (IOException Tc1oau7I) {
			map = null;
			Tc1oau7I.printStackTrace();
			JOptionPane.showMessageDialog(this, myResources.getString("Cannot_find_\"") + LOHjFTw4
					+ myResources.getString("\"_in\n") + supportDir.toString(), VietPad.APP_NAME,
					JOptionPane.ERROR_MESSAGE);
		}
	}

}