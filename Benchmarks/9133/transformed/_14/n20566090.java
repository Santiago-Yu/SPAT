class n20566090 {
	public void run() {
		if (null == getCommand())
			throw new IllegalArgumentException("Given command is null!");
		if (null == getSocketProvider())
			throw new IllegalArgumentException("Given connection is not open!");
		if (getCommand() instanceof ListCommand) {
			try {
				setReply(ReplyWorker.readReply(getSocketProvider(), true));
				setStatus(ReplyWorker.FINISHED);
			} catch (IOException ioe) {
				setCaughtException(ioe);
				setStatus(ReplyWorker.ERROR_IO_EXCEPTION);
			}
			return;
		} else if (getCommand() instanceof RetrieveCommand) {
			RetrieveCommand retrieveCommand = (RetrieveCommand) getCommand();
			if (Command.TYPE_I == retrieveCommand.getFromFile().getTransferType().intern()
					|| Command.TYPE_A == retrieveCommand.getFromFile().getTransferType().intern()) {
				try {
					log.debug("Download file: " + retrieveCommand.getFromFile().toString());
					FileOutputStream out = null;
					FileChannel channel = null;
					if (RetrieveCommand.FILE_BASED == getDownloadMethod()) {
						out = new FileOutputStream(retrieveCommand.getToFile().getFile());
						channel = out.getChannel();
						if (retrieveCommand.getResumePosition() != -1) {
							try {
								channel.position(retrieveCommand.getResumePosition());
							} catch (IOException ioe) {
								setCaughtException(ioe);
								setStatus(ReplyWorker.ERROR_IO_EXCEPTION);
								try {
									channel.close();
								} catch (IOException ioe2) {
								}
								return;
							}
						}
					} else if (RetrieveCommand.BYTEBUFFER_BASED == getDownloadMethod()) {
					}
					int amount;
					try {
						while ((amount = getSocketProvider().read(buffer)) != -1) {
							if (0 == amount) {
								try {
									Thread.sleep(4);
								} catch (InterruptedException e) {
								}
							}
							buffer.flip();
							while (buffer.hasRemaining()) {
								if (RetrieveCommand.STREAM_BASED == getDownloadMethod()) {
									int rem = buffer.remaining();
									byte[] buf = new byte[rem];
									buffer.get(buf, 0, rem);
									this.outputPipe.write(buf, 0, rem);
								} else if (RetrieveCommand.BYTEBUFFER_BASED == getDownloadMethod()) {
								} else {
									channel.write(buffer);
								}
							}
							buffer.clear();
						}
						buffer.flip();
						while (buffer.hasRemaining()) {
							if (RetrieveCommand.STREAM_BASED == getDownloadMethod()) {
								int rem = buffer.remaining();
								byte[] buf = new byte[rem];
								buffer.get(buf, 0, rem);
								this.outputPipe.write(buf, 0, rem);
							} else if (RetrieveCommand.BYTEBUFFER_BASED == getDownloadMethod()) {
							} else {
								channel.write(buffer);
							}
						}
						buffer.clear();
						setStatus(ReplyWorker.FINISHED);
						if (channel != null)
							channel.close();
						if (this.outputPipe != null)
							this.outputPipe.close();
						getSocketProvider().close();
					} catch (IOException ioe) {
						setCaughtException(ioe);
						setStatus(ReplyWorker.ERROR_IO_EXCEPTION);
					} finally {
						try {
							channel.close();
							getSocketProvider().close();
						} catch (Exception e) {
						}
					}
				} catch (FileNotFoundException fnfe) {
					setCaughtException(fnfe);
					setStatus(ReplyWorker.ERROR_FILE_NOT_FOUND);
				}
			} else
				throw new IllegalArgumentException("Unknown file transfer type for download!");
			return;
		} else if (getCommand() instanceof StoreCommand) {
			StoreCommand storeCommand = (StoreCommand) getCommand();
			if (Command.TYPE_I == storeCommand.getToFile().getTransferType().intern()
					|| Command.TYPE_A == storeCommand.getToFile().getTransferType().intern()) {
				try {
					log.debug("Upload file: " + storeCommand.getFromFile());
					InputStream in = storeCommand.getStream();
					int amount;
					int socketWrite;
					int socketAmount = 0;
					if (in instanceof FileInputStream) {
						FileChannel channel = ((FileInputStream) in).getChannel();
						if (storeCommand.getResumePosition() != -1) {
							try {
								channel.position(storeCommand.getResumePosition());
							} catch (IOException ioe) {
								setCaughtException(ioe);
								setStatus(ReplyWorker.ERROR_IO_EXCEPTION);
								try {
									channel.close();
								} catch (IOException ioe2) {
								}
								return;
							}
						}
						try {
							while ((amount = channel.read(buffer)) != -1) {
								buffer.flip();
								socketWrite = 0;
								while ((socketWrite = getSocketProvider().write(buffer)) != -1) {
									socketAmount += socketWrite;
									if (amount <= socketAmount) {
										break;
									}
									if (0 == socketWrite) {
										try {
											Thread.sleep(4);
										} catch (InterruptedException e) {
										}
									}
								}
								if (-1 == socketWrite) {
									break;
								}
								socketAmount = 0;
								buffer.clear();
							}
							setStatus(ReplyWorker.FINISHED);
							channel.close();
							getSocketProvider().close();
						} catch (IOException ioe) {
							setCaughtException(ioe);
							setStatus(ReplyWorker.ERROR_IO_EXCEPTION);
						} finally {
							try {
								channel.close();
								getSocketProvider().close();
							} catch (Exception e) {
							}
						}
					} else {
						try {
							while ((amount = in.read(buffer.array())) != -1) {
								buffer.flip();
								buffer.limit(amount);
								socketWrite = 0;
								while ((socketWrite = getSocketProvider().write(buffer)) != -1) {
									socketAmount = socketWrite;
									if (amount <= socketAmount) {
										break;
									}
									if (0 == socketWrite) {
										try {
											Thread.sleep(4);
										} catch (InterruptedException e) {
										}
									}
								}
								if (-1 == socketWrite) {
									break;
								}
								socketAmount = 0;
								buffer.clear();
							}
							setStatus(ReplyWorker.FINISHED);
							in.close();
							getSocketProvider().close();
						} catch (IOException ioe) {
							setCaughtException(ioe);
							setStatus(ReplyWorker.ERROR_IO_EXCEPTION);
						} finally {
							try {
								in.close();
								getSocketProvider().close();
							} catch (Exception e) {
							}
						}
					}
				} catch (FileNotFoundException fnfe) {
					setCaughtException(fnfe);
					setStatus(ReplyWorker.ERROR_FILE_NOT_FOUND);
				}
			} else
				throw new IllegalArgumentException("Unknown file transfer type for upload!");
		} else
			throw new IllegalArgumentException("Given command is not supported!");
	}

}