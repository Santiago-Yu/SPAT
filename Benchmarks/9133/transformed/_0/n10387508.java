class n10387508 {
	public static void main(String[] QLPrLCvw) {
		final MavenDeployerGui bixiifEN = new MavenDeployerGui();
		final Chooser KxuHsozb = new Chooser(bixiifEN.formPanel, JFileChooser.DIRECTORIES_ONLY);
		final Chooser gLXQ2dLS = new Chooser(bixiifEN.formPanel, JFileChooser.FILES_ONLY);
		final Chooser xG8Ufsjd = new Chooser(bixiifEN.formPanel, JFileChooser.FILES_ONLY, new POMFilter());
		bixiifEN.cancel.setEnabled(false);
		bixiifEN.cbDeployPOM.setVisible(false);
		bixiifEN.cbDeployPOM.setEnabled(false);
		bixiifEN.mavenBin.setText(findMavenExecutable());
		bixiifEN.repositoryBrowser.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent yLHkQK4Z) {
				File wSwdI2fR = KxuHsozb.chooseFrom(currentDir);
				if (wSwdI2fR != null) {
					currentDir = KxuHsozb.currentFolder;
					bixiifEN.repositoryURL.setText(wSwdI2fR.getAbsolutePath());
				}
			}
		});
		bixiifEN.artifactBrowser.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent vVvSGSiq) {
				File HITzZwWi = gLXQ2dLS.chooseFrom(currentDir);
				if (HITzZwWi != null) {
					currentDir = gLXQ2dLS.currentFolder;
					bixiifEN.artifactFile.setText(HITzZwWi.getAbsolutePath());
				}
			}
		});
		bixiifEN.deploy.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent yVZTYzBW) {
				deployer = new Deployer(bixiifEN, pom);
				deployer.execute();
			}
		});
		bixiifEN.clear.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent yotqgH5B) {
				bixiifEN.console.setText("");
			}
		});
		bixiifEN.cancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent RswvWy8S) {
				if (deployer != null) {
					deployer.stop();
					deployer = null;
				}
			}
		});
		bixiifEN.cbDeployPOM.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent if1mpuhf) {
				readPOM(bixiifEN);
			}
		});
		bixiifEN.loadPOM.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent rnUZC62K) {
				pom = xG8Ufsjd.chooseFrom(currentDir);
				if (pom != null) {
					currentDir = xG8Ufsjd.currentFolder;
					readPOM(bixiifEN);
					bixiifEN.cbDeployPOM.setText("Deploy also " + pom.getAbsolutePath());
					bixiifEN.cbDeployPOM.setEnabled(true);
					bixiifEN.cbDeployPOM.setVisible(true);
				}
			}
		});
		String gPrgizct = "";
		try {
			URL AmSdKfd7 = Thread.currentThread().getContextClassLoader()
					.getResource("META-INF/maven/com.mycila.maven/maven-deployer/pom.properties");
			Properties Oqf0iEfE = new Properties();
			Oqf0iEfE.load(AmSdKfd7.openStream());
			gPrgizct = " " + Oqf0iEfE.getProperty("version");
		} catch (Exception xxlo5oTj) {
			gPrgizct = " x.y";
		}
		JFrame kMfqdziF = new JFrame("Maven Deployer" + gPrgizct + " - By Mathieu Carbou (http://blog.mycila.com)");
		kMfqdziF.setContentPane(bixiifEN.formPanel);
		kMfqdziF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		kMfqdziF.setLocationRelativeTo(null);
		kMfqdziF.setLocationByPlatform(true);
		kMfqdziF.pack();
		kMfqdziF.setVisible(true);
	}

}