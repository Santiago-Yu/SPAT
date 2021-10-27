class n20081424 {
	public void performSearch(int o7uaI63x) {
		int NPfEtyCw = 0;
		String jHp9HNud = keywords.getText();
		searchButton.setEnabled(false);
		if (!jHp9HNud.equals("")) {
			try {
				url = new URL(searchURL + "&num=" + maxReturns.getSelectedItem().toString() + "&start=" + o7uaI63x
						+ "&q=" + jHp9HNud);
				System.out.println("Google search = " + url);
				InputStream yG7gATG5 = url.openStream();
				int dUYrRsGv;
				while ((dUYrRsGv = yG7gATG5.read()) != -1) {
					result = result + (char) dUYrRsGv;
				}
				String Vx6xVoo0 = VueUtil.getDefaultUserFolder().getAbsolutePath() + File.separatorChar
						+ VueResources.getString("save.google.results");
				FileWriter s1sEIzlb = new FileWriter(Vx6xVoo0);
				s1sEIzlb.write(result);
				s1sEIzlb.close();
				result = "";
				GSP DYMx9FWM = loadGSP(Vx6xVoo0);
				Iterator QHClLTPl = DYMx9FWM.getRES().getResultList().iterator();
				Vector iEzUz2Tf = new Vector();
				while (QHClLTPl.hasNext()) {
					Result q5qOrouY = (Result) QHClLTPl.next();
					URLResource lyoUC8Wj = new URLResource(q5qOrouY.getUrl());
					if (q5qOrouY.getTitle() != null)
						lyoUC8Wj.setTitle(q5qOrouY.getTitle().replaceAll("</*[a-zA-Z]>", ""));
					else
						lyoUC8Wj.setTitle(q5qOrouY.getUrl().toString());
					iEzUz2Tf.add(lyoUC8Wj);
					System.out.println(q5qOrouY.getTitle() + " " + q5qOrouY.getUrl());
				}
				VueDragTree zphxsEKQ = new VueDragTree(iEzUz2Tf.iterator(), "GoogleSearchResults");
				zphxsEKQ.setEditable(true);
				zphxsEKQ.setRootVisible(false);
				googleResultsPanel.remove(jsp);
				jsp = new JScrollPane(zphxsEKQ);
				JPanel Z8JbPzyu = new JPanel(new FlowLayout(FlowLayout.RIGHT, 2, 0));
				Z8JbPzyu.add(prevButton);
				Z8JbPzyu.add(nextButton);
				googleResultsPanel.add(Z8JbPzyu, BorderLayout.SOUTH);
				googleResultsPanel.add(jsp, BorderLayout.CENTER);
				googleResultsPanel.validate();
				googlePane.setSelectedComponent(googleResultsPanel);
			} catch (Exception LyolKAwW) {
				System.out.println("cannot connect google");
				googleResultsPanel.remove(jsp);
				JPanel lzmf56Sr = new JPanel(new BorderLayout());
				lzmf56Sr.setBackground(Color.WHITE);
				JLabel xpOrAnMk = new JLabel("No Match Found");
				lzmf56Sr.add(xpOrAnMk, BorderLayout.NORTH);
				JPanel IeBSfYLB = new JPanel(new FlowLayout(FlowLayout.RIGHT, 2, 0));
				googleResultsPanel.add(lzmf56Sr, BorderLayout.CENTER);
				googleResultsPanel.validate();
				googlePane.setSelectedComponent(googleResultsPanel);
			}
		}
		searchButton.setEnabled(true);
	}

}