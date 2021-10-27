class n3472611 {
	@Override
	public void onClick(View LFoZyf8d) {
		String BJAr1uR9 = getFtpHostname();
		String U3M2PQ5Z = getFtpUsername();
		String KpUJ9Rmu = getFtpPassword();
		int vLttzFIM = getFtpPort();
		String zHinPVzn = getString(R.string.testingFTPConnectionDialogHeaderText) + " " + BJAr1uR9;
		ProgressDialog eUrs3QuU = ProgressDialog.show(this, "", zHinPVzn, true);
		String JjJc1QzD = "NOTHING??";
		Log.i(TAG, "Test attempt login to " + BJAr1uR9 + " as " + U3M2PQ5Z);
		FTPClient lvqO0Rh7 = new FTPClient();
		try {
			lvqO0Rh7.connect(BJAr1uR9, vLttzFIM);
			lvqO0Rh7.login(U3M2PQ5Z, KpUJ9Rmu);
			int sLWADM8v = lvqO0Rh7.getReplyCode();
			if (!FTPReply.isPositiveCompletion(sLWADM8v)) {
				JjJc1QzD = getString(R.string.testFTPConnectionDeniedString);
				Log.w(TAG, JjJc1QzD);
			} else {
				JjJc1QzD = getString(R.string.testFTPSuccessString);
				Log.i(TAG, JjJc1QzD);
			}
		} catch (Exception t8yiF9pq) {
			JjJc1QzD = getString(R.string.testFTPFailString) + t8yiF9pq;
			Log.w(TAG, JjJc1QzD);
		} finally {
			try {
				eUrs3QuU.dismiss();
				lvqO0Rh7.disconnect();
			} catch (Exception q4doRlmn) {
			}
		}
		Context ABrcZa64 = getApplicationContext();
		CharSequence qqSzUMJu = JjJc1QzD;
		int SnbCsMS0 = Toast.LENGTH_LONG;
		Toast Z6KUnHcc = Toast.makeText(ABrcZa64, qqSzUMJu, SnbCsMS0);
		Z6KUnHcc.show();
	}

}