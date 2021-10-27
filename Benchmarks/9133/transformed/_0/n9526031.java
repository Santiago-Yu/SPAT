class n9526031 {
	public boolean register(Object D2o2nxqb) {
		String sI11AFEX;
		if (D2o2nxqb == null)
			throw new IllegalArgumentException("object cannot be null");
		if (!(D2o2nxqb instanceof User)) {
			throw new IllegalArgumentException("passed argument is not an instance of the User class");
		}
		User kIYAhJFm = (User) D2o2nxqb;
		sI11AFEX = kIYAhJFm.getPassword();
		kIYAhJFm.setPassword(passwordEncoder.encodePassword(sI11AFEX, null));
		kIYAhJFm.setRegDate(new Date());
		logger.debug("Setting default Authority {} to new user!", Authority.DEFAULT_NAME);
		kIYAhJFm.getAuthorities().add(super.find(Authority.class, 1));
		logger.debug("Creating hash from email address! using Base64");
		kIYAhJFm.setHash(new String(Base64.encodeBase64(kIYAhJFm.getEmail().getBytes())));
		logger.debug("Creating phpBB forum User, by calling URL: {}", forumUrl);
		try {
			StringBuilder riFcEFVK = new StringBuilder(forumUrl);
			riFcEFVK.append("phpBB.php?action=register").append("&login=").append(kIYAhJFm.getLogin())
					.append("&password=").append(sI11AFEX).append("&email=").append(kIYAhJFm.getEmail());
			sqlInjectionPreventer(riFcEFVK.toString());
			logger.debug("Connecting to URL: {}", riFcEFVK.toString());
			URL dDWpsa0B = new URL(riFcEFVK.toString());
			URLConnection WkkNwsUM = dDWpsa0B.openConnection();
			BufferedReader Ev5rxrxw = new BufferedReader(new InputStreamReader(WkkNwsUM.getInputStream()));
			String Tc8G1Mx7;
			while ((Tc8G1Mx7 = Ev5rxrxw.readLine()) != null)
				kIYAhJFm.setForumID(Integer.valueOf(Tc8G1Mx7));
			Ev5rxrxw.close();
		} catch (IOException tVCWT7pt) {
			logger.error("Connecting failed! Msg: {}", tVCWT7pt.getMessage());
			throw new RuntimeException("Couldn't conntect to phpBB");
		} catch (NumberFormatException RxaeWcb2) {
			logger.error("phpBB user generation failed! Msg: {}", RxaeWcb2.getMessage());
			throw new RuntimeException("phpBB user generation failed!");
		}
		entityManager.persist(kIYAhJFm);
		try {
			sendConfirmationEmail(kIYAhJFm);
			return true;
		} catch (MailException DWjYCV1s) {
			return false;
		}
	}

}