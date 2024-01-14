package com.ApexParty.searchparty.domain.comments;

import com.ApexParty.searchparty.domain.BaseTimeEntity;
import com.ApexParty.searchparty.domain.boards.Posts;
import com.ApexParty.searchparty.domain.users.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@Entity
public class Comments extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "posts_id")
    private Posts posts;

    @Column
    private String comment;

    public Comments(Users users,Posts posts,String comment) {
        this.users = users;
        this.posts = posts;
        this.comment = comment;
    }

}
