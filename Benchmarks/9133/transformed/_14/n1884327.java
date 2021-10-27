class n1884327 {
	public void actionPerformed(java.awt.event.ActionEvent e) {
		try {
			setStatus(DigestSignTask.RESET, "");
			if (sd == e.getSource())
				if (retriveEncodedDigestFromServer())
					setStatus(DigestSignTask.RESET, "Inserire il pin e battere INVIO per firmare.");
			if (pwd == e.getSource()) {
				initStatus(0, DigestSignTask.SIGN_MAXIMUM);
				if (detectCardAndCriptoki()) {
					dsTask = new DigestSignTask(getCryptokiLib(), getSignerLabel(), log);
					timer = new Timer(ONE_SECOND, new java.awt.event.ActionListener() {

						public void actionPerformed(java.awt.event.ActionEvent evt) {
							setStatus(dsTask.getCurrent(), dsTask.getMessage());
							if (dsTask.done()) {
								timer.stop();
								progressBar.setValue(progressBar.getMinimum());
								if (DigestSignTask.SIGN_DONE == dsTask.getCurrent()) {
									Toolkit.getDefaultToolkit().beep();
									setEncryptedDigest(dsTask.getEncryptedDigest());
									returnEncryptedDigestToForm();
									setCertificate(dsTask.getCertificate());
									returnCertificateToForm();
									if (getSubmitAfterSigning()) {
										submitForm();
									}
								}
								enableControls(true);
							}
						}
					});
					sign();
				}
			}
			if (enc == e.getSource()) {
				log.println("\nCalculating digest ...\n");
				java.security.MessageDigest md5 = java.security.MessageDigest.getInstance("MD5");
				md5.update(dataArea.getText().getBytes("UTF8"));
				byte[] digest = md5.digest();
				log.println("digest:\n" + formatAsHexString(digest));
				log.println("Done.");
				setEncodedDigest(encodeFromBytes(digest));
				returnDigestToForm();
			}
			if (ld == e.getSource())
				retriveEncodedDigestFromForm();
			if (led == e.getSource())
				retriveEncryptedDigestFromForm();
			if (v == e.getSource()) {
				verify();
			}
		} catch (Exception ex) {
			log.println(ex.toString());
		} finally {
			pwd.setText("");
		}
	}

}