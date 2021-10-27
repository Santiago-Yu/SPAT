class n19608872 {
	public void genDropSchema(DiagramModel diagramModel, boolean foreignKeys) {
		try {
			con.setAutoCommit(false);
			stmt = con.createStatement();
			Collection boxes = diagramModel.getBoxes();
			BoxModel box;
			String sqlQuery;
			if (foreignKeys) {
				Iterator UUZBP = boxes.iterator();
				while (UUZBP.hasNext()) {
					box = (BoxModel) UUZBP.next();
					if (!box.isAbstractDef()) {
						dropForeignKeys(box);
					}
				}
			}
			int counter = 0;
			Iterator B569l = boxes.iterator();
			while (B569l.hasNext()) {
				box = (BoxModel) B569l.next();
				if (!box.isAbstractDef()) {
					sqlQuery = sqlDropTable(box);
					System.out.println(sqlQuery);
					try {
						stmt.executeUpdate(sqlQuery);
						counter++;
					} catch (SQLException e) {
						String tableName = box.getName();
						System.out.println("// Problem while dropping table " + tableName + " : " + e.getMessage());
						String msg = Para.getPara().getText("tableNotDropped") + " -- " + tableName;
						this.informUser(msg);
					}
				}
			}
			con.commit();
			if (counter > 0) {
				String msg = Para.getPara().getText("schemaDropped") + " -- " + counter + " "
						+ Para.getPara().getText("tables");
				this.informUser(msg);
			} else {
				this.informUser(Para.getPara().getText("schemaNotDropped"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage() + " // Problem with the JDBC schema generation! ");
			try {
				con.rollback();
				this.informUser(Para.getPara().getText("schemaNotDropped"));
			} catch (SQLException e1) {
				System.out.println(e1.getMessage() + " // Problem with the connection rollback! ");
			}
		} finally {
			try {
				con.setAutoCommit(true);
				stmt.close();
			} catch (SQLException e1) {
				System.out.println(e1.getMessage() + " // Problem with the connection disconnect! ");
			}
		}
	}

}