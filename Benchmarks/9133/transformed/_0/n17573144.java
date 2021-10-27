class n17573144 {
	public void dispatch(com.sun.star.util.URL nwh5hHwT, com.sun.star.beans.PropertyValue[] MKXot51T) {
		if (nwh5hHwT.Protocol.compareTo("org.openoffice.oosvn.oosvn:") == 0) {
			OoDocProperty uwXCTQnF = getProperty();
			settings.setCancelFired(false);
			if (nwh5hHwT.Path.compareTo("svnUpdate") == 0) {
				try {
					try {
						settings = getSerializedSettings(uwXCTQnF);
					} catch (NullPointerException HuU3Apmz) {
						new DialogSettings(new javax.swing.JFrame(), true, settings).setVisible(true);
						if (settings.getCancelFired())
							return;
						new DialogFileChooser(new javax.swing.JFrame(), true, settings).setVisible(true);
						if (settings.getCancelFired())
							return;
					} catch (Exception t65Lu4Xg) {
						error("Error getting settings", t65Lu4Xg);
						return;
					}
					Object[][] XIVRHrLt = getLogs(settings);
					long ruvx1a2o = -1;
					if (XIVRHrLt.length == 0) {
						error("Sorry, the specified repository is empty.");
						return;
					}
					new DialogSVNHistory(new javax.swing.JFrame(), true, settings, XIVRHrLt).setVisible(true);
					if (settings.getCancelFired())
						return;
					File PAw1cPGO = new File(settings.getCheckoutPath() + svnWorker.tempDir);
					if (PAw1cPGO.exists()) {
						if (deleteFileDir(PAw1cPGO) == false) {
							error("Error while deleting temporary checkout dir.");
						}
					}
					svnWorker.checkout(settings);
					File[] gFFk21pJ = PAw1cPGO.listFiles();
					File dQM8wCst = null;
					File u1OirDYx = null;
					for (int PDfbbp3A = 0; PDfbbp3A < gFFk21pJ.length; PDfbbp3A++) {
						if (gFFk21pJ[PDfbbp3A].toString().endsWith(".odt"))
							dQM8wCst = gFFk21pJ[PDfbbp3A];
						if (gFFk21pJ[PDfbbp3A].toString().equals(settings.getCheckoutDoc())
								&& settings.getCheckoutDoc() != null)
							u1OirDYx = gFFk21pJ[PDfbbp3A];
					}
					if (u1OirDYx != null)
						dQM8wCst = u1OirDYx;
					String yvBKlZcV;
					if (settings.getCheckoutDoc() == null || !settings.getCheckoutDoc().equals(dQM8wCst.getName())) {
						File MKF3UDzg = new File(settings.getCheckoutPath() + "/" + dQM8wCst.getName());
						if (MKF3UDzg.exists())
							MKF3UDzg.delete();
						dQM8wCst.renameTo(MKF3UDzg);
						File oRdMEj8d = new File(settings.getCheckoutPath() + svnWorker.tempDir + "/.svn");
						File D87nEkxu = new File(settings.getCheckoutPath() + "/.svn");
						if (D87nEkxu.exists()) {
							if (deleteFileDir(D87nEkxu) == false) {
								error("Error while deleting temporary checkout dir.");
							}
						}
						yvBKlZcV = "file:///" + MKF3UDzg.getPath().replace("\\", "/");
						oRdMEj8d.renameTo(D87nEkxu);
						dQM8wCst = MKF3UDzg;
						loadDocumentFromUrl(yvBKlZcV);
						settings.setCheckoutDoc(dQM8wCst.getName());
						try {
							settings.serializeOut();
						} catch (Exception eaXnHCsv) {
							error("Error occured when re-newing settings.", eaXnHCsv);
						}
					} else {
						try {
							settings.serializeOut();
						} catch (Exception n0yS4Esw) {
							error("Error occured when re-newing settings.", n0yS4Esw);
						}
						yvBKlZcV = "file:///" + dQM8wCst.getPath().replace("\\", "/");
						XDispatchProvider h0rZpScS = (XDispatchProvider) UnoRuntime
								.queryInterface(XDispatchProvider.class, m_xFrame);
						PropertyValue vQ0LFmMd[] = new PropertyValue[1];
						vQ0LFmMd[0] = new PropertyValue();
						vQ0LFmMd[0].Name = "URL";
						vQ0LFmMd[0].Value = yvBKlZcV;
						XMultiServiceFactory etwxPmDI = createProvider();
						Object wq8NnWBl = m_xServiceManager
								.createInstanceWithContext("com.sun.star.frame.DispatchHelper", m_xContext);
						XDispatchHelper z4egqorL = (XDispatchHelper) UnoRuntime.queryInterface(XDispatchHelper.class,
								wq8NnWBl);
						z4egqorL.executeDispatch(h0rZpScS, ".uno:CompareDocuments", "", 0, vQ0LFmMd);
					}
				} catch (Exception HpIWdps4) {
					error(HpIWdps4);
				}
				return;
			}
			if (nwh5hHwT.Path.compareTo("svnCommit") == 0) {
				try {
					try {
						settings = getSerializedSettings(uwXCTQnF);
					} catch (Exception jZX2cCU4) {
						error("Error getting settings", jZX2cCU4);
						return;
					}
					Collection s0300HDO = svnWorker.getLogs(settings);
					long oQ7OJtWE = svnWorker.getHeadRevisionNumber(s0300HDO);
					long cXWUiFCH = -1;
					new DialogCommitMessage(new javax.swing.JFrame(), true, settings).setVisible(true);
					if (settings.getCancelFired())
						return;
					try {
						settings.serializeOut();
					} catch (Exception A3hyEQwf) {
						error("Error occured when re-newing settings.", A3hyEQwf);
					}
					if (oQ7OJtWE == 0) {
						File JKQo4Rbn = new File(settings.getCheckoutPath() + svnWorker.tempDir + "/.import");
						if (JKQo4Rbn.exists())
							if (deleteFileDir(JKQo4Rbn) == false) {
								error("Error while creating temporary import directory.");
								return;
							}
						if (!JKQo4Rbn.mkdirs()) {
							error("Error while creating temporary import directory.");
							return;
						}
						File IOgfVwYe = new File(settings.getCheckoutPath() + svnWorker.tempDir + "/.import/"
								+ settings.getCheckoutDoc());
						try {
							FileChannel Rky04lc2 = new FileInputStream(
									settings.getCheckoutPath() + "/" + settings.getCheckoutDoc()).getChannel();
							FileChannel cA9OatAR = new FileOutputStream(IOgfVwYe).getChannel();
							cA9OatAR.transferFrom(Rky04lc2, 0, Rky04lc2.size());
							Rky04lc2.close();
							cA9OatAR.close();
						} catch (Exception QejKrTHq) {
							error("Error while importing file", QejKrTHq);
							return;
						}
						final String eedIoVbV = settings.getCheckoutPath();
						try {
							settings.setCheckoutPath(JKQo4Rbn.toString());
							cXWUiFCH = svnWorker.importDirectory(settings, false).getNewRevision();
						} catch (Exception DPg7nhit) {
							settings.setCheckoutPath(eedIoVbV);
							error("Error while importing file", DPg7nhit);
							return;
						}
						settings.setCheckoutPath(eedIoVbV);
						if (JKQo4Rbn.exists())
							if (deleteFileDir(JKQo4Rbn) == false)
								error("Error while creating temporary import directory.");
						try {
							File oL9pYxkX = new File(settings.getCheckoutPath() + "/.svn");
							if (oL9pYxkX.exists()) {
								if (deleteFileDir(oL9pYxkX) == false) {
									error("Error while deleting temporary checkout dir.");
								}
							}
							File Wzii2ZfP = new File(settings.getCheckoutPath() + svnWorker.tempDir);
							if (Wzii2ZfP.exists()) {
								if (deleteFileDir(Wzii2ZfP) == false) {
									error("Error while deleting temporary checkout dir.");
								}
							}
							svnWorker.checkout(settings);
							File OC0aIi5u = new File(settings.getCheckoutPath() + svnWorker.tempDir + "/.svn");
							OC0aIi5u.renameTo(oL9pYxkX);
							if (deleteFileDir(Wzii2ZfP) == false) {
								error("Error while managing working copy");
							}
							try {
								settings.serializeOut();
							} catch (Exception YuFJyp6c) {
								error("Error occured when re-newing settings.", YuFJyp6c);
							}
						} catch (Exception ZaK8W53L) {
							error("Error while checking out a working copy for the location", ZaK8W53L);
						}
						showMessageBox("Import succesful", "Succesfully imported as revision no. " + cXWUiFCH);
						return;
					} else {
						try {
							cXWUiFCH = svnWorker.commit(settings, false).getNewRevision();
						} catch (Exception lEFGDV7h) {
							error("Error while committing changes. If the file is not working copy, you must use 'Checkout / Update' first.",
									lEFGDV7h);
						}
						if (cXWUiFCH == -1) {
							showMessageBox("Update - no changes",
									"No changes was made. Maybe you must just save the changes.");
						} else {
							showMessageBox("Commit succesfull", "Commited as revision no. " + cXWUiFCH);
						}
					}
				} catch (Exception pLgQetxH) {
					error(pLgQetxH);
				}
				return;
			}
			if (nwh5hHwT.Path.compareTo("svnHistory") == 0) {
				try {
					try {
						settings = getSerializedSettings(uwXCTQnF);
					} catch (Exception KDARJN22) {
						error("Error getting settings", KDARJN22);
						return;
					}
					Object[][] kKdYK8JX = getLogs(settings);
					long qvXVs9qi = settings.getCheckoutVersion();
					settings.setCheckoutVersion(-99);
					new DialogSVNHistory(new javax.swing.JFrame(), true, settings, kKdYK8JX).setVisible(true);
					settings.setCheckoutVersion(qvXVs9qi);
				} catch (Exception aL7nsTAo) {
					error(aL7nsTAo);
				}
				return;
			}
			if (nwh5hHwT.Path.compareTo("settings") == 0) {
				try {
					settings = getSerializedSettings(uwXCTQnF);
				} catch (NoSerializedSettingsException RPSCftg5) {
					try {
						settings.setCheckout(uwXCTQnF.getDocURL());
					} catch (Exception MgiLDxqf) {
					}
				} catch (Exception mhsLv0Ec) {
					error("Error getting settings; maybe you" + " need to save your document."
							+ " If this is your first" + " checkout of the document, use Checkout"
							+ " function directly.");
					return;
				}
				new DialogSettings(new javax.swing.JFrame(), true, settings).setVisible(true);
				try {
					settings.serializeOut();
				} catch (Exception xXwAqcns) {
					error("Error occured when saving settings.", xXwAqcns);
				}
				return;
			}
			if (nwh5hHwT.Path.compareTo("about") == 0) {
				showMessageBox("OoSvn :: About", "Autor: ?t?p?n Cenek (stepan@geek.cz)");
				return;
			}
		}
	}

}