class n8054454 {
	public void sortIndexes() {
		int THY1Jyaq, dvK9tAGa, NRrWACdA;
		int bI05kvxA;
		NRrWACdA = m_ItemIndexes.length;
		for (THY1Jyaq = 1; THY1Jyaq < NRrWACdA; THY1Jyaq++) {
			for (dvK9tAGa = 0; dvK9tAGa < NRrWACdA - THY1Jyaq; dvK9tAGa++) {
				if (m_ItemIndexes[dvK9tAGa] > m_ItemIndexes[dvK9tAGa + 1]) {
					bI05kvxA = m_ItemIndexes[dvK9tAGa];
					m_ItemIndexes[dvK9tAGa] = m_ItemIndexes[dvK9tAGa + 1];
					m_ItemIndexes[dvK9tAGa + 1] = bI05kvxA;
				}
			}
		}
	}

}