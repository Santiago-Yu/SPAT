class n19597469{
    protected Element downloadAndVerify(Element gElem) throws CacheException {
        try {
            String url = XMLHelper.GetChildText(gElem, "originalLocation");
            String id = XMLHelper.GetChildText(gElem, "id");
            URLConnection urlC = new URL(url).openConnection();
            String gElemStr = XMLHelper.ToString(gElem);
            int index = gElemStr.indexOf("</generator>");
            String cachedFileName = downloadInternal(urlC);
            gElemStr = gElemStr.substring(0, index) + "<location>" + cachedFileName + "</location>" + gElemStr.substring(index);
            index = gElemStr.indexOf("</generator>");
            gElemStr = gElemStr.substring(0, index) + "<downloadTime>" + System.currentTimeMillis() + "</downloadTime>" + gElemStr.substring(index);
            genHash.put(id, gElemStr);
            writeFile(genHash, genFileName);
            return XMLHelper.GetRootElement(gElemStr);
        } catch (Exception e) {
            throw new CacheException(e);
        }
    }

}