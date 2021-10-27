class n21770019 {
	protected NetQuery(String PJDmW2Cb, String LAgtZPdB, byte OIOm8Q3r, String yOlB9wRC, int QFVTj4In) {
        String KWh6gPW5 = null;
        try {
            queryString = LAgtZPdB;
            char TXATnOfA = PJDmW2Cb.indexOf('?') == -1 ? '?' : '&';
            if (OIOm8Q3r == Query.UPDATE_TYPE) KWh6gPW5 = PJDmW2Cb; else {
                KWh6gPW5 = PJDmW2Cb + TXATnOfA + "query=" + URLEncoder.encode(LAgtZPdB, "UTF-8");
                TXATnOfA = '&';
                if (yOlB9wRC != null) KWh6gPW5 += TXATnOfA + "default-graph-uri=" + yOlB9wRC;
            }
            URL AqfWH2DU = new URL(KWh6gPW5);
            conn = (HttpURLConnection) AqfWH2DU.openConnection();
            configureConnection(LAgtZPdB, OIOm8Q3r, QFVTj4In, yOlB9wRC);
        } catch (UnsupportedEncodingException ozlrdEfp) {
            System.err.println(ozlrdEfp.toString());
            ozlrdEfp.printStackTrace();
            System.exit(-1);
        } catch (MalformedURLException gsSGjpZB) {
            System.err.println(gsSGjpZB.toString() + " for URL: " + KWh6gPW5);
            System.err.println(PJDmW2Cb);
            gsSGjpZB.printStackTrace();
            System.exit(-1);
        } catch (IOException EXRmnXIT) {
            System.err.println(EXRmnXIT.toString());
            EXRmnXIT.printStackTrace();
            System.exit(-1);
        }
    }

}