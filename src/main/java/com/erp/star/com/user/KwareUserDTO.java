package com.erp.star.com.user;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@ToString
public class KwareUserDTO {

    @Builder
    KwareUserDTO(Long id, String userId, String passWd, String userNm, String telNo, String email, String approveAt) {
        this.id = id;
        this.userId = userId;
        this.passWd = passWd;
        this.userNm = userNm;
        this.telNo = telNo;
        this.email = email;
        this.approveAt = approveAt;
    }
    private Long id;
    private String userId;
    private String passWd;
    private String userNm;
    private String telNo;
    private String email;
    private String approveAt;
    private Timestamp regDt;
    private Timestamp updtDt;

    public KwareUser toEntity() {
        KwareUser build = KwareUser.builder()
                .id(id)
                .userId(userId)
                .passWd(passWd)
                .telNo(telNo)
                .email(email)
                .approveAt(approveAt)
                .build();
        return build;
    }
}
