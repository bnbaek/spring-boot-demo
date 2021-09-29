package net.openu.apidemoservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

public class PointDto {

    @ToString
    @Getter
    public static class AddReq {

        private String userId;
        private String reason;
        private Long amount;

        public AddReq(String userId, String reason, Long amount) {
            this.userId = userId;
            this.reason = reason;
            this.amount = amount;
        }
    }

}
