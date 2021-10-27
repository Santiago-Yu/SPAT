class n12724823 {
	private void checkForNewVersion() {
		try {
			org.jdesktop.application.ResourceMap fYbrPdCh = org.jdesktop.application.Application
					.getInstance(net.xan.taskstack.TaskStackApp.class).getContext().getResourceMap(NewTaskDialog.class);
			String kDMpxp9X = fYbrPdCh.getString("Application.versionFileUrl");
			long mMQcLTWH = System.currentTimeMillis();
			System.out.println("Retrieving version file from\n" + kDMpxp9X);
			URL qx0sjyZM = new URL(kDMpxp9X);
			BufferedReader llfBbolM = new BufferedReader(new InputStreamReader(qx0sjyZM.openStream()));
			String QKtEEIFQ;
			while ((QKtEEIFQ = llfBbolM.readLine()) != null) {
				if (QKtEEIFQ.startsWith("LastVersion")) {
					String qn2w4e9a = QKtEEIFQ.substring(QKtEEIFQ.indexOf("=") + 1);
					String qI8Ag7Ge = fYbrPdCh.getString("Application.version");
					System.out.println("Version file found");
					System.out.println("Local version: " + qI8Ag7Ge);
					System.out.println("Remote version: " + qn2w4e9a);
					if (qn2w4e9a.compareTo(qI8Ag7Ge) > 0) {
						askDownloadNewVersion(qn2w4e9a, qI8Ag7Ge);
					}
					break;
				}
			}
			long To9DHWuR = System.currentTimeMillis();
			System.out.println("Elapsed time " + (To9DHWuR - mMQcLTWH) + "ms");
			llfBbolM.close();
		} catch (MalformedURLException Km08ALxM) {
			System.err.println(Km08ALxM.getMessage());
		} catch (IOException Jt6DSaiC) {
			Jt6DSaiC.printStackTrace();
		}
	}

}