class n4166046 {
	public void viewFile(int wjBzMPea) {
		FTPClient bWsUqUxq = new FTPClient();
		boolean QoDnstD0 = false;
		try {
			int tzUkamnw;
			bWsUqUxq.connect("tgftp.nws.noaa.gov");
			bWsUqUxq.login("anonymous", "");
			Log.d("WXDroid", "Connected to tgftp.nws.noaa.gov.");
			Log.d("WXDroid", bWsUqUxq.getReplyString());
			tzUkamnw = bWsUqUxq.getReplyCode();
			if (!FTPReply.isPositiveCompletion(tzUkamnw)) {
				bWsUqUxq.disconnect();
				System.err.println("FTP server refused connection.");
				System.exit(1);
			}
			bWsUqUxq.changeWorkingDirectory("fax");
			Log.d("WXDroid", "working directory: " + bWsUqUxq.printWorkingDirectory());
			bWsUqUxq.setFileType(FTPClient.BINARY_FILE_TYPE);
			InputStream CXFdSKBM = bWsUqUxq.retrieveFileStream("PYAA10.gif");
			String bpub5rKw = Environment.getExternalStorageState();
			if (bpub5rKw.contains("mounted")) {
				String iICKnhxh = Environment.getExternalStorageDirectory().getAbsolutePath() + "/NOAAWX/";
				File g4kg49pU = new File(iICKnhxh);
				File hAkrAoFc = new File(iICKnhxh + "PYAA10.gif");
				OutputStream LrA9GLQg = new FileOutputStream(hAkrAoFc);
				byte[] BDAe8nbT = new byte[1024];
				int sWw0r0ZA;
				while ((sWw0r0ZA = CXFdSKBM.read(BDAe8nbT)) != -1) {
					if (Thread.interrupted() == true) {
						String VMrVJFBG = Thread.currentThread().getStackTrace()[2].getMethodName() + "()";
						throw new InterruptedException("The function " + VMrVJFBG + " was interrupted.");
					}
					LrA9GLQg.write(BDAe8nbT, 0, sWw0r0ZA);
				}
				wxDroid.showImage();
				LrA9GLQg.flush();
				LrA9GLQg.close();
				CXFdSKBM.close();
				Log.d("WXDroid", "file saved: " + iICKnhxh + " " + hAkrAoFc);
			} else {
				Log.d("WXDroid", "The SD card is not mounted");
			}
			bWsUqUxq.logout();
			bWsUqUxq.disconnect();
		} catch (IOException fO90wed9) {
			QoDnstD0 = true;
			fO90wed9.printStackTrace();
		} catch (InterruptedException OBvCgz1J) {
			OBvCgz1J.printStackTrace();
		} finally {
			if (bWsUqUxq.isConnected()) {
				try {
					bWsUqUxq.disconnect();
				} catch (IOException mfJJK4t5) {
				}
			}
		}
	}

}