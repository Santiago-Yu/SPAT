class n16908849 {
	public static void changeStructure(double KkApe2as) throws DException {
		try {
			Class yZaxZPkL = Class
					.forName("com.daffodilwoods.daffodildb.server.datadictionarysystem.SystemTablesCreator");
			java.net.URL lgkP6kPB = yZaxZPkL
					.getResource("/com/daffodilwoods/daffodildb/server/datadictionarysystem/systemtablesStructure.obj");
			ObjectInputStream mrPbC7Li = new ObjectInputStream(new BufferedInputStream(lgkP6kPB.openStream()));
			structureMap = (HashMap) mrPbC7Li.readObject();
			if (KkApe2as >= 3.4) {
				Object[][] aB5hSoQo = (Object[][]) structureMap.get((Object) SystemTables.columns_TableName);
				aB5hSoQo[9][2] = new Integer(1027);
			}
			mrPbC7Li.close();
		} catch (IOException UEERU6kb) {
		} catch (ClassNotFoundException hsIfiI6l) {
		}
	}

}