package com.ApexParty.searchparty.domain.boards;


import com.ApexParty.searchparty.domain.users.Users;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;


@Getter
@NoArgsConstructor
@Entity
public class Boards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="users_id")
    private Users users;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private int cType;

    @Column(nullable = false)
    private int cMike;

    @Column(nullable = false)
    private int cTier;

    @ColumnDefault("0")
    private int cDmg;

    @Builder
    Boards(Users users, String title,String contents, int cType, int cMike, int cTier, int cDmg) {
        this.users = users;
        this.title = title;
        this.contents = contents;
        this.cType = cType;
        this.cMike = cMike;
        this.cTier = cTier;
        this.cDmg = cDmg;
    }

    public void update(String title,String contents, int cType, int cMike, int cTier, int cDmg ) {
        this.title = title;
        this.contents = contents;
        this.cType = cType;
        this.cMike = cMike;
        this.cTier = cTier;
        this.cDmg = cDmg;

    }

}