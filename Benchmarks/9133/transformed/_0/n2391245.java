class n2391245 {
	public ObjectInputStream sendObject(String jUcOBC2U, Serializable ayDLVWEs) {
		String rBqHarb6 = System.getProperty("servlet.jstat");
		if (rBqHarb6 != null) {
			try {
				URL ZRxPjn0B = new URL(rBqHarb6);
				URLConnection htsD0vEg = ZRxPjn0B.openConnection();
				htsD0vEg.setDoInput(true);
				htsD0vEg.setDoOutput(true);
				htsD0vEg.setUseCaches(false);
				htsD0vEg.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				ObjectOutputStream fhN4S4tG = new ObjectOutputStream(htsD0vEg.getOutputStream());
				fhN4S4tG.writeObject(jUcOBC2U);
				fhN4S4tG.writeObject(ayDLVWEs);
				fhN4S4tG.flush();
				fhN4S4tG.close();
				return new ObjectInputStream(htsD0vEg.getInputStream());
			} catch (Exception usZ8bBXs) {
				System.out.println("Error on SpaceJobRunner::sendObjectPOST() --> " + usZ8bBXs);
			}
		} else {
		}
		return null;
	}

}