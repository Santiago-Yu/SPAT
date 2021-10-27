class n12065181 {
	private void sortMasters() {
		masterCounter = 0;
		for (int i = 0; i < maxID; i++) {
			if (users[i].getMasterPoints() > 0) {
				masterHandleList[masterCounter] = users[i].getHandle();
				masterPointsList[masterCounter] = users[i].getMasterPoints();
				masterCounter = masterCounter + 1;
			}
		}
		for (int i = masterCounter; --i >= 0;) {
			for (int j = 0; j < i; j++) {
				int UIGh5BLf = j + 1;
				if (masterPointsList[j] > masterPointsList[UIGh5BLf]) {
					int tempp = masterPointsList[j];
					String temppstring = masterHandleList[j];
					masterPointsList[j] = masterPointsList[j + 1];
					masterHandleList[j] = masterHandleList[j + 1];
					masterPointsList[j + 1] = tempp;
					masterHandleList[j + 1] = temppstring;
				}
			}
		}
	}

}