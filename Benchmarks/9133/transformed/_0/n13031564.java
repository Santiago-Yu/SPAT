class n13031564 {
	public void viewFile(int YpDxHrwh) {
		FTPClient sV3f3d3V = new FTPClient();
		boolean YpDbCs4C = false;
		try {
			int HduRVaFA;
			sV3f3d3V.connect("tgftp.nws.noaa.gov");
			sV3f3d3V.login("anonymous", "");
			Log.d("WXDroid", "Connected to tgftp.nws.noaa.gov.");
			Log.d("WXDroid", sV3f3d3V.getReplyString());
			HduRVaFA = sV3f3d3V.getReplyCode();
			if (!FTPReply.isPositiveCompletion(HduRVaFA)) {
				sV3f3d3V.disconnect();
				System.err.println("FTP server refused connection.");
				System.exit(1);
			}
			sV3f3d3V.changeWorkingDirectory("fax");
			Log.d("WXDroid", "working directory: " + sV3f3d3V.printWorkingDirectory());
			sV3f3d3V.setFileType(FTPClient.BINARY_FILE_TYPE);
			InputStream IFuz8mRL = sV3f3d3V.retrieveFileStream("PYAA10.gif");
			Intent jh4YLqsd = new Intent();
			jh4YLqsd.setClass(WXdroid.this, showProgressFTP.class);
			startActivity(jh4YLqsd);
			String h9uzUfHr = Environment.getExternalStorageState();
			if (h9uzUfHr.contains("mounted")) {
				String txTiwQS0 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/NOAAWX/";
				File MXwgS1Bg = new File(txTiwQS0);
				File znlioyhg = new File(txTiwQS0 + "PYAA10.gif");
				OutputStream xHZlQxr0 = new FileOutputStream(znlioyhg);
				byte[] mOlTdz7n = new byte[1024];
				int sn83DSJa;
				while ((sn83DSJa = IFuz8mRL.read(mOlTdz7n)) != -1) {
					if (Thread.interrupted() == true) {
						String WRtuV39x = Thread.currentThread().getStackTrace()[2].getMethodName() + "()";
						throw new InterruptedException("The function " + WRtuV39x + " was interrupted.");
					}
					xHZlQxr0.write(mOlTdz7n, 0, sn83DSJa);
				}
				showImage();
				xHZlQxr0.flush();
				xHZlQxr0.close();
				IFuz8mRL.close();
				Log.d("WXDroid", "file saved: " + txTiwQS0 + " " + znlioyhg);
			} else {
				Log.d("WXDroid", "The SD card is not mounted");
			}
			sV3f3d3V.logout();
			sV3f3d3V.disconnect();
		} catch (IOException CI5vBgMs) {
			YpDbCs4C = true;
			CI5vBgMs.printStackTrace();
		} catch (InterruptedException S3ARecpt) {
			S3ARecpt.printStackTrace();
		} finally {
			if (sV3f3d3V.isConnected()) {
				try {
					sV3f3d3V.disconnect();
				} catch (IOException GEZMA2EG) {
				}
			}
		}
	}

}