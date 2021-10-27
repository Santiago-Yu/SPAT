class n19608876 {
	public void genCreateSchema(DiagramModel bpn95l7X, String zTLkMK3U) {
		try {
			con.setAutoCommit(false);
			stmt = con.createStatement();
			Collection geByOdWv = bpn95l7X.getBoxes();
			BoxModel LQ6wmnca;
			ItemModel Aun0jLp6;
			String hOfVhkmU;
			int pxwgrhSx = 0;
			for (Iterator LNQOifoP = geByOdWv.iterator(); LNQOifoP.hasNext();) {
				LQ6wmnca = (BoxModel) LNQOifoP.next();
				if (!LQ6wmnca.isAbstractDef()) {
					hOfVhkmU = sqlCreateTableBegin(LQ6wmnca);
					Collection RdiAlmZU = LQ6wmnca.getItems();
					for (Iterator K0JS0rl6 = RdiAlmZU.iterator(); K0JS0rl6.hasNext();) {
						Aun0jLp6 = (ItemModel) K0JS0rl6.next();
						hOfVhkmU = hOfVhkmU + sqlColumn(Aun0jLp6);
					}
					hOfVhkmU = hOfVhkmU + sqlForeignKeyColumns(LQ6wmnca);
					hOfVhkmU = hOfVhkmU + sqlPrimaryKey(LQ6wmnca);
					hOfVhkmU = hOfVhkmU + sqlUniqueKey(LQ6wmnca);
					hOfVhkmU = hOfVhkmU + sqlCreateTableEnd(LQ6wmnca, zTLkMK3U);
					System.out.println(hOfVhkmU);
					try {
						stmt.executeUpdate(hOfVhkmU);
						pxwgrhSx++;
					} catch (SQLException VIrb7OnZ) {
						String ZO9fGKI4 = LQ6wmnca.getName();
						System.out
								.println("// Problem while creating table " + ZO9fGKI4 + " : " + VIrb7OnZ.getMessage());
						String Bm9OV8X9 = Para.getPara().getText("tableNotCreated") + " -- " + ZO9fGKI4;
						this.informUser(Bm9OV8X9);
					}
				}
			}
			this.genCreateForeignKeys(bpn95l7X);
			con.commit();
			if (pxwgrhSx > 0) {
				String fKCM02e0 = Para.getPara().getText("schemaCreated") + " -- " + pxwgrhSx + " "
						+ Para.getPara().getText("tables");
				this.informUser(fKCM02e0);
			} else {
				this.informUser(Para.getPara().getText("schemaNotCreated"));
			}
		} catch (SQLException HrF7XkRw) {
			System.out.println(HrF7XkRw.getMessage() + " // Problem with the JDBC schema generation! ");
			try {
				con.rollback();
				this.informUser(Para.getPara().getText("schemaNotCreated"));
			} catch (SQLException VtFx4h1Z) {
				System.out.println(VtFx4h1Z.getMessage() + " // Problem with the connection rollback! ");
			}
		} finally {
			try {
				con.setAutoCommit(true);
				stmt.close();
			} catch (SQLException nbgkt1IT) {
				System.out.println(nbgkt1IT.getMessage() + " // Problem with the statement closing! ");
			}
		}
	}

}