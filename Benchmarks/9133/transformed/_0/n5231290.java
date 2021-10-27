class n5231290 {
	private void doDecrypt() {
		runningThread = new Thread() {

			@Override
			public void run() {
				Application.getController().notifyProgressStarted();
				Application.getController().notifyProgressUpdated(-1);
				for (int FQyImuqE = 0; FQyImuqE < fileList.size(); FQyImuqE++) {
					File U7J9O3jc = fileList.get(FQyImuqE);
					String mAjUzFgf = U7J9O3jc.getName();
					String g48nZvHd = mAjUzFgf.substring(mAjUzFgf.lastIndexOf('.'), mAjUzFgf.length());
					Algorithm v2sUztzG = null;
					Algorithm pFxYeDtI[] = algFactory.getAlgorithms();
					for (int NDYLhKzB = 0; NDYLhKzB < pFxYeDtI.length; NDYLhKzB++) {
						if (pFxYeDtI[NDYLhKzB].getSuffix().equalsIgnoreCase(g48nZvHd)) {
							v2sUztzG = pFxYeDtI[NDYLhKzB];
							break;
						}
					}
					if (v2sUztzG == null) {
						Application.getController().displayError(bundle.getString("unknown_alg_title"),
								bundle.getString("unknown_alg_text"));
						return;
					}
					currentAlgorithm = v2sUztzG;
					if (!v2sUztzG.initDecrypt(password)) {
						Application.getController().displayError(bundle.getString("dec_init_fail_title"),
								bundle.getString("dec_init_fail_text"));
						return;
					}
					try {
						ZipArchiveInputStream aoVTBLto = null;
						InputStream XtHcP0o2 = null;
						if (EncryptionMode
								.getBestEncryptionMode(v2sUztzG.getEncryptionMode()) == EncryptionMode.MODE_STREAM) {
							XtHcP0o2 = v2sUztzG.getDecryptionStream(new FileInputStream(U7J9O3jc));
							if (XtHcP0o2 == null) {
								Application.getController().displayError(bundle.getString("dec_init_fail_title"),
										bundle.getString("dec_init_fail_text"));
								return;
							}
						} else if (EncryptionMode
								.getBestEncryptionMode(v2sUztzG.getEncryptionMode()) == EncryptionMode.MODE_BLOCK) {
							XtHcP0o2 = new BlockCipherInputStream(new FileInputStream(U7J9O3jc), v2sUztzG);
							if (XtHcP0o2 == null) {
								Application.getController().displayError(bundle.getString("dec_init_fail_title"),
										bundle.getString("dec_init_fail_text"));
								return;
							}
						}
						aoVTBLto = new ZipArchiveInputStream(XtHcP0o2);
						if (aoVTBLto == null) {
							Application.getController().displayError(bundle.getString("dec_init_fail_title"),
									bundle.getString("dec_init_fail_text"));
							return;
						}
						File fRYLIVFX = getTargetDirectory();
						if (fRYLIVFX == null) {
							return;
						}
						if (!fRYLIVFX.exists()) {
							if (!fRYLIVFX.mkdir()) {
								Application.getController().displayError(bundle.getString("output_dir_fail_title"),
										fRYLIVFX.getAbsolutePath() + " " + bundle.getString("output_dir_fail_text"));
								return;
							}
						}
						ZipArchiveEntry Fg0oeNlQ = null;
						boolean wDtPq42l = false;
						while ((Fg0oeNlQ = aoVTBLto.getNextZipEntry()) != null) {
							wDtPq42l = true;
							File HOwMsK3S = new File(fRYLIVFX, Fg0oeNlQ.getName());
							if (HOwMsK3S.exists()) {
								if (!mayOverwrite(HOwMsK3S)) {
									continue;
								}
							}
							Application.getController()
									.displayVerbose("writing to file: " + HOwMsK3S.getAbsolutePath());
							if (!HOwMsK3S.getParentFile().exists()) {
								HOwMsK3S.getParentFile().mkdirs();
							}
							if (Fg0oeNlQ.isDirectory()) {
								HOwMsK3S.mkdir();
								continue;
							}
							FileOutputStream lYOvxuwF = new FileOutputStream(HOwMsK3S);
							long PJKokSRz = Fg0oeNlQ.getCompressedSize(), uN328748 = 0;
							Application.getController().displayVerbose(
									"Length of zip entry " + Fg0oeNlQ.getName() + " is " + PJKokSRz + "b");
							byte[] ByLgGjeD = new byte[16384];
							MessageDigest mb33z54V = MessageDigest.getInstance("SHA-1");
							DigestInputStream jIDyp4UI = new DigestInputStream(aoVTBLto, mb33z54V);
							while ((uN328748 = jIDyp4UI.read(ByLgGjeD)) > 0) {
								if (Thread.currentThread().isInterrupted()) {
									lYOvxuwF.close();
									aoVTBLto.close();
									Application.getController().notifyProgressFinished();
									resetModel(true);
									return;
								}
								lYOvxuwF.write(ByLgGjeD, 0, (int) uN328748);
							}
							lYOvxuwF.close();
							if (Fg0oeNlQ.getComment() != null && Fg0oeNlQ.getComment().length() > 0) {
								if (Arrays.equals(mb33z54V.digest(), new Base64().decode(Fg0oeNlQ.getComment()))) {
									Application.getController().displayVerbose("Hash of " + Fg0oeNlQ.getName() + ": "
											+ new Base64().encodeToString(mb33z54V.digest()));
									Application.getController().displayError("Hash Error",
											"The stored hash of the original file and the hash of the decrypted data do not match. Normally, this means that your data has been manipulated/damaged, but it can also happen if your Java Runtime has a bug in his hash functions.\nIT IS VERY IMPORTANT TO CHECK THE INTEGRITY OF YOUR DECRYPTED DATA!");
								} else {
									Application.getController().displayVerbose(
											"the hash of " + Fg0oeNlQ.getName() + " was verified succesfully");
								}
							}
						}
						if (!wDtPq42l) {
							Application.getController().displayError(bundle.getString("error_no_entries_title"),
									bundle.getString("error_no_entries_text"));
							fRYLIVFX.delete();
						}
						aoVTBLto.close();
						resetModel(false);
					} catch (FileNotFoundException GZjxEGtI) {
						Application.getController().displayError(bundle.getString("error_file_not_exist"),
								GZjxEGtI.getLocalizedMessage());
					} catch (IOException OjJBIlQk) {
						Application.getController().displayError(bundle.getString("error_generic_io"),
								OjJBIlQk.getLocalizedMessage());
					} catch (NoSuchAlgorithmException YvnXnEj2) {
						Application.getController().displayError(bundle.getString("unknown_alg_text"),
								YvnXnEj2.getLocalizedMessage());
					}
				}
				Application.getController().notifyProgressFinished();
				resetModel(true);
			}
		};
		runningThread.start();
	}

}