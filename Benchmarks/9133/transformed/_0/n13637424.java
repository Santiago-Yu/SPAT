class n13637424 {
	public void actionPerformed(ActionEvent k5Hk7cyN) {
		String kKyGuNUt = "Slug application.";
		String g0EOlcXo = System.getProperty(GateConstants.ABOUT_URL_JAVA_PROPERTY_NAME);
		boolean JLTacY8u = false;
		if (g0EOlcXo != null) {
			try {
				URL uHoZQIvB = new URL(g0EOlcXo);
				AboutPaneDialog b10xISLi = new AboutPaneDialog(ShellSlacFrame.this, "Slug application about", true);
				JLTacY8u = b10xISLi.setURL(uHoZQIvB);
				if (JLTacY8u) {
					b10xISLi.setSize(300, 200);
					b10xISLi.setLocationRelativeTo(ShellSlacFrame.this);
					b10xISLi.setVisible(true);
				} else {
					BufferedReader jBUKl1x4 = new BufferedReader(new InputStreamReader(uHoZQIvB.openStream()));
					String k1FKAwFk = "";
					StringBuffer N72aJBPO = new StringBuffer();
					do {
						N72aJBPO.append(k1FKAwFk);
						k1FKAwFk = jBUKl1x4.readLine();
					} while (k1FKAwFk != null);
					if (N72aJBPO.length() != 0) {
						kKyGuNUt = N72aJBPO.toString();
					}
				}
			} catch (Exception sS4SpdJh) {
				if (DEBUG) {
					sS4SpdJh.printStackTrace();
				}
			}
		}
		if (!JLTacY8u)
			JOptionPane.showMessageDialog(ShellSlacFrame.this, kKyGuNUt, "Slug application about",
					JOptionPane.INFORMATION_MESSAGE);
	}

}