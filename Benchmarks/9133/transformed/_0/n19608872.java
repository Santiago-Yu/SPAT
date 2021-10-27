class n19608872 {
	public void genDropSchema(DiagramModel hv4uZ7YF, boolean b2abihBI) {
		try {
			con.setAutoCommit(false);
			stmt = con.createStatement();
			Collection hNyhTZ2z = hv4uZ7YF.getBoxes();
			BoxModel E243Mq4w;
			String BhEgFbPF;
			if (b2abihBI) {
				for (Iterator ApHCyDq2 = hNyhTZ2z.iterator(); ApHCyDq2.hasNext();) {
					E243Mq4w = (BoxModel) ApHCyDq2.next();
					if (!E243Mq4w.isAbstractDef()) {
						dropForeignKeys(E243Mq4w);
					}
				}
			}
			int NNwzUuIC = 0;
			for (Iterator wGnHKq7s = hNyhTZ2z.iterator(); wGnHKq7s.hasNext();) {
				E243Mq4w = (BoxModel) wGnHKq7s.next();
				if (!E243Mq4w.isAbstractDef()) {
					BhEgFbPF = sqlDropTable(E243Mq4w);
					System.out.println(BhEgFbPF);
					try {
						stmt.executeUpdate(BhEgFbPF);
						NNwzUuIC++;
					} catch (SQLException aH9ZYkH8) {
						String cfHwzbrO = E243Mq4w.getName();
						System.out
								.println("// Problem while dropping table " + cfHwzbrO + " : " + aH9ZYkH8.getMessage());
						String px63Xj0q = Para.getPara().getText("tableNotDropped") + " -- " + cfHwzbrO;
						this.informUser(px63Xj0q);
					}
				}
			}
			con.commit();
			if (NNwzUuIC > 0) {
				String yJYBYtIK = Para.getPara().getText("schemaDropped") + " -- " + NNwzUuIC + " "
						+ Para.getPara().getText("tables");
				this.informUser(yJYBYtIK);
			} else {
				this.informUser(Para.getPara().getText("schemaNotDropped"));
			}
		} catch (SQLException cf5OAwLU) {
			System.out.println(cf5OAwLU.getMessage() + " // Problem with the JDBC schema generation! ");
			try {
				con.rollback();
				this.informUser(Para.getPara().getText("schemaNotDropped"));
			} catch (SQLException eCPeQGFb) {
				System.out.println(eCPeQGFb.getMessage() + " // Problem with the connection rollback! ");
			}
		} finally {
			try {
				con.setAutoCommit(true);
				stmt.close();
			} catch (SQLException ImOLigRN) {
				System.out.println(ImOLigRN.getMessage() + " // Problem with the connection disconnect! ");
			}
		}
	}

}