package acac.airbnb.be.model;

import lombok.Getter;

public class OAuthToken {
    @Getter
    private String access_token;
    @Getter
    private String token_type;
    @Getter
    private String refresh_token;
    @Getter
    private Integer expires_in;
    @Getter
    private Integer refresh_token_expires_in;
}
