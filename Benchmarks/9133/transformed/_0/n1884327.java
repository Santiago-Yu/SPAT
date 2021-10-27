class n1884327 {
	public void actionPerformed(java.awt.event.ActionEvent ZR82ZRGf) {
		try {
			setStatus(DigestSignTask.RESET, "");
			if (ZR82ZRGf.getSource() == sd)
				if (retriveEncodedDigestFromServer())
					setStatus(DigestSignTask.RESET, "Inserire il pin e battere INVIO per firmare.");
			if (ZR82ZRGf.getSource() == pwd) {
				initStatus(0, DigestSignTask.SIGN_MAXIMUM);
				if (detectCardAndCriptoki()) {
					dsTask = new DigestSignTask(getCryptokiLib(), getSignerLabel(), log);
					timer = new Timer(ONE_SECOND, new java.awt.event.ActionListener() {

						public void actionPerformed(java.awt.event.ActionEvent EDZbf2ja) {
							setStatus(dsTask.getCurrent(), dsTask.getMessage());
							if (dsTask.done()) {
								timer.stop();
								progressBar.setValue(progressBar.getMinimum());
								if (dsTask.getCurrent() == DigestSignTask.SIGN_DONE) {
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
			if (ZR82ZRGf.getSource() == enc) {
				log.println("\nCalculating digest ...\n");
				java.security.MessageDigest KfiBp0hi = java.security.MessageDigest.getInstance("MD5");
				KfiBp0hi.update(dataArea.getText().getBytes("UTF8"));
				byte[] spkuItDn = KfiBp0hi.digest();
				log.println("digest:\n" + formatAsHexString(spkuItDn));
				log.println("Done.");
				setEncodedDigest(encodeFromBytes(spkuItDn));
				returnDigestToForm();
			}
			if (ZR82ZRGf.getSource() == ld)
				retriveEncodedDigestFromForm();
			if (ZR82ZRGf.getSource() == led)
				retriveEncryptedDigestFromForm();
			if (ZR82ZRGf.getSource() == v) {
				verify();
			}
		} catch (Exception YKkQroz0) {
			log.println(YKkQroz0.toString());
		} finally {
			pwd.setText("");
		}
	}

}