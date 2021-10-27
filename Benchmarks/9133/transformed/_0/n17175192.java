class n17175192 {
	public void update() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					jButton1.setEnabled(false);
					jButton2.setEnabled(false);
					URL yfaLbcz5 = new URL(updatePath + "currentVersion.txt");
					URLConnection ssVwG6d2 = yfaLbcz5.openConnection();
					ssVwG6d2.connect();
					BufferedReader PB5LIIih = new BufferedReader(new InputStreamReader(ssVwG6d2.getInputStream()));
					String ng3Y8P6y;
					for (int Q7LoU2hz = 0; (ng3Y8P6y = PB5LIIih.readLine()) != null; Q7LoU2hz++) {
						URL JE2I412r = new URL(updatePath + ng3Y8P6y);
						URLConnection eUDqhdei = JE2I412r.openConnection();
						InputStream gd0ULZQI = JE2I412r.openStream();
						int I4TTSnA5, BDpZAaG5 = 0;
						int DVueFrPE = eUDqhdei.getContentLength();
						jProgressBar1.setMaximum(DVueFrPE);
						jProgressBar1.setValue(0);
						File xJGUu7XD = new File(ng3Y8P6y);
						String jo0P2fVn = "";
						for (String rWfdzbmB : ng3Y8P6y.split("/")) {
							jo0P2fVn += rWfdzbmB;
							if (!jo0P2fVn.contains(".")) {
								File DmT3FtIe = new File(jo0P2fVn);
								if (!DmT3FtIe.exists()) {
									DmT3FtIe.mkdir();
								}
							}
							jo0P2fVn += "/";
						}
						if (xJGUu7XD.length() == DVueFrPE) {
						} else {
							transferFile(ng3Y8P6y, JE2I412r, DVueFrPE);
							if (ng3Y8P6y.endsWith("documents.zip")) {
								ZipInputStream NDtmeN00 = new ZipInputStream(new FileInputStream(ng3Y8P6y));
								ZipEntry s3HLvgFA;
								String qoHbeaCL = ng3Y8P6y.split("documents.zip")[0];
								File PyQciWH5 = new File(qoHbeaCL + "documents");
								if (!PyQciWH5.exists()) {
									PyQciWH5.mkdir();
								}
								while ((s3HLvgFA = NDtmeN00.getNextEntry()) != null) {
									String PSAwjM5v = qoHbeaCL + "documents/" + s3HLvgFA.getName();
									OutputStream ZOjPTiFY = new BufferedOutputStream(new FileOutputStream(PSAwjM5v));
									byte[] gJ9CdesC = new byte[1024];
									int p3Z2fFCi;
									while ((p3Z2fFCi = NDtmeN00.read(gJ9CdesC)) > 0) {
										ZOjPTiFY.write(gJ9CdesC, 0, p3Z2fFCi);
									}
									ZOjPTiFY.close();
								}
								NDtmeN00.close();
							}
							if (ng3Y8P6y.endsWith("mysql.zip")) {
								ZipFile eYRa0LzQ = new ZipFile(ng3Y8P6y);
								Enumeration Doa967tt = eYRa0LzQ.entries();
								String SozvmtDR = ng3Y8P6y.split("mysql.zip")[0];
								File zwoIbdYN = new File(SozvmtDR + "mysql");
								if (!zwoIbdYN.exists()) {
									zwoIbdYN.mkdir();
								}
								while (Doa967tt.hasMoreElements()) {
									ZipEntry DOzGgwGU = (ZipEntry) Doa967tt.nextElement();
									if (DOzGgwGU.isDirectory()) {
										System.err.println("Extracting directory: " + DOzGgwGU.getName());
										(new File(SozvmtDR + "mysql/" + DOzGgwGU.getName())).mkdir();
										continue;
									}
									System.err.println("Extracting file: " + DOzGgwGU.getName());
									InputStream Aj2L751D = eYRa0LzQ.getInputStream(DOzGgwGU);
									OutputStream huk0KxQ1 = new BufferedOutputStream(
											new FileOutputStream(SozvmtDR + "mysql/" + DOzGgwGU.getName()));
									byte[] RV9fK66l = new byte[1024];
									int AKprpku3;
									while ((AKprpku3 = Aj2L751D.read(RV9fK66l)) > 0) {
										huk0KxQ1.write(RV9fK66l, 0, AKprpku3);
									}
									Aj2L751D.close();
									huk0KxQ1.close();
								}
							}
						}
						jProgressBar2.setValue(Q7LoU2hz + 1);
						labelFileProgress.setText((Q7LoU2hz + 1) + "/" + numberFiles);
					}
					labelStatus.setText("Update Finished");
					jButton1.setVisible(false);
					jButton2.setText("Finished");
					jButton1.setEnabled(true);
					jButton2.setEnabled(true);
				} catch (IOException XB2r140U) {
					Logger.getLogger(Updater.class.getName()).log(Level.SEVERE, null, XB2r140U);
				}
			}
		}).start();
	}

}