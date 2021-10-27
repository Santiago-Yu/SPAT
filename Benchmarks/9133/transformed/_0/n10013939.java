class n10013939 {
	public Object execute(ExecutionEvent RLCONcDd) throws ExecutionException {
		try {
			Shell Z9M7hglQ = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			QuizTreeView X7A6zIZA = (QuizTreeView) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
					.showView("org.rcpquizengine.views.quizzes");
			Folder FEFp3AZD = X7A6zIZA.getRootFolder();
			if (!FEFp3AZD.isEncrypted()) {
				PasswordDialog HyWsBcSs = new PasswordDialog(Z9M7hglQ);
				if (HyWsBcSs.open() == Window.OK) {
					String yBlZaLxB = HyWsBcSs.getPassword();
					if (!yBlZaLxB.equals("")) {
						String mJY8A8NX = "";
						MessageDigest u47puFGO = MessageDigest.getInstance("MD5");
						u47puFGO.update(yBlZaLxB.getBytes());
						mJY8A8NX = new BigInteger(u47puFGO.digest()).toString();
						FEFp3AZD.setMd5Digest(mJY8A8NX);
						FEFp3AZD.setEncrypted(true);
						MessageDialog.openInformation(Z9M7hglQ, "Quiz bank locked",
								"The current quiz bank has been locked");
						yBlZaLxB = "";
						mJY8A8NX = "";
					}
				}
			} else {
				MessageDialog.openError(Z9M7hglQ, "Error locking quiz bank", "Quiz bank already locked");
			}
		} catch (PartInitException YRCPbHil) {
			YRCPbHil.printStackTrace();
		} catch (NoSuchAlgorithmException FNE59vWA) {
			FNE59vWA.printStackTrace();
		}
		return null;
	}

}