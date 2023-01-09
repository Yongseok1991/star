package com.erp.star.com.user;

import com.erp.star.com.upload.KwareFile;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Table(name= "kware_user")
@Entity
@NoArgsConstructor
@ToString
public class KwareUser {

    @Builder
    public KwareUser(Long id, String userId, String passWd, String userNm, String telNo, String email, String approveAt) {
        this.id = id;
        this.userId = userId;
        this.passWd = passWd;
        this.userNm = userNm;
        this.telNo = telNo;
        this.email = email;
        this.approveAt = approveAt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 25)
    private String userId;
    @Column(nullable = false, length = 30)
    private String passWd;
    @Column(nullable = false, length = 10)
    private String userNm;

    @Column(nullable = false, length = 11)
    private String telNo;
    @Column(nullable = false, length = 100)
    private String email;
    @ColumnDefault("'N'")
    private String approveAt;

    @CreationTimestamp
    private Timestamp regDt;
    @CreationTimestamp
    private Timestamp updtDt;

    public KwareUser toEntity() {
        KwareUser build = KwareUser.builder()
                .userId(userId)
                .passWd(passWd)
                .telNo(telNo)
                .email(email)
                .approveAt(approveAt)
                .build();
        return build;
    }
}
