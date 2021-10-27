class n1896923 {
	protected static JXStatusBar getStatusBar(final JXPanel jxPanel, final JTabbedPane mainTabbedPane) {
		JXStatusBar statusBar = new JXStatusBar();
		try {
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			Enumeration<URL> urls = cl.getResources("META-INF/MANIFEST.MF");
			String substanceVer = null;
			String substanceBuildStamp = null;
			while (urls.hasMoreElements()) {
				InputStream is = urls.nextElement().openStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				while (true) {
					String line = br.readLine();
					if (null == line)
						break;
					int firstColonIndex = line.indexOf(":");
					if (firstColonIndex < 0)
						continue;
					String name = line.substring(0, firstColonIndex).trim();
					String val = line.substring(firstColonIndex + 1).trim();
					if (0 == name.compareTo("Substance-Version"))
						substanceVer = val;
					if (0 == name.compareTo("Substance-BuildStamp"))
						substanceBuildStamp = val;
				}
				try {
					br.close();
				} catch (IOException ioe) {
				}
			}
			if (substanceVer != null) {
				JLabel statusLabel = new JLabel(substanceVer + " [built on " + substanceBuildStamp + "]");
				JXStatusBar.Constraint cStatusLabel = new JXStatusBar.Constraint();
				cStatusLabel.setFixedWidth(300);
				statusBar.add(statusLabel, cStatusLabel);
			}
		} catch (IOException ioe) {
		}
		JXStatusBar.Constraint c2 = new JXStatusBar.Constraint(JXStatusBar.Constraint.ResizeBehavior.FILL);
		final JLabel tabLabel = new JLabel("");
		statusBar.add(tabLabel, c2);
		mainTabbedPane.getModel().addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				int selectedIndex = mainTabbedPane.getSelectedIndex();
				if (selectedIndex < 0)
					tabLabel.setText("No selected tab");
				else
					tabLabel.setText("Tab " + mainTabbedPane.getTitleAt(selectedIndex) + " selected");
			}
		});
		JPanel fontSizePanel = FontSizePanel.getPanel();
		JXStatusBar.Constraint fontSizePanelConstraints = new JXStatusBar.Constraint();
		fontSizePanelConstraints.setFixedWidth(270);
		statusBar.add(fontSizePanel, fontSizePanelConstraints);
		JPanel alphaPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 0));
		final JLabel alphaLabel = new JLabel("100%");
		final JSlider alphaSlider = new JSlider(0, 100, 100);
		alphaSlider.setFocusable(false);
		alphaSlider.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				int currValue = alphaSlider.getValue();
				alphaLabel.setText(currValue + "%");
				jxPanel.setAlpha(currValue / 100.0f);
			}
		});
		alphaSlider.setToolTipText("Changes the global opacity. Is not Substance-specific");
		alphaSlider.setPreferredSize(new Dimension(120, alphaSlider.getPreferredSize().height));
		alphaPanel.add(alphaLabel);
		alphaPanel.add(alphaSlider);
		JXStatusBar.Constraint alphaPanelConstraints = new JXStatusBar.Constraint();
		alphaPanelConstraints.setFixedWidth(160);
		statusBar.add(alphaPanel, alphaPanelConstraints);
		return statusBar;
	}

}