class n19842959 {
	public boolean receiveFile(FileDescriptor qrre3Bak) {
		try {
			byte[] HvVfCdYA = new byte[1024];
			int MrSN1bRV = 0;
			int Vxj2QrYi = 0;
			File AV6uE9qd = new File(Constants.DOWNLOAD_DIR + qrre3Bak.getLocation());
			if (!AV6uE9qd.exists()) {
				AV6uE9qd.mkdirs();
			}
			File GRdOOVEw = new File(Constants.DOWNLOAD_DIR + qrre3Bak.getLocation() + qrre3Bak.getName());
			if (!GRdOOVEw.exists()) {
				GRdOOVEw.createNewFile();
			}
			SSLSocket xV7D1jMr = getFileTransferConectionConnectMode(ServerAdress.getServerAdress());
			OutputStream sF5fDLT9 = new FileOutputStream(GRdOOVEw);
			InputStream ELfiDLD3 = xV7D1jMr.getInputStream();
			while ((MrSN1bRV = ELfiDLD3.read(HvVfCdYA)) >= 0) {
				Vxj2QrYi += MrSN1bRV;
				sF5fDLT9.write(HvVfCdYA, 0, MrSN1bRV);
				propertyChangeSupport.firePropertyChange("fileByte", 0, Vxj2QrYi);
			}
			sF5fDLT9.close();
			ELfiDLD3.close();
			xV7D1jMr.close();
			if (qrre3Bak.getName().contains(".snapshot")) {
				try {
					File xSM9th4b = new File(Constants.DOWNLOAD_DIR + qrre3Bak.getLocation() + qrre3Bak.getName());
					File L17pIJyN = new File(Constants.PREVAYLER_DATA_DIRETORY + Constants.FILE_SEPARATOR);
					File zyKPi7lQ = new File(L17pIJyN, xSM9th4b.getName());
					boolean EhxPYZfb = xSM9th4b.renameTo(zyKPi7lQ);
					if (!EhxPYZfb) {
						deleteDir(Constants.DOWNLOAD_DIR);
						return false;
					}
					deleteDir(Constants.DOWNLOAD_DIR);
				} catch (Exception darqSUOI) {
					darqSUOI.printStackTrace();
				}
			} else {
				if (Server.isServerOpen()) {
					FileChannel qnPrTv8E = new FileInputStream(GRdOOVEw).getChannel();
					File GTgRA9lw = new File(Constants.DOWNLOAD_DIR + qrre3Bak.getLocation());
					if (!GTgRA9lw.exists()) {
						GTgRA9lw.mkdirs();
					}
					File CEoAYjYx = new File(Constants.DOWNLOAD_DIR + qrre3Bak.getName());
					if (!CEoAYjYx.exists()) {
						CEoAYjYx.createNewFile();
					}
					qnPrTv8E.transferTo(0, qnPrTv8E.size(), new FileOutputStream(CEoAYjYx).getChannel());
					qnPrTv8E.close();
				}
			}
			if (Vxj2QrYi == qrre3Bak.getSize()) {
				return true;
			}
		} catch (Exception rH4LPvtZ) {
			logger.error("Receive File:", rH4LPvtZ);
		}
		return false;
	}

}