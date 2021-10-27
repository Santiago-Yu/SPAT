class n15637504 {
	@Override
	protected void setUp() throws Exception {
		File repoFolder = new File("target/repository");
		this.logger = new ConsoleLogger(ConsoleLogger.LEVEL_WARN);
		removeRepository(repoFolder);
		InputStream repoConfigIn = getClass().getResourceAsStream(REPO_CONFIG_FILE);
		File tempRepoConfigFile = File.createTempFile("repository", "xml");
		tempRepoConfigFile.deleteOnExit();
		OutputStream tempRepoConfigOut = new FileOutputStream(tempRepoConfigFile);
		try {
			IOUtils.copy(repoConfigIn, tempRepoConfigOut);
		} finally {
			repoConfigIn.close();
			tempRepoConfigOut.close();
		}
		ServerAdapterFactory factory = new ServerAdapterFactory();
		Repository repo = new TransientRepository(tempRepoConfigFile.getAbsolutePath(), "target/repository");
		RemoteRepository remoteRepo = factory.getRemoteRepository(repo);
		reg = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
		reg.rebind(REMOTE_REPO_NAME, remoteRepo);
		session = repo.login(new SimpleCredentials(LOGIN, PWD.toCharArray()), WORKSPACE);
		InputStream nodeTypeDefIn = getClass().getResourceAsStream(MQ_JCR_XML_NODETYPES_FILE);
		JackrabbitInitializerHelper.setupRepository(session, new InputStreamReader(nodeTypeDefIn), "");
	}

}