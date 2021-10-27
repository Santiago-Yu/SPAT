class n1502582 {
	public void get(final String PFUzmPVp, final String mHQtiK1B, final String E1xR5sl8) {
		final FTPClient Rs47MB81 = new FTPClient();
		final FTPMessageCollector hdU88QDi = new FTPMessageCollector();
		try {
			final String WwbqMQQE = E1xR5sl8.substring(0, E1xR5sl8.lastIndexOf(File.separator));
			System.out.println("ftp:");
			System.out.println("   remoteDir " + PFUzmPVp);
			System.out.println("   localDir " + WwbqMQQE);
			final File bYgYeHtl = new File(WwbqMQQE);
			if (!bYgYeHtl.exists()) {
				System.out.println("   create Dir " + WwbqMQQE);
				bYgYeHtl.mkdir();
			}
			Rs47MB81.setTimeout(10000);
			Rs47MB81.setRemoteHost(host);
			Rs47MB81.setMessageListener(hdU88QDi);
		} catch (final UnknownHostException tSvSc5Cw) {
			showConnectError();
			return;
		} catch (final Exception pYvWjqKG) {
			pYvWjqKG.printStackTrace();
		}
		final TileInfoManager uVCntKmu = TileInfoManager.getInstance();
		final Job AQc29d7o = new Job(Messages.job_name_ftpDownload) {

			@Override
			protected IStatus run(final IProgressMonitor AdzIM4ne) {
				try {
					showTileInfo(mHQtiK1B, -1);
					System.out.println("   connect " + host);
					Rs47MB81.connect();
					showTileInfo(mHQtiK1B, -2);
					System.out.println("   login " + user + " " + password);
					Rs47MB81.login(user, password);
					System.out.println("   set passive mode");
					Rs47MB81.setConnectMode(FTPConnectMode.PASV);
					System.out.println("   set type binary");
					Rs47MB81.setType(FTPTransferType.BINARY);
					showTileInfo(mHQtiK1B, -3);
					System.out.println("   chdir " + PFUzmPVp);
					Rs47MB81.chdir(PFUzmPVp);
					Rs47MB81.setProgressMonitor(new FTPProgressMonitor() {

						public void bytesTransferred(final long pQz0esbC) {
							uVCntKmu.updateSRTMTileInfo(TileEventId.SRTM_DATA_LOADING_MONITOR, mHQtiK1B, pQz0esbC);
						}
					});
					showTileInfo(mHQtiK1B, -4);
					System.out.println("   get " + mHQtiK1B + " -> " + E1xR5sl8 + " ...");
					Rs47MB81.get(E1xR5sl8, mHQtiK1B);
					System.out.println("   quit");
					Rs47MB81.quit();
				} catch (final UnknownHostException u0yMOFVQ) {
					return new Status(IStatus.ERROR, TourbookPlugin.PLUGIN_ID, IStatus.ERROR,
							NLS.bind(Messages.error_message_cannotConnectToServer, host), u0yMOFVQ);
				} catch (final SocketTimeoutException dIzIDuPp) {
					return new Status(IStatus.ERROR, TourbookPlugin.PLUGIN_ID, IStatus.ERROR,
							NLS.bind(Messages.error_message_timeoutWhenConnectingToServer, host), dIzIDuPp);
				} catch (final Exception E521wp7j) {
					E521wp7j.printStackTrace();
					uVCntKmu.updateSRTMTileInfo(TileEventId.SRTM_DATA_ERROR_LOADING, mHQtiK1B, 0);
				} finally {
					uVCntKmu.updateSRTMTileInfo(TileEventId.SRTM_DATA_END_LOADING, mHQtiK1B, 0);
				}
				return Status.OK_STATUS;
			}
		};
		AQc29d7o.schedule();
		try {
			AQc29d7o.join();
		} catch (final InterruptedException H3Mu5c9H) {
			H3Mu5c9H.printStackTrace();
		}
	}

}