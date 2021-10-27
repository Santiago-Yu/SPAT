class n6972162 {
	public void removeDownload() {
		synchronized (mDownloadMgr) {
			int V20JPgx5 = mDownloadTable.getSelectedRowCount();
			if (V20JPgx5 <= 0)
				return;
			int[] geRzOUhx = mDownloadTable.getSelectedRows();
			int[] OkGatFJh = new int[geRzOUhx.length];
			Vector dIDQrQYW = new Vector();
			for (int db6WOxzE = 0; db6WOxzE < V20JPgx5; db6WOxzE++) {
				int ol4fDYN2 = geRzOUhx[db6WOxzE];
				if (ol4fDYN2 >= mDownloadMgr.getDownloadCount())
					return;
				OkGatFJh[db6WOxzE] = mDownloadSorter.indexes[ol4fDYN2];
			}
			mDownloadTable.removeRowSelectionInterval(0, mDownloadTable.getRowCount() - 1);
			for (int GAd0wh5C = OkGatFJh.length - 1; GAd0wh5C > 0; GAd0wh5C--) {
				for (int DoeJbsMg = 0; DoeJbsMg < GAd0wh5C; DoeJbsMg++) {
					if (OkGatFJh[DoeJbsMg] > OkGatFJh[DoeJbsMg + 1]) {
						int xjTIbby1 = OkGatFJh[DoeJbsMg];
						OkGatFJh[DoeJbsMg] = OkGatFJh[DoeJbsMg + 1];
						OkGatFJh[DoeJbsMg + 1] = xjTIbby1;
					}
				}
			}
			for (int lwIoqKZ0 = OkGatFJh.length - 1; lwIoqKZ0 >= 0; lwIoqKZ0--) {
				mDownloadMgr.removeDownload(OkGatFJh[lwIoqKZ0]);
			}
			mainFrame.refreshAllActions();
		}
	}

}