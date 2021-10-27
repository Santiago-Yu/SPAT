class n21028028 {
	public int save(String sLSYTDMy, String Y5o4UZN9, int RmpHChYp, boolean HmxJjPZO) {
		if (sLSYTDMy == null || sLSYTDMy.equals(""))
			return InventoryMonitor.CONFIGURATION_NOT_SAVED;
		Category nPEp55PS = ThreadCategory.getInstance(getClass());
		try {
			nPEp55PS.debug(sLSYTDMy);
			init(sLSYTDMy);
		} catch (ValidationException ypwZLKiv) {
			nPEp55PS.error("Unable to parse new Inventory.");
			nPEp55PS.error(ypwZLKiv);
			return InventoryMonitor.CONFIGURATION_NOT_SAVED;
		} catch (MarshalException TVASEPXH) {
			nPEp55PS.error("Unable to parse new Inventory.");
			nPEp55PS.error(TVASEPXH);
			return InventoryMonitor.CONFIGURATION_NOT_SAVED;
		}
		InventoryConfiguration ildb1xeP = InventoryConfigFactory.getInstance().getConfiguration();
		String ZyUUMnvk = ildb1xeP.getFileRepository();
		String qbI7zjaJ = (String) parameters.get("path");
		if (qbI7zjaJ == null) {
			nPEp55PS.error("Parameter 'path' not found.");
			saveMessage = "Unable to save " + Y5o4UZN9 + " configuration.<br>";
			return InventoryMonitor.CONFIGURATION_NOT_SAVED;
		}
		java.sql.Connection LwxsnVpB = null;
		try {
			LwxsnVpB = DatabaseConnectionFactory.getInstance().getConnection();
			LwxsnVpB.setAutoCommit(false);
		} catch (SQLException CFScGLTn) {
			nPEp55PS.error("Unable to connect to DB");
			saveMessage = "Unable to save " + Y5o4UZN9 + " configuration.<br>";
			return InventoryMonitor.CONFIGURATION_NOT_SAVED;
		} catch (Exception PceNeQPK) {
			nPEp55PS.error("Unable to connect to DB");
			saveMessage = "Unable to save " + Y5o4UZN9 + " configuration.<br>";
			return InventoryMonitor.CONFIGURATION_NOT_SAVED;
		}
		String h9JLLV73 = "";
		String bmH3VSls = "";
		String PB6Ii3QS = "";
		String rqU2Vp5I = "";
		boolean RRSHkCGU = false;
		ResultSet weaNEMll = null;
		try {
			PreparedStatement bR0OrD8X = LwxsnVpB.prepareStatement(SELECT_NODEID_BY_INTERFACE);
			bR0OrD8X.setString(1, ipAddress);
			weaNEMll = bR0OrD8X.executeQuery();
			while (weaNEMll.next()) {
				nodeId = weaNEMll.getInt(1);
			}
			if (ZyUUMnvk.endsWith("/") == false && ZyUUMnvk.endsWith(File.separator) == false) {
				ZyUUMnvk += File.separator;
			}
			h9JLLV73 = ZyUUMnvk + nodeId;
		} catch (SQLException Lu6Kuk4O) {
			try {
				LwxsnVpB.rollback();
			} catch (SQLException vxaQkIPT) {
				nPEp55PS.error("Unable to rollback on db. " + vxaQkIPT);
			}
			nPEp55PS.error("Unable to read from DB");
			saveMessage = "Unable to save " + Y5o4UZN9 + " configuration.<br>";
			return InventoryMonitor.CONFIGURATION_NOT_SAVED;
		}
		weaNEMll = null;
		try {
			PreparedStatement bpIz4Gkr = LwxsnVpB.prepareStatement(SELECT_PATHTOFILE);
			bpIz4Gkr.setInt(1, nodeId);
			bpIz4Gkr.setString(2, Y5o4UZN9);
			bpIz4Gkr.setString(3, "A");
			weaNEMll = bpIz4Gkr.executeQuery();
			while (weaNEMll.next()) {
				PB6Ii3QS = weaNEMll.getString(1);
			}
			String vrptJxzd = h9JLLV73;
			if (qbI7zjaJ.startsWith("/") == false && qbI7zjaJ.startsWith(File.separator) == false) {
				vrptJxzd += File.separator;
			}
			long P0DTAJqe = System.currentTimeMillis();
			Timestamp o7iDwO0f = new Timestamp(P0DTAJqe);
			java.util.Date pgwc3zhI = new java.util.Date(o7iDwO0f.getTime());
			SimpleDateFormat CbfLG6Ry = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			rqU2Vp5I = vrptJxzd + qbI7zjaJ + "[" + CbfLG6Ry.format(pgwc3zhI) + "]";
		} catch (SQLException bHGHjKAY) {
			nPEp55PS.error("Unable to read from DB");
			try {
				LwxsnVpB.rollback();
			} catch (SQLException fHzSFQ3C) {
				nPEp55PS.error("Unable to rollback on db. " + fHzSFQ3C);
			}
			saveMessage = "Unable to save " + Y5o4UZN9 + " configuration.<br>";
			return InventoryMonitor.CONFIGURATION_NOT_SAVED;
		}
		int LQtTYvfc = InventoryMonitor.CONFIGURATION_SAVED;
		weaNEMll = null;
		int oK0Ssop5 = -1;
		try {
			PreparedStatement c1v8b92J = LwxsnVpB.prepareStatement(COUNT_NODEID_CONFIGURATION_NAME);
			c1v8b92J.setInt(1, nodeId);
			c1v8b92J.setString(2, Y5o4UZN9);
			weaNEMll = c1v8b92J.executeQuery();
			while (weaNEMll.next()) {
				oK0Ssop5 = weaNEMll.getInt(1);
			}
		} catch (SQLException ro8I6sCm) {
			nPEp55PS.error("Unable to read from DB");
			nPEp55PS.error(ro8I6sCm);
			try {
				LwxsnVpB.rollback();
			} catch (SQLException dXZvQGT9) {
				nPEp55PS.error("Unable to rollback on db. " + dXZvQGT9);
			}
			saveMessage = "Unable to save " + Y5o4UZN9 + " configuration.<br>";
			return InventoryMonitor.CONFIGURATION_NOT_SAVED;
		}
		long FWDY6rGe = System.currentTimeMillis();
		Timestamp TjJJdqek = new Timestamp(FWDY6rGe);
		if (oK0Ssop5 > 0) {
			if (RmpHChYp == InventoryMonitor.CONFIGURATION_CHANGED
					|| RmpHChYp == InventoryMonitor.FIRST_ACTIVE_CONFIGURATION_DOWNLOAD) {
				try {
					nPEp55PS.debug("FOUND=" + oK0Ssop5 + " row/s in configuration, UPDATE it");
					PreparedStatement DKhUZ4dl = LwxsnVpB.prepareStatement(UPDATE_CONFIGURATION_TO_STATUS_N);
					DKhUZ4dl.setInt(1, nodeId);
					DKhUZ4dl.setString(2, Y5o4UZN9);
					DKhUZ4dl.executeUpdate();
				} catch (SQLException mssFQBxN) {
					nPEp55PS.error("Unable to update DB" + mssFQBxN);
					try {
						LwxsnVpB.rollback();
					} catch (SQLException dlluc1cn) {
						nPEp55PS.error("Unable to rollback on db. " + dlluc1cn);
					}
					saveMessage = "Unable to save " + Y5o4UZN9 + " configuration.<br>";
					return InventoryMonitor.CONFIGURATION_NOT_SAVED;
				}
				try {
					PreparedStatement fRPxSDKc = LwxsnVpB.prepareStatement(INSERT_IN_CONFIGURATION);
					fRPxSDKc.setInt(1, nodeId);
					fRPxSDKc.setTimestamp(2, TjJJdqek);
					fRPxSDKc.setTimestamp(3, TjJJdqek);
					fRPxSDKc.setString(4, Y5o4UZN9);
					fRPxSDKc.setString(5, rqU2Vp5I);
					fRPxSDKc.execute();
				} catch (SQLException vis5wvPT) {
					nPEp55PS.error("Unable to insert in DB");
					nPEp55PS.error(vis5wvPT);
					try {
						LwxsnVpB.rollback();
					} catch (SQLException UkUCgxUY) {
						nPEp55PS.error("Unable to rollback on db. " + UkUCgxUY);
					}
					saveMessage = "Unable to save " + Y5o4UZN9 + " configuration.<br>";
					return InventoryMonitor.CONFIGURATION_NOT_SAVED;
				}
			} else {
				try {
					nPEp55PS.debug("FOUND=" + oK0Ssop5 + " row/s in configuration, UPDATE it");
					PreparedStatement nJGzj6Qe = LwxsnVpB.prepareStatement(UPDATE_LASTPOLLTIME_PATHTOFILE);
					nJGzj6Qe.setTimestamp(1, TjJJdqek);
					nJGzj6Qe.setString(2, rqU2Vp5I);
					nJGzj6Qe.setInt(3, nodeId);
					nJGzj6Qe.setString(4, Y5o4UZN9);
					nJGzj6Qe.executeUpdate();
					RRSHkCGU = true;
				} catch (SQLException tpSXDW2v) {
					nPEp55PS.error("Unable to update DB");
					nPEp55PS.error(tpSXDW2v);
					try {
						LwxsnVpB.rollback();
					} catch (SQLException sm9enNzn) {
						nPEp55PS.error("Unable to rollback on db. " + sm9enNzn);
					}
					saveMessage = "Unable to save " + Y5o4UZN9 + " configuration.<br>";
					return InventoryMonitor.CONFIGURATION_NOT_SAVED;
				}
			}
			try {
				LwxsnVpB.commit();
			} catch (SQLException ucPXct9d) {
				nPEp55PS.error("Unable to commit to DB " + ucPXct9d);
				try {
					LwxsnVpB.rollback();
				} catch (SQLException exg8lO7g) {
					nPEp55PS.error("Unable to rollback on db. " + exg8lO7g);
				}
				return InventoryMonitor.CONFIGURATION_NOT_SAVED;
			}
		} else {
			try {
				PreparedStatement ceWT5jgg = LwxsnVpB.prepareStatement(INSERT_IN_CONFIGURATION);
				ceWT5jgg.setInt(1, nodeId);
				ceWT5jgg.setTimestamp(2, TjJJdqek);
				ceWT5jgg.setTimestamp(3, TjJJdqek);
				ceWT5jgg.setString(4, Y5o4UZN9);
				ceWT5jgg.setString(5, rqU2Vp5I);
				ceWT5jgg.execute();
			} catch (SQLException Pz9e9m4l) {
				nPEp55PS.error("Unable to insert in DB");
				nPEp55PS.error(Pz9e9m4l);
				try {
					LwxsnVpB.rollback();
				} catch (SQLException KQSGTgJ1) {
					nPEp55PS.error("Unable to rollback on db. " + KQSGTgJ1);
				}
				saveMessage = "Unable to save " + Y5o4UZN9 + " configuration.<br>";
				return InventoryMonitor.CONFIGURATION_NOT_SAVED;
			}
		}
		weaNEMll = null;
		oK0Ssop5 = -1;
		try {
			PreparedStatement gzrNCMGv = LwxsnVpB.prepareStatement(COUNT_NODEID_IN_ASSET);
			gzrNCMGv.setInt(1, nodeId);
			weaNEMll = gzrNCMGv.executeQuery();
			while (weaNEMll.next()) {
				oK0Ssop5 = weaNEMll.getInt(1);
			}
		} catch (SQLException dC597oiX) {
			nPEp55PS.error("Unable to write into DB");
			nPEp55PS.error(dC597oiX);
			try {
				LwxsnVpB.rollback();
			} catch (SQLException mDdwivGR) {
				nPEp55PS.error("Unable to rollback on db. " + mDdwivGR);
			}
			saveMessage = "Unable to save " + Y5o4UZN9 + " configuration.<br>";
			return InventoryMonitor.CONFIGURATION_NOT_SAVED;
		}
		FWDY6rGe = System.currentTimeMillis();
		TjJJdqek = new Timestamp(FWDY6rGe);
		if (oK0Ssop5 > 0) {
			try {
				nPEp55PS.debug("Found " + oK0Ssop5 + " rows in table assets: UPDATE it");
				Iterator UKaSCe7i = asset.keySet().iterator();
				String ft8VhXCE = "";
				int z9qBZWKS = 0;
				while (UKaSCe7i.hasNext()) {
					z9qBZWKS++;
					String LDzWrTvG = (String) UKaSCe7i.next();
					String yWCA4DYI = (String) asset.get(LDzWrTvG);
					yWCA4DYI = yWCA4DYI.replaceAll("[ \t]+", " ");
					ft8VhXCE += LDzWrTvG + "='" + yWCA4DYI + "',";
				}
				if (z9qBZWKS > 0) {
					String rTUc6qDz = "UPDATE assets SET  " + ft8VhXCE + " lastmodifieddate=? WHERE nodeID =?";
					PreparedStatement lxOCUxlY = LwxsnVpB.prepareStatement(rTUc6qDz);
					lxOCUxlY.setTimestamp(1, TjJJdqek);
					lxOCUxlY.setInt(2, nodeId);
					nPEp55PS.debug("UPDATEQUERY " + rTUc6qDz);
					lxOCUxlY.executeUpdate();
				}
			} catch (SQLException hpgQsCSn) {
				nPEp55PS.error("Unable to update DB" + hpgQsCSn);
				try {
					LwxsnVpB.rollback();
				} catch (SQLException fpTpfLN5) {
					nPEp55PS.error("Unable to rollback on db. " + fpTpfLN5);
				}
				saveMessage = "Unable to save " + Y5o4UZN9 + " configuration.<br>";
				return InventoryMonitor.CONFIGURATION_NOT_SAVED;
			}
		} else {
			try {
				nPEp55PS.debug("row not found. INSERT into assets");
				InsertIntoAssets(LwxsnVpB);
			} catch (SQLException MusZtSlo) {
				nPEp55PS.error("Unable to insert in DB");
				nPEp55PS.error(MusZtSlo);
				try {
					LwxsnVpB.rollback();
				} catch (SQLException sra8irQf) {
					nPEp55PS.error("Unable to rollback on db. " + sra8irQf);
				}
				saveMessage = "Unable to save " + Y5o4UZN9 + " configuration.<br>";
				return InventoryMonitor.CONFIGURATION_NOT_SAVED;
			}
		}
		try {
			LwxsnVpB.commit();
		} catch (SQLException PeTQvlYe) {
			nPEp55PS.error("Unable to save into DB" + PeTQvlYe);
			try {
				LwxsnVpB.rollback();
			} catch (SQLException Z2EB2xc5) {
				nPEp55PS.error("Unable to rollback on db. " + Z2EB2xc5);
			}
			saveMessage = "Unable to save " + Y5o4UZN9 + " configuration.<br>";
			return InventoryMonitor.CONFIGURATION_NOT_SAVED;
		}
		try {
			boolean S8pr5EKl = (new File(ZyUUMnvk)).exists();
			if (!S8pr5EKl) {
				nPEp55PS.warn("file-repository '" + ZyUUMnvk + "' not found: trying to create it.");
				boolean vNas9pog = (new File(ZyUUMnvk)).mkdir();
				if (!vNas9pog) {
					nPEp55PS.error("Directory creation failed");
					try {
						LwxsnVpB.rollback();
					} catch (SQLException kiFrZCO0) {
						nPEp55PS.error("Unable to rollback DB");
					}
					return InventoryMonitor.CONFIGURATION_NOT_SAVED;
				}
				nPEp55PS.warn("file-repository '" + ZyUUMnvk + "' created.");
			}
			S8pr5EKl = (new File(h9JLLV73)).exists();
			if (!S8pr5EKl) {
				boolean QpEwJZoG = (new File(h9JLLV73)).mkdir();
				if (!QpEwJZoG) {
					nPEp55PS.error("Node Directory '" + h9JLLV73 + "' creation failed.");
					saveMessage = "Unable to save " + Y5o4UZN9 + " configuration.<br>";
					try {
						LwxsnVpB.rollback();
					} catch (SQLException E0TLGSew) {
						nPEp55PS.error("Unable to rollback DB");
					}
					return InventoryMonitor.CONFIGURATION_NOT_SAVED;
				}
			}
			S8pr5EKl = (new File(PB6Ii3QS)).exists();
			nPEp55PS.debug(PB6Ii3QS + " exists=" + S8pr5EKl);
			if (!S8pr5EKl) {
				if (HmxJjPZO) {
					nPEp55PS.warn("renameCorruptedFile=true and old configuration doesn't exist.");
				}
				LQtTYvfc = InventoryMonitor.FIRST_ACTIVE_CONFIGURATION_DOWNLOAD;
			}
			if (HmxJjPZO) {
				File rQC7g2nB = new File(PB6Ii3QS);
				String wKgGi70b = PB6Ii3QS + "_Corrupted";
				File LijsmU1w = new File(wKgGi70b);
				LijsmU1w.createNewFile();
				rQC7g2nB.renameTo(LijsmU1w);
				FileWriter c0FQTKp6 = new FileWriter(rqU2Vp5I);
				BufferedWriter Wo0f8iTC = new BufferedWriter(c0FQTKp6);
				PrintWriter Rk88KGks = new PrintWriter(Wo0f8iTC);
				Rk88KGks.println(sLSYTDMy);
				Rk88KGks.close();
			} else {
				if (RRSHkCGU) {
					File GOOotZO4 = new File(PB6Ii3QS);
					File hYCotj7E = new File(rqU2Vp5I);
					hYCotj7E.createNewFile();
					GOOotZO4.renameTo(hYCotj7E);
				} else {
					FileWriter htVTYErG = new FileWriter(rqU2Vp5I);
					BufferedWriter qtiz5CUA = new BufferedWriter(htVTYErG);
					PrintWriter OFw8dwTh = new PrintWriter(qtiz5CUA);
					OFw8dwTh.print(sLSYTDMy);
					OFw8dwTh.close();
				}
			}
		} catch (IOException RIFVq13w) {
			try {
				LwxsnVpB.rollback();
			} catch (SQLException lC9Za5FY) {
				nPEp55PS.error("Unable to rollback DB");
			}
			nPEp55PS.error("Failed writing to file '" + rqU2Vp5I + "'.");
			saveMessage = "Unable to save " + Y5o4UZN9 + " configuration.<br>";
			return InventoryMonitor.CONFIGURATION_NOT_SAVED;
		} finally {
			try {
				LwxsnVpB.close();
			} catch (SQLException tFfSkdKK) {
				nPEp55PS.error("Unable to close connection to DB");
			}
		}
		saveMessage = "inventory " + Y5o4UZN9 + " success.<br>";
		nPEp55PS.debug("" + LQtTYvfc);
		return LQtTYvfc;
	}

}