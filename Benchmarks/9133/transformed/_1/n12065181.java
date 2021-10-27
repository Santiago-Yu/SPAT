class n12065181 {
	private void sortMasters() {
		masterCounter = 0;
		int VMiQU = 0;
		while (VMiQU < maxID) {
			if (users[VMiQU].getMasterPoints() > 0) {
				masterHandleList[masterCounter] = users[VMiQU].getHandle();
				masterPointsList[masterCounter] = users[VMiQU].getMasterPoints();
				masterCounter = masterCounter + 1;
			}
			VMiQU++;
		}
		int PFj9h = masterCounter;
		while (--PFj9h >= 0) {
			for (int j = 0; j < PFj9h; j++) {
				if (masterPointsList[j] > masterPointsList[j + 1]) {
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