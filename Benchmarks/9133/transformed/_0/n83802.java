class n83802 {
	private void doTask() {
		try {
			log("\n\n\n\n\n\n\n\n\n");
			log(" =================================================");
			log(" = Starting PSCafePOS                            =");
			log(" =================================================");
			log(" =   An open source point of sale system         =");
			log(" =   for educational organizations.              =");
			log(" =================================================");
			log(" = General Information                           =");
			log(" =   http://pscafe.sourceforge.net               =");
			log(" = Free Product Support                          =");
			log(" =   http://www.sourceforge.net/projects/pscafe  =");
			log(" =================================================");
			log(" = License Overview                              =");
			log(" =================================================");
			log(" = PSCafePOS is a POS System for Schools         =");
			log(" = Copyright (C) 2007 Charles Syperski           =");
			log(" =                                               =");
			log(" = This program is free software; you can        =");
			log(" = redistribute it and/or modify it under the    =");
			log(" = terms of the GNU General Public License as    =");
			log(" = published by the Free Software Foundation;    =");
			log(" = either version 2 of the License, or any later =");
			log(" = version.                                      =");
			log(" =                                               =");
			log(" = This program is distributed in the hope that  =");
			log(" = it will be useful, but WITHOUT ANY WARRANTY;  =");
			log(" = without even the implied warranty of          =");
			log(" = MERCHANTABILITY or FITNESS FOR A PARTICULAR   =");
			log(" = PURPOSE.                                      =");
			log(" =                                               =");
			log(" = See the GNU General Public License for more   =");
			log(" = details.                                      =");
			log(" =                                               =");
			log(" = You should have received a copy of the GNU    =");
			log(" = General Public License along with this        =");
			log(" = program; if not, write to the                 =");
			log(" =                                               =");
			log(" =      Free Software Foundation, Inc.           =");
			log(" =      59 Temple Place, Suite 330               =");
			log(" =      Boston, MA 02111-1307 USA                =");
			log(" =================================================");
			log(" = If you have any questions of comments please  =");
			log(" = let us know at http://pscafe.sourceforge.net  =");
			log(" =================================================");
			pause();
			File M3njFLaO;
			if (blAltSettings) {
				System.out.println("\n  + Alternative path specified at run time:");
				System.out.println("    Path: " + strAltPath);
				M3njFLaO = new File(strAltPath);
			} else {
				M3njFLaO = new File("etc" + File.separatorChar + "settings.dbp");
			}
			System.out.print("\n  + Checking for existance of settings...");
			boolean QAdZidYo = false;
			if (M3njFLaO.exists() && M3njFLaO.canRead()) {
				log("[OK]");
				QAdZidYo = true;
				if (forceConfig) {
					System.out.print("\n  + Running Config Wizard (at user request)...");
					Process OJdm6ntC = Runtime.getRuntime()
							.exec("java -cp . PSSettingWizard etc" + File.separatorChar + "settings.dbp");
					InputStream jWeIjnoH = OJdm6ntC.getErrorStream();
					InputStream AuPuHPcA = OJdm6ntC.getInputStream();
					InputStreamReader N5yuOZqJ = new InputStreamReader(AuPuHPcA);
					BufferedReader ljGGb722 = new BufferedReader(N5yuOZqJ);
					String cNYoSx60 = null;
					while ((cNYoSx60 = ljGGb722.readLine()) != null)
						System.out.println("  " + cNYoSx60);
					OJdm6ntC.waitFor();
				}
			} else {
				log("[FAILED]");
				M3njFLaO = new File("etc" + File.separatorChar + "settings.dbp.firstrun");
				System.out.print("\n  + Checking if this is the first run... ");
				if (M3njFLaO.exists() && M3njFLaO.canRead()) {
					log("[FOUND]");
					File AaeO5Bkm = new File("etc" + File.separatorChar + "settings.dbp");
					FileInputStream IpUNU4oz = null;
					FileOutputStream yZ8ahnQA = null;
					try {
						IpUNU4oz = new FileInputStream(M3njFLaO);
						yZ8ahnQA = new FileOutputStream(AaeO5Bkm);
						byte[] Yc0H44Et = new byte[4096];
						int MHqjoC0q;
						while ((MHqjoC0q = IpUNU4oz.read(Yc0H44Et)) != -1) {
							yZ8ahnQA.write(Yc0H44Et, 0, MHqjoC0q);
						}
						if (AaeO5Bkm.exists() && AaeO5Bkm.canRead()) {
							M3njFLaO = null;
							M3njFLaO = new File("etc" + File.separatorChar + "settings.dbp");
						}
						System.out.print("\n  + Running Settings Wizard... ");
						try {
							Process gLXYgq1S = Runtime.getRuntime()
									.exec("java PSSettingWizard etc" + File.separatorChar + "settings.dbp");
							InputStream VKbewLO1 = gLXYgq1S.getErrorStream();
							InputStream Kf8lyH3b = gLXYgq1S.getInputStream();
							InputStreamReader dHrifNvb = new InputStreamReader(Kf8lyH3b);
							BufferedReader RTQDlNH2 = new BufferedReader(dHrifNvb);
							String eQN4p191 = null;
							while ((eQN4p191 = RTQDlNH2.readLine()) != null)
								System.out.println("  " + eQN4p191);
							gLXYgq1S.waitFor();
							log("[OK]");
							if (gLXYgq1S.exitValue() == 0)
								QAdZidYo = true;
						} catch (InterruptedException BgE8oyIN) {
							System.err.println(BgE8oyIN.getMessage());
						}
					} catch (Exception Ahqys3bY) {
						System.err.println(Ahqys3bY.getMessage());
					} finally {
						if (IpUNU4oz != null)
							try {
								IpUNU4oz.close();
							} catch (IOException OQPTh7RV) {
								;
							}
						if (yZ8ahnQA != null)
							try {
								yZ8ahnQA.close();
							} catch (IOException DRnCzMwu) {
								;
							}
					}
				} else {
					M3njFLaO = null;
					M3njFLaO = new File("etc" + File.separatorChar + "settings.dbp");
					DBSettingsWriter mR2RBfpi = new DBSettingsWriter();
					mR2RBfpi.writeFile(new DBSettings(), M3njFLaO);
					QAdZidYo = true;
				}
			}
			if (QAdZidYo) {
				String Yr7sPWlL = ".";
				try {
					File jgoSC4Oo = new File("lib");
					File[] hMWQ5JDE = jgoSC4Oo.listFiles();
					for (int mKAMqtYx = 0; mKAMqtYx < hMWQ5JDE.length; mKAMqtYx++) {
						if (hMWQ5JDE[mKAMqtYx].isFile()) {
							Yr7sPWlL += File.pathSeparatorChar + "lib" + File.separatorChar
									+ hMWQ5JDE[mKAMqtYx].getName() + "";
						}
					}
				} catch (Exception nAvVHTeX) {
					System.err.println(nAvVHTeX.getMessage());
				}
				try {
					boolean azcUs6wS = false;
					System.out.print("\n  + Checking runtime settings...         ");
					DBSettings wycuigBo = null;
					if (M3njFLaO == null)
						M3njFLaO = new File("etc" + File.separatorChar + "settings.dbp");
					if (M3njFLaO.exists() && M3njFLaO.canRead()) {
						DBSettingsWriter X9p25W81 = new DBSettingsWriter();
						wycuigBo = (DBSettings) X9p25W81.loadSettingsDB(M3njFLaO);
						if (wycuigBo != null) {
							azcUs6wS = true;
						}
					}
					if (azcUs6wS) {
						log("[OK]");
						String G0mEgm0x = "";
						String lwveScRe = "";
						if (wycuigBo != null) {
							debug = wycuigBo.get(DBSettings.MAIN_DEBUG).compareTo("1") == 0;
							if (debug)
								log("       * Debug Mode is ON");
							else
								log("       * Debug Mode is OFF");
							if (wycuigBo.get(DBSettings.POS_SSLENABLED).compareTo("1") == 0) {
								G0mEgm0x = "-Djavax.net.ssl.keyStore=" + wycuigBo.get(DBSettings.POS_SSLKEYSTORE)
										+ " -Djavax.net.ssl.keyStorePassword=pscafe -Djavax.net.ssl.trustStore="
										+ wycuigBo.get(DBSettings.POS_SSLTRUSTSTORE)
										+ " -Djavax.net.ssl.trustStorePassword=pscafe";
								log("       * Using SSL");
								debug("            " + G0mEgm0x);
								if (wycuigBo.get(DBSettings.POS_SSLDEBUG).compareTo("1") == 0) {
									lwveScRe = "-Djavax.net.debug=all";
									log("       * SSL Debugging enabled");
									debug("            " + lwveScRe);
								}
							}
						}
						String xGyDzCBn = "java  -cp " + Yr7sPWlL + " " + G0mEgm0x + " " + lwveScRe + " POSDriver "
								+ M3njFLaO.getPath();
						debug(xGyDzCBn);
						System.out.print("\n  + Running PSCafePOS...                 ");
						Process zwNffpzu = Runtime.getRuntime().exec(xGyDzCBn);
						System.out.print("[OK]\n\n");
						InputStream LXDJAdr5 = zwNffpzu.getErrorStream();
						InputStream fSuu4DtQ = zwNffpzu.getInputStream();
						InputStreamReader TxX9BuTZ = new InputStreamReader(fSuu4DtQ);
						InputStreamReader YarmGvnS = new InputStreamReader(LXDJAdr5);
						BufferedReader q01jv69P = new BufferedReader(TxX9BuTZ);
						BufferedReader PSpKASuC = new BufferedReader(YarmGvnS);
						String xR1kMQF9 = null;
						String sZ7rGWqe = null;
						log(" =================================================");
						log(" =        Output from PSCafePOS System           =");
						log(" =================================================");
						while ((xR1kMQF9 = q01jv69P.readLine()) != null || (sZ7rGWqe = PSpKASuC.readLine()) != null) {
							if (xR1kMQF9 != null)
								System.out.println(" [PSCafePOS]" + xR1kMQF9);
							if (sZ7rGWqe != null)
								System.out.println(" [ERR]" + sZ7rGWqe);
						}
						zwNffpzu.waitFor();
						log(" =================================================");
						log(" =       End output from PSCafePOS System        =");
						log(" =              PSCafePOS has exited             =");
						log(" =================================================");
					} else {
						log("[Failed]");
					}
				} catch (Exception SIW90p8Q) {
					log(SIW90p8Q.getMessage());
					SIW90p8Q.printStackTrace();
				}
			}
		} catch (Exception JLQx7Z2D) {
			log(JLQx7Z2D.getMessage());
		}
	}

}