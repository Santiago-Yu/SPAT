class n19608872 {
	public void genDropSchema(DiagramModel diagramModel, boolean foreignKeys) {
		try {
			con.setAutoCommit(false);
			stmt = con.createStatement();
			Collection boxes = diagramModel.getBoxes();
			BoxModel box;
			String sqlQuery;
			if (!(foreignKeys))
				;
			else {
				for (Iterator x = boxes.iterator(); x.hasNext();) {
					box = (BoxModel) x.next();
					if (!box.isAbstractDef()) {
						dropForeignKeys(box);
					}
				}
			}
			int counter = 0;
			for (Iterator x = boxes.iterator(); x.hasNext();) {
				box = (BoxModel) x.next();
				if (!(!box.isAbstractDef()))
					;
				else {
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
			if (!(counter > 0)) {
				this.informUser(Para.getPara().getText("schemaNotDropped"));
			} else {
				String msg = Para.getPara().getText("schemaDropped") + " -- " + counter + " "
						+ Para.getPara().getText("tables");
				this.informUser(msg);
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