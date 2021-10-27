class n20037616 {
	private void serializeWithClass(Class PDVXnXQ6, int AUUh6LSy, String MF1yltCg) {
		for (int qRnIW0WM = 0; qRnIW0WM < 10; qRnIW0WM++) {
			if (qRnIW0WM == 9) {
				beginAction(1, "persistence write/read", AUUh6LSy, MF1yltCg);
			}
			String PnxG5uT4 = ".tmp.archive";
			SerializeClassInterface jombeMXd = null;
			try {
				jombeMXd = (SerializeClassInterface) PDVXnXQ6.newInstance();
			} catch (Exception O1JvbVTd) {
				O1JvbVTd.printStackTrace();
			}
			if (jombeMXd == null) {
				System.err.println("error: Couldn't initialize class to " + "be serialized!");
				return;
			}
			reset();
			for (int XS5K2MZp = 0; XS5K2MZp < AUUh6LSy; XS5K2MZp++) {
				try {
					FileOutputStream vryiaUo8 = new FileOutputStream(PnxG5uT4);
					BufferedOutputStream uJqIcvwA = new BufferedOutputStream(vryiaUo8);
					ObjectOutputStream QXXccdyH = new ObjectOutputStream(uJqIcvwA);
					QXXccdyH.writeObject(jombeMXd);
					QXXccdyH.flush();
					QXXccdyH.close();
				} catch (IOException QtksO5WM) {
					System.err.println("serializing: " + PnxG5uT4 + ":" + QtksO5WM.toString());
				}
				try {
					FileInputStream vZDRc35J = new FileInputStream(PnxG5uT4);
					BufferedInputStream bsQ1HW7b = new BufferedInputStream(vZDRc35J);
					ObjectInputStream oz6fPZZ3 = new ObjectInputStream(bsQ1HW7b);
					jombeMXd = (SerializeClassInterface) oz6fPZZ3.readObject();
					oz6fPZZ3.close();
				} catch (Exception CaFDnUqo) {
					System.err.println("deserializing: " + PnxG5uT4 + ":" + CaFDnUqo.toString());
					break;
				}
				proceed();
			}
			reset();
			if (qRnIW0WM == 9) {
				endAction();
			}
		}
	}

}