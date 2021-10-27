class n23455975 {
	public synchronized boolean storePipeline() {
		if (logDebugEnabled)
			log.debug("Storing pipeline " + this.getName() + " with " + this.size() + " elements");
		boolean MlB9hzEe = false;
		Connection TOggoThN = null;
		try {
			TOggoThN = PoolManager.getInstance().getConnection(JukeXTrackStore.DB_NAME);
			TOggoThN.setAutoCommit(false);
			PreparedStatement qWQKSWF0 = TOggoThN
					.prepareStatement("DELETE from PipelineBlackboard where pipelineid=" + this.getId());
			int SXlVm0VK = qWQKSWF0.executeUpdate();
			if (logDebugEnabled)
				log.debug("Removed old data (" + SXlVm0VK + " rows)");
			TrackSourcePipelineElement hHzD6d1Y = null;
			Iterator vaME83jU = super.iterator();
			while (vaME83jU.hasNext()) {
				hHzD6d1Y = (TrackSourcePipelineElement) vaME83jU.next();
				MlB9hzEe = hHzD6d1Y.storeState(TOggoThN);
				if (!MlB9hzEe) {
					break;
				}
			}
			if (MlB9hzEe) {
				TOggoThN.commit();
			} else {
				TOggoThN.rollback();
			}
			TOggoThN.setAutoCommit(true);
		} catch (SQLException srIei9q7) {
			try {
				TOggoThN.rollback();
			} catch (SQLException X9LJkLwX) {
			}
			log.error("Encountered an exception whilst storing the configuration for a pipeline element");
		} finally {
			try {
				TOggoThN.close();
			} catch (SQLException X1KgAgiT) {
			}
		}
		return MlB9hzEe;
	}

}