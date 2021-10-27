class n15461830 {
	private void update() {
		if (VERSION.contains("dev"))
			return;
		System.out.println(updateURL_s);
		try {
			URL mUjl7xtW = new URL(updateURL_s);
			InputStream g9mHuIWQ = mUjl7xtW.openStream();
			InputStreamReader PKkgySjC = new InputStreamReader(g9mHuIWQ);
			BufferedReader qg0C5rdv = new BufferedReader(PKkgySjC);
			String Fw1Qe9Es = qg0C5rdv.readLine();
			if (Fw1Qe9Es.equals("GENREMANUPDATEPAGE")) {
				String atjpfsIm = qg0C5rdv.readLine();
				String NdVXnbUv = qg0C5rdv.readLine();
				if (!atjpfsIm.equals(VERSION)) {
					System.out.println("Update available!");
					int OsiTR9G4 = JOptionPane.showConfirmDialog(this,
							Language.get("UPDATE_AVAILABLE_MSG").replaceAll("%o", VERSION).replaceAll("%c", atjpfsIm),
							Language.get("UPDATE_AVAILABLE_TITLE"), JOptionPane.YES_NO_OPTION);
					if (OsiTR9G4 == 0) {
						URL ObHcdixB = new URL(NdVXnbUv);
						HttpURLConnection NUpDTwVC = (HttpURLConnection) ObHcdixB.openConnection();
						NUpDTwVC.connect();
						if (NUpDTwVC.getResponseCode() / 100 != 2) {
							throw new Exception("Server error! Response code: " + NUpDTwVC.getResponseCode());
						}
						int fJxMVCUm = NUpDTwVC.getContentLength();
						if (fJxMVCUm < 1) {
							throw new Exception("Invalid content length!");
						}
						int gQpAFGnx = fJxMVCUm;
						File Bh8WU0q4 = File.createTempFile("genreman_update", ".zip");
						Bh8WU0q4.deleteOnExit();
						RandomAccessFile mp9UCD96 = new RandomAccessFile(Bh8WU0q4, "rw");
						InputStream fnQLrpSe = NUpDTwVC.getInputStream();
						int BJD2opuV = 0;
						ProgressWindow ee09VH0b = new ProgressWindow(this, "Downloading");
						ee09VH0b.setVisible(true);
						ee09VH0b.setProgress(0);
						ee09VH0b.setText("Connecting...");
						while (BJD2opuV < gQpAFGnx) {
							byte CVAEElfU[];
							if (gQpAFGnx - BJD2opuV > 1024) {
								CVAEElfU = new byte[1024];
							} else {
								CVAEElfU = new byte[gQpAFGnx - BJD2opuV];
							}
							int WnfBzOTi = fnQLrpSe.read(CVAEElfU);
							if (WnfBzOTi == -1)
								break;
							mp9UCD96.write(CVAEElfU, 0, WnfBzOTi);
							BJD2opuV += WnfBzOTi;
							ee09VH0b.setProgress(BJD2opuV / gQpAFGnx);
						}
						mp9UCD96.close();
						System.out.println("Downloaded file to " + Bh8WU0q4.getAbsolutePath());
						ee09VH0b.setVisible(false);
						ee09VH0b.dispose();
						ee09VH0b = null;
						ZipInputStream RiG8PydL = new ZipInputStream(new FileInputStream(Bh8WU0q4));
						ZipEntry nuJge7lq;
						while ((nuJge7lq = RiG8PydL.getNextEntry()) != null) {
							File oUzcQfoj = new File(nuJge7lq.getName());
							System.out.println(oUzcQfoj.getAbsoluteFile());
							if (oUzcQfoj.exists())
								oUzcQfoj.delete();
							OutputStream bL1DxZMc = new FileOutputStream(oUzcQfoj);
							byte[] FV6aB6Np = new byte[1024];
							int BnqrCISk;
							while ((BnqrCISk = RiG8PydL.read(FV6aB6Np)) > 0) {
								bL1DxZMc.write(FV6aB6Np, 0, BnqrCISk);
							}
							bL1DxZMc.close();
						}
						JOptionPane.showMessageDialog(this, Language.get("UPDATE_SUCCESS_MSG"),
								Language.get("UPDATE_SUCCESS_TITLE"), JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
						if (System.getProperty("os.name").indexOf("Windows") != -1) {
							Runtime.getRuntime().exec("iTunesGenreArtManager.exe");
						} else {
							Runtime.getRuntime().exec(
									"java -jar \"iTunes Genre Art Manager.app/Contents/Resources/Java/iTunes_Genre_Art_Manager.jar\"");
						}
						System.exit(0);
					} else {
					}
				}
				qg0C5rdv.close();
				PKkgySjC.close();
				g9mHuIWQ.close();
			} else {
				while (qg0C5rdv.ready()) {
					System.out.println(qg0C5rdv.readLine());
				}
				qg0C5rdv.close();
				PKkgySjC.close();
				g9mHuIWQ.close();
				throw new Exception("Update page had invalid header: " + Fw1Qe9Es);
			}
		} catch (Exception CXVvgeDe) {
			JOptionPane.showMessageDialog(this, Language.get("UPDATE_ERROR_MSG"), Language.get("UPDATE_ERROR_TITLE"),
					JOptionPane.ERROR_MESSAGE);
			CXVvgeDe.printStackTrace();
		}
	}

}