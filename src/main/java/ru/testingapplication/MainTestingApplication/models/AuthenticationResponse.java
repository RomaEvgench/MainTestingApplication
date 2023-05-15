package ru.testingapplication.MainTestingApplication.models;

public class AuthenticationResponse {
    private final String accessToken;
    private final String refreshToken;

    public AuthenticationResponse(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    // стандартные геттеры
    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
}
