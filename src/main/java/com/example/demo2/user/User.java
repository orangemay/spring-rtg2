package com.example.demo2.user;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import com.example.demo2.div.Div;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name= "users")
public class User {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="mail")
    private String mail;

    @Column(name="picture")
    private String picture;  // 画像ファイルのパス

    @Column(name="storage_file_name")
    private String storageFileName;

    @Column(name="joined_at")
    private LocalDateTime joinedAt;

    @ManyToOne
    @JoinColumn(name = "belong_to")
    private Div div;
}