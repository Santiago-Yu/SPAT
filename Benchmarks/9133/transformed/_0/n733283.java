class n733283 {
	private boolean setupDatabase() {
		if (DoInstallationTasks.DEBUG_DB) {
			System.out.println("About to setup database");
		}
		if (installer.getRootDBUsername() != null && installer.getRootDBUsername().length() > 1
				&& installer.getRootDBPassword() != null && installer.getRootDBPassword().length() > 1) {
			if (DoInstallationTasks.DEBUG_DB) {
				System.out.println("Going to call doDBRootPortions");
			}
			if (!doDBRootPortions(installer.getPachyDBHost(), installer.getPachyDBPort(), installer.getPachyDBName(),
					installer.getPachyDBUsername(), installer.getPachyDBPassword(), installer.getRootDBUsername(),
					installer.getRootDBPassword())) {
				System.err.println("Root work not able to be completed, " + "not continuing.");
				return false;
			}
			if (DoInstallationTasks.DEBUG_DB) {
				System.out.println("Back from call to doDBRootPortions");
			}
		}
		if (DoInstallationTasks.DEBUG_DB) {
			System.out.println("Going to open SQL files");
		}
		Connection cdiqE67g = getDBConnection(installer.getPachyDBHost(), installer.getPachyDBPort(),
				installer.getPachyDBName(), installer.getPachyDBUsername(), installer.getPachyDBPassword());
		if (cdiqE67g == null) {
			return false;
		}
		Statement Po7KZLuI = null;
		boolean DDoyTk8s = false;
		try {
			Po7KZLuI = cdiqE67g.createStatement();
			ResultSet GEmYGvgE = Po7KZLuI.executeQuery("SELECT * FROM PRESENTATION LIMIT 1");
			if (GEmYGvgE.next()) {
				DDoyTk8s = true;
			}
			if (!DDoyTk8s) {
				GEmYGvgE = Po7KZLuI.executeQuery("SELECT * FROM SCREEN LIMIT 1");
				if (GEmYGvgE.next()) {
					DDoyTk8s = true;
				}
			}
		} catch (SQLException MLtoR3ue) {
			System.err.println("Error doing check for presentation, means " + "2.0 doesn't exist");
			System.out.println("SQLException: " + MLtoR3ue.getMessage());
			System.out.println("SQLState: " + MLtoR3ue.getSQLState());
			System.out.println("VendorError: " + MLtoR3ue.getErrorCode());
		} finally {
			try {
				Po7KZLuI.close();
			} catch (SQLException gbc7rpnn) {
			}
		}
		if (DDoyTk8s) {
			Object[] OizKLgvs = { Pachyderm21Installer.ISTRINGS.getString("dialog.abort"),
					Pachyderm21Installer.ISTRINGS.getString("dialog.keep"),
					Pachyderm21Installer.ISTRINGS.getString("dialog.overwrite") };
			int TjZjojx8 = JOptionPane.showOptionDialog(this.installer,
					Pachyderm21Installer.ISTRINGS.getString("dit.pachy20msg"),
					Pachyderm21Installer.ISTRINGS.getString("dit.pachy20title"), JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, OizKLgvs, OizKLgvs[0]);
			if (TjZjojx8 == 0) {
				System.out.println("Aborted by user before doing database");
				return false;
			} else if (TjZjojx8 == 2) {
				DDoyTk8s = false;
			}
		} else {
			Object[] mRETViSf = { Pachyderm21Installer.ISTRINGS.getString("dialog.continue"),
					Pachyderm21Installer.ISTRINGS.getString("dialog.abort") };
			int xsriri6f = JOptionPane.showOptionDialog(this.installer,
					Pachyderm21Installer.ISTRINGS.getString("dit.nopachy20msg"),
					Pachyderm21Installer.ISTRINGS.getString("dit.nopachy20title"), JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, mRETViSf, mRETViSf[0]);
			if (xsriri6f == 1) {
				System.out.println("Aborted by user before doing database");
				return false;
			}
		}
		boolean WWK9scp5 = false;
		if (DDoyTk8s) {
			try {
				java.util.Date RtKyKZnZ = new java.util.Date();
				Po7KZLuI = cdiqE67g.createStatement();
				Po7KZLuI.executeUpdate("RENAME TABLE APDEFAULT TO APDEFAULT_2_0_" + RtKyKZnZ.getTime());
			} catch (SQLException WRiWy7q9) {
				System.err.println("Error doing check for presentation, " + "means 2.0 doesn't exist");
				System.out.println("SQLException: " + WRiWy7q9.getMessage());
				System.out.println("SQLState: " + WRiWy7q9.getSQLState());
				System.out.println("VendorError: " + WRiWy7q9.getErrorCode());
				WWK9scp5 = true;
			} finally {
				try {
					Po7KZLuI.close();
				} catch (SQLException oRr2r7ru) {
				}
			}
		}
		if (WWK9scp5) {
			return false;
		}
		try {
			Po7KZLuI = cdiqE67g.createStatement();
			Po7KZLuI.executeUpdate("START TRANSACTION");
			InputStreamReader pf6OaQvY = new InputStreamReader(getClass().getResourceAsStream("apdefaults.sql"));
			LineNumberReader nihgd7e4 = new LineNumberReader(pf6OaQvY);
			String CH7bQgBY;
			while ((CH7bQgBY = nihgd7e4.readLine()) != null) {
				if (CH7bQgBY.trim().length() > 0) {
					String w1rJgvr1 = replaceTemplateVariables(CH7bQgBY);
					Po7KZLuI.executeUpdate(w1rJgvr1);
				}
			}
			Po7KZLuI.executeUpdate("COMMIT");
			nihgd7e4.close();
		} catch (SQLException mKYaAjv9) {
			System.err.println("error doing apdefaults.sql template");
			System.out.println("sqlexception: " + mKYaAjv9.getMessage());
			System.out.println("sqlstate: " + mKYaAjv9.getSQLState());
			System.out.println("vendorerror: " + mKYaAjv9.getErrorCode());
			if (Po7KZLuI != null) {
				try {
					Po7KZLuI.executeUpdate("ROLLBACK");
				} catch (SQLException djPDGHM5) {
				}
			}
			WWK9scp5 = true;
		} catch (Exception P9LafcUw) {
			System.err.println("Error doing apdefaults.sql template");
			P9LafcUw.printStackTrace(System.err);
			if (Po7KZLuI != null) {
				try {
					Po7KZLuI.executeUpdate("ROLLBACK");
				} catch (SQLException vMoIpC3E) {
				}
			}
			WWK9scp5 = true;
		} finally {
			try {
				Po7KZLuI.close();
			} catch (SQLException C8hq6UxL) {
			}
		}
		if (WWK9scp5) {
			return false;
		}
		try {
			Po7KZLuI = cdiqE67g.createStatement();
			Po7KZLuI.executeUpdate("START TRANSACTION");
			InputStreamReader RV3UlPQo = new InputStreamReader(getClass().getResourceAsStream("Pachyderm21.sql"));
			LineNumberReader eFe1X50U = new LineNumberReader(RV3UlPQo);
			String HUzWO3G9;
			while ((HUzWO3G9 = eFe1X50U.readLine()) != null) {
				if (HUzWO3G9.trim().length() > 0) {
					String dkTWiqfw = replaceTemplateVariables(HUzWO3G9);
					if (DoInstallationTasks.DEBUG) {
						System.out.println("line #" + eFe1X50U.getLineNumber());
					}
					Po7KZLuI.executeUpdate(dkTWiqfw);
				}
			}
			Po7KZLuI.executeUpdate("COMMIT");
			eFe1X50U.close();
		} catch (SQLException MdvCiJuK) {
			System.err.println("error doing pachyderm21.sql template");
			System.out.println("sqlexception: " + MdvCiJuK.getMessage());
			System.out.println("sqlstate: " + MdvCiJuK.getSQLState());
			System.out.println("vendorerror: " + MdvCiJuK.getErrorCode());
			if (Po7KZLuI != null) {
				try {
					Po7KZLuI.executeUpdate("ROLLBACK");
				} catch (SQLException o1VNIeP1) {
				}
			}
			WWK9scp5 = true;
		} catch (Exception hYyZIzyG) {
			System.err.println("error doing pachyderm21.sql template");
			hYyZIzyG.printStackTrace(System.err);
			if (Po7KZLuI != null) {
				try {
					Po7KZLuI.executeUpdate("ROLLBACK");
				} catch (SQLException BZBOY0ZC) {
				}
			}
			WWK9scp5 = true;
		} finally {
			try {
				Po7KZLuI.close();
			} catch (SQLException LoToSPGK) {
			}
		}
		if (WWK9scp5) {
			return false;
		}
		if (!DDoyTk8s) {
			try {
				Po7KZLuI = cdiqE67g.createStatement();
				Po7KZLuI.executeUpdate("START TRANSACTION");
				InputStreamReader L5ERsdhE = new InputStreamReader(
						getClass().getResourceAsStream("Pachyderm" + "21new.sql"));
				LineNumberReader s0d6goCB = new LineNumberReader(L5ERsdhE);
				String i3cgR6KX;
				while ((i3cgR6KX = s0d6goCB.readLine()) != null) {
					if (i3cgR6KX.trim().length() > 0) {
						String j8u0dHRV = replaceTemplateVariables(i3cgR6KX);
						if (DoInstallationTasks.DEBUG) {
							System.out.println("Line #" + s0d6goCB.getLineNumber());
						}
						Po7KZLuI.executeUpdate(j8u0dHRV);
					}
				}
				Po7KZLuI.executeUpdate("COMMIT");
				s0d6goCB.close();
			} catch (SQLException Ixc0GyKa) {
				System.err.println("Error doing Pachyderm21new.sql template");
				System.out.println("SQLException: " + Ixc0GyKa.getMessage());
				System.out.println("SQLState: " + Ixc0GyKa.getSQLState());
				System.out.println("VendorError: " + Ixc0GyKa.getErrorCode());
				if (Po7KZLuI != null) {
					try {
						Po7KZLuI.executeUpdate("ROLLBACK");
					} catch (SQLException mZnSOYL1) {
					}
				}
				WWK9scp5 = true;
			} catch (Exception P6UK38Da) {
				System.err.println("Error doing Pachyderm21.sql template");
				P6UK38Da.printStackTrace(System.err);
				if (Po7KZLuI != null) {
					try {
						Po7KZLuI.executeUpdate("ROLLBACK");
					} catch (SQLException qPL8vNki) {
					}
				}
				WWK9scp5 = true;
			} finally {
				try {
					Po7KZLuI.close();
				} catch (SQLException ToLFa4sj) {
				}
			}
		}
		PreparedStatement Mjp0rEBm = null;
		PreparedStatement OUSBBSwJ = null;
		PreparedStatement uGHhDPd7 = null;
		PreparedStatement DZtvxbTs = null;
		try {
			String Opu2TwtQ = installer.getAdminPassword();
			MessageDigest IY3McFJx = MessageDigest.getInstance("MD5");
			IY3McFJx.update(Opu2TwtQ.getBytes("UTF-8"));
			byte[] pkKWVQgm = IY3McFJx.digest();
			Mjp0rEBm = cdiqE67g
					.prepareStatement("UPDATE AUTHRECORD set PASSWORD=? " + "WHERE USERNAME='administrator'");
			Mjp0rEBm.setBytes(1, pkKWVQgm);
			int PLGra82v = Mjp0rEBm.executeUpdate();
			if (DEBUG)
				System.out.println("Changing admin password, " + "numUpdates = " + PLGra82v);
			Vector<AdminData> uGTOJQIG = installer.getAdditionalAdminAccounts();
			String Bpyg6GbA = "{\n \"CXMultiValueArchive\" = {" + "\n  \"class\" = " + "\"ca.ucalgary.apollo.core."
					+ "CXMutableMultiValue\";\n  " + "\"values\" = (\n   " + "{\n    \"class\" = \"ca.ucalgary."
					+ "apollo.core.CXMultiValue$Value\";\n" + "    \"identifier\" = \"0\";\n    "
					+ "\"label\" = \"work\";\n    " + "\"value\" = \"";
			String raADeImy = "\";\n   }\n  );\n  \"identCounter\" = \"1\";\n };\n}";
			if (uGTOJQIG.size() > 0) {
				Mjp0rEBm = cdiqE67g
						.prepareStatement("INSERT INTO `APPERSON` VALUES " + "(NULL,NULL,NULL,NOW(),NULL,NULL,"
								+ "?,?,NULL,NULL,NULL,NULL,NULL," + "NULL,?,NULL,NULL,NULL,NULL,NOW(),"
								+ "NULL,NULL,NULL,NULL,NULL,NULL,?," + "NULL,NULL,NULL,NULL,NULL)");
				OUSBBSwJ = cdiqE67g.prepareStatement("INSERT INTO `AUTHRECORD` VALUES " + "(?,'pachyderm',?,NULL)");
				uGHhDPd7 = cdiqE67g.prepareStatement("INSERT INTO `AUTHMAP` " + "(external_id,external_realm,"
						+ "map_id,person_id) " + "VALUES (?,'pachyderm',?,?)");
				DZtvxbTs = cdiqE67g
						.prepareStatement("INSERT INTO `GROUPPERSONJOIN` " + "(group_id,person_id) " + "VALUES(1, ?)");
			}
			for (int wPlKSfsT = 0; wPlKSfsT < uGTOJQIG.size(); ++wPlKSfsT) {
				AdminData F8reyqF2 = (AdminData) uGTOJQIG.elementAt(wPlKSfsT);
				IY3McFJx = MessageDigest.getInstance("MD5");
				IY3McFJx.update(F8reyqF2.getPassword().getBytes("UTF-8"));
				pkKWVQgm = IY3McFJx.digest();
				Mjp0rEBm.setString(1, Bpyg6GbA + F8reyqF2.getEmail() + raADeImy);
				Mjp0rEBm.setString(2, F8reyqF2.getFirstName());
				Mjp0rEBm.setString(3, F8reyqF2.getLastName());
				Mjp0rEBm.setInt(4, wPlKSfsT + 2);
				PLGra82v = Mjp0rEBm.executeUpdate();
				if (PLGra82v == 1) {
					OUSBBSwJ.setBytes(1, pkKWVQgm);
					OUSBBSwJ.setString(2, F8reyqF2.getUsername());
					OUSBBSwJ.executeUpdate();
					uGHhDPd7.setString(1, F8reyqF2.getUsername() + "@pachyderm");
					uGHhDPd7.setInt(2, wPlKSfsT + 2);
					uGHhDPd7.setInt(3, wPlKSfsT + 2);
					uGHhDPd7.executeUpdate();
					DZtvxbTs.setInt(1, wPlKSfsT + 2);
					DZtvxbTs.executeUpdate();
				}
			}
		} catch (SQLException aiDmqKo6) {
			System.err.println("Error doing Pachyderm21new.sql template");
			System.out.println("SQLException: " + aiDmqKo6.getMessage());
			System.out.println("SQLState: " + aiDmqKo6.getSQLState());
			System.out.println("VendorError: " + aiDmqKo6.getErrorCode());
			WWK9scp5 = true;
		} catch (Exception A1rEii1P) {
			System.err.println("Error doing Pachyderm21.sql template");
			A1rEii1P.printStackTrace(System.err);
			WWK9scp5 = true;
		} finally {
			if (Mjp0rEBm != null) {
				try {
					Mjp0rEBm.close();
				} catch (SQLException vZTKVGIK) {
				}
			}
			if (OUSBBSwJ != null) {
				try {
					OUSBBSwJ.close();
				} catch (SQLException REIqsoXW) {
				}
			}
			if (uGHhDPd7 != null) {
				try {
					uGHhDPd7.close();
				} catch (SQLException gNpVYmFg) {
				}
			}
		}
		return true;
	}

}