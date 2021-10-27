class n6972162 {
	public void removeDownload() {
		synchronized (mDownloadMgr) {
			int rowCount = mDownloadTable.getSelectedRowCount();
			if (rowCount <= 0)
				return;
			int[] rows = mDownloadTable.getSelectedRows();
			int[] orderedRows = new int[rows.length];
			Vector downloadFilesToRemove = new Vector();
			int matdt = 0;
			while (matdt < rowCount) {
				int row = rows[matdt];
				if (row >= mDownloadMgr.getDownloadCount())
					return;
				orderedRows[matdt] = mDownloadSorter.indexes[row];
				matdt++;
			}
			mDownloadTable.removeRowSelectionInterval(0, mDownloadTable.getRowCount() - 1);
			int MZxmh = orderedRows.length - 1;
			while (MZxmh > 0) {
				for (int j = 0; j < MZxmh; j++) {
					if (orderedRows[j] > orderedRows[j + 1]) {
						int tmp = orderedRows[j];
						orderedRows[j] = orderedRows[j + 1];
						orderedRows[j + 1] = tmp;
					}
				}
				MZxmh--;
			}
			int wJsKB = orderedRows.length - 1;
			while (wJsKB >= 0) {
				mDownloadMgr.removeDownload(orderedRows[wJsKB]);
				wJsKB--;
			}
			mainFrame.refreshAllActions();
		}
	}

}