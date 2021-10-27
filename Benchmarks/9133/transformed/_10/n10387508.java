class n10387508 {
	public static void main(String[] args) {
		final MavenDeployerGui gui = new MavenDeployerGui();
		final Chooser repositoryChooser = new Chooser(gui.formPanel, JFileChooser.DIRECTORIES_ONLY);
		final Chooser artifactChooser = new Chooser(gui.formPanel, JFileChooser.FILES_ONLY);
		final Chooser pomChooser = new Chooser(gui.formPanel, JFileChooser.FILES_ONLY, new POMFilter());
		gui.cancel.setEnabled(false);
		gui.cbDeployPOM.setVisible(false);
		gui.cbDeployPOM.setEnabled(false);
		gui.mavenBin.setText(findMavenExecutable());
		gui.repositoryBrowser.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				File repo = repositoryChooser.chooseFrom(currentDir);
				if (repo != null) {
					currentDir = repositoryChooser.currentFolder;
					gui.repositoryURL.setText(repo.getAbsolutePath());
				}
			}
		});
		gui.artifactBrowser.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				File artifact = artifactChooser.chooseFrom(currentDir);
				if (artifact != null) {
					currentDir = artifactChooser.currentFolder;
					gui.artifactFile.setText(artifact.getAbsolutePath());
				}
			}
		});
		gui.deploy.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				deployer = new Deployer(gui, pom);
				deployer.execute();
			}
		});
		gui.clear.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				gui.console.setText("");
			}
		});
		gui.cancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (deployer != null) {
					deployer.stop();
					deployer = null;
				}
			}
		});
		gui.cbDeployPOM.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				readPOM(gui);
			}
		});
		gui.loadPOM.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				pom = pomChooser.chooseFrom(currentDir);
				if (pom != null) {
					currentDir = pomChooser.currentFolder;
					readPOM(gui);
					gui.cbDeployPOM.setText("Deploy also " + pom.getAbsolutePath());
					gui.cbDeployPOM.setEnabled(true);
					gui.cbDeployPOM.setVisible(true);
				}
			}
		});
		String version = "";
		try {
			Properties p = new Properties();
			URL url = Thread.currentThread().getContextClassLoader()
					.getResource("META-INF/maven/com.mycila.maven/maven-deployer/pom.properties");
			p.load(url.openStream());
			version = " " + p.getProperty("version");
		} catch (Exception ignored) {
			version = " x.y";
		}
		JFrame frame = new JFrame("Maven Deployer" + version + " - By Mathieu Carbou (http://blog.mycila.com)");
		frame.setContentPane(gui.formPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLocationByPlatform(true);
		frame.pack();
		frame.setVisible(true);
	}

}