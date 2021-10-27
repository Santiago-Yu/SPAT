class n12214439 {
	public boolean saveNote(NoteData GP1zZeAq) {
		String ovVCX14d;
		try {
			conn.setAutoCommit(false);
			Statement ikdGlNvF = null;
			ResultSet uCrSPu97 = null;
			ikdGlNvF = conn.createStatement();
			ovVCX14d = "select * from notes where noteid = " + GP1zZeAq.getID();
			uCrSPu97 = ikdGlNvF.executeQuery(ovVCX14d);
			if (uCrSPu97.next()) {
				ovVCX14d = "UPDATE notes SET title = '" + escapeCharacters(GP1zZeAq.getTitle()) + "', keywords = '"
						+ escapeCharacters(GP1zZeAq.getKeywords()) + "' WHERE noteid = " + GP1zZeAq.getID();
				try {
					ikdGlNvF.executeUpdate(ovVCX14d);
				} catch (SQLException Or1SLQVo) {
					Or1SLQVo.printStackTrace();
					conn.rollback();
					conn.setAutoCommit(true);
					return false;
				}
				LinkedList<FieldData> lnFwHnfC = GP1zZeAq.getFields();
				ListIterator<FieldData> CdAhXYnH = lnFwHnfC.listIterator(0);
				FieldData Qnd9dkYw = null;
				PreparedStatement DFzbq937 = conn
						.prepareStatement("UPDATE fielddata SET data = ? WHERE noteid = ? AND fieldid = ?");
				try {
					while (CdAhXYnH.hasNext()) {
						Qnd9dkYw = CdAhXYnH.next();
						if (Qnd9dkYw instanceof FieldDataImage) {
							System.out.println("field is an image.");
							DFzbq937.setBytes(1, ((FieldDataImage) Qnd9dkYw).getDataBytes());
						} else {
							System.out.println("field is not an image");
							DFzbq937.setString(1, Qnd9dkYw.getData());
						}
						DFzbq937.setInt(2, GP1zZeAq.getID());
						DFzbq937.setInt(3, Qnd9dkYw.getID());
						DFzbq937.execute();
					}
				} catch (SQLException VgQXjujE) {
					conn.rollback();
					conn.setAutoCommit(true);
					VgQXjujE.printStackTrace();
					return false;
				}
				ovVCX14d = "DELETE FROM links WHERE (note1id = " + GP1zZeAq.getID() + " OR note2id = "
						+ GP1zZeAq.getID() + ")";
				try {
					ikdGlNvF.execute(ovVCX14d);
				} catch (SQLException McyasICK) {
					conn.rollback();
					conn.setAutoCommit(true);
					McyasICK.printStackTrace();
					return false;
				}
				Vector<Link> fo29OGJl = GP1zZeAq.getAssociations();
				ListIterator<Link> Veexrrn4 = fo29OGJl.listIterator();
				Link SGcHLvaY = null;
				DFzbq937 = conn.prepareStatement("INSERT INTO links (note1id, note2id) VALUES (?, ?)");
				try {
					while (Veexrrn4.hasNext()) {
						SGcHLvaY = Veexrrn4.next();
						DFzbq937.setInt(1, GP1zZeAq.getID());
						DFzbq937.setInt(2, SGcHLvaY.getID());
						DFzbq937.execute();
					}
				} catch (SQLException tXFJby6t) {
					conn.rollback();
					conn.setAutoCommit(true);
					tXFJby6t.printStackTrace();
					return false;
				}
			} else {
				ovVCX14d = "INSERT INTO notes (templateid, title, keywords) VALUES (" + GP1zZeAq.getTemplate().getID()
						+ ", '" + escapeCharacters(GP1zZeAq.getTitle()) + "', '"
						+ escapeCharacters(GP1zZeAq.getKeywords()) + "')";
				try {
					ikdGlNvF.executeUpdate(ovVCX14d);
				} catch (SQLException DIVrwTiG) {
					DIVrwTiG.printStackTrace();
					conn.rollback();
					conn.setAutoCommit(true);
					return false;
				}
				LinkedList<FieldData> nnBGTwy0 = GP1zZeAq.getFields();
				ListIterator<FieldData> b8KXgYJy = nnBGTwy0.listIterator(0);
				FieldData wtBGykzd = null;
				GP1zZeAq.setID(Integer.parseInt(executeMySQLGet("SELECT LAST_INSERT_ID()")));
				PreparedStatement nYJSsJyt;
				try {
					nYJSsJyt = conn.prepareStatement("INSERT INTO fielddata (noteid, fieldid, data) VALUES (?,?,?)");
					while (b8KXgYJy.hasNext()) {
						wtBGykzd = b8KXgYJy.next();
						if (wtBGykzd instanceof FieldDataImage) {
							System.out.println("field is an image.");
							nYJSsJyt.setBytes(3, ((FieldDataImage) wtBGykzd).getDataBytes());
						} else {
							System.out.println("field is not an image");
							nYJSsJyt.setString(3, wtBGykzd.getData());
						}
						nYJSsJyt.setInt(1, GP1zZeAq.getID());
						nYJSsJyt.setInt(2, wtBGykzd.getID());
						nYJSsJyt.execute();
					}
				} catch (SQLException N6pejNN5) {
					conn.rollback();
					conn.setAutoCommit(true);
					N6pejNN5.printStackTrace();
					return false;
				}
				Vector<Link> v8rBK0Qu = GP1zZeAq.getAssociations();
				Iterator<Link> wraAyQZm = v8rBK0Qu.listIterator();
				Link VBpZRX6D = null;
				nYJSsJyt = conn.prepareStatement("INSERT INTO links (note1id, note2id) VALUES (?,?)");
				try {
					while (wraAyQZm.hasNext()) {
						VBpZRX6D = wraAyQZm.next();
						nYJSsJyt.setInt(1, GP1zZeAq.getID());
						nYJSsJyt.setInt(2, VBpZRX6D.getID());
						nYJSsJyt.execute();
					}
				} catch (SQLException PklFYCW4) {
					conn.rollback();
					conn.setAutoCommit(true);
					PklFYCW4.printStackTrace();
					return false;
				}
			}
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException HwLU6NEB) {
			HwLU6NEB.printStackTrace();
			return false;
		}
		return true;
	}

}