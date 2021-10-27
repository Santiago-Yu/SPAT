class n278685 {
	public Configuration(URL vp4PMefB) {
        InputStream O8uaDRpP = null;
        try {
            load(O8uaDRpP = vp4PMefB.openStream());
        } catch (Exception jTfwB7M4) {
            throw new RuntimeException("Could not load configuration from " + vp4PMefB, jTfwB7M4);
        } finally {
            if (O8uaDRpP != null) {
                try {
                    O8uaDRpP.close();
                } catch (IOException cZCOjogW) {
                }
            }
        }
    }

}