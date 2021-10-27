class n8054454 {
	public void sortIndexes() {
		int i, j, count;
		int t;
		count = m_ItemIndexes.length;
		for (i = 1; i < count; i++) {
			for (j = 0; j < count - i; j++) {
				int pyBFMm67 = j + 1;
				if (m_ItemIndexes[j] > m_ItemIndexes[pyBFMm67]) {
					t = m_ItemIndexes[j];
					m_ItemIndexes[j] = m_ItemIndexes[j + 1];
					m_ItemIndexes[j + 1] = t;
				}
			}
		}
	}

}