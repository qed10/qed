package http;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public  class miTM implements javax.net.ssl.TrustManager,
        javax.net.ssl.X509TrustManager {
    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }

    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }

    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}