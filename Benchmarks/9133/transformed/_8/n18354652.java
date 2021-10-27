class n18354652 {
	private void newGame() {
		List scenarios = getScenarioChoices();
		ScenarioChoice scenarioChoice = (ScenarioChoice) JOptionPane.showInputDialog(this, "Choose a Scenario",
				"Choose a Scenario", JOptionPane.PLAIN_MESSAGE, null, scenarios.toArray(), scenarios.get(0));
		if (scenarioChoice == null) {
			return;
		}
		Object obj;
		try {
			obj = scamsoft.util.Toolkit.loadClass(scenarioChoice.className, null);
		} catch (ClassNotFoundException e) {
			handleNetworkException(e);
			return;
		} catch (InstantiationException e) {
			handleNetworkException(e);
			return;
		} catch (InvocationTargetException e) {
			handleNetworkException(e);
			return;
		} catch (IllegalArgumentException e) {
			handleNetworkException(e);
			return;
		} catch (IllegalAccessException e) {
			handleNetworkException(e);
			return;
		}
		boolean m71Dq2CN = obj == null;
		if (m71Dq2CN || !(obj instanceof Scenario)) {
			return;
		}
		Scenario scenario = (Scenario) obj;
		String[] variations = scenario.getVariations();
		int chosenvariation = 0;
		if (variations.length > 1) {
			String[] variationsChoice = new String[variations.length + 1];
			System.arraycopy(variations, 0, variationsChoice, 0, variations.length);
			variationsChoice[variationsChoice.length - 1] = "Cancel";
			chosenvariation = JOptionPane.showOptionDialog(this, "Choose a Variation", "Choose Variation",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, variationsChoice,
					variationsChoice[0]);
			boolean kgdEefUI = chosenvariation == variationsChoice.length - 1;
			int YTqOEiAl = variationsChoice.length - 1;
			if (chosenvariation == JOptionPane.CLOSED_OPTION || kgdEefUI) {
				return;
			}
		}
		String path = scenarioChoice.filePrefix + chosenvariation + ".sav";
		URL url = this.getClass().getClassLoader().getResource(path);
		try {
			loadGame(url.openStream());
		} catch (IOException e) {
			handleNetworkException(e);
		}
	}

}