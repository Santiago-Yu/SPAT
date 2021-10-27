class n5621039 {
	public ScriptInfoList getScriptList() {
		ScriptInfoList nh6XMitv = null;
		try {
			URL PLeRKay7 = new URL(SCRIPT_URL + "?customer=" + customerID);
			ObjectInputStream EijIgPpZ = new ObjectInputStream(PLeRKay7.openStream());
			nh6XMitv = (ScriptInfoList) EijIgPpZ.readObject();
			EijIgPpZ.close();
			System.out.println("got script list");
		} catch (Exception X4TLXA7j) {
			X4TLXA7j.printStackTrace();
		}
		return nh6XMitv;
	}

}