package com.example.springApp.repos;

import com.example.springApp.domain.Activity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityUsersCounterRepo extends JpaRepository<Activity, Long> {

    @Query( value = "SELECT " +
            "a.id AS activityId,\n" +
            "\t     a.activityname AS activityName,\n" +
            "       c.categoryname AS categoryName,\n" +
            "       COUNT(ua.activity_id) as countUsers\n" +
            "FROM actvt AS a\n" +
            "LEFT JOIN user_activity AS ua ON ua.activity_id = a.id\n" +
            "LEFT JOIN ctgr AS c ON c.id = a.category_id\n" +
//            "WHERE ua.status = 'CONFIRMED' OR ua.activity_id IS NULL\n" +
            "GROUP BY a.id  \n" +
            "ORDER BY " +
                        "CASE WHEN :sortField = 'activityName' THEN activityName\n" +
                            "WHEN :sortField = 'categoryName' THEN categoryName\n" +
                            "WHEN :sortField = 'countUsers' THEN COUNT(ua.activity_id) END",
            nativeQuery = true)
    List<ActivityUsersCounter> countActivityUsersAndOrderBy(@Param("sortField")String sortField);

    @Query( value = "SELECT " +
            "a.id AS activityId,\n" +
            "\t     a.activityname AS activityName,\n" +
            "       c.categoryname AS categoryName,\n" +
            "       COUNT(ua.activity_id) as countUsers\n" +
            "FROM actvt AS a\n" +
            "LEFT JOIN user_activity AS ua ON ua.activity_id = a.id\n" +
            "LEFT JOIN ctgr AS c ON c.id = a.category_id\n" +
            "WHERE categoryName = :categoryName\n" +
            "GROUP BY a.id  \n" +
            "ORDER BY categoryName ASC",
            nativeQuery = true)
    List<ActivityUsersCounter> countActivityUsersByCategoryName(@Param("categoryName")String categoryName);

    @Query( value = "SELECT " +
            "a.id AS activityId,\n" +
            "       a.activityname AS activityName,\n" +
            "       c.categoryname AS categoryName,\n" +
            "       COUNT(ua.activity_id) as countUsers\n" +
            "FROM actvt AS a\n" +
            "LEFT JOIN user_activity AS ua ON ua.activity_id = a.id\n" +
            "LEFT JOIN ctgr AS c ON c.id = a.category_id\n" +
            "WHERE c.categoryname IS NULL\n" +
            "GROUP BY a.id  \n" +
            "ORDER BY categoryName ASC",
            nativeQuery = true)
    List<ActivityUsersCounter> countActivityUsersWhereCategoryIsNull();
}