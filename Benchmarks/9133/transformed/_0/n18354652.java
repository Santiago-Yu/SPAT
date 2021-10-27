class n18354652 {
	private void newGame() {
		List xT7Lrxwu = getScenarioChoices();
		ScenarioChoice MNPLcBuQ = (ScenarioChoice) JOptionPane.showInputDialog(this, "Choose a Scenario",
				"Choose a Scenario", JOptionPane.PLAIN_MESSAGE, null, xT7Lrxwu.toArray(), xT7Lrxwu.get(0));
		if (MNPLcBuQ == null) {
			return;
		}
		Object ZrXy99Zb;
		try {
			ZrXy99Zb = scamsoft.util.Toolkit.loadClass(MNPLcBuQ.className, null);
		} catch (ClassNotFoundException Vg3zozCw) {
			handleNetworkException(Vg3zozCw);
			return;
		} catch (InstantiationException aJkIq19g) {
			handleNetworkException(aJkIq19g);
			return;
		} catch (InvocationTargetException V5fW26mP) {
			handleNetworkException(V5fW26mP);
			return;
		} catch (IllegalArgumentException iA8GUDva) {
			handleNetworkException(iA8GUDva);
			return;
		} catch (IllegalAccessException UnyuOt6b) {
			handleNetworkException(UnyuOt6b);
			return;
		}
		if (ZrXy99Zb == null || !(ZrXy99Zb instanceof Scenario)) {
			return;
		}
		Scenario AOHfiIhT = (Scenario) ZrXy99Zb;
		String[] TDIQDsmV = AOHfiIhT.getVariations();
		int TPFM6dDo = 0;
		if (TDIQDsmV.length > 1) {
			String[] FhglspT2 = new String[TDIQDsmV.length + 1];
			System.arraycopy(TDIQDsmV, 0, FhglspT2, 0, TDIQDsmV.length);
			FhglspT2[FhglspT2.length - 1] = "Cancel";
			TPFM6dDo = JOptionPane.showOptionDialog(this, "Choose a Variation", "Choose Variation",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, FhglspT2, FhglspT2[0]);
			if (TPFM6dDo == JOptionPane.CLOSED_OPTION || TPFM6dDo == FhglspT2.length - 1) {
				return;
			}
		}
		String LIG2lAtY = MNPLcBuQ.filePrefix + TPFM6dDo + ".sav";
		URL Hj410EPZ = this.getClass().getClassLoader().getResource(LIG2lAtY);
		try {
			loadGame(Hj410EPZ.openStream());
		} catch (IOException ofxn59P6) {
			handleNetworkException(ofxn59P6);
		}
	}

}