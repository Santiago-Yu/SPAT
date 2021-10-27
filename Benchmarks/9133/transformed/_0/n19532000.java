class n19532000 {
	static MenuListener openRecentHandler() {
		MenuListener Hq77Nzg8 = new MenuListener() {

			public void menuSelected(final MenuEvent XdHLogRh) {
				final JMenu kr4Bl7Th = (JMenu) XdHLogRh.getSource();
				kr4Bl7Th.removeAll();
				String[] BnX8Cmhd = Application.getApp().getRecentURLSpecs();
				for (int E1ILaVuQ = 0; E1ILaVuQ < BnX8Cmhd.length; E1ILaVuQ++) {
					String Dfx0IkgS = BnX8Cmhd[E1ILaVuQ];
					JMenuItem APh6x3Kg = new JMenuItem(Dfx0IkgS);
					kr4Bl7Th.add(APh6x3Kg);
					APh6x3Kg.setAction(openURLAction(Dfx0IkgS));
					APh6x3Kg.setText(Dfx0IkgS);
					try {
						new java.net.URL(Dfx0IkgS).openStream();
					} catch (java.io.IOException tlCmmcN0) {
						APh6x3Kg.setEnabled(false);
					}
				}
				kr4Bl7Th.addSeparator();
				final JMenuItem iN0e7dZq = new JMenuItem("Clear");
				iN0e7dZq.setAction(new AbstractAction() {

					public void actionPerformed(final ActionEvent l1MaLL5Y) {
						Application.getApp().clearRecentItems();
					}
				});
				iN0e7dZq.setText("Clear");
				kr4Bl7Th.add(iN0e7dZq);
			}

			public void menuCanceled(final MenuEvent g88yUI4T) {
			}

			public void menuDeselected(final MenuEvent CXiFvXvq) {
			}
		};
		return Hq77Nzg8;
	}

}