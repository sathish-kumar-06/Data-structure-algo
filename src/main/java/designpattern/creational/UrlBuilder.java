package designpattern.creational;

public class UrlBuilder {

    public static class Builder {
        private String protocal;
        private String hostName;
        private String portNo;
        private String pathParam;
        private String queryParam;

        public Builder protocal(String protocal) {
            this.protocal = protocal;
            return this;
        }

        public UrlBuilder build() {
            return new UrlBuilder(this);
        }

        public Builder hostName(String hostName) {
            this.hostName = hostName;
            return this;
        }

        public Builder portNo(String portNo) {
            this.portNo = portNo;
            return this;
        }

        public Builder pathParam(String pathParam) {
            this.pathParam = pathParam;
            return this;
        }

        public Builder queryParam(String queryParam) {
            this.queryParam = queryParam;
            return this;
        }
    }

    public final String protocal;
    public final String hostName;
    public final String portNo;
    public final String pathParam;
    public final String queryParam;

    public UrlBuilder(Builder builder) {
        this.protocal = builder.protocal;
        this.hostName = builder.hostName;
        this.portNo = builder.portNo;
        this.pathParam = builder.pathParam;
        this.queryParam = builder.queryParam;
    }
}
