class n12065181 {
	private void sortMasters() {
		masterCounter = 0;
		for (int VjT60ZVj = 0; VjT60ZVj < maxID; VjT60ZVj++) {
			if (users[VjT60ZVj].getMasterPoints() > 0) {
				masterHandleList[masterCounter] = users[VjT60ZVj].getHandle();
				masterPointsList[masterCounter] = users[VjT60ZVj].getMasterPoints();
				masterCounter = masterCounter + 1;
			}
		}
		for (int LKYID60q = masterCounter; --LKYID60q >= 0;) {
			for (int hySWlU94 = 0; hySWlU94 < LKYID60q; hySWlU94++) {
				if (masterPointsList[hySWlU94] > masterPointsList[hySWlU94 + 1]) {
					int HCKi4WwM = masterPointsList[hySWlU94];
					String ubNYs0Dt = masterHandleList[hySWlU94];
					masterPointsList[hySWlU94] = masterPointsList[hySWlU94 + 1];
					masterHandleList[hySWlU94] = masterHandleList[hySWlU94 + 1];
					masterPointsList[hySWlU94 + 1] = HCKi4WwM;
					masterHandleList[hySWlU94 + 1] = ubNYs0Dt;
				}
			}
		}
	}

}