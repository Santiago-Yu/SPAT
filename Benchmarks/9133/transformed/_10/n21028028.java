class n21028028 {
	public int save(String newInventory, String inventoryType, int compareResult, boolean renameCorruptedFile) {
		if (newInventory == null || newInventory.equals(""))
			return InventoryMonitor.CONFIGURATION_NOT_SAVED;
		Category log = ThreadCategory.getInstance(getClass());
		try {
			log.debug(newInventory);
			init(newInventory);
		} catch (ValidationException ve) {
			log.error("Unable to parse new Inventory.");
			log.error(ve);
			return InventoryMonitor.CONFIGURATION_NOT_SAVED;
		} catch (MarshalException me) {
			log.error("Unable to parse new Inventory.");
			log.error(me);
			return InventoryMonitor.CONFIGURATION_NOT_SAVED;
		}
		InventoryConfiguration iConfig = InventoryConfigFactory.getInstance().getConfiguration();
		String directory_repository = iConfig.getFileRepository();
		String path = (String) parameters.get("path");
		java.sql.Connection dbConn = null;
		if (path == null) {
			log.error("Parameter 'path' not found.");
			saveMessage = "Unable to save " + inventoryType + " configuration.<br>";
			return InventoryMonitor.CONFIGURATION_NOT_SAVED;
		}
		String nodeDirectory_repository = "";
		try {
			dbConn = DatabaseConnectionFactory.getInstance().getConnection();
			dbConn.setAutoCommit(false);
		} catch (SQLException s) {
			log.error("Unable to connect to DB");
			saveMessage = "Unable to save " + inventoryType + " configuration.<br>";
			return InventoryMonitor.CONFIGURATION_NOT_SAVED;
		} catch (Exception s) {
			log.error("Unable to connect to DB");
			saveMessage = "Unable to save " + inventoryType + " configuration.<br>";
			return InventoryMonitor.CONFIGURATION_NOT_SAVED;
		}
		String file_repository = "";
		String oldPathToFile = "";
		boolean renameFile = false;
		String newPathToFile = "";
		ResultSet rs = null;
		try {
			PreparedStatement stmt = dbConn.prepareStatement(SELECT_NODEID_BY_INTERFACE);
			stmt.setString(1, ipAddress);
			rs = stmt.executeQuery();
			while (rs.next()) {
				nodeId = rs.getInt(1);
			}
			if (directory_repository.endsWith("/") == false && directory_repository.endsWith(File.separator) == false) {
				directory_repository += File.separator;
			}
			nodeDirectory_repository = directory_repository + nodeId;
		} catch (SQLException s) {
			try {
				dbConn.rollback();
			} catch (SQLException sqle) {
				log.error("Unable to rollback on db. " + sqle);
			}
			log.error("Unable to read from DB");
			saveMessage = "Unable to save " + inventoryType + " configuration.<br>";
			return InventoryMonitor.CONFIGURATION_NOT_SAVED;
		}
		rs = null;
		try {
			PreparedStatement stmt = dbConn.prepareStatement(SELECT_PATHTOFILE);
			stmt.setInt(1, nodeId);
			stmt.setString(2, inventoryType);
			stmt.setString(3, "A");
			rs = stmt.executeQuery();
			String newDirRep = nodeDirectory_repository;
			while (rs.next()) {
				oldPathToFile = rs.getString(1);
			}
			long time = System.currentTimeMillis();
			if (path.startsWith("/") == false && path.startsWith(File.separator) == false) {
				newDirRep += File.separator;
			}
			Timestamp currTime = new Timestamp(time);
			SimpleDateFormat ObjectformatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.util.Date currTimeDate = new java.util.Date(currTime.getTime());
			newPathToFile = newDirRep + path + "[" + ObjectformatDate.format(currTimeDate) + "]";
		} catch (SQLException s) {
			log.error("Unable to read from DB");
			try {
				dbConn.rollback();
			} catch (SQLException sqle) {
				log.error("Unable to rollback on db. " + sqle);
			}
			saveMessage = "Unable to save " + inventoryType + " configuration.<br>";
			return InventoryMonitor.CONFIGURATION_NOT_SAVED;
		}
		rs = null;
		int returnValue = InventoryMonitor.CONFIGURATION_SAVED;
		int found = -1;
		long time = System.currentTimeMillis();
		try {
			PreparedStatement stmt = dbConn.prepareStatement(COUNT_NODEID_CONFIGURATION_NAME);
			stmt.setInt(1, nodeId);
			stmt.setString(2, inventoryType);
			rs = stmt.executeQuery();
			while (rs.next()) {
				found = rs.getInt(1);
			}
		} catch (SQLException s) {
			log.error("Unable to read from DB");
			log.error(s);
			try {
				dbConn.rollback();
			} catch (SQLException sqle) {
				log.error("Unable to rollback on db. " + sqle);
			}
			saveMessage = "Unable to save " + inventoryType + " configuration.<br>";
			return InventoryMonitor.CONFIGURATION_NOT_SAVED;
		}
		Timestamp currentTime = new Timestamp(time);
		rs = null;
		if (found > 0) {
			if (compareResult == InventoryMonitor.CONFIGURATION_CHANGED
					|| compareResult == InventoryMonitor.FIRST_ACTIVE_CONFIGURATION_DOWNLOAD) {
				try {
					log.debug("FOUND=" + found + " row/s in configuration, UPDATE it");
					PreparedStatement stmt = dbConn.prepareStatement(UPDATE_CONFIGURATION_TO_STATUS_N);
					stmt.setInt(1, nodeId);
					stmt.setString(2, inventoryType);
					stmt.executeUpdate();
				} catch (SQLException s) {
					log.error("Unable to update DB" + s);
					try {
						dbConn.rollback();
					} catch (SQLException sqle) {
						log.error("Unable to rollback on db. " + sqle);
					}
					saveMessage = "Unable to save " + inventoryType + " configuration.<br>";
					return InventoryMonitor.CONFIGURATION_NOT_SAVED;
				}
				try {
					PreparedStatement stmt = dbConn.prepareStatement(INSERT_IN_CONFIGURATION);
					stmt.setInt(1, nodeId);
					stmt.setTimestamp(2, currentTime);
					stmt.setTimestamp(3, currentTime);
					stmt.setString(4, inventoryType);
					stmt.setString(5, newPathToFile);
					stmt.execute();
				} catch (SQLException s) {
					log.error("Unable to insert in DB");
					log.error(s);
					try {
						dbConn.rollback();
					} catch (SQLException sqle) {
						log.error("Unable to rollback on db. " + sqle);
					}
					saveMessage = "Unable to save " + inventoryType + " configuration.<br>";
					return InventoryMonitor.CONFIGURATION_NOT_SAVED;
				}
			} else {
				try {
					log.debug("FOUND=" + found + " row/s in configuration, UPDATE it");
					PreparedStatement stmt = dbConn.prepareStatement(UPDATE_LASTPOLLTIME_PATHTOFILE);
					stmt.setTimestamp(1, currentTime);
					stmt.setString(2, newPathToFile);
					stmt.setInt(3, nodeId);
					stmt.setString(4, inventoryType);
					stmt.executeUpdate();
					renameFile = true;
				} catch (SQLException s) {
					log.error("Unable to update DB");
					log.error(s);
					try {
						dbConn.rollback();
					} catch (SQLException sqle) {
						log.error("Unable to rollback on db. " + sqle);
					}
					saveMessage = "Unable to save " + inventoryType + " configuration.<br>";
					return InventoryMonitor.CONFIGURATION_NOT_SAVED;
				}
			}
			try {
				dbConn.commit();
			} catch (SQLException s) {
				log.error("Unable to commit to DB " + s);
				try {
					dbConn.rollback();
				} catch (SQLException sqle) {
					log.error("Unable to rollback on db. " + sqle);
				}
				return InventoryMonitor.CONFIGURATION_NOT_SAVED;
			}
		} else {
			try {
				PreparedStatement stmt = dbConn.prepareStatement(INSERT_IN_CONFIGURATION);
				stmt.setInt(1, nodeId);
				stmt.setTimestamp(2, currentTime);
				stmt.setTimestamp(3, currentTime);
				stmt.setString(4, inventoryType);
				stmt.setString(5, newPathToFile);
				stmt.execute();
			} catch (SQLException s) {
				log.error("Unable to insert in DB");
				log.error(s);
				try {
					dbConn.rollback();
				} catch (SQLException sqle) {
					log.error("Unable to rollback on db. " + sqle);
				}
				saveMessage = "Unable to save " + inventoryType + " configuration.<br>";
				return InventoryMonitor.CONFIGURATION_NOT_SAVED;
			}
		}
		found = -1;
		time = System.currentTimeMillis();
		try {
			PreparedStatement stmt = dbConn.prepareStatement(COUNT_NODEID_IN_ASSET);
			stmt.setInt(1, nodeId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				found = rs.getInt(1);
			}
		} catch (SQLException s) {
			log.error("Unable to write into DB");
			log.error(s);
			try {
				dbConn.rollback();
			} catch (SQLException sqle) {
				log.error("Unable to rollback on db. " + sqle);
			}
			saveMessage = "Unable to save " + inventoryType + " configuration.<br>";
			return InventoryMonitor.CONFIGURATION_NOT_SAVED;
		}
		currentTime = new Timestamp(time);
		if (found > 0) {
			try {
				log.debug("Found " + found + " rows in table assets: UPDATE it");
				String queryParam = "";
				Iterator dbColumnIter = asset.keySet().iterator();
				int counter = 0;
				while (dbColumnIter.hasNext()) {
					String currDbColumn = (String) dbColumnIter.next();
					counter++;
					String dataItem = (String) asset.get(currDbColumn);
					dataItem = dataItem.replaceAll("[ \t]+", " ");
					queryParam += currDbColumn + "='" + dataItem + "',";
				}
				if (counter > 0) {
					String updateAssets = "UPDATE assets SET  " + queryParam + " lastmodifieddate=? WHERE nodeID =?";
					PreparedStatement stmt = dbConn.prepareStatement(updateAssets);
					stmt.setTimestamp(1, currentTime);
					stmt.setInt(2, nodeId);
					log.debug("UPDATEQUERY " + updateAssets);
					stmt.executeUpdate();
				}
			} catch (SQLException s) {
				log.error("Unable to update DB" + s);
				try {
					dbConn.rollback();
				} catch (SQLException sqle) {
					log.error("Unable to rollback on db. " + sqle);
				}
				saveMessage = "Unable to save " + inventoryType + " configuration.<br>";
				return InventoryMonitor.CONFIGURATION_NOT_SAVED;
			}
		} else {
			try {
				log.debug("row not found. INSERT into assets");
				InsertIntoAssets(dbConn);
			} catch (SQLException s) {
				log.error("Unable to insert in DB");
				log.error(s);
				try {
					dbConn.rollback();
				} catch (SQLException sqle) {
					log.error("Unable to rollback on db. " + sqle);
				}
				saveMessage = "Unable to save " + inventoryType + " configuration.<br>";
				return InventoryMonitor.CONFIGURATION_NOT_SAVED;
			}
		}
		try {
			dbConn.commit();
		} catch (SQLException sqle) {
			log.error("Unable to save into DB" + sqle);
			try {
				dbConn.rollback();
			} catch (SQLException sqlex) {
				log.error("Unable to rollback on db. " + sqlex);
			}
			saveMessage = "Unable to save " + inventoryType + " configuration.<br>";
			return InventoryMonitor.CONFIGURATION_NOT_SAVED;
		}
		try {
			boolean exists = (new File(directory_repository)).exists();
			if (!exists) {
				log.warn("file-repository '" + directory_repository + "' not found: trying to create it.");
				boolean success = (new File(directory_repository)).mkdir();
				if (!success) {
					log.error("Directory creation failed");
					try {
						dbConn.rollback();
					} catch (SQLException s) {
						log.error("Unable to rollback DB");
					}
					return InventoryMonitor.CONFIGURATION_NOT_SAVED;
				}
				log.warn("file-repository '" + directory_repository + "' created.");
			}
			exists = (new File(nodeDirectory_repository)).exists();
			if (!exists) {
				boolean success = (new File(nodeDirectory_repository)).mkdir();
				if (!success) {
					log.error("Node Directory '" + nodeDirectory_repository + "' creation failed.");
					saveMessage = "Unable to save " + inventoryType + " configuration.<br>";
					try {
						dbConn.rollback();
					} catch (SQLException s) {
						log.error("Unable to rollback DB");
					}
					return InventoryMonitor.CONFIGURATION_NOT_SAVED;
				}
			}
			exists = (new File(oldPathToFile)).exists();
			log.debug(oldPathToFile + " exists=" + exists);
			if (!exists) {
				if (renameCorruptedFile) {
					log.warn("renameCorruptedFile=true and old configuration doesn't exist.");
				}
				returnValue = InventoryMonitor.FIRST_ACTIVE_CONFIGURATION_DOWNLOAD;
			}
			if (renameCorruptedFile) {
				File f = new File(oldPathToFile);
				String oldConfigurationFileDestination = oldPathToFile + "_Corrupted";
				File dest = new File(oldConfigurationFileDestination);
				dest.createNewFile();
				f.renameTo(dest);
				FileWriter fileout = new FileWriter(newPathToFile);
				BufferedWriter filebufwri = new BufferedWriter(fileout);
				PrintWriter printout = new PrintWriter(filebufwri);
				printout.println(newInventory);
				printout.close();
			} else {
				if (renameFile) {
					File f = new File(oldPathToFile);
					File dest = new File(newPathToFile);
					dest.createNewFile();
					f.renameTo(dest);
				} else {
					FileWriter fileout = new FileWriter(newPathToFile);
					BufferedWriter filebufwri = new BufferedWriter(fileout);
					PrintWriter printout = new PrintWriter(filebufwri);
					printout.print(newInventory);
					printout.close();
				}
			}
		} catch (IOException ioex) {
			try {
				dbConn.rollback();
			} catch (SQLException s) {
				log.error("Unable to rollback DB");
			}
			log.error("Failed writing to file '" + newPathToFile + "'.");
			saveMessage = "Unable to save " + inventoryType + " configuration.<br>";
			return InventoryMonitor.CONFIGURATION_NOT_SAVED;
		} finally {
			try {
				dbConn.close();
			} catch (SQLException s) {
				log.error("Unable to close connection to DB");
			}
		}
		saveMessage = "inventory " + inventoryType + " success.<br>";
		log.debug("" + returnValue);
		return returnValue;
	}

}