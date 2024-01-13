package com.ApexParty.searchparty.domain.boards;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Integer> {

    @Query(value = "SELECT p FROM Boards p ORDER BY p.id DESC", nativeQuery = true)
    List<Posts> findAllDesc();
}
