class n1502583 {
	@Override
	protected IStatus run(final IProgressMonitor LV8fKVDm) {
		try {
			showTileInfo(remoteFileName, -1);
			System.out.println("   connect " + host);
			ftp.connect();
			showTileInfo(remoteFileName, -2);
			System.out.println("   login " + user + " " + password);
			ftp.login(user, password);
			System.out.println("   set passive mode");
			ftp.setConnectMode(FTPConnectMode.PASV);
			System.out.println("   set type binary");
			ftp.setType(FTPTransferType.BINARY);
			showTileInfo(remoteFileName, -3);
			System.out.println("   chdir " + remoteFilePath);
			ftp.chdir(remoteFilePath);
			ftp.setProgressMonitor(new FTPProgressMonitor() {

				public void bytesTransferred(final long PHG2cMvs) {
					tileInfoMgr.updateSRTMTileInfo(TileEventId.SRTM_DATA_LOADING_MONITOR, remoteFileName, PHG2cMvs);
				}
			});
			showTileInfo(remoteFileName, -4);
			System.out.println("   get " + remoteFileName + " -> " + localName + " ...");
			ftp.get(localName, remoteFileName);
			System.out.println("   quit");
			ftp.quit();
		} catch (final UnknownHostException faohpbIc) {
			return new Status(IStatus.ERROR, TourbookPlugin.PLUGIN_ID, IStatus.ERROR,
					NLS.bind(Messages.error_message_cannotConnectToServer, host), faohpbIc);
		} catch (final SocketTimeoutException aIrRl8U3) {
			return new Status(IStatus.ERROR, TourbookPlugin.PLUGIN_ID, IStatus.ERROR,
					NLS.bind(Messages.error_message_timeoutWhenConnectingToServer, host), aIrRl8U3);
		} catch (final Exception SHN2YTuj) {
			SHN2YTuj.printStackTrace();
			tileInfoMgr.updateSRTMTileInfo(TileEventId.SRTM_DATA_ERROR_LOADING, remoteFileName, 0);
		} finally {
			tileInfoMgr.updateSRTMTileInfo(TileEventId.SRTM_DATA_END_LOADING, remoteFileName, 0);
		}
		return Status.OK_STATUS;
	}

}