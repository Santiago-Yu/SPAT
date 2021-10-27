class n23455975 {
	public synchronized boolean storePipeline() {
		boolean retVal = false;
		if (logDebugEnabled)
			log.debug("Storing pipeline " + this.getName() + " with " + this.size() + " elements");
		Connection conn = null;
		try {
			conn = PoolManager.getInstance().getConnection(JukeXTrackStore.DB_NAME);
			conn.setAutoCommit(false);
			PreparedStatement ps = conn
					.prepareStatement("DELETE from PipelineBlackboard where pipelineid=" + this.getId());
			int rowCount = ps.executeUpdate();
			TrackSourcePipelineElement pe = null;
			if (logDebugEnabled)
				log.debug("Removed old data (" + rowCount + " rows)");
			Iterator i = super.iterator();
			while (i.hasNext()) {
				pe = (TrackSourcePipelineElement) i.next();
				retVal = pe.storeState(conn);
				if (!retVal) {
					break;
				}
			}
			if (retVal) {
				conn.commit();
			} else {
				conn.rollback();
			}
			conn.setAutoCommit(true);
		} catch (SQLException se) {
			try {
				conn.rollback();
			} catch (SQLException ignore) {
			}
			log.error("Encountered an exception whilst storing the configuration for a pipeline element");
		} finally {
			try {
				conn.close();
			} catch (SQLException ignore) {
			}
		}
		return retVal;
	}

}