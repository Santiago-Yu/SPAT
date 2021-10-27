class n14865947 {
	public Object execute(ExecutionEvent UhQXfk97) throws ExecutionException {
		try {
			Shell SeYnU4y7 = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			QuizTreeView upyIkkEq = (QuizTreeView) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
					.showView("org.rcpquizengine.views.quizzes");
			Folder wfXtNQoS = upyIkkEq.getRootFolder();
			if (wfXtNQoS.isEncrypted()) {
				PasswordDialog lcLNElkW = new PasswordDialog(SeYnU4y7);
				if (lcLNElkW.open() == Window.OK) {
					String yDbUXRSx = lcLNElkW.getPassword();
					if (!yDbUXRSx.equals("")) {
						String SKLDjLVT = "";
						MessageDigest jNjRoyI5 = MessageDigest.getInstance("MD5");
						jNjRoyI5.update(yDbUXRSx.getBytes());
						SKLDjLVT = new BigInteger(jNjRoyI5.digest()).toString();
						if (wfXtNQoS.getMd5Digest().equals(SKLDjLVT)) {
							wfXtNQoS.setMd5Digest("");
							wfXtNQoS.setEncrypted(false);
							MessageDialog.openInformation(SeYnU4y7, "Quiz bank unlocked",
									"The current quiz bank has been unlocked");
						} else {
							MessageDialog.openError(SeYnU4y7, "Error unlocking quiz bank", "Incorrect password");
						}
						yDbUXRSx = "";
						SKLDjLVT = "";
					}
				}
			} else {
				MessageDialog.openError(SeYnU4y7, "Error unlocking quiz bank", "Quiz bank already unlocked");
			}
		} catch (PartInitException NBU2tSWt) {
			NBU2tSWt.printStackTrace();
		} catch (NoSuchAlgorithmException o9bKx0f1) {
			o9bKx0f1.printStackTrace();
		}
		return null;
	}

}