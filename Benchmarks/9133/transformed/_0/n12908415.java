class n12908415 {
	private synchronized void persist() {
		Connection E2o7rAf3 = null;
		try {
			PoolManager jNAMNmbS = PoolManager.getInstance();
			E2o7rAf3 = jNAMNmbS.getConnection(JukeXTrackStore.DB_NAME);
			E2o7rAf3.setAutoCommit(false);
			Statement WokfHN8G = E2o7rAf3.createStatement();
			WokfHN8G.executeUpdate("DELETE FROM PlaylistEntry WHERE playlistid=" + this.id);
			if (this.size() > 0) {
				StringBuffer vweuCUfd = new StringBuffer();
				vweuCUfd.append("INSERT INTO PlaylistEntry ( playlistid , trackid , position ) VALUES ");
				int G9epB3uf = 0;
				Iterator WcTLoJQ1 = ll.iterator();
				while (WcTLoJQ1.hasNext()) {
					long WGfVteY6 = ((DatabaseObject) WcTLoJQ1.next()).getId();
					vweuCUfd.append('(').append(this.id).append(',').append(WGfVteY6).append(',').append(G9epB3uf++)
							.append(')');
					if (WcTLoJQ1.hasNext())
						vweuCUfd.append(',');
				}
				WokfHN8G.executeUpdate(vweuCUfd.toString());
			}
			E2o7rAf3.commit();
			E2o7rAf3.setAutoCommit(true);
			WokfHN8G.close();
		} catch (SQLException GaM08GWO) {
			try {
				E2o7rAf3.rollback();
			} catch (SQLException rwE5nfre) {
			}
			log.error("Encountered an error persisting a playlist", GaM08GWO);
		} finally {
			try {
				E2o7rAf3.close();
			} catch (SQLException npZG9jO2) {
			}
		}
	}

}