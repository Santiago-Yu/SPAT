class n1908212{
    public static CMLUnitList createUnitList(URL url) throws IOException, CMLException {
        Document dictDoc = null;
        InputStream in = null;
        try {
            in = url.openStream();
            dictDoc = new CMLBuilder().build(in);
        } catch (NullPointerException e) {
            e.printStackTrace();
            throw new CMLException("NULL " + e.getMessage() + S_SLASH + e.getCause() + " in " + url);
        } catch (ValidityException e) {
            throw new CMLException(S_EMPTY + e.getMessage() + S_SLASH + e.getCause() + " in " + url);
        } catch (ParsingException e) {
            e.printStackTrace();
            throw new CMLException(e, " in " + url);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        CMLUnitList dt = null;
        if (dictDoc != null) {
            Element root = dictDoc.getRootElement();
            if (root instanceof CMLUnitList) {
                dt = new CMLUnitList((CMLUnitList) root);
            } else {
            }
        }
        if (dt != null) {
            dt.indexEntries();
        }
        return dt;
    }

}