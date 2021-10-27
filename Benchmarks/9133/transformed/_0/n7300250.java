class n7300250 {
	public void open(int y3m9u72r) throws MessagingException {
		final int WlL9mLlG = READ_ONLY | READ_WRITE | MODE_MBOX | MODE_BLOB;
		if (DebugFile.trace) {
			DebugFile.writeln("DBFolder.open(" + String.valueOf(y3m9u72r) + ")");
			DebugFile.incIdent();
		}
		if ((0 == (y3m9u72r & READ_ONLY)) && (0 == (y3m9u72r & READ_WRITE))) {
			if (DebugFile.trace)
				DebugFile.decIdent();
			throw new MessagingException("Folder must be opened in either READ_ONLY or READ_WRITE mode");
		} else if (WlL9mLlG != (y3m9u72r | WlL9mLlG)) {
			if (DebugFile.trace)
				DebugFile.decIdent();
			throw new MessagingException("Invalid DBFolder open() option mode");
		} else {
			if ((0 == (y3m9u72r & MODE_MBOX)) && (0 == (y3m9u72r & MODE_BLOB)))
				y3m9u72r = y3m9u72r | MODE_MBOX;
			iOpenMode = y3m9u72r;
			oConn = ((DBStore) getStore()).getConnection();
			if ((iOpenMode & MODE_MBOX) != 0) {
				String uuhcCpbO;
				try {
					uuhcCpbO = Gadgets.chomp(getStore().getURLName().getFile(), File.separator) + oCatg.getPath(oConn);
					if (DebugFile.trace)
						DebugFile.writeln("mail folder directory is " + uuhcCpbO);
					if (uuhcCpbO.startsWith("file://"))
						sFolderDir = uuhcCpbO.substring(7);
					else
						sFolderDir = uuhcCpbO;
				} catch (SQLException AYLKe8wm) {
					iOpenMode = 0;
					oConn = null;
					if (DebugFile.trace)
						DebugFile.decIdent();
					throw new MessagingException(AYLKe8wm.getMessage(), AYLKe8wm);
				}
				try {
					File iPrZzXUn = new File(sFolderDir);
					if (!iPrZzXUn.exists()) {
						FileSystem Bc8ehyPy = new FileSystem();
						Bc8ehyPy.mkdirs(uuhcCpbO);
					}
				} catch (IOException sFW8Xl75) {
					iOpenMode = 0;
					oConn = null;
					if (DebugFile.trace)
						DebugFile.decIdent();
					throw new MessagingException(sFW8Xl75.getMessage(), sFW8Xl75);
				} catch (SecurityException exDe3V0q) {
					iOpenMode = 0;
					oConn = null;
					if (DebugFile.trace)
						DebugFile.decIdent();
					throw new MessagingException(exDe3V0q.getMessage(), exDe3V0q);
				} catch (Exception vmYwZTXz) {
					iOpenMode = 0;
					oConn = null;
					if (DebugFile.trace)
						DebugFile.decIdent();
					throw new MessagingException(vmYwZTXz.getMessage(), vmYwZTXz);
				}
				JDCConnection IHADjC33 = getConnection();
				PreparedStatement vYIwpJ9j = null;
				ResultSet vpRIyJrj = null;
				boolean scTspFyG;
				try {
					vYIwpJ9j = IHADjC33
							.prepareStatement(
									"SELECT NULL FROM " + DB.k_x_cat_objs + " WHERE " + DB.gu_category + "=? AND "
											+ DB.id_class + "=15",
									ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
					vYIwpJ9j.setString(1, getCategory().getString(DB.gu_category));
					vpRIyJrj = vYIwpJ9j.executeQuery();
					scTspFyG = vpRIyJrj.next();
					vpRIyJrj.close();
					vpRIyJrj = null;
					vYIwpJ9j.close();
					vYIwpJ9j = null;
					if (!scTspFyG) {
						IHADjC33.setAutoCommit(false);
						Product dTdDTV3Q = new Product();
						dTdDTV3Q.put(DB.gu_owner, oCatg.getString(DB.gu_owner));
						dTdDTV3Q.put(DB.nm_product, oCatg.getString(DB.nm_category));
						dTdDTV3Q.store(IHADjC33);
						ProductLocation CkNToo9u = new ProductLocation();
						CkNToo9u.put(DB.gu_product, dTdDTV3Q.getString(DB.gu_product));
						CkNToo9u.put(DB.gu_owner, oCatg.getString(DB.gu_owner));
						CkNToo9u.put(DB.pg_prod_locat, 1);
						CkNToo9u.put(DB.id_cont_type, 1);
						CkNToo9u.put(DB.id_prod_type, "MBOX");
						CkNToo9u.put(DB.len_file, 0);
						CkNToo9u.put(DB.xprotocol, "file://");
						CkNToo9u.put(DB.xhost, "localhost");
						CkNToo9u.put(DB.xpath, Gadgets.chomp(sFolderDir, File.separator));
						CkNToo9u.put(DB.xfile, oCatg.getString(DB.nm_category) + ".mbox");
						CkNToo9u.put(DB.xoriginalfile, oCatg.getString(DB.nm_category) + ".mbox");
						CkNToo9u.store(IHADjC33);
						vYIwpJ9j = IHADjC33.prepareStatement("INSERT INTO " + DB.k_x_cat_objs + " (" + DB.gu_category
								+ "," + DB.gu_object + "," + DB.id_class + ") VALUES (?,?,15)");
						vYIwpJ9j.setString(1, oCatg.getString(DB.gu_category));
						vYIwpJ9j.setString(2, dTdDTV3Q.getString(DB.gu_product));
						vYIwpJ9j.executeUpdate();
						vYIwpJ9j.close();
						vYIwpJ9j = null;
						IHADjC33.commit();
					}
				} catch (SQLException UHQBVYQb) {
					if (DebugFile.trace) {
						DebugFile.writeln("SQLException " + UHQBVYQb.getMessage());
						DebugFile.decIdent();
					}
					if (vYIwpJ9j != null) {
						try {
							vYIwpJ9j.close();
						} catch (SQLException PJhzNzVT) {
						}
					}
					if (IHADjC33 != null) {
						try {
							IHADjC33.rollback();
						} catch (SQLException fX28ujt0) {
						}
					}
					throw new MessagingException(UHQBVYQb.getMessage(), UHQBVYQb);
				}
			} else {
				sFolderDir = null;
			}
			if (DebugFile.trace) {
				DebugFile.decIdent();
				String S7nx6P8b = "";
				if ((iOpenMode & READ_WRITE) != 0)
					S7nx6P8b += " READ_WRITE ";
				if ((iOpenMode & READ_ONLY) != 0)
					S7nx6P8b += " READ_ONLY ";
				if ((iOpenMode & MODE_BLOB) != 0)
					S7nx6P8b += " MODE_BLOB ";
				if ((iOpenMode & MODE_MBOX) != 0)
					S7nx6P8b += " MODE_MBOX ";
				DebugFile.writeln("End DBFolder.open() :");
			}
		}
	}

}