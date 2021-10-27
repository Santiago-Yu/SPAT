class n17681309 {
	public static void main(String[] TOPxtqtI) {
		Dialog mhvmScpp = new Dialog();
		try {
			if (TOPxtqtI.length != 5) {
				throw new InvalidParameterException(
						"\n\nInvalid nunmber of parameters.\n\nCall must be \"java  -jar  Updater.jar  PATH_TO_MANAGER.JAR  CURRENT_MANAGER_VERSION  VERIONS.TXT_CONTROL_FILE  ROOT_WEBSERVER_FOLDER  LOCAL_TEMPORARY_FOLDER\"");
			}
			File t8UOF2px = new File(TOPxtqtI[0]);
			if (!t8UOF2px.exists()) {
				throw new FileNotFoundException(TOPxtqtI[0]);
			}
			mhvmScpp.updateLabel("Calculating files");
			URL NjkUsDtz = new URL(TOPxtqtI[2]);
			URLConnection VLAGkAek = NjkUsDtz.openConnection();
			VLAGkAek.setConnectTimeout(10000);
			BufferedReader myWfIxQ6 = new BufferedReader(new InputStreamReader(VLAGkAek.getInputStream()));
			ArrayList<String> ZvbKRQ4s = new ArrayList<String>();
			while (myWfIxQ6.ready()) {
				ZvbKRQ4s.add(myWfIxQ6.readLine());
			}
			myWfIxQ6.close();
			int I39KSPdd = ZvbKRQ4s.indexOf(TOPxtqtI[1]);
			String c6WKSEJh = TOPxtqtI[3];
			if (!c6WKSEJh.endsWith("/")) {
				c6WKSEJh += "/";
			}
			if (I39KSPdd != -1) {
				ArrayList<File> w8IZjDa9 = new ArrayList<File>();
				int EWELEv30 = 0;
				for (int knATtizd = I39KSPdd - 1; knATtizd >= 0; knATtizd--) {
					mhvmScpp.updateLabel("Connecting " + ++EWELEv30 + "/" + I39KSPdd + " files");
					URL hPPFhesN = new URL(c6WKSEJh + ZvbKRQ4s.get(knATtizd).replaceAll(" ", "%20") + ".jar");
					URLConnection g6Wxy9MU = hPPFhesN.openConnection();
					g6Wxy9MU.setConnectTimeout(10000);
					mhvmScpp.progressBar.setValue(0);
					mhvmScpp.progressBar.setMaximum(g6Wxy9MU.getContentLength());
					File rb1NDmZ6 = new File(TOPxtqtI[4] + File.separator + ZvbKRQ4s.get(knATtizd) + ".jar");
					InputStream rY3QE3bm = g6Wxy9MU.getInputStream();
					FileOutputStream SgMBEIxF = new FileOutputStream(rb1NDmZ6, false);
					mhvmScpp.updateLabel("Downloading " + knATtizd + "/" + I39KSPdd + " files");
					copyInputStream(rY3QE3bm, SgMBEIxF, mhvmScpp.progressBar);
					rY3QE3bm.close();
					SgMBEIxF.close();
					w8IZjDa9.add(rb1NDmZ6);
				}
				Iterator<File> p8OKyq6T = w8IZjDa9.iterator();
				EWELEv30 = 0;
				while (p8OKyq6T.hasNext()) {
					mhvmScpp.updateLabel("Applying " + ++EWELEv30 + "/" + w8IZjDa9.size() + " files");
					File jlya3NLC = p8OKyq6T.next();
					mhvmScpp.progressBar.setValue(0);
					FileInputStream WRCxDiSv = new FileInputStream(jlya3NLC);
					mhvmScpp.progressBar.setMaximum(WRCxDiSv.available());
					WRCxDiSv.close();
					putDifsInJar(t8UOF2px, jlya3NLC, mhvmScpp.progressBar);
				}
			} else {
				mhvmScpp.updateLabel("Connecting");
				URL hwkG6CYG = new URL(c6WKSEJh + "Manager.jar");
				URLConnection AkPs3Bst = hwkG6CYG.openConnection();
				AkPs3Bst.setConnectTimeout(10000);
				mhvmScpp.progressBar.setValue(0);
				mhvmScpp.progressBar.setMaximum(AkPs3Bst.getContentLength());
				File utTF7aDB = new File(TOPxtqtI[4] + File.separator + "Manager.jar");
				InputStream tHWwJyik = AkPs3Bst.getInputStream();
				OutputStream bZZP5Ik3 = new FileOutputStream(utTF7aDB);
				mhvmScpp.updateLabel("Downloading ");
				copyInputStream(tHWwJyik, bZZP5Ik3, mhvmScpp.progressBar);
				tHWwJyik.close();
				bZZP5Ik3.close();
				FileInputStream XcVnSEyX = new FileInputStream(utTF7aDB);
				FileOutputStream wYtg7eK8 = new FileOutputStream(t8UOF2px);
				copyInputStream(tHWwJyik, bZZP5Ik3, null);
				tHWwJyik.close();
				bZZP5Ik3.close();
			}
			mhvmScpp.updateLabel("Finishing");
			Process GYLMLpHh = Runtime.getRuntime().exec("java -jar " + t8UOF2px.getAbsolutePath());
			System.exit(0);
		} catch (Exception VK9Vulj6) {
			mhvmScpp.updateLabel("Closing...");
			JOptionPane.showMessageDialog(null, "Failed to update manager\n\n" + VK9Vulj6.toString(), "Update failed",
					JOptionPane.ERROR_MESSAGE);
			long XUdwXqdG, DIdkVE0T;
			XUdwXqdG = System.currentTimeMillis();
			do {
				DIdkVE0T = System.currentTimeMillis();
			} while ((DIdkVE0T - XUdwXqdG) < (1 * 1500));
			System.exit(0);
		}
	}

}