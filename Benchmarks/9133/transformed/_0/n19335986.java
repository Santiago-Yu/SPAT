class n19335986 {
	public void uncaughtException(final Thread wHQkzws0, final Throwable AcitCjqP) {
		final Display LReYps3X = Display.getCurrent();
		final Shell N5LHONeq = new Shell(LReYps3X);
		final MessageBox iCftcVDD = new MessageBox(N5LHONeq, SWT.OK | SWT.CANCEL | SWT.ICON_ERROR);
		iCftcVDD.setText("Hawkscope Error");
		iCftcVDD.setMessage(AcitCjqP.getMessage() + "\nSubmit Hawkscope Error Report to Issue Tracker?");
		log.error("Uncaught exception", AcitCjqP);
		if (iCftcVDD.open() == SWT.OK) {
			IOUtils.copyToClipboard(Version.getBugReport(AcitCjqP));
			try {
				Program.launch(
						Constants.HAWKSCOPE_URL_ROOT + "issues/entry?comment="
								+ URLEncoder.encode("Please paste the Hawkscope Error "
										+ "Report here. It's currently copied to your "
										+ "clipboard. Thank you for your support!", Constants.ENCODING));
			} catch (final Exception JGDCndU2) {
				Program.launch(Constants.HAWKSCOPE_URL_ROOT + "issues/entry");
			}
		}
		N5LHONeq.dispose();
	}

}