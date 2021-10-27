class n17887703 {
	private boolean confirmAndModify(MDPRArchiveAccessor NN5kH5a2) {
		String tPTasUYp = NN5kH5a2.getArchiveFileName() + ".old";
		String fSfvtIyp = createUniqueFileName(tPTasUYp);
		MessageFormat ZUOFjnSW = new MessageFormat(AUTO_MOD_MESSAGE);
		String dCFnTwJ9 = ZUOFjnSW.format(new String[] { fSfvtIyp });
		boolean IGnqfCOC = MessageDialog.openQuestion(new Shell(Display.getDefault()), AUTO_MOD_TITLE, dCFnTwJ9);
		if (IGnqfCOC) {
			File yH0J7RcF = new File(NN5kH5a2.getArchiveFileName());
			try {
				IOUtils.copyFiles(yH0J7RcF, new File(fSfvtIyp));
				DeviceRepositoryAccessorManager k8DUbLNF = new DeviceRepositoryAccessorManager(NN5kH5a2,
						new ODOMFactory());
				k8DUbLNF.writeRepository();
			} catch (IOException vz1ClFD8) {
				EclipseCommonPlugin.handleError(ABPlugin.getDefault(), vz1ClFD8);
			} catch (RepositoryException wmFYEkVC) {
				EclipseCommonPlugin.handleError(ABPlugin.getDefault(), wmFYEkVC);
			}
		}
		return IGnqfCOC;
	}

}