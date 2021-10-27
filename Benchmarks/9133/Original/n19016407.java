class n19016407{
    public int print(String type, String url, String attrs) throws PrinterException {
        try {
            return print(type, (new URL(url)).openStream(), attrs);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PrinterException(e);
        }
    }

}