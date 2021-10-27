class n1896923 {
	protected static JXStatusBar getStatusBar(final JXPanel lFnbCRfv, final JTabbedPane DIvk17RT) {
		JXStatusBar xA3OLHU5 = new JXStatusBar();
		try {
			ClassLoader X08ewCQ4 = Thread.currentThread().getContextClassLoader();
			Enumeration<URL> C3dw6cml = X08ewCQ4.getResources("META-INF/MANIFEST.MF");
			String hSRHHYa6 = null;
			String A7ndDxXe = null;
			while (C3dw6cml.hasMoreElements()) {
				InputStream KldTbstb = C3dw6cml.nextElement().openStream();
				BufferedReader dzdvI2MC = new BufferedReader(new InputStreamReader(KldTbstb));
				while (true) {
					String cBciFb3s = dzdvI2MC.readLine();
					if (cBciFb3s == null)
						break;
					int UwCzuvDF = cBciFb3s.indexOf(":");
					if (UwCzuvDF < 0)
						continue;
					String mdTN0hBb = cBciFb3s.substring(0, UwCzuvDF).trim();
					String uywTvq9D = cBciFb3s.substring(UwCzuvDF + 1).trim();
					if (mdTN0hBb.compareTo("Substance-Version") == 0)
						hSRHHYa6 = uywTvq9D;
					if (mdTN0hBb.compareTo("Substance-BuildStamp") == 0)
						A7ndDxXe = uywTvq9D;
				}
				try {
					dzdvI2MC.close();
				} catch (IOException muK3sZ6O) {
				}
			}
			if (hSRHHYa6 != null) {
				JLabel uA4CiPVj = new JLabel(hSRHHYa6 + " [built on " + A7ndDxXe + "]");
				JXStatusBar.Constraint F5JmQqkM = new JXStatusBar.Constraint();
				F5JmQqkM.setFixedWidth(300);
				xA3OLHU5.add(uA4CiPVj, F5JmQqkM);
			}
		} catch (IOException hyy2IUyW) {
		}
		JXStatusBar.Constraint bCF191ks = new JXStatusBar.Constraint(JXStatusBar.Constraint.ResizeBehavior.FILL);
		final JLabel piSC4gkr = new JLabel("");
		xA3OLHU5.add(piSC4gkr, bCF191ks);
		DIvk17RT.getModel().addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent wmD0Pa4n) {
				int cCWL3vFt = DIvk17RT.getSelectedIndex();
				if (cCWL3vFt < 0)
					piSC4gkr.setText("No selected tab");
				else
					piSC4gkr.setText("Tab " + DIvk17RT.getTitleAt(cCWL3vFt) + " selected");
			}
		});
		JPanel G6VLUNnO = FontSizePanel.getPanel();
		JXStatusBar.Constraint pggntJIA = new JXStatusBar.Constraint();
		pggntJIA.setFixedWidth(270);
		xA3OLHU5.add(G6VLUNnO, pggntJIA);
		JPanel wLXaJlt3 = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 0));
		final JLabel YbsFutxx = new JLabel("100%");
		final JSlider LqLoUinm = new JSlider(0, 100, 100);
		LqLoUinm.setFocusable(false);
		LqLoUinm.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent c5hIapBY) {
				int ngcmEViu = LqLoUinm.getValue();
				YbsFutxx.setText(ngcmEViu + "%");
				lFnbCRfv.setAlpha(ngcmEViu / 100.0f);
			}
		});
		LqLoUinm.setToolTipText("Changes the global opacity. Is not Substance-specific");
		LqLoUinm.setPreferredSize(new Dimension(120, LqLoUinm.getPreferredSize().height));
		wLXaJlt3.add(YbsFutxx);
		wLXaJlt3.add(LqLoUinm);
		JXStatusBar.Constraint negVxyu3 = new JXStatusBar.Constraint();
		negVxyu3.setFixedWidth(160);
		xA3OLHU5.add(wLXaJlt3, negVxyu3);
		return xA3OLHU5;
	}

}