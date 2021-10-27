class n14800928{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        HttpURLConnection httpConn = null;
        byte[] result = null;
        try {
            byte[] bytes = HttpUtil.getHttpURLReturnData(request);
            if (-1 == bytes.length || 23 > bytes.length) throw new Exception();
            MsgPrint.showMsg("========byte length" + bytes.length);
            String userTag = request.getParameter("userTag");
            String isEncrypt = request.getParameter("isEncrypt");
            URL httpurl = new URL(ProtocolContanst.TRANSFERS_URL + userTag + "&isEncrypt=" + isEncrypt);
            httpConn = (HttpURLConnection) httpurl.openConnection();
            httpConn.setDoOutput(true);
            httpConn.setRequestProperty("Content-Length", String.valueOf(bytes.length));
            OutputStream outputStream = httpConn.getOutputStream();
            outputStream.write(bytes);
            outputStream.close();
            InputStream is = httpConn.getInputStream();
            if (0 >= httpConn.getContentLength()) {
                throw new Exception();
            }
            byte[] resultBytes = new byte[httpConn.getContentLength()];
            byte[] tempByte = new byte[1024];
            int length = 0;
            int index = 0;
            while ((length = is.read(tempByte)) != -1) {
                System.arraycopy(tempByte, 0, resultBytes, index, length);
                index += length;
            }
            is.close();
            result = resultBytes;
        } catch (Exception e) {
        }
        ServletOutputStream sos = response.getOutputStream();
        if (null != result) {
            response.setContentLength(result.length);
            sos.write(result);
        } else {
            response.setContentLength(26);
            sos.write(new byte[] { 48, 48, 55, -23, 3, 56, 49, 54, 57, 55, 49, 51, 54, 72, 71, 52, 48, 1, 3, 3, 48, 48, 48, 48, 48, 48 });
        }
        sos.flush();
        sos.close();
    }

}