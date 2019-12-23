package com.shengxi.carblog.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author yan
 * @version 1.1.0
 * @date 2019-11-13 23:33:40
 * 照片类
 */
@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "draw")
public class Draw implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "status")
    private String status;

    @Column(name = "content_url")
    private String contentUrl;

    @Column(name = "reviewer")
    private Integer reviewer;

    @Column(name = "upload_time")
    private LocalDateTime uploadTime;

    @Column(name = "title")
    private String title;

    public Draw(String contentUrl, LocalDateTime uploadTime, String title) {
        this.contentUrl = contentUrl;
        this.uploadTime = uploadTime;
        this.title = title;
    }
}
