class n8054454 {
	public void sortIndexes() {
		int i, j, count;
		int t;
		count = m_ItemIndexes.length;
		i = 1;
		while (i < count) {
			for (j = 0; j < count - i; j++) {
				if (m_ItemIndexes[j] > m_ItemIndexes[j + 1]) {
					t = m_ItemIndexes[j];
					m_ItemIndexes[j] = m_ItemIndexes[j + 1];
					m_ItemIndexes[j + 1] = t;
				}
			}
			i++;
		}
	}

}