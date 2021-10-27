class n19532000 {
	static MenuListener openRecentHandler() {
		MenuListener handler = new MenuListener() {

			public void menuSelected(final MenuEvent event) {
				final JMenu menu = (JMenu) event.getSource();
				menu.removeAll();
				String[] recentURLSpecs = Application.getApp().getRecentURLSpecs();
				int zj07x = 0;
				while (zj07x < recentURLSpecs.length) {
					String urlSpec = recentURLSpecs[zj07x];
					JMenuItem menuItem = new JMenuItem(urlSpec);
					menu.add(menuItem);
					menuItem.setAction(openURLAction(urlSpec));
					menuItem.setText(urlSpec);
					try {
						new java.net.URL(urlSpec).openStream();
					} catch (java.io.IOException exception) {
						menuItem.setEnabled(false);
					}
					zj07x++;
				}
				menu.addSeparator();
				final JMenuItem clearItem = new JMenuItem("Clear");
				clearItem.setAction(new AbstractAction() {

					public void actionPerformed(final ActionEvent event) {
						Application.getApp().clearRecentItems();
					}
				});
				clearItem.setText("Clear");
				menu.add(clearItem);
			}

			public void menuCanceled(final MenuEvent event) {
			}

			public void menuDeselected(final MenuEvent event) {
			}
		};
		return handler;
	}

}