package com.example.springApp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActivityUsersCounterRepo extends JpaRepository<ActivityUsersCounter, Long> {

    @Query( value = "SELECT a.id, a.activityname, c.categoryname, count(ua.activity_id) as usersCounter\n" +
            "FROM actvt a left join user_activity ua on a.id = ua.activity_id\n" +
            "inner join ctgr c on a.category_id = c.id\n" +
            "group by a.id\n" +
            "order by ?1 ?2",
            nativeQuery = true)
    List<ActivityUsersCounter> CountActivityUsersAndOrderBy(String orderField, String orderDirection);

}
