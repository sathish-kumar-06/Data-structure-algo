package designpattern.creational;

public class UrlBuilderDriver {
    public static void main(String[] args) {
        UrlBuilder.Builder builder = new UrlBuilder.Builder();
        builder.protocal("https://").hostName("sathish").portNo(":0618");
        UrlBuilder urlBuilder = builder.build();

        System.out.print(urlBuilder.protocal);
        System.out.print(urlBuilder.hostName);
        System.out.print(urlBuilder.portNo);
        System.out.println();
        UrlBuilder.Builder builderTwo = new UrlBuilder.Builder();
        builder.protocal("https://").hostName("sathish.com").pathParam("/v1");
        UrlBuilder urlBuilderTwo = builder.build();
        System.out.print(urlBuilderTwo.protocal);
        System.out.print(urlBuilderTwo.hostName);
        System.out.print(urlBuilderTwo.portNo);
    }
}
