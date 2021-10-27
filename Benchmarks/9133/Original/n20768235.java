class n20768235{
    public void initialize() {
        if (shieldings == null) {
            try {
                URL url = ClassLoader.getSystemResource(RF);
                InputStreamReader isr = new InputStreamReader(url.openStream());
                BufferedReader br = new BufferedReader(isr);
                SharcReader sr1 = new SharcReader(br);
                shieldings = new Hashtable();
                while (sr1.hasNext()) {
                    SharcShielding ss1 = sr1.next();
                    shieldings.put(ss1.getMethod(), ss1);
                }
                String[] shieldingNames = new String[shieldings.size()];
                int i = 0;
                for (Enumeration k = shieldings.keys(); k.hasMoreElements(); ) {
                    shieldingNames[i] = (String) k.nextElement();
                    i++;
                }
                dialog = new SelectSharcReference(null, shieldingNames, true);
            } catch (Exception ex) {
                shieldings = null;
            }
        }
    }

}