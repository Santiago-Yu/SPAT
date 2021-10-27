class n20081424 {
	public void performSearch(int searchStartIndex) {
		int index = 0;
		String searchString = keywords.getText();
		searchButton.setEnabled(false);
		if (!(!searchString.equals("")))
			;
		else {
			try {
				url = new URL(searchURL + "&num=" + maxReturns.getSelectedItem().toString() + "&start="
						+ searchStartIndex + "&q=" + searchString);
				System.out.println("Google search = " + url);
				InputStream input = url.openStream();
				int c;
				while ((c = input.read()) != -1) {
					result = result + (char) c;
				}
				String googleResultsFile = VueUtil.getDefaultUserFolder().getAbsolutePath() + File.separatorChar
						+ VueResources.getString("save.google.results");
				FileWriter fileWriter = new FileWriter(googleResultsFile);
				fileWriter.write(result);
				fileWriter.close();
				result = "";
				GSP gsp = loadGSP(googleResultsFile);
				Iterator i = gsp.getRES().getResultList().iterator();
				Vector resultVector = new Vector();
				while (i.hasNext()) {
					Result r = (Result) i.next();
					URLResource urlResource = new URLResource(r.getUrl());
					if (r.getTitle() != null)
						urlResource.setTitle(r.getTitle().replaceAll("</*[a-zA-Z]>", ""));
					else
						urlResource.setTitle(r.getUrl().toString());
					resultVector.add(urlResource);
					System.out.println(r.getTitle() + " " + r.getUrl());
				}
				VueDragTree tree = new VueDragTree(resultVector.iterator(), "GoogleSearchResults");
				tree.setEditable(true);
				tree.setRootVisible(false);
				googleResultsPanel.remove(jsp);
				jsp = new JScrollPane(tree);
				JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 2, 0));
				bottomPanel.add(prevButton);
				bottomPanel.add(nextButton);
				googleResultsPanel.add(bottomPanel, BorderLayout.SOUTH);
				googleResultsPanel.add(jsp, BorderLayout.CENTER);
				googleResultsPanel.validate();
				googlePane.setSelectedComponent(googleResultsPanel);
			} catch (Exception ex) {
				System.out.println("cannot connect google");
				googleResultsPanel.remove(jsp);
				JPanel jp = new JPanel(new BorderLayout());
				jp.setBackground(Color.WHITE);
				JLabel jl = new JLabel("No Match Found");
				jp.add(jl, BorderLayout.NORTH);
				JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 2, 0));
				googleResultsPanel.add(jp, BorderLayout.CENTER);
				googleResultsPanel.validate();
				googlePane.setSelectedComponent(googleResultsPanel);
			}
		}
		searchButton.setEnabled(true);
	}

}