package ru.netology.data;

import lombok.Value;


public class DataHelper {


    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCode() {
        return new VerificationCode("12345");
    }


    @Value
    public static class TransferCardInfo {
        private String numberIdCard;
        private String numberCard;
        private String numberMask;
        private int startBalance;

}
    public static TransferCardInfo getOneTransferCard () {
        return new TransferCardInfo("92df3f1c-a033-48e6-8390-206f6b1f56c0", "5559 0000 0000 0001", "**** **** **** 0001", 10_000);
    }

    public static TransferCardInfo getTwoTransferCard() {
        return new TransferCardInfo("0f3f5c2a-249e-4c3d-8287-09f7a039391d", "5559 0000 0000 0002", "**** **** **** 0002", 10_000);

    }
}

