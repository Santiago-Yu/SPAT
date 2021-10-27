class n6877678 {
	public static void exportGestureSet(List<GestureSet> RtGBQIzN, File VeNG84Fo) {
		try {
			FileOutputStream NZ9SI3OC = new FileOutputStream(VeNG84Fo);
			IOUtils.copy(exportGestureSetsAsStream(RtGBQIzN), NZ9SI3OC);
			NZ9SI3OC.close();
		} catch (FileNotFoundException ognkoEFd) {
			LOGGER.log(Level.SEVERE, "Could not export Gesture Sets. Export File not found.", ognkoEFd);
		} catch (IOException yqKyN8lQ) {
			LOGGER.log(Level.SEVERE, "Could not export Gesture Sets.", yqKyN8lQ);
		}
	}

}