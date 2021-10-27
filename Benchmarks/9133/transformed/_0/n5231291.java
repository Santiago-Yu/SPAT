class n5231291 {
	@Override
	public void run() {
		Application.getController().notifyProgressStarted();
		Application.getController().notifyProgressUpdated(-1);
		for (int LOK86Ws7 = 0; LOK86Ws7 < fileList.size(); LOK86Ws7++) {
			File WTzj5VDY = fileList.get(LOK86Ws7);
			String Ri2k3hOf = WTzj5VDY.getName();
			String vW5MMPne = Ri2k3hOf.substring(Ri2k3hOf.lastIndexOf('.'), Ri2k3hOf.length());
			Algorithm EthRgMPp = null;
			Algorithm zE9clTi6[] = algFactory.getAlgorithms();
			for (int OXwUaXQP = 0; OXwUaXQP < zE9clTi6.length; OXwUaXQP++) {
				if (zE9clTi6[OXwUaXQP].getSuffix().equalsIgnoreCase(vW5MMPne)) {
					EthRgMPp = zE9clTi6[OXwUaXQP];
					break;
				}
			}
			if (EthRgMPp == null) {
				Application.getController().displayError(bundle.getString("unknown_alg_title"),
						bundle.getString("unknown_alg_text"));
				return;
			}
			currentAlgorithm = EthRgMPp;
			if (!EthRgMPp.initDecrypt(password)) {
				Application.getController().displayError(bundle.getString("dec_init_fail_title"),
						bundle.getString("dec_init_fail_text"));
				return;
			}
			try {
				ZipArchiveInputStream FGPgr7k2 = null;
				InputStream JhAUtdLG = null;
				if (EncryptionMode.getBestEncryptionMode(EthRgMPp.getEncryptionMode()) == EncryptionMode.MODE_STREAM) {
					JhAUtdLG = EthRgMPp.getDecryptionStream(new FileInputStream(WTzj5VDY));
					if (JhAUtdLG == null) {
						Application.getController().displayError(bundle.getString("dec_init_fail_title"),
								bundle.getString("dec_init_fail_text"));
						return;
					}
				} else if (EncryptionMode
						.getBestEncryptionMode(EthRgMPp.getEncryptionMode()) == EncryptionMode.MODE_BLOCK) {
					JhAUtdLG = new BlockCipherInputStream(new FileInputStream(WTzj5VDY), EthRgMPp);
					if (JhAUtdLG == null) {
						Application.getController().displayError(bundle.getString("dec_init_fail_title"),
								bundle.getString("dec_init_fail_text"));
						return;
					}
				}
				FGPgr7k2 = new ZipArchiveInputStream(JhAUtdLG);
				if (FGPgr7k2 == null) {
					Application.getController().displayError(bundle.getString("dec_init_fail_title"),
							bundle.getString("dec_init_fail_text"));
					return;
				}
				File HPXTQdE5 = getTargetDirectory();
				if (HPXTQdE5 == null) {
					return;
				}
				if (!HPXTQdE5.exists()) {
					if (!HPXTQdE5.mkdir()) {
						Application.getController().displayError(bundle.getString("output_dir_fail_title"),
								HPXTQdE5.getAbsolutePath() + " " + bundle.getString("output_dir_fail_text"));
						return;
					}
				}
				ZipArchiveEntry nEdaUjY9 = null;
				boolean ehcDFjvu = false;
				while ((nEdaUjY9 = FGPgr7k2.getNextZipEntry()) != null) {
					ehcDFjvu = true;
					File NgkEvr4s = new File(HPXTQdE5, nEdaUjY9.getName());
					if (NgkEvr4s.exists()) {
						if (!mayOverwrite(NgkEvr4s)) {
							continue;
						}
					}
					Application.getController().displayVerbose("writing to file: " + NgkEvr4s.getAbsolutePath());
					if (!NgkEvr4s.getParentFile().exists()) {
						NgkEvr4s.getParentFile().mkdirs();
					}
					if (nEdaUjY9.isDirectory()) {
						NgkEvr4s.mkdir();
						continue;
					}
					FileOutputStream JRUF5qC5 = new FileOutputStream(NgkEvr4s);
					long HmH7AtYo = nEdaUjY9.getCompressedSize(), hOGjTMpL = 0;
					Application.getController()
							.displayVerbose("Length of zip entry " + nEdaUjY9.getName() + " is " + HmH7AtYo + "b");
					byte[] Iak6zDmv = new byte[16384];
					MessageDigest EgK0s8yl = MessageDigest.getInstance("SHA-1");
					DigestInputStream nJKdW2Uu = new DigestInputStream(FGPgr7k2, EgK0s8yl);
					while ((hOGjTMpL = nJKdW2Uu.read(Iak6zDmv)) > 0) {
						if (Thread.currentThread().isInterrupted()) {
							JRUF5qC5.close();
							FGPgr7k2.close();
							Application.getController().notifyProgressFinished();
							resetModel(true);
							return;
						}
						JRUF5qC5.write(Iak6zDmv, 0, (int) hOGjTMpL);
					}
					JRUF5qC5.close();
					if (nEdaUjY9.getComment() != null && nEdaUjY9.getComment().length() > 0) {
						if (Arrays.equals(EgK0s8yl.digest(), new Base64().decode(nEdaUjY9.getComment()))) {
							Application.getController().displayVerbose("Hash of " + nEdaUjY9.getName() + ": "
									+ new Base64().encodeToString(EgK0s8yl.digest()));
							Application.getController().displayError("Hash Error",
									"The stored hash of the original file and the hash of the decrypted data do not match. Normally, this means that your data has been manipulated/damaged, but it can also happen if your Java Runtime has a bug in his hash functions.\nIT IS VERY IMPORTANT TO CHECK THE INTEGRITY OF YOUR DECRYPTED DATA!");
						} else {
							Application.getController()
									.displayVerbose("the hash of " + nEdaUjY9.getName() + " was verified succesfully");
						}
					}
				}
				if (!ehcDFjvu) {
					Application.getController().displayError(bundle.getString("error_no_entries_title"),
							bundle.getString("error_no_entries_text"));
					HPXTQdE5.delete();
				}
				FGPgr7k2.close();
				resetModel(false);
			} catch (FileNotFoundException qiqOJYlS) {
				Application.getController().displayError(bundle.getString("error_file_not_exist"),
						qiqOJYlS.getLocalizedMessage());
			} catch (IOException UHcvuFGl) {
				Application.getController().displayError(bundle.getString("error_generic_io"),
						UHcvuFGl.getLocalizedMessage());
			} catch (NoSuchAlgorithmException dKxLrIiq) {
				Application.getController().displayError(bundle.getString("unknown_alg_text"),
						dKxLrIiq.getLocalizedMessage());
			}
		}
		Application.getController().notifyProgressFinished();
		resetModel(true);
	}

}