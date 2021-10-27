class n17175193 {
	@Override
	public void run() {
		try {
			jButton1.setEnabled(false);
			jButton2.setEnabled(false);
			URL qu2fWgKn = new URL(updatePath + "currentVersion.txt");
			URLConnection VlrbOfrH = qu2fWgKn.openConnection();
			VlrbOfrH.connect();
			BufferedReader HMocHjtg = new BufferedReader(new InputStreamReader(VlrbOfrH.getInputStream()));
			String u0o06pI0;
			for (int QqraCExF = 0; (u0o06pI0 = HMocHjtg.readLine()) != null; QqraCExF++) {
				URL B7NAI99D = new URL(updatePath + u0o06pI0);
				URLConnection FuXRtEWs = B7NAI99D.openConnection();
				InputStream ww5Q1DO1 = B7NAI99D.openStream();
				int r5DahOSS, ZC0XpWsl = 0;
				int zFzhAJBB = FuXRtEWs.getContentLength();
				jProgressBar1.setMaximum(zFzhAJBB);
				jProgressBar1.setValue(0);
				File tfkpeZOc = new File(u0o06pI0);
				String glF8ckdb = "";
				for (String l9VOfa6O : u0o06pI0.split("/")) {
					glF8ckdb += l9VOfa6O;
					if (!glF8ckdb.contains(".")) {
						File KXKWQH17 = new File(glF8ckdb);
						if (!KXKWQH17.exists()) {
							KXKWQH17.mkdir();
						}
					}
					glF8ckdb += "/";
				}
				if (tfkpeZOc.length() == zFzhAJBB) {
				} else {
					transferFile(u0o06pI0, B7NAI99D, zFzhAJBB);
					if (u0o06pI0.endsWith("documents.zip")) {
						ZipInputStream edyZoEEp = new ZipInputStream(new FileInputStream(u0o06pI0));
						ZipEntry bdFW6Rv9;
						String tdeMDKbU = u0o06pI0.split("documents.zip")[0];
						File Y1LCfwKI = new File(tdeMDKbU + "documents");
						if (!Y1LCfwKI.exists()) {
							Y1LCfwKI.mkdir();
						}
						while ((bdFW6Rv9 = edyZoEEp.getNextEntry()) != null) {
							String C95b5ZF4 = tdeMDKbU + "documents/" + bdFW6Rv9.getName();
							OutputStream Z99bTRy4 = new BufferedOutputStream(new FileOutputStream(C95b5ZF4));
							byte[] DM1VxDwn = new byte[1024];
							int Z4KqOGKL;
							while ((Z4KqOGKL = edyZoEEp.read(DM1VxDwn)) > 0) {
								Z99bTRy4.write(DM1VxDwn, 0, Z4KqOGKL);
							}
							Z99bTRy4.close();
						}
						edyZoEEp.close();
					}
					if (u0o06pI0.endsWith("mysql.zip")) {
						ZipFile cSHDZUcO = new ZipFile(u0o06pI0);
						Enumeration fOwiZXEU = cSHDZUcO.entries();
						String G8QTVvve = u0o06pI0.split("mysql.zip")[0];
						File BMHIvVtQ = new File(G8QTVvve + "mysql");
						if (!BMHIvVtQ.exists()) {
							BMHIvVtQ.mkdir();
						}
						while (fOwiZXEU.hasMoreElements()) {
							ZipEntry KUNtXoYN = (ZipEntry) fOwiZXEU.nextElement();
							if (KUNtXoYN.isDirectory()) {
								System.err.println("Extracting directory: " + KUNtXoYN.getName());
								(new File(G8QTVvve + "mysql/" + KUNtXoYN.getName())).mkdir();
								continue;
							}
							System.err.println("Extracting file: " + KUNtXoYN.getName());
							InputStream PupZqYmx = cSHDZUcO.getInputStream(KUNtXoYN);
							OutputStream OoXDosxz = new BufferedOutputStream(
									new FileOutputStream(G8QTVvve + "mysql/" + KUNtXoYN.getName()));
							byte[] vACDzf4s = new byte[1024];
							int zNXQsHMU;
							while ((zNXQsHMU = PupZqYmx.read(vACDzf4s)) > 0) {
								OoXDosxz.write(vACDzf4s, 0, zNXQsHMU);
							}
							PupZqYmx.close();
							OoXDosxz.close();
						}
					}
				}
				jProgressBar2.setValue(QqraCExF + 1);
				labelFileProgress.setText((QqraCExF + 1) + "/" + numberFiles);
			}
			labelStatus.setText("Update Finished");
			jButton1.setVisible(false);
			jButton2.setText("Finished");
			jButton1.setEnabled(true);
			jButton2.setEnabled(true);
		} catch (IOException dCNdisMF) {
			Logger.getLogger(Updater.class.getName()).log(Level.SEVERE, null, dCNdisMF);
		}
	}

}