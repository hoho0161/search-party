package com.ApexParty.searchparty.domain.boards;


import com.ApexParty.searchparty.domain.BaseTimeEntity;
import com.ApexParty.searchparty.domain.users.Users;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;


@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Users users;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String cType;

    @Column(nullable = false)
    private String cMike;

    @Column(nullable = false)
    private String cTier;


    @Builder
    public Posts(String title,Users users, String contents, String cType, String cMike, String cTier) {
        this.title = title;
        this.users = users;
        this.contents = contents;
        this.cType = cType;
        this.cMike = cMike;
        this.cTier = cTier;
    }

    public void update(String title,String contents, String cType, String cMike, String cTier) {
        this.title = title;
        this.contents = contents;
        this.cType = cType;
        this.cMike = cMike;
        this.cTier = cTier;
    }
}
