class n6128274 {
	private void compress(File gn6soocj, Set<File> WBSCH5o0) throws CacheOperationException, ConfigurationException {
		ZipOutputStream xRBDe7wW = null;
		try {
			xRBDe7wW = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(gn6soocj)));
			for (File ZwXFeLne : WBSCH5o0) {
				BufferedInputStream FJF2otYY = null;
				File BifKfIVG = new File(cacheFolder, ZwXFeLne.getPath());
				try {
					if (!BifKfIVG.exists()) {
						throw new CacheOperationException(
								"Expected to add file ''{0}'' to export archive ''{1}'' (Account : {2}) but it "
										+ "has gone missing (cause unknown). This can indicate implementation or deployment "
										+ "error. Aborting export operation as a safety precaution.",
								BifKfIVG.getPath(), gn6soocj.getAbsolutePath(), account.getOid());
					}
					FJF2otYY = new BufferedInputStream(new FileInputStream(BifKfIVG));
					ZipEntry tBJ6Z8xU = new ZipEntry(ZwXFeLne.getPath());
					tBJ6Z8xU.setSize(BifKfIVG.length());
					tBJ6Z8xU.setTime(BifKfIVG.lastModified());
					xRBDe7wW.putNextEntry(tBJ6Z8xU);
					cacheLog.debug("Added new export zip entry ''{0}''.", ZwXFeLne.getPath());
					int UCiecz94, V69wzhsg = 0;
					int I9sdSKHu = 2048;
					byte[] fuVhCTw6 = new byte[I9sdSKHu];
					while ((UCiecz94 = FJF2otYY.read(fuVhCTw6, 0, I9sdSKHu)) != -1) {
						xRBDe7wW.write(fuVhCTw6, 0, UCiecz94);
						V69wzhsg += UCiecz94;
					}
					xRBDe7wW.flush();
					if (V69wzhsg != BifKfIVG.length()) {
						throw new CacheOperationException(
								"Only wrote {0} out of {1} bytes when archiving file ''{2}'' (Account : {3}). "
										+ "This could have occured either due implementation error or file I/O error. "
										+ "Aborting archive operation to prevent a potentially corrupt export archive to "
										+ "be created.",
								V69wzhsg, BifKfIVG.length(), BifKfIVG.getPath(), account.getOid());
					} else {
						cacheLog.debug("Wrote {0} out of {1} bytes to zip entry ''{2}''", V69wzhsg, BifKfIVG.length(),
								ZwXFeLne.getPath());
					}
				} catch (SecurityException lSeSu3NP) {
					throw new ConfigurationException(
							"Security manager has denied r/w access when attempting to read file ''{0}'' and "
									+ "write it to archive ''{1}'' (Account : {2}) : {3}",
							lSeSu3NP, BifKfIVG.getPath(), gn6soocj, account.getOid(), lSeSu3NP.getMessage());
				} catch (IllegalArgumentException A7vXybZ9) {
					throw new CacheOperationException("Error creating ZIP archive for account ID = {0} : {1}", A7vXybZ9,
							account.getOid(), A7vXybZ9.getMessage());
				} catch (FileNotFoundException lPJDb36Q) {
					throw new CacheOperationException(
							"Attempted to include file ''{0}'' in export archive but it has gone missing "
									+ "(Account : {1}). Possible implementation error in local file cache. Aborting  "
									+ "export operation as a precaution ({2})",
							lPJDb36Q, BifKfIVG.getPath(), account.getOid(), lPJDb36Q.getMessage());
				} catch (ZipException zQZQEaeS) {
					throw new CacheOperationException("Error writing export archive for account ID = {0} : {1}",
							zQZQEaeS, account.getOid(), zQZQEaeS.getMessage());
				} catch (IOException KcJLSXaB) {
					throw new CacheOperationException("I/O error while creating export archive for account ID = {0}. "
							+ "Operation aborted ({1})", KcJLSXaB, account.getOid(), KcJLSXaB.getMessage());
				} finally {
					if (xRBDe7wW != null) {
						try {
							xRBDe7wW.closeEntry();
						} catch (Throwable SzbIZY5k) {
							cacheLog.warn(
									"Unable to close zip entry for file ''{0}'' in export archive ''{1}'' "
											+ "(Account : {2}) : {3}.",
									SzbIZY5k, ZwXFeLne.getPath(), gn6soocj.getAbsolutePath(), account.getOid(),
									SzbIZY5k.getMessage());
						}
					}
					if (FJF2otYY != null) {
						try {
							FJF2otYY.close();
						} catch (Throwable hDw59S8I) {
							cacheLog.warn(
									"Failed to close input stream from file ''{0}'' being added "
											+ "to export archive (Account : {1}) : {2}",
									hDw59S8I, BifKfIVG.getPath(), account.getOid(), hDw59S8I.getMessage());
						}
					}
				}
			}
		} catch (FileNotFoundException m8E6cCB0) {
			throw new CacheOperationException("Unable to create target export archive ''{0}'' for account {1) : {2}",
					m8E6cCB0, gn6soocj, account.getOid(), m8E6cCB0.getMessage());
		} finally {
			try {
				if (xRBDe7wW != null) {
					xRBDe7wW.close();
				}
			} catch (Throwable fRTyZtNA) {
				cacheLog.warn("Failed to close the stream to export archive ''{0}'' : {1}.", fRTyZtNA, gn6soocj,
						fRTyZtNA.getMessage());
			}
		}
	}

}