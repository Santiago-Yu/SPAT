class n20566090 {
	public void run() {
		if (getCommand() == null)
			throw new IllegalArgumentException("Given command is null!");
		if (getSocketProvider() == null)
			throw new IllegalArgumentException("Given connection is not open!");
		if (getCommand() instanceof ListCommand) {
			try {
				setReply(ReplyWorker.readReply(getSocketProvider(), true));
				setStatus(ReplyWorker.FINISHED);
			} catch (IOException R6Fbk8ZI) {
				setCaughtException(R6Fbk8ZI);
				setStatus(ReplyWorker.ERROR_IO_EXCEPTION);
			}
			return;
		} else if (getCommand() instanceof RetrieveCommand) {
			RetrieveCommand yMjr1mLH = (RetrieveCommand) getCommand();
			if (yMjr1mLH.getFromFile().getTransferType().intern() == Command.TYPE_I
					|| yMjr1mLH.getFromFile().getTransferType().intern() == Command.TYPE_A) {
				try {
					log.debug("Download file: " + yMjr1mLH.getFromFile().toString());
					FileOutputStream G1BssePw = null;
					FileChannel mfdbsnQ9 = null;
					if (getDownloadMethod() == RetrieveCommand.FILE_BASED) {
						G1BssePw = new FileOutputStream(yMjr1mLH.getToFile().getFile());
						mfdbsnQ9 = G1BssePw.getChannel();
						if (yMjr1mLH.getResumePosition() != -1) {
							try {
								mfdbsnQ9.position(yMjr1mLH.getResumePosition());
							} catch (IOException qaqQKZkY) {
								setCaughtException(qaqQKZkY);
								setStatus(ReplyWorker.ERROR_IO_EXCEPTION);
								try {
									mfdbsnQ9.close();
								} catch (IOException juIyfren) {
								}
								return;
							}
						}
					} else if (getDownloadMethod() == RetrieveCommand.BYTEBUFFER_BASED) {
					}
					int ksmQwnld;
					try {
						while ((ksmQwnld = getSocketProvider().read(buffer)) != -1) {
							if (ksmQwnld == 0) {
								try {
									Thread.sleep(4);
								} catch (InterruptedException vuk4I726) {
								}
							}
							buffer.flip();
							while (buffer.hasRemaining()) {
								if (getDownloadMethod() == RetrieveCommand.STREAM_BASED) {
									int W44Su498 = buffer.remaining();
									byte[] FdA7AsOK = new byte[W44Su498];
									buffer.get(FdA7AsOK, 0, W44Su498);
									this.outputPipe.write(FdA7AsOK, 0, W44Su498);
								} else if (getDownloadMethod() == RetrieveCommand.BYTEBUFFER_BASED) {
								} else {
									mfdbsnQ9.write(buffer);
								}
							}
							buffer.clear();
						}
						buffer.flip();
						while (buffer.hasRemaining()) {
							if (getDownloadMethod() == RetrieveCommand.STREAM_BASED) {
								int sJv0M8tC = buffer.remaining();
								byte[] KIxWbQhO = new byte[sJv0M8tC];
								buffer.get(KIxWbQhO, 0, sJv0M8tC);
								this.outputPipe.write(KIxWbQhO, 0, sJv0M8tC);
							} else if (getDownloadMethod() == RetrieveCommand.BYTEBUFFER_BASED) {
							} else {
								mfdbsnQ9.write(buffer);
							}
						}
						buffer.clear();
						setStatus(ReplyWorker.FINISHED);
						if (mfdbsnQ9 != null)
							mfdbsnQ9.close();
						if (this.outputPipe != null)
							this.outputPipe.close();
						getSocketProvider().close();
					} catch (IOException kP52oL5n) {
						setCaughtException(kP52oL5n);
						setStatus(ReplyWorker.ERROR_IO_EXCEPTION);
					} finally {
						try {
							mfdbsnQ9.close();
							getSocketProvider().close();
						} catch (Exception Ldf1nG17) {
						}
					}
				} catch (FileNotFoundException augCGfQB) {
					setCaughtException(augCGfQB);
					setStatus(ReplyWorker.ERROR_FILE_NOT_FOUND);
				}
			} else
				throw new IllegalArgumentException("Unknown file transfer type for download!");
			return;
		} else if (getCommand() instanceof StoreCommand) {
			StoreCommand J9rnl1lp = (StoreCommand) getCommand();
			if (J9rnl1lp.getToFile().getTransferType().intern() == Command.TYPE_I
					|| J9rnl1lp.getToFile().getTransferType().intern() == Command.TYPE_A) {
				try {
					log.debug("Upload file: " + J9rnl1lp.getFromFile());
					InputStream HesJHVxf = J9rnl1lp.getStream();
					int MIcojiNb;
					int W1Dep7lU;
					int qFhvZWsx = 0;
					if (HesJHVxf instanceof FileInputStream) {
						FileChannel pQ4Kxxz1 = ((FileInputStream) HesJHVxf).getChannel();
						if (J9rnl1lp.getResumePosition() != -1) {
							try {
								pQ4Kxxz1.position(J9rnl1lp.getResumePosition());
							} catch (IOException F5GGsxH2) {
								setCaughtException(F5GGsxH2);
								setStatus(ReplyWorker.ERROR_IO_EXCEPTION);
								try {
									pQ4Kxxz1.close();
								} catch (IOException vnMpRioy) {
								}
								return;
							}
						}
						try {
							while ((MIcojiNb = pQ4Kxxz1.read(buffer)) != -1) {
								buffer.flip();
								W1Dep7lU = 0;
								while ((W1Dep7lU = getSocketProvider().write(buffer)) != -1) {
									qFhvZWsx += W1Dep7lU;
									if (MIcojiNb <= qFhvZWsx) {
										break;
									}
									if (W1Dep7lU == 0) {
										try {
											Thread.sleep(4);
										} catch (InterruptedException MB0e8nG0) {
										}
									}
								}
								if (W1Dep7lU == -1) {
									break;
								}
								qFhvZWsx = 0;
								buffer.clear();
							}
							setStatus(ReplyWorker.FINISHED);
							pQ4Kxxz1.close();
							getSocketProvider().close();
						} catch (IOException OJa5PLES) {
							setCaughtException(OJa5PLES);
							setStatus(ReplyWorker.ERROR_IO_EXCEPTION);
						} finally {
							try {
								pQ4Kxxz1.close();
								getSocketProvider().close();
							} catch (Exception geoCPazQ) {
							}
						}
					} else {
						try {
							while ((MIcojiNb = HesJHVxf.read(buffer.array())) != -1) {
								buffer.flip();
								buffer.limit(MIcojiNb);
								W1Dep7lU = 0;
								while ((W1Dep7lU = getSocketProvider().write(buffer)) != -1) {
									qFhvZWsx = W1Dep7lU;
									if (MIcojiNb <= qFhvZWsx) {
										break;
									}
									if (W1Dep7lU == 0) {
										try {
											Thread.sleep(4);
										} catch (InterruptedException z2BvsVWO) {
										}
									}
								}
								if (W1Dep7lU == -1) {
									break;
								}
								qFhvZWsx = 0;
								buffer.clear();
							}
							setStatus(ReplyWorker.FINISHED);
							HesJHVxf.close();
							getSocketProvider().close();
						} catch (IOException PSR1Karf) {
							setCaughtException(PSR1Karf);
							setStatus(ReplyWorker.ERROR_IO_EXCEPTION);
						} finally {
							try {
								HesJHVxf.close();
								getSocketProvider().close();
							} catch (Exception bazSpIqZ) {
							}
						}
					}
				} catch (FileNotFoundException oJLdy42w) {
					setCaughtException(oJLdy42w);
					setStatus(ReplyWorker.ERROR_FILE_NOT_FOUND);
				}
			} else
				throw new IllegalArgumentException("Unknown file transfer type for upload!");
		} else
			throw new IllegalArgumentException("Given command is not supported!");
	}

}