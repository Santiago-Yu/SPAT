    public static void main(String[] args) {
        try {
            URL url = new URL(args[0]);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setDoOutput(true);
            httpCon.setRequestMethod("PUT");
            OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream());
            out.write("fatal error");
            out.close();
            System.out.println("end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
