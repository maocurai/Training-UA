package com.example.springApp.repos;

import com.example.springApp.domain.Activity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityUsersCounterRepo extends JpaRepository<Activity, Long> {

    @Query( value = "SELECT \n" +
            "a.id AS activityId,\n" +
            "a.activityname AS activityName,\n" +
            "c.categoryname AS categoryName,\n" +
            "COUNT(ca.activity_id) as countUsers\n" +
            "FROM actvt AS a\n" +
            "LEFT JOIN (\n" +
            "    SELECT activity_id\n" +
            "    FROM user_activity AS ua\n" +
            "    WHERE ua.status = \"CONFIRMED\"\n" +
            ") AS ca ON ca.activity_id = a.id\n" +
            "LEFT JOIN ctgr AS c ON c.id = a.category_id\n" +
            "GROUP BY a.id\n"
//            "ORDER BY \n" +
//                        "CASE WHEN :sortField = 'activityName' THEN activityName\n" +
//                            "WHEN :sortField = 'categoryName' THEN categoryName\n" +
//                            "WHEN :sortField = 'countUsers' THEN COUNT(ca.activity_id) END"
            , countQuery = "SELECT COUNT(*) FROM actvt;"
                            ,nativeQuery = true)
    Page<ActivityUsersCounter> countActivityUsers(Pageable pageable);

    @Query( value = "SELECT \n" +
            "a.id AS activityId,\n" +
            "a.activityname AS activityName,\n" +
            "c.categoryname AS categoryName,\n" +
            "COUNT(ca.activity_id) as countUsers\n" +
            "FROM actvt AS a\n" +
            "LEFT JOIN (\n" +
            "    SELECT activity_id\n" +
            "    FROM user_activity AS ua\n" +
            "    WHERE ua.status = 'CONFIRMED'\n" +
            ") AS ca ON ca.activity_id = a.id\n" +
            "LEFT JOIN ctgr AS c ON c.id = a.category_id\n" +
            "WHERE categoryName = :categoryName\n" +
            "GROUP BY a.id\n",
            countQuery = "SELECT COUNT(*) FROM actvt WHERE category_id = (SELECT id FROM ctgr WHERE categoryName = :categoryName)",
            nativeQuery = true)
    Page<ActivityUsersCounter> countActivityUsersByCategoryName(@Param("categoryName")String categoryName, Pageable pageable);

    @Query( value = "SELECT \n" +
            "a.id AS activityId,\n" +
            "a.activityname AS activityName,\n" +
            "c.categoryname AS categoryName,\n" +
            "COUNT(ca.activity_id) as countUsers\n" +
            "FROM actvt AS a\n" +
            "LEFT JOIN (\n" +
            "    SELECT activity_id\n" +
            "    FROM user_activity AS ua\n" +
            "    WHERE ua.status = 'CONFIRMED'\n" +
            ") AS ca ON ca.activity_id = a.id\n" +
            "LEFT JOIN ctgr AS c ON c.id = a.category_id\n" +
            "WHERE categoryName IS NULL\n" +
            "GROUP BY a.id\n",
            countQuery = "SELECT COUNT(*) FROM actvt WHERE category_id IS NULL",
            nativeQuery = true)
    Page<ActivityUsersCounter> countActivityUsersWhereCategoryIsNull(Pageable pageable);
}