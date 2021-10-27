class n458662 {
	public Configuration(URL bi8CHSr3) {
        InputStream kg4OIiG3 = null;
        try {
            load(kg4OIiG3 = bi8CHSr3.openStream());
        } catch (Exception JrFvwO1j) {
            throw new RuntimeException("Could not load configuration from " + bi8CHSr3, JrFvwO1j);
        } finally {
            if (kg4OIiG3 != null) {
                try {
                    kg4OIiG3.close();
                } catch (IOException YDzB9oCm) {
                }
            }
        }
    }

}